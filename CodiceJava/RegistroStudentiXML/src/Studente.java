public class Studente {
    public Materia[] getMaterie() {
        return materie;
    }

//    public void setMaterie(Materia[] materie) {
//        this.materie = materie;
//    }

    public String getCognome() {
        return cognome;
    }

//    public void setCognome(String cognome) {
//        this.cognome = cognome;
//    }

    public String getMatricola() {
        return matricola;
    }

//    public void setMatricola(String matricola) {
//        this.matricola = matricola;
//    }

    public String getNome() {
        return nome;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public Studente(String matricola,String nome, String cognome, Materia[] materie) {
        this.nome = nome;
        this.matricola = matricola;
        this.cognome = cognome;
        this.materie = materie;
    }

    private String matricola;
    private String nome;
    private String cognome;
    private Materia[] materie;
}
