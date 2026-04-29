package main;

import java.util.*;

public class ProjektStart {

	public static void main(String[] args) throws InterruptedException {

		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		Spravce sp = new Spravce();
		
		if (!sp.connect("zamestnanci.db"))
	    {
	    	System.out.println("K databázi se nebylo možné připojit");
			exit = true;
	    }
		
		sp.createTableZamestnanci();
		sp.createTableSpoluprace();
		sp.selectAll();
		 
		while(!exit) {
			int vyber = 0;
			Menu.MainMenu();
			
			if(sc.hasNextInt()) 
			{
				vyber = sc.nextInt();
			}
			else 
			{
				vyber = 99;
				sc.next();
			}			
			System.out.print("\t\t\t\t-+---------------------------------------------+-\n" +
					 	     "\t\t\t\t |                                             |\n");
			switch(vyber) 
			{
				case 1:
					
					Menu.MenuZamestnanci();					
					
					if(sc.hasNextInt()) 
					{
						vyber = sc.nextInt();
					}
					else 
					{
						vyber = 99;
						sc.next();
					}
					System.out.print("\t\t\t\t-+---------------------------------------------+-\n"+
									 "\t\t\t\t |                                             |\n");
					switch(vyber) 
					{
						case 1:
							if(sp.pridatZamenstnance()) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(sp.pridatSpolupraci())
							{
								System.out.print("Success");
							}
							break;
						
						case 3:
							if(sp.odebratZamestnance())
							{
								System.out.print("Success");
							}
							break;
						
						case 4:
							if(sp.odebratSpolupraci())
							{
								System.out.print("Success");
							}
							break;
							
						case 5:
							if(sp.vyhledatZamestnance())
							{
								System.out.print("Success");
							}
							break;
							
						case 6:
							if(sp.dovednostiZamestnance())
							{
								System.out.print("Success");
							}
							break;
						
						case 7:
							break;
						
						default:
							Menu.GeneralError("Chyba volby v Menu Zaměstnanci", "Dopustili jste se chyby při zadávání vaší volby pro"
									+ " submenu. Prosím, zkuste to znovu.");
							break;							
					}
					break;

				case 2:
					Menu.MenuStatistiky();
										
					if(sc.hasNextInt()) 
					{
						vyber = sc.nextInt();
					}
					else 
					{
						vyber = 99;
						sc.next();
					}
					
					System.out.print("\t\t\t\t-+---------------------------------------------+-\n" +
									 "\t\t\t\t |                                             |\n");
					switch(vyber) 
					{
						case 1:
							if(sp.vypisZamestnancu()) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(sp.kvalitaSpoluprace())
							{
								System.out.print("Success");
							}
							break;
						
						case 3:
							if(sp.maxVazebSpoluprace())
							{
								System.out.print("Success");
							}
							break;
						
						case 4:
							if(sp.pocetZamestnancuVeSkupinach())
							{
								System.out.print("Success");
							}
							break;
						
						case 5:
							break;							
						
						default:
							Menu.GeneralError("Chyba volby v Menu Statistiky", "Dopustili jste se chyby při zadávání vaší volby pro"
									+ " submenu. Prosím, zkuste to znovu.");
							break;		
					}
					break;
				
				case 3:
					Menu.MenuSoubory();
										
					if(sc.hasNextInt()) 
					{
						vyber = sc.nextInt();
					}
					else 
					{
						vyber = 99;
						sc.next();
					}
					
					System.out.print("\t\t\t\t-+---------------------------------------------+-\n" +
									 "\t\t\t\t |                                             |\n");
					switch(vyber) 
					{
						case 1:
							if(sp.zapisDoSouboru("zamestnanci.txt")) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(sp.nacteniZeSouboru("zamestnanci.txt"))
							{
								System.out.print("Success");
							}
							break;
						
						case 3:
							break;

						default:
							Menu.GeneralError("Chyba volby v Menu Souborové operace", "Dopustili jste se chyby při zadávání vaší volby pro"
									+ " submenu. Prosím, zkuste to znovu.");
							break;	
					}
					break;
					
				case 4:
					Menu.Konec();
					String e = sc.next();
					System.out.print("\t\t\t\t-+---------------------------------------------+-\n" +
							 		 "\t\t\t\t |                                             |\n");
					if(e.toLowerCase().startsWith("a"))
					{
						exit = true;
						sc.close();
					}
					break;
				
				default:
					Menu.GeneralError("Chyba volby v MainMenu", "Dopustili jste se chyby při zadávání vaší volby pro"
										+ " submenu. Prosím, zkuste to znovu.");
					break;							
			}
		}
		sp.insert();
		sp.disconnect();
		
		System.out.print("Ukončeno.");
	}
}
