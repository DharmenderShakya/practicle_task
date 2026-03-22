package Concurrency_Blocking_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T>{
	
	Queue<T> queue;
	int capacity;
	
	BlockingQueue(int capacity){
		this.queue=new LinkedList<>();
		this.capacity=capacity;
	}
	
    // Add element to queue
    public synchronized void enqueue(T item) throws InterruptedException {

        // Wait until space is available
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(item);

        // Notify waiting consumers
        notifyAll();
    }
    
    // Remove element from queue
    public synchronized T dequeue() throws InterruptedException {

        // Wait until element is available
        while (queue.isEmpty()) {
            wait();
        }

        T item = queue.poll();

        // Notify waiting producers
        notifyAll();

        return item;
    }
    
    public synchronized int size() {
        return queue.size();
    }
	
}
