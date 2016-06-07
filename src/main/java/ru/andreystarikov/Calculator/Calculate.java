package ru.andreystarikov.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Calculate {

    /**
     * Считает выражение, записанное в обратной польской нотации
     *
     * @param expression строка в обратной польской нотации
     * @return double result
     */
    public static double calculate(String expression) throws Exception {
        double a = 0, b = 0; //переменные а и b
        String str;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        while (stringTokenizer.hasMoreTokens()) {
            try {
                str = stringTokenizer.nextToken().trim();
                if (1 == str.length() && Operations.isOperation(str.charAt(0))) {

                    if (stack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке для операции " + str);
                    }

                    b = stack.pop();
                    a = stack.pop();
                    switch (str.charAt(0)) {
                        case '+':
                            a += b;
                            break;
                        case '-':
                            a -= b;
                            break;
                        case '/':
                            a /= b;
                            break;
                        case '*':
                            a *= b;
                            break;
//                        case '%':
//                            a %= b;
//                            break;
//                        case '^':
//                            a = Math.pow(a, b);
//                            break;
                        default:
                            throw new Exception("Недопустимая операция " + str);
                    }
                    stack.push(a);
                } else {
                    a = Double.parseDouble(str);
                    stack.push(a);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }

        return stack.pop();
    }
}
