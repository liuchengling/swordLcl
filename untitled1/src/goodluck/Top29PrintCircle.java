package goodluck;

public class Top29PrintCircle {
    public void whenPrintCircle(int[][] number, int rows, int cols) {
        if (number == null || rows <= 0 || cols <= 0)
            return;
        int start = 0;
        while (rows > start * 2 && cols > start * 2){
            howToPrint(number, rows, cols, start);
            start++;
        }
    }
    public void howToPrint(int[][] number, int rows, int cols, int start) {
        int endX = rows - 1 - start;
        int endY = cols - 1 - start;

        for (int i = start; i<= endY; i++)
            System.out.print(number[start][i] + " ");

        if (endX > start) {
            for (int i = start + 1; i <= endX;i ++)
                System.out.print(number[i][endY] + " ");
        }

        if (endX > start && endY > start) {
            for (int i = endY - 1; i >= start; i--)
                System.out.print(number[endX][i] + " ");
        }

        if (endX > start + 1 && endY > start) {
            for (int i = endX - 1; i >= start + 1;i --)
                System.out.print(number[i][start] + " ");
        }
    }
    public void test() {
        int[][] number = new int[7][7];
        fillMatrix(number,7,7);
        printNormal(number, 7, 7);
        System.out.println();
        whenPrintCircle(number,7,7);
    }
    public void fillMatrix(int[][] number, int rows, int cols) {
        if (rows <= 0 || cols <= 0)
            return;
        int n = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                number[i][j] = n;
                n++;
            }
    }
    public void printNormal(int[][] number, int rows, int cols) {
        if (number == null || rows <= 0 || cols <= 0)
            return;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(number[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Top29PrintCircle demo = new Top29PrintCircle();
        demo.test();
    }
}
