package com.epam.vilgodskiy.courses.algorithms_and_data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListService {

    //2.1 (30 минут)
    public List<Integer> deleteDuplicatesWithBuffer(List<Integer> processingList) {
        List<Integer> uniqueList = new LinkedList<>();
        return processingList.stream().filter(elem -> {
            if (uniqueList.contains(elem)) {
                return false;
            }
            uniqueList.add(elem);
            return true;
        }).collect(Collectors.toList());
    }

    //Только для списков, где реализован метод "remove" и не выбрасывает Exception
    public void deleteDuplicatesWithoutBuffer(LinkedList<Integer> processingList) {
        LinkedList<Integer> indexesForDeleting = new LinkedList<>(processingList);
        for (int i = 0; i < processingList.size() - 1; i++) {
            for (int j = i + 1; j < processingList.size(); j++) {
                if (processingList.get(i).equals(processingList.get(j))) {
                    processingList.remove(j);
                }
            }
        }
    }

    //2.4 (45 минут)
    //Только для списков, где реализован метод "remove" и не выбрасывает Exception
    public void replaceAround(List<Integer> processingList, int basicValue) {
        Integer splitIndex = null;
        for (int i = 0; i < processingList.size(); i++) {
            if (splitIndex == null) {
                if (processingList.get(i) >= basicValue) {
                    splitIndex = i;
                }
            } else {
                if (processingList.get(i) < basicValue) {
                    processingList.add(splitIndex, processingList.get(i));
                    processingList.remove(i + 1);
                }
            }
        }
    }

    //2.5 (45 минут)
    public List<Integer> sum(List<Integer> first, List<Integer> second) {
        List<Integer> maxList = first.size() >= second.size() ? first : second;
        List<Integer> minList = maxList.equals(first) ? second : first;
        List<Integer> sumList = new ArrayList<>(maxList.size() + 1);
        int plusExtra = 0;
        for (int i = 0; i < maxList.size(); i++) {
            int sum;
            if (minList.size() >= i + 1) {
                sum = maxList.get(i) + minList.get(i) + plusExtra;
            } else {
                sum = maxList.get(i) + plusExtra;
            }
            sumList.add(sum % 10);
            plusExtra = sum / 10;
        }
        if (plusExtra != 0) {
            sumList.add(plusExtra);
        }
        return sumList;
    }

    //2.6 (10 минут)
    public boolean isPalindrome(List<Integer> processingList) {
        for (int i = 0; i < processingList.size() / 2; i++) {
            if (!processingList.get(i).equals(processingList.get(processingList.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
