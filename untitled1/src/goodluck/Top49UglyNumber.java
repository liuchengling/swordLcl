package goodluck;

public class Top49UglyNumber {
    private static boolean isUglyNumber(int num) {
        while (num%2==0)
            num /= 2;
        while (num%3==0)
            num /= 3;
        while (num%5==0)
            num /= 5;
        return num==1;
    }
    private static int countUglyNumber(int index) {
        if(index<=0)
            return -1;
        int count = 0;
        int number = 0;
        while (count<index) {
            number++;
            if(isUglyNumber(number))
                count++;
        }
        return number;
    }

    private static int countUglyNumber2(int index) {
        int[] uglyNum = new int[index];

        uglyNum[0] = 1;
        int nextIndex = 1;

        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        while (nextIndex < index) {
            int min = getMin(uglyNum[multiply2]*2,uglyNum[multiply3]*3,uglyNum[multiply5]*5);
            uglyNum[nextIndex] = min;

            while (uglyNum[multiply2]*2<=uglyNum[nextIndex])
                multiply2++;
            while (uglyNum[multiply3]*3<=uglyNum[nextIndex])
                multiply3++;
            while (uglyNum[multiply5]*5<=uglyNum[nextIndex])
                multiply5++;

            nextIndex++;
        }

        return uglyNum[index-1];
    }

    private static int getMin(int number1, int number2, int number3) {
        int min = Math.min(number1, number2);
        return Math.min(min, number3);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(countUglyNumber(1500));
        long endTime = System.nanoTime();
        System.out.println("程序执行时间：" + (endTime-startTime)/Math.pow(10,6) + "ms");
    }
}
