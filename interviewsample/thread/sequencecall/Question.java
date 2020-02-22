package interviewsample.thread.sequencecall;

public class Question {
    public static void main(String[] args) {
        FooBad foo = new FooBad();

        MyThread thread1 = new MyThread(foo, "first");
        MyThread thread2 = new MyThread(foo, "second");
        MyThread thread3 = new MyThread(foo, "third");

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
