package goodluck;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Top41StreamMedium {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private void insertNum(int num) {
        int len = minHeap.size() + maxHeap.size();
        if((len&1)==0) {
            if(!maxHeap.isEmpty() && (maxHeap.peek() > num)) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if(!minHeap.isEmpty() && (minHeap.peek() < num)) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }
    private double getMedium() {
        int len = minHeap.size() + maxHeap.size();
        if(len==0)
            throw new RuntimeException();
        if((len&1)==0)
            return (minHeap.peek() + maxHeap.peek())/2.0;
        else
            return minHeap.peek();
    }

    public static void main(String[] args) {
        Top41StreamMedium demo = new Top41StreamMedium();
        demo.insertNum(3);
        System.out.println(demo.getMedium());
        demo.insertNum(4);
        System.out.println(demo.getMedium());
        demo.insertNum(5);
        System.out.println(demo.getMedium());
        demo.insertNum(0);
        System.out.println(demo.getMedium());
        demo.insertNum(1);
        System.out.println(demo.getMedium());
        demo.insertNum(7);
        System.out.println(demo.getMedium());
    }
}
