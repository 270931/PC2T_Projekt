package main;

import java.util.List;
import java.util.Map;
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
//			-> Souborové operace
//				-> Uložení zaměstnance do souboru
//				-> Načtení zaměstnance ze souboru
//			-> Konec
//				-> Opravdu se chystáte odejít?



public class Menu {
	

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
	
	public static void MenuStatistiky() 
	{

		// TO DO: clear console
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                 Statistiky                  |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím vyberte Vaši akci:                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Abecední výpis zaměstnanců             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Kvalita spolupráce                     |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 3    Zaměstnanec s nejvíce vazbami          |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	public static void MenuSoubory() 
	{

		// TO DO: clear console
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |              Souborové operace              |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Prosím vyberte Vaši akci:                   |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 1    Uložení zaměstnanců do souboru         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 2    Načtení zaměstnanců ze souboru         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 4    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	public static void Konec() 
	{

		// TO DO: clear console
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |         Opravdu se chystáte odejít?         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |           Ano                 Ne            |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}

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
			zamereni = "Bezpečnostní specialista";
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
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", id, jmeno, prijmeni, rokNarozeni, zamereni
			);
		
		// wait 5 seconds
		TimeUnit.SECONDS.sleep(5);
	}
	

	public static void NovaSpoluprace(int id_zamestnance, int id_kolegy, int uroven) throws InterruptedException 
	{
		String urovenString = "";
		// TO DO: clear console
		switch(uroven)
		{
		case 1:
			urovenString = "Špatná";
			break;
		case 2:
			urovenString = "Průměrná";
			break;
		case 3:
			urovenString = "Dobrá";
		}
		
		Menu.StandartHeader("Nová spolupráce vytvořena.");
		
		System.out.printf(
				"\t\t\t\t |         ID      ID       Spolupráce         |\n"+
				"\t\t\t\t |         %3d <-> %3d       %8s          |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", id_zamestnance, id_kolegy, urovenString
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
	
	public static void VyhledatZamestnance(int id, String jmeno, String prijmeni, 
			int rokNarozeni, int skupina, Map<Integer, Integer> spoluprace) throws InterruptedException 
	{

		// TO DO: clear console
		String zamereni;
		if(skupina == 1)
		{
			zamereni = "Datový analytik";
		}
		else
		{
			zamereni = "Bezpečnostní specialista";
		}
		Menu.StandartHeader("Hledaný zaměstnanec:");
		
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
				"\t\t\t\t |   Spolupráce:   ID    Úroveň spolupráce     |\n"+
				"\t\t\t\t |                                             |\n"
				, id, jmeno, prijmeni, rokNarozeni, zamereni
			);
		
		for(Map.Entry<Integer,Integer> i : spoluprace.entrySet())
		{
			String uroven = "";
			switch(i.getValue())
			{
			case 1:
				uroven = "Špatná";
				break;
			case 2:
				uroven = "Průměrná";
				break;
			case 3:
				uroven = "Dobrá";
				break;
			}			
			System.out.printf("\t\t\t\t |                 %d   %-17s     |\n", i.getKey(), uroven);
		}
		
		System.out.printf(
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		// wait 5 seconds
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void DovednostAnalytik(int id, int id_kolegy, int maxSpolupraci) throws InterruptedException
	{
		StandartHeader(String.format("Výsledek dovednosti zaměstanance ID%d", id));
		System.out.printf(
				"\t\t\t\t |           ID kolegy:   %-20d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |    Počet společných                         |\n"+
				"\t\t\t\t |          spoluprací:   %-20d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", id_kolegy, maxSpolupraci
			);
		
		// wait 5 seconds
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void DovednostBezpecnostni(int id, int score, int pocetSpolupraci) throws InterruptedException
	{
		StandartHeader(String.format("Výsledek dovednosti zaměstanance ID%d", id));
		System.out.printf(
				"\t\t\t\t |    Počet spoluprací:   %-20d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |      Rizikové skóre:   %-20d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | (Rizikové skóre dává na škále 0-100 kvalitu |\n"+
				"\t\t\t\t |   spoluprací, které tento zaměstance má.    |\n"+
				"\t\t\t\t |   100 - velmi špatné; 0 - nejlepší možné)   |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", pocetSpolupraci, score
			);
		
		// wait 5 seconds
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void Seznam(List<Zamestnanec> databaze)
	{
		System.out.printf(
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t-+-------------------------------------------------------------------------------------------------------------------+-\n"+
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t |                          ABECEDNÍ  SEZNAM  ZAMĚSTNANCŮ  AKTUÁLNĚ  ULOŽENÝCH  V  DATABÁZI                          |\n"+
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t-+--ID---+--Jméno--------------+--Přijmení-----------+--Rok Narození--+--Pracovní skupina---------+--No. Spoluprací--+\n"+
	            "\t\t\t\t |       |                     |                     |                |                           |                  |\n"+
	            "\t\t\t\t |  999  |  sssssss17ssssssss  |  sssssss17ssssssss  |      d04d      |  Bezpečností Specialista  |       d3d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\t\t\t\t |  999  |  sssssss17ssssssss  |  sssssss17ssssssss  |      d04d      |  Datový Analytik          |       d3d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\t\t\t\t |  999  |  sssssss17ssssssss  |  sssssss17ssssssss  |      d04d      |  Bezpečností Specialista  |       d3d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		System.out.printf(
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t-+-------------------------------------------------------------------------------------------------------------------+-\n"+
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t |                          ABECEDNÍ  SEZNAM  ZAMĚSTNANCŮ  AKTUÁLNĚ  ULOŽENÝCH  V  DATABÁZI                          |\n"+
	            "\t\t\t\t |                                                                                                                   |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\t\t\t\t |  ID   |  Jméno              |  Přijmení           |  Rok Narození  |  Pracovní Skupina         |  No. Spoluprací  |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\t\t\t\t |  999  |  sssssss17ssssssss  |  sssssss17ssssssss  |      d04d      |  Bezpečností Specialista  |       d3d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\t\t\t\t |  999  |  sssssss17ssssssss  |  sssssss17ssssssss  |      d04d      |  Datový Analytik          |       d3d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+---------------------------+------------------+\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
	
	

}