public class NewProjectExample {
    public static void main(String[] args) {
        // Пример арифметических операторов
        int a = 10;
        int b = 5;
        System.out.println("Сложение: " + (a + b)); // 15

        // Пример условий if/else
        if (a > b) {
            System.out.println("a больше b");
        } else {
            System.out.println("a меньше или равно b");
        }

        // Пример цикла for
        System.out.println("Цикл for:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Итерация: " + i);
        }

        // Пример цикла while
        System.out.println("Цикл while:");
        int count = 0;
        while (count < 5) {
            System.out.println("Счетчик: " + count);
            count++;
        }
    }
}

