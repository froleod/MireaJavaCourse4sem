package prak3;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public MySet(Set<T> set, Semaphore semaphore) {
        this.set = set;
        this.semaphore = semaphore;
    }

    public void add(T element) throws InterruptedException{
        semaphore.acquire();
        try {
            set.add(element);
        } finally {
            semaphore.release();
        }
    }

    public void remove(T element) throws InterruptedException{
        semaphore.acquire();
        try{
            set.remove(element);
        } finally {
            semaphore.release();
        }
    }

    public boolean contains(T element) throws InterruptedException{
        semaphore.acquire();
        try{
            return set.contains(element);
        } finally {
            semaphore.release();
        }
    }
}
