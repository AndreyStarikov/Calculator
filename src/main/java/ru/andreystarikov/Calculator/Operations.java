package ru.andreystarikov.Calculator;

public class Operations {

    /**
     * Функция проверяет, является ли текущий символ оператором
     */
    public static boolean isOperation(char c) {
        boolean ret = false;
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
//            case '^':
                ret = true;
        }
        return ret;
    }

    /**
     * Возвращает приоритет операции
     *
     * @param op char
     * @return byte
     */
    public static byte opPrior(char op) {
        byte ret = 1;
        switch (op) {
//            case '^':
//                ret = 3;
//                break;
            case '*':
            case '/':
//            case '%':
                ret = 2;
                break;
        }
        return ret; // Тут остается + и -
    }
}
