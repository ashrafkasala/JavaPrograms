package MultiThreading;

import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String... args){
        ProdCons pc =new ProdCons();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }
                catch (InterruptedException e){}
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                }
                catch (InterruptedException e){}
            }

        });
        t1.start();
        t2.start();
    }
}


class ProdCons{

    LinkedList<Integer> list = new LinkedList<>();
    int capacity=5;
    int value=0;
    void  produce() throws InterruptedException{
        while (true) {
        synchronized (this) {

                while (list.size() == capacity)
                    wait();
                list.add(value);
                System.out.println("Producer produced " + value);
                value++;
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {

                while (list.size() == 0)
                    wait();
                System.out.println("Consumer consumed " + list.removeFirst());
                notify();
                value--;
                Thread.sleep(1000);

            }
        }
    }
}
