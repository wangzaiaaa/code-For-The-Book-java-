package Chapter1;

/**
 * java线程分为守护线程和非守护线程，通过isDaemon()来判断一个线程是否守护线程
 * 如果向创建一个守护线程，可以调用setDaemon(true) 来设置
 */

public class Chapter1_1_5 {
    public static void main(String [] args){
        myThread t1 = new myThread();
        System.out.println(t1.isDaemon());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());

    }
}
