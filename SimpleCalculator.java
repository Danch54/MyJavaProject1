import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true; // Флаг для контроль повторения расчетов

        while (continueCalculating) {
            System.out.println("=== Простая Калькулятор ===");
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            System.out.println("Выберите операцию: ");
            System.out.println("1. Сложение (+)");
            System.out.println("2. Вычитание (-)");
            System.out.println("3. Умножение (*)");
            System.out.println("4. Деление (/)");

            int operation = scanner.nextInt();
            double result;

            switch (operation) {
                case 1:
                    result = num1 + num2;
                    System.out.println("Результат: " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("Результат: " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("Результат: " + result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Результат: " + result);
                    } else {
                        System.out.println("Ошибка: Деление на ноль недопустимо.");
                    }
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
            }

            System.out.print("Хотите выполнить еще один расчет? (да/нет): ");
            String answer = scanner.next();

            // Если пользователь ввел "нет", выходим из цикла
            if (answer.equalsIgnoreCase("нет")) {
                continueCalculating = false;
            }
        }

        System.out.println("Спасибо за использование калькулятора. Всего хорошего!");
        scanner.close();
    }
}