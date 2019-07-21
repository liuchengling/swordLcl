package wzcroad;

public class multi {
    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            go();
        }
    }
    private void go() {
        for(int i=0 ;i<10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is Running!");
        }
    }
    private void test() {
        MyRunnable m = new MyRunnable();
        Thread alpha = new Thread(m);
        Thread beta = new Thread(m);
        alpha.setName("alpha");
        beta.setName("beta");
        alpha.start();
        beta.start();
        System.out.println("Back in main!");
    }
    public static void main(String[] args) {
        multi multi = new multi();
        multi.test();
    }
}
