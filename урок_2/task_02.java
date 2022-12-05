// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой
// итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class task_02 {
    public static void main(String[] args) {
        int [] workArray = { 19, 13, 15, 18, 17, 10, 14, 12, 11, 16 };
        
        arrayPrint(workArray);
        System.out.println();
        sortFunction (workArray);
        arrayPrint(workArray);
        System.out.println();
    }

    
    public static void arrayPrint (int[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void sortFunction (int[] array) {
        boolean sort = false;
        int temporary;
        while(!sort) {
            sort = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    sort = false;
                    temporary = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporary;

                    String str = Arrays.toString(array);
                    try (FileWriter writer = new FileWriter("log_file_урок2_task_02.txt", true)) {
                        writer.write(str);            
                        writer.append('\n');
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }
}