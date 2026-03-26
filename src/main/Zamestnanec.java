package main;

import java.util.HashMap;
import java.util.Map;

public abstract class Zamestnanec {
	
	// 'ID' zaměstnance
	public int ID;
	
	// 'Jméno' zaměstnance
	public String Name;
	
	// 'Přijmení' zaměstance
	public String Surname;
	
	// ROk narození zaměstnance
	public int DateOfBirth;
	
	// Seznam úrovní spolupráce s ostatními zaměstnanci uložené jako
	// 'ID, úroveň' dvojice, kde ID je key pro přístup k úrovni 
	public Map<Integer, String> relations = new HashMap<Integer, String>();
	
	
	// konstruktor pro abstraktní třídu Zamestnanec
	public Zamestnanec(int id, String name, String surname, int dateOfBirth) {
		this.ID = id;
		this.Name = name;
		this.Surname = surname;
		this.DateOfBirth = dateOfBirth;
	}
	
	
	// společný textový výpis o zaměstnanci
	@Override
	public String toString() {
		
		return "Nic";
	}

}
