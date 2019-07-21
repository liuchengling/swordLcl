package goodluck;

public class Top33SequenceOfBST {
    public boolean sequenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length<=0)
            return false;
        return sequenceCore(sequence, 0, sequence.length - 1);
    }
    public boolean sequenceCore(int[] sequence, int start, int end) {
        if(start>=end)
            return true;
        int mid = start;
        while (sequence[mid]<sequence[end]) {
            mid++;
        }
        for(int i = mid; i < end; i++) {
            if(sequence[i] < sequence[end])
                return false;
        }
        return (sequenceCore(sequence, start, mid - 1) && sequenceCore(sequence, mid, end - 1));
    }
    public void test() {
        int[] sequence = {5,9,3,6};
        System.out.println(sequenceOfBST(sequence));
    }

    public static void main(String[] args) {
        Top33SequenceOfBST demo = new Top33SequenceOfBST();
        demo.test();
    }
}
