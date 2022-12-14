// Реализовать алгоритм сортировки слиянием.

import java.util.Arrays;
import java.util.Random;

public class task_001 {
    public static void main(String[] args) {
        int[] origArray = randomArray();
        System.out.println("Неотсортированный массив -> ");
        System.out.println(Arrays.toString(origArray));
        int[] sortArray = mergeSort(origArray);
        System.out.println("Отсортированный массив -> ");
        System.out.println(Arrays.toString(sortArray));

    }

    public static int[] randomArray() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int n = random.nextInt(40) - 20;
            array[i] = n;
        }
        return array;
    }

    public static int[] mergeSort(int[] origArray) {
        int[] buffer1 = Arrays.copyOf(origArray, origArray.length);
        int[] buffer2 = new int[origArray.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, origArray.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
