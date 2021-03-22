package linkedLists;

/*Implement an algorithm to find the kth to last element of a singly linked list.*/

public class returnKthToLast {

    static class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
    }

    public static void main(String[] args){

    }

    //if the size of the linked list is known then the kth to last element if (length -k)
    //element
    //Sol 1 : Using recursive
    public static int printKth(LinkedListNode head, int k){
        if (head == null){
            return  0;
        }
        int index = printKth(head.next,k) + 1;
        if(index == k){
            System.out.println(k + "th to the last node is" + head.data);
        }
        return index;
    }
    //sol 2: using iterative. Using two pointer p1 and p2
    //place them k nodes apart in the linkedList by putting p2 at the
    //beginning and moving p1 k nodes into the list. Then when we move them at the same place,
    //p1 will hit the end of the linked list after Length -k steps.
    //At that point, p2 will be length -k nodes into the list, or k nodes from the end.

    public static LinkedListNode nthToLast(LinkedListNode head, int k){

        if(head == null || k < 1){
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;


        for(int i = 0; i < k; i++){
            if(p1 == null){
                return null;
            }
            p1 = p1.next;
        }
        //move both pointers at the same. When p1 hits the end, p2 will be at the right element
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
