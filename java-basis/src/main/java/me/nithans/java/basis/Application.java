package me.nithans.java.basis;

import java.util.ServiceLoader;
import me.nithans.java.basis.spi.IMyServiceLoader;

public class Application {

    public static void main(String[] args) {
        ServiceLoader<IMyServiceLoader> spi = ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader myServiceLoader : spi) {
            myServiceLoader.test();
        }
    }
}
