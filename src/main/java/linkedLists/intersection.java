package linkedLists;

/* Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.*/

public class intersection {

    static class LinkedListNode{
        int data;
       LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
        public LinkedListNode(){

        }
    }
    static class Result{
        public LinkedListNode tail;
        public int size;
        public Result(LinkedListNode tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }

    //Process:
    //1. Run through each linked list to get the lengths and the tails
    //2. Compare the tails if they are different return immediately as there is no intersection
    //3. Set two pointers to the start of each linked list
    //4. on the longer linked list, advance its pointer by difference in lengths.
    //5 Now, traverse on each linked list until the pointers are the same

    public LinkedListNode findIntersection (LinkedListNode l1, LinkedListNode l2){
        if(l1 == null || l2 == null){
            return null;
        }

        //get tail and sizes
        Result result1 = getTailAndSize(l1);
        Result result2 = getTailAndSize(l2);

        //If different tail nodes, then these is no intersection
        if(result1.tail != result2.tail){
            return  null;
        }

        //Set pointer to the start of each linked list
        LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
        LinkedListNode longer = result1.size < result2.size? l2 : l1;

        //Advance the pointer for longer linked list by difference in lengths
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        //Move both pointers until you have a collision
        while(shorter != longer){
            shorter =shorter.next;
            longer = longer.next;
        }

        //return either one
        return longer;
    }

    public Result getTailAndSize(LinkedListNode list){
        if(list == null){
            return null;
        }
        int size = 1;
        LinkedListNode current = list;
        while (current.next != null){
            size++;
            current=current.next;
        }
        return new Result(current,size);
    }
    public LinkedListNode getKthNode(LinkedListNode head, int k){
        LinkedListNode current = head;
        while(k > 0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }

}
