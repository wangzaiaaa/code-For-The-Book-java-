package Chapter1;

/**
 * 中断线程
 * 可以调用void interrupt()来中断线程，当一个线程调用了Thread的sleep()或者join()方法时，该线程
 * 的阻塞状态就会被清除，同时会产生InterruptedException异常
 * static boolean interrupted() 验证该线程是否已经中断，该线程的中断状态会被这个方法清除掉
 * boolean isInterrupted() 验证该线程是否已经中断，不会影响到该线程的中断状态
 */
public class Chapter1_2_1 {
    public static void main(String [] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                Thread t = Thread.currentThread();
                int count = 0;
                while(!t.isInterrupted()){
                    System.out.println(name+":"+ count++);
                }
            }
        };
        Thread A = new Thread(r);
        Thread B = new Thread(r);
        A.start();
        B.start();
        while (true){
            double n = Math.random();
            if(n>=0.499999&&n<=0.500001)
                break;
        }
        A.interrupt();
        B.interrupt();

    }
}
