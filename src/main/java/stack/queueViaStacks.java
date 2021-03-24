package stack;

/* Implement a MyQueue class which implements a queue using two stacks.*/

import java.util.Stack;

public class queueViaStacks <T> {

    // We need to modify peek() and pop() in reverse order.
    //We can use second stack to reverse the order of the elements (by popping s1 and
    //pushing to s2. We should pop everything from s1 onto s2, perform the peek/pop operation
    //and then push everything back
    //stackNewest has the newest elements on top and stackOldest has the oldest
    //elements on top. When we dequeue an element, we want to remove the oldest element first, and so we
    //dequeue from stackOldest. If stackOldest is empty, then we want to transfer all elements from
    //stackNewest into this stack in reverse order. To insert an element, we push onto stackNewest, since it
    //has the newest elements on top.

    Stack<T> stackNewest , stackOldest;
    public queueViaStacks(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value){
        //push onto stackNewest, which always has the newest elements on top
        stackNewest.push(value);
    }

    //Move elements from stackNewest into stackOldest.
    private void shiftStack(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStack(); //ensure stackOldest has the current elements
        return stackOldest.peek();
    }
    public T remove(){
        shiftStack();
        return stackOldest.pop();
    }
}
