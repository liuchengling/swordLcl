package wzcroad;

public class Movie {
    private String pic;
    private boolean flag = true;
    int i = 0;

    public synchronized void play(String pic) {
        if (!flag) {
            try {
                this.wait();
                System.out.println("play wait" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("继续生产了" + i++);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("生产了");
        this.pic = pic;
        this.notify();
        this.flag = false;
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
                System.out.println("watch wait" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("继续消费了" + i++);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(pic);
        this.notify();
        this.flag = true;
    }
}
