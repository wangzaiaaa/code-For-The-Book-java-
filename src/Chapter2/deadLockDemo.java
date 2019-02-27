package Chapter2;

public class deadLockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    public void instanceMethod1(){
        synchronized (lock1){
            synchronized (lock2){
                System.out.println("instanceMethod1 in Thread1");
            }
        }
    }
    public void instanceMethod2(){
        synchronized (lock2){
            synchronized (lock1){
                System.out.println("instanceMethod2 in Thread2");
            }
        }
    }
    public static void main(String [] args){
        final deadLockDemo dld = new deadLockDemo();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                dld.instanceMethod1();
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread T1 = new Thread(r1);
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                dld.instanceMethod2();
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread T2 = new Thread(r2);
        T1.start();
        T2.start();
    }
}
