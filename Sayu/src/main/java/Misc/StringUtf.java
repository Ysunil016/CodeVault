package Misc;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class StringUtf {
    public static void main(String[] args) {
        utfString();
        wrapperClass();
    }

    private static void wrapperClass() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        Float wrapperFloat = new Float(500);

        System.out.println("Main :: " + atomicInteger + " && " + wrapperFloat);
        System.out.println();

        System.out.println("Starting Threads");
        for (int idx = 0; idx < 100; idx++)
            new Thread(() -> {
                System.out.println("Current Thread :: " + Thread.currentThread().getName() + " :: " + atomicInteger + " && " + wrapperFloat);
                // wrapperFloat = new Float(100);
                System.out.println("Atomic Inc -> " + atomicInteger.incrementAndGet());
            }).start();

    }

    private static void utfString() {
        String str = new String("\uD801\uDC00".getBytes(), StandardCharsets.UTF_8); // Holds 4 byte for > U+10000
        System.out.println("\u0001"); // Length became 2 for only 1 character.
        System.out.println(str.length()); // Length became 2 for only 1 character.
    }
}
