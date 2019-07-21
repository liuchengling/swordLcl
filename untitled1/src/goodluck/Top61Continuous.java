package goodluck;

import java.util.Arrays;

public class Top61Continuous {
    private boolean isContinuous(int[] cards) {
        if(cards==null || cards.length<=0)
            return false;
        Arrays.sort(cards);
        int NumOf0 = 0;
        int NumOfGap = 0;
        for(int i=0;i<cards.length;i++)
            if(cards[i]==0)
                NumOf0++;

        int small = NumOf0;
        int big = NumOf0+1;
        while (big<cards.length) {
            if(cards[small]==cards[big])
                return false;
            NumOfGap += cards[big++] - cards[small++] - 1;
        }

        if(NumOf0>=NumOfGap)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] cards = {11,10,9,14,0};
        Top61Continuous demo = new Top61Continuous();
        System.out.println(demo.isContinuous(cards));
    }
}
