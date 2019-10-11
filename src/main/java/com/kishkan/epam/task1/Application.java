package com.kishkan.epam.task1;

import com.kishkan.epam.task1.service.Utils;

public class Application {

    public static void main(String[] args) {
        Utils utilManager = new Utils();
        System.out.println(utilManager.computeFactorial(5));
    }
}
