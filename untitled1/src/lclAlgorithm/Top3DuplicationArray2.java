package lclAlgorithm;

import java.util.ArrayList;

public class Top3DuplicationArray2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3, 2, 6, 7};
        ArrayList<Integer> dup = new ArrayList<Integer>();
        if (getDuplication(array, dup)) {
            System.out.println("duplication num is " + dup.get(0));
        } else {
            System.out.println("no duplication num ");
        }


    }

    private static boolean getDuplication(int[] array, ArrayList<Integer> dup) {
        if (array.length == 0) {
            return false;
        }
        int start = 1; //1～8-1 之间
        int end = array.length - 1; // 8-1
        System.out.println("end" + end);
        while (end >= start) {
            int middle = (end - start) / 2 + start;// 7-1/2+1 = 4 1-4 5-7
            int count = countRange(array, start, middle);
            if (end == start) {
                if (count > 1) {
                    dup.add(start);
                    return true;
                }
                return false;
            }
            if (count > middle - start+ 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private static int countRange(int[] array, int start, int end) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= end) {
                ++count;
            }
        }
        return count;
    }
}
