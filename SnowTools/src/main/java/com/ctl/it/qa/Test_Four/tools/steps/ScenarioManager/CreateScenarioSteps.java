package com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class CreateScenarioSteps extends E2ESteps {
	ScenarioPage scenarioPage;
	private final Logger logger = LoggerFactory.getLogger(CreateScenarioSteps.class);

	@Step
	public void user_creates_a_Secenario() {

		WebElement iframe_quote = null;
		WebElement iframe_manage_scenario = null;
		String tempSidID = null;
		String myEnv = (System.getProperty("staf.environment.key")).toUpperCase();
		String sOppName = System.getProperty("myOpp_name.ID"); // get the oppty name from memory
		logger.info("in create a secenario");
		waitABit(2000);
		scenarioPage.waitForTextToAppear("Quotes", 90000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		scenarioPage.tab_quote.withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible().waitUntilEnabled();
		scenarioPage.tab_quote.withTimeoutOf(Duration.ofSeconds(90)).waitUntilClickable().click();
		logger.info("Successfully clicked on Quotes");
		//waitABit(12000);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(25));
		//WebElement quoteFrame= getDriver().findElement(By.xpath("(//iframe[contains(@name,'vfFrame')])[1]"));
	   // //(//iframe[contains(@name,'vfFrame')])[6]
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe[contains(@name,'vfFrame')])[1]")));
		logger.info("Switched to New Scenario manager frame");
		//getDriver().switchTo().frame(quoteFrame);
		scenarioPage.waitForTextToAppear("Quoting System", 90000);
		//scenarioPage.waitForTextToAppear("OpportunityQuotes", 90000);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		scenarioPage.btn_newquote.withTimeoutOf(Duration.ofSeconds(120)).waitUntilClickable().click(); // create scenario
																										// // manager
																										// button
		logger.info("Successfully clicked on New Scenario Manager Quote button");
		waitABit(16000);
//		if(myEnv.equals("TEST4"))
//		{
//		logger.info("Url Refreshed");
//		getDriver().navigate().refresh();
//		waitABit(15000);
//		}
		scenarioPage.waitForAbsenceOf("Create a New Quote");
		try {
			iframe_quote = getDriver().findElement(By.xpath("//iframe[@title='accessibility title']"));
		} catch (Exception e) {
			iframe_quote = getDriver().findElement(By.xpath("//iframe[@title='Salesforce - Performance Edition']"));
			System.out.println(" frame is the saleforce performance edition");
		}
		getDriver().switchTo().frame(iframe_quote);
		logger.info("Switched to scenario manager frame");
		iframe_manage_scenario = getDriver().findElement(By.xpath("//iframe[@id='quote-iframe'][@name='theIframe']"));
		getDriver().switchTo().frame(iframe_manage_scenario);
		logger.info("Switched to inner scenario manager frame");
		try {
			logger.info("Validating quote Name text is clickable");
			scenarioPage.txt_quotename.withTimeoutOf(Duration.ofSeconds(60)).waitUntilClickable();
		} catch (TimeoutException e) {
			System.out.println("Refreshed the page");
			getDriver().navigate().refresh();
			waitABit(15000);
			try {
				iframe_quote = getDriver().findElement(By.xpath("//iframe[@title='accessibility title']"));
			} catch (Exception e1) {
				iframe_quote = getDriver().findElement(By.xpath("//iframe[@title='Salesforce - Performance Edition']"));
				System.out.println(" frame is the saleforec performance edition");
			}
			waitABit(2000);
			getDriver().switchTo().frame(iframe_quote);
			logger.info("Successfully switched to Quote parent frame");
			iframe_manage_scenario = getDriver()
					.findElement(By.xpath("//iframe[@id='quote-iframe'][@name='theIframe']"));
			getDriver().switchTo().frame(iframe_manage_scenario);
			logger.info("Successfully switched to scenario manager frame");
		}
		scenarioPage.txt_quotename.withTimeoutOf(Duration.ofSeconds(60)).waitUntilClickable();
		scenarioPage.txt_quotename.click();
		scenarioPage.txt_quotename.type(sOppName); // Quote Name
		logger.info("Quote Name is entered");
		// scenarioPage.ddl_currencyArrow.click();// drop down arrow for currency
		// scenarioPage.waitForTextToAppear("Argentinean Pesos - ARS", 20000); // Wait
		// for Upload;
		// getDriver().switchTo().activeElement().sendKeys("US Dollars - USD",
		// Keys.ENTER); // currency pick
		// getDriver().switchTo().activeElement().sendKeys(Keys.SHIFT, Keys.TAB,
		// Keys.ENTER);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		scenarioPage.txt_description.type("Automation testing");// type in text bo
		logger.info("Quote description is entered");
		waitABit(3000);
//		for(int i=0;i<=2;i++)
//		{
//		if(!scenarioPage.currencyValue.getText().equals("US Dollars - USD"))
//		{
//			waitABit(3000);
//			logger.info("Currency value not populated");			
//		}
//		else
//		{
//			logger.info("Currency value Populated");
//			break;
//		}
//		}
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("Quote is saved successfully");
		waitABit(5000);
		scenarioPage.waitForTextToAppear("Product Summary", 300000);
		logger.info("Navigated to Product Summary Page");
		if (myEnv.equals("TEST4")) {
			// case "TEST4":
			tempSidID = scenarioPage.find(By.cssSelector("div:nth-child(2) > div.text")).getTextValue(); // this ia for
																											// // SM
			// break;
		}
		// case "TEST2":
		else if (myEnv.equals("TEST2")) {
			tempSidID = scenarioPage.find(By.cssSelector("div:nth-child(2) > div.text")).getTextValue(); // this ia for
																											// // SM
			// break;
		}
		// case "TEST1":
		else if (myEnv.equals("TEST1")) {
			tempSidID = scenarioPage.find(By.cssSelector("div:nth-child(2) > div.text")).getTextValue(); // this ia for
																											// // SM
			// break;
		}
		// case "TEST3":
		else if (myEnv.equals("TEST3")) {
			tempSidID = scenarioPage.find(By.cssSelector("div:nth-child(2) > div.text")).getTextValue(); // this ia for
																											// // SM
			// break;
		} else {
			// default:
			System.out.println("no envirnment found");
			// break;
		}
		System.setProperty("SID.ID", tempSidID);
		String SIDID = System.getProperty("SID.ID");
		E2ESteps.softAssertError("Scenario Manager ID", true, "the SM id is ", String.valueOf(tempSidID));
		logger.info("Scenario ID is  " + SIDID); // end of getting order id
		waitABit(1000);
		logger.info("Successfully created the Quotes");
		E2ESteps.printInGreenColor("Leaving Scenario Manager ", "Scenario ID is : " + SIDID);
		scenarioPage.btn_add_new_product.click(); // add new product button
		logger.info("Add New Product button is clicked");
	}
}
