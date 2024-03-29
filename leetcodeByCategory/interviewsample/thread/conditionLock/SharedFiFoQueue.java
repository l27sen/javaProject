package leetcodeByCategory.interviewsample.thread.conditionLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//use array implement FIFO
public class SharedFiFoQueue {

    private Object[] elems = null;
    private int current = 0;
    private int placeIndex = 0;
    private int removeIndex = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    public SharedFiFoQueue(int capacity) {
        this.elems = new Object[capacity];
    }

    public void add(Object elem) throws InterruptedException {
        lock.lock();
        while(current >= elems.length)
            isFull.await();

        elems[placeIndex] = elem;

        //We need the modulo, in order to avoid going out of bounds.
        placeIndex = (placeIndex + 1) % elems.length;

        ++current;

        //Notify the consumer that there is data available.
        isEmpty.signal();

        lock.unlock();
    }

    public Object remove() throws InterruptedException {
        Object elem = null;

        lock.lock();
        while(current <= 0)
            isEmpty.await();

        //remove from 0,
        elem = elems[removeIndex];

        //We need the modulo, in order to avoid going out of bounds.
        //use %, the index will shift to zero
        removeIndex = (removeIndex + 1) % elems.length;

        --current;

        //Notify the producer that there is space available.
        isFull.signal();

        lock.unlock();

        return elem;
    }
}
