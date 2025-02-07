

public class Вводвывод {
    public static void main(String[] args) {
        // Предопределенные числа
        int a = 10; // Первое число
        int b = 5;  // Второе число

        // Выполняем сложение и выводим результат
        int sum = a + b;
        System.out.println("Сложение: " + sum);

        // Проверяем, какое больше
        if (a > b) {
            System.out.println("Первое число (" + a + ") больше второго числа (" + b + ").");
        } else if (a < b) {
            System.out.println("Второе число (" + b + ") больше первого числа (" + a + ").");
        } else {
            System.out.println("Оба числа равны.");
        }
    }
}