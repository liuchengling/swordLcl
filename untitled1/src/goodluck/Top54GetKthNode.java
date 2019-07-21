package goodluck;

public class Top54GetKthNode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    int index = 0;
    public TreeNode kthNode(TreeNode root, int k) {
        if(root==null || k<=0)
            return root;
        TreeNode kthNode = getKthNode(root, k);
        return kthNode;
    }
    public TreeNode getKthNode(TreeNode root, int k) {
        TreeNode target = null;
        if(root.left!=null)
            target = getKthNode(root.left, k);
        if(target==null) {
            index++;
            if(k==index)
                return root;
        }
        if(target==null && root.right!=null)
            target = getKthNode(root.right, k);
        return target;
    }
    public void test() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode target = kthNode(node1,6);
        System.out.println(target.val);
    }

    public static void main(String[] args) {
        Top54GetKthNode demo = new Top54GetKthNode();
        demo.test();
    }
}
