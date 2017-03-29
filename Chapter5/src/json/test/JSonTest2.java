package json.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JSonTest2 {

	public static void main(String[] args) 
			throws JsonProcessingException, IOException, ParseException {
		
		String jsonString="{\"field1\": \"value1\","
				+ "\"field2\": \"value2\","
				+ "\"field3\":{"
				+ "\"field4\":\"value4\","
				+ "\"field5\":\"value5\""
				+ "},"
				+ "\"field6\":[{"
				+ "\"field7\":\"value7\","
				+ "\"field8\":\"value8\""
				+ "},{"
				+ "\"field7\":\"value9\","
				+ "\"field8\":\"value10\""
				+ "}]"
				+ "}";
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
		
		//System.out.println(jsonObject.containsKey("field1")); //true
		//System.out.println(jsonObject.containsKey("field3")); //true
		//System.out.println(jsonObject.containsKey("field10"));//false 
	    String[] keyArray=new String[]{"field1","field3.field4","field6.field7"};
		for(String key:keyArray){
			searchKey(jsonObject,jsonObject,key.split("\\."));
			System.out.println("------------------");
		}
		
		
		
	}
	
	static void searchKey(JSONObject jsonObjectOrig,JSONObject jsonObjectNew, String[] key){
		if(key.length>1 &&
				jsonObjectNew.containsKey(key[0])){
			if(jsonObjectNew.get(key[0]).getClass()==JSONObject.class){
				jsonObjectNew=(JSONObject) jsonObjectNew.get(key[0]);
			}else{
				//Assume it is JsonArray
				JSONArray jsonArray=(JSONArray) jsonObjectOrig.get(key[0]);
				for(int i=0;i<jsonArray.size();i++){
					searchKey(jsonObjectOrig,(JSONObject) jsonArray.get(i),
							Arrays.copyOfRange(key, 1, key.length));
				}
			}
			key=Arrays.copyOfRange(key, 1, key.length);
			searchKey(jsonObjectOrig,jsonObjectNew,key);
		}
		
		if(jsonObjectNew!=null &&  jsonObjectNew.containsKey(key[0])){
			System.out.println("Key  is : "+ key[0] );
			System.out.println("Key value is : "+ jsonObjectNew.get(key[0]) );
		}
			
	}
	
	
}
