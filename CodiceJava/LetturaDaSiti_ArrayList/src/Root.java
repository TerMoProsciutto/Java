import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
public class Root {
    @JacksonXmlElementWrapper(localName = "users")
    @JacksonXmlProperty(localName = "user")

    private ArrayList<User> users;
    private Statistiche statistiche;

    public Root(ArrayList<User> users, Statistiche statistiche) {
        this.users = users;
        this.statistiche = statistiche;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Statistiche getStatistiche() {
        return statistiche;
    }

    public void setStatistiche(Statistiche statistiche) {
        this.statistiche = statistiche;
    }
}
