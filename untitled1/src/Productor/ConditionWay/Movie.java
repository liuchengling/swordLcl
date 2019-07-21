package Productor.ConditionWay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Movie {
    private String pic;
    private boolean flag=true;
    private Lock lock;
    private Condition playerCondition;
    private Condition watcherCondition;

    public Movie(Lock lock, Condition playerCondition, Condition watcherCondition) {
        this.lock = lock;
        this.playerCondition = playerCondition;
        this.watcherCondition = watcherCondition;
    }

    public void play(String pic) {
        lock.lock();
        try {
            if(!flag) {
                try {
                    playerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.pic = pic;
            watcherCondition.signalAll();
            this.flag = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void watch() {
        lock.lock();
        try {
            if(flag) {
                try {
                    watcherCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(pic);
            playerCondition.signalAll();
            this.flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
