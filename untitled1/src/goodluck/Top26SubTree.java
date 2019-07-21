package goodluck;

public class Top26SubTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean hasTree(TreeNode farther, TreeNode son){
        boolean flag = false;
        if(farther != null && son != null){
            if(farther.val == son.val)
                flag = isSubTree(farther, son);
            if(!flag)
                flag = hasTree(farther.left, son);
            if(!flag)
                flag = hasTree(farther.right, son);
        }
        return flag;
    }
    public boolean isSubTree(TreeNode farther, TreeNode son){
        if(son == null)
            return true;
        if(farther == null)
            return false;
        if(farther.val != son.val)
            return false;
        return isSubTree(farther.left, son.left) && isSubTree(farther.right, son.right);
    }
    public void Print(TreeNode node){
        if(node!=null){
            System.out.println(node.val);
            Print(node.left);
            Print(node.right);
        }
    }
    public void test(){
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(7);
        TreeNode m1 = new TreeNode(8);
        TreeNode m2 = new TreeNode(9);
        TreeNode m3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n7;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        n4.right = n6;
        m1.left = m2;
        m1.right = m3;
        Print(n1);
        System.out.println("==============");
        Print(m1);
        System.out.println(hasTree(n1,m1));
    }

    public static void main(String[] args) {
        Top26SubTree demo = new Top26SubTree();
        demo.test();
    }
}
