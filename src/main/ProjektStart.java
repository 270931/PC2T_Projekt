package main;

public class ProjektStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("N2co.");
		
		Menu.MainMenu();
		Menu.MainMenu();

	}
	
	
	// bylo by mnohem lepší/bezpečnější udělat novou statickou třídu např. Handler/Databaze atd.
	public void PridatZamenstnance(String skupina, String jmeno, String prijmeni, int rokNarozeni) {
		
		//generace ID
		int ID = 0;
		boolean prijatelneID = false;
		while (!prijatelneID) {
			ID = (int)(Math.random() * 1000);
			
			// checkuj, jestli je ID 3-místné číslo a.k.a. 100 až 999
			if (ID > 99) {
				prijatelneID = true;
			}
			
			
		}
		
		
	}

}
