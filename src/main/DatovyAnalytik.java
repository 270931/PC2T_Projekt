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

		for(Zamestnanec z : databaze)
		{
			int momentalneSpolupracovniku = 0;
			
			if(z.ID != this.ID)
			{
				for(Integer i : z.spoluprace.keySet()) 
				{
					if(this.spoluprace.containsKey(i))
					{
						momentalneSpolupracovniku++;
					}
				}
			}
			
			if(momentalneSpolupracovniku > nejviceSpolupracovniku)
			{
				nejviceSpolupracovniku = momentalneSpolupracovniku;
				spolupracovnik_ID = z.ID;
			}
		}
		
		try 
		{
			Menu.DovednostAnalytik(this.ID, spolupracovnik_ID, nejviceSpolupracovniku);
		} 
		catch (InterruptedException e) 
		{
			System.out.print("Nastala chyba");
		}
	}
	
	@Override
	public String toString() 
	{
		return "Datový analytik s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", narodil se v roce " + RokNarozeni + ".";
	}

}