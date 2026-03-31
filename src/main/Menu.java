package main;

import java.util.concurrent.TimeUnit;


//		Struktura systému nabídek Menu
//		
//		-> MainMenu
//			-> Zaměstnanci a operace s nimi
//				-> Přidání zaměstnance
//				-> Přidání spolupráce
//				-> Odebrání zaměstnance
//				-> Odebrání spolupráce
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
	
	/**
	 * Vypíše strukturované hlavní menu.
	 */
	public static void MainMenu() 
	{

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
				"\t\t\t\t | 1    Zaměstnanci a operace s nimi           |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Statistiky                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Souborové operace                      |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	
	/**
	 * Standartní okno pro výpis chyby uživateli
	 * @param errorHeader	Nadpis chyby (max. 43 znaků)
	 * @param errorMessage	Zpráva pro uživatele, bez délkového omezení
	 * @throws InterruptedException 
	 */
	public static void GeneralError(String errorHeader, String errorMessage) throws InterruptedException 
	{
	    
	    // Standardizovaný nadpis
	    Menu.StandartHeader(errorHeader);
	    
	    
	    
	    String[] slova = errorMessage.split(" ");
	    String newLine = "";
	    
	    for (int i = 0; i < slova.length; i++) {
	        // Přidání mezery pokud nový řádek není prázný
	        String mezera = newLine.isEmpty() ? "" : " ";
	        
	        // Jestliže se další slovo vejde do 43 znaků, tak ho přidáme
	        if ((newLine + mezera + slova[i]).length() <= 43) 
	        {
	            newLine += mezera + slova[i]; 
	        }
	        else
	        {
	            // pokud je řádek plný, print
	        	int padding = (43 - newLine.length())/2;
	    		String pad = "";
	    		for(int j = 0; j < padding; j++) {
	    			pad += " ";
	    	}
	    		
	    		pad += newLine;
	            System.out.printf("\t\t\t\t | %-43s |\n", pad);
	            
	            // Nový řádek začne se slovem co se v aktuálním cyklu nevešlo
	            newLine = slova[i];
	        }
	    }
	    
	    // Pokud něco zbylo, vypíše se to zde
	    if (!newLine.isEmpty()) 
	    {
	    	int padding = (43 - newLine.length())/2;
			String pad = "";
			for(int j = 0; j < padding; j++) 
			{
				pad += " ";
			}
			
			pad += newLine;
	        System.out.printf("\t\t\t\t | %-43s |\n", pad);
	    }
	    
	    // Spodní okraj
	    System.out.printf(
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    
	    TimeUnit.SECONDS.sleep(5);
	}
	
	
	/**
	 * Vypíše do konzole standartní hlavičku dialogového okna
	@param	header	Nadpis okna (max. 43 znaků)
	 */
	public static void StandartHeader(String header) 
	{
		
		// Dostanu počet mezer které jsou potřeba přidat zleva i z prava
		int padding = (43 - header.length())/2;
		String pad = "";
		for(int i = 0; i < padding; i++) {
			pad += " ";
		}
		
		pad += header;
		
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t | %-43s |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n", pad);
	}
	
	/**
	 * Vypíše strukturovaný informační banner o zaměstnanci
	 * @param id	ID vypisovaného zaměstnance
	 * @param jmeno	Jméno vypisovaného zaměstnance
	 * @param prijmeni	Prijmení vypisovaného zaměstnance
	 * @param rokNarozeni	Rok narození vypisovaného zaměstnance
	 * @throws InterruptedException	Metoda používá pro přehlednost funkci sleep().
	 */
	public static void NovyZamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni, int skupina) throws InterruptedException 
	{

		// TO DO: clear console
		String zamereni;
		if(skupina == 1)
		{
			zamereni = "Datový analytik";
		}
		else
		{
			zamereni = "Bezpečností Specialista";
		}
		
		Menu.StandartHeader("Nový zaměstnanec vytvořen.");
		
		System.out.printf(
				"\t\t\t\t |           ID:   %-27d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |        Jméno:   %-27s |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |     Přijmení:   %-27s |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Rok narození:   %-27d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |      Skupina:   %-27s |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n", id, jmeno, prijmeni, rokNarozeni, zamereni
			);
		
		// wait 5 seconds
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void VyberSkupiny() 
	{

		// TO DO: clear console
		System.out.printf("\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |          Výběr skupiny zaměstnance          |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím, vyberte skupinu nového zaměstnance: |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Datový analytik                        |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Bezpečností specialista                |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	
	public static void MenuZamestnanci() 
	{

		// TO DO: clear console
		
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |         Zaměstnanci a operace s nimi        |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím vyberte Vaši akci:                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Přidání zaměstnance                    |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Přidání spolupráce                     |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Odebrání zaměstnance                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Odebrání spolupráce                    |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 5    Vyhledání zaměstnance podle ID         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 6    Dovednosti zaměstnance                 |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 7    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	

}
