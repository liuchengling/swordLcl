package goodluck;

public class Top25Merge {
    class LinkNode{
        int val;
        LinkNode next;
        public LinkNode(int val){
            this.val = val;
        }
    }
    public LinkNode Merge(LinkNode pHead1, LinkNode pHead2){
        if(pHead1 == null)
            return pHead2;
        if(pHead2 == null)
            return pHead1;

        LinkNode pMerge = null;
        if(pHead1.val < pHead2.val){
            pMerge = pHead1;
            pMerge.next = Merge(pHead1.next, pHead2);
        } else {
            pMerge = pHead2;
            pMerge.next = Merge(pHead1, pHead2.next);
        }
        return pMerge;
    }
    public void test(){
        LinkNode[] linkNodes = new LinkNode[9];
        for(int i=0;i<9;i++)
            linkNodes[i] = new LinkNode(i);
        linkNodes[1].next = linkNodes[3];
        linkNodes[3].next = linkNodes[5];
        linkNodes[5].next = linkNodes[7];
        linkNodes[2].next = linkNodes[4];
        linkNodes[4].next = linkNodes[6];
        linkNodes[6].next = linkNodes[8];
        LinkNode merge = Merge(linkNodes[2],null);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public static void main(String[] args) {
        Top25Merge demo = new Top25Merge();
        demo.test();
    }
}
