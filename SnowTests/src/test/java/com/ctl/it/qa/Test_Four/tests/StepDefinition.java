package com.ctl.it.qa.Test_Four.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ctl.it.qa.Test_Four.tools.steps.SendMail;
//import com.ctl.it.qa.Test_Four.tools.steps.AsriSanity.AsriCeSanitySteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.ServiceNowSteps;
import com.ctl.it.qa.Test_Four.tools.steps.user.UserSteps;
import com.ctl.it.qa.staf.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class StepDefinition {
	@Steps
	UserSteps userSteps;
	
	

	@Before
	public void beforeEveryScenario(Scenario scenario) {
		Serenity.setSessionVariable("file_type").to(scenario.getName());
//		String tcNo=scenario.getName().substring(0,6);
//		System.setProperty("TC_No", tcNo); 
//		String test_No=System.getProperty("TC_No"); 
//		System.out.println("Test Case No-"+test_No);
		ArrayList<String>  allTags=(ArrayList<String>) scenario.getSourceTagNames();
	    for(int i=0;i<=allTags.size()-1;i++)
	    {
	    	//System.out.println(allTags.get(i));
	    	if(allTags.get(i).startsWith("@DIA")||allTags.get(i).startsWith("@Wave"))
	    	{
	    	String scenarioName1=allTags.get(i);
	    	System.out.println("Scenario Name="+scenarioName1);
	    	String scenarioName=allTags.get(i).substring(1);
	    	System.setProperty("ScenarioName", scenarioName); 
	    	System.out.println(System.getProperty("ScenarioName"));
	    	
	    	}
	    }
	}

	@After
	public void afterEveryScenario(Scenario scenario) {
		String oppOrderID = System.getProperty("OppOrder.ID");
		String smId = System.getProperty("SID.ID");
		String boid = System.getProperty("Swift.ID");
		// String order_Id=SwiftSteps.myOpid;
		String snowOrderID = ServiceNowSteps.snowOrderId;
		try {
			com.ctl.it.qa.staf.Steps.isInitialized = false;
			Page.isInitialized = false;
			// scenario.write("Data used for this test case:" + "\r\n");
			scenario.log("Opportunity Id used for this test case:" + oppOrderID);
			scenario.log("SM Id used for this test case:" + smId);
			scenario.log("Snow Order used for this test case:" + snowOrderID);
		    ServiceNowSteps.snowOrderId="";
			// scenario.write("Boid Id used for this test case:" +boid );
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) userSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshots");
				File srcFile = ((TakesScreenshot) userSteps.getDriver()).getScreenshotAs(OutputType.FILE);
				String scName = scenario.getName().substring(0, 5);
				String userDir = System.getProperty("user.dir");
				FileUtils.copyFile(srcFile, new File(userDir + "\\target\\screenshot\\" + scName + ".png"));
			}
		} catch (Exception e) {
		} finally {
			String currentURL = userSteps.getDriver().getCurrentUrl(); // get the current url of
			// String myEnv = System.getProperty("staf.environment.key");
			// String to[] = { "Rajneesh.k.gautam@lumen.com", "@centurylink.com",
			// "@level3.com" };
			String to[] = { "Rajneesh.k.gautam@lumen.com" };
			try {
				SendMail.send("Rajneesh.k.gautam@lumen.com", to, "Digital Dialogue SNOW" + " - " + currentURL + " - ",
						"");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			userSteps.captureTestResult(scenario);
			userSteps.getDriver().close();
			userSteps.getDriver().quit();
		}
	}
}
