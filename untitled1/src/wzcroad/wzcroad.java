package wzcroad;

import java.util.Arrays;

public class wzcroad {

    static int result = 0;

    public static Integer[] delete(Integer[] list, int num) {
        Integer[] newlist = new Integer[list.length - 1];
        for(int i = 0; i < list.length - 1; i++)
            if(i < num)
                newlist[i] = list[i];
            else
                newlist[i] = list[i + 1];
        return newlist;
    }

    public static Integer[] cut(Integer[] list, Integer[] listDone){
        for(int i = 0; i <= list.length - 1; i++)
            if(list[i] <= listDone[1] || list[i] >= listDone[2]) {
                list = delete(list, i);
                i = -1;
            }
        return list;
    }

    public static void DFS(Integer[] list,Integer[] listDone, int k) {
        /**
         * 1. 另起炉灶
         *    a. 如果k大于等于总长度，直接+k
         *    b. 否则瘦身+初始listDone，DFS;
         * 2. 如果两边挨不上，另起炉灶；
         *
         */
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(listDone));

        int start = list[0];
        int last  = list[list.length - 1];

        if(listDone[0] == start && listDone[3] == last) {
            if(last - start + 1 <= k) {
                result = result + k;
            } else {
                listDone[1] = start + k - 1;
                listDone[2] = last - k + 1;
                list = cut(list, listDone);
                if(listDone[2] - listDone[1] > 1) {
                    result = result + k * 2;
                    if(list.length != 0)
                        DFS(list, listDone, k);
                } else
                    result = result + (last - start + 1);
            }
        } else if(start - listDone[1] >= k && listDone[2] - last >= k) {
            listDone[0] = start;
            listDone[1] = start;
            listDone[2] = last;
            listDone[3] = last;
            if(list.length != 0)
                DFS(list, listDone, k);
        } else {
            System.out.println("还没写好呢！");
        }
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{1, 5, 6, 9};
        int k = 3;

        int start = list[0];
        int last = list[list.length - 1];
        Integer[] listDone = new Integer[]{start, start, last, last};

        DFS(list, listDone, k);
        System.out.println("The minValue is : " + result);
    }
}
