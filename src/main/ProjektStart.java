package main;

import java.util.*;

public class ProjektStart {

	public static void main(String[] args) throws InterruptedException {

		
		
		
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		Handler hr = new Handler();
		
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
							if(hr.pridatSpoluprace())
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
							if(hr.odebratSpoluprace())
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
					// Vypiš menu pro statistiky
					break;
				
				case 3:
					// Vypiš menu pro soubory
					break;
					
				case 4:
					// Vypiš menu pro ukončení
					exit = true;
					break;
				
				default:
					//moron
					Menu.GeneralError("Chyba volby v MainMenu", "Dopustili jste se chyby při zadávání vaší volby pro"
																+ " submenu. Prosím, zkuste to znovu.");
					break;			
				
			}
			

		} while(!exit);
		
		System.out.print("Ukončeno.");
		sc.close();
	}

}
