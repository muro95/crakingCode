package linkedLists;

/*You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2. That is, 912.

*/
public class sumLists {
    static class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
        public LinkedListNode(){

        }
    }
    // can do this by recursive adding node by node
    public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if(l1 != null){
            value += l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }
        //get second digit of number
        result.data = value %10;

        //recurse
        if(l1 != null || l2 != null){
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                            l2 == null ? null : l2.next,
                                            value >= 10 ? 1 :0);
//            result.setNext(more);
        }
        return  result;
    }

    //Follow up question:
    //Suppose the digits are stored in forward order. Repeat the above problem.
    //Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    //Output: 9 -> 1 -> 2. That is, 912.
    //

}
