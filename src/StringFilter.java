public class StringFilter {

	// Returns alpha-numeric string (SPACE is not allowed)
	public static String filter(String str) {
		if (str==null) return "null";
		return str.replaceAll("[^A-Za-z0-9]","").toLowerCase();
	}

	// Returns alpha-numeric string (SPACE is allowed)
	public static String filterB(String str) {
		if (str==null) return "null";
		return str.replaceAll("[^A-Za-z0-9 ]","").toLowerCase();
	}
}