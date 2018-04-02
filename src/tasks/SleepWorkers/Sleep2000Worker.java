package tasks.SleepWorkers;

import tasks.ThreadedTask;

public class Sleep2000Worker extends ThreadedTask {
    @Override
    public void run() {
        try {
//            System.out.println("Started 2000");
            Thread.sleep(2000);
//            System.out.println("Finished 2000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
