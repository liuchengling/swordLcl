package goodluck;

public class Top20IsNum {
    public boolean isNumtric(char[] str){
        if(str==null)
            return false;
        int[] index = new int[1];
        index[0] = 0;
        boolean isNumUntil;
        //判断A
        isNumUntil = isInteger(str,index);
        //判断B
        if(index[0]<str.length && str[index[0]]=='.'){
            index[0]++;
            isNumUntil = isUnsignedInteger(str,index) || isNumUntil;
        }
        //判断C
        if(index[0]<str.length && (str[index[0]]=='e' || str[index[0]]=='E')){
            index[0]++;
            isNumUntil = isInteger(str,index) && isNumUntil;
        }
        if(str.length==index[0] && isNumUntil)
            return true;
        else
            return false;

    }
    public boolean isInteger(char[] str,int[] index){
        if(index[0]<str.length && (str[index[0]]=='+' || str[index[0]]=='-'))
            index[0]++;
        return isUnsignedInteger(str,index);
    }
    public boolean isUnsignedInteger(char[] str,int[] index){
        int start = index[0];
        while(index[0]<str.length && str[index[0]]>='0' && str[index[0]]<='9')
            index[0]++;
        if(index[0]>start)
            return true;
        else
            return false;
    }

    public void test(){
        char[] ch = {'+','9','.','0','e','-','9'};
        System.out.println(isNumtric(ch));
    }

    public static void main(String[] args) {
        Top20IsNum demo = new Top20IsNum();
        demo.test();
    }
}
