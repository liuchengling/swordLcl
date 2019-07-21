package goodluck;

public class Top63StockMaxDiff {
    private static int maxDiff(int[] stocks) {
        if(stocks==null || stocks.length<2)
            return -1;

        int Min = stocks[0];
        int MaxDiff = stocks[1] - Min;

        for(int i=2;i<stocks.length;i++) {
            if(stocks[i-1]<Min)
                Min = stocks[i-1];
            if(stocks[i]-Min>MaxDiff)
                MaxDiff = stocks[i]-Min;
        }

        return MaxDiff;
    }

    public static void main(String[] args) {
        int[] stocks = {9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(stocks));
    }
}
