package goodluck;

public class Top58LeftTurnWords {
    private static String leftTurn(char[] ch, int n) {
        if(ch==null || ch.length<=0 || n<=0 || n>ch.length)
            return String.valueOf(ch);
        reverse(ch,0,n-1);
        reverse(ch, n,ch.length-1);
        reverse(ch,0,ch.length-1);
        return String.valueOf(ch);
    }
    private static void reverse(char[] ch, int start, int end) {
        if(ch==null || ch.length<=0)
            return;
        while (start<end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] ch = {'a','b','c','d','e','f','g'};
        System.out.println(leftTurn(ch,2));
    }
}
