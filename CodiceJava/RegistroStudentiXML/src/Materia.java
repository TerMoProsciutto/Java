public class Materia {
//    public String getNome() {
//        return nome;
//    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public double[] getVoti() {
        return voti;
    }

//    public void setVoti(double[] voti) {
//        this.voti = voti;
//    }

    public Materia(String nome, double[] voti) {
        this.nome = nome;
        this.voti = voti;
    }



    String nome;
    double[] voti;
}
