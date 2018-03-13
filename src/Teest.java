import java.util.List;
import java.util.ArrayList;


public class Teest {

	public static void main(String[] args) {
		List<Integer> werte = new ArrayList<Integer>();
        werte.add(1000);
        werte.add(500);
        werte.add(100);
        werte.add(50);
        werte.add(10);
        werte.add(5);
        werte.add(1);
        
        List<String> roem = new ArrayList<String>();
        roem.add("M");
        roem.add("D");
        roem.add("C");
        roem.add("L");
        roem.add("X");
        roem.add("V");
        roem.add("I");

        int eingabe = 1666;
        int[] ausgabe = new int[7];
        for (int i = 0; i < ausgabe.length; i++) {
             
            ausgabe[i] = eingabe / werte.get(i);
            
            eingabe = eingabe % werte.get(i);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ausgabe.length; i++) {
            for (int j = 0; j < ausgabe[i]; j++) {
                sb.append(roem.get(i));
            }
        }

      
        System.out.println(sb.toString());
      

	}

}
