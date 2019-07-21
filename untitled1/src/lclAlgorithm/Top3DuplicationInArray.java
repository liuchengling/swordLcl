package lclAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Top3DuplicationInArray {
    // psvm

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        ArrayList<Integer> dup = new ArrayList<Integer>();

        if (duplicate(array, dup)) {
            //sout
            System.out.println("this num is duplicate:" + dup.get(0));
        } else {
            System.out.println("no duplicate Num");
        }

    }

    private static boolean duplicate(int[] array, ArrayList<Integer> dup) {
        if (array != null && array.length <= 0) {
            System.out.println("array not exist");
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array.length-1 < array[i] || 0 > array[i]) {
                System.out.println("array not right");
                return false;

            }
        }

        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    dup.add(array[i]);
                    System.out.println("duplicate is " + dup);
                    return true;
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return false;
    }
}
