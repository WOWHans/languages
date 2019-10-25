package me.nithans.java.basis.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ScheduledThread {
    private static final Logger LOGGER = Logger.getLogger("test");

    public static final ScheduledExecutorService scheduledExecutorService;

    static {
        /**
         *
         * @param corePoolSize     池中所保存的线程数，包括空闲线程
         *
         * @param maximumPoolSize  池中允许的最大线程数，默认
         * @see java.lang.Integer  #MAX_VALUE
         *
         * @param keepAliveTime    当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，默认为0
         * @param unit             时间单位
         * @param workQueue        执行前用于保持任务的队列。此队列仅保持由execute方法提交的Runnable任务
         * @param threadFactory    执行程序创建新线程时使用的工厂
         * @param handler          由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序
         */
        scheduledExecutorService = new ScheduledThreadPoolExecutor(2,
            new ThreadFactoryBuilder().setDaemon(true).setNameFormat("test-scheduled-thread-%d").build(),
            new DiscardPolicy());
    }

    public static void testScheduledTask() {
        scheduledExecutorService.scheduleAtFixedRate(() -> LOGGER.info("1"), 5, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        testScheduledTask();
        System.out.println(1);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
