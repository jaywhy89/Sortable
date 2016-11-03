import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Sortable {
	static int perfectMatch = 0;
	static int strongMatch = 0;

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		// Input File Path
		String productFile = "./inputfile/products.txt";
		String listingFile = "./inputfile/listings.txt";

		ProductReader productReader = new ProductReader(productFile);
		ListingReader listingReader = new ListingReader(listingFile);

		List<Product> product = productReader.getProduct();
		List<Listing> listing = listingReader.getListing();


		Map<String,ArrayList<Listing>> resultSet = matchItems(product, listing);

		OutputWriter.generateOutput(resultSet);

		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("\t(Code execution time: "+executionTime+" ms)\n");
		System.out.println("Please check result.txt for output.\n");
	}

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
				String listManufac = filter(l.getManufacturer());
				String listTitle = filter(l.getTitle());
				String productManufac = p.getManufacturer();
				String productModel = p.getModel();
				if (listManufac.equals(productManufac) && listTitle.contains(productModel)) {
					resultMap.get(p.getProductName()).add(l);
					found.add(l);
					perfectMatch++;
				}
			}
			listing.removeAll(found);
		}
		System.out.println("\tFound "+perfectMatch+" PERFECT matches.");

		// Iterate over reamining listing to find STRONG MATCH
		System.out.print("\nFinding STRONG MATCH...");
		for (Listing l : listing) {
			for (Product p : product) {
				String listTitle = filter(l.getTitle());
				String productName = p.getProductName();
				String productManufac = p.getManufacturer();
				String productModel = p.getModel();
				String productFamily = p.getFamily();

				if ((listTitle.contains(productManufac) && listTitle.contains(productModel))) {
					resultMap.get(productName).add(l);
					strongMatch++;
				}
			}
		}
		System.out.println(" \tFound "+strongMatch+" STRONG matches.");
		System.out.println("\n\t\t\t[Matching Finished.]\n");
		System.out.print("\nProgram found total of "+(perfectMatch+strongMatch)+" matches.");

		return resultMap;
	}

	public static String filter(String str) {
		if (str==null) return "null";
		return str.replaceAll("[^A-Za-z0-9]","").toLowerCase();
	}
}
