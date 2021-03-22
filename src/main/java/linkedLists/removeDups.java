package linkedLists;

/*write code to remove duplicates from an unsorted linked list
   *how would you solve this problem if a temp buffer is not allowed?*/

import java.util.HashSet;
import java.util.Set;

public class removeDups {
    static class LinkedListNode{
        int data;
       LinkedListNode next = null;
        public LinkedListNode(int value){
            this.data = value;
        }
    }
    public static void main(String[] args){

    }

//    Using hash table to check duplicate
//    Time O(N) Space O(N)
    public static void deleteDups(LinkedListNode n){
        Set<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while(n != null){
            if(set.contains(n.data)){
                previous.next = n.next;
            }else{
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    //no buffer allowed. We can iterate with two pointer: current which iterates through
    //the linked list and runner which checks all subsequent nodes for duplicate
    //Time: O(n^2) Space: O(1)
    public static void deleteDups2(LinkedListNode head){
        LinkedListNode current = head;
        while(current != null){
            LinkedListNode runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
