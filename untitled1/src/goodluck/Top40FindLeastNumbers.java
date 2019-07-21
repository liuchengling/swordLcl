package goodluck;

import java.util.ArrayList;

public class Top40FindLeastNumbers {
    private ArrayList<Integer> findLeastNumbers1(int[] input, int k) {
        if(input == null || input.length==0 || k < 0 || k > input.length-1)
            return null;
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while (index != k-1) {
            if(index < k-1) {
                start = index + 1;
                index = partition(input,start,end);
            } else {
                end = index - 1;
                index = partition(input,start,end);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<k;i++)
            list.add(input[i]);
        return list;
    }

    private int partition(int[] array, int start, int end) {
        int num = array[start];
        while (start < end) {
            while (start < end && array[end] > num)
                end--;
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            while (start < end && array[start] < num)
                start++;
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return start;
    }

    private void test1() {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = findLeastNumbers2(input,4);
        for(int i:list)
            System.out.println(i);
    }

    public static void main(String[] args) {
        Top40FindLeastNumbers demo = new Top40FindLeastNumbers();
        demo.test1();
    }

    private ArrayList<Integer> findLeastNumbers2(int[] input,int k) {
        if(input==null || input.length==0 || k<0 || k>input.length)
            return null;
        int[] num = new int[k];
        for(int i=0;i<k;i++)
            num[i] = input[i];
        for(int i = k/2 - 1;i>=0;i--)
            ajustHeap(num,i,k-1);
        for(int i=k;i<input.length;i++) {
            if(input[i]<num[0]) {
                num[0] = input[i];
                ajustHeap(num,0,k-1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:num) {
            list.add(i);
        }
        return list;
    }

    private void ajustHeap(int[] num, int start, int end) {
        int dad = start;
        int son = start*2+1;
        while (son<=end) {
            if(son+1<=end && num[son] < num[son+1])
                son++;
            if(num[dad] > num[son])
                break;
            int temp = num[son];
            num[son] = num[dad];
            num[dad] = temp;
            dad = son;
            son = dad*2+1;
        }
    }
}
