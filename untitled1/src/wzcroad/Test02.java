package wzcroad;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcde");
        System.out.println(sb.delete(3,4).deleteCharAt(2).insert(1,"u").indexOf("u"));
        System.out.println(sb);
    }
}
