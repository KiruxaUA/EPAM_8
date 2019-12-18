package ua.epam7.FizzBuzzMultithreaded;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private int bound;
    private static FizzBuzz fizzBuzz;
    public static String output;

    public FizzBuzz() throws InterruptedException {
        fizzSem.acquire();
        buzzSem.acquire();
        fizzBuzzSem.acquire();
        FizzBuzz.output = "";
    }

    private AtomicInteger currentNumber = new AtomicInteger(1);
    private Semaphore fizzSem = new Semaphore(1);
    private Semaphore buzzSem = new Semaphore(1);
    private Semaphore fizzBuzzSem = new Semaphore(1);
    private Semaphore numSem = new Semaphore(1);

    public static synchronized FizzBuzz getObject() throws InterruptedException {
        if (fizzBuzz == null) {
            fizzBuzz = new FizzBuzz();
        }
        return fizzBuzz;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public void fizz() throws InterruptedException {
        while (currentNumber.get() <= bound) {
            fizzSem.acquire();
            if (currentNumber.get() > bound) return;
            FizzBuzz.output += "fizz ";
            System.out.println("fizz ");
            currentNumber.incrementAndGet();
            release();
        }
        releaseAll();
    }

    public void buzz() throws InterruptedException {
        while (currentNumber.get() <= bound) {
            buzzSem.acquire();
            if (currentNumber.get() > bound) return;
            FizzBuzz.output += "buzz ";
            System.out.println("buzz ");
            currentNumber.incrementAndGet();
            release();
        }
        releaseAll();
    }

    public void fizzbuzz() throws InterruptedException {
        while (currentNumber.get() <= bound) {
            fizzBuzzSem.acquire();
            if (currentNumber.get() > bound) return;
            FizzBuzz.output += "fizzbuzz ";
            System.out.println("fizzbuzz ");
            currentNumber.incrementAndGet();
            release();
        }
        releaseAll();
    }

    public void number() throws InterruptedException {
        while (currentNumber.get() <= bound) {
            numSem.acquire();
            if (currentNumber.get() > bound) return;
            FizzBuzz.output += currentNumber + " ";
            System.out.println(currentNumber + " ");
            currentNumber.incrementAndGet();
            release();
        }
        releaseAll();
    }

    private void release() {
        if (currentNumber.get() % 3 == 0 && currentNumber.get() % 5 == 0) {
            fizzBuzzSem.release();
        } else if (currentNumber.get() % 3 == 0) {
            fizzSem.release();
        } else if (currentNumber.get() % 5 == 0) {
            buzzSem.release();
        } else {
            numSem.release();
        }
    }

    private void releaseAll() {
        fizzBuzzSem.release();
        fizzSem.release();
        buzzSem.release();
        numSem.release();
    }
}
