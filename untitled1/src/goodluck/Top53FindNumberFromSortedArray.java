package goodluck;

public class Top53FindNumberFromSortedArray {
    private static int getCountOfNum(int[] a, int k) {
        if(a==null || a.length<=0)
            return 0;
        int first = getFirst(a, 0, a.length-1, k);
        if(first==-1)
            return 0;
        int last = getLast(a, first, a.length-1, k);
        return last-first+1;
    }

    private static int getFirst(int[] a, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(a[mid] == k) {
            if(mid==0 || a[mid-1]!=k)
                return mid;
            else
                end = mid-1;
        } else if(a[mid] < k) {
            start = mid+1;
        } else
            end = mid-1;
        return getFirst(a, start, end, k);
    }

    private static int getLast(int[] a, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(a[mid] == k) {
            if(mid==end || a[mid+1]!=k)
                return mid;
            else
                start = mid+1;
        } else if(a[mid] > k) {
            end = mid-1;
        } else
            start = mid+1;
        return getLast(a, start, end, k);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println(getCountOfNum(a,3));
    }
}
