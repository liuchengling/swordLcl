package lclAlgorithm;

public class Top8FindTreeNext {

    public static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("a");
        TreeNode nodeB = new TreeNode("b");
        TreeNode nodeD = new TreeNode("d");
        TreeNode nodeH = new TreeNode("h");
        TreeNode nodeE = new TreeNode("e");
        TreeNode nodeI = new TreeNode("i");
        TreeNode nodeF = new TreeNode("f");
        TreeNode nodeC = new TreeNode("c");
        TreeNode nodeG = new TreeNode("g");

        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeD.parent = nodeB;
        nodeB.parent = root;
        nodeB.right = nodeE;
        nodeE.parent = nodeB;
        nodeH.parent = nodeE;
        nodeI.parent = nodeE;
        nodeC.parent = root;
        nodeF.parent = nodeC;
        nodeG.parent = nodeC;
        nodeE.left = nodeH;
        nodeE.right = nodeI;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
        TreeNode next = getNext(nodeF);
        if (next != null) {
            System.out.println(next.val);
        } else {
            System.out.println("no next node");
        }
    }

    public static TreeNode getNext(TreeNode find) {
        if (find == null) {
            return null;
        }
        //中序遍历：左父右
        TreeNode next = null;
        // 右节点不是空
        if (find.right != null) {
            find = find.right; //1。右节点是下一个
            while (find.left != null) { //2。 有左节点，向下找最左节点
                find = find.left;
            }
            return find;
        }
        // 右节点是空
        while (find.parent != null) {
            if (find == find.parent.left) { //4。向上找是左节点的父亲
                return find.parent;
            }
            find = find.parent; // 3。父节点是下一个
        }
        return next;
    }
}
