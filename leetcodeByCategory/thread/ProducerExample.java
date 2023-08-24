package leetcodeByCategory.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerExample {

  private Lock lock = new ReentrantLock();

  private Condition notFull = lock.newCondition();
  private Condition notEmpty = lock.newCondition();

  private List list = new ArrayList();

  public void put(Object obj) throws Exception {
    lock.lock();
    try {

      //full
      if (list.size() == 22) {
        notFull.await();
      }
      list.add(obj);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public void consume(Object object) throws Exception {
    lock.lock();
    try {

      //full
      while (list.isEmpty()) {
        notEmpty.await();
      }
      list.remove(object);
      notFull.signalAll();

    } finally {
      lock.unlock();
    }
  }

}
