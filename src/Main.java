package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Task> tasks = new ArrayList<>(); // Список задач
    private static int taskIdCounter = 1; // Счётчик для уникальных идентификаторов задач

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Программа добавляет задачу "Сходить в магазин" автоматически
        Task initialTask = new Task(taskIdCounter++, "Сходить в магазин", "Купить яйца и молоко");
        tasks.add(initialTask);
        
        System.out.println("Добро пожаловать в систему управления задачами!");
        String command;
        do {
            System.out.println("\nВведите команду (add - добавить, list - показать все задачи, complete - завершить, exit - выход): ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addTask(scanner);
                    break;
                case "list":
                    listTasks();
                    break;
                case "complete":
                    completeTask(scanner);
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        } while (!command.equals("exit"));
        
        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Введите заголовок задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();

        Task task = new Task(taskIdCounter++, title, description);
        tasks.add(task);
        System.out.println("Задача добавлена: " + task);
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Нет задач для отображения.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void completeTask(Scanner scanner) {
        System.out.print("Введите ID задачи для завершения: ");
        int id;

        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите корректный ID задачи.");
            return;
        }

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.complete();
                System.out.println("Задача завершена: " + task);
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена.");
    }
}