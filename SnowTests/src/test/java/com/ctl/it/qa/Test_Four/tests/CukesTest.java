package com.ctl.it.qa.Test_Four.tests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.ctl.it.qa.staf.Environment;
import com.ctl.it.qa.staf.HtmlReport;
import com.ctl.it.qa.staf.STAFEnvironment;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@TestEnvironment(Environment.TEST4) //Test Environment on which execution is to happen is provided
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html", "html:target/site/serenity/index.html",
		"json:target/jira-xray-data.json", "json:targets/sanity.json", "json:target/cucumber-report.json",
		"usage:target/site/serenity/cucumber-usage.json" }, 
features = "src/test/resources/features", tags = "@All_Scenario")
public class CukesTest {
	/*
	 * COMMENTS ARE ADDED TO BELOW MENTIONED CLA-SSES IN TESTS PROJECTS FOR BETTER
	 * UNDERSTANDING OF STAF
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/CukesTest.java
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/steps/centurylink/
	 * SmallBusinessStepDefinition.java
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/steps/user/
	 * UserStepDefinition.java
	 */
	/*
	 * COMMENTS ARE ADDED TO BELOW MENTIONED CLASSES IN TOOLS PROJECTS FOR BETTER
	 * UNDERSTANDING OF STAF
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/steps/user/UserSteps.
	 * java
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/steps/smallbusiness/
	 * SmallBusinessSteps.java
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/pages/common/HomePage.
	 * java
	 */
	
	@BeforeClass
	public static void setEnvironment() {
		STAFEnvironment.registerEnvironment(CukesTest.class);
		Steps.initialize("Test_Four.xml");// Data input file name (present in
		// SampleTools/src/test/resources) is provided
		// Steps.initialize("E2E.xml"); // Data input file name for DIA BAU
		
	}

	@AfterClass
	public static void clearEnvironment() {
		HtmlReport.generate();
//		String OrderID = System.getProperty("Order.ID");
//		String smId= System.getProperty("SID.ID");
//		String order_Id=SwiftSteps.myOpid;			
//		System.out.println("Opportunity ID Used for the order-"+OrderID);
//		System.out.println("SM ID Used for the order-"+smId);
//		System.out.println("Order ID Used for the order-"+order_Id);
				
	}
	
}