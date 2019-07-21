package goodluck;

public class Top22LinkBackK {
    class LinkNode{
        int val;
        LinkNode next=null;
        public LinkNode(int val){
            this.val = val;
        }
    }
    public void printK(LinkNode node,int k){
        if(node==null||k<=0) {
            System.out.println("Error");
            return;
        }
        LinkNode head = node;
        LinkNode follow = node;
        for(int i=0;i<k-1;i++) {
            head = head.next;
            if(head==null) {
                System.out.println("Error");
                return;
            }
        }
        while(head.next!=null){
            head=head.next;
            follow=follow.next;
        }
        System.out.println(follow.val);
    }
    public void test(){
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printK(node1,7);
    }

    public static void main(String[] args) {
        Top22LinkBackK demo = new Top22LinkBackK();
        demo.test();
    }
}
