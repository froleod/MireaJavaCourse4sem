package prak4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutorService implements Executor {
    private final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    private final Thread[] threads;

    public MyExecutorService(int numThreads) {
        this.threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(this::taskExecutor);
            threads[i].start();
        }
    }

    private void taskExecutor() {
        while (true) {
            try {
                Runnable task = workQueue.take();
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void execute(Runnable command) {
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(2);
        executorService.execute(() -> System.out.println("Message 1"));
        executorService.execute(() -> System.out.println("Message 2"));
        executorService.execute(() -> System.out.println("Message 3"));
        executorService.execute(() -> System.out.println("Message 4"));
        executorService.execute(() -> System.out.println("Message 5"));
        executorService.shutdown();
    }
}