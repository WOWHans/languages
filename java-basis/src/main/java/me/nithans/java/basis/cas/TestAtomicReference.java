package me.nithans.java.basis.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 还需要去了解 volatile 、 synchronized
 */
public class TestAtomicReference {

    public static void test() {
        String sourceStr = "test1";
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set(sourceStr);
        String targetStr = "test2";
        atomicReference.compareAndSet(sourceStr, targetStr);
        System.out.println(atomicReference.get());

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        User dingding = new User();
        dingding.setUserName("dingding");
        dingding.setSex("男");
        userAtomicReference.set(dingding);
        User huahua = new User();
        huahua.setUserName("huahua");
        huahua.setSex("女");
        boolean exchanged = userAtomicReference.compareAndSet(dingding, huahua);
        userAtomicReference.get().setUserName("huahua2");
        System.out.println(exchanged);
        System.out.println(userAtomicReference.get().getUserName());

    }

    public static void main(String[] args) {
        test();
    }

    static class User {
        private String userName;
        private String sex;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
