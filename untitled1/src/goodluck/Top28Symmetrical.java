package goodluck;

public class Top28Symmetrical {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isSymmetrical(TreeNode node){
        return isSymmetrical(node, node);
    }
    public boolean isSymmetrical(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        if(node1.val != node2.val)
            return false;
        return isSymmetrical(node1.left,node2.right) && isSymmetrical(node1.right,node2.left);
    }
    public void test(){
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;
        System.out.println(isSymmetrical(node1));
    }

    public static void main(String[] args) {
        Top28Symmetrical demo = new Top28Symmetrical();
        demo.test();
    }
}
