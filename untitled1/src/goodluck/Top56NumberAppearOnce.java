package goodluck;

public class Top56NumberAppearOnce {
    private static int findNumber(int[] arr) {
        if(arr==null || arr.length<=0)
            throw new RuntimeException();

        int bitSum[] = new int[32];
        for(int i=0;i<32;i++)
            bitSum[i] = 0;
        for(int i=0;i<arr.length;i++) {
            int bitMark = 1;
            for(int j=31;j>-0;j--) {
                if((arr[i]&bitMark)!=0)
                    bitSum[j]++;
                bitMark<<=1;
            }
        }

        int result = 0;
        for(int i=0;i<32;i++) {
            result <<= 1;
            result += bitSum[i]%3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,5,2,3,2};
        System.out.println(findNumber(arr));
    }
}
