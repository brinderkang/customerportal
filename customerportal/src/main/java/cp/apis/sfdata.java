package cp.apis;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import cp.base.Baseclass;



public class sfdata extends Baseclass {
	
	public static void salesforcedata() throws UnirestException
	{
		System.out.println("sfdata = : "+sflogin.sftoken);
		String external_id= sfgetapplicationID.externalId;
		try {
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.get(prop.getProperty("sfurl")+"/query/?q=select+Contact_Email__c,Id+from+Opportunity+where+External_Id__c+=+'"+external_id+"'")
			  .header("Authorization", "Bearer "+ sflogin.sftoken)
			  .header("Cookie", "BrowserId=3XwbyA7lEeumMLNqQFClzQ; BrowserId=olcYHaXQEeyTHY_xno_R0g")
			  .asString();
			
			System.out.println(response.getBody());
			JSONObject jobj= new JSONObject(response.getBody());
			System.out.println(response.getBody());
			System.out.println(jobj.getJSONArray("records").getJSONObject(0).get("Id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Catch");
		}
		
		

	}

}
