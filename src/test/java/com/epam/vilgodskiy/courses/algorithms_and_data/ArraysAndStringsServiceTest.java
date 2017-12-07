package com.epam.vilgodskiy.courses.algorithms_and_data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsServiceTest {

    private ArraysAndStringsService arraysAndStringsService;

    @Before
    public void beforeTest() {
        arraysAndStringsService = new ArraysAndStringsService();
    }

    //1.1

    @Test
    public void hasDuplicateLettersWithSet() {
        assertFalse(arraysAndStringsService.hasDuplicateLettersWithSet(""));
        assertFalse(arraysAndStringsService.hasDuplicateLettersWithSet("а"));
        assertFalse(arraysAndStringsService.hasDuplicateLettersWithSet("абвг"));
        // Повторяется буква "б"
        assertTrue(arraysAndStringsService.hasDuplicateLettersWithSet("аббвгд"));
        // Повторяются пробелы
        assertTrue(arraysAndStringsService.hasDuplicateLettersWithSet("аб в гд"));
        // Заглавная и прописная буквы - разные символы
        assertFalse(arraysAndStringsService.hasDuplicateLettersWithSet("абБвг"));
    }

    @Test
    public void hasDuplicateLetters() {
        assertFalse(arraysAndStringsService.hasDuplicateLetters(""));
        assertFalse(arraysAndStringsService.hasDuplicateLetters("а"));
        assertFalse(arraysAndStringsService.hasDuplicateLetters("абвг"));
        // Повторяется буква "б"
        assertTrue(arraysAndStringsService.hasDuplicateLetters("аббвгд"));
        // Повторяются пробелы
        assertTrue(arraysAndStringsService.hasDuplicateLetters("аб в гд"));
        // Заглавная и прописная буквы - разные символы
        assertFalse(arraysAndStringsService.hasDuplicateLetters("абБвг"));
    }

    @Test
    public void hasDuplicateLettersOnlyString() {
        assertFalse(arraysAndStringsService.hasDuplicateLettersOnlyString(""));
        assertFalse(arraysAndStringsService.hasDuplicateLettersOnlyString("а"));
        assertFalse(arraysAndStringsService.hasDuplicateLettersOnlyString("абвг"));
        // Повторяется буква "б"
        assertTrue(arraysAndStringsService.hasDuplicateLettersOnlyString("аббвгд"));
        // Повторяются пробелы
        assertTrue(arraysAndStringsService.hasDuplicateLettersOnlyString("аб в гд"));
        // Заглавная и прописная буквы - разные символы
        assertFalse(arraysAndStringsService.hasDuplicateLettersOnlyString("абБвг"));
    }

    //1.2

    @Test
    public void isRearrangedStrings() {
        //Если они идентичны - они не являются перестановкой друг друга, а являются тойже строкой
        assertFalse(arraysAndStringsService.isRearrangedStrings("", ""));
        assertTrue(arraysAndStringsService.isRearrangedStrings("аб", "ба"));
        //Если они идентичны - они не являются перестановкой друг друга, а являются тойже строкой
        assertFalse(arraysAndStringsService.isRearrangedStrings("аб", "аб"));
        assertTrue(arraysAndStringsService.isRearrangedStrings("абвг", "гвба"));
        assertTrue(arraysAndStringsService.isRearrangedStrings("а бвг", "гвб а"));
        //Два символа пробела
        assertFalse(arraysAndStringsService.isRearrangedStrings("а бвг", "г вб а"));
        //Заглавные буквы отличны от строчных
        assertFalse(arraysAndStringsService.isRearrangedStrings("абвг", "Абвг"));
    }

    @Test
    public void isPalindrome() {
        assertTrue(arraysAndStringsService.isPalindrome("топот"));
        assertFalse(arraysAndStringsService.isPalindrome("кот"));
        assertTrue(arraysAndStringsService.isPalindrome("А роза упала на лапу Азора"));
        assertFalse(arraysAndStringsService.isPalindrome("Это точно не полином"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPalindromeWithException() {
        arraysAndStringsService.isPalindrome("   ");
    }


    @Test
    public void differentIsOneModify() {
        assertTrue(arraysAndStringsService.differentIsOneModify("pale", "ple"));
        assertTrue(arraysAndStringsService.differentIsOneModify("pales", "pale"));
        assertTrue(arraysAndStringsService.differentIsOneModify("pale", "bale"));
        assertFalse(arraysAndStringsService.differentIsOneModify("pale", "bake"));
        //Это одинаковые слова, значит не на расстоянии одной модификации
        assertFalse(arraysAndStringsService.differentIsOneModify("pale", "pale"));
        assertTrue(arraysAndStringsService.differentIsOneModify("pale", "pales"));
        assertFalse(arraysAndStringsService.differentIsOneModify("pale", "pa"));
        assertFalse(arraysAndStringsService.differentIsOneModify("pale", "sle"));
        assertFalse(arraysAndStringsService.differentIsOneModify("pale", "palese"));
    }

    @Test
    public void getShortForm() {
        assertEquals(arraysAndStringsService.getShortForm("aaaabbbcccc"), "a4b3c4");
        assertEquals(arraysAndStringsService.getShortForm("abbbcccc"), "a1b3c4");
        assertEquals(arraysAndStringsService.getShortForm("abcd"), "abcd");
        assertEquals(arraysAndStringsService.getShortForm(""), "");
        assertEquals(arraysAndStringsService.getShortForm("aabbaacccCCd"), "a2b2a2c3C2d1");
    }
}