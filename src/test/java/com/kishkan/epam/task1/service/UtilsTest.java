package com.kishkan.epam.task1.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static java.time.Duration.ofNanos;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest
    @CsvSource({"testcompleted, test, completed", "тестпройден, тест, пройден"})
    void concatenateWords(String expected, String str1, String str2) {
        String result = Utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings");
    }

    @Test
    void concatenateWordsWithRightStringEmpty() {
        String expected = "test";
        String str1 = "test";
        String str2 = "";
        String result = Utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with right empty");
    }

    @Test
    void concatenateWordsWithLeftStringEmpty() {
        String expected = "completed";
        String str1 = "";
        String str2 = "completed";
        String result = Utils.concatenateWords(str1, str2);
        assertEquals(expected, result, "Concatenating strings with left empty");
    }

    @Test
    @Disabled
    void testComputeFactorial() {
        BigInteger expected = BigInteger.valueOf(1307674368000L);
        BigInteger result = Utils.computeFactorial(15);
        assertEquals(expected, result, "Calculating factorial");
    }

    @Test
    void testFactorialWithTimeout() {
        assertTimeout(ofNanos(40), () -> {
            Utils.computeFactorial((int) (Math.random() * 100));
        });
    }

    @Test
    void testFactorialWithNegativeInput() {
        assertThrows(ArithmeticException.class, (() -> Utils.computeFactorial(-7)));
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "3, 6", "10, 3628800", "12, 479001600"})
    void parameterizedTestComputeFactorial(long a, long b) {
        BigInteger expected = BigInteger.valueOf(b);
        BigInteger result = Utils.computeFactorial(a);
        assertEquals(expected, result, "Calculating factorial");
    }

}