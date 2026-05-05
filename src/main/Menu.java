package main;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Menu {	

	public static void MainMenu() 
	{
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
				"\t\t\t\t | 4    Počet zaměstnanců ve skupinách         |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | 5    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	public static void MenuSoubory() 
	{
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
				"\t\t\t\t | 3    Konec                                  |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t | Zadejte vaši volbu: "
			);
	}
	
	public static void Konec() 
	{
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
	    Menu.StandartHeader(errorHeader);
	    
	    String[] slova = errorMessage.split(" ");
	    String newLine = "";
	    
	    for (int i = 0; i < slova.length; i++) 
	    {
	        String mezera = newLine.isEmpty() ? "" : " ";
	        
	        if ((newLine + mezera + slova[i]).length() <= 43) 
	        {
	            newLine += mezera + slova[i]; 
	        }
	        else
	        {
	        	int padding = (43 - newLine.length())/2;
	    		String pad = "";
	    		for(int j = 0; j < padding; j++) 
	    		{
	    			pad += " ";
	    		}
	    		pad += newLine;
	            System.out.printf("\t\t\t\t | %-43s |\n", pad);
	            newLine = slova[i];
	        }
	    }

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

	    System.out.printf(
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    
	    TimeUnit.SECONDS.sleep(3);
	}
	

	public static void StandartHeader(String header) 
	{
		int padding = (43 - header.length())/2;
		String pad = "";
		for(int i = 0; i < padding; i++) 
		{
			pad += " ";
		}
		
		pad += header;
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
	            "\t\t\t\t |                                             |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t | %-43s |\n"+
	            "\t\t\t\t-+---------------------------------------------+-\n"+
	            "\t\t\t\t |                                             |\n", pad);
	}

	public static void NovyZamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni, int skupina) throws InterruptedException 
	{
		String zamereni;
		if(skupina == 1)
		{
			zamereni = "Datový analytik";
		}
		else
		{
			zamereni = "Bezpečnostní specialista";
		}
		
		Menu.StandartHeader("Úspěšné přidání zaměstnance");
		
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
		
		TimeUnit.SECONDS.sleep(3);
	}
	

	public static void NovaSpoluprace(int id_zamestnance, int id_kolegy, int uroven) throws InterruptedException 
	{
		String urovenString = "";
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
		
		Menu.StandartHeader("Úspěšné přidání spolupráce");
		
		System.out.printf(
				"\t\t\t\t |         ID      ID       Spolupráce         |\n"+
				"\t\t\t\t |         %3d <-> %3d       %8s          |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", id_zamestnance, id_kolegy, urovenString
			);
		
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void VyberSkupiny() 
	{
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
		
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void DovednostAnalytik(int id, int id_kolegy, int maxSpolupraci) throws InterruptedException
	{
		StandartHeader(String.format("Výsledek dovednosti zaměstnance s ID %d", id));
		System.out.printf(
				"\t\t\t\t |           ID kolegy:   %-20d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |    Počet společných                         |\n"+
				"\t\t\t\t |          spoluprací:   %-20d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", id_kolegy, maxSpolupraci
			);

		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void DovednostBezpecnostni(int id, int score, int pocetSpolupraci) throws InterruptedException
	{
		StandartHeader(String.format("Výsledek dovednosti zaměstnance s ID %d", id));
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
		
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void Seznam(List<Zamestnanec> databaze)
	{		
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
	            "\t\t\t\t |                                                                                                                    |\n"+
	            "\t\t\t\t-+--------------------------------------------------------------------------------------------------------------------+-\n"+
	            "\t\t\t\t |                                                                                                                    |\n"+
	            "\t\t\t\t |                          ABECEDNÍ  SEZNAM  ZAMĚSTNANCŮ  AKTUÁLNĚ  ULOŽENÝCH  V  DATABÁZI                           |\n"+
	            "\t\t\t\t |                                                                                                                    |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+----------------------------+------------------+\n"+
	            "\t\t\t\t |  ID   |  Jméno              |  Přijmení           |  Rok Narození  |  Pracovní Skupina          |  No. Spoluprací  |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+----------------------------+------------------+\n");
		
		for (Zamestnanec i : databaze)
		{
			System.out.printf(
				"\t\t\t\t |  %-3d  |  %-17s  |  %-17s  |      %-4d      |  %-24s  |        %-2d        |\n"+
	            "\t\t\t\t-+-------+---------------------+---------------------+----------------+----------------------------+------------------+\n",
	            i.ID, i.Jmeno, i.Prijmeni, i.RokNarozeni, (i instanceof DatovyAnalytik) ? "Datový Analytik" : "Bezpečnostní Specialista", i.spoluprace.size());
		}
		
		System.out.printf(
	            "\t\t\t\t |                                                                                                                    |\n"+
	            "\t\t\t\t |                                      Do Hlavního menu se vrátíte stiskem ENTER                                     |\n"+
	            "\t\t\t\t-+--------------------------------------------------------------------------------------------------------------------+-\n");	
	}
	
	public static void KvalitaSpoluprace(String spoluprace, int pocet) throws InterruptedException
	{
		StandartHeader("Převažující kvalita spolupráce");
		System.out.printf(
				"\t\t\t\t | Převažující spolupráce:   %-17s |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |       Počet spoluprací:   %-17d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", spoluprace, pocet/2
			);
		
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void NejviceSpolupraci(int ID, int pocet) throws InterruptedException
	{
		StandartHeader("Zaměstnanec s nejvíce spolupracemi");
		System.out.printf(
				"\t\t\t\t |               ID :   %-22d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |  Počet spoluprací:   %-22d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", ID, pocet
			);
		
		TimeUnit.SECONDS.sleep(3);
	}
	
	public static void PocetZamestnancuVeSkupinach(int datovych, int bezpec) throws InterruptedException
	{
		StandartHeader("Počet zaměstnanců podle skupin");
		System.out.printf(
				"\t\t\t\t |         Datových Analytiků :   %-12d |\n"+
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t |  Bezpečnostních Specialistů:   %-12d |\n"+   
				"\t\t\t\t |  ------------------------------------------ |\n"+
				"\t\t\t\t |                      Celkem:   %-12d |\n"+   
				"\t\t\t\t |                                             |\n"+
				"\t\t\t\t-+---------------------------------------------+-\n"+
				"\t\t\t\t |                                             |\n\n\n\n\n\n\n\n\n\n\n\n\n", datovych, bezpec, datovych+bezpec
			);
		
		TimeUnit.SECONDS.sleep(3);
	}
}