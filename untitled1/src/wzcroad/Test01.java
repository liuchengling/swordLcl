package wzcroad;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test01 {

    public static void main(String[] args) throws ParseException {
        MyRunnable my = new MyRunnable();
        Thread t1= new Thread(my);
        Thread t2= new Thread(my);
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {

    Map map = new HashMap();
    Object obj = new Object();

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            map.put(i,obj);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Object key : map.keySet())
                System.out.println("(" + Thread.currentThread().getName() + ")The " + i  + " time : " + (Integer) key);
        }
        System.out.println();
    }
}

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}