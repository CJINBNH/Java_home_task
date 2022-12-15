// Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной
// польской записи. Калькулятор вычисляет результат и проверяет, что в стэке получилось
// единственное число.
// Например:
// 5 4 3 - + => 5 1 + => 6
// Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ
// и номером группы.

import java.util.Scanner;
import java.util.Stack;

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Через пробел введите операцию в постфиксной форме -> ");
        String input = scanner.nextLine();
        

        String[] reversePolish = input.split(" ");
        double result = 0;
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < reversePolish.length; i++) {
            if (isDigit(reversePolish[i])) {
                stack.push(Double.parseDouble(reversePolish[i]));
            } else {
                switch (reversePolish[i]) {
                    case "+":
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "-":
                        result = -stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "*":
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        break;
                    case "/":
                        result = stack.pop() / stack.pop();
                        stack.push(result);
                        break;
                    default:
                        break;
                }
            }
            System.out.println(stack);
        }
        System.out.printf("%.3f\n", stack.pop());
        scanner.close();
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
