package Chapter2;
class MyLatch{
    private int count;
    public MyLatch(int count){
        this.count = count;
    }
    public synchronized void await() throws InterruptedException{
        while(count>0){
            wait();
        }
    }
    public synchronized void cutDown(){
        count--;
        if(count<=0){
            notifyAll();
        }
    }
}
class Wroker extends Thread{
    MyLatch latch;
    public Wroker(MyLatch latch){
        this.latch = latch;
    }
    public void run(){
        try{
            Thread.sleep((int)(Math.random()*100));
            this.latch.cutDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class racerWithLanchDemo {
    public static void main(String [] args)throws InterruptedException{
        int workerNum = 100;
        MyLatch latch = new MyLatch(100);
        Wroker [] wrokers = new Wroker[workerNum];
        for(int i=0;i<workerNum;i++){
            wrokers[i] = new Wroker(latch);
            wrokers[i].start();
        }
        latch.await();
        System.out.println("collect worker result");
    }

}
