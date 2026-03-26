package main;

public class ProjektStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("N2co.");
		
		Menu.MainMenu();
		Menu.MainMenu();

	}
	
	public void PridatZamenstnance(String skupina, String jmeno, String prijmeni, int rokNarozeni) {
		
		//generace ID
		int ID = 0;
		boolean prijatelneID = false;
		while (!prijatelneID) {
			ID = (int)(Math.random() * 1000);
			if (ID > 100) {
				prijatelneID = true;
			}
		}
		
		
		
	}

}
