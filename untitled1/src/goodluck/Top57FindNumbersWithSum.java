package goodluck;

import java.util.ArrayList;

public class Top57FindNumbersWithSum {
    private static ArrayList<Integer> findTwoNumbers(int[] arr, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(arr==null || arr.length<=0)
            return null;
        int low = 0;
        int high = arr.length - 1;
        while (low<high) {
            if(arr[low]+arr[high]==sum) {
                list.add(arr[low]);
                list.add(arr[high]);
                break;
            } else if(arr[low]+arr[high]>sum)
                high--;
            else
                low++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        ArrayList<Integer> list = findTwoNumbers(arr, 15);
        for(int i:list)
            System.out.println(i);
    }
}
