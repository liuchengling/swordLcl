package goodluck;

import java.util.ArrayDeque;

public class Top59QueueWithMax {
    ArrayDeque<InternalData> queue = new ArrayDeque<InternalData>();
    ArrayDeque<InternalData> max = new ArrayDeque<InternalData>();
    private class InternalData {
        int index;
        int number;
        public InternalData(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    private int index = 0;
    private void push(int number) {
        InternalData curData = new InternalData(index, number);
        queue.addLast(curData);
        while (!max.isEmpty() && curData.number>max.getLast().number)
            max.removeLast();
        max.addLast(curData);
        index++;
    }
    private void pop() {
        if(queue.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = queue.removeFirst();
        if(!max.isEmpty() && curData.index==max.getFirst().index)
            max.removeFirst();
    }
    private int getMax() {
        if(max.isEmpty()) {
            System.out.println("Error");
            return 0;
        }
        return max.getFirst().number;
    }

    public static void main(String[] args) {
        Top59QueueWithMax q = new Top59QueueWithMax();
        q.push(3);
        System.out.println(q.getMax());
        q.push(1);
        System.out.println(q.getMax());
        q.pop();
        System.out.println(q.getMax());
        q.push(5);
        System.out.println(q.getMax());
        q.pop();
        System.out.println(q.getMax());
        q.pop();
        System.out.println(q.getMax());
    }
}
