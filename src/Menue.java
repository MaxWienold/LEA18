

public class Menue {
	//1. Begrüßung
	//2. Menü Anzeigen
	
	public static String[][] funktionen = new String[4][2];
	
	
	public static void arrayAufbauen() {
	Menue.funktionen[0][0] = "Name";
	Menue.funktionen[0][1] = "Beschreibung";
	Menue.funktionen[1][0] = "Name";
	Menue.funktionen[1][1] = "Beschreibung";
	Menue.funktionen[2][0] = "Name";
	Menue.funktionen[2][1] = "Beschreibung";



	}
	
	
	public void schleife() {
		do{
		Ausgaben.menuAnzeigen();
		auswählen();
		programmStarten();
		}while(1<5);
	}

	
	public void outro() 
	{
		boolean geht = true;
		System.out.println("\nWas möchten Sie jetzt machen?"
				+ "\n[q] Beenden [a] Noch einmal ausführen [d] Etwas anderes "
				+ "ausprobieren ");
		
		do {
			String option = eingabe();
			switch(option) {
			case("q"):{
				System.out.println("Okay, Tschüss!");
				System.exit(0);
				geht = false;
				break;
			}
			case("a"):{
				programmStarten();
				geht = false;
				break;
			}
			case("d"):{
				geht = false;
				break;
			}
			default:{
				Ausgaben.fehler();
				
				break;
			}
			}
		}while(geht);
		
	}
	
	public String eingabe() {
		String input = RoemischeZahlen.eingabe.nextLine();
		return input;
		
	}
	
	public void auswählen() 
	{
		boolean geht= true;
		System.out.println("\nBitte ein Programm auswählen.");
		do {
			try {
				int auswahl = Integer.parseInt(eingabe());

				geht = false;
			}
			catch(Exception e){
				Ausgaben.fehler();
			}
		}while(geht);
	}
	
	public void programmStarten() {

		outro();
	}



	
	//3. Eingabe fordern und prüfen.
	//4. Funktion starten.
	
	
	
}
