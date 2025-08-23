import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository<Task> repository;

    public TaskServiceImpl(TaskRepository<Task> repository) {
        this.repository = repository;
    }

    @Override
    public void addTask(Task task) {
        repository.save(task);
    }

    @Override
    public void removeTask(Integer id) {
        try{
            repository.delete(id);
        } catch (TaskNotFoundException e){
            e.getMessage();
        }
    }

    @Override
    public Optional<Task> findTaskById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Task> listAllTasks() {
        return repository.findAll();
    }
}

