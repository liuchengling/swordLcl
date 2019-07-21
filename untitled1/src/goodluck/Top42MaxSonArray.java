package goodluck;

public class Top42MaxSonArray {
    private int function1(int[] arr) {
        if(arr==null || arr.length<=0) {
            return 0;
        }
        int max = arr[0];
        int now = arr[0];
        for (int i=1; i<arr.length; i++) {
            if(now < 0)
                now = arr[i];
            else {
                now += arr[i];
            }
            if(now > max) {
                max = now;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Top42MaxSonArray demo = new Top42MaxSonArray();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(demo.function1(arr));
    }
}
