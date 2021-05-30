package com.scotiabank.riskmanagement.testcdoe.other;

import java.util.Stack;

/**
 * queue a->b->c,
 */
public class QueueByTwoStack {
    Stack<String> inputStack = new Stack();
    Stack<String> outStack = new Stack();

    private void put(String a){
        inputStack.add(a);
    }

    /**
     * get all element from inputstack and put them to outPutStack.
     * @return
     */
    private String getFromQueue(){
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        while (!inputStack.isEmpty()){
            outStack.push(inputStack.pop());
        }
        return outStack.peek();
    }
}
