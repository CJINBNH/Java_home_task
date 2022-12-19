// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один
// человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;

public class task_0001 {
    public static void main (String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        
        ArrayList<String> phoneNums1 = new ArrayList<>();
        phoneNums1.add("home 34 25 72");
        phoneNums1.add("work 53 69 97");
        phoneNums1.add("mobil 89271485050");
        phoneBook.putIfAbsent("Мордашов Алексей Александрович", phoneNums1);
        
        ArrayList<String> phoneNums2 = new ArrayList<>();
        phoneNums2.add("home 78 50 25");
        phoneNums2.add("work 62 01 47");
        phoneNums2.add("mobil 89173157078");
        phoneBook.putIfAbsent("Абрамович Роман Аркадьевич", phoneNums2);

        ArrayList<String> phoneNums3 = new ArrayList<>();
        phoneNums3.add("home 95 10 31");
        phoneNums3.add("work 22 77 88");
        phoneNums3.add("mobil 89053106325");
        phoneBook.putIfAbsent("Алекперов Вагит Юсуфович", phoneNums3);

        for (HashMap.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            Object[] temp = entry.getValue().toArray();
            for (Object phone : temp) {
                System.out.printf("Контакт %s телефон %s \n", entry.getKey(), phone);

            }
        }
    }
}
