// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
// “перевернутый” список.

import java.util.LinkedList;
import java.util.List;

public class task_1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add ("первый_элемент");
        list.add ("второй_элемент");
        list.add ("третий_элемент");
        list.add ("четвертый_элемент");
        list.add ("пятый_элемент");
        System.out.println(list);
        System.out.println(reversList(list));
    }

    public static List<String> reversList (List<String> list) {
        LinkedList<String> result = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}
