package main;

import java.util.*;

public class Handler {
	
	// jelikož Analytik a Bezpečák jsou typu ZAměstnance, můžeme vytvořit list zaměstnanců typu Zaměstnanec a
	//  pokud budeme chtít s pracovat s metodou specifickou pro jednu danou třídu, budeme muset zkontrolovat typ pomocí 'instanceof ()'
	private static List<Zamestnanec> databazeZamestnancu = new ArrayList<Zamestnanec>();
	
	
	private static boolean zkontrolujUnikatniID(int kontrolovaneID) {
		
		// projdi každý prvek uložený v databázi
		for(Zamestnanec i : databazeZamestnancu) {
			if(kontrolovaneID == i.ID) {
				return false;
			}
		}
		return true;

	}
	
	// bylo by mnohem lepší/bezpečnější udělat novou statickou třídu např. Handler/Databaze atd.
	public static boolean pridatZamenstnance(int skupina, String jmeno, String prijmeni, int rokNarozeni) {
		
		//generace ID
		int ID = 0;
		boolean prijatelneID = false;
		while (!prijatelneID) {
			ID = (int)(Math.random() * 1000);
			
			// checkuj, jestli je ID 3-místné číslo a.k.a. 100 až 999
			if (ID > 99) {
				
				// do 'prijatelneID' loadni true/false, pokud je ID unikátní
				prijatelneID = zkontrolujUnikatniID(ID);
			}
			
		}
		
		if(skupina == 1) {
			databazeZamestnancu.add(new DatovyAnalytik(ID, jmeno, prijmeni, rokNarozeni));
			return true;
		}
		else if(skupina == 2) {
			//databazeZamestnancu.add(new Bezpecnost(ID, jmeno, prijmeni, rokNarozeni));
			return true;
		}
		else {
			Menu.GeneralError("Váš výběr"+ skupina +" je neplatným výběrem. Prosím, vyberte pouze z nabízených možností.");
			return false;
		}
		
		
	}
	
}
