package main;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class Zamestnanec {
	
	// 'ID' zaměstnance
	public int ID;
	
	// 'Jméno' zaměstnance
	public String Name;
	
	// ROk narození zaměstnance
	public int DateOfBirth;
	
	// Seznam úrovní spolupráce s ostatními zaměstnanci uložené jako
	// 'ID, úroveň' dvojice, kde ID je key pro přístup k úrovni 
	public Dictionary<Integer, String> relations = new Hashtable<>();
	
	
	// konstruktor pro abstraktní třídu Zamestnanec
	public Zamestnanec(int id, String name, int dateOfBirth) {
		this.ID = id;
		this.Name = name;
		this.DateOfBirth = dateOfBirth;
	}
	
	
	// společný textový výpis o zaměstnanci
	@Override
	public String toString() {
		
		// Nějaký hezký strukturovaný výpis o zaměstnanci.
		return "Nic";
	}
	

}
