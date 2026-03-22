package Concurrency_Synchronizers;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexTaskExecutor {

    public void executeTasks(int numberOfTasks) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        AtomicInteger totalResult = new AtomicInteger(0);

        // Barrier action: runs when all threads reach barrier
        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks, () -> {
            System.out.println("\nAll tasks completed!");
            System.out.println("Final combined result: " + totalResult.get());
        });

        for (int i = 1; i <= numberOfTasks; i++) {
            int taskId = i;

            executor.submit(() -> {
                try {
                    ComplexTask task = new ComplexTask(taskId, totalResult);

                    task.execute();

                    System.out.println("Task " + taskId + " waiting at barrier...");
                    
                    barrier.await(); // wait for others

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
