package goodluck;

public class findHalf {
    public static int find(int[] num){
        if(num == null || num.length<=0){
            return -1;
        }
        for(int a:num){
            if(a<0 || a>num.length-1){
                return -1;
            }
        }
        int start = 1;
        int end = num.length - 1;
        while(end>=start){
            int middle = ((end - start) >> 1) + start;
            int count = getCount(num,start,middle);
            System.out.println("middle = " + middle + "count = " + count);
            if(start == end){
                if(count > 1)
                    return start;
                else
                    break;
            }
            if(count > middle - start + 1)
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    public static int getCount(int[] num, int start, int middle){
        if(num == null)
            return -1;
        int count = 0;
        for(int a:num){
            if(a>=start && a<=middle){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = {2,3,5,4,3,2,6,7};
        System.out.println(find(num));
    }
}
