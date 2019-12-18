package ua.epam7.FizzBuzzMultithreaded;

public class FizzBuzzThread extends Thread {
    private FizzBuzz fizzBuzz;
    private String name;

    public FizzBuzzThread(FizzBuzz fizzBuzz, String name) {
        this.fizzBuzz = fizzBuzz;
        this.name = name;
    }

    public void run() {
        if(name.equalsIgnoreCase("fizz")) {
            try {
                fizzBuzz.fizz();
            } catch(InterruptedException e) {
                e.getStackTrace();
            }
        }
        else if(name.equalsIgnoreCase("buzz")) {
            try {
                fizzBuzz.buzz();
            } catch(InterruptedException e) {
                e.getStackTrace();
            }
        }
        else if(name.equalsIgnoreCase("fizzbuzz")) {
            try {
                fizzBuzz.fizzbuzz();
            } catch(InterruptedException e) {
                e.getStackTrace();
            }
        } else {
            try {
                fizzBuzz.number();
            } catch(InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
