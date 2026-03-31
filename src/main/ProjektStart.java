package main;

import java.util.*;

public class ProjektStart {

	public static void main(String[] args) throws InterruptedException {

		
		
		
		boolean exit = false;
		
		do {
			Scanner sc = new Scanner(System.in);
			int vyber = 0;
			
			//Vypiš hlavní menu
			Menu.MainMenu();
			
			//nefunkcni
			if(sc.hasNextInt()) {
				vyber = sc.nextInt();
			}
			else {
				vyber = 99;
			}
			
			
			// rozhodování pro vstup do submenu
			switch(vyber){
				case 1:
					// Vypiš menu pro manupulaci se zaměstnanci
					
					//Tohle tu někde taky bude
					if(Handler.pridatZamenstnance()) {
						System.out.print("Success");
					}
					break;
				
				case 2:
					// Vypiš menu pro statistiky
					break;
				
				case 3:
					// Vypiš menu pro soubory
					break;
					
				case 4:
					// Vypiš menu pro ukončení
					exit = true;
					break;
				
				default:
					//moron
					Menu.GeneralError("Chyba volby v MainMenu", "Dopustili jste se chyby při zadávání vaší volby pro"
																+ " submenu. Prosím, zkuste to znovu.");
					break;			
				
			}
			
			sc.close();
		} while(!exit);
		
		System.out.print("Ukončeno.");
	}

}
