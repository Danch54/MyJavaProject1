import java.time.LocalDateTime;

public class Task {
    private int id; // Уникальный идентификатор задачи
    private String title; // Заголовок задачи
    private String description; // Описание задачи
    private boolean isCompleted; // Флаг завершенности задачи
    private LocalDateTime creationDate; // Дата создания задачи

    // Конструктор
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = false; // Задача не завершена по умолчанию
        this.creationDate = LocalDateTime.now(); // Устанавливаем дату создания
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", creationDate=" + creationDate +
                '}';
    }
}
