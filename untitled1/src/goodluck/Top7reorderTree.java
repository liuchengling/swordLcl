package goodluck;

public class Top7reorderTree {
    public class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }

    }

    public Tree reconstruct(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length)
            return null;
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public Tree construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        Tree root = new Tree(pre[pStart]);
        if (pStart == pEnd && iStart == iEnd) {
            if (pre[pStart] != in[iStart])
                throw new RuntimeException("Error");
            return root;
        }
        int index = iStart;
        while (in[index] != root.val && index < iEnd) {
            index++;
        }
        int length = index - iStart;
        if (length > 0) {
            root.left = construct(pre, in, pStart + 1, pStart + length, iStart, iStart + length - 1);
        }
        if (iEnd - index > 0) {
            root.right = construct(pre, in, pStart + length + 1, pEnd, index + 1, iEnd);
        }
        return root;
    }

    public void prePrint(Tree node) {
        if (node == null)
            return;
        System.out.println("pre " + node.val);
        prePrint(node.left);
        prePrint(node.right);
    }

    public void inPrint(Tree node) {
        if (node == null)
            return;
        inPrint(node.left);
        System.out.println("in " + node.val);
        inPrint(node.right);
    }

    private void test() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Tree root = reconstruct(pre, in);
        prePrint(root);
        inPrint(root);
    }

    public static void main(String[] args) {
        Top7reorderTree demo = new Top7reorderTree();
        demo.test();
    }
}
