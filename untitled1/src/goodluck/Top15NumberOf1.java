package goodluck;

public class Top15NumberOf1 {
    //常规解法
    public int func1(int origin){
        int sum=0;
        int flag=1;
        while(flag!=0){
            if((origin&flag)!=0)
                sum+=1;
            flag=flag<<1;
        }
        return sum;
    }
    //惊喜算法
    public int func2(int origin){
        int sum=0;
        while(origin!=0){
            sum++;
            origin = (origin-1)&origin;
        }
        return sum;
    }
    public void test(){
        System.out.println(func1(0x80));
    }

    public static void main(String[] args) {
        Top15NumberOf1 demo = new Top15NumberOf1();
        demo.test();
    }
}
