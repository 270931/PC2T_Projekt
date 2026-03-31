package main;

public class BezpecnostniSpecialista extends Zamestnanec {

	public BezpecnostniSpecialista(int id, String jmeno, String prijmeni, int rokNarozeni) {
		super(id, jmeno, prijmeni, rokNarozeni);
		
	}
	@Override
	public String toString() {
		
		return "Bezpecnostni specialista s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", jeho datum narozeni je" + RokNarozeni + ".";
	}
}