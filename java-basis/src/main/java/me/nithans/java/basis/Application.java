package me.nithans.java.basis;

import java.util.Iterator;
import java.util.ServiceLoader;
import me.nithans.java.basis.spi.IMyServiceLoader;

public class Application {

    public static void main(String[] args) {
        ServiceLoader<IMyServiceLoader> spi = ServiceLoader.load(IMyServiceLoader.class);
        Iterator<IMyServiceLoader> it = spi.iterator();
        while (it.hasNext()) {
            it.next().test();
        }
    }
}
