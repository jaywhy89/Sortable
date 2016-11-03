import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SortableMatcher {

	public synchronized static Map<String,ArrayList<Listing>> matchItems(List<Product> product, List<Listing> listing) {
		System.out.println("\n[Starting Matching]");

		Map<String,ArrayList<Listing>> resultMap = new HashMap<String,ArrayList<Listing>>();

		//Initialize HashMap with number of products.
		for (Product p : product) {
			resultMap.put(p.getProductName(),new ArrayList<Listing>());
		}


		// Iterate over products to find PERFECT MATCH & STRONG MATCH
		System.out.print("Finding matches...");
		for (Product p : product) {
			List<Listing> found = new ArrayList<Listing>();
			String productManufac = p.getManufacturer();
			String productModel = p.getModel();
			String productName = p.getProductName();
			String productFamily = p.getFamily();

			Pattern pModel = Pattern.compile("\\b"+productModel+"\\b");
			Pattern pManufac = Pattern.compile("\\b"+productManufac+"\\b");
			Pattern pFamily = Pattern.compile("\\b"+productFamily+"\\b");

			for (Listing l : listing) {
				String listManufac = StringFilter.filter(l.getManufacturer());
				String listTitle = StringFilter.listFilter(l.getTitle());
				Matcher mModel = pModel.matcher(listTitle);
				Matcher mManufac = pManufac.matcher(listTitle);
				Matcher mFamily = pFamily.matcher(listTitle);

				if (listManufac.equals(productManufac) && mModel.find()) {
					System.out.println("\n\t\tPERFECT match");
					System.out.println("p Name : "+productName);
					System.out.println("p Manu : "+productManufac);
					System.out.println("p Fam  : "+productFamily);
					System.out.println("p Model: "+productModel);
					System.out.println("l Title: "+l.getTitle());
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.perfectMatch++;
				} else if (mManufac.find() && mModel.find()) {
					System.out.println("\n\t\tSTRONG match");
					System.out.println("p Name : "+productName);
					System.out.println("p Manu : "+productManufac);
					System.out.println("p Fam  : "+productFamily);
					System.out.println("p Model: "+productModel);
					System.out.println("l Title: "+l.getTitle());
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.strongMatch++;
				} else if (mFamily.find() && mModel.find()) {
					System.out.println("\n\t\tPOSSIBLE match");
					System.out.println("p Name : "+productName);
					System.out.println("p Manu : "+productManufac);
					System.out.println("p Fam  : "+productFamily);
					System.out.println("p Model: "+productModel);
					System.out.println("l Title: "+l.getTitle());
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.possibleMatch++;
				}
			}
			listing.removeAll(found);
		}
		System.out.println("\tFound "+Sortable.perfectMatch+" PERFECT matches.");
		System.out.println("\n\t\t\t\tFound "+Sortable.strongMatch+" STRONG matches.");
		System.out.println("\n\t\t\t\tFound "+Sortable.possibleMatch+" POSSIBLE matches.");
		
		System.out.println("\n\t\t\t[Matching Finished.]\n");
		System.out.print("\nProgram found total of "+(Sortable.perfectMatch+Sortable.strongMatch+Sortable.possibleMatch)+" matches.");

		return resultMap;
	}
}





// System.out.println("\n\tPOSSIBLE match");
// System.out.println("p Name : "+productName);
// System.out.println("p Manu : "+productManufac);
// System.out.println("p Fam  : "+productFamily);
// System.out.println("p Model: "+productModel);
// System.out.println("l Title: "+l.getTitle());