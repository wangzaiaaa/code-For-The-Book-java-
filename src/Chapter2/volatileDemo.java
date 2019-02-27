package Chapter2;

public class volatileDemo {

    public static void main(String [] args){
        class myThread extends Thread{
            private volatile boolean stopped;
            public void run(){
                while(!stopped){
                    System.out.println("running");
                }
            }
            public void stopThread(){
                stopped = true;
            }
        }
        myThread T1 = new myThread();
        T1.start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            T1.stopThread();
        }
    }
}
