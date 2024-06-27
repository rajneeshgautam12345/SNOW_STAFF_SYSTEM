package com.ctl.it.qa.Test_Four.tools.steps.Oppty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.CreditCheckPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.NetworkDesignerPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import io.cucumber.java.Scenario;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

// 
@SuppressWarnings("serial")
public class CreateOppySteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(CreateOppySteps.class);
	// private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	NetworkDesignerPage networkdesignerpage;
	CreditCheckPage creditcheckpage;
	
	@Step
	public void user_creates_an_Opportunity(String sAccount, int pdays) {
		// ###################################DEBUG ENDS HERE
		// ########################################################################
		String myEnv = System.getProperty("staf.environment.key");
		Long tempNum = Math.round(Math.random() * 1000000);
	    String tcName= System.getProperty("TC_No"); 
		String myOppName = tcName+String.valueOf(tempNum);
		System.setProperty("myOpp_name.ID", myOppName); // set the oppty name into memory
		String sOppName = System.getProperty("myOpp_name.ID"); // get the oppty name from memory
		logger.info("Create Opportunity " + sOppName);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, pdays);
		String newDate = dateFormat.format(cal.getTime());
		logger.info("Search for Account");
		waitABit(1000);
		homePage.waitForTextToAppear("Today's Events", 90000);
		homePage.txt_search.withTimeoutOf(Duration.ofSeconds(30)).waitUntilPresent().click(); // Account Text
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(sAccount);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		homePage.waitForTextToAppear("Search Results", 30000);
		homePage.waitForTextToAppear("Top Results", 60000);
		waitABit(4000);
		homePage.account_tab.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(240));
		homePage.account_tab.click();
		logger.info("Clicked on Account tab section");
		waitABit(2000);
		getDriver().findElement(By.xpath(homePage.customer1 + sAccount + homePage.customer2)).isDisplayed();
		waitABit(1000);
		
		if(sAccount.equals("Costco Wholesale Corporation"))
		{
		getDriver()
				.findElement(
						By.xpath("//span[text()='3-A67847']/../../../th//a[@title='Costco Wholesale Corporation']"))
				.click();
		}
		else
		{
			getDriver().findElement(By.xpath(homePage.customer1 + sAccount + homePage.customer2)).click();	
		}
		// getDriver().findElement(By.xpath(homePage.customer1+sAccount+homePage.customer2)).click();
//		getDriver().findElement(By.linkText(sAccount)).isDisplayed(); // wait for account name to appear
//		getDriver().findElement(By.linkText(sAccount)).click(); // click on account name
		// waitABit(5000);
		homePage.waitForTextToAppear("Account", 20000);
		logger.info("Successfully navigated to account section");
		// Create Opportunity
		homePage.waitForTextToAppear("Account Details", 60000);
		WebElement element = null;
		// WebElement element1 = null;
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		for (int i = 0; i < 3; i++) {
			try {
				logger.info("Trying to click the oppertunity tab");
				element = getDriver().findElement(By.xpath("//a[contains(@data-label,'Opportunities')]"));
			} catch (Exception e) {
				System.out.println("in catch"); // end of getting order id
			}
		}
		jse.executeScript("arguments[0].click()", element);
		logger.info("Clicking on the Oppertunity tab");
		waitABit(2000);
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("in catch for new oppty tab "); // end of getting order id
		}
		waitABit(5000);
		JavascriptExecutor btn_executor = (JavascriptExecutor) getDriver();
		homePage.btn_new_opp.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(300));
		
		btn_executor.executeScript("arguments[0].scrollIntoView(true);", homePage.btn_new_opp);
		btn_executor.executeScript("arguments[0].click();", homePage.btn_new_opp);
		logger.info("New opportunity quote button clicked");
		homePage.recordType.withTimeoutOf(Duration.ofSeconds(30)).waitUntilPresent();
		homePage.recordType.withTimeoutOf(Duration.ofSeconds(30)).click();
		logger.info("Opportunity quote button picked");
		homePage.btn_opp_next.withTimeoutOf(Duration.ofSeconds(30)).waitUntilEnabled();
		homePage.btn_opp_next.withTimeoutOf(Duration.ofSeconds(30)).click();
		logger.info("Opportunity next button clicked");
		homePage.waitForTextToAppear("Opportunity Owner", 40000);
		homePage.txt_opp_name.withTimeoutOf(Duration.ofSeconds(30)).waitUntilPresent().type(myOppName);
		// waitABit(8000);
		logger.info("Opportunity name is entered");
		logger.info("The environment is : " + myEnv);
//		switch (myEnv.toUpperCase()) {
//		case "TEST1":
//		case "TEST2":
//			System.out.println("in Case TEST 1 or 2");
//		homePage.dd_opp_sub_type1.withTimeoutOf(Duration.ofSeconds(30)).click();
//		homePage.dd_opp_sub_type1.withTimeoutOf(Duration.ofSeconds(30)).click();
//		homePage.dd_opp_sub_type_new_Services.withTimeoutOf(Duration.ofSeconds(30)).click();
		waitABit(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", homePage.dd_sub_type_motion);
		homePage.dd_sub_type_motion.withTimeoutOf(Duration.ofSeconds(30)).click();
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Sub type motion value added successfully");
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);			
		homePage.txt_opp_date.withTimeoutOf(Duration.ofSeconds(30)).type(newDate);
		jse.executeScript("arguments[0].scrollIntoView(true);", homePage.dd_opp_stage);
		homePage.dd_opp_stage1.withTimeoutOf(Duration.ofSeconds(30)).click();
		homePage.dd_opp_stage_Qua.withTimeoutOf(Duration.ofSeconds(30)).click();
		logger.info("Opportunity data entered successfully");
		if (sAccount.equals("Robert Half International -Indirect")) {
			homePage.partnerSalesrepId.sendKeys("DCMP");
			logger.info("Partner sales rep Id entered successfully");
		}
//			break;
//		case "TEST3":
//		case "TEST4":
//			System.out.println("in Case TEST4");			
//			homePage.dd_opp_sub_type1.withTimeoutOf(Duration.ofSeconds(30)).click();
//			homePage.dd_opp_sub_type1.withTimeoutOf(Duration.ofSeconds(30)).click();		
//			homePage.dd_opp_sub_type_new_Services.withTimeoutOf(Duration.ofSeconds(30)).click();		
//			homePage.txt_opp_date.withTimeoutOf(Duration.ofSeconds(30)).type(newDate);			
//			jse.executeScript("arguments[0].scrollIntoView(true);", homePage.dd_opp_stage);
//			homePage.dd_opp_stage1.withTimeoutOf(Duration.ofSeconds(30)).click();			
//			homePage.dd_opp_stage_Qua.withTimeoutOf(Duration.ofSeconds(30)).click();
//			System.out.println("Opportunity is created in TEST4");
//			break;
//		default:
//			System.out.println("no Environment found");
//			break;
//		}
		waitABit(700);
		homePage.btn_save_opp.withTimeoutOf(Duration.ofSeconds(30)).waitUntilEnabled().click();
		logger.info("Opportunity save button clicked ");
		try {
			homePage.waitForTextToAppear("was created.", 60000);
		} catch (Exception e) {
			System.out.println("in catch for in new oppty was created"); // end of getting order id
		}
		// Open Opportunity
		logger.info("Open Opportunity " + myOppName);
		int env;
		String environment = myEnv.toUpperCase();
		if (environment.equals("TEST1")) {
			env = 1;
		} else if (environment.equals("TEST2")) {
			env = 2;
		} else if (environment.equals("TEST3")) {
			env = 3;
		} else {
			env = 4;
		}
		switch (env) {
		case 1:
			homePage.openAt(
					"https://lumn--itv1.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
			break;
		case 2:
			homePage.openAt(
					"https://lumn--itv2.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
			break;
		case 3:
			homePage.openAt("https://lumn--itv3.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
			break;
		case 4:
			homePage.openAt(
					"https://lumn--e2e.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
			break;
		default:
			System.out.println("no envirnment found");
			break;
		}
		homePage.waitForTextToAppear("Recently Viewed", 80000);
		homePage.lbl_oppty_id.withTimeoutOf(Duration.ofSeconds(30)).waitUntilEnabled();
		String tempOrderID = homePage.lbl_oppty_id.getText(); // get the oppty id
		System.setProperty("OppOrder.ID", tempOrderID);
		String OrderID = System.getProperty("OppOrder.ID");
		E2ESteps.softAssertError("Opportunity", true, "the Oppid id is ", String.valueOf(OrderID));
		logger.info("Opportunity_ID  is  " + OrderID); // end of getting order id
		// logger.info("Create Scenario " + myOppName);
		getDriver().findElement(By.linkText(myOppName)).click();// click on the new oppty just created
		waitABit(2000);
		logger.info("Successfully created the Opprtunity");
		E2ESteps.printInGreenColor("Opportunity created ", "Opportunity_ID  is  " + OrderID);
		E2ESteps.printInGreenColor("Leaving Opportunity  ", "going to scenario manager");
	}
}
