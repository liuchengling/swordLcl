package goodluck;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] n,int left,int right){
        int length = n.length;
        if(n==null||length<=0)
            throw new RuntimeException("error");
        if(left>right)
            return n;
        int temp = n[left];
        int i = left;
        int j = right;
        while(i!=j){
            while(n[j]>=temp && i<j)
                j--;
            while(n[i]<=temp && i<j)
                i++;
            if(i<j){
                int t = n[i];
                n[i] = n[j];
                n[j] = t;
            }
        }
        n[left] = n[i];
        n[i] = temp;
        sort(n,left,i-1);
        sort(n,i+1,right);
        return n;
    }
    public int[] quick(int[] n){
        sort(n,0,n.length-1);
        return n;
    }
    public void test(){
        int[] n = {6,1,2,5,4,3,9,7,10,8};
        System.out.println(Arrays.toString(quick(n)));
    }

    public static void main(String[] args) {
        QuickSort demo = new QuickSort();
        demo.test();
    }
}
