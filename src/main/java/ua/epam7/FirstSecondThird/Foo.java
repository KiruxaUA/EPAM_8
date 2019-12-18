package ua.epam7.FirstSecondThird;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore sem1;
    private Semaphore sem2;
    public static String output;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);
            sem1.acquire();
            sem2.acquire();
            Foo.output = "";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void first() {
        try {
            Foo.output += "first";
            System.out.print("first");
            sem1.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void second() {
        try {
            sem1.acquire();
            sem1.release();
            Foo.output += "second";
            System.out.print("second");
            sem2.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void third() {
        try {
            sem2.acquire();
            sem2.release();
            Foo.output += "third";
            System.out.println("third");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
