import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	public String file;
	BufferedReader br = null;

	public JsonReader(String file) {
		this.file = file;
	}

	// public 
	// try{
	// 		br = new BufferedReader(new FileReader(new File(productFile)));
	// 		String jsonObj = null;
	// 		while ((jsonObj=br.readLine()) != null) {
	// 			System.out.println(jsonObj);
	// 		}
	// 	}
	// catch (IOException ex) {
	// 	ex.printStackTrace();
	// }

}