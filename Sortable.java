import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sortable {
	public static void main(String[] args) {

		//Open Products file
		String productFile = "./p.txt";
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(new File(productFile)));
			String jsonObj = null;
			while ((jsonObj=br.readLine()) != null) {
				System.out.println(jsonObj);
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
