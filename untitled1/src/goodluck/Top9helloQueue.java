package goodluck;

import java.util.Stack;

public class Top9helloQueue {
    public class Queue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int i){
            stack1.push(i);
        }

        public int pop(){
            if(stack2.empty()){
                if(stack1.empty())
                    System.out.println("empty");
                else {
                    while (!stack1.empty())
                        stack2.push(stack1.pop());
                }

            }
            return stack2.pop();
        }

        public boolean empty(){
            if(!stack1.empty() || !stack2.empty())
                return false;
            else
                return true;
        }
    }

    public void test(){
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        while(!queue.empty())
            System.out.println(queue.pop());
    }

    public static void main(String[] args) {
        Top9helloQueue que = new Top9helloQueue();
        que.test();
    }
}
