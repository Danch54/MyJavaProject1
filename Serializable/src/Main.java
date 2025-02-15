import java.util.List;
import java.util.Scanner;

public class Main {
    private static TaskManager taskManager = new TaskManager(); // Менеджер задач

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Добро пожаловать в систему управления задачами!");
        String command;
        do {
            System.out.println("\nВведите команду (add - добавить, list - показать все задачи, update - обновить, delete - удалить, exit - выход): ");
            command = scanner.nextLine().trim().toLowerCase();

            try {
                switch (command) {
                    case "add":
                        addTask(scanner);
                        break;
                    case "list":
                        listTasks();
                        break;
                    case "update":
                        updateTask(scanner);
                        break;
                    case "delete":
                        deleteTask(scanner);
                        break;
                    case "exit":
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неизвестная команда. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } while (!command.equals("exit"));
        
        scanner.close();
    }

    // Метод для добавления задачи
    private static void addTask(Scanner scanner) {
        System.out.print("Введите уникальный ID задачи: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите заголовок задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();

        Task task = taskManager.createTask(id, title, description);
        System.out.println("Задача добавлена: " + task);
    }

    // Метод для вывода всех задач
    private static void listTasks() {
        List<Task> tasks = taskManager.readTasks();
        if (tasks.isEmpty()) {
            System.out.println("Нет задач для отображения.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Метод для обновления задачи
    private static void updateTask(Scanner scanner) throws Exception {
        System.out.print("Введите ID задачи для обновления: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите новый заголовок задачи: ");
        String newTitle = scanner.nextLine();
        System.out.print("Введите новое описание задачи: ");
        String newDescription = scanner.nextLine();
        
        if (!taskManager.updateTask(id, newTitle, newDescription)) {
            throw new Exception("Задача с ID " + id + " не найдена.");
        }
        System.out.println("Задача обновлена.");
    }

    // Метод для удаления задачи
    private static void deleteTask(Scanner scanner) throws Exception {
        System.out.print("Введите ID задачи для удаления: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        if (!taskManager.deleteTask(id)) {
            throw new Exception("Задача с ID " + id + " не найдена.");
        }
        System.out.println("Задача с ID " + id + " удалена.");
    }
}