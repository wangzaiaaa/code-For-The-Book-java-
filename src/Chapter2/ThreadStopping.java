package Chapter2;

public class ThreadStopping {
    public static void main(String [] args){
        class StoppableThread extends Thread{
            private boolean stopped;
            public void run(){
                while(!stopped){
                    System.out.println("running");
                }
            }
            void stopThread(){
                stopped = true;
            }
        }
        Thread m = Thread.currentThread();
        m.setName("xxxx");
        StoppableThread st = new StoppableThread();
        st.setName("hahaha");
        st.start();
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            st.stopThread();
        }
    }
}
