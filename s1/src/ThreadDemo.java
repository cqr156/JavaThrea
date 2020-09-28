/**
 * Created on 2020/9/28.
 *
 * @author CQR
 */


/**
 * @author Woo_home
 * @create by 2020/1/20
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        ThreadShop shopA = new ThreadShop();
        ThreadShop shopB = new ThreadShop();
        ThreadShop shopC = new ThreadShop();
        new Thread(shopA,"A 店铺").start();
        new Thread(shopB,"B 店铺").start();
        new Thread(shopC,"C 店铺").start();
        System.out.println("不同对象");
    }
}

class ThreadShop implements Runnable {

    private volatile int product = 5; // 直接内存操作



    @Override
    public void run() {
        synchronized (this) {
            while (this.product > 0) {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "商品处理，product = " + this.product--);
            }
        }
    }
}
