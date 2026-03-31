package main;

import java.util.HashMap;
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
	public Map<Integer, String> spoluprace = new HashMap<Integer, String>();
	
	
	// konstruktor pro abstraktní třídu Zamestnanec
	public Zamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni) 
	{
		this.ID = id;
		this.Jmeno = jmeno;
		this.Prijmeni = prijmeni;
		this.RokNarozeni = rokNarozeni;
	}
	
	
	// společný textový výpis o zaměstnanci
	@Override
	public String toString() 
	{
		return "Zaměstnanec s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", narodil se v roce " + RokNarozeni + ".";
	}

}
