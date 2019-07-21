package goodluck;

public class Top12Path {
    public boolean path(char[][] a,char[] p){
        int row = a.length;
        int colum = a[0].length;
        if(a==null||row<=0)
            return false;
        for(int i=0;i<row;i++)
            if(a[i].length!=colum)
                return false;
        boolean[][] flag = new boolean[row][colum];
        for(int i=0;i<row;i++)
            for (int j=0;j<colum;j++)
                flag[i][j] = false;
        for(int i=0;i<row;i++)
            for (int j=0;j<colum;j++)
                if(a[i][j]==p[0])
                    if(find(a,p,0,i,j,row,colum,flag))
                        return true;
        return false;
    }
    public boolean find(char[][] a,char[] p,int index,int i,int j,int row,int colum,boolean[][] flag){
        if(i<0 || j<0 || i>=row || j>=colum || flag[i][j]==true || a[i][j]!= p[index])
            return false;
        if(p.length-1==index)
            return true;
        flag[i][j] = true;
        boolean path = find(a,p,index+1,i-1,j,row,colum,flag) || find(a,p,index+1,i+1,j,row,colum,flag)
                || find(a,p,index+1,i,j-1,row,colum,flag) || find(a,p,index+1,i,j+1,row,colum,flag);
        if(!path)
            flag[i][j]=false;
        return path;
    }

    public void test(){
        char[][] a = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        char[] p = {'a','c','f','c'};
        System.out.println(path(a,p));
    }

    public static void main(String[] args) {
        Top12Path demo = new Top12Path();
        demo.test();
    }
}
