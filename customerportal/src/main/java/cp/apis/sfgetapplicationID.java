package cp.apis;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import cp.base.Baseclass;



public class sfgetapplicationID extends Baseclass{
	public static String externalId;
	
	public static void salesforcedata() throws UnirestException
	{
		System.out.println("sfdata = : "+sflogin.sftoken);
		System.out.println(cp.pages.Applynow2.sfemail);
		String email= cp.pages.Applynow2.sfemail;
		try {
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.get(prop.getProperty("sfurl")+"/query/?q=select+Id,External_Id__c+from+Opportunity+where+Contact_Email__c+=+'"+email+"'")
			  .header("Authorization", "Bearer "+ sflogin.sftoken)
			  .header("Cookie", "BrowserId=3XwbyA7lEeumMLNqQFClzQ; BrowserId=olcYHaXQEeyTHY_xno_R0g")
			  .asString();
			
			System.out.println(response.getBody());
			JSONObject jobj= new JSONObject(response.getBody());
			System.out.println(response.getBody());

			System.out.println(jobj.getJSONArray("records").getJSONObject(0).get("Id"));
			System.out.println(jobj.getJSONArray("records").getJSONObject(0).get("External_Id__c"));
			externalId = (String) jobj.getJSONArray("records").getJSONObject(0).get("External_Id__c");
		/*	JSONArray records = jobj.getJSONArray("records");
	        JSONObject result1 = records.getJSONObject(0);
	        System.out.println(result1);
	        String appID = (String) result1.get("Id");
	        System.out.println(appID);
			System.out.println(jobj.getJSONArray("records").getJSONObject(0).get("Id"));
			
			System.out.println(jobj.get("System.out.println(jobj.getJSONArray(\"records\").getJSONObject(0).get(\"Id\"));"));
			*/
			
			//System.out.println(jobj.getJSONObject("records").get("External_Id__c"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Catch");
		}
		


	}

}
