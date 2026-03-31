package main;

public class DatovyAnalytik extends Zamestnanec {

	public DatovyAnalytik(int id, String jmeno, String prijmeni, int rokNarozeni) {
		super(id, jmeno, prijmeni, rokNarozeni);
		
	}
	@Override
	public String toString() {
		
		return "Datovy analytik s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", jeho datum narozeni je" + RokNarozeni + ".";
	}

}
