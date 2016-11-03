import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SortableMatcher {

	public synchronized static Map<String,ArrayList<Listing>> matchItems(List<Product> product, List<Listing> listing) {
		System.out.println("\n[Starting Matching]\n");

		Map<String,ArrayList<Listing>> resultMap = new HashMap<String,ArrayList<Listing>>();

		// Initialize HashMap (KEY: product name, VALUE: ArrayList of Listing)
		for (Product p : product) {
			resultMap.put(p.getProductName(),new ArrayList<Listing>());
		}

		/*
			For each Product, iterate over Listing to find matches. 

							<3 Types of Matching>
			[PERFECT match]
				- Listing's manufacturer = Product's maufacturer
				- Listing's title contains Product's model
			
			[STRONG match]
				- Listing's title contains Product's model AND manufacturer

			[POSSIBLE match]
				- Listing's title contains Produtc's model AND family
		*/

		System.out.print("Finding matches...");

		for (Product p : product) {
		
			/* Initialize Product properties
		  	    NOTE: productModel has 3 variants to increase matching case
		  			1.LowerCase 
		 			2.LowerCase + Alpha-numeric (wo/ space char)
		 			3.LowerCase + Alpha-numeric (w/ space char)
			*/
			List<Listing> found = new ArrayList<Listing>();
			String productManufac = p.getManufacturer();
			String productModel = p.getModel().toLowerCase();
			String productModel2 = StringFilter.filter(productModel);
			String productModel3 = StringFilter.filterB(productModel);
			String productName = p.getProductName();
			String productFamily = p.getFamily();

			Pattern pModel = Pattern.compile("\\b"+productModel+"\\b");
			Pattern pModel2 = Pattern.compile("\\b"+productModel2+"\\b");
			Pattern pModel3 = Pattern.compile("\\b"+productModel3+"\\b");
			Pattern pManufac = Pattern.compile("\\b"+productManufac+"\\b");
			Pattern pFamily = Pattern.compile("\\b"+productFamily+"\\b");

			for (Listing l : listing) {
				String listManufac = StringFilter.filter(l.getManufacturer());
				String listTitle = StringFilter.filterB(l.getTitle());
				Matcher mModel = pModel.matcher(listTitle);
				Matcher mModel2 = pModel2.matcher(listTitle);
				Matcher mModel3 = pModel3.matcher(listTitle);
				Matcher mManufac = pManufac.matcher(listTitle);
				Matcher mFamily = pFamily.matcher(listTitle);

				// PERFCET MATCH
				if (listManufac.equals(productManufac) && (mModel.find()||mModel2.find()||mModel3.find())) {
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.perfectMatch++;
				}
				// STRONG MATCH 
				else if (mManufac.find() && (mModel.find()||mModel2.find()||mModel3.find())) {
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.strongMatch++;
				}
				// POSSIBLE MATCH 
				else if (mFamily.find() && (mModel.find()||mModel2.find()||mModel3.find())) {
					resultMap.get(productName).add(l);
					found.add(l);
					Sortable.possibleMatch++;
				}
			}
			listing.removeAll(found);
		}

		// Print number of matches
		System.out.println("\tFound "+Sortable.perfectMatch+" PERFECT matches.");
		System.out.println("\n\t\t\tFound "+Sortable.strongMatch+" STRONG matches.");
		System.out.println("\n\t\t\tFound "+Sortable.possibleMatch+" POSSIBLE matches.");
		
		System.out.println("\n\t\t\t\t[Matching Finished.]\n");
		System.out.print("\nProgram found total of "+(Sortable.perfectMatch+Sortable.strongMatch+Sortable.possibleMatch)+" matches.");

		return resultMap;
	}
}




// Below was used for manual testing with small data set.

// System.out.println("\n\tPOSSIBLE match");
// System.out.println("p Name : "+productName);
// System.out.println("p Manu : "+productManufac);
// System.out.println("p Fam  : "+productFamily);
// System.out.println("p Model: "+productModel);
// System.out.println("l Title: "+l.getTitle());