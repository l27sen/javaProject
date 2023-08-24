package leetcodeByCategory.queue;


/**
 * stack 只需要处理top节点
 */
public class MyStack {

    Node top;

    public Node peek(){
        if(top != null){
            return top;
        }

        return null;
    }

    public Node pop(){
        if(top == null){
            return null;
        }else{
            Node temp = new Node(top.val);
            //第一个出来了，指针下一个
            top = top.next;
            return temp;
        }
    }

    public void push(Node n){
        if(n != null){
            n.next = top;
            top = n;
        }
    }

    public static void main(String[] a){
        MyStack stack = new MyStack();
        stack.push(new Node(1));
        stack.push(new Node(2));

        System.out.println("stack value:"+stack.peek().val);


    }
}
