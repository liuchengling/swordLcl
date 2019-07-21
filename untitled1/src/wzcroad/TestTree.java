package wzcroad;

public class TestTree {
    private static TreeNode getNext(TreeNode root) {
        TreeNode current = root;
        if(current.right!=null) {
            current = current.right;
            while (current.left!=null)
                current = current.left;
            return current;
        } else if(current.parent!=null) {
            current = current.parent;
            while (current.parent!=null && current == current.parent.right)
                current = current.parent;
            if(current == current.parent.left)
                return current.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode('a');
        TreeNode node2 = new TreeNode('b');
        TreeNode node3 = new TreeNode('c');
        TreeNode node4 = new TreeNode('d');
        TreeNode node5 = new TreeNode('e');
        node1.left = node2;
        node1.right = node3;
        node3.parent = node1;
        node2.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        TreeNode res = getNext(node5);
        System.out.println(res.val);
    }
}

class TreeNode {
    char val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
