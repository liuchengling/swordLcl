package goodluck;

public class Top4findErweishuzu {
    private static int[] findnum(int[][] matrix, int num) {
        int[] index = {-1, -1};

        if (matrix == null || matrix.length <= 0)
            return index;
        int rows = matrix.length;
        int colums = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i].length != colums)
                return index;
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j == 0)
                    break;
                if (i == 0) {
                    if (matrix[i][j] < matrix[i][j - 1])
                        return index;
                } else if (j == 0) {
                    if (matrix[i][j] < matrix[i - 1][j])
                        return index;
                } else if (matrix[i][j] < matrix[i - 1][j] || matrix[i][j] < matrix[i][j - 1]) {
                    return index;
                }
            }
        }

        int row = 0;
        int colum = colums - 1;
        while (row < rows && colum >= 0) {
            System.out.println("num = " + num + "x = " + row + "y = " + colum);
            if (matrix[row][colum] == num) {
                index[0] = row;
                index[1] = colum;
                return index;
            } else if (matrix[row][colum] > num) {
                colum--;
            } else {
                row++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[] index = findnum(matrix, 7);
        System.out.println("x=" + index[0] + "y=" + index[1]);
    }
}
