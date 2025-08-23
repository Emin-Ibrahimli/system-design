import java.time.LocalDateTime;

public class DeadlineTask extends Task {
    private LocalDateTime deadline;

    public DeadlineTask(Integer id, String title, String description, LocalDateTime created, boolean isCompleted, TaskStatus status, LocalDateTime deadline) {
       super(id, title, description, created, isCompleted, status);
       this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "DeadlineTask{" +
                "id=" + this.getId() + '\n' +
                "title='" + this.getTitle() + '\n' +
                "description='" + this.getDescription() +'\n' +
                "created=" + this.getCreated() + '\n' +
                "isCompleted=" + this.isCompleted() + '\n' +
                "status=" + this.getStatus() + '\n' +
                "deadline=" + deadline + '\n' +
                "} ";
    }
}
