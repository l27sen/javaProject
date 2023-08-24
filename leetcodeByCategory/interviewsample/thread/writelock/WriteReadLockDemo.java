package leetcodeByCategory.interviewsample.thread.writelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLockDemo<E> {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    private final List<E> list = new ArrayList<>();

    public void set(E o)
    {
        //write lock will block read function
        writeLock.lock();
        try
        {
            //
            System.out.println("write begin"+Thread.currentThread().getName());
            list.add(o);
            System.out.println("write end: "+Thread.currentThread().getName());
        }
        finally
        {
            writeLock.unlock();
        }
    }

    public E get(int i)
    {
        readLock.lock();
        try
        {
            System.out.println("Printing elements by thread"+Thread.currentThread().getName());
            if(!list.isEmpty()){
                System.out.println("get  end"+Thread.currentThread().getName());
                return list.get(i);

            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally
        {
            readLock.unlock();
        }
        System.out.println("get null"+ Thread.currentThread().getName());
        return null;
    }
    public static void main(String[] args) throws Exception
    {
        WriteReadLockDemo<String> threadSafeArrayList = new WriteReadLockDemo<>();

        for(int i=0;i<6;i++){
            new Thread(()->{
                threadSafeArrayList.set("L");
            },String.valueOf("thread"+i)).start();
        }

        for(int i=0;i<6;i++){
            new Thread(()->{
                threadSafeArrayList.get(0);
            },"thread "+i).start();
        }



    }
}
