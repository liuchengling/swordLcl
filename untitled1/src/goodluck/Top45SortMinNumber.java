package goodluck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Top45SortMinNumber {
    private static String sortMinNumber(int[] num) {
        if(num==null || num.length<=0)
            return null;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<num.length;i++)
            list.add(String.valueOf(num[i]));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s:list)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] num = {2,12,321};
        System.out.println(sortMinNumber(num));
    }
}
