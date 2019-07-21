package goodluck;

public class Top56FindNumsAppearOnce {
    private static void findNums(int[] arr, int[] num1, int[] num2) {
        if(arr==null || arr.length<=0)
            return;

        int resultExclusiveOr = 0;
        for(int i=0;i<arr.length;i++) {
            resultExclusiveOr^=arr[i];
        }

        int indexOf1 = findFirstBit1(resultExclusiveOr);

        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<arr.length;i++) {
            if(isBit1(arr[i], indexOf1))
                num1[0]^=arr[i];
            else
                num2[0]^=arr[i];
        }
    }
    private static int findFirstBit1(int resultExclusiveOr) {
        int indexOf = 0;
        while ((resultExclusiveOr&1)==0 && indexOf<Integer.SIZE) {
            resultExclusiveOr>>=1;
            indexOf++;
        }
        return indexOf;
    }
    private static boolean isBit1(int num, int indexOf1) {
        num = num>>indexOf1;
        return (num&1)==1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] arr = {2,4,3,6,3,2,5,5};
        findNums(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
