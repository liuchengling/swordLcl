package goodluck;

public class Top68LowestParent {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        private TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 以下两种方法感觉都有问题，前提是node1、node2一定是树中的节点。
     */
    private static TreeNode getLowestParent(TreeNode root, TreeNode node1, TreeNode node2){
        while (true) {
            if(root==null)
                return root;
            if(root.val<node1.val&&root.val<node2.val)
                root=root.right;
            else if(root.val>node1.val&&root.val>node2.val)
                root=root.right;
            else
                return root;
        }
    }

    private static TreeNode getLowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2){
        if(root==null || root==node1 || root==node2)
            return root;
        TreeNode left = getLowestCommonParent(root.left, node1, node2);
        TreeNode right = getLowestCommonParent(root.right, node1, node2);
        return left==null? right:right==null? left:root;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;
        System.out.println(getLowestParent(node1, node6, node7).val);
        System.out.println(getLowestCommonParent(node1, node6, node7).val);
    }
}
