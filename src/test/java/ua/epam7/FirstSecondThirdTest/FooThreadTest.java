package ua.epam7.FirstSecondThirdTest;

import org.junit.Test;
import ua.epam7.FirstSecondThird.Foo;
import ua.epam7.FirstSecondThird.FooThread;

import static org.junit.Assert.*;

public class FooThreadTest {
    private int[] orderOfThreads1 = {1, 2, 3};
    private int[] orderOfThreads2 = {2, 3, 1};
    private int[] orderOfThreads3 = {2, 1, 3};
    private String expectedOutput = "firstsecondthird";
    private Foo foo = new Foo();

    @Test
    public void checkOutput1() {
        FooThread fooThreadOne = new FooThread(foo, orderOfThreads1[0]);
        FooThread fooThreadTwo = new FooThread(foo, orderOfThreads1[1]);
        FooThread fooThreadThree = new FooThread(foo, orderOfThreads1[2]);
        fooThreadOne.start();
        fooThreadTwo.start();
        fooThreadThree.start();
        try {
            fooThreadThree.join();
            fooThreadOne.join();
            fooThreadTwo.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        assertEquals(expectedOutput, Foo.output);
    }

    @Test
    public void checkOutput2() {
        FooThread fooThreadOne = new FooThread(foo, orderOfThreads2[0]);
        FooThread fooThreadTwo = new FooThread(foo, orderOfThreads2[1]);
        FooThread fooThreadThree = new FooThread(foo, orderOfThreads2[2]);
        fooThreadOne.start();
        fooThreadTwo.start();
        fooThreadThree.start();
        try {
            fooThreadThree.join();
            fooThreadOne.join();
            fooThreadTwo.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        assertEquals(expectedOutput, Foo.output);
    }

    @Test
    public void checkOutput3() {
        FooThread fooThreadOne = new FooThread(foo, orderOfThreads3[0]);
        FooThread fooThreadTwo = new FooThread(foo, orderOfThreads3[1]);
        FooThread fooThreadThree = new FooThread(foo, orderOfThreads3[2]);
        fooThreadOne.start();
        fooThreadTwo.start();
        fooThreadThree.start();
        try {
            fooThreadThree.join();
            fooThreadOne.join();
            fooThreadTwo.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        assertEquals(expectedOutput, Foo.output);
    }
}
