package leetcodeByCategory.jacob;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack(Stack<Integer> stack, int min){
        this.stack = stack;
        this.min = min;
    }



    public void push(int value){

        if(value<=min){
            stack.push(min);
            min = value;
        }
        stack.push(value);

    }

    public void pop(){
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
}
