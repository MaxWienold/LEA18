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
		if(zahl > 61109){
			System.out.println("Dieser Rechner kann nur mit Zahlen bis 61109 umgehen.");
			gültig = false;
		}
		
		return gültig;
	}
	public static boolean istGueltigRoemisch(String text) {
		StringBuilder zeichen = new StringBuilder();
		boolean gültigZeichen = false;
		boolean gültig = false;
		for (int i = 0; i < text.length(); i++) {
									//Überprüfen, ob das Zeichen eine römische Ziffer ist.
			for (int j = 0; j < werte.size(); j++) {
				if (text.charAt(i) == werte.get(j).getText().charAt(0)) {
												
					gültigZeichen = true; 
					gültig = true;
									//Überprüfen, ob das Zeichen vor dem nächsten stehen darf.
					if(i+1 < text.length() && werte.get(j).getText().length() > 1) {
						if(text.charAt(i+1) != werte.get(j).getText().charAt(1) ) {
							if(text.charAt(i+1) != werte.get(j+2).getText().charAt(1)) {
								if(text.charAt(i+1) != text.charAt(i)) {
									System.out.println(text.charAt(i) + " darf nicht vor " + text.charAt(i+1) + " stehen.");
									gültig = false;
								}
							}
						}

					}
					else {
						if(j > 3 ) {
							System.out.println(text.charAt(i) + " darf nicht vor " + text.charAt(i+1) + " stehen.");

							gültig = false;
						}
						if(i+1 < text.length()) {
							
							if(text.charAt(i+1) != werte.get(j - 1).getText().charAt(1) ){
								if(text.charAt(i+1) != werte.get(j - 3).getText().charAt(1)) {
									System.out.println(text.charAt(i) + " darf nicht vor " + text.charAt(i+1) + " stehen.");

									gültig = false;
								}

							}
						}
					}
					j = werte.size();
				}



			}
								//ungültige Zeichen zusammenfassen
			if(!gültigZeichen) {
				zeichen.append(text.charAt(i)+ " ");

			}
			if(i < text.length() - 1)
				gültigZeichen = false;
		}

		if (!gültigZeichen) {
			System.out.print(zeichen.toString());
			if (zeichen.toString().length() > 2)
				System.out.println("sind keine lateinischen Ziffern.");
			else
				System.out.println("ist keine gültige lateinische Ziffer.");

			gültig = false;
		}
										//Überprüfen, ob die Subtraktionsregel erfüllt ist
		for (int i = 0; i < text.length(); i++) {
			if(text.length() - i > 3)
				if(text.charAt(i) == text.charAt(i + 1) && text.charAt(i) == text.charAt(i + 2) && text.charAt(i) == text.charAt(i + 3)) {
					
					System.out.println("Es dürfen keine vier " + text.charAt(i) +" hintereinander stehen.");
					gültig = false;
				}

		}
		if(!gültig)
			Ausgaben.zahlenfehlerAusgeben();
		return gültig;

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


	public static void ausgabeTest() {
		int gesamt = 0;
		for (RoemischeZahlen ro : werte) {
			gesamt += ro.getWert() * 3;
		}
		System.out.println(gesamt);
	}
}
