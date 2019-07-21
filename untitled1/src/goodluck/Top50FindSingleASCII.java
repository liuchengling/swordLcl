package goodluck;

public class Top50FindSingleASCII {
    private static char findFirst(String string) {
        if(string==null || string.length()<=0)
            return '\0';
        int[] charA = new int[256];
        for(int i=0;i<256;i++)
            charA[i] = 0;

        for(int i=0;i<string.length();i++) {
            charA[string.charAt(i)]++;
        }

        for(int i=0;i<string.length();i++) {
            if(charA[string.charAt(i)]==1)
                return string.charAt(i);
        }

        return '\0';
    }

    public static void main(String[] args) {
        String string = "abaccdeff";
        System.out.println(findFirst(string));
    }
}
