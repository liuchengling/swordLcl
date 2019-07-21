package lclAlgorithm;

public class Top4Find {
    public static void main(String[] args) {
        int[][] array = {{
                1, 2, 8, 9
        }, {
                2, 3, 9, 12
        }, {
                4, 7, 10, 13
        }, {
                6, 8, 11, 15
        }};
        int num = 8;
        System.out.println("find Num:" + num);
        if (find(array, num)) {
            System.out.println("finded Num");
        } else {
            System.out.println("not finded");
        }

    }

    public static boolean find(int[][] array, int num) {
        if (array == null || array.length <= 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;

        int row = 0;
        int column = columns - 1;
        //  从右上角开始找； 往左下角移动row++,column--
        while (row < rows && column > 0) {
            if (array[row][column] == num) {
                return true;
            } else if (array[row][column] > num) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
