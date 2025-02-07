import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoAppStub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>(); // Список для хранения задач
        int choice;

        do {
            // Отображение меню
            System.out.println("=== ToDo Приложение (Заглушка) ===");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Просмотреть задачи");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Выход");
            System.out.print("Выберите опцию (1-4): ");

            // Проверка ввода пользователя
            while (!scanner.hasNextInt()) {
                System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 4.");
                scanner.next(); // Пропустить неправильный ввод
            }
            choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите задачу: ");
                    String task = scanner.nextLine();
                    tasks.add(task); // Добавляем задачу в список
                    System.out.println("Задача добавлена: " + task);
                    break;
                case 2:
                    System.out.println("Список задач:");
                    if (tasks.isEmpty()) {
                        System.out.println("Нет задач для отображения.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i)); // Печатаем все задачи с номерами
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите номер задачи для удаления: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Неверный ввод. Пожалуйста, введите номер задачи.");
                        scanner.next(); // Пропустить неправильный ввод
                    }
                    int taskNumber = scanner.nextInt();
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        String removedTask = tasks.remove(taskNumber - 1); // Удаляем задачу по номеру
                        System.out.println("Задача удалена: " + removedTask);
                    } else {
                        System.out.println("Неверный номер задачи. Пожалуйста, введите номер от 1 до " + tasks.size() + ".");
                    }
                    break;
                case 4:
                    System.out.println("Выход из приложения.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите опцию от 1 до 4.");
            }

            System.out.println(); // Пустая строка для разделения выходных данных

        } while (choice != 4); // Продолжать до тех пор, пока пользователь не выберет выход

        scanner.close();
    }
}

