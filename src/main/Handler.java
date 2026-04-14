package main;

import java.util.*;

public class Handler 
{
	// jelikož Analytik a Bezpečák jsou typu Zaměstnance, můžeme vytvořit list zaměstnanců typu Zaměstnanec a
	//  pokud budeme chtít s pracovat s metodou specifickou pro jednu danou třídu, budeme muset zkontrolovat typ pomocí 'instanceof ()'
	private List<Zamestnanec> databaze = new ArrayList<Zamestnanec>();
	private Scanner sc = new Scanner(System.in);
	
	// HOTOVO
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
	
	// HOTOVO
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
		do{
			System.out.printf("\t\t\t\t |  Rok narození nového zaměstnance: ");
			rokNarozeni = sc.nextInt();
			System.out.print("\t\t\t\t |  \n");
			if((1940 > rokNarozeni) || (rokNarozeni > 2010))
			{
				System.out.printf("\t\t\t\t |  Takovýto rok narození je nemožný. \n");
				System.out.print("\t\t\t\t |  \n");
			}
		}while((1940 > rokNarozeni) || (rokNarozeni > 2010));
		
		
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
	
	// HOTOVO
	public boolean pridatSpolupraci() throws InterruptedException 
	{
		Menu.StandartHeader("Přidávání spolupráce");
		System.out.print("\t\t\t\t |  Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		System.out.print("\t\t\t\t |\n\t\t\t\t |  Zadejte ID kolegy: ");
		int id_kolegy = sc.nextInt();
		System.out.print("\t\t\t\t |\n\t\t\t\t |  1 - špatná; 2 - průměrná; 3 - dobrá ");
		System.out.print("\n\t\t\t\t |  Zadejte úroveň spolupráce (1-3): ");
		int urovenSpoluprace = sc.nextInt();
		
		// kontrola rozdílnosti ID
		if(id_zamestnance == id_kolegy)
		{
			Menu.GeneralError("Nelze přidat spolupráci", "Není možné přidat spolupráci sobě sama. Prosím zvolte ID jiného člověka a opakujte akci.");
			return false;
		}

		
		boolean zamestnanecExists = false;
		boolean kolegaExists = false;
		int zamestnanecIndex = 0, kolegaIndex = 0;
		
		// najdi jestli obě ID existují
		for (Zamestnanec current : databaze)
		{
			if(current.ID == id_zamestnance)
			{
				zamestnanecExists = true;
				zamestnanecIndex = databaze.indexOf(current);
			}
			if(current.ID == id_kolegy)
			{
				kolegaExists = true;
				kolegaIndex = databaze.indexOf(current);
			}
			if(zamestnanecExists & kolegaExists)
			{
				// přidání spolupráce do zaměstnance
				Zamestnanec a = databaze.get(zamestnanecIndex);
				a.spoluprace.put(id_kolegy, urovenSpoluprace);
				
				// přidání spolupráce do kolegy
				Zamestnanec b = databaze.get(kolegaIndex);
				b.spoluprace.put(id_zamestnance, urovenSpoluprace);
				
				Menu.NovaSpoluprace(a.ID, b.ID, a.spoluprace.get(b.ID));
				return true;
			}
		}
		Menu.GeneralError("Nenalezeny požadované ID", String.format("Pokud toto čtete, znamená to, že program nemohl v databázi najít "
				+ "jedno nebo obě Vámi zadané ID (%d; %d). Prosím, zkontrolujte vámi zadané ID a opakujte akci.", id_zamestnance, id_kolegy));
		return false;
	}
	
	// HOTOVO
	public boolean odebratZamestnance() throws InterruptedException 
	{
		Menu.StandartHeader("Odebrání zaměstnance");
		System.out.print("\t\t\t\t |  Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		int odebranych_vazeb = 0;
		
		for(Zamestnanec current : databaze)
		{
			if(current.ID == id_zamestnance)
			{
				Menu.StandartHeader(String.format("Odebrání zaměstance ID%d", id_zamestnance));
				System.out.print(
						"\t\t\t\t |    Jste si zcela jistí odebráním tohoto     |\n"+
						"\t\t\t\t |    zaměstnance? Tato akce je nevratná!      |\n"+
						"\t\t\t\t |                                             |\n"+
						"\t\t\t\t |             Ano              Ne             |\n"+
						"\t\t\t\t-+---------------------------------------------+-\n"+
			            "\t\t\t\t |                                             |\n");
				System.out.print(
						"\t\t\t\t |  Vaše volba: ");
				String volba = sc.next();
				
				// pokud uživatel zvolí "Ano"
				if(volba.toLowerCase().startsWith("a"))
				{
					databaze.remove(current);
					
					// odebere spolupráce u všech ostatních zaměstanců (odebíraný zaměstnanec už není součástí databáze)
					// težce neefektivní
					for(Zamestnanec i : databaze)
					{
						if(i.spoluprace.containsKey(current.ID))
							{
								i.spoluprace.remove(current.ID);
								odebranych_vazeb++;
							}
					}
					
					Menu.GeneralError(String.format("Zaměstanec ID%d úspěšně odebrán.", current.ID), "Odebrání zaměstance proběhlo v pořádku.");
					System.out.println(odebranych_vazeb);
					return true;
				}
				Menu.GeneralError("Akce byla zrušena.", "Vstup z klávesnice nebyl interpretován jako souhlas s odebráním zaměstnance.");
				return true;
			}
		}
		Menu.GeneralError(String.format("Zaměstnanec ID%d nenalezen.", id_zamestnance), "Program nemohl v databázi najít zaměstnance s požadovaným ID."
				+ "Prosím, opakujte akci s jiným ID.");
		return true;
	}
	
	// neotestovano
	public boolean odebratSpolupraci() throws InterruptedException 
	{
		Menu.StandartHeader("Odebrání spolupráce mezi zaměstnanci");
		System.out.print("\t\t\t\t |  Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		System.out.print("\t\t\t\t |  Zadejte ID kolegy: ");
		int id_kolegy = sc.nextInt();
		
		boolean spoluprace_nalezena = false;
		int odebranych_spolupraci = 0;

		if(id_zamestnance == id_kolegy)
		{
			Menu.GeneralError("Duplikátní ID", "Nelze odebrat (a ani přidat) spolupráci "
					+ "mezi jedním a stejným zaměstnancem. Prosím, zvolte rozdílná ID a akci opakujte");
			return false;
		}
		
		for(Zamestnanec i : databaze)
		{
			if(i.ID == id_zamestnance) {
				if(i.spoluprace.containsKey(id_kolegy))
				{
					spoluprace_nalezena = true;
					i.spoluprace.remove(id_kolegy);
					odebranych_spolupraci++;
				}
				else
				{
					Menu.GeneralError("Spolupráce neexistuje", String.format("Spolupráce mezi"
							+ " ID%d a ID%d neexistuje. Prosím, zvolte dvojici zaměstnanců která má spolupráci", id_zamestnance, id_kolegy));
					return false;
				}
				
			}
			if(i.ID == id_kolegy)
			{
				if(i.spoluprace.containsKey(id_zamestnance))
				{
					spoluprace_nalezena = true;
					i.spoluprace.remove(id_zamestnance);
					odebranych_spolupraci++;
				}
				else
				{
					Menu.GeneralError("Spolupráce neexistuje", String.format("Spolupráce mezi"
							+ " ID%d a ID%d neexistuje. Prosím, zvolte dvojici zaměstnanců která má spolupráci", id_zamestnance, id_kolegy));
					return false;
				}
			}
		}
		
		if(spoluprace_nalezena)
		{
			Menu.GeneralError("Spolupráce úspěšně odebrána.", String.format("Spolupráce mezi zaměstnanci "
					+ "ID%d a ID%d byla úspěšně odebrána. %d", id_zamestanca, id_kolegy, odebranych_spolupraci));
			return true;
		}
		
		Menu.GeneralError("ID zaměstnance nenalezeno", "V programu nastala chyba, v databázi nebylo"
				+ "možné najít buď ID zaměstnance nebo kolegy. Prosím, opakujte akci.");
		// vykoná se pokud ID zaměstnance neexistuje
		return false;
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
