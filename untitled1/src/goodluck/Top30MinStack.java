package goodluck;

import java.util.Stack;

public class Top30MinStack {
    public class MinStack {
        Stack<Integer> stack_origin = new Stack<Integer>();
        Stack<Integer> stack_min = new Stack<Integer>();
        public void push(int node) {
            stack_origin.push(node);
            if(stack_min.empty() || stack_min.peek()>node) {
                stack_min.push(node);
            } else {
                stack_min.push(stack_min.peek());
            }
        }
        public void pop() {
            if(!stack_origin.empty() && !stack_min.empty()) {
                stack_origin.pop();
                stack_min.pop();
            }
        }
        public int min() {
            return stack_min.peek();
        }
    }

    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
    }

    public static void main(String[] args) {
        Top30MinStack demo = new Top30MinStack();
        demo.test();
    }

}
