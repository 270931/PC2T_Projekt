package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Zamestnanec 
{
	
	// 'ID' zaměstnance
	protected int ID;
	
	// 'Jméno' zaměstnance
	protected String Jmeno;
	
	// 'Přijmení' zaměstance
	protected String Prijmeni;
	
	// Rok narození zaměstnance
	protected int RokNarozeni;
	
	// Seznam úrovní spolupráce s ostatními zaměstnanci uložené jako
	// 'ID, úroveň' dvojice, kde ID je key pro přístup k úrovni 
	public Map<Integer, Integer> spoluprace = new HashMap<Integer, Integer>();
	
	
	// konstruktor pro abstraktní třídu Zamestnanec
	public Zamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni) 
	{
		this.ID = id;
		this.Jmeno = jmeno;
		this.Prijmeni = prijmeni;
		this.RokNarozeni = rokNarozeni;
	}
	
	protected void Dovednost(List<Zamestnanec> databaze) {}
	protected void Dovednost() {}
	public String getPrijmeni() { return this.Prijmeni;}
	
	
	// společný textový výpis o zaměstnanci
	@Override
	public String toString() 
	{
		return ID + ";" + Jmeno + ";" + Prijmeni + ";" + RokNarozeni;
	}
	


}
