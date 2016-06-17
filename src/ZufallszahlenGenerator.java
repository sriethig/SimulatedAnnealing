import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZufallszahlenGenerator {

	public ZufallszahlenGenerator() {

	}

	public List<Integer> generate(int input) {
		List<Integer> zufallsZahlen = new ArrayList<Integer>();
		
		HashMap<Integer, Integer> verteilung = new HashMap<Integer, Integer>();
		for(int i = 1; i < 127; i++) {
			verteilung.put(i, 1);
		}
		
		int seed = input;
		int m = 2147483647;
		int factor = 16807;
		int additiveConst = 0;

		for(int i = 0; i < 2000; i++) {
			seed = (factor*seed + (additiveConst % m)) % 127;
			if(seed < 0) {
				seed = seed * (-1);
			}
			zufallsZahlen.add(seed + 1);
			verteilung.put(seed, (verteilung.get(seed) + 1));
		}
		
		/*for(int i = 1; i < 127; i++) {
			System.out.println(i + ": " + verteilung.get(i));
		}*/
		
		/*for(int i = 0; i < 127; i++) {
			System.out.println(i + ": " + zufallsZahlen.get(i));
		}*/

		return zufallsZahlen;
	}

}
