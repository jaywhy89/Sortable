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


		Map<String,ArrayList<Listing>> resultSet = Matcher.matchItems(product, listing);

		OutputWriter.generateOutput(resultSet);

		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("\t(Code execution time: "+executionTime+" ms)\n");
		System.out.println("Please check result.txt for output.\n");
	}
}
