package prak3;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class MyList<T> {
    private final Lock lock;
    private final List<T> list;

    public MyList(Lock lock, List<T> list) {
        this.lock = lock;
        this.list = list;
    }
    public void add(T element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public boolean contains(T element) {
        lock.lock();
        try {
            return list.contains(element);
        } finally {
            lock.unlock();
        }
    }

    public T get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }

    public void remove(T element) {
        lock.lock();
        try {
            list.remove(element);
        } finally {
            lock.unlock();
        }
    }
}
