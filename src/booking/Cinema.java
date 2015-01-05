package booking;

import java.util.HashMap;
import java.util.Map;

public class Cinema {

	public static String CINEMA_THE_MALL = "THE MALL";
	public static String CINEMA_MALL_OF_SOFIA = "MALL OF SOFIA";
	public static String CINEMA_RING_MALL = "RING MALL";
	public static String CINEMA_BULGARIA_MALL = "BULGARIA MALL";
	public static String CINEMA_CCS = "CCS";
	
	static Map<Integer, String> cinemas;
	
	static {
		cinemas = new HashMap<>();
		cinemas.put(0, CINEMA_THE_MALL);
		cinemas.put(1, CINEMA_MALL_OF_SOFIA);
		cinemas.put(2, CINEMA_RING_MALL);
		cinemas.put(3, CINEMA_BULGARIA_MALL);
		cinemas.put(4, CINEMA_CCS);
	}
	
	public static String getCinemaNameById(int id) {
		return cinemas.get(id);
	}
}
