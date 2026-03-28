package main;

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
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |        Databázový systém zaměstnanců        |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím vyberte Vaši akci:                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Zaměstnanci a operace s nimi	       |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Statistiky		   	       |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Souborové operace                      |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"
			);
	}
	
	public static void GeneralError(String errorMessage) {
	    
	    // Nadpis a horní okraj
	    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |               Chyba programu                |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n");
	    
	    String[] slova = errorMessage.split(" ");
	    String newLine = "";
	    
	    for (int i = 0; i < slova.length; i++) {
	        // Přidání mezery pokud je není prázný
	        String mezera = newLine.isEmpty() ? "" : " ";
	        
	        // Jestliže se další slovo vejde do 43 znaků, tak ho přidáme
	        if ((newLine + mezera + slova[i]).length() <= 43) {
	            newLine += mezera + slova[i]; 
	            
	        } else {
	            // pokud je řádek plný, print
	            System.out.printf("\t\t\t\t | %-43s |\n", newLine);
	            
	            // Nový řádek začne se slovem co se v aktuálním cyklu nevešlo
	            newLine = slova[i];
	        }
	    }
	    
	    // Pokud něco zbylo, vypíše se to zde
	    if (!newLine.isEmpty()) {
	        System.out.printf("\t\t\t\t | %-43s |\n", newLine);
	    }
	    
	    // Spodní okraj
	    System.out.printf(
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

}
