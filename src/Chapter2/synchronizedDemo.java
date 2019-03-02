package Chapter2;
class counter{
    private int sum;
    public counter(int num){
        this.sum = num;
    }
    public synchronized void increase(){
        this.sum++;
    }
    public synchronized int get(){
        return this.sum;
    }
}
class myThread extends Thread{
    private counter counter;
    public myThread(counter counter){
        this.counter = counter;
    }
    public void run(){
        for(int i=0;i<1000;i++){
            counter.increase();
        }
    }
}
public class synchronizedDemo {
    public static void main(String [] args)throws InterruptedException{
        long start = System.currentTimeMillis();
        counter mycounter = new counter(0);
        myThread[] myThreads = new myThread[1000];
        for(int i=0;i<1000;i++){
            myThreads[i] = new myThread(mycounter);
            myThreads[i].start();
            myThreads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println(mycounter.get());
        System.out.println("cost time "+(end-start));
    }
}
