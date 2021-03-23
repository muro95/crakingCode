package linkedLists;

/*Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
Inout:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b ->d ->e->f*/

public class deleteMiddleNode {
    static class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
    }
    // copy data from next node to current node then delete the next node
    // Note that this problem cannot be solved if the node to be deleted is the last node
    public boolean deleteNode(LinkedListNode n){
        if(n == null || n.next == null){
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = n.next.next;
        return true;
    }
}
