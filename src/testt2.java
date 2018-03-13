import java.util.ArrayList;
import java.util.List;
public class testt2 {

	public static void main(String[] args) {


		List<RoemischeZahlen> werte = new ArrayList<RoemischeZahlen>();
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

		int eingabe = 904; 
		StringBuilder builder = new StringBuilder();
		while (eingabe > 0) {
			for (RoemischeZahlen roemischeZahlen : werte) {
				int x = eingabe - roemischeZahlen.getWert();
				if (x >= 0) {
					eingabe = x;
					builder.append(roemischeZahlen.getText());
					break;
				}
			}
		}
		System.out.println(builder.toString());

	}
}

class RoemischeZahlen {
	private int wert;
	private String text;

	public RoemischeZahlen(int wert, String text) {
		this.wert = wert;
		this.text = text;
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}


