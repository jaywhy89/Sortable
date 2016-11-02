import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Sortable {
	public static void main(String[] args) {

		// Path of JSON Input files
		// String productFile = "./p.txt";
		// String listingFile = "./l.txt";

		String productFile = "./products.txt";
		String listingFile = "./listings.txt";

		ListingReader listingReader = new ListingReader(listingFile);
		ProductReader productReader = new ProductReader(productFile);

		List<Listing> listing = listingReader.getListing();
		List<Product> product = productReader.getProduct();

	}
}
