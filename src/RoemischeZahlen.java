import java.util.Scanner;

public class RoemischeZahlen {

	public static Scanner eingabe = new Scanner(System.in);
	
	

	public static void main(String[] args) {
	    System.out.println("       ____            ____\n"
	    		+"      /   /           /   /\n"
	    		+"     /   /           /   /\n"
	    		+"    /   /___   ____ /   /___\n"
	    		+"   /   _    \\ /___//   _    \\\n"
	    		+"  /   / /   //   //   / /   /\n"
	    		+" /   /_/   //   //   /_/   / ____ ____\n"
	    		+"/         //   //         / /   //   /\n"
	    		+"\\________/ \\__/ \\________/ /   //   /\n"
	    		+"    ________   ________   /   //   /________   ________   ________\n"
	    		+"   /   __   \\ /   _    \\ /   //   //   ___  \\ /   __   \\ /   ___  \\\n"
	    		+"  /   / /___//   / /   //   //   //   /__/  //   / /___//   /__/  /\n"
	    		+" /   /___   /   /_/   //   //   //   ______//   /_____ /   ______/\n"
	    		+"/        \\ /         //   //   //         //         //         /\n"
	    		+"\\________/ \\________/ \\___\\\\___\\\\________/ \\____/___/ \\________/\n");

	    
	    System.out.println("____________________________\n\n"
	    		+ "lateinischer Rechner\n\n"
	    		+ "entstanden als LEA im Frühjahr 2018\n"
	    		+ "Entwickelt von Volkan Hanke und Max Wienold\n"
	    		+ "____________________________\n\n");
	    
	    
		Menue.arrayAufbauen();
		Menue.schleife();
		
		

	}
}
