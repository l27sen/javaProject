package interviewsample.thread.sequencecall;

public class QuestionCorrect {
    public static void main(String[] args) {
        Foo foo = new Foo();

        MyThread2 thread1 = new MyThread2(foo, "first");
        MyThread2 thread2 = new MyThread2(foo, "second");
        MyThread2 thread3 = new MyThread2(foo, "third");

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
