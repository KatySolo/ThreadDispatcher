package tasks.SleepWorkers;

import tasks.ThreadedTask;

public class Sleep7000Worker extends ThreadedTask {
    @Override
    public void run() {
        try {
//            System.out.println("Started 7000");
            Thread.sleep(7000);
//            System.out.println("Finished 7000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
