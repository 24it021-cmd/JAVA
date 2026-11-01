
import java.util.concurrent.*;

class MyTask implements Runnable {
    int id;

    MyTask(int id) {
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("Task-" + id + " started by "
                    + Thread.currentThread().getName());

            Thread.sleep(500);

            System.out.println("Task-" + id + " completed");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService pool =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            pool.execute(new MyTask(i));
        }

        pool.shutdown();

        try {
            if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
