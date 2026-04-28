package main;

import java.io.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.Collator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Spravce 
{
	private List<Zamestnanec> databaze = new ArrayList<Zamestnanec>();
	private Scanner sc = new Scanner(System.in);
	
	private boolean zkontrolujUnikatniID(int kontrolovaneID) 
	{
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
		int ID = 0;
		boolean prijatelneID = false;
		while (!prijatelneID) 
		{
			ID = (int)(Math.random() * 1000);
			if (ID > 99) 
			{
				prijatelneID = this.zkontrolujUnikatniID(ID);
			}
		}
		
		Menu.StandartHeader("Přidávání nového zaměstnance (ID " + ID  + ")");		
		System.out.print("\t\t\t\t |  Jméno nového zaměstnance: ");
		String jmeno=sc.next();
		System.out.print("\t\t\t\t |  \n");
		System.out.printf("\t\t\t\t |  Přijmení nového zaměstnance: ");
		String prijmeni=sc.next();
		System.out.print("\t\t\t\t |  \n");
		
		int rokNarozeni = 0;
		do
		{
			System.out.printf("\t\t\t\t |  Rok narození nového zaměstnance: ");
			rokNarozeni = sc.nextInt();
			System.out.print("\t\t\t\t |  \n");
			if((1940 > rokNarozeni) || (rokNarozeni > 2010))
			{
				System.out.printf("\t\t\t\t |  Takovýto rok narození je nemožný. \n");
				System.out.print("\t\t\t\t |  \n");
			}
		}
		while((1940 > rokNarozeni) || (rokNarozeni > 2010));

		int skupina = 0;
		Menu.VyberSkupiny();
		
		if(sc.hasNextInt()) 
		{
			 skupina= sc.nextInt();
		}
		else 
		{
			//skupina = 99; ????
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

		if(id_zamestnance == id_kolegy)
		{
			Menu.GeneralError("Nelze přidat spolupráci", "Není možné přidat spolupráci sobě sama. Prosím zvolte ID jiného člověka a opakujte akci.");
			return false;
		}

		boolean zamestnanecExistuje = false;
		boolean kolegaExistuje = false;
		int zamestnanecIndex = 0, kolegaIndex = 0;

		for(Zamestnanec z : databaze)
		{
			if(z.ID == id_zamestnance)
			{
				zamestnanecExistuje = true;
				zamestnanecIndex = databaze.indexOf(z);
			}
			if(z.ID == id_kolegy)
			{
				kolegaExistuje = true;
				kolegaIndex = databaze.indexOf(z);
			}
			if(zamestnanecExistuje && kolegaExistuje)
			{
				Zamestnanec a = databaze.get(zamestnanecIndex);
				a.spoluprace.put(id_kolegy, urovenSpoluprace);

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

	public boolean odebratZamestnance() throws InterruptedException 
	{
		Menu.StandartHeader("Odebrání zaměstnance");
		System.out.print("\t\t\t\t |  Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		int odebranych_vazeb = 0;
		
		for(Zamestnanec z : databaze)
		{
			if(z.ID == id_zamestnance)
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

				if(volba.toLowerCase().startsWith("a"))
				{
					databaze.remove(z);

					for(Zamestnanec i : databaze)
					{
						if(i.spoluprace.containsKey(z.ID))
							{
								i.spoluprace.remove(z.ID);
								odebranych_vazeb++;
							}
					}
					
					Menu.GeneralError(String.format("Zaměstanec ID%d úspěšně odebrán.", z.ID), "Odebrání zaměstance proběhlo v pořádku.");
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
		
		for(Zamestnanec z : databaze)
		{
			if(z.ID == id_zamestnance) 
			{
				if(z.spoluprace.containsKey(id_kolegy))
				{
					spoluprace_nalezena = true;
					z.spoluprace.remove(id_kolegy);
					odebranych_spolupraci++;
				}
				else
				{
					Menu.GeneralError("Spolupráce neexistuje", String.format("Spolupráce mezi"
							+ " ID%d a ID%d neexistuje. Prosím, zvolte dvojici zaměstnanců která má spolupráci", id_zamestnance, id_kolegy));
					return false;
				}
				
			}
			if(z.ID == id_kolegy)
			{
				if(z.spoluprace.containsKey(id_zamestnance))
				{
					spoluprace_nalezena = true;
					z.spoluprace.remove(id_zamestnance);
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
					+ "ID%d a ID%d byla úspěšně odebrána. (%d)", id_zamestnance, id_kolegy, odebranych_spolupraci/2));
			return true;
		}
		
		Menu.GeneralError("ID zaměstnance nenalezeno", "V programu nastala chyba, v databázi nebylo"
				+ " možné najít buď ID zaměstnance nebo kolegy. Prosím, opakujte akci.");
		return false;
	}
	
	public boolean vyhledatZamestnance() throws InterruptedException
	{
		Menu.StandartHeader("Vyhledání zaměstnance");
		System.out.print("\t\t\t\t |  Zadejte ID zaměstnance: ");
		int id_zamestnance = sc.nextInt();
		System.out.print("\t\t\t\t |  \n");
		
		int skupina = 0;
		for(Zamestnanec z : databaze) 
		{
			if(id_zamestnance == z.ID) 
			{
				if(z instanceof DatovyAnalytik) 
				{
					skupina = 1;
				}
				else 
				{
					skupina = 2;	
				}
				Menu.VyhledatZamestnance(z.ID, z.Jmeno, z.Prijmeni, z.RokNarozeni, skupina, z.spoluprace);
				return true;
			}	
		}
		
		Menu.GeneralError("Chybné ID", String.format("Nebyl nalezen zaměstnanec s hledaným ID %d.", id_zamestnance));
		return false;
	}
	
	public boolean dovednostiZamestnance() throws InterruptedException 
	{
		Menu.StandartHeader("Dovednosti zaměstance");
		System.out.print("\t\t\t\t |    Zadejte ID zaměstance jehož dovednost    |\n"+
				 		 "\t\t\t\t |               chcete využít.                |\n"+
				 		 "\t\t\t\t |                                             |\n"+
				 		 "\t\t\t\t |  ID zaměstnance: ");
		int id = sc.nextInt();
		for(Zamestnanec z : databaze)
		{
			if(id == z.ID)
			{
				if(z instanceof BezpecnostniSpecialista) 
				{
					z.Dovednost();
				}
				else 
				{
					z.Dovednost(databaze);
				}
				return true;
			}
		}
		
		Menu.GeneralError("Chyba ID", "Vámi zadané ID nebylo v databázi nalezeno. Prosím, opakujte akci s jiným ID.");
		return false;		
	}	
	// ---------------------STATISTIKY---------------------------------------
	
	public boolean vypisZamestnancu()
	{
		// Collator je classa přesně dělaná pro porovnávání stringů podle pravidel nějakého přirozeného jazyka a.k.a. CZ
		// Collator beze jako data typ class Locale
		@SuppressWarnings("deprecation")
		Collator cz = Collator.getInstance(new Locale("cz", "CZ"));
		
		databaze.sort(Comparator.comparing((Zamestnanec z) -> z.getClass().getSimpleName()).thenComparing(Zamestnanec::getPrijmeni, cz));
		Menu.Seznam(databaze);
		sc.nextLine();
		return true;
	}
	
	public boolean kvalitaSpoluprace()
	{
		int dobra = 0, prum = 0, spatna = 0;
		
		for (Zamestnanec z: databaze)
		{
			for(Integer i : z.spoluprace.values())
			{
				switch (i)
				{
				case 1:
					spatna++;
					break;
				case 2:
					prum++;
					break;
				case 3:
					dobra++;
					break;
				}
			}
		}
		
		try 
		{
			if(spatna > prum || spatna > dobra)
			{
				Menu.KvalitaSpoluprace("Špatná", spatna);
			}
			else if(prum > spatna || prum > dobra)
			{
				Menu.KvalitaSpoluprace("Průměrná", prum);
			}
			else
			{
				Menu.KvalitaSpoluprace("Dobrá", dobra);
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean maxVazebSpoluprace()
	{
		int maxVazeb = 0;
		int max_ID = 0;
		
		for(Zamestnanec z : databaze)
		{
			if(z.spoluprace.values().size() > maxVazeb)
			{
				maxVazeb = z.spoluprace.values().size();
				max_ID = z.ID;
			}
		}
		
		if(maxVazeb == 0)
		{
			try 
			{
				Menu.GeneralError("Nenalezeny žádné vazby", "Program nemohl vyhodnotit nejvyšší počet vazeb, protože žádné vazby nenašel. Prosím, přidejte nějaké vazby a opakujte akci.");
			} 
			catch (InterruptedException e) 
			{
			}
			return false;
		}
		else 
		{
			try 
			{
				Menu.NejviceSpolupraci(max_ID, maxVazeb);
			} 
			catch (InterruptedException e) 
			{
				return false;
			}
			return true;
		}
	}
	
	public boolean pocetZamestnancuVeSkupinach()
	{
		int datovych = 0, bezpecnostnich = 0;
		
		for(Zamestnanec z : databaze)
		{
			if(z instanceof DatovyAnalytik)
			{
				datovych++;
			}
			else 
			{
				bezpecnostnich++;
			}
		}
		
		try 
		{
			Menu.PocetZamestnancuVeSkupinach(datovych, bezpecnostnich);
		} 
		catch (InterruptedException e) 
		{
			return false;
		}
		
		return true;
	}
	// ---------------------SOUBORY---------------------------------------
	
	public boolean zapisDoSouboru(String jmenoSouboru) throws InterruptedException
	{
		try (FileWriter fw = new FileWriter(jmenoSouboru); 
				BufferedWriter bw = new BufferedWriter(fw))
		{
			int skupina = 0;

			if (databaze.isEmpty()) 
			{
				Menu.GeneralError("Prázdná databáze", "Není možný zápis do souboru, databáze je prázdná.");
				return false;
			}
			for(Zamestnanec z : databaze) 
			{
				if(z instanceof DatovyAnalytik) 
				{
					skupina = 1;
				}
				else 
				{
					skupina = 2;	
				}
				bw.write(z.ID + ";" + z.Jmeno + ";" + z.Prijmeni + ";" + z.RokNarozeni + ";" + skupina);
				z.spoluprace.forEach((k,v) -> 
				{
					try 
					{
						bw.write(";" + k + v);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				});
				
				bw.newLine();
			}
			return true;
		}		 
		catch (IOException e) 
		{
			Menu.GeneralError("Chyba", "Nepodařilo se otevřít soubor.");
			return false;
		}
	}
	
	public boolean nacteniZeSouboru(String jmenoSouboru) throws InterruptedException
	{
		try (FileReader fr = new FileReader(jmenoSouboru);
			BufferedReader br = new BufferedReader(fr);
			Scanner sc = new Scanner(br))
		{
			String radek;
			int pocet = 0;
			while((radek = br.readLine()) != null)
			{
				String[] atributy = radek.split(";");
				int id = Integer.parseInt(atributy[0]);
				String jmeno = atributy[1];
				String prijmeni = atributy[2];
				int rok = Integer.parseInt(atributy[3]);
				int skupina = Integer.parseInt(atributy[4]);
				
				if (this.zkontrolujUnikatniID(id) == true) 
				{
					if(skupina == 1) 
					{
						DatovyAnalytik a = new DatovyAnalytik(id, jmeno, prijmeni, rok);
						databaze.add(a);
						pocet += 1;
					}
					else if (skupina == 2) 
					{
						BezpecnostniSpecialista s = new BezpecnostniSpecialista(id, jmeno, prijmeni, rok);
						databaze.add(s);
						pocet += 1;
					}
					
					Zamestnanec c = databaze.get(databaze.size()-1);
					for(int i = 5; i < atributy.length; i++)
					{
						int vazba = Integer.parseInt(atributy[i]);
						int id_kolegy = Math.floorDiv(vazba, 10);
						int uroven = (vazba - Math.floorDiv(vazba, 10)*10);
						c.spoluprace.put(id_kolegy, uroven);
					}
				}
			}
			Menu.StandartHeader(String.format("Bylo načteno %d nových záznamů.", pocet));
			TimeUnit.SECONDS.sleep(3);
		} 
		catch (FileNotFoundException e) 
		{
			Menu.GeneralError("Chyba", "Soubor nebyl nalezen.");
			return false;
		} 
		catch (IOException e) 
		{
			Menu.GeneralError("Chyba", "Soubor nelze otevřít.");
			return false;
		}
		return true;
	}
	//--------------SQL-----------------
	
	private Connection pripojeni; 
	
	public boolean connect(String nazevDatabaze) 
	{ 
		pripojeni = null; 
		try 
		{
			pripojeni = DriverManager.getConnection("jdbc:sqlite:zamestnanci.db");                 
		} 
		catch (SQLException e) 
		{ 
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public void disconnect() 
	{ 
		if (pripojeni != null) 
		{
			try 
			{ 
				pripojeni.close();
			} 
			catch (SQLException e) 
			{ 
				System.out.println(e.getMessage()); 
			}
		}
	}
	
	public boolean createTableZamestnanci()
	{
		if (pripojeni == null) 
		{
			return false;
		}
		String sql = "CREATE TABLE IF NOT EXISTS Zamestnanci"
				+ "(id INT PRIMARY KEY,"
				+ "jmeno VARCHAR (100),"
				+ "prijmeni VARCHAR (100),"
				+ "rokNarozeni INT,"
				+ "skupina INT)";
		try
		{
			Statement stmt = pripojeni.createStatement(); 
			stmt.execute(sql);
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean createTableSpoluprace()
	{
		if (pripojeni == null) 
		{
			return false;
		}
		String sql = "CREATE TABLE IF NOT EXISTS Spoluprace"
				+ "(id_zamestnance INT,"
				+ "id_kolegy INT,"
			    + "uroven_spoluprace INT,"
				+ "FOREIGN KEY(id_zamestnance) REFERENCES Zamestnanci(id))";
		try
		{
			Statement stmt = pripojeni.createStatement(); 
			stmt.execute(sql);
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
//vlozeni zaznamu na konci programu
	public boolean insert() throws InterruptedException 
	{
		if (databaze.isEmpty()) 
		{
			Menu.GeneralError("Prázdná databáze", "Není možný zápis do sql, databáze je prázdná.");
			return false;
		}
		for(Zamestnanec z : databaze) 
		{
			int id = z.ID;
			String jmeno = z.Jmeno;
			String prijmeni = z.Prijmeni;
			int rokNarozeni = z.RokNarozeni;
			int skupina = 0;
			
			if(z instanceof DatovyAnalytik) 
			{
				skupina = 1;
			}
			else 
			{
				skupina = 2;	
			}
			
			String sql = "INSERT OR REPLACE INTO Zamestnanci(id, jmeno, prijmeni, rokNarozeni, skupina) VALUES(?,?,?,?,?)";
	        try {
	            PreparedStatement pstmt = pripojeni.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            pstmt.setString(2, jmeno);
	            pstmt.setString(3, prijmeni);
	            pstmt.setInt(4, rokNarozeni);
	            pstmt.setInt(5, skupina);
	            pstmt.executeUpdate();
	        } 
	         catch (SQLException e) 
	        {
	        	 
	             System.out.println(e.getMessage());
	        }  
		}
		insertSpoluprace();
		return true;        
    }
	
	//chybi kontrola id_kolegy
	public void insertSpoluprace() 
	{
		for(Zamestnanec z : databaze) 
		{
			int id_zamestnance = z.ID;
			String sql = "INSERT OR REPLACE INTO Spoluprace(id_zamestnance, id_kolegy, uroven_spoluprace) VALUES(?,?,?)";

	        z.spoluprace.forEach((k,v) -> 
			{
				try 
				{
					PreparedStatement pstmt = pripojeni.prepareStatement(sql);
					pstmt.setInt(1, id_zamestnance);
					pstmt.setInt(2, k);
					pstmt.setInt(3, v);
		            pstmt.executeUpdate();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			});
		}
	}
	
//nacteni zaznamu na zacatku programu
	public void selectAll() throws InterruptedException
	{
        String sql = "SELECT id, jmeno, prijmeni, rokNarozeni, skupina FROM Zamestnanci";
        try 
        {
             Statement stmt = pripojeni.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             int pocet = 0;
             int spoluprace = 0;
             
             while (rs.next()) 
			{
				int id = rs.getInt("id");
				String jmeno = rs.getString("jmeno");
				String prijmeni = rs.getString("prijmeni");
				int rokNarozeni = rs.getInt("rokNarozeni");
				int skupina = rs.getInt("skupina");

				if (this.zkontrolujUnikatniID(id) == true) 
				{
					if(skupina == 1) 
					{
						DatovyAnalytik a = new DatovyAnalytik(id, jmeno, prijmeni, rokNarozeni);
						databaze.add(a);
						pocet += 1;
					}
					else if (skupina == 2) 
					{
						BezpecnostniSpecialista s = new BezpecnostniSpecialista(id, jmeno, prijmeni, rokNarozeni);
						databaze.add(s);
						pocet += 1;
					}
				}
				spoluprace += selectSpoluprace(id);
			}
            
            Menu.StandartHeader(String.format("Bylo načteno %d zaměstnanců.", pocet));
            Menu.StandartHeader(String.format("Bylo načteno %d spoluprací.", spoluprace));
 			TimeUnit.SECONDS.sleep(3);
        } 
        catch (SQLException e) 
        {
             System.out.println(e.getMessage());
        }
	}
	
	public int selectSpoluprace(int id)
	{
		String sql = String.format("SELECT id_zamestnance, id_kolegy, uroven_spoluprace FROM Spoluprace WHERE id_zamestnance=%d",id);
		
		Zamestnanec c = databaze.get(databaze.size()-1);
		int pocet= 0;
		try 
		{
			Statement stmt = pripojeni.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
			while (rs.next()) 
			{
				int id_kolegy = rs.getInt("id_kolegy");
				int uroven = rs.getInt("uroven_spoluprace");
				c.spoluprace.put(id_kolegy, uroven);
				pocet++;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pocet;
	}
}
