package leetcodeByCategory.collection.list;

import java.util.LinkedList;

public class StackTest {

  private LinkedList l = new LinkedList();
  public void push(Object obj) {
    l.addFirst(obj);
  }
  public Object top() {
    return l.getFirst();
  }
  public Object pop() {
    return l.removeFirst();
  }

  public static void main(String[] args) {
    StackTest s = new StackTest();
    s.push(5);
    s.push(1);
    s.push(3);
    s.push(9);
    s.push(7);
    System.out.println("The top element of the stack is: " + s.pop());
    System.out.println("The stack element that is popped is: " + s.pop());
    System.out.println("The stack element that is popped is: " + s.pop());
    System.out.println("The top element of the stack is: " + s.top());
  }

}
