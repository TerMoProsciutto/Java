public class Farmaco {
    private String nomeFarmaco;
    private String nomeAzienda;
    private String nomeMalattia;
    private double costo;
    private String tipoDiFarmaco;


    public Farmaco(String nomeFarmaco, String nomeAzienda, String nomeMalattia, double costo, String tipoDiFarmaco) {
        this.nomeFarmaco = nomeFarmaco;
        this.nomeAzienda = nomeAzienda;
        this.nomeMalattia = nomeMalattia;
        this.costo = costo;
        this.tipoDiFarmaco = tipoDiFarmaco;
    }




    public String getNomeFarmaco() {
        return nomeFarmaco;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getNomeMalattia() {
        return nomeMalattia;
    }

    public double getCosto() {
        return costo;
    }

    public String getTipoDiFarmaco() {
        return tipoDiFarmaco;
    }


}
