package com.epam.vilgodskiy.courses.algorithms_and_data;

import java.util.HashSet;
import java.util.Set;

public class ArraysAndStringsService {

    // 1.1

    public boolean hasDuplicateLettersWithSet(String word) {
        Set<Character> usedSymbols = new HashSet<Character>(word.length());
        for (int i = 0; i < word.length(); i++) {
            if (!usedSymbols.add(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicateLetters(String word) {
        char[] usedSymbols = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (char usedSymbol : usedSymbols) {
                if (usedSymbol == word.charAt(i)) {
                    return true;
                }
            }
            usedSymbols[i] = word.charAt(i);
        }
        return false;
    }

    public boolean hasDuplicateLettersOnlyString(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i + 1).contains(String.valueOf(word.charAt(i)))) {
                return true;
            }
        }
        return false;
    }


    // 1.2 (20 минут на полное решение и написание тестов)
    public boolean isRearrangedStrings(String firstWord, String secondWord) {
        //Если длинна строки не совпадает, то это сразу нет
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        //Если они идентичны - они не являются перестановкой друг друга, а являются тойже строкой
        if (firstWord.equals(secondWord)) {
            return false;
        }
        char[] firstWordSymbols = firstWord.toCharArray();
        for (int i = 0; i < secondWord.length(); i++) {
            boolean found = false;
            for (int j = i; j < firstWordSymbols.length; j++) {
                if (firstWordSymbols[j] == secondWord.charAt(i)) {
                    char temp = firstWordSymbols[i];
                    firstWordSymbols[i] = firstWordSymbols[j];
                    firstWordSymbols[j] = temp;
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    //1.4 (20 минут)
    public boolean isPalindrome(String word) {
        if (word == null || word.trim().equals("")) {
            throw new IllegalArgumentException("Была передана пустая строка или null");
        }
        String wordWithoutSpaces = word.replace(" ", "").toLowerCase();
        return wordWithoutSpaces.equals(new StringBuilder(wordWithoutSpaces).reverse().toString());
    }

    //1.5 (35 минут)
    public boolean differentIsOneModify(String firstWord, String secondWord) {
        if (firstWord.equals(secondWord)) {
            //Это одинаковые слова, значит не на расстоянии одной модификации
            return false;
        }
        if (Math.abs(firstWord.length() - secondWord.length()) > 1) {
            return false;
        }
        boolean modifyUsed = false;
        //Модификация - ЗАМЕНА
        if (firstWord.length() == secondWord.length()) {
            for (int i = 0; i < firstWord.length(); i++) {
                if (firstWord.charAt(i) != secondWord.charAt(i)) {
                    if (modifyUsed) {
                        return false;
                    }
                    modifyUsed = true;
                }
            }
            return true;
        }
        //Модификация - Удаление или добавление (эквивалентны если поменять местами параметры)
        for (int i = 0; i < Math.min(firstWord.length(), secondWord.length()); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                if (modifyUsed) {
                    return false;
                }
                modifyUsed = true;
                if (firstWord.length() > secondWord.length()) {
                    firstWord = firstWord.substring(0, i) + firstWord.substring(i + 1);
                } else {
                    secondWord = secondWord.substring(0, i) + secondWord.substring(i + 1);
                }
                i--;
            }
        }
        return true;
    }

    //1.6 (20 минут)
    public String getShortForm(String startForm){
        boolean wasRepetition = false;
        StringBuilder resultStringBuilder = new StringBuilder();
        for(int i = 0; i < startForm.length();){
            char currentSymbol = startForm.charAt(i);
            int countRepetition = 1;
            for(int j = i + 1; j < startForm.length(); j++){
                if(startForm.charAt(j) == currentSymbol){
                    countRepetition++;
                }else {
                    break;
                }
            }
            if(countRepetition > 1){
                wasRepetition = true;
            }
            resultStringBuilder.append(currentSymbol).append(countRepetition);
            i+=countRepetition;
        }
        return wasRepetition ? resultStringBuilder.toString() : startForm;
    }
}
