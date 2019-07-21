package goodluck;

public class Top53FindNumberWhichEqualsIndex {
    private static int findNum(int[] a) {
        if(a==null || a.length<=0)
            return -1;
        int start = 0;
        int end = a.length-1;
        while (start<=end) {
            int mid = (start+end)>>1;
            if(a[mid]==mid)
                return mid;
            else if(a[mid]<mid)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-3,-1,1,3,5};
        System.out.println(findNum(a));
    }
}
