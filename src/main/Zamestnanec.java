package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Zamestnanec 
{
	protected int ID;
	protected String Jmeno;
	protected String Prijmeni;
	protected int RokNarozeni;

	public Map<Integer, Integer> spoluprace = new HashMap<Integer, Integer>();

	public Zamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni) 
	{
		this.ID = id;
		this.Jmeno = jmeno;
		this.Prijmeni = prijmeni;
		this.RokNarozeni = rokNarozeni;
	}
	
	protected void Dovednost(List<Zamestnanec> databaze) {}
	protected void Dovednost() {}
	
	public String getPrijmeni() 
	{ 
		return this.Prijmeni;
	}

	@Override
	public String toString() 
	{
		return ID + ";" + Jmeno + ";" + Prijmeni + ";" + RokNarozeni;
	}
}
