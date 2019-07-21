package fanxing;

public class road77 {
    public static Integer[] getMin(Integer[] list, int k, int... para) {
        int length = list.length;
        int begin;
        if (0 == para.length) {
            begin = 1;
        } else {
            begin = para[0];
        }
        if (2 == para.length) {
            length = para[1];
        }

        int newLen = list[length - 1];
        Integer[] an = new Integer[newLen];
        Integer[] an_be = new Integer[newLen];//接着铺
        Integer[] an_af = new Integer[newLen];//重新铺

        int i = 0;
        int j = 0;
        int para_be[] = {0, 0};  //递归首位
        int para_af[] = {0, 0};
        int n = 0;
        int s = 0;
        int t = 0;

        for (i = 0; i < newLen; i++) {
            an[i] = 0;
            an_be[i] = 0;
            an_af[i] = 0;
        }

        //开始 1.把原数组放入
        for (i = 0; i < begin; i++) {
            an[i] = list[i];
        }
        //初始段还需连续修k
        if (1 == begin) {
            for (i = 1; i < k; i++) {
                an[i] = an[i - 1] + 1;
            }
        }
        j = i - 1;//对确定要修的最后一个路段数下标

        //2.对已修路段进行遍历
        for (i = 1; i < length; i++) {
            //2.1本段已在已修路段里，继续
            if (list[i] <= an[j]) {
                continue;
            }
            //2。2本段是已修路的+1，直接铺,继续
            if (list[i] == an[j] + 1) {
                an[++j] = list[i];
                continue;
            }

            //2.3本段与已修路段间隔超过k范围
            if (list[i] > an[j] + k - 1) {
                //2.3.1本段与最后一段的间隔超过了k,可以直接往后铺
                if (list[length - 1] >= list[i] + k - 1) {
                    an[j + 1] = list[i];
                    for (s = 1; s < k; s++) {
                        an[j + 1 + s] = an[j + s] + 1;
                    }
                } else {//2.3.2否则需要从最后一段往前倒推k范围，然后铺
                    for (s = 1; s <= k; s++) {
                        an[j + s] = list[length - 1] - k + s;
                    }
                }
                j = j + k;
                continue;

            }

            //2.4本段与已修路段间隔t,在k范围内，且超过1
            t = list[i] - an[j];
            //2.4.1本段为最后一段时，可以直接铺设倒最后一段
            if (i == length - 1) {
                for (s = 1; s <= t; s++) {
                    an[j + s] = an[j + s - 1] + 1;
                }
                j = j + t;
                break;
            }

            //2.4.2本段为中间段，递归求最小， 分本段开始铺或本段重新铺两种
            for (s = 0; s <= j; s++) {
                an_be[s] = an[s];
                an_af[s] = an[s];
            }
            //2.4.2.1继续铺设到本段倒数组
            for (s = 1; s <= t; s++) {
                an_be[j + s] = an_be[j + s - 1] + 1;
            }
            para_be[0] = j + t + 1;
            n = para_be[0];
            for (s = i + 1; s < length; s++) {
                an_be[n++] = list[s];
            }
            para_be[1] = n;

            //2.4.2.2本段开始重新铺设数组赋值
            an_af[j + 1] = list[i];
            for (s = 1; s < k; s++) {
                an_af[j + 1 + s] = an_af[j + s] + 1;
            }
            para_af[0] = j + k + 1;
            n = para_af[0];
            for (s = i + 1; s < length; s++) {
                if (list[s] <= an_af[j + k]) {
                    continue;
                }
                an_af[n++] = list[s];
            }
            para_af[1] = n;


            //2.4.2.3比较长度，短的留下
            if (getMin(an_be, k, para_be[0], para_be[1]).length < getMin(an_af, k, para_af[0], para_af[1]).length) {
                for (s = 1; s <= t; s++) {
                    an[j + s] = an[j + s - 1] + 1;
                }
                j = j + t;
            } else {
                an[j + 1] = list[i];
                for (s = 1; s < k; s++) {
                    an[j + 1 + s] = an[j + s] + 1;
                }
                j = j + k;
            }


        }

        //3最后下标+1
        j++;

        Integer[] result = new Integer[j];
        for (i = 0; i < j; i++) {
            result[i] = an[i];
        }
        return result;

    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{5, 8, 10, 12};
        Integer[] list0 = new Integer[]{2, 5, 6, 9, 13, 15};
        Integer[] list1 = new Integer[]{2, 5, 6, 7, 9, 19, 20, 22};
        Integer[] list2 = new Integer[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        Integer[] list3 = new Integer[]{1, 2, 3, 4, 5, 10, 15};
//        Integer[] list3 = new Integer[]{4,10,16};
        int k = 3;
        int k0 = 3;
        int k1 = 3;
        int k2 = 2;
        int k3 = 3;
        Integer[] result;
        result = getMin(list, k);
        print(result);
        result=getMin(list0, k0);
        print(result);

        result= getMin(list1, k1);
        print(result);

        result=getMin(list2, k2);
        print(result);
        result =  getMin(list3, k3);
        print(result);
    }

    public static void print(Integer[] result) {
        int length = result.length;
        for (int i = 0; i < length; i++) {
            System.out.printf("," + result[i]);
        }
        System.out.printf("total" + length+"\n");
    }
}
