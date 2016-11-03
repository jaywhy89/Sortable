import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Sortable {
	
	// Match counters for each test case
	static int perfectMatch = 0;
	static int strongMatch = 0;
	static int possibleMatch = 0;

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		// Input File Path
		String productFile = "./inputfile/products.txt";
		String listingFile = "./inputfile/listings.txt";

		// Import input files
		ProductReader productReader = new ProductReader(productFile);
		ListingReader listingReader = new ListingReader(listingFile);

		// Create ArrayList of Products and Listings
		List<Product> product = productReader.getProduct();
		List<Listing> listing = listingReader.getListing();

		// Create results in HashSet (K-product name, V-ArrayList of Listing)
		Map<String,ArrayList<Listing>> resultSet = SortableMatcher.matchItems(product, listing);

		// Create "results.txt" and store the results in JSON format
		ResultsWriter.generateOutput(resultSet);

		// Print code execution time and location of output file
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("\t(Code execution time: "+executionTime+" ms)\n");
		System.out.println("Please check results.txt for output.\n");
	}
}
