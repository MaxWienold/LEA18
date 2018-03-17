import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dateianalyse {


	public static List<String[]> zerlegen(String pfad) {
		List<String[]> strings = new ArrayList<String[]>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(pfad)));
			String line = null;
			while((line = br.readLine()) != null) {              
				String[] parts = line.split("[^a-zA-Z0-9-]+");
				strings.add(parts);
			}
		} 

		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		catch(IOException e) {
			e.printStackTrace();
		}

		finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}


		}
		return strings;
	}

	public static void zahlenAendern(String pfad) {
		List<String[]> strings = zerlegen(pfad);
		int b = 1;
		for(String[] a : strings){
			for(int i = 0; i< a.length;i++) {
				
//				try {
//					int zahl = Integer.parseInt(a[i]);
//					if(Zahlformatierung.istGueltigArabisch(zahl))
//						a[i] = Zahlformatierung.formatiertInRoemisch(zahl);
//					else {
//						int zeichen = 1;
//						for (int j = 0; j < i; j++) {
//							zeichen += a[j].length();
//						}
//						System.out.println("In Zeile " + b + " bei Zeichen " + zeichen + ".");
//						
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}

				System.out.println(a[i]);

			}
			System.out.print("\n");

		}
	}
	public static void zeichenÄndern() {

	}
}
