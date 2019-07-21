package goodluck;

import java.text.NumberFormat;

public class Top60PrintProbability {
    int maxValue = 6;
    public void printProbability(int number) {
        if(number<1)
            return;
        int[] probabilities = new int[number*maxValue-number+1];
        for(int i=1;i<=maxValue;i++)
            calP(probabilities, number, number-1, i);
        int totalP = (int) Math.pow(maxValue, number);
        for(int i=0;i<probabilities.length;i++) {
            double ratio = (double) probabilities[i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(5);
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }
    public void calP(int[] probabilites, int number, int curNumber, int sum) {
        if(curNumber==0) {
            probabilites[sum-number]++;
            return;
        }
        for(int i=1;i<=maxValue;i++)
            calP(probabilites, number, curNumber-1, sum+i);
    }
    public void printPobability2(int number) {
        if(number<1)
            return;

        int[][] probabilities = new int[2][number*maxValue+1];
        for(int i=0;i<2;i++)
            for(int j=0;j<number*maxValue+1;j++)
                probabilities[i][j]=0;

        for(int i=1;i<=maxValue;i++)
            probabilities[0][i] = 1;

        int flag = 0;
        for(int curNum=2;curNum<=number;curNum++) {
            for(int i=0;i<curNum;i++)
                probabilities[1-flag][i]=0;
            for(int i=curNum;i<=curNum*maxValue;i++) {
                for(int j=1;j<=6 && j<=i;j++)
                    probabilities[1-flag][i] += probabilities[flag][i-j];
            }
            flag=1-flag;
        }
        int totalP = (int) Math.pow(maxValue, number);
        for(int i=number;i<probabilities[flag].length;i++) {
            double ratio = (double) probabilities[flag][i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(5);
            System.out.println("点数和为"+(i)+"的概率为:"+format.format(ratio));
        }
    }

    public static void main(String[] args) {
        Top60PrintProbability demo = new Top60PrintProbability();
        long startTime = System.currentTimeMillis();
        //demo.printProbability(10);
        demo.printPobability2(10);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
