import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZufallszahlenGenerator {

	public ZufallszahlenGenerator() {

	}

	public List<Integer> generate(int input) {
		List<Integer> zufallsZahlen = new ArrayList<Integer>();
		
		HashMap<Integer, Integer> verteilung = new HashMap<Integer, Integer>();
		for(int i = 0; i < 127; i++) {
			verteilung.put(i, 1);
		}
		
		int seed = input;
		int m = 21454;
		int factor = 1927843;
		int additiveConst = 18237890;

		for(int i = 0; i < 2000; i++) {
			seed = (factor*seed + (additiveConst % m)) % 128;
			if(seed < 0) {
				seed = seed * (-1);
			}
			zufallsZahlen.add(seed);
			verteilung.put(seed, (verteilung.get(seed) + 1));
		}
		
		for(int i = 0; i < 127; i++) {
			System.out.println(i + ": " + verteilung.get(i));
		}

		return zufallsZahlen;
	}

}
