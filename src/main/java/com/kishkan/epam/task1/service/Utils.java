package com.kishkan.epam.task1.service;

import java.math.BigInteger;

public class Utils {

    public static String concatenateWords(String firstString, String secondString) {
        return firstString.concat(secondString);
    }

    public static BigInteger computeFactorial(long input) {
        if (input >= 0) {
            BigInteger result = BigInteger.valueOf(1);
            for (long i = 1; i <= input; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        } else {
            throw new ArithmeticException("negative input!");
        }
    }
}