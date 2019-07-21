package goodluck;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Stack;

public class Top34FindPath {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void findPath(TreeNode root, int target) {
        if(root == null)
            return;
        ArrayList<Integer> array = new ArrayList<Integer>();
        printPath(root, target, array);
    }
    public void printPath(TreeNode root, int target, ArrayList<Integer> array) {
        if(root == null)
            return;
        array.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            for(Integer integer : array)
                System.out.println(integer);
            System.out.println();
        }
        if(root.left != null) {
            printPath(root.left, target, array);
        }
        if(root.right != null) {
            printPath(root.right, target, array);
        }
        array.remove(array.size()-1);
    }
    public void test() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1. right = node5;
        findPath(node1, 22);
    }

    public static void main(String[] args) {
        Top34FindPath demo = new Top34FindPath();
        demo.test();
    }
}
