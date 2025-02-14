import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks; // Список задач
    private int taskIdCounter; // Счетчик для уникальных идентификаторов задач

    public TaskManager() {
        tasks = new ArrayList<>(); // Инициализация списка задач
        taskIdCounter = 1; // Начинаем с ID 1
    }

    public Task createTask(String title, String description) {
        Task task = new Task(taskIdCounter++, title, description);
        tasks.add(task);
        return task;
    }

    public List<Task> readTasks() {
        return tasks;
    }

    public boolean updateTask(int id, String newTitle, String newDescription) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, new Task(id, newTitle, newDescription)); // Обновляем задачу
                return true; // Успех
            }
        }
        return false; // Задача не найдена
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}