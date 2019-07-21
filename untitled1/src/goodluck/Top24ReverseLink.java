package goodluck;

public class Top24ReverseLink {
    class LinkNode{
        int val;
        LinkNode next;
        public LinkNode(int val){
            this.val = val;
        }
    }
    LinkNode reverseLink(LinkNode head){
        if(head == null)
            return null;
        LinkNode newhead = null;
        LinkNode now = head;
        LinkNode pre = null;
        while(now!=null){
            LinkNode next = now.next;
            if(next == null)
                newhead = now;
            now.next = pre;
            pre = now;
            now = next;
        }
        return newhead;
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
        System.out.println(reverseLink(node1).val);
    }
    public static void main(String[] args) {
        Top24ReverseLink demo = new Top24ReverseLink();
        demo.test();
    }
}
