package main;

public class DatovyAnalytik extends Zamestnanec {

	public DatovyAnalytik(int id, String jmeno, String prijmeni, int datumNarozeni) {
		super(id, jmeno, prijmeni, datumNarozeni);
		
	}
	@Override
	public String toString() {
		
		return "Datovy analytik s ID " + ID + " se jmenuje " + Jmeno + " " + Prijmeni + ", jeho datum narozeni je" + DatumNarozeni + ".";
	}

}
