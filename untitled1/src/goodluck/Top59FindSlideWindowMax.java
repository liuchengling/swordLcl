package goodluck;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Top59FindSlideWindowMax {
    private static ArrayList<Integer> findmax(int[] arr, int len) {
        if(arr==null || arr.length<=0 || len<=0 || len>arr.length)
            return null;
        ArrayList<Integer> max = new ArrayList<Integer>();
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();
        for (int i=0;i<len-1;i++) {
            while (!indexDeque.isEmpty() && arr[i]>indexDeque.getLast())
                indexDeque.removeLast();
            indexDeque.addLast(i);
        }

        for(int i=len-1;i<arr.length;i++) {
            while (!indexDeque.isEmpty() && arr[i]>arr[indexDeque.getLast()])
                indexDeque.removeLast();
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=len)
                indexDeque.removeFirst();
            indexDeque.addLast(i);
            max.add(indexDeque.getFirst());
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> arrayList = findmax(arr, 3);
        for(int index:arrayList)
            System.out.println(arr[index]);
    }
}
