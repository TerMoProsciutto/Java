import java.time.LocalDate;

public class Ordine {

    private String nome;
    private String codice;
    private int quantita;
    private LocalDate data;

    public Ordine(String codice, String nome, int quantita, LocalDate data) {
        this.nome = nome;
        this.codice = codice;
        this.quantita = quantita;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
