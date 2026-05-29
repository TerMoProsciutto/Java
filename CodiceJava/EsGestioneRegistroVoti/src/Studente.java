public class Studente {

    private String nome;
    private String matricola;
    private float voto;


    public Studente(String matricola, String nome, float voto) {
        this.nome = nome;
        this.matricola = matricola;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricola() {
        return matricola;
    }

    public float getVoto() {
        return voto;
    }

    public void setVoto(float voto) {
        this.voto = voto;
    }

}
