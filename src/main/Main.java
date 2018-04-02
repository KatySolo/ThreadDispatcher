package main;

import dispatcher.ThreadDispatcher;
import tasks.SleepWorkers.Sleep2000Worker;
import tasks.SleepWorkers.Sleep5000Worker;
import tasks.SleepWorkers.Sleep7000Worker;

public class Main {
    public static void main(String[] args) {
        ThreadDispatcher threadDispatcher = ThreadDispatcher.getInstance();
        Sleep5000Worker task1 = new Sleep5000Worker();
        Sleep2000Worker task2 = new Sleep2000Worker();
        Sleep2000Worker task3 = new Sleep2000Worker();
        Sleep7000Worker task4 = new Sleep7000Worker();
        threadDispatcher.Add(task1);
        threadDispatcher.Add(task2);
        threadDispatcher.Add(task4);
        threadDispatcher.Add(task3);
    }
}
