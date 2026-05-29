public class Todo {
    //userId, id, title, completed (boolean)
    private String userId;
    private String id;
    private String title;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public Todo(String userId, String id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public Todo() {
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }




}
