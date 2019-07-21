package goodluck;

public class Top17PrintToMax {
    public void printMax(int n){
        if(n<=0)
            return;
        char[] number=new char[n];
        for(int i=0;i<n;i++)
            number[i]='0';
        while (!increase(number)){
            Print(number);
        }
    }

    public boolean increase(char[] number){
        int flag=0;
        int sum;
        for(int i=number.length-1;i>=0;i--){
            sum = number[i]-'0'+flag;
            if(i==number.length-1)
                sum++;
            if(sum>=10){
                if(i==0)
                    return true;
                flag=1;
                sum-=10;
                number[i]='0';
            } else {
                number[i] = (char)(sum + '0');
                break;
            }
        }
        return false;
    }
    public void Print(char[] number){
        boolean isBeginning0=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning0 && (number[i] - '0')!=0)
                isBeginning0=false;
            if(!isBeginning0)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    //方法二
    public void printMax2(int n){
        if(n<=0)
            return;
        char[] number= new char[n];
        for(int i=0;i<n;i++)
            number[i]='0';
        for(int i=0;i<10;i++){
            number[0] = (char)(i + '0');
            printFunc2(number,n,0);
        }
    }
    public void printFunc2(char[] number,int length,int index){
        if(index==length-1){
            Print(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index+1] = (char)(i+'0');
            printFunc2(number,length,index+1);
        }
    }

    public void test(){
        printMax2(2);
    }

    public static void main(String[] args) {
        Top17PrintToMax demo = new Top17PrintToMax();
        demo.test();
    }
}
