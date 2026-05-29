public class Classe {
    private String nome_classe;
    private String[] destinazioni;
    private String[][] costi;


    public String getNomeClasse() {
        return nome_classe;
    }
//    public void setNomeClasse(String nome_classe) {
//        this.nome_classe = nome_classe;
//    }

    public String[] getDestinazioni() {
        return destinazioni;
    }
//    public void setDestinazioni(String[] destinazioni) {
//        this.destinazioni = destinazioni;
//    }

    public String[][] getCosti() {
        return costi;
    }
//    public void setCosti(String[][] costi) {
//        this.costi = costi;
//    }


    public Classe(String[][] costi, String[] destinazioni, String nome_classe) {
        this.costi = costi;
        this.destinazioni = destinazioni;
        this.nome_classe = nome_classe;
    }

}
