/**
 * Created on 2020/9/28.
 *
 * @author CQR
 */
public class Run {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            RunThread thread= new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值false");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

class RunThread extends Thread {
    volatile private boolean isRunning=true;
    //private boolean isRunning=true;
    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean isRunning){
        this.isRunning=isRunning;
        System.out.println(Thread.currentThread().getName());
    }
    @Override
    public void run(){
        System.out.println("进入run了");
        System.out.println(Thread.currentThread().getName());
        while (isRunning==true){
        }
        System.out.println("线程被停止了");
    }
    /*
    volatile具备两种特性，第一就是保证共享变量对所有线程的可见性。将一个共享变量声明为volatile后，会有以下效应：

　　　　1.当写一个volatile变量时，JMM会把该线程对应的本地内存中的变量强制刷新到主内存中去；

　　　　2.这个写会操作会导致其他线程中的缓存无效。
     */
}
