package com.epam.vilgodskiy.courses.algorithms_and_data;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class StackSorterTest {

    private StackSorter stackSorter = new StackSorter();

    @Test
    public void sortStack() {
        Stack<Integer> processingStack = new Stack<>();
        processingStack.push(3);
        processingStack.push(2);
        processingStack.push(5);
        processingStack.push(1);
        processingStack.push(7);
        processingStack.push(0);
        stackSorter.sort(processingStack);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(7);
        expectedStack.push(5);
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);
        expectedStack.push(0);
        assertTrue(expectedStack.equals(processingStack));
    }

    @Test
    public void sortStackWithRepetition() {
        Stack<Integer> processingStack = new Stack<>();
        processingStack.push(3);
        processingStack.push(2);
        processingStack.push(5);
        processingStack.push(1);
        processingStack.push(2);
        processingStack.push(7);
        processingStack.push(0);
        processingStack.push(3);
        stackSorter.sort(processingStack);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(7);
        expectedStack.push(5);
        expectedStack.push(3);
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(2);
        expectedStack.push(1);
        expectedStack.push(0);
        assertTrue(expectedStack.equals(processingStack));
    }

    @Test
    public void sortSortedStack() {
        Stack<Integer> processingStack = new Stack<>();
        processingStack.push(7);
        processingStack.push(5);
        processingStack.push(3);
        processingStack.push(2);
        processingStack.push(1);
        processingStack.push(0);
        stackSorter.sort(processingStack);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(7);
        expectedStack.push(5);
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);
        expectedStack.push(0);
        assertTrue(expectedStack.equals(processingStack));
    }

    @Test
    public void sortReverseStack() {
        Stack<Integer> processingStack = new Stack<>();
        processingStack.push(0);
        processingStack.push(1);
        processingStack.push(2);
        processingStack.push(3);
        processingStack.push(5);
        processingStack.push(7);
        stackSorter.sort(processingStack);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(7);
        expectedStack.push(5);
        expectedStack.push(3);
        expectedStack.push(2);
        expectedStack.push(1);
        expectedStack.push(0);
        assertTrue(expectedStack.equals(processingStack));
    }

    @Test
    public void sortEmptyStack() {
        Stack<Integer> processingStack = new Stack<>();
        stackSorter.sort(processingStack);
        assertTrue(new Stack<>().equals(processingStack));
    }
}