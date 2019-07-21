package Productor;

public class Movie {
    private String pic;
    private boolean flag = true;

    public synchronized void play(String pic) {
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        this.notify();
        this.flag = false;
    }

    public synchronized void watch() {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pic);
        this.notify();
        this.flag = true;
    }
}
