package ru.andreystarikov.Calculator;

public class ReversePolishNotation {

    /**
     * Преобразует строку в обратную польскую нотацию С ИГНОРИРОВАНИЕМ СКОБОК КАК ЗНАКОВ ПРИОРИТЕТА!!!
     * Для преобразования с использованием приоритета, нужно раскомментировать 2 последних блока if.
     *
     * @param stringIn входящая строка
     * @return строка в обратной польской нотации
     * @throws Exception
     */
    public static String rpn(String stringIn) throws Exception {
        StringBuilder stack = new StringBuilder("");
        StringBuilder stackOut = new StringBuilder("");
        char charIn, charTmp;

        for (int i = 0; i < stringIn.length(); i++) {
            charIn = stringIn.charAt(i);
            if (Operations.isOperation(charIn)) {
                while (stack.length() > 0) {
                    charTmp = stack.substring(stack.length() - 1).charAt(0);
                    if (Operations.isOperation(charTmp) && (Operations.opPrior(charIn) <= Operations.opPrior(charTmp))) {
                        stackOut.append(" ").append(charTmp).append(" ");
                        stack.setLength(stack.length() - 1);
                    } else {
                        stackOut.append(" ");
                        break;
                    }
                }

                stackOut.append(" ");
                stack.append(charIn);
            } else if ('(' == charIn) {
//                stack.append(charIn);
            } else if (')' == charIn) {
//                charTmp = stack.substring(stack.length() - 1).charAt(0);
//                while ('(' != charTmp) {
//                    if (stack.length() < 1) {
//                        throw new Exception("Ошибка разбора скобок. Проверьте правильность выражения.");
//                    }
//                    stackOut.append(" ").append(charTmp);
//                    stack.setLength(stack.length() - 1);
//                    charTmp = stack.substring(stack.length() - 1).charAt(0);
//                }
//                stack.setLength(stack.length() - 1);
            } else {
                stackOut.append(charIn);
            }
        }

        while (stack.length() > 0) {
            stackOut.append(" ").append(stack.substring(stack.length() - 1));
            stack.setLength(stack.length() - 1);
        }

        return stackOut.toString();
    }


}
