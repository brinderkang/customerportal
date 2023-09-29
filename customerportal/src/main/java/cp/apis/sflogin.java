package cp.apis;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class sflogin {
 public static String sftoken;
	public static void salesforcelogin() throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://test.salesforce.com/services/oauth2/token")
		  .header("Content-Type", "application/x-www-form-urlencoded")
		  .header("Cookie", "BrowserId=qwHmgBNyEeu2xWsZzyVoEg; CookieConsentPolicy=0:1; LSKey-c$CookieConsentPolicy=0:1")
		  .field("grant_type", "password")
		  .field("client_id", "3MVG9Vik22TUgUphKhs9dOlQTslN.n78UdCjA7Ys2VS4bKJWbadop3g.pTfN562svPWrLu3JmdXnkgT7tPkV4")
		  .field("client_secret", "7749285582146278058")
		  .field("username", "hal@lendingpoint.com.dev")
		  .field("password", "LP2#2Ap1$!gJkSAItroL59cnPUuXdQvy2Dk")
		  .asString();
		
		response.getBody();
		JSONObject jobj = new JSONObject(response.getBody());
		System.out.println(jobj);
		System.out.println();
		System.out.println(response.getBody());
		System.out.println(jobj.get("access_token"));
		sftoken= (String) jobj.get("access_token");
		 

	}

}
