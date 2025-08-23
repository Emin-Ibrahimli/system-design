import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime created;
    private boolean isCompleted;
    private TaskStatus status;
    private static ImmutableUser[] users;
    private static int countUser= 0;

    public Task(Integer id, String title, String description, LocalDateTime created, boolean isCompleted, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.isCompleted = isCompleted;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public static void addUser(ImmutableUser user){

    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted && Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(created, task.created) && Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, created, isCompleted, status);
    }

    @Override
    public String toString() {
        return "Task{" + '\n' +
                "id=" + id + '\n' +
                "title='" + title + '\n' +
                "description='" + description +'\n' +
                "created=" + created + '\n' +
                "isCompleted=" + isCompleted + '\n' +
                "status=" + status + '\n' +
                '}';
    }
}
