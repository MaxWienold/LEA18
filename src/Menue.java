

public class Menue {



	public static String[][] funktionen = new String[5][2];

	private static int auswahl = 0;



	public static void arrayAufbauen() {
		Menue.funktionen[0][0] = "Erklärung";
		Menue.funktionen[0][1] = "Lassen Sie sich erklären, wie die Umrechnung von lateinischen Zahlen funktioniert.";
		Menue.funktionen[1][0] = "Arabisches Format";
		Menue.funktionen[1][1] = "Hier können Sie lateinische Ziffern in arabische Zahlen umwandeln.";
		Menue.funktionen[2][0] = "Lateinisches Format";
		Menue.funktionen[2][1] = "Hier können Sie normale arabische Zahlen in lateinische Ziffern umwandeln.";
		Menue.funktionen[3][0] = "Datei Formatieren";
		Menue.funktionen[3][1] = "Hier können Sie die Zahlen in einem Fließtext komplett formatieren.";
		Menue.funktionen[4][0] = "Rechner";
		Menue.funktionen[4][1] = "Hier können Sie lateinische Zahlen addieren und subtrahieren.";


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
			Funktionen.erklärung();
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
		}
		case(5):{
			Funktionen.rechnen();
		}
		default:{
			Ausgaben.fehlerAusgeben();
		}
		}



		outro();
	}




	//3. Eingabe fordern und prüfen.
	//4. Funktion starten.



}
