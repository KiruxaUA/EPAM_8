package ua.epam7.FizzBuzzMultithreaded;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzMultithreadedTest {
    private FizzBuzz fizzBuzz;
    private FizzBuzzThread threadFizz;
    private FizzBuzzThread threadBuzz;
    private FizzBuzzThread threadFizzBuzz;
    private FizzBuzzThread threadNumber;
    private int bound = 15;
    private String expectedOutput = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz ";

    @Test
    public void checkOutput() throws InterruptedException {
        fizzBuzz = FizzBuzz.getObject();
        fizzBuzz.setBound(bound);
        threadFizz = new FizzBuzzThread(fizzBuzz, "fizz");
        threadBuzz = new FizzBuzzThread(fizzBuzz, "buzz");
        threadFizzBuzz = new FizzBuzzThread(fizzBuzz, "fizzbuzz");
        threadNumber = new FizzBuzzThread(fizzBuzz, "number");
        threadBuzz.start();
        threadFizz.start();
        threadFizzBuzz.start();
        threadNumber.start();
        try {
            threadBuzz.join();
            threadFizz.join();
            threadFizzBuzz.join();
            threadNumber.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        assertEquals(expectedOutput, FizzBuzz.output);
    }
}
