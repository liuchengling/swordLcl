package goodluck;

import java.util.Stack;

public class Top6linknodeReverse {
    static class linkNode{
        int key;
        linkNode next;

        public linkNode(int key){
            this.key = key;
            this.next = null;
        }
    }

    //栈
    public static void func1(linkNode node){
        Stack<linkNode> stack = new Stack<linkNode>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().key);
        }
    }

    //递归
    public static void func2(linkNode node){
        if(node!=null){
            func2(node.next);
            System.out.println(node.key);
        }
    }

    public void test(){
        linkNode node1 = new linkNode(1);
        linkNode node2 = new linkNode(2);
        linkNode node3 = new linkNode(3);
        linkNode node4 = new linkNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //func2(node1);
        func1(node1);
    }

    public static void main(String[] args) {
        Top6linknodeReverse demo = new Top6linknodeReverse();
        demo.test();
    }
}
