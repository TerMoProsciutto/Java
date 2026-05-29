import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() throws IOException, InterruptedException {
    ArrayList<User> usersList = new ArrayList<>();
    ArrayList<Todo> todosList = new ArrayList<>();


    long timer1 = System.currentTimeMillis();

    letturaSito(usersList, todosList);

    long timer2 = System.currentTimeMillis();

    assegnazioneTodos(usersList, todosList);

    long timer3 = System.currentTimeMillis();

    calcoloPercentualeTodosCompletati(usersList);

    long timer4 = System.currentTimeMillis();

    String idUtentePiuCompletati = calcolaUtenteConPiuTodoCompletati(usersList);

    String idUtenteMenoCompletati = calcolaUtenteConMenoTodoCompletati(usersList);

    long timer5 = System.currentTimeMillis();

    double percentualeTotale = calcolaPercentualeTotaleCompletamento(usersList);

    double numeroMedioTodos = calcolaMediaTodos(usersList);

    Statistiche statistiche = new Statistiche(idUtentePiuCompletati, idUtenteMenoCompletati, percentualeTotale, numeroMedioTodos);

    long timer6 = System.currentTimeMillis();

    creaXML(usersList, statistiche);

    long timer7 = System.currentTimeMillis();


    VisualizzaTempi(timer2, timer1, timer3, timer4, timer5, timer7, timer6);
    System.out.println("Il file è stato creato correttamente!!");
}

public static void VisualizzaTempi(long timer2, long timer1, long timer3, long timer4, long timer5, long timer7, long timer6) {
    System.out.println("\n-------------------------TABELLA DEI TEMPI-------------------------");
    System.out.println("Tempo lettura da sito: " + (timer2 - timer1) + "ms");
    System.out.println("Tempo assegnazione todos: " + (timer3 - timer2) + "ms");
    System.out.println("Tempo calcolo percentuale, numero completato e numero di todos: " + (timer4 - timer3) + "ms");
    System.out.println("Tempo calcolo user con piu e meno todos completati: " + (timer5 - timer4) + "ms");
    System.out.println("Tempo impiegato alla scrittura dell'xml: " + (timer7 - timer6) + "ms");
    System.out.println("Tempo totale: " + (timer7 - timer1) + "ms");
    System.out.println("--------------------------------------------------------------------\n");

}

public void creaXML(ArrayList<User> usersList, Statistiche statistiche) throws IOException {
    Root dati = new Root(usersList, statistiche);
    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    xmlMapper.writeValue(new File("report.xml"), dati);
}

public double calcolaMediaTodos(ArrayList<User> usersList) {
    double media = 0;

    for (int i = 0; i < usersList.size(); i++) {
        media += usersList.get(i).getNumeroDiTodo();
    }

    return media / usersList.size();
}

public double calcolaPercentualeTotaleCompletamento(ArrayList<User> usersList) {
    double percentualeTotale = 0;

    for (int i = 0; i < usersList.size(); i++) {
        percentualeTotale += usersList.get(i).getPercentuale();
    }

    return percentualeTotale / usersList.size();
}

public String calcolaUtenteConMenoTodoCompletati(ArrayList<User> usersList) {
    int min = 0;

    for (int i = 1; i < usersList.size(); i++) {
        if (usersList.get(i - 1).getCompletedTodo() > usersList.get(i).getCompletedTodo()) {
            min = i;
        }
    }

    return usersList.get(min).getId();
}

public String calcolaUtenteConPiuTodoCompletati(ArrayList<User> usersList) {
    int max = 0;

    for (int i = 1; i < usersList.size(); i++) {
        if (usersList.get(i - 1).getCompletedTodo() < usersList.get(i).getCompletedTodo()) {
            max = i;
        }
    }

    return usersList.get(max).getId();
}

public void calcoloPercentualeTodosCompletati(ArrayList<User> usersList) {
    for (int i = 0; i < usersList.size(); i++) {
        int contaCompletati = 0;
        int lunghezzaTodosUser = usersList.get(i).getTodos().length;
        for (int j = 0; j < lunghezzaTodosUser; j++) {
            if (usersList.get(i).getTodos()[j].isCompleted())
                contaCompletati++;
        }
        usersList.get(i).setPercentuale((double) contaCompletati / lunghezzaTodosUser * 100);
        usersList.get(i).setCompletedTodo(contaCompletati);
        usersList.get(i).setNumeroDiTodo(lunghezzaTodosUser);
    }
}

public static void assegnazioneTodos(ArrayList<User> usersList, ArrayList<Todo> todosList) {
    for (int i = 0, k = 0; i < usersList.size(); i++) {
        ArrayList<Todo> todosUser = new ArrayList<>();

        while (todosList.get(k).getUserId().equals(usersList.get(i).getId())) {
            todosUser.add(todosList.get(k));
            k++;
            if (k == todosList.size())
                break;
        }
        Todo[] todos = new Todo[todosUser.size()];
        todosUser.toArray(todos);
        usersList.get(i).setTodos(todos);
    }
}

public static void letturaSito(ArrayList<User> usersList, ArrayList<Todo> todosList) throws IOException, InterruptedException {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//serve per non leggere le cose inutili

    usersList.addAll(Arrays.asList(mapper.readValue(new URL("https://jsonplaceholder.typicode.com/users"), User[].class)));
    todosList.addAll(Arrays.asList(mapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), Todo[].class)));


}