package com.kishkan.epam.task1.service;

import java.math.BigInteger;

public class Utils {

    public String concatenateWords(String firstString, String secondString) {
        return firstString + " " + secondString;
    }

    public BigInteger computeFactorial(long input) {
        BigInteger result = BigInteger.valueOf(1);
        for (long i = 1; i <= input; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}