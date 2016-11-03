import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListingReader {
	FileReader fileReader;
	BufferedReader bufferedReader;
	String obj;
	JSONObject jsonObj;
	List<Listing> listingList;

	public ListingReader(String file) {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			listingList = new ArrayList<Listing>();

			while ((obj=bufferedReader.readLine()) != null) {
				jsonObj = (JSONObject) new JSONParser().parse(obj);
				Listing item = new Listing();
				item.setTitle((String)jsonObj.get("title"));
				item.setManufacturer((String)jsonObj.get("manufacturer"));
				item.setCurrency((String)jsonObj.get("currency"));
				item.setPrice((String)jsonObj.get("price"));
				listingList.add(item);
			}

			System.out.println("Finished importing listings.txt");

			bufferedReader.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (ParseException ex) {
			ex.printStackTrace();
		}
	}

	public List<Listing> getListing() {
		return listingList;
	}
}