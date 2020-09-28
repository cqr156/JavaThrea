import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/9/28.
 *
 * @author CQR
 */
public class AtomaticIntegar_Test {
    public static void main(String[] args) {
        AtomicInteger first = new AtomicInteger(5);
        System.out.println("original value: "+first);      // 5
        int a = first.getAndIncrement();
        System.out.println("original value: "+first);      //6
        System.out.println("getAndIncrement value: "+ a);  // 5

        AtomicInteger second = new AtomicInteger(5);
        System.out.println("original value: "+second);     // 5
        int b = second.incrementAndGet();
        System.out.println("incrementAndGet value: "+ b);  // 6
    }
}
