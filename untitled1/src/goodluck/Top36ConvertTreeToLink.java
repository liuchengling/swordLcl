package goodluck;

public class Top36ConvertTreeToLink {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeNode Convert(TreeNode root) {
        if(root == null)
            return root;
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        if(left!=null) {
            while (p.right!=null) {
                p = p.right;
            }
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if(right!=null) {
            root.right = right;
            right.left = root;
        }
        return left==null?root:left;
    }
    private void printTree(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    private void printLinkList(TreeNode root) {
        if(root == null)
            return;
        TreeNode p = root;
        System.out.print(p.val + " ");
        while (p.right!=null) {
            p = p.right;
            System.out.print(p.val + " ");
        }
        System.out.println();
        while (p!=null) {
            System.out.print(p.val + " ");
            p = p.left;
        }
    }
    private void test() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;
        printTree(node1);
        System.out.println();
        printLinkList(Convert(node1));
    }

    public static void main(String[] args) {
        Top36ConvertTreeToLink demo = new Top36ConvertTreeToLink();
        demo.test();
    }
}
