package linkedLists;
/*Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8*/

public class partition {
    static class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
    }
    //iterate through linked list then insert elements into before list or after list.
    //Then merge at the end
    public LinkedListNode partition( LinkedListNode node, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null){
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x){
                //insert node into end of before list
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }else{
                // insert node into end of after list
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = node;
                    afterEnd= node;
                }
            }
            node = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        //merge before and after
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //sol 2: if we dont care abt making the elements of list "stable", then we can
    //rearrange the element by growing the list at the head and tail

    public LinkedListNode partition2(LinkedListNode node, int x){
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null){
            LinkedListNode next = node.next;
            if(node.data < x){
                //insert node at head
                node.next = head;
                head = node;
            }else{
                //insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }
}
