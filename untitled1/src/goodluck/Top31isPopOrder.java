package goodluck;

import java.util.Stack;

public class Top31isPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if(pushA == null || popA == null)
            return false;
        if(pushA.length != popA.length || pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        for(int pushIndex = 0; pushIndex<pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while(!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public void test() {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,2,3,1};
        System.out.println(isPopOrder(pushA,popA));
    }

    public static void main(String[] args) {
        Top31isPopOrder demo = new Top31isPopOrder();
        demo.test();
    }
}
