
void main() {
    String a = "p", b = "zbc", c = "pippz";
    if (VerificaOrdineAlfabetico.verificaOrdineAlfabeticoStringhe(a, b) < 1) {
        System.out.println(a);
        if (VerificaOrdineAlfabetico.verificaOrdineAlfabeticoStringhe(b, c) < 1) {
            System.out.println(b + "\n" + c);
        }
    }
}

