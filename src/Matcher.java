import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Matcher {

	public synchronized static Map<String,ArrayList<Listing>> matchItems(List<Product> product, List<Listing> listing) {
		System.out.println("\n[Starting Matching]");

		Map<String,ArrayList<Listing>> resultMap = new HashMap<String,ArrayList<Listing>>();

		//Initialize HashMap with number of products.
		for (Product p : product) {
			resultMap.put(p.getProductName(),new ArrayList<Listing>());
		}

		// Iterate over products to find PERFECT MATCH
		System.out.print("Finding PERFECT MATCH...");
		for (Product p : product) {
			List<Listing> found = new ArrayList<Listing>();
			for (Listing l : listing) {
				String listManufac = StringFilter.filter(l.getManufacturer());
				String listTitle = StringFilter.filter(l.getTitle());
				String productManufac = p.getManufacturer();
				String productModel = p.getModel();
				if (listManufac.equals(productManufac) && listTitle.contains(productModel)) {
					resultMap.get(p.getProductName()).add(l);
					found.add(l);
					Sortable.perfectMatch++;
				}
			}
			listing.removeAll(found);
		}
		System.out.println("\tFound "+Sortable.perfectMatch+" PERFECT matches.");

		// Iterate over reamining listing to find STRONG MATCH
		System.out.print("\nFinding STRONG MATCH...");
		for (Listing l : listing) {
			for (Product p : product) {
				String listTitle = StringFilter.filter(l.getTitle());
				String productName = p.getProductName();
				String productManufac = p.getManufacturer();
				String productModel = p.getModel();
				String productFamily = p.getFamily();

				if ((listTitle.contains(productManufac) && listTitle.contains(productModel))) {
					resultMap.get(productName).add(l);
					Sortable.strongMatch++;
				}
			}
		}
		System.out.println(" \tFound "+Sortable.strongMatch+" STRONG matches.");
		System.out.println("\n\t\t\t[Matching Finished.]\n");
		System.out.print("\nProgram found total of "+(Sortable.perfectMatch+Sortable.strongMatch)+" matches.");

		return resultMap;
	}
}