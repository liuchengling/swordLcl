package wzcroad;

import java.util.HashMap;

public class SxtHashSet {

    HashMap map;
    private static final Object PRESENT = new Object();

    public SxtHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);// set 不可重复 利用map的键对象不可重复
    }

    public static void main(String[] args) {

        SxtHashSet s = new SxtHashSet();
        s.add("aaa");
        System.out.println(s.size());
    }


}
