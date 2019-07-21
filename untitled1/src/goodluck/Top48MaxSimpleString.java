package goodluck;

public class Top48MaxSimpleString {
    private static int getMaxLengthForString(String s) {
        if(s==null || s.length()<=0)
            return -1;
        int current = 0;
        int max = 0;
        int[] pos = new int[26];
        for(int i=0;i<26;i++)
            pos[i] = -1;
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';
            if(pos[index]<0 || i-pos[index]>current)
                current++;
            else
                current=i-pos[index];
            pos[index] = i;
            if(current>max)
                max = current;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLengthForString("arabra"));
    }
}
