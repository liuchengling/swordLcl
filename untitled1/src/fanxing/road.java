package fanxing;

import java.util.ArrayList;
import java.util.List;

public class road {

    public static void main(String[] args) {

        Integer[] list = new Integer[]{5, 8, 10, 12}; //7
        Integer[] list0 = new Integer[]{2, 5, 6, 9, 13, 15}; //11
        Integer[] list1 = new Integer[]{2, 5, 6, 7, 9, 19, 20, 22}; //12
        Integer[] list2 = new Integer[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18}; //15


        Integer[] list3= new Integer[]{1, 2, 3, 4, 5, 10, 15};
//        Integer[] list3 = new Integer[]{1, 2, 3, 4, 7,10, 13};
        int length = 4;
        int k = 13;
        int length0 = 6;
        int k0 = 3;
        int length1 = 8;
        int k1 = 3;
        int length2 = 10;
        int k2 = 2;
        int length3 = 5;
        int k3 = 3;

        getMinRoad(list, length, k);
        getMinRoad(list0, length0, k0);
        getMinRoad(list1, length1, k1);
        getMinRoad(list2, length2, k2);
        getMinRoad(list3, list3.length, k3);


    }

    public static List<Integer> getMinRoad(Integer[] list, int length, int k) {

        List<Integer> use = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (use.contains(list[i]))
                continue;
            use.add(list[i]);

            int big = 1;
            int no = 0;

            if (i + 1 < length && i > 0) {
                for (int tempK = k - 1; tempK > 0; tempK--) {
                    if (list[i] - tempK > 0 && use.contains(list[i] - tempK)) {
                        no++;
                        big = -1;
                    }
                }
                if (no != k - 1 && (list[i] - list[i - 1] >= list[i + 1] - list[i]) && k > list[i + 1] - list[i])
                    big = 1;

            }
            if (i + 1 == length)
                big = -1;
            for (int b = 0; b < k; b++) {
                if (!use.contains(list[i] + b * big) && list[i] + b * big>list[0]&&list[i] + b * big < list[length - 1]) {
                    use.add(list[i] + b * big);
                    System.out.println("===use====="+list[i]+"====="+(list[i]+b*big));
                }
            }
        }

        System.out.println(use);
        System.out.println(use.size());
        return use;
    }
}
