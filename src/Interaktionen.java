

public class Interaktionen {



	public static String[][] funktionen = new String[6][2];

	private static int auswahl = 0;



	public static void arrayAufbauen() {
		Interaktionen.funktionen[0][0] = "Erklärung";
		Interaktionen.funktionen[0][1] = "Lassen Sie sich erklären, wie die Umrechnung von lateinischen Zahlen funktioniert.";
		Interaktionen.funktionen[1][0] = "Arabisches Format";
		Interaktionen.funktionen[1][1] = "Hier können Sie lateinische Ziffern in arabische Zahlen umwandeln.";
		Interaktionen.funktionen[2][0] = "Lateinisches Format";
		Interaktionen.funktionen[2][1] = "Hier können Sie normale arabische Zahlen in lateinische Ziffern umwandeln.";
		Interaktionen.funktionen[3][0] = "Datei Formatieren";
		Interaktionen.funktionen[3][1] = "Hier können Sie die Zahlen in einem Fließtext komplett formatieren.";
		Interaktionen.funktionen[4][0] = "Lateinischer Rechner";
		Interaktionen.funktionen[4][1] = "Hier können Sie lateinische Zahlen addieren,subtrahieren und multiplizieren.";
		Interaktionen.funktionen[5][0] = "Arabischer Rechner";
		Interaktionen.funktionen[5][1] = "Hier können Sie arabische Zahlen addieren,subtrahieren dividieren und multiplizieren.";

	}


	public static void schleife() {
		do{
			Ausgaben.menuAnzeigen();
			auswählen();
			Ausgaben.funktionenIntro(auswahl);
			funktionStarten(auswahl);
		}while(1<5);
	}


	public static void outro() 
	{
		boolean geht = true;
		System.out.println("\nWas möchten Sie jetzt machen?"
				+ "\n[q] Beenden [a] Noch einmal ausführen [d] Etwas anderes "
				+ "ausprobieren ");

		do {
			String option = eingabeEmpfangen();
			switch(option) {
			case("q"):{
				System.out.println("Okay, Tschüss!");
				System.exit(0);
				geht = false;
				break;
			}
			case("a"):{
				funktionStarten(auswahl);
				geht = false;
				break;
			}
			case("d"):{
				geht = false;
				break;
			}
			default:{
				Ausgaben.fehlerAusgeben();

				break;
			}
			}
		}while(geht);

	}

	public static String eingabeEmpfangen() {
		String input = RoemischerRechner.eingabe.nextLine();
		return input;

	}
	
	public static int intEingabe() {
		int zahl = 0;
		boolean geht = true;
		do {
			try {
				zahl = Integer.parseInt(eingabeEmpfangen());

				geht = false;
			}
			catch(Exception e){
				Ausgaben.zahlenfehlerAusgeben();
			}
		}while(geht);
		
		return zahl;
	}

	public static int auswählen() 
	{
		boolean geht= true;
		Exception ex = new Exception();
		System.out.println("\nBitte ein Programm auswählen.");
		do {
			try {
				auswahl = Integer.parseInt(eingabeEmpfangen());
				if(auswahl < 1 || auswahl > funktionen.length)
					throw ex;
				geht = false;
			}
			catch(Exception e){
				Ausgaben.zahlenfehlerAusgeben();
			}
		}while(geht);

		return auswahl;
	}

	public static void funktionStarten(int auswahl) {
		switch (auswahl) {
		case(1):{
			Funktionen.erklaerung();
			break;
		}
		case(2):{
			Funktionen.arabisch();
			break;
		}
		case(3):{
			Funktionen.lateinisch();
			break;
		}
		case(4):{
			Funktionen.dateiFormatieren();
			break;
		}
		case(5):{
			Funktionen.latRechnen();
			break;
			}
		case(6):{
			Funktionen.arabRechnen();
			break;
			}
		default:{
			Ausgaben.fehlerAusgeben();
			break;
			}
		}



		outro();
	}






}
