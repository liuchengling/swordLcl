package goodluck;

import java.util.Arrays;

public class Top21ReorderOddEven {
    public void reorderOddEven(int[] number){
        if(number==null)
            return;
        int start = 0;
        int end = number.length - 1;
        while (start<end){
            while(start<end && !func(number[start]))
                start++;
            while(start<end && func(number[end]))
                end--;
            if(start<end){
                int temp = number[start];
                number[start] = number[end];
                number[end] = temp;
            }
        }
    }
    boolean func(int n){
        return (n&0x1)==0;
    }
    public void test(){
        int[] number = {1,2,3,4,5,6,7,8};
        reorderOddEven(number);
        System.out.println(Arrays.toString(number));
    }

    public static void main(String[] args) {
        Top21ReorderOddEven demo = new Top21ReorderOddEven();
        demo.test();
    }
}
