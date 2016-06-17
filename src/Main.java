import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Biergarten> biergaerten =
				readFile("/Users/sonja/Downloads/SimulatedAnnealing/bier127.tsp");

		/*for(Biergarten bier: biergaerten){
			System.out.println(bier.getNode() + " " + bier.getCoordX() + " " + bier.getCoordY());
		}*/

		Tour startTour = new Tour(biergaerten);
		startTour.getStartTour();

		ZufallszahlenGenerator zG = new ZufallszahlenGenerator();
		zG.generate(1024);

		return;
	}

	private static ArrayList<Biergarten> readFile(String fileName){

		ArrayList<Biergarten> biergaerten = new ArrayList<>();

		File file = new File(fileName);

		if(file.exists()){

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));

				String line;

				String all = "";

				while ((line = br.readLine()) != null) {
					all += line;
				}

				String [] ar = all.split("\\s+");

				for(int i = 0; i < ar.length; i = i+3){
					try{
						Biergarten bier = new Biergarten(Integer.parseInt(ar[i]), Integer.parseInt(ar[i+1]),Integer.parseInt(ar[i+2]));
						biergaerten.add(bier);
					}catch(NumberFormatException e){
						//TODO
					}
				}

				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else{
			//TODO
		}
		return biergaerten;
	}

}