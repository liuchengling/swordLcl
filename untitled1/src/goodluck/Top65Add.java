package goodluck;

public class Top65Add {
    private static int add(int num1, int num2) {
        while (num2 != 0) {
            int num = num1^num2;
            int carry = (num1&num2)<<1;
            num1 = num;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(45,96));
    }
}
