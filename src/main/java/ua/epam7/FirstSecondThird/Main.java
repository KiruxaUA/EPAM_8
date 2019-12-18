package ua.epam7.FirstSecondThird;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        int[] orderOfThreads = {2, 1, 3};
        FooThread thread1 = new FooThread(foo, orderOfThreads[0]);
        FooThread thread2 = new FooThread(foo, orderOfThreads[1]);
        FooThread thread3 = new FooThread(foo, orderOfThreads[2]);
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
