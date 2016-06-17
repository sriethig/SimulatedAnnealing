import java.util.ArrayList;
import java.util.List;

public class Laengenmessung {

	private double[][] abstandsmatrix;

	public Laengenmessung(int length) {
		abstandsmatrix = new double[length][length];

		for(int i = 0; i < length; i++) {
			abstandsmatrix[i][i] = 0;
		}
	}

	private double abstand(Biergarten biergarten1, Biergarten biergarten2) {

		int nodeX = biergarten1.getNode();
		int nodeY = biergarten2.getNode();

		int x1 = biergarten1.getCoordX();
		int y1 = biergarten1.getCoordY();

		int x2 = biergarten2.getCoordX();
		int y2 = biergarten2.getCoordY();

		double d_ij = Math.sqrt((double)((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)));

		abstandsmatrix[nodeX - 1][nodeY - 1] = d_ij;
		abstandsmatrix[nodeY - 1][nodeX - 1] = d_ij;

		return d_ij;
	}

	public double[][] getAbstandsmatrix() {
		return abstandsmatrix;
	}

	public void setAbstandsmatrix(ArrayList<Biergarten> biergaerten) {

		for(int i = 0; i < biergaerten.size(); i++) {
			for(int j = 0; j < biergaerten.size(); j++) {
				abstand(biergaerten.get(i), biergaerten.get(j));
			}
		}

	}

}
