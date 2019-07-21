package goodluck;

public class Top52FindFirstNode {
    private static class LinkNode {
        int val;
        LinkNode next;
        public LinkNode(int val) {
            this.val = val;
        }
    }
    private static int getLength(LinkNode head) {
        if(head==null)
            return 0;
        int count = 0;
        LinkNode index = head;
        while (index!=null) {
            count++;
            index = index.next;
        }
        return count;
    }
    private static LinkNode fun1(LinkNode node1, LinkNode node2) {
        int len1 = getLength(node1);
        int len2 = getLength(node2);
        int diff = len1 - len2;
        LinkNode longLink = node1;
        LinkNode shortLink = node2;
        if(diff<0) {
            longLink = node2;
            shortLink = node1;
            diff = -diff;
        }
        for(int i=0;i<diff;i++)
            longLink = longLink.next;
        while (longLink!=shortLink) {
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        return longLink;
    }
    private static LinkNode fun2(LinkNode node1, LinkNode node2) {
        LinkNode p1 = node1;
        LinkNode p2 = node2;
        while (p1!=p2) {
            if(p1!=null) p1 = p1.next;
            if(p2!=null) p2 = p2.next;
            if(p1!=p2) {
                if(p1==null) p1 = node2;
                if(p2==null) p2 = node1;
            }
        }
        return p1;
    }
    private static void test() {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);
        LinkNode node7 = new LinkNode(7);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node3.next = node6;
        node5.next = node6;
        node6.next = node7;
        System.out.println(fun1(node1,node4).val);
        System.out.println(fun2(node1,node4).val);
    }

    public static void main(String[] args) {
        test();
    }
}
