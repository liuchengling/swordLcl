package goodluck;

import java.util.ArrayList;
import java.util.Collections;

public class Top38SortString {
    private ArrayList<String> sortString(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0)
            return list;
        sortString(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }
    private void sortString(char[] ch, int index, ArrayList<String> list) {
        if(index==ch.length-1) {
            if(!list.contains(String.valueOf(ch)))
                list.add(String.valueOf(ch));
        } else {
            for(int i=index; i<ch.length;i++) {
                char temp = ch[index];
                ch[index] = ch[i];
                ch[i] = temp;
                sortString(ch, index+1, list);
                ch[i] = ch[index];
                ch[index] = temp;
            }
        }
    }
    private void test() {
        String str = "aac";
        ArrayList<String> list = sortString(str);
        for(String s:list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Top38SortString demo = new Top38SortString();
        demo.test();
    }
}
