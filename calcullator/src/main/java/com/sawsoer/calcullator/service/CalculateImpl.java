package com.sawsoer.calcullator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateImpl implements Calculate {

    @Override
    public Double calculate(Double num1, Double num2, String op) {
        Double index = null;

        switch (op) {
            case "+":
                index = num1 + num2;
                break;
            case "-":
                index = num1 - num2;
                break;
            case "/":
                index = num1 / num2;
                break;
            case "*":
                index = num1 * num2;
                break;

        }
        return index;
    }
    
}
