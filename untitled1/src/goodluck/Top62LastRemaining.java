package goodluck;

import java.util.LinkedList;

public class Top62LastRemaining {
    private static int fun1(int n, int m) {
        if(n<1 || m<1)
            return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int removeIndex = 0;
        while(list.size()>1) {
            removeIndex = (removeIndex+m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.getFirst();
    }

    private static int fun2(int n, int m) {
        if(n<1 || m<1)
            return -1;
        int last = 0;
        for(int i=2;i<=n;i++)
            last = (last+m)%i;
        return last;
    }

    public static void main(String[] args) {
        System.out.println(fun1(6,3));
        System.out.println(fun2(6,3));
    }
}
