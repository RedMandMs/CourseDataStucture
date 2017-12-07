package com.epam.vilgodskiy.courses.algorithms_and_data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> processingStack = new MyStack<>();

    @Test
    public void min() {
        processingStack.push(3);
        processingStack.push(2);
        processingStack.push(5);
        processingStack.push(1);
        processingStack.push(7);
        processingStack.push(0);
        assertEquals(new Integer(0), processingStack.min());
        assertEquals(new Integer(0), processingStack.pop());
        assertEquals(new Integer(1), processingStack.min());
        assertEquals(new Integer(7), processingStack.pop());
        assertEquals(new Integer(1), processingStack.min());
        assertEquals(new Integer(1), processingStack.pop());
        assertEquals(new Integer(2), processingStack.min());
    }
}