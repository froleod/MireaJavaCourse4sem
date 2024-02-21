package prak3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MySet<Integer> set = new MySet<>(new HashSet<>(), new Semaphore(1));
        set.add(5);
        set.add(7);
        System.out.println(set.contains(5));

        MyList<String> list = new MyList<>(new ReentrantLock(), new ArrayList<>());
        list.add("abc");
        list.add("def");
        list.remove("abc");
        System.out.println(list.contains("abc"));
    }
}
