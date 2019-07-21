package goodluck;

public class Top46GetTranslationCount {
    private static int getTranslationCount(int num) {
        if(num<0)
            return 0;
        String numString = String.valueOf(num);
        int len = numString.length();
        int[] count = new int[len];
        for(int i=len-1;i>=0;i--) {
            if(i==len-1)
                count[i] = 1;
            else {
                count[i] = count[i+1];
                if(canTrans(numString, i)) {
                    if(i==len-2)
                        count[i] += 1;
                    else
                        count[i] += count[i+2];
                }
            }
        }
        return count[0];
    }
    private static boolean canTrans(String string, int i) {
        int a = string.charAt(i) - '0';
        int b = string.charAt(i+1) - '0';
        int num = a*10 + b;
        if(num >= 10 && num <= 25)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(1111));
    }
}
