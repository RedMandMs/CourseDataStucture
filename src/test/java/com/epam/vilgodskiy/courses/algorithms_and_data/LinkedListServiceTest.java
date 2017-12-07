package com.epam.vilgodskiy.courses.algorithms_and_data;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

import static org.junit.Assert.*;

public class LinkedListServiceTest {

    private LinkedListService linkedListService;

    @Before
    public void beforeTests() {
        linkedListService = new LinkedListService();
    }

    @Test
    public void deleteDuplicatesWithBuffer() {
        assertThat(Arrays.asList(1, 2, 3, 4, 5),
                is(linkedListService.deleteDuplicatesWithBuffer(Arrays.asList(1, 1, 2, 1, 3, 2, 4, 2, 5))));
        assertThat(Arrays.asList(1, 2, 3, 4, 5),
                is(linkedListService.deleteDuplicatesWithBuffer(Arrays.asList(1, 2, 3, 4, 5))));
        assertThat(Arrays.asList(1, 3, 4, 5),
                is(linkedListService.deleteDuplicatesWithBuffer(Arrays.asList(1, 1, 3, 4, 4, 5, 5))));
        assertThat(Collections.emptyList(),
                is(linkedListService.deleteDuplicatesWithBuffer(Collections.emptyList())));
    }

    @Test
    public void deleteDuplicatesWithoutBuffer() {
        LinkedList<Integer> processingList = new LinkedList<>(Arrays.asList(1, 1, 2, 1, 3, 2, 4, 2, 5));
        linkedListService.deleteDuplicatesWithoutBuffer(processingList);
        assertThat(Arrays.asList(1, 2, 3, 4, 5),
                is(processingList));
        processingList = new LinkedList<>(Arrays.asList(1, 1, 3, 4, 4, 5, 5));
        linkedListService.deleteDuplicatesWithoutBuffer(processingList);
        assertThat(Arrays.asList(1, 3, 4, 5),
                is(processingList));
        processingList = new LinkedList<>();
        linkedListService.deleteDuplicatesWithoutBuffer(processingList);
        assertThat(Collections.emptyList(), is(processingList));
    }

    @Test
    public void replaceAround() {
        checkReplacement(new LinkedList<>(Arrays.asList(1, 1, 2, 3, 2, 4, 2, 1, 5)), 3);
        checkReplacement(new LinkedList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 5)), 5);
        checkReplacement(new LinkedList<>(), 5);
        checkReplacement(new LinkedList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 5)), 5);
        checkReplacement(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4)), 5);
    }

    private void checkReplacement(List<Integer> processingList, int basicValue) {
        linkedListService.replaceAround(processingList, basicValue);
        boolean splitIndexFound = false;
        for (Integer value : processingList) {
            if (value >= basicValue) {
                splitIndexFound = true;
            }
            if (splitIndexFound) {
                assertThat(value, greaterThanOrEqualTo(basicValue));
            } else {
                assertThat(value, lessThan(basicValue));
            }
        }
    }

    @Test
    public void sum() {
        assertTrue(new LinkedList<>(Arrays.asList(2, 1, 9)).equals(
                linkedListService.sum(new LinkedList<>(Arrays.asList(7, 1, 6)),
                        new LinkedList<>(Arrays.asList(5, 9, 2)))));
        assertTrue(new LinkedList<>(Arrays.asList(8, 9, 9, 1)).equals(
                linkedListService.sum(new LinkedList<>(Arrays.asList(9, 9, 9)),
                        new LinkedList<>(Arrays.asList(9, 9, 9)))));
        assertTrue(new LinkedList<>(Arrays.asList(0, 0, 0, 1)).equals(
                linkedListService.sum(new LinkedList<>(Arrays.asList(9, 9, 9)),
                        new LinkedList<>(Collections.singletonList(1)))));
        assertTrue(new LinkedList<>(Collections.singletonList(1)).equals(
                linkedListService.sum(new LinkedList<>(Collections.emptyList()),
                        new LinkedList<>(Collections.singletonList(1)))));
        assertTrue(new LinkedList<>(Arrays.asList(1, 2, 3, 4)).equals(
                linkedListService.sum(new LinkedList<>(Collections.emptyList()),
                        new LinkedList<>(Arrays.asList(1, 2, 3, 4)))));
        assertTrue(new LinkedList<>(Arrays.asList(1, 2, 3, 4)).equals(
                linkedListService.sum(new LinkedList<>(Arrays.asList(1, 2, 3, 4)),
                        new LinkedList<>(Collections.emptyList()))));
    }

    @Test
    public void isPalindrome() {
        assertTrue(linkedListService.isPalindrome(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1)));
        assertTrue(linkedListService.isPalindrome(Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1)));
        assertTrue(linkedListService.isPalindrome(Arrays.asList(1, 2, 1)));
        assertTrue(linkedListService.isPalindrome(Arrays.asList(1, 2, 2, 1)));
        assertTrue(linkedListService.isPalindrome(Collections.emptyList()));
        assertTrue(linkedListService.isPalindrome(Collections.singletonList(1)));
        assertFalse(linkedListService.isPalindrome(Arrays.asList(1, 2, 3)));
        assertFalse(linkedListService.isPalindrome(Arrays.asList(1, 2, 3, 4, 2, 1)));
    }


}