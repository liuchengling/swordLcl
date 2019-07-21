package wzcroad;

public class RyanAndMonicaJob implements Runnable {
    private int balance = 0;
    @Override
    public void run() {
        for(int i=0 ;i<50; i++) {
            increment();
            System.out.println("balance is " + balance);
        }
    }
    private void increment() {
        synchronized (this) {
            int i = balance;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = i + 1;
        }
    }

    public static void main(String[] args) {
        RyanAndMonicaJob job = new RyanAndMonicaJob();
        Thread one = new Thread(job);
        Thread two = new Thread(job);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }
}
