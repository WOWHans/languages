package me.nithans.java.basis.volatilekey;

public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;


    public void write() {
        flag = true;
        a = 1;
    }

    public void read() {
        // 当遇到volatile变量后，会把该线程对应的本地内存置为无效（即读到 flag 这个volatile变量），
        // 该线程会去从主内存中读取共享变量，
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }

}
