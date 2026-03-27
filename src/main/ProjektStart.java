package main;

import java.io.IOException;

public class ProjektStart {


	public static void main(String[] args) throws IOException, InterruptedException {

		
		
		if (args.length == 0 || !args[0].equals("v_cmd")) {
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -cp bin main.ProjektStart v_cmd\"");
            System.exit(0); // Ukončíme původní běh v Eclipse
        }
		
		System.out.print("Něco.");
		
		
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
