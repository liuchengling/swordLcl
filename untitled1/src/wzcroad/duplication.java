package wzcroad;

import java.util.Arrays;

public class duplication {
    public static int find(int[] num){
        int length = num.length;
        if(num == null || length<=0){
            return -1;
        }
        for(int i=0;i<length;i++){
            if(num[i]<0||num[i]>length-1){
                return -1;
            }
        }
        for(int i=0;i<length;i++){
            while(num[i]!=i){
                if(num[i] == num[num[i]]){
                    return num[i];
                }
                int temp = num[i];
                num[i] = num[temp];
                num[temp] = temp;
                System.out.println(Arrays.toString(num));
            }
            System.out.println(Arrays.toString(num));
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {2,3,1,0,2,5,3};
        System.out.println(find(num));
    }
}
