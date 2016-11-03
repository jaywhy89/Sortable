public class StringFilter {

	public static String filter(String str) {
		if (str==null) return "null";
		return str.replaceAll("[^A-Za-z0-9]","").toLowerCase();
	}

	public static String listFilter(String str) {
		if (str==null) return "null";
		return str.replaceAll("[^A-Za-z0-9 ]","").toLowerCase();
	}
}