// Реализовать алгоритм пирамидальной сортировки (HeapSort).

import java.util.Arrays;
import java.util.Random;

public class task_0003 {
    public static void main (String[] args) {

        int[] checkArray = randomArray();
        System.out.println("Массив до сортировки -> ");
        System.out.println(Arrays.toString(checkArray));
        System.out.println("Массив после сортировки -> ");
        heapSort(checkArray, checkArray.length);

    }

    public static int[] randomArray() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int n = random.nextInt(50) - 25;
            array[i] = n;
        }
        return array;
    }

    public static void heapSort (int[] array, int length) {
        int temp;
        int size = length - 1;
        for (int i = (length / 2); i >= 0; i--) {
            heapify(array, i, size);
        }
        for (int i = size; i >= 0; i--) {
            temp = array[0];
            array[0] = array[size];
            array[size] = temp;
            size--;
            heapify(array, 0, size);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void heapify (int[] array, int top, int heapSize) {
        int left = 2 * top + 1;
        int right = 2 * top + 2;
        int largestElement;
        if (left <= heapSize && array[left] > array[top]) {
            largestElement = left;
        } else {
            largestElement = top;
        }
        if (right <= heapSize && array[right] > array[largestElement]) {
            largestElement = right;
        }
        if (largestElement != top) {
            int temp = array[top];
            array[top] = array[largestElement];
            array[largestElement] = temp;
            heapify(array, largestElement, heapSize);
        }
    }
}
