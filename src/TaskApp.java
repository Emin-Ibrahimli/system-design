import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskRepository<Task> repository = new TaskRepository<>();
        TaskService taskService = new TaskServiceImpl(repository);

        while (true) {
            System.out.println("\n===== Task Management System =====");
            System.out.println("1. Yeni tapşırıq əlavə et");
            System.out.println("2. Deadline ilə tapşırıq əlavə et");
            System.out.println("3. Bütün tapşırıqları göstər");
            System.out.println("4. ID ilə tapşırığı tap");
            System.out.println("5. ID ilə tapşırığı sil");
            System.out.println("6. Çıxış");
            System.out.print("Seçim: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Tapşırığın adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Tapşırığın açıqlaması: ");
                    String desc = scanner.nextLine();

                    Task task = new Task(TaskIdGenerator.generateId(), title, desc, LocalDateTime.now(), false, TaskStatus.NEW);
                    taskService.addTask(task);
                    System.out.println("Tapşırıq əlavə edildi!");
                    break;
                case 2:
                    System.out.print("Tapşırığın adı: ");
                    String dTitle = scanner.nextLine();
                    System.out.print("Tapşırığın açıqlaması: ");
                    String dDesc = scanner.nextLine();
                    System.out.print("Deadline (YYYY-MM-DDTHH:MM): ");
                    String deadlineInput = scanner.nextLine();
                    LocalDateTime deadline = LocalDateTime.parse(deadlineInput);

                    DeadlineTask dTask = new DeadlineTask(TaskIdGenerator.generateId(), dTitle, dDesc, LocalDateTime.now(), false, TaskStatus.NEW, deadline);
                    taskService.addTask(dTask);
                    if (deadline.isBefore(LocalDateTime.now())) {
                        System.out.println("Diqqət! Bu tapşırığın deadline keçib!");
                    } else {
                        System.out.println("Deadline ilə tapşırıq əlavə edildi!");
                    }
                case 3:
                    System.out.println("Bütün tapşırıqlar:");
                    taskService.listAllTasks().forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Silinəcək ID: ");
                    int delId = scanner.nextInt();
                    try {
                        taskService.removeTask(delId);
                        System.out.println("Tapşırıq silindi!");
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Sistem bağlanır...");
                    return;

                default:
                    System.out.println("Yanlış seçim, yenidən cəhd edin!");
            }
        }
    }
}
