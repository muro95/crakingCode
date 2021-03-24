package stack;

/*Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific substack.*/

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class stackOfPlates {

    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public  int capacity;
    public stackOfPlates(int capacity){
        this.capacity = capacity;
    }
    public Stack getLastStack(){
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size() -1);
    }

    public void push(int v){
        Stack last = getLastStack();
//        if(last != null && !last.isFull()){
//            last.push(v);
//        }else{
//            Stack stack = new Stack(capacity);
//            stack.push(v);
//            stacks.add(stack);
//        }
    }
    public int pop(){
        Stack last = getLastStack();
        if(last == null) throw new EmptyStackException();
//      int v = last.pop();
        int v =1;
//        if(last.size == 0 ){
//            stacks.remove(stacks.size()-1);
//        }
        return v;
    }

}
