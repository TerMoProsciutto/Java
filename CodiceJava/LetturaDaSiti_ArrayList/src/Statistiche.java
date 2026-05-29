public class Statistiche {
    private String idUtentePiuCompletati;
    private String idUtenteMenoCompletati;
    private double percentualeTotale;
    private double numeroMedioTodos;

    public Statistiche(String idUtentePiuCompletati, String idUtenteMenoCompletati, double percentualeTotale, double numeroMedioTodos) {
        this.idUtentePiuCompletati = idUtentePiuCompletati;
        this.idUtenteMenoCompletati = idUtenteMenoCompletati;
        this.percentualeTotale = percentualeTotale;
        this.numeroMedioTodos = numeroMedioTodos;
    }

    public String getIdUtentePiuCompletati() {
        return idUtentePiuCompletati;
    }

    public void setIdUtentePiuCompletati(String idUtentePiuCompletati) {
        this.idUtentePiuCompletati = idUtentePiuCompletati;
    }

    public String getIdUtenteMenoCompletati() {
        return idUtenteMenoCompletati;
    }

    public void setIdUtenteMenoCompletati(String idUtenteMenoCompletati) {
        this.idUtenteMenoCompletati = idUtenteMenoCompletati;
    }

    public double getPercentualeTotale() {
        return percentualeTotale;
    }

    public void setPercentualeTotale(double percentualeTotale) {
        this.percentualeTotale = percentualeTotale;
    }

    public double getNumeroMedioTodos() {
        return numeroMedioTodos;
    }

    public void setNumeroMedioTodos(double numeroMedioTodos) {
        this.numeroMedioTodos = numeroMedioTodos;
    }
}
