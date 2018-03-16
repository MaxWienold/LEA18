public class Ausgaben {
	

	
	public static void menuAnzeigen() 
	{

		for(int i = 0; i < Menue.funktionen.length; i++) {
			System.out.println("[" + (i+1) + "]\t" + Menue.funktionen[i][0]);

		}
	}
	public static void fehlerAusgeben() {
		System.out.println("Das hat nicht geklappt, bitte nochmal probieren.");
		
	}
	public static void zahlenfehlerAusgeben() {
		System.out.println("Das ist keine gültige Zahl! Bitte probieren Sie es nochmal.");
		
	}
	
	public static void funktionenIntro(int auswahl) {
		System.out.println(Menue.funktionen[auswahl - 1][1]);
	}
}
