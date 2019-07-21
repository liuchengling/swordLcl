package goodluck;

public class Top35CloneLinkNodes {
    class ComplexLinkNode{
        char val;
        ComplexLinkNode next;
        ComplexLinkNode sibling;

        public void setVal(char val) {
            this.val = val;
        }
    }
    private void insertNode(ComplexLinkNode head) {
        ComplexLinkNode node = head;
        while(node!=null) {
            ComplexLinkNode clone = new ComplexLinkNode();
            clone.val = node.val;
            clone.next = node.next;
            clone.sibling = null;

            node.next = clone;
            node = clone.next;
        }
    }
    private void cloneSibling(ComplexLinkNode head) {
        ComplexLinkNode node = head;
        while (node!=null) {
            ComplexLinkNode clone = node.next;
            if(node.sibling!=null) {
                clone.sibling = node.sibling.next;
            }
            node = clone.next;
        }
    }
    private ComplexLinkNode seprateNode(ComplexLinkNode head) {
        ComplexLinkNode node = head;
        ComplexLinkNode cloneHead = null;
        ComplexLinkNode cloneNode = null;
        if(node!=null) {
            cloneHead = cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node!=null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }
    private ComplexLinkNode cloneLinkNodes(ComplexLinkNode head) {
        insertNode(head);
        cloneSibling(head);
        return seprateNode(head);
    }
    private void printLinkNodes(ComplexLinkNode head) {
        if(head == null) {
            return;
        }
        ComplexLinkNode node = head;
        while(node!=null) {
            System.out.print("this = " + node.val + " ");
            if(node.next!=null) {
                System.out.print("next = " + node.next.val + " ");
            }
            if(node.sibling!=null) {
                System.out.print("sibling = " + node.sibling.val);
            }
            System.out.println();
            node = node.next;
        }
    }
    private void test() {
        ComplexLinkNode node1 = new ComplexLinkNode();
        ComplexLinkNode node2 = new ComplexLinkNode();
        ComplexLinkNode node3 = new ComplexLinkNode();
        ComplexLinkNode node4 = new ComplexLinkNode();
        ComplexLinkNode node5 = new ComplexLinkNode();
        node1.setVal('A');
        node2.setVal('B');
        node3.setVal('C');
        node4.setVal('D');
        node5.setVal('E');
        node1.next = node2;
        node1.sibling = node3;
        node2.next = node3;
        node2.sibling = node5;
        node3.next = node4;
        node4.next = node5;
        node4.sibling = node2;
        printLinkNodes(node1);
        System.out.println("==================");
        ComplexLinkNode clone = cloneLinkNodes(node1);
        printLinkNodes(clone);
    }

    public static void main(String[] args) {
        Top35CloneLinkNodes demo = new Top35CloneLinkNodes();
        demo.test();
    }
}
