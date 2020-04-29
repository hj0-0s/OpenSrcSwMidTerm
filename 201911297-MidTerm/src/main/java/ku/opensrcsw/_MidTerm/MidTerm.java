package ku.opensrcsw._MidTerm;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;

public class MidTerm {
	public static void main(String[] args) {
		JSONParser jsonP = new JSONParser();
		Scanner scan = new Scanner(System.in);
		try {
			FileReader file = new FileReader("c:/midterm.json");
			JSONObject jsonObj = (JSONObject)jsonP.parse(file);
			JSONArray arr = (JSONArray)jsonObj.get("poem");
			String[] arr2 = new String[14];
			for(int i = 0;i < 14;i++) {
				JSONObject temp = (JSONObject)arr.get(i);
				arr2[i] = (String)temp.get("item");
			}
			System.out.print("Enter the pattern you are looking for:");
			String oper = scan.nextLine();
			for(int i = 0;i<14;i++) {
				if(arr2[i].contains(oper))
					System.out.println("item "+i+": "+arr2[i]);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
}