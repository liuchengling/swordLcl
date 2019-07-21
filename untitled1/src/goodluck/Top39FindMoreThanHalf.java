package goodluck;

public class Top39FindMoreThanHalf {
    private int findMoreThanHalf(int[] array) {
        if(array==null||array.length==0)
            return 0;

        int start = 0;
        int end = array.length-1;
        int index = partition(array,start,end);
        while (index!=array.length>>1) {
            if(index<array.length>>1) {
                start = index + 1;
                index = partition(array,start,end);
            } else {
                end = index - 1;
                index = partition(array,start,end);
            }
        }

        int middle = array[index];
        int times = 0;
        for (int i=0; i<array.length; i++)
            if(array[i]==middle)
                times++;
        if(times*2>array.length)
            return middle;
        return 0;
    }
    private int partition(int[] array, int low, int high) {
        int random = array[low];
        while (low<high) {
            while (low<high && array[high]>=random)
                high--;
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            while (low<high && array[low]<=random)
                low++;
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        return low;
    }

    private void test1() {
        int[] array = {1,2,3,2,2,5,5,4,3};
        System.out.println(findMoreThanHalf(array));
    }
    private void test2() {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(findMoreThanHalf2(array));
    }

    public static void main(String[] args) {
        Top39FindMoreThanHalf demo = new Top39FindMoreThanHalf();
        demo.test1();
        demo.test2();
    }

    private int findMoreThanHalf2(int[] array) {
        if(array==null || array.length==0)
            return 0;
        int result = array[0];
        int times = 1;
        for(int i=1;i<array.length;i++) {
            if(times==0) {
                result = array[i];
                times = 1;
            } else if(result==array[i])
                times++;
            else
                times--;
        }

        if(times>0) {
            times = 0;
            for (int i = 0; i < array.length; i++)
                if (array[i] == result)
                    times++;
            if (times * 2 > array.length)
                return result;
        }
        return 0;
    }
}
