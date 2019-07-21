package goodluck;

public class Top43TimesOf1 {
    private static int timesOf1(int n) {
        int count = 0;
        for(int i=1;i<=n;i*=10) {
            int high = n/(i*10);
            int cur = (n/i)%10;
            int low = n%i;
            if(cur==0) {
                count += high*i;
            } else if (cur==1) {
                count += high*i + (low+1);
            } else {
                count += (high+1)*i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(timesOf1(21235));
    }
}
