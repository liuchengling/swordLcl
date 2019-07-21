package Productor.BlockingQueueWay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Movie {
    private String pic;
    private BlockingQueue resource = new LinkedBlockingQueue(1);
    public void play(String pic) {
        try {
            resource.put(1);
            this.pic = pic;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void watch() {
        try {
            resource.take();
            System.out.println(pic);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
