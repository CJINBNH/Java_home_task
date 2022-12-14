// Пусть дан произвольный список целых чисел. Удалить из него чётные числа.


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_002 {
    public static void main(String[] args) {
        List<Integer> list = randomList();
        System.out.println("Начальный список -> ");
        System.out.println(list);

        List<Integer> result = removingEvenNumbers(list);
    
        System.out.println("Итоговый список -> ");
        System.out.println(result);

    }

    public static List<Integer> randomList () {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int n = random.nextInt(40) - 20;
            list.add(n);
        }
        return list;
    }

    public static List<Integer> removingEvenNumbers (List<Integer> list) {
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        
        return list;
    }
}
