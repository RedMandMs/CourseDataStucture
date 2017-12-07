package com.epam.vilgodskiy.courses.algorithms_and_data;

import java.util.Stack;

//3.5 (1 час)
public class StackSorter {

    public <T extends Comparable<T>> void sort(Stack<T> processingStack) {
        int sortedElementsCount = 0;
        Stack<T> tempStack = new Stack<>();
        T topSortedElem = null;
        while (!processingStack.isEmpty()) {
            T localMin = processingStack.pop();
            while (!processingStack.isEmpty()) {
                T elem = processingStack.pop();
                if (topSortedElem != null && elem.compareTo(topSortedElem) == 0) {
                    tempStack.push(localMin);
                    localMin = elem;
                    break;
                }
                if (elem.compareTo(localMin) < 0) {
                    tempStack.push(localMin);
                    localMin = elem;
                } else {
                    tempStack.push(elem);
                }
            }
            topSortedElem = localMin;
            while (tempStack.size() > sortedElementsCount) {
                processingStack.push(tempStack.pop());
            }
            tempStack.push(localMin);
            sortedElementsCount++;
        }
        while (!tempStack.isEmpty()) {
            processingStack.push(tempStack.pop());
        }
    }
}
