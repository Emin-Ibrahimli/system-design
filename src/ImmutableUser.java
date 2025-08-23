public final class ImmutableUser {

   private final int id;
   private final String name;

    public ImmutableUser(int id, String name) {
        this.id = id;
        this.name = name;
        Task.addUser(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
