import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/9/28.
 *
 * @author CQR
 */
public class AtomicIn {
    static AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
        count.getAndIncrement();// 先返回在++
        System.err.println(Thread.currentThread().getName() + "--" + count + "-----");

    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Th1());
            //t.setName("thread"+i);
            t.start();
        }
        System.err.println("**********" + Thread.activeCount());
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.err.println("**********" + Thread.activeCount());
        System.err.println(AtomicIn.count);
    }

}
class Th1 implements Runnable {
    @Override
    public void run() {
        AtomicIn.increment();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
