package ua.epam7.FizzBuzzMultithreaded;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = FizzBuzz.getObject();
        fizzBuzz.setBound(15);
        FizzBuzzThread threadFizz = new FizzBuzzThread(fizzBuzz, "fizz");
        FizzBuzzThread threadBuzz = new FizzBuzzThread(fizzBuzz, "buzz");
        FizzBuzzThread threadFizzBuzz = new FizzBuzzThread(fizzBuzz, "fizzbuzz");
        FizzBuzzThread threadNumber = new FizzBuzzThread(fizzBuzz, "number");
        threadBuzz.start();
        threadFizz.start();
        threadFizzBuzz.start();
        threadNumber.start();
    }
}
