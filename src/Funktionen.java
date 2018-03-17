import java.awt.Menu;
import java.io.File;

import javax.swing.MenuElement;

public class Funktionen {
	
	public static void erklaerung() {
		System.out.println("Die Römer verwendeten folgende Ziffern: \n"
				+ "I=1, V=5, X=10, L=50, C=100, D=500, M=1000, \n"
				+ "ↁ=5000, ↂ=10000. Diese werden einfach aneinandergereiht und zusammengezählt. \n"
				+ "Ausnahme: Steht einer dieser Buchstaben vor einem mit einem höheren Wert, \n"
				+ "so wird dieser Buchstabe vom Wert "
				+ "der Zahl abgezogen(z.B 4= IV also V-I oder auch 5-1). \n"
				+ "Man darf allerdings nicht V=5, L=50, D=500 und " 
				+ "ↁ=5000 von größeren Werten abziehen.");
		
	}
	public static void lateinisch() {
		System.out.println("Geben sie eine arabische Zahl ein um eine römische zu erhalten: ");
		int zahl = Interaktionen.intEingabe();
		System.out.println(Zahlformatierung.formatiertInRoemisch(zahl));
	}
	
	public static void arabisch() {

		boolean geht = false;
		String zahl = "";

		
			do {
				System.out.println("Geben sie eine römische Zahl ein um eine arabische zu erhalten: ");
				zahl = Interaktionen.eingabeEmpfangen();
				geht = Zahlformatierung.istGueltigRoemisch(zahl);
			}while(!geht);

		System.out.println(Zahlformatierung.formatiertInArabisch(zahl));
	}
	
	public static void dateiFormatieren() {
		
		String pfad = "";
		boolean geht = false;
		do {
			System.out.println("Bitte den absoluten Pfad zur Textdatei angeben:");
			pfad = Interaktionen.eingabeEmpfangen();
			geht = new File(pfad).isFile();
		} while (!geht);
		

		Dateianalyse.zahlenAendern(pfad);
		
		
		
		
	}
	public static void latRechnen() {
		System.out.println("möchten sie Zahlen [a]ddieren, [s]ubtrahieren, [d]ividieren oder [m]ultiplizieren?");
		boolean geht = true;
		do {
			String option = Interaktionen.eingabeEmpfangen();
			switch(option) {
			case("a"):{
				Rechnungen.plusRoem();
				geht = false;
				break;
			}
			case("s"):{
				Rechnungen.minusRoem();
				geht = false;
				break;
			}
			case("d"):{
				Rechnungen.dividierenRoem();
				geht = false;
			}
			case("m"):{
				Rechnungen.multiplizierenRoem();
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
	public static void arabRechnen() {
		System.out.println("möchten sie Zahlen [a]ddieren, [s]ubtrahieren, oder [m]ultiplizieren?");
		boolean geht = true;
		do {
			String option = Interaktionen.eingabeEmpfangen();
			switch(option) {
			case("a"):{
				Rechnungen.plusAra();
				geht = false;
				break;
			}
			case("s"):{
				Rechnungen.minusAra();
				geht = false;
				break;
			}

			case("m"):{
				Rechnungen.multiplizierenAra();
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

}
