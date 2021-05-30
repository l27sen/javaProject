package com.scotiabank.riskmanagement.testcdoe.queue;


/**
 * top 记录index 最后加入元素的位置
 * size 记录array 大小
 * @param <E>
 */
    public class StackByArray<E> {
        private E[] arr = null;
        private int CAP;
        private int top = -1;
        private int size = 0;

        @SuppressWarnings("unchecked")
        public StackByArray(int cap) {
            this.CAP = cap;
            this.arr = (E[]) new Object[cap];
        }

        public E pop() {
            if(this.size == 0){
                return null;
            }
            this.size--;
            E result = this.arr[top];
            this.arr[top] = null;//prevent memory leaking
            this.top--;
            return result;
        }

        public boolean push(E e) {
            if (isFull())
                return false;

            this.size++;
            this.arr[++top] = e;

            return true;
        }

        public boolean isFull() {
            if (this.size == this.CAP)
                return false;
            return true;
        }

        public String toString() {
            if(this.size==0){
                return null;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<this.size; i++){
                sb.append(this.arr[i] + ", ");
            }

            sb.setLength(sb.length()-2);
            return sb.toString();
        }

        public static void main(String[] args) {

            StackByArray<String> stack = new StackByArray<String>(11);
            stack.push("hello");
            stack.push("world");

            System.out.println(stack);

            stack.pop();
            System.out.println(stack);

            stack.pop();
            System.out.println(stack);
        }
}
