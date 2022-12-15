// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;

public class task_2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        
        enqueue (list, "abcd");
        System.out.printf("Добавление элементов -> %s\n", list);
        enqueue (list, "1234");
        System.out.printf("Добавление элементов -> %s\n", list);
        enqueue (list, "efgh");
        System.out.printf("Добавление элементов -> %s\n", list);
        enqueue (list, "5678");
        System.out.printf("Добавление элементов -> %s\n", list);
        enqueue (list, "ijkl");
        System.out.printf("Добавление элементов -> %s\n", list);
        enqueue (list, "91011");
        System.out.printf("Добавление элементов -> %s\n", list);

        System.out.printf("Первый элемент -> %s\n", dequeue (list));
        System.out.printf("Удаление первого элемента -> %s\n", list);
        
        System.out.printf("Последний элемент -> %s\n", dequeueLast(list));
        System.out.printf("Удаление последнего элемента -> %s\n", list);

        System.out.printf("Первый элемент -> %s\n", first (list));
        System.out.printf("Без удаления первого элемента -> %s\n", list);

        System.out.printf("Последний элемент -> %s\n", last (list));
        System.out.printf("Без удаления последнего элемента -> %s\n", list);

    }

    public static void enqueue (LinkedList<String> test, String str) {
        test.addLast(str);
    }
    
    public static String dequeue (LinkedList<String> test) { 
        return test.pollFirst();
    }

    public static String dequeueLast (LinkedList<String> test) { 
        return test.pollLast();
    }

    public static String first (LinkedList<String> test) {
        return test.peekFirst();
    }

    public static String last (LinkedList<String> test) {
        return test.peekLast();
    }
}
