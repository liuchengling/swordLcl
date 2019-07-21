package Productor.SynchronizedWay;

public class Player implements Runnable {
    public Player(Movie m) {
        this.m = m;
    }

    private Movie m;

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            if (i % 2 == 0)
                m.play("左青龙");
            else
                m.play("右白虎");
        }
    }
}
