// В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow"
// Для разбора строки используйте String.split. Сформируйте новую строку,
// используя StringBuilder. Значения null не включаются в запрос.

import java.io.BufferedReader;
import java.io.FileReader;

public class task_01 {
        public static void main (String[] args) throws Exception {
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader("string_урок_2_task_01.txt"));
            
            String data;
            StringBuilder builderStr = new StringBuilder();
            StringBuilder builderKey = new StringBuilder();
            String strNull = "null";
            
            while ((data = bufferedReader.readLine()) != null) {
                System.out.printf ("%s\n", data);
                data = data.substring (1, data.length() - 1);
                String[] dataNew;
                dataNew = data.split(", ");
                String introduc = "SELECT * FROM students WHERE ";
                builderStr.append(String.format("%s", introduc));
                for (String dn : dataNew) {
                    String[] dataKey;
                    dataKey = dn.split(":");
                    String key = dataKey[0];
                    key = key.substring(1, key.length() - 1);
                    String value = dataKey[1];
                    if ((value.substring(1, value.length() - 1)).equals(strNull) != true) {
                        builderKey.append(String.format(" AND %s = %s", key, value));
                    }
                }
                String result = builderKey.toString();
                result = result.substring(5);
                builderStr.append(String.format("%s", result));
                System.out.println(builderStr);
            }  
            try {
                if (bufferedReader != null)
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("Ошибка чтения файла");
            }       
        }
    }
