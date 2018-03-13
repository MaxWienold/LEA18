import java.util.Scanner;

public class RoemischeZahlen {

	public static Scanner eingabe = new Scanner(System.in);

	public static void main(String[] args) {
		Menue.arrayAufbauen();
		Ausgaben.menuAnzeigen();
		
		
		Scanner leser = new Scanner(System.in);
		int zahl = leser.nextInt();
		System.out.println(Zahlformatierung.arabischRömisch(zahl));
		leser.close();
	}
}
