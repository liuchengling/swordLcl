package goodluck;

import java.util.ArrayList;

public class Top57FindContinuousSequence {
    private static ArrayList<ArrayList<Integer>> findSequence(int num) {
        ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<ArrayList<Integer>>();
        if(num<3)
            return null;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while (small<=num/2) {
            if(curSum==num) {
                ArrayList<Integer> sequence = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    sequence.add(i);
                sequenceList.add(sequence);
                curSum-=small;
                small++;
            } else if(curSum<num){
                big++;
                curSum+=big;
            } else {
                curSum-=small;
                small++;
            }
        }
        return sequenceList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = findSequence(15);
        for(ArrayList l:list) {
            for(Object j:l)
                System.out.print(j+" ");
            System.out.println();
        }
    }
}
