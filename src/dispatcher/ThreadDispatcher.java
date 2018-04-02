package dispatcher;

import tasks.ThreadMonitor;
import tasks.ThreadedTask;
import thread_task.TaskThread;

import java.util.ArrayList;

public class ThreadDispatcher {

    public static final ArrayList<TaskThread> allTasks = new ArrayList<>();
    private static volatile ThreadDispatcher instance;

    private ThreadDispatcher() {
        Add(new ThreadMonitor());
        //То есть при создании диспетчера потоков по умолчанию сразу
        // же создается фоновый поток.
    }

    // создание синглтона
    public static ThreadDispatcher getInstance() {
        if (instance == null) {
            synchronized (ThreadDispatcher.class) {
                if (instance == null) {
                    instance = new ThreadDispatcher();
                }
            }
        }
        return instance;
    }

    // постаить задачу на поток
    //данный метод запускает на выполнение задачу
    public void Add(ThreadedTask task) {
        TaskThread a = new TaskThread(task);
        a.setName(task.toString());
        allTasks.add(a);
        a.start();

    }
}
