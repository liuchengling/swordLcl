package goodluck;

public class Top8getTreeNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode parent = null;
        TreeLinkNode left = null;
        TreeLinkNode right = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode node) {
        if(node==null)
            return null;
        if(node.right!=null){
            node=node.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }
        while(node.parent!=null){
            if(node==node.parent.left)
                return node.parent;
            node=node.parent;
        }
        return null;
    }

    public void test(){
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.parent = node1;
        node2.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        if(getNext(node5)==null){
            System.out.println("no next node");
        } else {
            System.out.println(getNext(node5).val);
        }
    }

    public static void main(String[] args) {
        Top8getTreeNext demo = new Top8getTreeNext();
        demo.test();
    }
}
