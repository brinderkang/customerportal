package cp.testCases;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import cp.apis.sflogin;

public class sfloginTest {
	
	@Test
	public void salesforcelogintest() throws UnirestException
	{
		sflogin.salesforcelogin();
	}

}
