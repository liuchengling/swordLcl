package goodluck;

public class Top16Powder {
    public double Powder(double origin,int ex){
        if(origin==0)
            return 0;
        if(ex>=0){
            return powderCore(origin,ex);
        }else{
            return 1/powderCore(origin,-ex);
        }
    }
    public double powderCore(double origin,int ex){
        if(ex==1)
            return origin;
        if(ex==0)
            return 1;
        /**常规
        double result=origin;
        return result*powderCore(origin,ex-1);
         */
        //二分相乘
        double result = powderCore(origin,ex>>1);
        result *= result;
        //判断是否为奇数
        if((ex&0x1)==1)
            result *= origin;
        return result;
    }
    public void test(){
        System.out.println(Powder(-2,-3));
    }

    public static void main(String[] args) {
        Top16Powder demo = new Top16Powder();
        demo.test();
    }
}
