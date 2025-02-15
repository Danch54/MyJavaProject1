import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks; // Список задач
    private static final String FILE_NAME = "tasks.ser"; // Имя файла для сохранения задач

    public TaskManager() {
        tasks = new ArrayList<>(); // Инициализация списка задач
        loadTasks(); // Загружаем задачи из файла при инициализации
    }

    // Метод для добавления новой задачи с автоматически сгенерированным ID
    public Task createTask(String title, String description) {
        int id = tasks.size() + 1; // Генерируем ID на основе текущего размера списка
        Task task = new Task(id, title, description);
        tasks.add(task);
        saveTasks(); // Сохраняем задачи после добавления
        return task;
    }

    // Метод для добавления новой задачи с заданным ID
    public Task createTask(int id, String title, String description) {
        Task task = new Task(id, title, description);
        tasks.add(task);
        saveTasks(); // Сохраняем задачи после добавления
        return task;
    }

    // Метод для получения всех задач
    public List<Task> readTasks() {
        return tasks;
    }

    // Метод для обновления задачи по ID
    public boolean updateTask(int id, String newTitle, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.set(tasks.indexOf(task), new Task(id, newTitle, newDescription)); // Обновляем задачу
                saveTasks(); // Сохраняем изменения
                return true; // Успех
            }
        }
        return false; // Задача не найдена
    }

    // Метод для удаления задачи по ID
    public boolean deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            saveTasks(); // Сохраняем изменения
        }
        return removed;
    }

    // Метод для сохранения задач в файл
    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения задач: " + e.getMessage());
        }
    }

    // Метод для загрузки задач из файла
    @SuppressWarnings("unchecked")
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                tasks = (List<Task>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка загрузки задач: " + e.getMessage());
            }
        }
    }
}