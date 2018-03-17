import java.util.ArrayList;
import java.util.List;


public class Zahlformatierung {


	private static List<RoemischeZahlen> werte = new ArrayList<RoemischeZahlen>();
	private static List<RoemischeZahlen> fuenferwerte = new ArrayList<RoemischeZahlen>();
	public static void werteAufbauen() {
		werte.add(new RoemischeZahlen(10000, "ↂ"));
		werte.add(new RoemischeZahlen(9000, "Mↂ"));
		werte.add(new RoemischeZahlen(5000, "ↁ"));
		werte.add(new RoemischeZahlen(4000, "Mↁ"));
		werte.add(new RoemischeZahlen(1000, "M"));
		werte.add(new RoemischeZahlen(900, "CM"));
		werte.add(new RoemischeZahlen(500, "D"));
		werte.add(new RoemischeZahlen(400, "CD"));
		werte.add(new RoemischeZahlen(100, "C"));
		werte.add(new RoemischeZahlen(90, "XC"));
		werte.add(new RoemischeZahlen(50, "L"));
		werte.add(new RoemischeZahlen(40, "XL"));
		werte.add(new RoemischeZahlen(10, "X"));
		werte.add(new RoemischeZahlen(9, "IX"));
		werte.add(new RoemischeZahlen(5, "V"));
		werte.add(new RoemischeZahlen(4, "IV"));
		werte.add(new RoemischeZahlen(1, "I"));
		fuenferwerte.add(new RoemischeZahlen(5, "I"));
		fuenferwerte.add(new RoemischeZahlen(50, "L"));
		fuenferwerte.add(new RoemischeZahlen(500, "D"));
		fuenferwerte.add(new RoemischeZahlen(5000, "ↁ"));
	}
	public static boolean istGueltigArabisch(int zahl) {
		boolean gültig = true;
		if(zahl < 0) {
			System.out.println("Die Römer kannten keine negativen Zahlen.");
			gültig = false;


		}
		if(zahl > 39999){
			System.out.println("Dieser Rechner kann nur mit Zahlen bis 39999 umgehen.");
			gültig = false;
		}

		return gültig;
	}



	public static boolean istGueltigRoemisch(String text) {
		text = text.toUpperCase();
	
		boolean gueltigeZiffer = true;
		boolean gueltigeStelle = true;
		boolean gueltigeAnzahl = true;
		
		for (int i = 0; i < text.length(); i++) {
			//1. Prüfen, ob der char eine römische Ziffer ist.
			boolean ziffer = istRoemischeZiffer(text.charAt(i));
			if (gueltigeZiffer)
				gueltigeZiffer = ziffer;
			//2. Prüfen, ob der char an richtiger Stelle steht.			
			if (i + 1 < text.length()) { 
				boolean stelle = istAnGueltigerStelle(text.charAt(i), text.charAt(i + 1));

				if (gueltigeStelle)
					gueltigeStelle = stelle;
			}
			
			if (i + 3 < text.length()) {
				boolean anzahl = hatGueltigeAnzahl(text.charAt(i), text.charAt(i + 1), text.charAt(i + 2), text.charAt(i + 3));
				
				if(gueltigeAnzahl)
					gueltigeAnzahl = anzahl;
			}
			
			

		}

		if(!gueltigeAnzahl || !gueltigeStelle || !gueltigeZiffer) {
			Ausgaben.zahlenfehlerAusgeben();
			return false;
		}
		else
			return true;
	}
	
	
	
	

	public static boolean istRoemischeZiffer(char zeichen) {
		for (RoemischeZahlen ro : werte) {
			if(zeichen == ro.getText().charAt(0)) {
				return true;
			}

		}
		System.out.println(zeichen + " ist keine römische Ziffer.");
		return false;
	}

	
	
	
	public static boolean istAnGueltigerStelle(char erste, char zweite ) {
		String ersteStr = String.valueOf(erste);
		String zweiteStr = String.valueOf(zweite);
		//1. Prüfen, ob die nächste stelle größer ist.
		if (formatiertInArabisch(ersteStr) < formatiertInArabisch(zweiteStr) ) {
			//wenn ja, prüfen, ob die Kombination gültig ist.
			for (int i = 0; i < werte.size(); i++) {
				if(werte.get(i).getText().length() > 1) {
					if (erste == werte.get(i).getText().charAt(0) && zweite == werte.get(i).getText().charAt(1)) {

						return true;
					}
				}
			}

			System.out.println(erste + " darf nicht vor " + zweite + " stehen.");
			return false;
		}
		else

			return true;
	}
	
	
	
	
	public static boolean hatGueltigeAnzahl(char erste, char zweite, char dritte, char vierte) {
		if (erste == zweite && erste == dritte && erste == vierte)
			return false;
		else
			return true;
	}
	



	public static String formatiertInRoemisch(int zahl) {


		StringBuilder builder = new StringBuilder();
		while (zahl > 0) {
			for (RoemischeZahlen ro : werte) {
				int x = zahl - ro.getWert();
				if (x >= 0) {
					zahl = x;
					builder.append(ro.getText());
					break;
				}
			}
		}
		return builder.toString();
	}


	public static int formatiertInArabisch(String text) {
		text = text.toUpperCase();
		int zahl = 0;

		for (int a = 0 ; a < text.length(); a++){
			for (RoemischeZahlen ro : werte) {
				if (text.charAt(a) == ro.getText().charAt(0))
					if(a+1 < text.length() && ro.getText().length() > 1) {
						if(text.charAt(a+1) == ro.getText().charAt(1)) {
							zahl+= ro.getWert();
							a++;
						}
					}
					else if(ro.getText().length() == 1)
						zahl += ro.getWert();
			}

		}
		return zahl;
	}



}
