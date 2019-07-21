package wzcroad;

public class TestSort {
    private void sort(int[] arr, int start, int end) {
        if(start>end)
            return;
        int temp = arr[start];
        int i = start;
        int j = end;
        while (i!=j) {
            while (arr[j]>=temp && i<j)
                j--;
            while (arr[i]<=temp && i<j)
                i++;
            if(i<j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = temp;
        sort(arr, start, i-1);
        sort(arr, i+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,1};
        TestSort ts = new TestSort();
        ts.sort(arr,0,arr.length-1);
        for(int a: arr)
            System.out.println(a);
    }
}
