package goodluck;

public class Top18DeleteLinkNode {
    class LinkNode{
        int val;
        LinkNode next=null;
        public LinkNode(int val) {
            this.val = val;
        }
    }
    public boolean isNotBelong(LinkNode origin,LinkNode delete){
        LinkNode index = origin;
        while(index!=null){
            if(index==delete)
                return false;
            index=index.next;
        }
        return true;
    }
    public LinkNode deleteNode(LinkNode origin,LinkNode delete){
        if(origin==null||delete==null||isNotBelong(origin,delete))
            throw new RuntimeException();
        //如果是首节点且只有一个节点
        if(origin==delete)
            origin=origin.next;
        //如果不是尾节点
        if(delete.next!=null) {
            delete.val=delete.next.val;
            delete.next = delete.next.next;
            return origin;
        }
        //是尾节点
        LinkNode index=origin;
        while(index!=null){
            if(index.next==delete){
                index.next=null;
            }
            index=index.next;
        }
        return origin;
    }
    public void test(){
        LinkNode node1=new LinkNode(1);
        LinkNode node2=new LinkNode(2);
        LinkNode node3=new LinkNode(3);
        node1.next=node2;
        node2.next=node3;
        node1=deleteNode(node1,node1);
        LinkNode index=node1;
        while (index!=null){
            System.out.println(index.val);
            index=index.next;
        }
    }

    public static void main(String[] args) {
        Top18DeleteLinkNode demo = new Top18DeleteLinkNode();
        demo.test();
    }
}
