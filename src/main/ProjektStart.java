package main;

public class ProjektStart {

	public static void main(String[] args) {

		
		boolean exit = false;
		do {
			int vyber = 0;
			//Vypiš hlavní menu
			Menu.MainMenu();
			
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
					break;
				
				default:
					//moron
					Menu.GeneralError("Chyba volby v MainMenu", "Dopustili jste se chyby při zadávání vaší volby pro"
																+ "submenu. Prosím, zkuste to znovu.");
					break;			
				
			}	
	
		} while(!exit);
		
		
	}

}
