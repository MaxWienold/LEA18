public class Ausgaben {
	
	public static void menuAnzeigen() 
	{

		for(int i = 0; i < Menue.funktionen.length; i++) {
			System.out.println("[" + (i+1) + "]\t" + Menue.funktionen[i][0]);

		}
	}
	public  static void fehler() {
		System.out.println("Das hat nicht geklappt, bitte nochmal probieren.");
		
	}
}
