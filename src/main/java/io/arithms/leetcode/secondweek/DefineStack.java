package io.arithms.leetcode.secondweek;

public class DefineStack {

    private static int capacity;
    private static int top;
    private int[] stack;
    private int[] minStack;
    /** initialize your data structure here. */
    public DefineStack() {
        capacity = 10;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int data) {
        if(! isFull()){
            stack[++top] = data;
        }else{
            System.out.println("Stack is full");
        }
    }

    public void pop() {
        if(!isEmpty()){
            int popVal = stack[top--];
        }else{
            System.out.println("Stack is empty");
        }
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return 0;
    }

    public static boolean isEmpty(){
        return (top == -1);
    }
    public static boolean isFull(){
        return (top == capacity-1);
    }

    public static void main(String[] args) {
        DefineStack ms = new DefineStack();
        ms.push(10);
        ms.pop();
        ms.getMin();
    }
}
