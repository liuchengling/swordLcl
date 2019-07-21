package goodluck;

public class Top67StringToInt {
    boolean isValid = false;
    private int stringToInt(String str) {
        if(str==null || str.length()<=0)
            return 0;
        char[] n = str.toCharArray();
        boolean minus = false;
        long num = 0;
        for(int i=0;i<n.length;i++) {
            if(i==0 && n[i]=='-')
                minus = true;
            else if(i==0 && n[i]=='+')
                minus = false;
            else {
                int a = (int) (n[i]-'0');
                if(a<0 || a>9) {
                    isValid = false;
                    return 0;
                }
                num = (minus==false)? num*10+a : num*10-a;
                isValid = true;
                if((minus==false && num>0x7FFFFFFF) ||
                        (minus==true && num<0x80000000)) {
                    isValid = false;
                    return 0;
                }
            }
        }
        return (int) num;
    }

    public static void main(String[] args) {
        Top67StringToInt demo = new Top67StringToInt();
        System.out.println(demo.stringToInt("+"));
        System.out.println(demo.isValid);
        System.out.println(demo.stringToInt("-6300"));
        System.out.println(demo.isValid);
        System.out.println(demo.stringToInt("888888888888888888888"));
        System.out.println(demo.isValid);
    }
}
