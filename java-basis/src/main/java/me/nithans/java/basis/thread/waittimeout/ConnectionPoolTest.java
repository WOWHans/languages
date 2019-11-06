package me.nithans.java.basis.thread.waittimeout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 有待调试,程序跑不出来，需要去稳固下synchronized的用法加深了解
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        synchronized (end) {
            end.wait();
        }
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: "+ got);
        System.out.println("not got connection "+ notGot);
        System.out.println("end "+ end.getCount());
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (count > 0) {
                    try {
                        Connection connection = pool.fetchConnection(10000);
                        if (connection != null) {
                            try {
                                connection.createStatement();
                                connection.commit();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                pool.releaseConnection(connection);
                                got.incrementAndGet();
                            }
                        } else {
                            notGot.incrementAndGet();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        count--;
                    }
                }
                end.countDown();
            }
        }

    }
}






































