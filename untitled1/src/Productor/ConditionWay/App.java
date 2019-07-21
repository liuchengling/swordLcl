package Productor.ConditionWay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition playerCondition = lock.newCondition();
        Condition watcherCondition = lock.newCondition();

        Movie m = new Movie(lock,playerCondition, watcherCondition);

        Player p = new Player(m);
        Watcher w = new Watcher(m);

        new Thread(p).start();
        new Thread(w).start();
    }
}
