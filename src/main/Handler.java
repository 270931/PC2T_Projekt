package main;

import java.util.*;

public class Handler 
{
	// jelikož Analytik a Bezpečák jsou typu ZAměstnance, můžeme vytvořit list zaměstnanců typu Zaměstnanec a
	//  pokud budeme chtít s pracovat s metodou specifickou pro jednu danou třídu, budeme muset zkontrolovat typ pomocí 'instanceof ()'
	private List<Zamestnanec> databaze = new ArrayList<Zamestnanec>();
	private Scanner sc = new Scanner(System.in);
	
	private boolean zkontrolujUnikatniID(int kontrolovaneID) 
	{
		// projdi každý prvek uložený v databázi
		for(Zamestnanec i : databaze) 
		{
			if(kontrolovaneID == i.ID) 
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean pridatZamenstnance() throws InterruptedException
	{
		//generace ID
		int ID = 0;
		boolean prijatelneID = false;
		while (!prijatelneID) 
		{
			ID = (int)(Math.random() * 1000);
			
			// checkuj, jestli je ID 3-místné číslo a.k.a. 100 až 999
			if (ID > 99) 
			{
				// do 'prijatelneID' loadni true/false, pokud je ID unikátní
				prijatelneID = this.zkontrolujUnikatniID(ID);
			}
		}
		
		// uvedení, co se to vlastně dělá
		Menu.StandartHeader("Přidávání nového zaměstnance (ID " + ID  + ")");
		
		System.out.print("\t\t\t\t |  Jméno nového zaměstnance: ");
		String jmeno=sc.next();
		System.out.print("\t\t\t\t |  \n");
		
		System.out.printf("\t\t\t\t |  Přijmení nového zaměstnance: ");
		String prijmeni=sc.next();
		System.out.print("\t\t\t\t |  \n");
		
		int rokNarozeni = 0;
		//nefunkcni
		do{
			System.out.printf("\t\t\t\t |  Rok narození nového zaměstnance: ");
			rokNarozeni = sc.nextInt();
			System.out.print("\t\t\t\t |  \n");
		}while((1940 < rokNarozeni) & (rokNarozeni < 2010));
		
		
		// dodělat rozdělení do skupin
		int skupina = 0;
		Menu.VyberSkupiny();
		
		if(sc.hasNextInt()) 
		{
			 skupina= sc.nextInt();
		}
		else 
		{
			//skupina = 99;
			sc.next();
		}
		
		
		if(skupina == 1) 
		{
			DatovyAnalytik a = new DatovyAnalytik(ID, jmeno, prijmeni, rokNarozeni);
			databaze.add(a);
			Menu.NovyZamestnanec(a.ID, a.Jmeno, a.Prijmeni, a.RokNarozeni, skupina);
			return true;
		}
		else if(skupina == 2) 
		{
			BezpecnostniSpecialista a = new BezpecnostniSpecialista(ID, jmeno, prijmeni, rokNarozeni);
			databaze.add(a);
			Menu.NovyZamestnanec(a.ID, a.Jmeno, a.Prijmeni, a.RokNarozeni, skupina);
			return true;
		}
		else 
		{
			Menu.GeneralError("Chyba - Nesprávný výběr skupiny", "Váš výběr" + skupina + " je neplatným výběrem. Prosím, vyberte pouze z nabízených možností.");
			return false;
		}
		
	}
	
	public boolean pridatSpolupraci() 
	{
		
		System.out.println("Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		System.out.println("Zadejte ID kolegy: ");
		int id_kolegy = sc.nextInt();
		System.out.println("Zadejte úroveň spolupráce: ");
		int urovenSpoluprace = sc.nextInt();
		return true;
	}
	
	public boolean odebratZamestnance() 
	{
		return true;
	}
	
	public boolean odebratSpolupraci() 
	{
		System.out.println("Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		System.out.println("Zadejte ID kolegy: ");
		int id_kolegy = sc.nextInt();
		System.out.println("Zadejte úroveň spolupráce: ");
		int urovenSpoluprace = sc.nextInt();
		return true;
	}
	
	public boolean vyhledatZamestnance()
	{
		System.out.println("Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		return true;
	}
	
	public boolean dovednostiZamestnance() 
	{
		return true;
	}
	
}
