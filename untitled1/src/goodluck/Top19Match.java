package goodluck;

public class Top19Match {
    public boolean matchPattern(char[] str,char[] pattern){
        if(str==null || pattern==null)
            return false;
        return matchCore(str,0,pattern,0);
    }
    public boolean matchCore(char[] str,int indexOfStr,char[] pattern,int indexOfPattern){
        if(str.length==indexOfStr && pattern.length==indexOfPattern)
            return true;
        if(str.length>indexOfStr && pattern.length==indexOfPattern)
            return false;
        if(indexOfPattern+1<pattern.length && pattern[indexOfPattern+1]=='*'){
            if(pattern[indexOfPattern]=='.' || str[indexOfStr]==pattern[indexOfPattern])
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2)
                            || matchCore(str, indexOfStr + 1, pattern, indexOfPattern)
                            || matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2);
            else
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2);

        }
        if((str[indexOfStr] == pattern[indexOfPattern] && str.length>indexOfStr) || pattern[indexOfPattern]=='.')
            return matchCore(str,indexOfStr+1,pattern,indexOfPattern+1);
        return false;
    }
    public void test(){
        char[] str = {'1'};
        char[] pattern = {'.'};
        System.out.println(matchPattern(str,pattern));
    }

    public static void main(String[] args) {
        Top19Match demo = new Top19Match();
        demo.test();
    }
}
