package ru.gb;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
 * (произведение чисел от 1 до n)
 * 
 */

public class App1 { 
    public static int recursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return recursion(n - 1) * n;
        }
    }
    public static void main(String[] args) {
        System.out.println(recursion(6));
    }
}

// public class App1 {
//     public static int getFactorial(int n) {
//         int result = 1;
//         for (int i = 1; i <= n; i++) {
//             result = result * i;
//         }
//         return result;
//   }
//   public static void main(String[] args) {
//         System.out.println(getFactorial(5));
//     }
// }