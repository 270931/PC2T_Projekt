package main;

import java.io.IOException;

public class Menu {
	
	public static void MainMenu() throws IOException, InterruptedException {
		
		
		
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		
		// TO DO: clear console
		System.out.printf("\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |        Databázový systém zaměstnanců        |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | O jaké informace se zajímáte?               |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Registrované osoby a operace s nimi    |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Nabízené tarify a operace s nimi       |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Další možnosti                         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"
			);
	}

}
