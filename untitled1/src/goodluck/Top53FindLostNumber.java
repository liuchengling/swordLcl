package goodluck;

public class Top53FindLostNumber {
    private static int findLostNum(int[] a) {
        if(a==null || a.length<=0)
            return -1;
        int start = 0;
        int end = a.length-1;
        while (start<=end) {
            int mid = (start+end)>>1;
            if(a[mid]!=mid){
                if(mid==0 || a[mid-1]==mid-1)
                    return mid;
                else
                    end = mid-1;
            } else
                start = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,6};
        System.out.println(findLostNum(a));
    }
}
