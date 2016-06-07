package ru.andreystarikov.Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Calculator {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression;

        try {
            System.out.println("Введте выражение для расчета:");
            expression = reader.readLine();
            expression = ReversePolishNotation.rpn(expression); //преобразовывает строку в обратную польскую нотацию
            System.out.println(expression);
            System.out.println(Calculate.calculate(expression)); //передаем строку в ОПН калькулятору
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
