class Saluto
//Perché non ho usato import? perché ho usato solo classi che fanno parte del pacchetto fondamentale di java: java.lang. Tutte le classi che si trovano in quel pacchetto vengono importate automaticamente dal compilatore java in ogni singolo file. Se voglio usare una classe che non si trova nel pacchetto base (es: java.util.Scanner || java.util.Random) devo importarla esplicitamente all'inizio del file usando l'istruzione import.
{
	public //visibilità pubblica, a tutte le classi
	static //il metodo main è associato alla classe e esiste indipendentemente da istanze della classe, dice alla virtual machine di iniziare da main
	void //il metodo main non deve restituire valori
	main (String args[])
//se non inserisco i parametri il programma genera un eccezzione: un errore in run time dovuto al fatto che nel main si referenziano (presentano)  le variabili args all indice 0 e all indice 1 che, pero, non vengono inizializzate ArrayIndexOutOfBoundsException l indice di un array ha "sforato" i limiti (come se ne ho uno da 4 elementi e gli chiedo di leggermi il 5). l array in questione è args cioè l'array di stringhe che compare come parametro nel main. se nella linea di comando non vengono inseriti i parametri "Mario Rossi", il programma cerca gli elementi all'indice 0 e 1 ma non li trova. 
//Le eccezioni vengono generate durante l esecuzione del programma ossia non sono errori di sintassi nel codice bensì sono dovuti al verificarsi di eventi. Nel nostro caso, l'eccezione è dovuto ad un "errore" nella chiamata del programma saluto. Java prevede di *gestire le eccezioni* facendo in modo che il programma non si blocchi infatti se mandando in esecuzione non inserisco args 0 e args 1 java non visualizza un generico messaggio tipo "runtime error" come fanno altri linguaggi: si dice che java è un linguaggio sicuro perché evita il bloccarsi del programma e prevede la gestione delle eccezioni (ArrayIndexOutOfBoundsException) 
	{
		System.out.println(args[0]);//System è la classe; out è un'*attributo* della classe System il suo valore è un *oggetto* di tipo Print Stream sul quale viene chiamato il metodo print/println; println non è una parola chiave ma un estensione del nucleo di java: appartiene alla libreria "io" 
	}
}
//la funzione e il metodo sono 2 cose diverse:
//Funzione(c): Blocco di codice indipendente, libero che esegue un compito specifico; non appartiene ne ad una classe ne ad un oggetto
//Metodo(java): Blocco di codice dentro ad una classe o ad un oggetto si distingue tra metodo statico= metodo che appartiene alla classe (concetto *simile* alla funzione libera di altri linguaggi) e metodo di istanza(l'oggetto è un istanza di una classe)= metodo legato ad un oggetto e che, per tanto, può usare i dati/campi dell'oggetto
//NB: in java tutto deve stare dentro ad una classe
//es. oggetto auto; il campo è per esempio il colore
//i linguaggi hanno tutti delle parole chiave (if, while)
