

public class Rechnungen {

	public static void plusAra() {

		System.out.print("Wie viele Zahlen moechten sie addieren? ");
		int anzahl = Interaktionen.intEingabe();
		int summe = 0;		//Summe (ergebnis der Rechnung)

		for(int i = 0; i<anzahl; i++ ){

			System.out.print("Geben sie die " + i + 1 + " Zahl ein: ");
			int zahl = Interaktionen.intEingabe();
			
			summe += zahl;

		}
		System.out.println(summe);
		System.out.println(Zahlformatierung.formatiertInRoemisch(summe));
	}

	public static void minusAra() {
		System.out.println("Geben sie 2 zu Subtrahierende Zahlen ein");
		System.out.print("Zahl 1: ");
		int zahlmin1 = Interaktionen.intEingabe();
		System.out.print("Zahl 2: ");
		int zahlmin2 = Interaktionen.intEingabe();
		int differenz = 0;		//Ergebnis der Rechnung
		for(int x = 0; x == 0;){
			if (zahlmin1 > zahlmin2)
			{
				differenz = zahlmin1 - zahlmin2;
				x++;
			}
			else if (zahlmin1 < zahlmin2)
			{
				System.out.println("Zahl 1 darf nicht groesser als Zahl 2 sein geben sie die werte erneut ein");
				System.out.print("Zahl 1: ");
				zahlmin1 = Interaktionen.intEingabe();
				System.out.print("Zahl 2: ");
				zahlmin2 = Interaktionen.intEingabe();
			}
			else if(zahlmin1 == zahlmin2){
				System.out.println("Zahl 1 darf nicht gleich Zahl 2 sein geben sie die werte erneut ein");
				System.out.print("Zahl 1: ");
				zahlmin1 = Interaktionen.intEingabe();
				System.out.print("Zahl 2: ");
				zahlmin2 = Interaktionen.intEingabe();
			}
			System.out.println(Zahlformatierung.formatiertInRoemisch(differenz));
		}
	}

	public static void multiplizierenAra() {
		System.out.print("Wie viele Zahlen moechten sie multiplizieren? ");
		int anzahl2 = Interaktionen.intEingabe();
		int produkt = 1;	//Produkt(Ergebnis der Rechnung)
		int b = 1;			//Anzahl der zu multiplizierenden Zahlen
		for(int z = 0; z<anzahl2; z++ ){
			System.out.print("Geben sie die " + b + " Zahl ein: ");
			int zahl = Interaktionen.intEingabe();
			produkt *= zahl;
			b++;
		}
		System.out.println(produkt);
		System.out.println(Zahlformatierung.formatiertInRoemisch(produkt));
	}

	public static void plusRoem() {
		System.out.print("Wie viele Zahlen moechten sie addieren? ");
		int anzahl = Interaktionen.intEingabe();
		int summe = 0;		//Summe (ergebnis der Rechnung)
			//Anzahl der zu addierenden Zahlen
		String zahl = "";
		for(int i = 0; i < anzahl; i++ ){
			boolean geht = false;
			
			do {
				System.out.print("Geben sie die " + (i + 1) + " Roemische Zahl ein: ");
				zahl = Interaktionen.eingabeEmpfangen();
				geht = Zahlformatierung.istGueltigRoemisch(zahl);
			}while(!geht);
			
			

			
			summe +=Zahlformatierung.formatiertInArabisch(zahl);
	
		}
		System.out.println(summe);	
	}

	public static void minusRoem() {
		System.out.println("Geben sie 2 zu subtrahierende römische Zahlen ein");

		boolean geht = false;
		String zahlmin1 = "";
		do {
			System.out.print("Roemische Zahl 1: ");
			zahlmin1 = Interaktionen.eingabeEmpfangen();
			geht = Zahlformatierung.istGueltigRoemisch(zahlmin1);
		}while(!geht);
		geht = false;
		
		String zahlmin2 = "";
		do {
			System.out.print("Roemische Zahl 2: ");
			zahlmin2 = Interaktionen.eingabeEmpfangen();
			geht = Zahlformatierung.istGueltigRoemisch(zahlmin2);
		}while(!geht);

		int min1 = Zahlformatierung.formatiertInArabisch(zahlmin1);
		int min2 = Zahlformatierung.formatiertInArabisch(zahlmin2);
		int differenz = min1 - min2;		//Ergebnis der Rechnung
		System.out.println(zahlmin1 + "-" + zahlmin2 + "=" + differenz);
	}

	public static void multiplizierenRoem() {
		System.out.print("Wie viele Zahlen moechten sie multiplizieren? ");
		int anzahl2 = Interaktionen.intEingabe();
		int produkt = 1;	//Produkt(Ergebnis der Rechnung)
		String zahl = "";
		//Anzahl der zu multiplizierenden Zahlen
		for(int z = 0; z < anzahl2; z++ ){
			boolean geht = false;
			
			do {
				System.out.print("Geben sie die " + z+1 + " Roemische Zahl ein: ");
				zahl = Interaktionen.eingabeEmpfangen();
				geht = Zahlformatierung.istGueltigRoemisch(zahl);
			}while(!geht);


			int x = Zahlformatierung.formatiertInArabisch(zahl);
			produkt *= x;

		}
		System.out.println(produkt);
	}

	public static void dividierenRoem() {
		System.out.println("Geben sie 2 zu Dividierende Roemische Zahlen ein");
		boolean geht = false;
		String zahl1 = "";
		do {
			System.out.print("Roemische Zahl 1: ");
			zahl1 = Interaktionen.eingabeEmpfangen();
			geht = Zahlformatierung.istGueltigRoemisch(zahl1);
		}while(!geht);
		geht = false;
		
		String zahl2 = "";
		do {
			System.out.print("Roemische Zahl 2: ");
			zahl2 = Interaktionen.eingabeEmpfangen();
			geht = Zahlformatierung.istGueltigRoemisch(zahl2);
		}while(!geht);
		
		double zahldiv1 = Zahlformatierung.formatiertInArabisch(zahl1);
		double zahldiv2 = Zahlformatierung.formatiertInArabisch(zahl2);
		double quotient = zahldiv1 / zahldiv2;
		System.out.println(zahl1 + ":" + zahl2 + "=" + quotient);
	}

}
