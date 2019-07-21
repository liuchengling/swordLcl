package goodluck;

public class Top47MaxGiftValue {
    private static int getMaxValue(int[][] gift) {
        if(gift==null || gift.length<=0 || gift[0].length<=0)
            return 0;
        int[] maxValue = new int[gift[0].length];
        for(int i=0;i<gift.length;i++) {
            for(int j=0;j<gift[i].length;j++){
                int left = 0;
                int up = 0;
                if(i>0)
                    up = maxValue[j];
                if(j>0)
                    left = maxValue[j-1];
                maxValue[j] = Math.max(up,left) + gift[i][j];
            }
        }
        return maxValue[gift[0].length-1];
    }

    public static void main(String[] args) {
        int[][] gift = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxValue(gift));
    }
}
