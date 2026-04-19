package main;

import java.util.*;

public class ProjektStart {

	public static void main(String[] args) throws InterruptedException {

		
		
		
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		Handler hr = new Handler();
		
		// načtení z databáze
		
		do 
		{
			
			int vyber = 0;
			
			//Vypiš hlavní menu
			Menu.MainMenu();
			
			//výběr možnosti
			if(sc.hasNextInt()) 
			{
				vyber = sc.nextInt();
			}
			else 
			{
				vyber = 99;
				sc.next();
			}
			
			
			// rozhodování pro vstup do submenu
			switch(vyber) 
			{
				//Submenu: Zaměstnanci
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
					
					switch(vyber) 
					{
						case 1:
							if(hr.pridatZamenstnance()) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(hr.pridatSpolupraci())
							{
								System.out.print("Success");
							}
							break;
						
						case 3:
							if(hr.odebratZamestnance())
							{
								System.out.print("Success");
							}
							break;
						
						case 4:
							if(hr.odebratSpolupraci())
							{
								System.out.print("Success");
							}
							break;
							
						case 5:
							if(hr.vyhledatZamestnance())
							{
								System.out.print("Success");
							}
							break;
							
						case 6:
							if(hr.dovednostiZamestnance())
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

				//Submenu: Statistiky
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
					
					switch(vyber) 
					{
						case 1:
							if(hr.vypisZamestnancu()) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(hr.kvalitaSpoluprace())
							{
								System.out.print("Success");
							}
							break;
						
						case 3:
							if(hr.maxVazbySpoluprace())
							{
								System.out.print("Success");
							}
							break;
						
						case 4:
							if(hr.pocetZamestnancuVeSkupinach())
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
					
					switch(vyber) 
					{
						case 1:
							if(hr.zapisDoSouboru("test.txt")) 
							{
								System.out.print("Success");
							}
							break;
						
						case 2:
							if(hr.nacteniZeSouboru("test.txt"))
							{
								System.out.print("Success");
							}
							break;
						
						case 4:
							break;
							
						
						default:
							Menu.GeneralError("Chyba volby v Menu Souborových operací", "Dopustili jste se chyby při zadávání vaší volby pro"
									+ " submenu. Prosím, zkuste to znovu.");
							break;
							
					}
					break;
					
				case 4:
					Menu.Konec();
					String e = sc.next();
					if(e.toLowerCase().startsWith("a"))
					{
						exit = true;
						sc.close();
					}
					break;
				
				default:
					//moron
					Menu.GeneralError("Chyba volby v MainMenu", "Dopustili jste se chyby při zadávání vaší volby pro"
																+ " submenu. Prosím, zkuste to znovu.");
					break;			
				
			}
			

		} while(!exit);
		
		
		// tady se bude ukládat do databáze
		
		System.out.print("Ukončeno.");
	}
}
