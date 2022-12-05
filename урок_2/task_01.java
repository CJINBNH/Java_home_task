// В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow"
// Для разбора строки используйте String.split. Сформируйте новую строку,
// используя StringBuilder. Значения null не включаются в запрос.

import java.io.BufferedReader;
import java.io.FileReader;

public class task_01 {
    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new FileReader("./string_task2.txt"));
        
        String data;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_key = new StringBuilder();
        String sNull = "null";
        
        while ((data = br.readLine()) != null) {
            System.out.printf ("%s\n", data);
            data = data.substring (1, data.length() - 1);
            String[] data_new;
            data_new = data.split(", ");
            String select = "SELECT * FROM students WHERE ";
            sb.append(String.format("%s", select));
            for (String dn : data_new) {
                String[] data_key;
                data_key = dn.split(":");
                String key = data_key[0];
                key = key.substring(1, key.length() - 1);
                String value = data_key[1];
                if ((value.substring(1, value.length() - 1)).equals(sNull) != true) {
                    sb_key.append(String.format(" AND %s = %s", key, value));
                }
            }
            String result = sb_key.toString();
            result = result.substring(5);
            sb.append(String.format("%s", result));
            System.out.println(sb);
        }  
        try {
            if (br != null)
            br.close();
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
        }       
    }
}

    //     String data = "name: Ivanov, country: Russia, city: Moscow, age: null";

    //     StringBuilder builder = new StringBuilder();

    //     String[] parts = data.split(", ");
    //     for (String part : parts){
    //         String[] keyValue = part.split(": ");
    //         String key = keyValue[0];
    //         String value = keyValue[1];

    //         builder.append (String.format(" AND %s = %s", key, value));
    //     }
    //     String request = builder.toString();
    //     request = request.substring(5);
    //     System.out.println(request);
    // }