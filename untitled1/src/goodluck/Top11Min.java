package goodluck;

public class Top11Min {
    public int findMin(int[] n){
        if(n==null||n.length<=0)
            return 0;
        int left = 0;
        int right = n.length - 1;
        int mid = (left+right)/2;
        if(n[right]>n[left])
            return n[left];
        if(n[right]==n[mid]&&n[mid]==n[left])
            for(int i=1;i<=right;i++)
                if(n[i]<n[i-1])
                    return n[i];
        while(left<right){
            if((right-left)==1)
                break;
            mid = (left+right)/2;
            if(n[left]<n[mid])
                left=mid;
            if(n[right]>n[mid])
                right=mid;
        }
        return n[right];
    }
    public void test(){
        int[] n={1,2,3,4,5,6,7};
        System.out.println("min = " + findMin(n));
    }

    public static void main(String[] args) {
        Top11Min demo = new Top11Min();
        demo.test();
    }
}
