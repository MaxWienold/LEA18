import java.util.ArrayList;
import java.util.List;


public class Zahlformatierung {
	public static String arabischRömisch(int eingabe) {
		
		List<RoemischeZahlenHelper> werte = new ArrayList<RoemischeZahlenHelper>();
		werte.add(new RoemischeZahlenHelper(10000, "ↂ"));
		werte.add(new RoemischeZahlenHelper(9000, "Mↂ"));
		werte.add(new RoemischeZahlenHelper(5000, "ↁ"));
		werte.add(new RoemischeZahlenHelper(4000, "Mↁ"));
		werte.add(new RoemischeZahlenHelper(1000, "M"));
		werte.add(new RoemischeZahlenHelper(900, "CM"));
		werte.add(new RoemischeZahlenHelper(500, "D"));
		werte.add(new RoemischeZahlenHelper(400, "CD"));
		werte.add(new RoemischeZahlenHelper(100, "C"));
		werte.add(new RoemischeZahlenHelper(90, "XC"));
		werte.add(new RoemischeZahlenHelper(50, "L"));
		werte.add(new RoemischeZahlenHelper(40, "XL"));
		werte.add(new RoemischeZahlenHelper(10, "X"));
		werte.add(new RoemischeZahlenHelper(9, "IX"));
		werte.add(new RoemischeZahlenHelper(5, "V"));
		werte.add(new RoemischeZahlenHelper(4, "IV"));
		werte.add(new RoemischeZahlenHelper(1, "I"));
		
		
		StringBuilder builder = new StringBuilder();
		while (eingabe > 0) {
			for (RoemischeZahlenHelper roemischeZahlen : werte) {
				int x = eingabe - roemischeZahlen.getWert();
				if (x >= 0) {
					eingabe = x;
					builder.append(roemischeZahlen.getText());
					break;
				}
			}
		}
		return builder.toString();
	}
}
