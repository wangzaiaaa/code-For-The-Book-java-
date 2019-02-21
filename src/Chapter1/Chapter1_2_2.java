package Chapter1;

/**
 * Thread类提供了三种join()方法，允许调用该方法的线程等待执行该方法线程
 * void join() 无期限的等待线程死亡
 * void join(long millis) 线程死亡前最多等待millis毫秒
 * void join(long millis,int nanos)
 */

public class Chapter1_2_2 {
    public static void main(String [] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true){
                    double n = Math.random();
                    if(n>0.49999&&n<0.50001){
                        System.out.println("thread1");
                        break;
                    }
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        try {
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main thread");


    }
}
