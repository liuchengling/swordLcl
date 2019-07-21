package goodluck;

public class Top18_2NeedDelete {
    class LinkNode{
        int val;
        LinkNode next=null;
        public LinkNode(int val){
            this.val=val;
        }
    }
    //保留一个
    public LinkNode deleteDuplication(LinkNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        LinkNode preNode = head;
        LinkNode index = preNode.next;
        while(index!=null){
            boolean needDelete = false;
            if(index.val==preNode.val)
                needDelete = true;
            if(!needDelete){
                preNode = index;
                index = index.next;
            } else {
                int val = index.val;
                LinkNode toBeDelete = index;
                while(toBeDelete!=null&&toBeDelete.val==val){
                    toBeDelete = toBeDelete.next;
                }
                index = toBeDelete;
                preNode.next = index;
            }
        }
        return head;
    }
    //全删
    public LinkNode deleteDuplicationAll(LinkNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        LinkNode preNode = null;
        LinkNode index = head;
        while(index!=null){
            LinkNode pNext = index.next;
            boolean needDelete = false;
            if(pNext!=null&&index.val==pNext.val)
                needDelete = true;
            if(!needDelete){
                preNode = index;
                index = index.next;
            } else {
                int val = index.val;
                LinkNode toBeDelete = index;
                while(toBeDelete!=null&&toBeDelete.val==val){
                    toBeDelete = toBeDelete.next;
                }
                if(preNode==null){
                    head = toBeDelete;
                } else {
                    preNode.next = toBeDelete;
                }
                index = toBeDelete;
            }
        }
        return head;
    }
    public void test(){
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1 = deleteDuplicationAll(node1);
        LinkNode index = node1;
        while(index!=null){
            System.out.println(index.val);
            index = index.next;
        }
    }

    public static void main(String[] args) {
        Top18_2NeedDelete demo = new Top18_2NeedDelete();
        demo.test();
    }
}
