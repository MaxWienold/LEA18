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
				String[] parts = line.split(" ");
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

			for(String[] a : strings){
				for(int i = 0; i< a.length;i++)
					System.out.print(a[i] + " ");
				System.out.println();
			}
		}
		return strings;
	}
}
