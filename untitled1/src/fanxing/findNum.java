package fanxing;

public class findNum {
    private static int[] find(int[][] arr, int k) {
        int[] result = {-1,-1};
        if(arr==null || arr.length<=0 || arr[0].length<=0)
            return result;
        int row = 0;
        int col = arr[0].length -1;
        while (row<arr.length&&col>=0) {
            if(arr[row][col]==k) {
                result[0] = row;
                result[1] = col;
                break;
            }
            else if(arr[row][col]>k)
                col--;
            else
                row++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8},{2,7,9},{4,7,10}};
        int[] result = find(arr,9);
        for(int i:result)
            System.out.println(i);
    }
}
