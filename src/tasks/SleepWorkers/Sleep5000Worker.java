package tasks.SleepWorkers;

import tasks.ThreadedTask;

public class Sleep5000Worker extends ThreadedTask {

    @Override
    public void run() {
        try {
//            System.out.println("Started 5000");
            Thread.sleep(5000);
//            System.out.println("Finished 5000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
