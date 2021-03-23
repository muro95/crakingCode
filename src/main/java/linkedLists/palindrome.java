package linkedLists;

import java.util.Stack;

/* implement a function to check if a linked list is a palindrome */
public class palindrome {

    static class LinkedListNode{
        int data;
        LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
        public LinkedListNode(){

        }
    }
    //sol 1: Reverse and compare

    boolean isPalindrome (LinkedListNode head){
        LinkedListNode reversed = reverseAndCline(head);
        return isEqual(head, reversed);
    }

    LinkedListNode reverseAndCline(LinkedListNode node){
        LinkedListNode head = null;
        while (node != null){
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(LinkedListNode one, LinkedListNode two){
        while( one != null && two != null){
            if(one.data != two.data){
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    //sol 2 Iterative Approach

    boolean isPalindrome2(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        //push element from first half of linked list onto stack.
        //When fast runner runner the end of the linked list, then we know we're at the middle
        //(fast 2x speed slow)

        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow=slow.next;
            fast=fast.next.next;
        }

        //Odd number of element, so skip the middle element
        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            int top = stack.pop().intValue();

            if(top != slow.data){
                return false;
            }
            slow =slow.next;
        }
        return true;
    }


}
