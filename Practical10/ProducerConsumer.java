
class Buffer {
    int data;
    boolean available = false;

    synchronized void produce(int value) {
        try {
            while (available) {
                wait();
            }

            data = value;
            available = true;

            System.out.println("Produced: " + value);

            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void consume() {
        try {
            while (!available) {
                wait();
            }

            System.out.println("Consumed: " + data);
            available = false;

            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Producer implements Runnable {
    Buffer b;

    Producer(Buffer b) {
        this.b = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            b.produce(i);
        }
    }
}

class Consumer implements Runnable {
    Buffer b;

    Consumer(Buffer b) {
        this.b = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            b.consume();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {

        Buffer b = new Buffer();

        Thread p = new Thread(new Producer(b));
        Thread c = new Thread(new Consumer(b));

        p.start();
        c.start();
    }
}
