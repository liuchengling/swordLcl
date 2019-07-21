package goodluck;

public class HeapSort {
    private void ajustHeap(int[] arr, int start, int end) {
        int dad = start;
        int son = dad*2 + 1;
        while (son<=end) {
            if(son+1<=end && arr[son] < arr[son+1])
                son++;
            if(arr[dad]>=arr[son])
                break;
            swap(arr,dad,son);
            dad = son;
            son = dad*2 + 1;
        }
    }
    private void sort(int[] arr) {
        int len = arr.length;
        for(int i = len/2 - 1; i>=0; i--)
            ajustHeap(arr, i, len-1);
        for(int j = len - 1; j>0; j--) {
            swap(arr, 0, j);
            ajustHeap(arr, 0, j-1);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort demo = new HeapSort();
        int[] arr = {10,7,9,4,5,2,3};
        demo.sort(arr);
        for(int a:arr)
            System.out.println(a);
    }
}
