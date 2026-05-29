import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class User {
    //id, name, username, email




    private String id;
    private String name;
    private String username;
    private String email;
    private Todo[] todos;
    private double percentualeCompletamentoTodos;
    private int completedTodo;
    private int numeroDiTodo;


    public int getNumeroDiTodo() {
        return numeroDiTodo;
    }

    public void setNumeroDiTodo(int numeroDiTodo) {
        this.numeroDiTodo = numeroDiTodo;
    }

    public int getCompletedTodo() {
        return completedTodo;
    }

    public void setCompletedTodo(int completedTodo) {
        this.completedTodo = completedTodo;
    }

    public void setPercentuale(double percentuale) {
        if (percentuale >= 0 && percentuale <= 100) {
            this.percentualeCompletamentoTodos = percentuale;
        } else {
            System.out.println("Percentuale invalida");
        }
    }

    public double getPercentuale() {
        return this.percentualeCompletamentoTodos;
    }

    public User(String id, String name, String username, String email, Todo[] todos) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.todos = todos;
    }

    public User() {
    }
    @JacksonXmlElementWrapper(localName = "todos")
    @JacksonXmlProperty(localName = "todo")
    public Todo[] getTodos() {
        return todos;
    }

    public void setTodos(Todo[] todos) {
        this.todos = todos;
    }

    public void setTodo(Todo todo, int pos) {
        this.todos[pos] = todo;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
