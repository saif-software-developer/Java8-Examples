package json.test;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws JsonProcessingException, IOException, ParseException {
		
		String json = "[{\"code\":\"TOWCAP3SAE\","
				+ "\"isTerms\":false,\"body\":\"Before towing, confirm your vehicle and trailer are compatible, "
				+ "hooked up properly and you have any necessary additional equipment. If gross trailer weight is above 5,000 lb (2,268 kg),"
				+ " it is necessary to use a weight-distributing hitch with sufficient capacity."
				+ " Do not exceed any Weight Ratings and follow all instructions and cautions from your"
				+ " trailer-hitch manufacturer and vehicle <em>Owner&apos;s Manual</em>. "
				+ "The maximum amount you can tow depends on the total weight of any cargo,"
				+ " occupants and available equipment.\"},{\"code\":\"TOWLOAD\",\"isTerms\":false,\"body\":\""
				+ "Please consult your Lexus dealer or <em>Owner&apos;s Manual</em> for towing and load specifications.\"}]\"";
		
//		ObjectMapper objectMapper= new ObjectMapper();
//		JsonNode node=objectMapper.readTree(json);
//		System.out.println(node.asText());
		
		 JSONParser jsonParser = new JSONParser();
		 JSONArray jsonArray = (JSONArray) jsonParser.parse(json);
		 	 
		// get a String from the JSON object
		 JSONObject jsonObject =  (JSONObject) jsonArray.get(0);
		 System.out.println("jsonObject is: " + jsonObject);
		
		// get a String from the JSON object
		String code = (String) jsonObject.get("code");
		 System.out.println("code is: " + code);
		 
		 // get a String from the JSON object
		 String body = (String) jsonObject.get("body");
		 System.out.println("body is: " + body);

	}

}
