package goodluck;

import java.util.Arrays;

public class Top3findDupication {
    public static int getDuplication(int[] num){
        if(num == null || num.length<=0){
            return -1;
        }
        for(int a:num){
            if(a<0 || a>num.length-1){
                return -1;
            }
        }
        for(int i=0;i<num.length;i++){
            while(num[i]!=i){
                if(num[i] == num[num[i]]){
                    return num[i];
                }
                int temp = num[i];
                num[i] = num[temp];
                num[temp] = temp;
                System.out.println(Arrays.toString(num));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {2,3,1,0,2,5,3};
        System.out.println(getDuplication(num));
    }
}
