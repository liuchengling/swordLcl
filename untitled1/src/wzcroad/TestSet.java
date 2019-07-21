package wzcroad;

import java.util.*;

public class TestSet {
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add("aaa");

        set.add("bbb");
        set.add(new String("aaa"));
        System.out.println(set.size());
        System.out.println(set.contains("aaa"));
        set.remove("bbb");
        System.out.println(set.size());
    }
}
