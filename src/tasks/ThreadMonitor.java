package tasks;

import dispatcher.ThreadDispatcher;
import thread_task.TaskThread;

import java.io.*;
import java.nio.file.Path;
import java.util.Observable;
import java.util.Observer;

public class ThreadMonitor extends ThreadedTask implements Observer {

    private File file;
    public ThreadMonitor () {
        file = new File("/Users/KatySolo/IdeaProjects/file_worker/src/output/output.txt");
    }
    // этот метод реализовает вывод в файл списка запущенных потоков и их идентификаторов
    @Override
    public void run() {
        synchronized (ThreadDispatcher.allTasks) {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                for (TaskThread t : ThreadDispatcher.allTasks) {
                    writer.write(t.getName().split("@")[0] + String.valueOf(' ') + String.valueOf(t.getId()) + String.valueOf('\n'));
                }

                writer.close();
            } catch (IOException a) {
                System.out.print("Problem occured");
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Got change in " + arg.toString());
        run();
    }
}
//tasks.ThreadMonitor - класс, реализующий функциональность монитора потоков. Необходимо с его помощью в методе
// run() реализовать вывод в файл списка запущенных потоков и их идентификаторов. Соотвественно, как только поток
// 		завершился, список монитора потоков должен обновиться, и данный поток должен исчезнуть. При запуске потока - поток
// 		должен добавиться в вывод. Подобное поведение можно наблюдать в диспетчере задач в Windows. Монитор потоков
// 			работает столько, сколько существует singleton tasks.ThreadedTask. Не может отключаться или ставиться на паузу. Монитор
// 		всегда показывает актуальное состояние диспетчера потоков.
//
//	ВАЖНО: необходимо реализовать именно отображение в реальном времени списка запущенных потоков, а не бесконечный
// 	вывод актуального состояния в файл.