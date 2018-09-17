package ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLeakTest {

    public static void main(String[] args) {
        // 如果控制线程池的大小为50，不会导致内存溢出
        testWithThreadPool(50);
        // 也不会导致内存泄露
        testWithThread();
    }

    static class TestTask implements Runnable {

        public void run() {
            ThreadLocal tl = new ThreadLocal();
            // 确保threadLocal为局部对象,在退出run方法之后，没有任何强引用，可以被垃圾回收
            tl.set(allocateMem());
        }
    }

    public static void testWithThreadPool(int poolSize) {
        ExecutorService service = Executors.newFixedThreadPool(poolSize);
        while (true) {
            try {
                Thread.sleep(100);
                service.execute(new TestTask());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testWithThread() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        new Thread(new TestTask()).start();

    }

    public static final byte[] allocateMem() {
        // 这里分配一个1M的对象
        byte[] b = new byte[1024 * 1024 * 1];
        return b;
    }

}