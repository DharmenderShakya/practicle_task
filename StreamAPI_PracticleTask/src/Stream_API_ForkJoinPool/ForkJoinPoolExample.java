package Stream_API_ForkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {

    public static void main(String[] args) {

        int n = 10; // factorial of 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialTask task = new FactorialTask(n);

        long result = forkJoinPool.invoke(task);

        System.out.println("Factorial " + n + "! = " + result);

        forkJoinPool.shutdown();
    }
}
