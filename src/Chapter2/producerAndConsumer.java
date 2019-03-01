package Chapter2;

import java.util.ArrayDeque;
import java.util.Queue;

class MyBlockingQueue<E>{
    private Queue<E> queue = null;
    private int limit;
    public MyBlockingQueue(int limit){
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }
    //生产 synchronized表示互斥锁 用limit来同步
    public synchronized void put(E e)throws InterruptedException{
        //生产队列已满 线程等待
        while(queue.size()==limit){
            wait();
        }
        queue.add(e);
        //唤醒因为生产队列空而等待的线程
        notifyAll();
    }
    //消费 synchronized表示互斥锁 用是否为空来同步
    public synchronized E take() throws InterruptedException{
        //生产队列为空 线程等待
        while (queue.isEmpty()){
            wait();
        }
        E e = queue.poll();
        //唤醒因为生产队列满而等待的线程
        notifyAll();
        return e;
    }
}
//生产者
class Producer extends Thread{
    MyBlockingQueue<String> queue;
    public Producer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }
    public void run(){
        int num = 0;
        try{
            while(true){
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("produce task "+ task);
                num++;
                Thread.sleep((int)(Math.random()*100));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
//消费者
class Consumer extends Thread{
    MyBlockingQueue<String> queue;
    public Consumer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }
    public void run(){
        try{
            while(true){
                String task = queue.take();
                System.out.println("handle task "+ task);
                Thread.sleep((int)(Math.random()*100));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class producerAndConsumer {
    public static void main(String [] args){
        MyBlockingQueue<String> blockingQueue = new MyBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        producer.start();
        consumer.start();
    }
}
