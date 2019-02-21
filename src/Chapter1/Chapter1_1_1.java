package Chapter1;

/**
 * 创建线程的2种方式
 */
public class Chapter1_1_1 {
    public static void main(String [] args){
        //method1 实现Runnable接口，实现run方法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("method1 to create a thread");
            }
        };
        Runnable r2 = () -> System.out.println("method1 to create a thread");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        myThread t3 = new myThread();
        t1.start();
        t2.start();
        t3.start();

    }
}
//method2 继承Thread类，重写run方法
class myThread extends Thread{
    @Override
    public void run(){
        System.out.println("method2 to create a thread");
    }
}
