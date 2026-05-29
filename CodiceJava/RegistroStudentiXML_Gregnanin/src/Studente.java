public class Studente {
    private String nome;
    private String cognome;
    private String matricola;
    private double[] medie;
    private String[] materie;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public double[] getMedie() {
        return medie;
    }

    public void setMedie(double[] medie) {
        this.medie = medie;
    }

    public String[] getMaterie() {
        return materie;
    }

    public void setMaterie(String[] materie) {
        this.materie = materie;
    }

}