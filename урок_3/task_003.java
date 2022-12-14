// Задан целочисленный список ArrayList. Найти минимальное, максимальное и
// среднее арифметичское этого списка.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class task_003 {
    public static void main(String[] args) {
        List<Integer> list = randomList();
        System.out.println("Исходный список -> " + list);

        int min = list.get(0);
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }
        System.out.printf("Минимальное число списка = %d\n", min);

        int max = list.get(0);
        for (int i : list) {
            if (i > max) {
                max = i;
            }
        }
        System.out.printf("Максимальное число списка = %d\n", max);

        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        double average = sum / list.size();
        System.out.printf("Среднее арифметическое = %.2f\n", average);
    }

    public static List<Integer> randomList() {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nums = random.nextInt(10) - 5;
            list.add(nums);
        }
        return list;
    }
}
