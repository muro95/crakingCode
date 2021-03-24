package stack;

/*How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. */


import java.util.Stack;

public class stackMin extends Stack<Integer>{

    // We can use an additional stack to keep track of the mins
    Stack<Integer> s2;
    public stackMin(){
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if(value <= min()){
            s2.push(value);
        }
        super.push(value);
    }
    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }
    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }
    }
}
