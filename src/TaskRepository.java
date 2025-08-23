import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository <T extends Task> {

    private List<T> tasks = new ArrayList<>();

    public void save(T task) {
        tasks.add(task);
    }

    public void delete(Integer id) throws TaskNotFoundException {
        boolean exists = false;
            for(T task : tasks){
                if(task.getId().equals(id)){
                    exists = true;
                    tasks.remove(task);
                }
            }
            if(!exists){
                throw new TaskNotFoundException("Task with id" + id + "not found!");
            }
    }

    public Optional<Task> findById(Integer id){
        Optional<Task> foundTask = Optional.empty();
          for (Task task : tasks) {
              if (task.getId().equals(id)) {
                  foundTask = Optional.of(task);
                  break;
              }
          }
          return foundTask;
    }

    public List<T> findAll(){
        return tasks;
    }
}
