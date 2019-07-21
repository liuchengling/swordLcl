package goodluck;

public class Fibonacci {
    public int getF(int n) {
        if(n<0)
            return -1;
        if(n == 0)
            return 0;
        if(n==1)
            return 1;
        int pre=1;
        int prepre=0;
        int result=0;
        for(int i=2;i<=n;i++){
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }
        return result;
    }
    public void test(){
        System.out.println(getF(6));
    }

    public static void main(String[] args) {
        Fibonacci demo = new Fibonacci();
        demo.test();
    }
}

/**
 * https://www.cnblogs.com/yongh/p/9804934.html
 */
