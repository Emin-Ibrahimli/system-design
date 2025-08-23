public class TaskIdGenerator {
    private static int currentId = 0;

    public static int generateId() {
        return ++currentId;
    }
}
