package goodluck;

public class Top23FindCircleNode {
    class LinkNode{
        int val;
        LinkNode next;
        public LinkNode(int val){
            this.val = val;
        }
    }
    LinkNode meetingNode(LinkNode head){
        if(head == null)
            return null;
        LinkNode pSlow = head;
        if(pSlow.next==null)
            return null;
        LinkNode pFast = pSlow.next;

        while (pSlow!=null && pFast!=null){
            if(pFast == pSlow)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast!=null)
                pFast = pFast.next;
        }
        return null;
    }
    LinkNode findEntrance(LinkNode head){
        if(head == null)
            return null;
        LinkNode meetingNode = meetingNode(head);
        if(meetingNode==null)
            return null;

        int count = 1;
        LinkNode pIndex = meetingNode.next;
        while(pIndex!=meetingNode){
            pIndex = pIndex.next;
            count++;
        }

        LinkNode p1 = head;
        for(int i = 0;i<count;i++)
            p1=p1.next;
        LinkNode p2 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
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
        node6.next = node3;
        LinkNode nodek = findEntrance(node1);
        if(nodek == null)
            System.out.println("No point");
        else
            System.out.println(nodek.val);
    }

    public static void main(String[] args) {
        Top23FindCircleNode demo = new Top23FindCircleNode();
        demo.test();
    }
}
