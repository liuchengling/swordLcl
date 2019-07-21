public class exam {
    private static String blank(StringBuilder str) {
        if(str==null)
            return null;
        int len = str.length();
        int p1 = len-1;
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==' ')
                len+=2;
        str.setLength(len);
        int p2 = len-1;
        while (p1<p2) {
            if(str.charAt(p1)!=' ')
                str.setCharAt(p2--,str.charAt(p1));
            else {
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }
            p1--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello , I am a student!");
        System.out.println(blank(str));
    }
}
