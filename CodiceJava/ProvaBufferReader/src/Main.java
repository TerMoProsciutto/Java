void main() throws IOException {
    String parola = "", frase = "";
    BufferedReader in = new BufferedReader(new FileReader("/home/Denny_Ferrari/IdeaProjects/ProvaBufferReader/src/file.csv"));

    do {
        parola = in.readLine();
        if (parola == null) {
            break;
        }
        frase += parola;
    } while (true);

    System.out.println(frase+"\n");

    String[] pippo = frase.split(";");

    for (int i = 0; i < pippo.length; i++) {
        System.out.println(pippo[i]);
    }
}
