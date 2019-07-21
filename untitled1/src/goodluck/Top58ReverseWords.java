package goodluck;

public class Top58ReverseWords {
    private static String reverseWords(char[] ch) {
        if(ch==null || ch.length<=0)
            return String.valueOf(ch);
        reverse(ch,0,ch.length-1);
        int start = 0;
        int end = 0;
        while (start<ch.length) {
            while (end<ch.length && ch[end]!=' ')
                end++;
            reverse(ch,start,end-1);
            start=++end;
        }
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
        char[] ch = {'I',' ','a','m',' ','a',' ','s','t','u','d','e','n','t','.'};
        System.out.println(reverseWords(ch));
    }
}
