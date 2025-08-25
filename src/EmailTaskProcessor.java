import java.time.LocalDateTime;

public class EmailTaskProcessor extends AbstractTaskProcessor {
    @Override
    public void processTask(Task task) {
        if(task instanceof DeadlineTask){
            DeadlineTask deadlineTask = (DeadlineTask) task;
            if(deadlineTask.getDeadline().isBefore(LocalDateTime.now())){
                System.out.println("The task deadline has already passed.");
                return;
            }
        }
        System.out.println("Email sent for task " + task.getTitle());
    }
}
