package main;

public class BezpecnostniSpecialista extends Zamestnanec 
{
	public BezpecnostniSpecialista(int id, String jmeno, String prijmeni, int rokNarozeni) 
	{
		super(id, jmeno, prijmeni, rokNarozeni);
	}
	
	@Override
	public void Dovednost()
	{
		int dobra = 0, prumer = 0, spatna = 0;

		for(Integer i : this.spoluprace.values())
		{
			switch (i)
			{
				case 1:
					spatna++;
					break;
				case 2:
					prumer++;
					break;
				case 3:
					dobra++;
					break;
			}
		}
			
		int skore = (int)Math.ceil((dobra * 0 + prumer * 50 + spatna * 100) / (dobra + prumer + spatna));
		try 
		{
			Menu.DovednostBezpecnostni(this.ID, skore, this.spoluprace.values().size());
		} 
		catch (InterruptedException e)
		{
			System.out.print(false);
		}			
	}
	
	@Override
	public String toString() 
	{
		return "Bezpečnostní specialista s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", narodil se v roce " + RokNarozeni + ".";
	}
}