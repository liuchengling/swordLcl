package goodluck;

public class Top37Serialize {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("$,");
        } else {
            sb.append(root.val+",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }
    int index=0;
    private TreeNode Deserialize(String str) {
        TreeNode root = null;
        if(str==null || str.length()==0)
            return null;
        int start = index;
        while (str.charAt(index)!=',') {
            index++;
        }
        if(!str.substring(start,index).equals("$")) {
            root = new TreeNode(Integer.parseInt(str.substring(start,index)));
            index++;
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        } else {
            index++;
        }
        return root;
    }
    private void printTree(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
    private void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node4;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        String str = Serialize(node1);
        System.out.println(str);
        System.out.println();
        TreeNode node = Deserialize(str);
        printTree(node);
    }

    public static void main(String[] args) {
        Top37Serialize demo = new Top37Serialize();
        demo.test();
    }
}
