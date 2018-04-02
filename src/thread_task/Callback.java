package thread_task;

import dispatcher.ThreadDispatcher;
import tasks.ThreadedTask;

import java.util.Observable;

public class Callback extends Observable {

    private TaskThread finishedThread;

    public void callback(ThreadedTask task) {
        addObserver(TaskThread.monitor);
        setChanged();
        synchronized (ThreadDispatcher.allTasks) {
            for (TaskThread t : ThreadDispatcher.allTasks) {
                if (t.task.toString().equals(task.toString())) {
                    finishedThread = t;
                    break;
                }
            }
            ThreadDispatcher.allTasks.remove(finishedThread);
        }
        notifyObservers(finishedThread);
    }
}
