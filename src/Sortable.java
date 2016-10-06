import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.List;


public class Sortable {
	public static void main(String[] args) {

		// Path of JSON Input files
		String productFile = "./p.txt";
		String listngFile = "./l.txt";
		Product product = new Product();
		product.setProductName("YOLO");
		System.out.println(product.getProductName());
		//List<Product> productList = new ArrayList<Product>();

		JsonReader jj = new JsonReader("EEE");
		System.out.println(jj.file);

	}
}
