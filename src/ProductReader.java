import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// ProductReader class to import products.txt

public class ProductReader {
	FileReader fileReader;
	BufferedReader bufferedReader;
	String obj;
	JSONObject jsonObj;
	List<Product> productList;

	public ProductReader(String file) {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			productList = new ArrayList<Product>();

			while ((obj=bufferedReader.readLine()) != null) {
				jsonObj = (JSONObject) new JSONParser().parse(obj);
				Product item = new Product();

				// Initialize Product class properties
				item.setProductName((String)jsonObj.get("product_name"));
				item.setManufacturer(StringFilter.filter((String)jsonObj.get("manufacturer")));
				item.setFamily(StringFilter.filter((String)jsonObj.get("family")));
				item.setModel((String)jsonObj.get("model"));
				item.setAnnouncedDate((String)jsonObj.get("announced-date"));

				productList.add(item);
			}

			bufferedReader.close();
			System.out.println("\nFinished importing /inputfile/products.txt");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (ParseException ex) {
			ex.printStackTrace();
		}
	}

	public List<Product> getProduct() {
		return productList;
	}
}