package fanxing;

public class roadChange {

    public static void main(String[] args) {

        Integer[] list = new Integer[]{5, 8, 10, 12};
        Integer[] list0 = new Integer[]{2, 5, 6, 9, 13, 15};
        Integer[] list1 = new Integer[]{2, 5, 6, 7, 9, 19, 20, 22};
        Integer[] list2 = new Integer[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        Integer[] list3 = new Integer[]{1, 2, 3, 4, 5, 10, 15};
//        Integer[] list3 = new Integer[]{4,10,16};
        int length = 4;
        int k = 3;
        int length0 = 6;
        int k0 = 3;
        int length1 = 8;
        int k1 = 3;
        int length2 = 10;
        int k2 = 2;
        int length3 = list3.length;
        int k3 = 3;
        getMinRoad(list, length, k);
        getMinRoad(list0, length0, k0);
        getMinRoad(list1, length1, k1);
        getMinRoad(list2, length2, k2);
        getMinRoad(list3, length3, k3);


    }


    public static void sortRoad(Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1])  //交换两数位置
                {
                    Integer temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }


    public static int getMinRoad(Integer[] list, int length, int k) {
        int num = 0;
        boolean[] use = new boolean[list[length - 1] + 1];
        for (int i = 0; i < length; i++) {
            if (use[list[i]])
                continue;
            use[list[i]] = true;
            num++;

            int big = 1;
            int no = 0;
            if (i + 1 < length && i > 0) {
                for (int tempK = k - 1; tempK > 0; tempK--) {
                    if (use[list[i] - tempK]) {
                        big = -1;
                        no++;
                    }
                }

                if (no != k - 1 && (list[i] - list[i - 1] >= list[i + 1] - list[i]) && k > list[i + 1] - list[i])
                    big = 1;
            }
            if (i + 1 == length)
                big = -1;
            for (int b = 0; b < k; b++) {
                if (list[i] + b * big < list[length - 1] && list[i] + b * big > list[0] && !use[list[i] + b * big]) {
                    use[list[i] + b * big] = true;
                    System.out.println("=====" + list[i] + "====" + (list[i] + b * big));
                    num++;
                }
            }
        }

        System.out.println(num);
        return num;
    }
}
