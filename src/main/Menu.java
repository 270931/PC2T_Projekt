package main;

import java.io.IOException;

//		Struktura systému nabídek Menu
//		
//		-> MainMenu
//			-> Zaměstnanci a operace s nimi
//				-> Přidání zaměstnance
//				-> Přidání spolupráce
//				-> Odebrání zaměstnance
//				-> Vyhledávání zaměstnance podle ID
//				-> Dovednosti zaměstnance
//			-> Statistiky
//				-> Abecední výpis zaměstnanců ve skupinách
//				-> Kvalita spolupráce
//				-> Zaměstnanec s nejvíce vazbami
//				-> Počet zaměstnanců ve skupinách
//			-> Souborové operace
//				-> Uložení zaměstnance do souboru
//				-> Načtení zaměstnance ze souboru
//			-> Konec
//				-> Opravdu se chystáte odejít?



public class Menu {
	
	public static void MainMenu() {

		// TO DO: clear console
		System.out.printf("\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |        Databázový systém zaměstnanců        |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím vyberte Vaši akci:                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Zaměstnanci a operace s nimi		    |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Statistiky						        |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Souborové operace                      |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"
			);
	}

}
