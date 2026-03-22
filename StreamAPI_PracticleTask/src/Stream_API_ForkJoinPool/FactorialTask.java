package Stream_API_ForkJoinPool;

import java.util.concurrent.RecursiveTask;

class FactorialTask extends RecursiveTask<Long> {

    private final int start;
    private final int end;

    // Constructor for full range
    public FactorialTask(int n) {
        this(1, n);
    }

    // Constructor for subtask
    public FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        // Base case (small task → compute directly)
        if (end - start <= 2) {
            long result = 1;
            for (int i = start; i <= end; i++) {
                result *= i;
            }
            return result;
        }

        // Split task
        int mid = (start + end) / 2;

        FactorialTask leftTask = new FactorialTask(start, mid);
        FactorialTask rightTask = new FactorialTask(mid + 1, end);

        // Fork left (async)
        leftTask.fork();

        // Compute right directly
        long rightResult = rightTask.compute();

        // Join left result
        long leftResult = leftTask.join();

        // Combine results
        return leftResult * rightResult;
    }
}
