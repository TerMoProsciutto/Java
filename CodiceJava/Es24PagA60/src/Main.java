 void main {
        Scanner keyboard = new Scanner(System.in);
        int n, prec = -256000, tot, i = 0;
        System.out.println("Quanti numeri vuoi inserire?(verifico che siano disposti in ordine crescente)");
        tot = keybord.nextInt();
        for (int i = 0; i < tot; i++) {
            n = keyboard.nextInt();
            if (n < prec)
                i = 1;
            prec = n;
        }
        if (i = 1) {
            System.out.println("I numeri non sono in ordine crescente");
        } else {
            System.out.println("I numeri sono in ordine crescente");
        }
    }