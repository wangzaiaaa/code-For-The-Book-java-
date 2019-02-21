package Chapter1;
// 获取和设置线程的状态
public class Chapter1_1_2 {
    public static void main(String [] args){
        //获取和设置线程的名称
        Runnable r = () -> System.out.println("it's a test");
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r,"Thread2");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.setName("Thread1");
        System.out.println(t1.getName());
        //获取一条线程的存活状态
        System.out.println(t1.isAlive());

    }
}
