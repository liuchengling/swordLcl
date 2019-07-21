package goodluck;

public class Top27Mirror {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public void mirror(TreeNode node){
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.left != null)
            mirror(node.left);
        if(node.right != null)
            mirror(node.right);
    }
    public void printOrigin(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            printOrigin(node.left);
            printOrigin(node.right);
        }
    }
    public void printMirror(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            printMirror(node.right);
            printMirror(node.left);
        }
    }
    public void test(){
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;
        printOrigin(node1);
        System.out.println("=================");
        printMirror(node1);
        System.out.println("=================");
        mirror(node1);
        printOrigin(node1);
    }

    public static void main(String[] args) {
        Top27Mirror demo = new Top27Mirror();
        demo.test();
    }
}
