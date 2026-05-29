public class Magazzino {

    private String nome;
    private String codice;
    private int quantita;

    public Magazzino(String codice, String nome, int quantita) {
        this.nome = nome;
        this.codice = codice;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

}
