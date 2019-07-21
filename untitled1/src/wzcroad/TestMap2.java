package wzcroad;

import java.util.LinkedList;

public class TestMap2 {
    int size;
    LinkedList[] linkedLists = new LinkedList[999];

    public void put(Object key, Object value) {
        Entry m = new Entry(key, value);
        int a = Math.abs(key.hashCode() % linkedLists.length);
        if (linkedLists[a] == null) {
            LinkedList list = new LinkedList();
            list.add(m);
            linkedLists[a] = list;
        } else {
            linkedLists[a].add(m);
        }
    }

    public Object get(Object key) {
        //return linkedLists[key.hashCode() % 999];
        int a = Math.abs(key.hashCode() % linkedLists.length);
        if (linkedLists[a] != null) {
            LinkedList list = linkedLists[a];
            for (int i = 0; i < list.size(); i++) {
                Entry e = (Entry) list.get(i);
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TestMap2 tm2 = new TestMap2();
        tm2.put("xiaohua", "beautiful");
        System.out.println(tm2.get("xiaohua"));
    }
}

class Entry {
    Object key;
    Object value;

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}