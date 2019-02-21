package Chapter1;
//获取和设置线程的优先级
//int getPriority() 返回线程的优先级
//void setPriority() 设置线程的优先级 传递的值应该处于
// Thread.MIN_PRIORITY和Thread.MAX_PRIORITY之间，Thread.NORMAL_PRIORITY则规定默认的优先级
public class Chapter1_1_4 {
    public static void main(String [] args){
        myThread t = new myThread();
        System.out.println(t.getPriority());
        t.setPriority(Thread.NORM_PRIORITY);

    }
}
