package cp.testCases;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import cp.apis.sfdata;
import cp.apis.sfgetapplicationID;

public class sfdataTest {
	
	@Test(priority=1)
	public void salesforcedata() throws UnirestException
	{
		sfgetapplicationID.salesforcedata();
	}
	@Test(priority=2)
	public void salesforceOpp() throws UnirestException
	{
		sfdata.salesforcedata();
	}

}
