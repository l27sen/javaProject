package com.scotiabank.riskmanagement.testcdoe.other;
import java.util.*;
import java.util.concurrent.*;
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();

//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);

        new WriteThread("Writer1", list).start();
        new WriteThread("Writer2", list).start();
        new WriteThread("Writer3", list).start();
        new WriteThread("Writer4", list).start();
        new WriteThread("Writer5", list).start();
        new WriteThread("Writer6", list).start();

        new ReadThread("Reader", list).start();

    }
}


class WriteThread extends Thread {

    private List<Integer> list;

    public WriteThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    public void run()  {
        int count = 6;

        while (true) {

            try {

                Thread.sleep(50);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if(list.size() == 1){
                list.set(0, 1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                list.add(count++);


            }else if(list.size() == 2){
                list.set(0, 1);
                list.set(0, 2);

            }
            else {
                if(list.size()<2){
                    list.add(count++);

                }
            }


            System.out.println(super.getName() + " done");
        }
    }
}


class ReadThread extends Thread {
    private List<Integer> list;

    public ReadThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    public void run() {

        while (true) {

            String output = "\n" + super.getName() + ":";

            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                output += " " + next;

                // fake processing time
                try {

                    Thread.sleep(10);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(output);
        }
    }
}
