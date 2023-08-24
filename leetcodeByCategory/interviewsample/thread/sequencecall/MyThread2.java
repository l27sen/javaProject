package leetcodeByCategory.interviewsample.thread.sequencecall;

public class MyThread2 implements Runnable{
    private String method;
    private Foo foo;

    public MyThread2(Foo foo, String method) {
        this.method = method;
        this.foo = foo;
    }

    public void run() {
        if (method == "first") {
            foo.first();
        } else if (method == "second") {
            foo.second();
        } else if (method == "third") {
            foo.third();
        }
    }
}
