import java.util.ArrayList;
import java.util.List;

class SharedBuffer {
    private List<Integer> buffer;
    private final int MAX_SIZE = 10; // Maximum size of the buffer

    public SharedBuffer() {
        buffer = new ArrayList<>();
    }

    // Producer adds an item to the buffer
    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            System.out.println("Buffer is full, producer is waiting...");
            wait(); // Wait until space is available in the buffer
        }
        buffer.add(item); // Add the item to the buffer
        System.out.println("Produced: " + item);
        notify(); // Notify the consumer that there is data to consume
    }

    // Consumer removes an item from the buffer
    public synchronized int consume() throws InterruptedException {
        while (buffer.size() == 0) {
            System.out.println("Buffer is empty, consumer is waiting...");
            wait(); // Wait until there is data to consume
        }
        int item = buffer.remove(0); // Remove the item from the buffer
        System.out.println("Consumed: " + item);
        notify(); // Notify the producer that there is space to produce more items
        return item;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100); // Produce a random item
                buffer.produce(item); // Add item to the buffer
                Thread.sleep(1000); // Simulate the time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume(); // Get an item from the buffer
                Thread.sleep(1500); // Simulate the time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        // Create a shared buffer
        SharedBuffer buffer = new SharedBuffer();

        // Create and start producer and consumer threads
        Thread producerThread = new Producer(buffer);
        Thread consumerThread = new Consumer(buffer);

        producerThread.start();
        consumerThread.start();
    }
}
