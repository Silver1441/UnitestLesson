package com.kishkan.epam.task1.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static java.time.Duration.ofNanos;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    private final Utils utils = new Utils();

    @Test
    void concatenateWords() {
        String expected = "test completed";
        String str1 = "test";
        String str2 = "completed";
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings");
    }

    @Test
    void concatenateWordsWithRightStringNull() {
        String expected = "test null";
        String str1 = "test";
        String str2 = null;
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with right null");
    }

    @Test
    void concatenateWordsWithLeftStringNull() {
        String expected = "null completed";
        String str1 = null;
        String str2 = "completed";
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with left null");
    }

    @Test
    void concatenateWordsWithRightStringEmpty() {
        String expected = "test ";
        String str1 = "test";
        String str2 = new String();
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with right empty");
    }

    @Test
    void concatenateWordsWithLeftStringEmpty() {
        String expected = " completed";
        String str1 = new String();
        String str2 = "completed";
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with left empty");
    }

    @Test
    void concatenateWordsNonLatin() {
        String expected = "тест пройден";
        String str1 = "тест";
        String str2 = "пройден";
        String result = utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating non-latin strings");
    }

    @Test
    @Disabled
    void testComputeFactorial() {
        BigInteger expected = BigInteger.valueOf(1307674368000L);
        BigInteger result = utils.computeFactorial(15);
        assertEquals(expected, result, "Calculating factorial");
    }

    @Test
    void testFactorialWithTimeout() {
        assertTimeout(ofNanos(40), () -> {
            utils.computeFactorial((int) (Math.random() * 100));
        });
    }

    @Test
    void testFactorialWithZero() {
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger result = utils.computeFactorial(0);
        assertEquals(expected, result, "Calculating zero input factorial");
    }

    @Test
    void testFactorialWithNegativeInput() {
        assertThrows(ArithmeticException.class, (() -> utils.computeFactorial(-7)));
    }

    @ParameterizedTest
    @CsvSource({ "3, 6", "10, 3628800", "12, 479001600" })
    void parameterizedTestComputeFactorial(long a, long b) {
        BigInteger expected = BigInteger.valueOf(b);
        BigInteger result = utils.computeFactorial(a);
        assertEquals(expected, result, "Calculating factorial");
    }

}