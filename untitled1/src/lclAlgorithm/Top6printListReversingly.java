package lclAlgorithm;

import java.util.Stack;

public class Top6printListReversingly {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node.next = node2;
        node2.next = node3;
        printListReverse(node);
        print(node);
    }

    // 递归
    private static void print(Node node) {
        if (node != null) {
            print(node.next);
            System.out.println("digui:"+ node.key);
        }
    }

    private static void printListReverse(Node node) {
        Stack<Node> stack = new Stack(); // stack要标记类型
        if (node == null) {
            return;
        }
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().key);
        }
    }


    static class Node {
        // 要定义成static
        int key;
        Node next;


        public Node(int key) {
            this.key = key;
//            this.next=null;
        }
    }
}
