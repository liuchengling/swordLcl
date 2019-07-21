package goodluck;

public class Top55TreeDepth {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int getDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left>right)?(left+1):(right+1);
    }
    private boolean isBalanced(TreeNode root, int[] index) {
        if(root==null) {
            index[0] = 0;
            return true;
        }
        int[] left = {0};
        int[] right = {0};
        if(isBalanced(root.left, left) && isBalanced(root.right, right) && left[0]==right[0]) {
            index[0] = left[0] + 1;
            return true;
        }
        return false;
    }
    private void test3(int[] a) {
        a[0]++;
    }
    private void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node1.right = node3;
        node3.right = node6;
        System.out.println(getDepth(node1));
    }
    private void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        int[] a = {0};
        System.out.println(isBalanced(node1,a));
        System.out.println(a[0]);
    }

    public static void main(String[] args) {
        Top55TreeDepth demo = new Top55TreeDepth();
        //demo.test();
        demo.test2();
    }
}
