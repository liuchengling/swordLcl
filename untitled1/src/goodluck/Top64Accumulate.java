package goodluck;

public class Top64Accumulate {
    private static int getSum(int n) {
        int sum = n;
        boolean flag = (n>1) && ((sum += getSum(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(100));
    }
}
