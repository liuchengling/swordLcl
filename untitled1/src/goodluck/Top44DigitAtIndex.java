package goodluck;

public class Top44DigitAtIndex {
    private static int digitAtIndex(int index) {
        if(index < 0)
            return -1;
        int digit=1;
        while (true) {
            int number = numberOfdigit(digit);
            if(index<digit*number)
                return digitAtIndex(index,digit);
            index -= digit*number;
            digit++;
        }
    }
    private static int numberOfdigit(int digit) {
        if(digit==1)
            return 10;
        return (int) (9*Math.pow(10,digit-1));
    }
    private static int digitAtIndex(int index, int digit) {
        int digitOfTotal = getFirstNumber(digit) + index/digit;
        int timesOfCircle = digit - index%digit;
        for(int i=1;i<timesOfCircle;i++)
            digitOfTotal/=10;
        return digitOfTotal%10;
    }
    private static int getFirstNumber(int digit) {
        if(digit==1)
            return 0;
        return (int) Math.pow(10,digit-1);
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1002));
    }
}
