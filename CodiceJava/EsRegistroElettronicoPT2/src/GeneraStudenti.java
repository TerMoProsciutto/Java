public class GeneraStudenti {
    public static String[][] main() {
        int i = 0, numerostudenti = 11, datiperstudente = 4;
        // String[] materie= {"italiano","storia","tpsit","informatica","inglese","sistemi e reti","matematica","telecomunicazioni","educazione civica","religione","scienze motorie"};
        String[][] studente = new String[numerostudenti][datiperstudente];
        String dominio = "@iisviolamarchesini.edu.it";
        float media = 0;

        String nome = "Stefano";
        String cognome = "Bonomo";
        String mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;

        float[] voti = {5.5F, 4.25F, 6.25F, 8.5F, 7.5F, 5.5F, 6, 8.5F, 7.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        String mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;


        nome = "Denny";
        cognome = "Ferrari";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "3.9";

        voti = new float[]{4.5F, 2.22F, 8.25F, 6.5F, 7.5F, 5.5F, 6, 8.5F, 6.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Giovanni";
        cognome = "Ghirotto";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "9.3";

        voti = new float[]{4.5F, 10F, 6.25F, 7.5F, 2.5F, 5.5F, 6.5F, 8.5F, 6.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Elia";
        cognome = "Giordani";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "7.4";

        voti = new float[]{4.5F, 7.75F, 8.25F, 6.5F, 7.5F, 5.5F, 6.75F, 8.5F, 7.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Hongjie";
        cognome = "Jiang";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "9.9";

        voti = new float[]{4.5F, 8F, 8.25F, 6.5F, 7.5F, 5.5F, 8, 8.5F, 6.75F, 7.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Federico";
        cognome = "Mori";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "3.9";

        voti = new float[]{4.5F, 6.75F, 8.25F, 6.5F, 7.5F, 4.5F, 6, 8.5F, 6.75F, 3.75F, 6.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Oleksii";
        cognome = "Naftulovych";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "6.7";

        voti = new float[]{4.5F, 4.4F, 8.25F, 6.5F, 7.5F, 6.5F, 7.5F, 8.5F, 6.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Federico";
        cognome = "Roccatello";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "6.3";

        voti = new float[]{6.5F, 2.22F, 8.25F, 6, 7.5F, 5.5F, 6, 8.5F, 8.75F, 9.25F, 8};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Mattia";
        cognome = "Trivellato";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "8.4";

        voti = new float[]{7.25F, 6.5F, 8.25F, 6.5F, 7.75F, 6.5F, 6, 8.5F, 5.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Axel";
        cognome = "Venturini";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "8.5";

        voti = new float[]{4.5F, 8F, 8.25F, 6.5F, 7.5F, 5.5F, 6, 8.5F, 6.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;
        media = 0;
        i++;

        nome = "Alex";
        cognome = "Veronese";
        mail = nome.toLowerCase() + "." + cognome.toLowerCase() + dominio;
        mediavoti = "7.3";

        voti = new float[]{7.5F, 7, 8.25F, 6.5F, 7.5F, 5.5F, 6.75F, 8.5F, 6.75F, 9.25F, 8.75F};
        for (int k = 0; k < voti.length; k++) {
            media += voti[k];
        }
        media /= voti.length;
        mediavoti = String.valueOf(media);

        studente[i][0] = nome;
        studente[i][1] = cognome;
        studente[i][2] = mail;
        studente[i][3] = mediavoti;

        return studente;
    }
}
