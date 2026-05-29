public class GeneraStudenti {
    public static String[][] main() {
        int i = 0, numerostudenti = 11, datiperstudente = 4;
        String[][] studente = new String[numerostudenti][datiperstudente];
        String dominio = "@iisviolamarchesini.edu.it";

        String nome = "Stefano";
        String cognome = "Bonomo";
        String mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        String mediavoti = "4.7";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;


        nome = "Denny";
        cognome = "Ferrari";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "3.9";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Giovanni";
        cognome = "Ghirotto";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "9.3";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Elia";
        cognome = "Giordani";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "7.4";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Hongjie";
        cognome = "Jiang";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "9.9";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Federico";
        cognome = "Mori";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "3.9";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Oleksii";
        cognome = "Naftulovych";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "6.7";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Federico";
        cognome = "Roccatello";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "6.3";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Mattia";
        cognome = "Trivellato";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "8.4";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Axel";
        cognome = "Venturini";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "8.5";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        i++;

        nome = "Alex";
        cognome = "Veronese";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "7.3";

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;

        return studente;
    }
}
