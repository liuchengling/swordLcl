package goodluck;

import java.util.LinkedList;
import java.util.Stack;

public class Top32TreeUpToDown {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void printTreeUpToDown(TreeNode root) {
        if(root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.offer(root);
        while (queue.size() != 0) {
            node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        System.out.println();
    }
    public void printTreeUpToDown2(TreeNode root) {
        if(root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.offer(root);
        int present = 0;
        int next = 1;
        while (queue.size() != 0) {
            present = next;
            next = 0;
            for(int i = 1; i <= present; i++) {
                node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null) {
                    queue.offer(node.left);
                    next++;
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    next++;
                }
            }
            System.out.println();
        }
    }
    public void printTreeUpToDown3(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node;
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                node = stack1.pop();
                System.out.print(node.val + " ");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            System.out.println();
            while (!stack2.empty()) {
                node = stack2.pop();
                System.out.print(node.val + " ");
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            System.out.println();
        }
    }

    public void test() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
        printTreeUpToDown2(node1);

    }

    public static void main(String[] args) {
        Top32TreeUpToDown demo = new Top32TreeUpToDown();
        demo.test();
    }
}
