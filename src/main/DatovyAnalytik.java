package main;
import java.util.List;

public class DatovyAnalytik extends Zamestnanec 
{

	public DatovyAnalytik(int id, String jmeno, String prijmeni, int rokNarozeni) 
	{
		super(id, jmeno, prijmeni, rokNarozeni);
	}
	
	@Override
	public void Dovednost(List<Zamestnanec> databaze)
	{
		int nejviceSpolupracovniku = 0;
		int spolupracovnik_ID = 0;
		
		// Pro každého zaměstnance v databázi ...
		for (Zamestnanec current : databaze)
		{
			int momentalneSpolupracovniku = 0;
			// ... který není zaměstnancem, metodu jehož instance voláme ...
			if(current.ID != this.ID)
			{
				// ... porovnej všechny záznamy tohoto zaměstance se všemi svými ...
				for(Integer i : current.spoluprace.keySet()) 
				{
					// .. a pokud obsahuje stejný klíč kolegy ...
					if(this.spoluprace.containsKey(i))
					{
						// ... zaznamenej si to.
						momentalneSpolupracovniku++;
					}
				}
			}
			
			
			if(momentalneSpolupracovniku > nejviceSpolupracovniku)
			{
				nejviceSpolupracovniku = momentalneSpolupracovniku;
				spolupracovnik_ID = current.ID;
			}
		}
		
		
		// Výpis zjistěných informací
		try {
			Menu.DovednostAnalytik(this.ID, spolupracovnik_ID, nejviceSpolupracovniku);
		} catch (InterruptedException e) {
			System.out.print("Nastala chyba");
		}
	}
	
	
	@Override
	public String toString() 
	{
		return "Datový analytik s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", narodil se v roce " + RokNarozeni + ".";
	}

}