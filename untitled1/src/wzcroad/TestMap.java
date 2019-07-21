package wzcroad;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    MyEntry[] arr = new MyEntry[990];
    int size;

    public void put(Object key, Object value) {
        MyEntry m = new MyEntry(key, value);
        for(int i=0;i<size;i++)
            if(arr[i].key.equals(key)) {
                arr[i].value = value;
                return;
            }
        arr[size++] = m;
    }

    public Object get(Object key) {
        for(int i=0;i<size;i++)
            if(arr[i].key.equals(key))
                return arr[i].value;
        return null;
    }

    public void remove(Object key) {
        for(int i=0;i<size;i++)
            if(arr[i].key.equals(key)) {
                arr[i] = arr[size-1];
                arr[size-1] = null;
                return;
            }
    }

    public static void main(String[] args) {
        TestMap tm = new TestMap();
        tm.put("aaa","bbb");
        tm.put("aaa","ccc");
        //tm.remove("aaa");
        Map m = new HashMap();
        System.out.println(tm.get("aaa"));
    }
}

class MyEntry {
    Object key;
    Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
