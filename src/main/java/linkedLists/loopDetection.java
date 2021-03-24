package linkedLists;

/*Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input: A - > B - > C - > D - > E - > C [the same C as earlier]
Output: C*/
public class loopDetection {
    //An easy way to detect if a linked list has a loop is through the FastRunner/SlowRunner
    //approach. As FR run 2 steps and SR one step.
    //So now we know that SR is 0 steps into the loop
    //FR is K steps into the loop
    //SR is K steps behind the loop
    //FR is loopSize - K steps behind SlowRunner (they will meet after loopSize 0 K steps)
    //FR catches up to SR at a rate of 1 step per unit of time
    //The head of linked list if also k nodes from the front of the loop. So, if we keep on pointer
    //where it is, and move the other pointer to the head of the linked list, then they will
    //meet at the front of the loop
    //1. Create two pointer, FR and SR
    //2. Move FP at rate of 2 and SP at rate of 1
    //When they collide, move SP to LinkedListHead. Keep FP where it is.
    //Move SP and FP at a rate of one step. Return the new collision point

    public class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
        public LinkedListNode(){

        }
    }
    public LinkedListNode findLoop(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //find meeting point
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        //check if there is no loop
        if(fast == null || fast.next == null){
            return null;
        }

        //move slow to head. Each are k steps from the loop start. if they move
        //at the same pace, they must meet at Loop Start
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
