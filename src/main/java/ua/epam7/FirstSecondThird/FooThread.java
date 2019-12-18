package ua.epam7.FirstSecondThird;

public class FooThread extends Thread {
    private Foo foo;
    private int order;

    public FooThread(Foo foo, int method) {
        this.order = method;
        this.foo = foo;
    }

    public void run() {
        switch(order) {
            case 1:
                foo.first();
                break;
            case 2:
                foo.second();
                break;
            case 3:
                foo.third();
                break;
        }
    }
}
