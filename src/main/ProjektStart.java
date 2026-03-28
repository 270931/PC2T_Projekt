package main;

public class ProjektStart {

	public static void main(String[] args) {

		
	boolean exit = false;
	do {
		
		//Vypiš hlavní menu
		Menu.MainMenu();
		Menu.GeneralError("Váš výběr"+ "3" +" je neplatným výběrem. Prosím, vyberte pouze z nabízených možností.");

	} while(exit);
		
		
	}

}
