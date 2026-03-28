package main;

import java.util.*;

public class Handler {
	
	// jelikož Analytik a Bezpečák jsou typu ZAměstnance, můžeme vytvořit list zaměstnanců typu Zaměstnanec a
	//  pokud budeme chtít s pracovat s metodou specifickou pro jednu danou třídu, budeme muset zkontrolovat typ pomocí 'instanceof ()'
	private static List<Zamestnanec> databaze = new ArrayList<Zamestnanec>();
	
	private static Scanner sc = new Scanner(System.in);
	
	
	private static boolean zkontrolujUnikatniID(int kontrolovaneID) {
		
		// projdi každý prvek uložený v databázi
		for(Zamestnanec i : databaze) {
			if(kontrolovaneID == i.ID) {
				return false;
			}
		}
		return true;

	}
	
	// bylo by mnohem lepší/bezpečnější udělat novou statickou třídu např. Handler/Databaze atd.
	public static boolean pridatZamenstnance() {
		
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
		
		// uvedení, co se to vlastně dělá
		Menu.StandartHeader("Přidávání nového zaměstnance (ID"+ID+")");
		
		System.out.print("\t\t\t\t |  Jméno nového zaměstnance: ");
		String jmeno=sc.next();
		System.out.print("\t\t\t\t |  \n");
		
		System.out.printf("\t\t\t\t |  Přijmení zaměstnance %s: ", jmeno);
		String prijmeni=sc.next();
		System.out.print("\t\t\t\t |  \n");
		
		System.out.printf("\t\t\t\t |  Rok narození zaměstnance %s: ", jmeno);
		int rokNarozeni = sc.nextInt();
		System.out.print("\t\t\t\t |  \n");
		
		
		// dodělat rozdělení do skupin
		int skupina = 1;
		
		if(skupina == 1) {
			DatovyAnalytik a = new DatovyAnalytik(ID, jmeno, prijmeni, rokNarozeni);
			databaze.add(a);
			Menu.NovyZamestnanec(a.ID, a.Name, a.Surname, a.DateOfBirth);
			return true;
		}
		else if(skupina == 2) {
			//databaze.add(new Bezpecnost(ID, jmeno, prijmeni, rokNarozeni));
			return true;
		}
		else {
			Menu.GeneralError("Chyba - Nesprávný výběr skupiny", "Váš výběr"+ skupina +" je neplatným výběrem. Prosím, vyberte pouze z nabízených možností.");
			return false;
		}
		
		
	}
	
}
