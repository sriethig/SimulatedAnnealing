import java.util.ArrayList;

public class Tour {
	
	private ArrayList<Biergarten> biergaerten;
	private ArrayList<Biergarten> reihenfolge;
	private int gesamtLaenge;
	
	public Tour(ArrayList<Biergarten> biergaerten) {
		this.biergaerten = biergaerten;
		this.gesamtLaenge = 0;
	}
	
	public double getStartTour() {
		double laenge = 0;
		
		Laengenmessung laengenmessung = new Laengenmessung(127);
		laengenmessung.setAbstandsmatrix(this.biergaerten);
		
		for(int i = 0; i < 126; i++) {
			laenge = laenge + laengenmessung.getAbstandsMatrix(i, i + 1);
		}
		laenge = laenge + laengenmessung.getAbstandsMatrix(126, 0);
		reihenfolge = biergaerten;
		reihenfolge.add(biergaerten.get(0));
		
		System.out.println("Tour Reihenfolge:");
		for(Biergarten b : reihenfolge) {
			System.out.println(b.getNode());
		}
		
		System.out.println("Tour Länge: " + laenge);
		return laenge;
	}

}
