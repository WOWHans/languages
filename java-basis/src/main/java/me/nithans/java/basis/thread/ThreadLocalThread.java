package me.nithans.java.basis.thread;

import java.util.concurrent.TimeUnit;

public class ThreadLocalThread {
    // ThreadLocal 线程变量


    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>();

    static {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + end() + " ms");
    }

}
