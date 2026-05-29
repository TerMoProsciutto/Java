public class Persona {
    private String nome;
    private String cognome;
    private String numero;

    public Persona(String nome, String cognome, String numero) {
        if (numero.length() != 10) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 10; i++) {
            if (numero.charAt(i) != '0' && numero.charAt(i) != '1' && numero.charAt(i) != '2' && numero.charAt(i) != '3' && numero.charAt(i) != '4' && numero.charAt(i) != '5' && numero.charAt(i) != '6' && numero.charAt(i) != '7' && numero.charAt(i) != '8' && numero.charAt(i) != '9') {
                throw new IllegalArgumentException();
            }
        }
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
