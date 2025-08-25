import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskRepository<Task> repository = new TaskRepository<>();
        TaskService taskService = new TaskServiceImpl(repository);

        while (true) {
            System.out.println("\n===== Task Management System =====");
            System.out.println("1. Enter the user");
            System.out.println("2. Add a new task");
            System.out.println("3. Add task with deadline");
            System.out.println("4. Show all tasks");
            System.out.println("5. Find task by ID");
            System.out.println("6. Delete task by ID ");
            System.out.println("7. Number of users");
            System.out.println("8. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the user name: ");
                    String userName = scanner.nextLine();

                    ImmutableUser user = new ImmutableUser(userId, userName);
                    System.out.println("User created successfully!");
                    break;

                case 2:
                    System.out.print("The name of the task: ");
                    String title = scanner.nextLine();
                    System.out.print("Task description: ");
                    String desc = scanner.nextLine();

                    Task task = new Task(TaskIdGenerator.generateId(), title, desc, LocalDateTime.now(), false, TaskStatus.NEW);
                    taskService.addTask(task);
                    System.out.println("Task added!");
                    break;

                case 3:
                    System.out.print("The name of the task: ");
                    String dTitle = scanner.nextLine();
                    System.out.print("Task description: ");
                    String dDesc = scanner.nextLine();
                      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    System.out.println("Please write in the form indicated: Year-Month-Day Hour:Minute:Second");

                      String deadlineInput = scanner.nextLine();
                      LocalDateTime deadline = LocalDateTime.parse(deadlineInput, formatter);

                    DeadlineTask dTask = new DeadlineTask(TaskIdGenerator.generateId(), dTitle, dDesc, LocalDateTime.now(), false, TaskStatus.NEW, deadline);
                    taskService.addTask(dTask);

                    if (deadline.isBefore(LocalDateTime.now())) {
                        System.out.println("Attention! The deadline for this assignment has passed!");
                    } else {
                        System.out.println("Task with deadline added!");
                    }
                    break;

                case 4:
                    System.out.println("All tasks:");
                    taskService.listAllTasks().forEach(System.out::println);
                    if(taskService.listAllTasks().isEmpty()){
                        System.out.println("Task not found!");
                    }
                    break;

                case 5:
                    System.out.println("Enter your ID: ");
                    int foundId = scanner.nextInt();
                    repository.findById(foundId).ifPresent(System.out::println);
                    if (!repository.findById(foundId).isPresent()) {
                        System.out.println("ID not found");
                    }
                    break;


                case 6:
                    System.out.print("The ID to delete: ");
                    int delId = scanner.nextInt();
                    try {
                        taskService.removeTask(delId);
                        System.out.println("Task deleted!");
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Number of users: ");
                    repository.numUser();
                    break;

                case 8:
                    System.out.println("System shutdown...");
                    return;

                default:
                    System.out.println("Wrong choice, try again!");
            }
        }
    }
}
