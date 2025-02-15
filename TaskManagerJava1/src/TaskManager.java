import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks; // Список задач
    private int taskIdCounter; // Счетчик для уникальных идентификаторов задач

    public TaskManager() {
        tasks = new ArrayList<>(); // Инициализация списка задач
        taskIdCounter = 1; // Начинаем с ID 1
    }

    // Метод для добавления новой задачи с автоматически сгенерированным ID
    public Task createTask(String title, String description) {
        Task task = new Task(taskIdCounter++, title, description);
        tasks.add(task);
        return task;
    }

    // Метод для добавления новой задачи с заданным ID
    public Task createTaskWithId(int id, String title, String description) {
        // Проверяем, существует ли уже задача с таким ID
        if (tasks.stream().anyMatch(task -> task.getId() == id)) {
            throw new IllegalArgumentException("Ошибка: Задача с таким ID уже существует."); // Генерация исключения
        }
        
        Task task = new Task(id, title, description);
        tasks.add(task);
        return task;
    }

    // Метод для получения всех задач
    public List<Task> readTasks() {
        return tasks;
    }

    // Метод для обновления задачи по ID
    public boolean updateTask(int id, String newTitle, String newDescription) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, new Task(id, newTitle, newDescription)); // Обновляем задачу
                return true; // Успех
            }
        }
        return false; // Задача не найдена
    }

    // Метод для удаления задачи по ID
    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}