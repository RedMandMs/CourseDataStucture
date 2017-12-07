package com.epam.vilgodskiy.courses.algorithms_and_data;

import java.util.EmptyStackException;
import java.util.Stack;

//3.2 (1 час)
public class MyStack<T extends Comparable<T>> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;
    private Stack<T> mins = new Stack<>();

    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        if(item.compareTo(min()) == 0){
            mins.pop();
        }
        return item;
    }

    public void push(T data){
        StackNode<T> newTop = new StackNode<>(data);
        newTop.next = top;
        top = newTop;
        if(mins.isEmpty() || data.compareTo(min()) <= 0){
            mins.push(data);
        }
    }

    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public T min(){
        if (top == null) throw new EmptyStackException();
        return mins.peek();
    }

    public void clear(){
        top = null;
        mins.clear();
    }
}
