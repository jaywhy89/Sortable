import java.io.*;
import java.util.Arrays;
import java.io.FileWriter;
import java.util.Map;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

// Create results.txt and store results in JSON format

public class ResultsWriter {

public synchronized static void generateOutput(Map<String,ArrayList<Listing>> resultSet){
	try {
		File file = new File("results.txt");
		file.createNewFile();

		FileWriter writer = new FileWriter(file);

		// Results are store in HashMap data structure. 
		// 		KEY: product name (String)
		// 		VALUE: Array[Listing] (ArrayList of Listings)
		// Iterate HashMap and convert each entry into JSON object.
		for (Map.Entry<String,ArrayList<Listing>> entry : resultSet.entrySet()){
			String productName = entry.getKey();
			ArrayList<Listing> listing = entry.getValue();
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			
			jsonObj.put("product_name",productName);

			for (Listing l : listing) {
				JSONObject item = new JSONObject();
				item.put("price",l.getPrice());
				item.put("currency",l.getCurrency());
				item.put("manufacturer",l.getManufacturer());
				item.put("title",l.getTitle());
				jsonArr.add(item);
			}
			jsonObj.put("listings",jsonArr);

			// Write JSON Object to file
			writer.write(jsonObj.toString()+"\n");		
		}
		writer.close();
	}
	catch (IOException ex) {
		ex.printStackTrace();
	}
}

}