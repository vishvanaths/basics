import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        BlockingQueue<LabelValue> q = new ArrayBlockingQueue(5);
        final Runnable producer = () -> {
            int a = atomicInteger.getAndIncrement();
            while (a < 14) {
                a = atomicInteger.getAndIncrement();
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " Produced : Label : " + a + " Value : " + 10 * a);
                try {
                    q.put(new LabelValue(a, 10 * a));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        (new Thread(producer)).start();
        (new Thread(producer)).start();

        final Runnable consumer = () -> {
            while (true) {
                LabelValue l = null;
                try {
                    l = q.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " Consumed : Label : " + l.label + " Value : " + l.value);
            }
        };
        (new Thread(consumer)).start();
        (new Thread(consumer)).start();
    }
}
