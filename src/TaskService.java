import java.util.List;
import java.util.Optional;

public interface TaskService {

    void addTask(Task task);
    void removeTask(Integer id);
    Optional<Task> findTaskById(Integer id);
    List<Task> listAllTasks();
}
