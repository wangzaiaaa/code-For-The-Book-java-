package Chapter1;

/**
 * Thread类声明了一对静态方法时线程休眠
 * void(long millis) 睡眠millis毫秒
 * void(long millis,int nanos) 睡眠millis毫秒和nanos纳秒
 */
public class Chapter1_2_3 {
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
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        A.interrupt();
        B.interrupt();

    }
}
