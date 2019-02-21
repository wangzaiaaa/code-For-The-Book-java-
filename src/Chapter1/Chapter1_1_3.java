package Chapter1;
/*
获取一条线程的执行状态
线程的执行的状态用Thread.state枚举常量标识
NEW 该线程还没有开始
RUNNABLE 该线程正在jvm中执行
BLOCKED 该线程被阻塞并等待一个监听锁
WAITTING 该线程无期限的等待另外一条线程执行特定的操作
TIMED_WAITTING 该线程有期限的等待另外一条线程执行特定的操作
TERMINATED 该状态下线程已推出
通过Thread state getState()可以得到线程的执行的状态
 */

public class Chapter1_1_3 {
    public static void main(String [] args){
        myThread t1 = new myThread();
        System.out.print(t1.getState());
    }
}
