package me.nithans.java.basis.thread;

import java.util.concurrent.TimeUnit;
import me.nithans.java.basis.utils.SleepUtils;

public class InterruptedThread {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(() -> {
            while (true) {
                SleepUtils.second(10);
            }
        });
        sleepThread.setDaemon(true);
        sleepThread.start();
        Thread busyThread = new Thread(() -> {
            while (true) {

            }
        });
        busyThread.setDaemon(true);
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

}
