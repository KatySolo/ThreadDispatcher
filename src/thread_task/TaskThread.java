package thread_task;

import tasks.ThreadMonitor;
import tasks.ThreadedTask;


public class TaskThread extends Thread {


    public static ThreadMonitor monitor;
    public ThreadedTask task;
    private Callback callback;

    public TaskThread(ThreadedTask task) {
        this.task = task;
        if (!task.toString().startsWith("tasks.ThreadMonitor")) {
            callback = new Callback();
        } else {
            monitor = (ThreadMonitor) task;
        }
    }

    @Override
    public void run() {
        task.run();
        if (callback != null) {
            callback.callback(task);
        }
    }
}
