package goodluck;

public class MergeSort {
    private void sort(int[] a, int start, int end) {
        int mid = (start + end) >> 1;
        if(start<end) {
            sort(a, start, mid);
            sort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }
    private void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if(a[i] > a[j])
                temp[k++] = a[j++];
            else
                temp[k++] = a[i++];
        }
        while (i <= mid)
            temp[k++] = a[i++];
        while (j <= end)
            temp[k++] = a[j++];
        System.arraycopy(temp, 0, a, start, temp.length);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {7,5,6,4};
        mergeSort.sort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
