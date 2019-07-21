package goodluck;

public class Top5replaceSpace {
    public static String replace(StringBuffer str){
        int length = str.length();
        if(str == null || length<=0)
            return null;
        for(int i=0;i< str.length();i++) {
            if (str.charAt(i) == ' ') {
                length += 2;
            }
        }
        int indexOriginal = str.length() - 1;
        str.setLength(length);
        int indexNew = length - 1;
        while (indexNew>indexOriginal){
            if(str.charAt(indexOriginal) != ' ')
                str.setCharAt(indexNew--,str.charAt(indexOriginal));
            else {
                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }
            indexOriginal--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println("str = " + replace(stringBuffer));
    }
}
