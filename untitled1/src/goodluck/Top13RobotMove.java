package goodluck;

public class Top13RobotMove {
    public int move(int rows,int cols,int k){
        if(rows<=0 || cols<=0 || k<0)
            return 0;
        boolean[][] flag = new boolean[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                flag[i][j]=false;
        int count = canMove(rows,cols,0,0,k,flag);
        return count;
    }
    public int canMove(int rows,int cols,int row,int col,int k,boolean[][] flag){
        if(row<0||col<0||row>=rows||col>=cols || flag[row][col]==true || cal(row) + cal(col) > k)
            return 0;
        flag[row][col] = true;
        return 1 + canMove(rows,cols,row-1,col,k,flag) + canMove(rows,cols,row+1,col,k,flag)
                + canMove(rows,cols,row,col-1,k,flag) + canMove(rows,cols,row,col+1,k,flag);
    }
    public int cal(int i){
        int sum=0;
        while(i!=0){
            sum = sum + i%10;
            i = i/10;
        }
        return sum;
    }
    public void test(){
        System.out.println(move(4,1,3));
    }

    public static void main(String[] args) {
        Top13RobotMove demo = new Top13RobotMove();
        demo.test();
    }
}
