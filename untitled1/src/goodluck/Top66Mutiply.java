package goodluck;

public class Top66Mutiply {
    private static int[] mutiply(int[] A) {
        if(A==null || A.length<2)
            return null;
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<A.length;i++)
            B[i] = B[i-1] * A[i-1];
        int temp = 1;
        for(int i=A.length-2;i>=0;i--) {
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {-1,3,1,-2,9};
        int[] B = mutiply(A);
        if(B==null)
            return;
        for(int i:B)
            System.out.println(i);
    }
}
