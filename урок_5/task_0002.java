// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу,
// которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class task_0002 {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<String>();
        employees.add("Иван");
        employees.add("Иван");
        employees.add("Пётр");
        employees.add("Антон");
        employees.add("Антон");
        employees.add("Пётр");
        employees.add("Иван");
        employees.add("Пётр");
        employees.add("Пётр");
        employees.add("Иван");
        employees.add("Иван");
        employees.add("Антон");
        employees.add("Пётр");
        employees.add("Иван");
        employees.add("Антон");

        System.out.printf("Список из %d сотрудников \n", employees.size());
        for (String person : employees) {
            System.out.println(person);
        }

        Map<String, Integer> hashMap = new HashMap<>();
        for (String person : employees) {
            String name = person;
            Integer frequency = hashMap.get(name);
            hashMap.put(name, frequency == null ? 1 : frequency + 1);
        }
        System.out.println(hashMap);

        ArrayList<Map.Entry<String, Integer>> mappings = new ArrayList<>(hashMap.entrySet());
        Collections.sort(mappings, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(mappings);
        Map<String, Integer> linkedHashMapSort = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : mappings) {
            linkedHashMapSort.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMapSort);

    }

}
