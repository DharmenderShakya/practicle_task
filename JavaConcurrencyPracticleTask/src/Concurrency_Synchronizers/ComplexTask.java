package Concurrency_Synchronizers;

import java.util.concurrent.atomic.AtomicInteger;

public class ComplexTask {

    private int taskId;
    private AtomicInteger resultHolder;

    public ComplexTask(int taskId, AtomicInteger resultHolder) {
        this.taskId = taskId;
        this.resultHolder = resultHolder;
    }

    public void execute() {
        try {
            // Simulate complex work
            int result = taskId * 10;

            System.out.println("Task " + taskId + " executed with result: " + result);

            // Add result to shared total
            resultHolder.addAndGet(result);

            Thread.sleep(500); // simulate delay

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
