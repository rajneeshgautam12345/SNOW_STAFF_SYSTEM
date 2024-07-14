package com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.WaveLengthSteps;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class SecenarioDataSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(SecenarioDataSteps.class);
	// private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	E2ESteps e2e;

	@Step
	public void set_Quote_To_Argeement() {
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		logger.info("in user_adds_secenario_data");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		getDriver().switchTo().parentFrame();
		logger.info("above back link click");
		senarioDataPage.lnk_back.withTimeoutOf(100, TimeUnit.SECONDS).waitUntilEnabled();
		senarioDataPage.lnk_back.withTimeoutOf(100, TimeUnit.SECONDS).click();
		logger.info("after back link click");
		waitABit(10000);
		try {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		    getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			logger.info("in Try for clicking on the field to open the pencil icon");
			WebElement element1 = null;
			if (myEnv.toUpperCase().equals("TEST1")) {
				element1 = getDriver().findElement(By.xpath("(//span[contains(@class,'static slds-grow ')])[10]")); // cust																							
																													// sign																						
																													// icon
			} else if (myEnv.toUpperCase().equals("TEST2")) {
				element1 = getDriver().findElement(By.xpath("//button[@title='Edit Customer Signature Date']/span[1]"));// cust																									
																													// sign																				
																													// icon
			} else if (myEnv.toUpperCase().equals("TEST3")) {
				element1 = getDriver().findElement(By.xpath("(//span[contains(@class,'static slds-grow ')])[10]")); // cust
																													// sign
																													// icon
			}
			if (myEnv.toUpperCase().equals("TEST4")) {
				element1 = getDriver().findElement(By.xpath("//button[@title='Edit Customer Signature Date']/span[1]"));// cust
																													// sign
																													// icon
			} else {
				// default:
				System.out.println("no Environment found");
			}
			
			WebElement ContractTypeMouseOver = getDriver().findElement(By.xpath("//button[@title='Edit Contract Type']/span[1]"));			
			logger.info("found the contractType pencil icon");
			Actions act = new Actions(getDriver());
			act.moveToElement(ContractTypeMouseOver).build().perform();
			//JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
			waitABit(1000);
			executor.executeScript("arguments[0].click()", ContractTypeMouseOver);
			waitABit(4000);	
			WebElement element5 = getDriver()
					.findElement(By.xpath("(//div[contains(@data-target-selection-name,'Contract_Type')]//div[1]/div[1]/button/span)[1]")); // contract list box
			//JavascriptExecutor jse5 = (JavascriptExecutor) getDriver();
			executor.executeScript("arguments[0].click()", element5);
			logger.info("opened the contract list box ");
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			logger.info("opened the contract list box ");
			waitABit(2000);
			WebElement element6 = getDriver()
					.findElement(By.xpath("(//*[@field-label='Teaming/CIE/SPA Requests']//button)[2]")); // pick none in cpe
																										// requst
			executor.executeScript("arguments[0].click()", element6); // button
			logger.info("cicked on the save button for the cust signed info");
			waitABit(2000);			
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			
		} catch (Exception e) {
			System.out.println("in catch for clicking on the field to open the pencil icon");
		}
		waitABit(3000);
		logger.info("above the customer sign date");
		senarioDataPage.txt_cust_signdate.type(newDate);
		logger.info("add new date: " + newDate);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
	//	JavascriptExecutor jse3 = (JavascriptExecutor) getDriver();
		WebElement element3 = getDriver().findElement(By.xpath("//span[text()='Fully Executed Contract Attached']/../..//input[@type='checkbox']")); // cust check box
																									// date
		executor.executeScript("arguments[0].click()", element3);
		logger.info("set the first checkbox");
		WebElement element4 = getDriver().findElement(By.xpath("//span[text()='I commit to Sales Results per Guidelines']/../..//input[@type='checkbox']")); // cust sign check
	//	JavascriptExecutor jse4 = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click()", element4);
		logger.info("set the second checkbox");
	//	JavascriptExecutor jse5 = (JavascriptExecutor) getDriver();		
		WebElement element7 = getDriver().findElement(By.xpath("(//button[@name='SaveEdit'])[1]")); // save
		executor.executeScript("arguments[0].click()", element7);
		logger.info("Successfully Saved the Sales Close Acknowledgements");
		waitABit(15000);
		
		if(WaveLengthSteps.preDeploy_Status.equals("ON"))
		{
			executor.executeScript("arguments[0].click();", senarioDataPage.lnk_agreement); // click on agreement link.
			waitABit(2000);
			executor.executeScript("arguments[0].click();", senarioDataPage.lnk_agreement); // click on agreement link.
			waitABit(2000);
			logger.info("clicked on the proposed link to turn scenario to order");
			executor.executeScript("arguments[0].click();", senarioDataPage.btn_mark_asCurrentStage);
			waitABit(3000);
			logger.info("clicked on the current proposed link make it order");
			
			senarioDataPage.waitForTextToAppear("Stage changed successfully", 90000);
			logger.info("Stage successfully changed to Proposed");
		}
		else
		{
		
		executor.executeScript("arguments[0].click();", senarioDataPage.lnk_agreement); // click on agreement link.
		waitABit(2000);
		executor.executeScript("arguments[0].click();", senarioDataPage.lnk_agreement); // click on agreement link.
		waitABit(2000);
		logger.info("clicked on the agreement link to turn scenario to order");
		executor.executeScript("arguments[0].click();", senarioDataPage.btn_mark_asCurrentStage); // click on mark as
         																							// current stage //
																									// button
		waitABit(3000);
		logger.info("clicked on the current agreement link make it order");
		executor.executeScript("arguments[0].click();", senarioDataPage.ddl_primaryReason); // drop down one lost
		waitABit(2000);
		logger.info("clicked on the dropdown for set primary reason");
		senarioDataPage.waitForTextToAppear("Won", 20000);
		logger.info("waiting on Won in dropdown to appear");
		getDriver().switchTo().activeElement().sendKeys("Won - Price");
		waitABit(1000);
		logger.info("picking a Won reason in dropdown ");
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("sent in the enter key to set won reason ");
		executor.executeScript("arguments[0].click();", senarioDataPage.btn_done); // done button
		logger.info("pressed the Done button for agreement ");
		try {
			waitABit(5000);
			senarioDataPage.waitForTextToAppear("Stage changed successfully", 90000);
			logger.info("Stage successfully changed to Agreement");
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		}
		waitABit(1000);
		E2ESteps.printInGreenColor("Set Quote to Order ", "Order  is  agreement ");
	}


	@Step
	public void set_HotCut() {
		logger.info("in the Hot cut function to set hot cut and sales user ");
		waitABit(1000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		scenarioPage.waitForTextToAppear("Quotes", 95000);
		waitABit(2000);
		scenarioPage.tab_quote.withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible().waitUntilEnabled();
		scenarioPage.tab_quote.withTimeoutOf(Duration.ofSeconds(120)).waitUntilClickable().click();
//		executor.executeScript("arguments[0].scrollIntoView();", scenarioPage.tab_quote);
		waitABit(1000);
//		scenarioPage.tab_quote.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().waitUntilClickable();
//		executor.executeScript("arguments[0].click();", scenarioPage.tab_quote);
		//scenarioPage.tab_quote.click();
		logger.info("clicked on the quote tab to prepare to return to quote ");
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB); //
		waitABit(2000);
		getDriver().switchTo().frame(0); // Quote Name
		String cpqStatus = getDriver().findElement(By.xpath("//div[@class='slick-cell l6 r6']")).getText();
		if (cpqStatus.equals("Pending")) {
			logger.info("CPQ status is in pending status");
			waitABit(2000);
			executor.executeScript("arguments[0].click();",
					getDriver().findElement(By.xpath("//div[@class='slick-cell l4 r4']/a")));
			waitABit(5000);
//			getDriver().switchTo().frame("quote-iframe");
//			logger.info("Successfully switched to quote- iframe");
			e2e.singleLocationNextandDiscount();
			set_Quote_To_Argeement();
			set_HotCut();
		}
		executor.executeScript("arguments[0].click();", senarioDataPage.lnk_quote_name);// click on SIDID link
		logger.info("clicked on the link for the quote name ");
		waitABit(5000);
		try {
			String url=senarioDataPage.getDriver().getCurrentUrl();
			if(url.contains("lightning"))
			{
				System.out.println("User was in Lightening ");
			}else
			{
			//if (senarioDataPage.lnk_switch_to_lightening.isCurrentlyVisible()) // see if lightening link exist
			senarioDataPage.lnk_switch_to_lightening.click(); // click on lightening link to get out of classic
			waitABit(4000);
			}
		} catch (Exception e) {
			System.out.println("User was not in Lightening ");
		}
		getDriver().switchTo().defaultContent();	
		senarioDataPage.waitForTextToAppear("Hot Cut/Replacement?", 90000);		
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		
		String ccmValue = "hhh";
		//String ccmValue = getDriver().findElement(By.xpath("(//force-lookup/div/records-hoverable-link/div/a)[2]")).getText();
		
		//String ccmValue = getDriver().findElement(By.xpath("(//span[text()='CCM'])[1]/../../../..//force-lookup//a//span")).getText();
		System.out.println("CCM Value-" + ccmValue);
		boolean ccmresult = true;
		if (ccmValue.equals("")) {
			ccmresult = false;
		}
		waitABit(1000);
		executor.executeScript("arguments[0].click();", senarioDataPage.icon_hotcut); // click on the edit icon for hot
																						// cut
		logger.info("clicked on the edit icon for hot cut to open drop down ");
		//getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		try {
			executor.executeScript("arguments[0].click();", senarioDataPage.ddl_hotcut); // open hot cut drop down
			logger.info("clicked on the click on the hot cut drop down to open it ");
			senarioDataPage.waitForTextToAppear("Yes", 20000);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("No");
			waitABit(2000);
			System.out.println("set hot cut drop down to NO ");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			waitABit(3000);
		} catch (Exception e) {
			System.out.println("User was in hot cut but it failed to oppen  ");
		}
		
		executor.executeScript("arguments[0].click();", senarioDataPage.ddl_sale_engineer);
		
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(2000);
		// senarioDataPage.ddl_sale_engineer.sendKeys("Eric Steele");
		getDriver().switchTo().activeElement().sendKeys("Eric Steele");
		waitABit(4000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("set sale engineer to Eric Steele");
		waitABit(2000);
		if (ccmresult == false) {
			getDriver().findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("Praveenya Dontula");
			waitABit(4000);
			getDriver().switchTo().activeElement().sendKeys(" ");
			waitABit(5000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			waitABit(4000);
		}
		
		executor.executeScript("arguments[0].click();", senarioDataPage.ottService); // done button
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		
		executor.executeScript("arguments[0].click();", senarioDataPage.btn_hotcut_save); // done button
		logger.info("Saved button clicked");
		waitABit(15000);
		logger.info("Successfully Saved hot cut details");	
		E2ESteps.printInGreenColor("Set Hot Cut and Contact ", "Out of hot cut");
	}

	@Step
	public void add_Contacts(String contact,String scenario) {
		System.out.println("in function to set the contacts ");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", senarioDataPage.lnk_go_to_Contacts); // go to contracts
		logger.info("Successfully clicked on the contact link");
		waitABit(4000);
		senarioDataPage.waitForTextToAppear("Order Contact Roles", 60000);
		// *********adding contacts **********
		System.out.println("pressed button for adding  contacts for existing contacts  ");
		senarioDataPage.btn_add_existing_Contactsnew.isCurrentlyEnabled();
		waitABit(2000);
		executor.executeScript("arguments[0].click();", senarioDataPage.btn_add_existing_Contactsnew); // add existing
		logger.info("Successfully clicked on the add existing contacts"); // contacts
		// button
		waitABit(5000);
		WebElement frame0 = getDriver().findElement(By.xpath("//iframe[@title='accessibility title']"));// contacts
																										// button
		getDriver().switchTo().frame(frame0);
		getDriver().findElement(By.xpath("//input[@value='Add']")).click();
		waitABit(2000);
		getDriver().findElement(By.xpath("//input[@value='Add']")).click();
		waitABit(2000);
		senarioDataPage.contactRoleSelection.selectByVisibleText("Local Primary Contact");
		waitABit(1000);
		senarioDataPage.contactRoleSelection5.selectByVisibleText("Local Secondary Contact");
		waitABit(1000);
		
		if(scenario.equals("DIA_Affiliate"))
		{
		getDriver().findElement(By.xpath("//input[@value='Add']")).click();
		waitABit(2000);
		senarioDataPage.contactRoleSelection6.selectByVisibleText("Property Manager");
		waitABit(1000);
		}
		getDriver().findElement(By.xpath("(//div[@class='requiredInput']/input)[1]")).sendKeys(contact);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// order contact
		System.out.println("added first contact  " + contact);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(contact); // send in contact name
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// billing contact
		System.out.println("added second contact  " + contact);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(contact);// send in contact name
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// billing contact
		System.out.println("added third contact  " + contact);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(contact);// send in contact name
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// LCON Primary contact
		System.out.println("added fourth contact  " + contact);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys("Andrew Ranney");// send in LCON sec contact name
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// billing contact
		System.out.println("added fifth contact  " + contact);
		waitABit(1500);
		
		if(scenario.equals("DIA_Affiliate"))
		{
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys("Andrew Ranney");// send in Property Manager contact name
		waitABit(1500);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);// billing contact
		System.out.println("added sixth contact  " + contact);
		waitABit(1500);
		}
		getDriver().findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
		logger.info("Successfully pressed the save contact button");
		waitABit(10000);
		E2ESteps.printInGreenColor("Set Contacts  ", " Out of contact function");
	}

	@Step
	public void add_Attachment(int pdays,String attchemntType) {
		logger.info("in add attachment function");
		try {
			senarioDataPage.lbl_oppty_quote.waitUntilEnabled();
			senarioDataPage.lbl_oppty_quote.click();
		} catch (Exception e) {
			System.out.println("trying to clicked on quote button again");
		}
		logger.info("clicked on quote label to tab to add attachments button");
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // hit the generate document button
		logger.info("clicked the generate document button");
		// Change Frame to add Document Details
		getDriver().switchTo().parentFrame();
		logger.info("Switched to parent frame");
		
//		senarioDataPage.waitForTextToAppear("Add Global Attachment", 80000);
//		senarioDataPage.getDriver().findElement(By.xpath("//button[text()='Add Global Attachment']")).click();
		
		waitABit(10000);
		getDriver().switchTo().frame(0);
		logger.info("Switched to Attachement frame");
		senarioDataPage.waitForTextToAppear("Global Attachment", 20000);
		senarioDataPage.waitForTextToAppear("Attachment Information", 20000);
		// Type in Document Name
		senarioDataPage.txt_attachment_name.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent().type("321"); //
		logger.info("Entered Document Name");
		// Select Document Type
		senarioDataPage.lst_doc_type.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent()
				.selectByValue(attchemntType); //
		logger.info("Entered Document Type");
		// Add Document Date
		waitABit(3000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, pdays);
		String newDate = dateFormat.format(cal.getTime());
		senarioDataPage.txt_sm_attachmentdate.withTimeoutOf(30, TimeUnit.SECONDS).type(newDate); // Attachment Date
		// Select Add Attachment Button
		logger.info("Entered attachment date");
		senarioDataPage.lst_sm_attachmenttype.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent()
				.selectByValue("Service Order Form"); // Attachment Type
		senarioDataPage.btn_sm_addattachment2.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent().click(); // Add
		logger.info("Clicked on Add Attachement button"); // Attachment
		// Button
		waitABit(5000);
		String userDir = System.getProperty("user.dir");
		logger.info("above defaultContent frame");
		try {
			for (int i = 0; i < 2; i++) {
				getDriver().switchTo().defaultContent(); // Change to the Attachment Frame
				logger.info("Switched to to parent window");
			}
		} catch (Exception e) {
			System.out.println("failed to switch to default frame ");
		}
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
		try {
			for (int i = 0; i < 2; i++) {
				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.xpath("//*[starts-with(@name,'vfFrameId_17')]")));
				logger.info("Waiting to switch to attachement frame");
				i=2;
			}
		} 
		catch (Exception e) {
			logger.info("failed to switch to vfFrame frame ");
		}
		
		try {
			for (int i = 0; i < 2; i++) {
				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.xpath("//*[starts-with(@name,'theIframe')]")));
				logger.info("Waiting to switch to theIframe");
				i=2;
			}
		} 
		catch (Exception e) {
			logger.info("failed to switch to vfFrame frame ");
		}
		
		//getDriver().switchTo().frame("theIframe"); // Change to the Attachment Frame
		logger.info("Switched to theIframe");
		wait.until(ExpectedConditions.elementToBeClickable(senarioDataPage.btn_sm_addfile));
		try {
			senarioDataPage.btn_sm_choosefile.withTimeoutOf(30, TimeUnit.SECONDS)
					.sendKeys(userDir + "\\src\\test\\resources\\testdata\\IPJustificationForm.xlsx");// Attachment to
																										// Add
		} catch (Exception e) {
			senarioDataPage.btn_sm_choosefile.withTimeoutOf(30, TimeUnit.SECONDS)
					.sendKeys(userDir + "\\src\\test\\resources\\testdata\\IPJustificationForm.xlsx");// Attachment to
																										// // Add
		}
		logger.info("sent in the file needed for the attachment");
		// send in the file
		senarioDataPage.btn_sm_addfile.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent().click(); // Add Attachment
		senarioDataPage.waitForTextToAppear("UPLOAD COMPLETE!", 20000); // Wait for Upload
		logger.info("file uploaded complete");
		getDriver().switchTo().parentFrame();
		logger.info("switching to parent frame before going into ban");
		
		senarioDataPage.btn_sm_backtorecord.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent().click(); // Back to
																											// Scenario
																											// // Detail
		logger.info("clicking to back to record button");
		E2ESteps.printInGreenColor("add Document  information ", " Out of add_Attachment");
	}

	@Step
	public void add_Ban() {
		logger.info("in function to add BAN");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String acct;
		acct = "";
		int myCounter = 0;
		String ban_Id = "5-BKYQDWC";
		String SIDID = System.getProperty("SID.ID");
		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
		getDriver().switchTo().defaultContent();
		logger.info("switching to default frame in ban");
		//waitABit(20000);
		waitABit(5000);
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
				logger.info("switching to parent frame");
			}
		} catch (Exception e) {
			System.out.println("failed to switch to parent frame ");
		}
		// senarioDataPage.waitForTextToAppear("Select Billing Account", 50000);
		logger.info("trying to click on the quote button ");
		senarioDataPage.lbl_oppty_quote.click();
		senarioDataPage.waitForTextToAppear("Global Notes", 20000);
		String banStatus_check=senarioDataPage.ban_check.getAttribute("icon-name");
		System.out.println("BAN status-"+banStatus_check);
		if(!banStatus_check.equals("action:approval"))
		{
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // select billing account
		// billing account
		waitABit(5000);
		try {
			logger.info("above defaultContent frame");
			getDriver().switchTo().defaultContent(); // Change to the default Frame
			logger.info("above parent frame");
			getDriver().switchTo().parentFrame();
			logger.info("after parent frame");
			getDriver().switchTo().frame(0);
			logger.info("after frame 0");
		} catch (Exception e) {
			System.out.println(e);
		}
		waitABit(5000);
		String text = getDriver().findElement(By.xpath("(//*[@name='j_id0:accountSearchFields']//td/div)[1]"))
				.getText();
	//	System.out.println("Text present--" + text);
		if (text.equals(
				"Billing Account Search has failed due to too many billing Accounts. Please do search on specific Billing Account.")) {
			senarioDataPage.billingAccountNoSearchText.sendKeys(ban_Id);
			waitABit(1000);
			senarioDataPage.billingAccountSearchButton.click();
			waitABit(3000);
		}
		senarioDataPage.find(By.cssSelector("input[value='Select']")).click(); // select_billing for list of billing
		waitABit(3000);
		while (acct.equals("")) {
			try {
				waitABit(1000);
				executor.executeScript("arguments[0].click();", senarioDataPage.btn_sm_acctupdateall);
			} catch (Exception e) {
				senarioDataPage.btn_sm_acctupdateall.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilEnabled()
						.waitUntilClickable().click(); // Update All Products with Billing Account
			}
			waitABit(5000);
			logger.info("BAN NOT Updated " + myCounter); // write to console
			myCounter++;
			if (myCounter == 45) {
				System.out.println("BAN not found. Counter reached 45!"); // write to console
				getDriver().close();
				getDriver().quit();
			}
			acct = senarioDataPage.ban_Id.getText();		
		}
		logger.info("BAN Updated!!");
		System.out.println(acct);
		
		
		getDriver().switchTo().parentFrame();
		logger.info("after parent frame");
		getDriver().switchTo().frame(0);
		logger.info("after frame 0");
		WebElement element = getDriver().findElement(
				By.cssSelector(".pbHeader table  tbody tr  .pbButton input.btn[value=\"Return to Quote\"]")); // return
																												// // to
																												// //
																												// quote
																												// //																											// button
		executor.executeScript("arguments[0].click();", element);
		}
		
		E2ESteps.printInGreenColor(" add BAN  information ", " Out of add_Ban" + "Ban id is " + acct);
	}

	@Step
	public void submit_the_Order() {
		logger.info("in function to submit the order");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		waitABit(15000);
		logger.info("returning to quote");
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
				logger.info("Switched to parent frame");
			}
		} catch (Exception e) {
			System.out.println("failed to switch to parent frame ");
		}
		getDriver().switchTo().defaultContent();

		senarioDataPage.waitForTextToAppear("Additional Fields", 10000);
		getDriver().findElement(By.xpath("//span[text()='Show more actions']/..")).click();
		waitABit(2000);
		List<WebElement> allOptions = getDriver()
				.findElements(By.xpath("//div[@role='menu']/slot/runtime_platform_actions-action-renderer"));
		int allSizeOptions = allOptions.size();
		logger.info("Sizeee--" + allSizeOptions);	
		//String text=allOptions.get(i).getAttribute("title");
		if (allSizeOptions>2)
		{
			// open to submit to swift- jenkins can't find this
			getDriver().findElement(By.xpath("//*[@title='Submit to Order']")).click();
		} 
		
		else {	
		getDriver().findElement(By.xpath("//button[text()='Submit to Order']")).click();
		}
		// senarioDataPage.btn_open_to_submit.click();// click on the drop down arrow to
		// open to submit to swift- jenkins can't find this
		//logger.info("clicked on submit to swift dropdown icon to open");

		logger.info("pressed the submit to order button ");
		waitABit(20000);
		try {
			senarioDataPage.waitForTextToAppear("Business Order ID", 20000); // submitted to swift successfully
			logger.info("quote sucessfully sent and is in DOP ");
		} catch (Exception e) {
			System.out.println("quote Not sucessfully to swift ");
		}
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
			}
		} catch (Exception e) {
			logger.info("failed to switch to parent frame ");
		}
		waitABit(15000); // adding wait for Jenkins
		try {
			String tempSwiftOrderID = senarioDataPage.find(By.xpath("//span[text()='Business Order ID']/../../../dd/div/span"))
					.getTextValue(); // this sections gets the order id
			logger.info("BOID value-"+tempSwiftOrderID);
//			String tempSwiftOrderID = senarioDataPage.find(By.xpath("(//span[contains(@class,'uiOutputText')])[2]"))
//					.getTextValue(); // this sections gets the order id
			if (tempSwiftOrderID.contains("Move Request Details")) {
				tempSwiftOrderID = senarioDataPage.find(By.xpath("//span[text()='Business Order ID']/../../../dd/div/span"))
						.getTextValue(); // this sections gets the order id
			}
			if (tempSwiftOrderID.contains("")) {
				tempSwiftOrderID = senarioDataPage.find(By.xpath("//span[text()='Business Order ID']/../../../dd/div/span"))
						.getTextValue(); // this sections gets the order id
			}
			System.setProperty("Swift.ID", tempSwiftOrderID); // set the swift id in memory
		} catch (Exception e) {
			System.out.println("failed to get BOID ");
		}
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id out of memory
		if (nSwiftID.isEmpty()) {
			System.out.println("failed BOID is empty ending test ");
		}
		E2ESteps.softAssertError("Submit to swift", true, "the BOID ", String.valueOf(nSwiftID));
		logger.info("Business Order ID  is  " + nSwiftID); // write the swift id to console
	
	}

	@Step
	public void user_adds_secenario_data(String contact, int pdays) {
	}

	@Step
	public void user_adds_secenario_data_not_submitting_order(String contact, int pdays, String tasknum)
			throws MessagingException {
	}

	public void addGlobalNotes() {
		String smPage = getDriver().getCurrentUrl();
		WebElement GNotesEle = getDriver().findElement(By.xpath("//*[@title='Go to Global Notes']"));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", GNotesEle);
		executor.executeScript("arguments[0].click();", GNotesEle);
		waitABit(2000);
		getDriver().findElement(By.xpath("//button[text()='New' and @name='New']")).click();
		getDriver()
				.findElement(By.xpath(
						"//*[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']"))
				.click();
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		getDriver().findElement(By.xpath("//*[@class=\"slds-textarea\"]")).sendKeys("testing");
		waitABit(2000);
		getDriver().findElement(By.xpath("//*[@name=\"SaveEdit\"]")).click();
		waitABit(5000);
		getDriver().navigate().to(smPage);
		waitABit(6000);
	}

	@Step
	public void adding_Ban() {
		logger.info("in function to add BAN");
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String acct;
		acct = "";
		int myCounter = 0;
		String ban_Id = "5-BKYQDWC";
		String SIDID = System.getProperty("SID.ID");
		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
		getDriver().switchTo().defaultContent();
		logger.info("switching to default frame in ban");
		//waitABit(20000);
		waitABit(5000);
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
				logger.info("switching to parent frame");
			}
		} catch (Exception e) {
			System.out.println("failed to switch to parent frame ");
		}
		// senarioDataPage.waitForTextToAppear("Select Billing Account", 50000);
		logger.info("trying to click on the quote button ");
		senarioDataPage.lbl_oppty_quote.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // select billing account
		// billing account
		waitABit(5000);
		try {
			logger.info("above defaultContent frame");
			getDriver().switchTo().defaultContent(); // Change to the default Frame
			logger.info("above parent frame");
			getDriver().switchTo().parentFrame();
			logger.info("after parent frame");
			getDriver().switchTo().frame(0);
			logger.info("after frame 0");
		} catch (Exception e) {
			System.out.println(e);
		}
		waitABit(5000);
		String text = getDriver().findElement(By.xpath("(//*[@name='j_id0:accountSearchFields']//td/div)[1]"))
				.getText();
		System.out.println("Text present--" + text);
		if (text.equals(
				"Billing Account Search has failed due to too many billing Accounts. Please do search on specific Billing Account.")) {
			senarioDataPage.billingAccountNoSearchText.sendKeys(ban_Id);
			waitABit(1000);
			senarioDataPage.billingAccountSearchButton.click();
			waitABit(3000);
		}
		senarioDataPage.find(By.cssSelector("input[value='Select']")).click(); // select_billing for list of billing
		waitABit(3000);
		try {
			waitABit(1000);
			executor.executeScript("arguments[0].click();", senarioDataPage.btn_sm_acctupdateall);
		} catch (Exception e) {
			senarioDataPage.btn_sm_acctupdateall.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilEnabled()
					.waitUntilClickable().click(); // Update All Products with Billing Account
		}
		waitABit(5000);
		acct = senarioDataPage.ban_Id.getText();
		System.out.println(acct);
		
		
		
		getDriver().switchTo().parentFrame();
		logger.info("after parent frame");
		getDriver().switchTo().frame(0);
		logger.info("after frame 0");
		WebElement element = getDriver().findElement(
				By.cssSelector(".pbHeader table  tbody tr  .pbButton input.btn[value=\"Return to Quote\"]")); // return
																												// // to
																												// //
																												// quote
																												// //																											// button
		executor.executeScript("arguments[0].click();", element);
	
		E2ESteps.printInGreenColor(" add BAN  information ", " Out of add_Ban" + "Ban id is " + acct);
	}
	
	
//	public void submitTechnicalDesignForm()
//	{		
//		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
//		
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		logger.info("in function to submitTechnicalDesignForm");
//		waitABit(10000);
//		
//		logger.info("returning to quote");
//		try {
//			for (int i = 0; i < 3; i++) {
//				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
//				logger.info("Switched to parent frame");
//			}
//		} catch (Exception e) {
//			System.out.println("failed to switch to parent frame ");
//		}
//		getDriver().switchTo().defaultContent();		 
//		waitABit(2000);
//		senarioDataPage.waitForTextToAppear("Additional Fields", 10000);
//		String currentUrl= getDriver().getCurrentUrl();		
//		String sProductType = System.getProperty("myProduct.ID");
//		
//		senarioDataPage.moreElement.click();
//		waitABit(1000);
//		List<WebElement> allOptions = getDriver()
//				.findElements(By.xpath("//div[@role='menu']/slot/runtime_platform_actions-action-renderer"));
//		int allSizeOptions = allOptions.size();
//		logger.info("Sizeee--" + allSizeOptions);
//		for(int i=0;i<=allOptions.size()-1;i++)
//		 {
//			String title=allOptions.get(i).getAttribute("title");
//			if(title.equals("Technical Design Form"))
//			{
//				allOptions.get(i).click();	
//				logger.info("Successfully clicked on Technical Design form");
//			}
//		} 
//			
//		
//	
//		getDriver().switchTo().frame(senarioDataPage.iframe_quote);		
//		getDriver().switchTo().frame(senarioDataPage.iframe_manage_scenario);			
//		senarioDataPage.waitForTextToAppear("DQPK", 80000);
//		logger.info("Found the TDF record");
//		waitABit(1000);		
//		Actions a1=new Actions(getDriver());
//		a1.moveToElement(senarioDataPage.tdf_OptionIcon).click().build().perform();
//		waitABit(1000);
//		senarioDataPage.editMenu.click();
//		waitABit(15000);
//		if(sProductType.equals("Dedicated Internet Access"))
//		{
//		if(myEnv.equals("TEST4"))
//		{
//			executor.executeScript("arguments[0].click();", senarioDataPage.ipTechDetails);
//			waitABit(2000);
//			
//		}		
//		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.ipModeBridged);
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", senarioDataPage.ipModeBridged);		
//		
//		if(myEnv.equals("TEST4"))
//		{
//			waitABit(2000);
//			executor.executeScript("arguments[0].click();", senarioDataPage.accessDetails);
//			waitABit(1000);			
//		}
//
//		}		
//		if(sProductType.equals("Dedicated Internet Access")||sProductType.equals("ExaSwitch"))
//		{
//		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.cablingType);
//		waitABit(1000);		
//		executor.executeScript("arguments[0].click();", senarioDataPage.cablingType);
//		waitABit(3000);		
//		executor.executeScript("arguments[0].click();", senarioDataPage.fiberMode);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("S");
//		waitABit(700);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(1200);
//		executor.executeScript("arguments[0].click();", senarioDataPage.connectorType);
//		waitABit(2000);	
//		if(sProductType.equals("ExaSwitch")) 
//		{
//			executor.executeScript("arguments[0].click();", senarioDataPage.opticType);
//			waitABit(2000);	
//		}
//		else {
//		executor.executeScript("arguments[0].click();", senarioDataPage.existingBuildExtCablingType);
//		waitABit(2000);	
//		executor.executeScript("arguments[0].click();", senarioDataPage.buildExtFiberMode);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("S");
//		waitABit(700);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(800);	
//		executor.executeScript("arguments[0].click();", senarioDataPage.buildExtConnectorType);
//		waitABit(1000);	
//		
//		if(!myEnv.equals("TEST4") && sProductType.equals("Dedicated Internet Access") )
//		{
//		String networkStatus=senarioDataPage.networkStatus.getText();
//		if(networkStatus.equals("Off Net"))	
//		{
//		senarioDataPage.accessOffnetTab.click();
//		waitABit(1500);
//		senarioDataPage.offnetMTU.sendKeys("1500");
//		waitABit(1000);
//		}
//		}
//		}
//		
//		executor.executeScript("arguments[0].click();", senarioDataPage.saveTDFButton);
//        waitABit(10000);             
//        getDriver().switchTo().parentFrame();
//        waitABit(2000);
//        getDriver().switchTo().defaultContent();
//        waitABit(2000);    
//		}
//	    E2ESteps.printInGreenColor(" add TechnicalDesignForm information ", " Out of submitTechnicalDesignForm");
//	}
	
	public void submit_SingleDigitalForm(String serviceLoc,String scenario)
	{
		logger.info("in function to submit_SingleDigitalForm");
		String sProductType = System.getProperty("myProduct.ID");
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
	    String parent=getDriver().getWindowHandle();	    
        String sdfUrl1= envData.getFieldValue("sdfurl");
        String sdfUrl2="#";  
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.open('https://www.google.com/','_blank');");
        for (String windowHandle : getDriver().getWindowHandles()) {
    	    if(!parent.equals(windowHandle)) {
    	       	getDriver().switchTo().window(windowHandle);
    	        break;
    	    }
    	}
        waitABit(1000);
        getDriver().navigate().to(sdfUrl1+System.getProperty("SID.ID")+sdfUrl2);
        waitABit(25000);      
        senarioDataPage.waitForTextToAppear(sProductType,120000);
        waitABit(1000); 
        jse.executeScript("arguments[0].click();", senarioDataPage.packageId);
		waitABit(11000);
		jse.executeScript("arguments[0].click();", senarioDataPage.earlyAcceptance);
		logger.info("Early acceptance selected successfully");
		waitABit(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.floorAndRoom);
		waitABit(1000);
		senarioDataPage.floorAndRoom.click();
		waitABit(6000);
		WebElement floorAndRoomText=getDriver().findElement(By.xpath("//input[@name='designators']"));		
		floorAndRoomText.sendKeys(serviceLoc);
		logger.info("service location added successfully");
		waitABit(2000);
		String networStatus=senarioDataPage.sdfNetworkStatus.getText();
		if(myEnv.equals("TEST4"))
		{
			waitABit(2000);
			senarioDataPage.loa_cfa.click();
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys("N");
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			waitABit(2000);
			logger.info("LOA_CFA selected as No successfully");
		}		
		jse.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.add_edit_LocalContact);
		waitABit(4000);	
		senarioDataPage.add_edit_LocalContact.click();	
		waitABit(2000);
		senarioDataPage.addLocalContactButton.click();				
		waitABit(2000);
		senarioDataPage.fistName.sendKeys("Raj1");
		senarioDataPage.lastName.sendKeys("Gautam1");
		senarioDataPage.email.sendKeys("rajneesh@gmail.com");
		senarioDataPage.phoneNo.sendKeys("2063964600");
		senarioDataPage.mobNO.sendKeys("2063964600");
		senarioDataPage.role.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);				
		waitABit(2000);		
		senarioDataPage.saveContactSDF.click();
		waitABit(6000);
		logger.info("LCON Primary added successfully");
		
		if(networStatus.contains("Off Net") ||scenario.equals("DIA_Affiliate"))
		{
		senarioDataPage.addLocalContactButton.click();
		waitABit(4000);	
		senarioDataPage.fistName.sendKeys("Raj2");
		senarioDataPage.lastName.sendKeys("Gautam2");
		senarioDataPage.email.sendKeys("rajneesh2@gmail.com");
		senarioDataPage.phoneNo.sendKeys("2063964608");
		senarioDataPage.mobNO.sendKeys("2063964608");
		senarioDataPage.role.click();
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		senarioDataPage.saveContactSDF.click();
		waitABit(6000);
		logger.info("LCON secondary added successfully");
		}
		
		senarioDataPage.closeLocalContactWindow.click();
		if(sProductType.equals("ExaSwitch") || sProductType.equals("Wavelength"))
		{			
		jse.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.loa_cfa_z);	
		jse.executeScript("arguments[0].click();", senarioDataPage.loa_cfa_z);	
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys("None");
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
//		senarioDataPage.vendorName.sendKeys("Comcast");	
//		waitABit(2000);
		jse.executeScript("arguments[0].scrollIntoView(true);",senarioDataPage.floorAndRoom2);
		waitABit(1000);
		senarioDataPage.floorAndRoom2.click();
		waitABit(6000);
		WebElement floorAndRoomText2=getDriver().findElement(By.xpath("//input[@name='designators']"));		
		if((scenario.equals("Wavelength_A_Onnet_and_Z_Onnet"))||(scenario.equals("Wavelength_A_Onnet_and_Z_Onnet_3rdParty"))||(scenario.equals("Wavelength_Protected"))||(scenario.equals("Wavelength_Encrypted"))||(scenario.equals("Wavelength_Predoply_On")))
		{
		String floorRoom2="Floor 0 Room 0";
		floorAndRoomText2.sendKeys(floorRoom2);
		waitABit(2000);
		}
		else if (scenario.equals("Wavelength_A_Onnet_and_Z_Offnet"))
		{
			String floorRoom2="Floor 1 Room TELC";
			floorAndRoomText2.sendKeys(floorRoom2);
			waitABit(2000);
		}
		else
		{
			System.out.println("Inside else floor and room ");
			floorAndRoomText2.sendKeys("Floor 1 Room 0");
		}
		
        WebElement addLocalContactZ=getDriver().findElement(By.xpath("(//span[text()='Add /Edit Location Contact'])[2]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", addLocalContactZ);
		waitABit(4000);	
		addLocalContactZ.click();		
		waitABit(2000);
		senarioDataPage.addLocalContactButton.click();
		
		waitABit(2000);
		senarioDataPage.fistName_z.sendKeys("Test");
		senarioDataPage.lastName_z.sendKeys("Test6");
		senarioDataPage.email_z.sendKeys("test6@gmail.com");
		senarioDataPage.phoneNo_z.sendKeys("2063964987");
		senarioDataPage.mobNO_z.sendKeys("2063964987");
		senarioDataPage.role_z.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    	waitABit(2000);
		senarioDataPage.saveContactSDF.click();
		waitABit(6000);
		senarioDataPage.closeLocalContactWindow.click();
		}	
		jse.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.save_ValidateButton);
		waitABit(4000);		
		senarioDataPage.save_ValidateButton.click();	
		
		waitABit(7000);	  
		getDriver().switchTo().window(parent);
//		getDriver().navigate().refresh();
//		waitABit(15000);	 
		waitABit(2000);
		getDriver().switchTo().frame(senarioDataPage.iframe_quote);
		getDriver().switchTo().frame(senarioDataPage.iframe_manage_scenario);		
		Actions a2=new Actions(getDriver());
		a2.moveToElement(senarioDataPage.tdf_OptionIcon).click().build().perform();
		waitABit(1000);
		senarioDataPage.editMenu.click();
		//waitABit(10000);
		waitABit(1000);
		senarioDataPage.waitForTextToAppear("Product Name", 80000);
		waitABit(2000);
		jse.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.publishButton);
		jse.executeScript("arguments[0].click();", senarioDataPage.publishButton);
		//waitABit(10000);
		
		waitABit(4000);
		senarioDataPage.waitForTextToAppear("Technical Design is published successfully!", 80000);
		getDriver().switchTo().parentFrame();
		waitABit(2000);
		senarioDataPage.backButton.click();
		//waitABit(8000);	
		E2ESteps.printInGreenColor(" add single digital form information ", " Out of single digital form");	
	}
	
	
	public void submitTechnicalDesignForm(String scenario)
	{	
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		logger.info("in function to submitTechnicalDesignForm");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		waitABit(10000);
		logger.info("returning to quote");
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Attachment Frame
				logger.info("Switched to parent frame");
			}
		} catch (Exception e) {
			System.out.println("failed to switch to parent frame ");
		}
		getDriver().switchTo().defaultContent();		 
		waitABit(2000);
		senarioDataPage.waitForTextToAppear("Additional Fields", 10000);
		//String currentUrl= getDriver().getCurrentUrl();		
		String sProductType = System.getProperty("myProduct.ID");		
		senarioDataPage.moreElement.click();
		waitABit(2000);
		List<WebElement> allOptions = getDriver()
				.findElements(By.xpath("//div[@role='menu']/slot/runtime_platform_actions-action-renderer"));
		int allSizeOptions = allOptions.size();
		logger.info("Sizeee--" + allSizeOptions);
		for(int i=0;i<=allOptions.size()-1;i++)
		 {
			String title=allOptions.get(i).getAttribute("title");
			if(title.equals("Technical Design Form"))
			{
				allOptions.get(i).click();	
				logger.info("Successfully clicked on Technical Design form");
			}
		} 
				
		getDriver().switchTo().frame(senarioDataPage.iframe_quote);		
		getDriver().switchTo().frame(senarioDataPage.iframe_manage_scenario);			
		senarioDataPage.waitForTextToAppear("DQPK", 80000);
		logger.info("Found the TDF record");
		waitABit(1000);		
		Actions a1=new Actions(getDriver());
		a1.moveToElement(senarioDataPage.tdf_OptionIcon).click().build().perform();
		waitABit(1000);
		senarioDataPage.editMenu.click();
		logger.info("Clicked on edit TDF record");
		waitABit(5000);
		senarioDataPage.waitForTextToAppear("Product Name", 80000);
		logger.info("TDF form is opened");
		waitABit(1000);
	//	waitABit(15000);	
		if(sProductType.equals("Dedicated Internet Access"))
		{
		if(myEnv.equals("TEST4"))
		{
			executor.executeScript("arguments[0].click();", senarioDataPage.ipTechDetails);
			waitABit(2000);
			logger.info("Clicked on IP Technical Details Tab");
			
		}				
		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.ipModeBridged);
		waitABit(1000);
		logger.info("Selected the IP Mode as Bridged");
		//String scenario="";
		if(scenario.equals("DIA_Headless"))
		{
			executor.executeScript("arguments[0].click();", senarioDataPage.ipModeRouted);
			logger.info("Selected the IP Mode as Bridged");
			executor.executeScript("arguments[0].click();", senarioDataPage.LANIPYes);
			logger.info("Selected the LAN IP");
			executor.executeScript("arguments[0].click();", senarioDataPage.routingProtocol);
			getDriver().switchTo().activeElement().sendKeys("BGP");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			logger.info("Selected the routing protocol as BGP");
			waitABit(2000);
			executor.executeScript("arguments[0].click();", senarioDataPage.bgpDetailsTab);
			logger.info("Clicked on BGP Details Tab");
			waitABit(2000);
			senarioDataPage.customer_bgp_asn.sendKeys("10754");
			senarioDataPage.maintener.sendKeys("COSTCO-MAINT");
			senarioDataPage.route_Registry.sendKeys("LUMEN");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			senarioDataPage.route_Registry_Yes.click();
			waitABit(2000);
			senarioDataPage.routeRegistryObect.sendKeys("RS-COSTCO");
			senarioDataPage.lmnAdvertisementToCust.sendKeys("Default Route");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			senarioDataPage.ipv4AdvertisedRoutes.sendKeys("1.1.1.0/29");
			senarioDataPage.bgpAsSource.sendKeys("Lumen Provided");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			senarioDataPage.bgpAdvanced.click();
			
			senarioDataPage.meds.click();
			waitABit(1500);
			senarioDataPage.moveSelectionArrow.click();
			
			senarioDataPage.bfd.click();
			senarioDataPage.bfdTimer.sendKeys("Specials Timer");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			
		}
		else
		{
		executor.executeScript("arguments[0].click();", senarioDataPage.ipModeBridged);		
		logger.info("Selected the IP Mode as Bridged");
		}
		if(myEnv.equals("TEST4"))
		{
			waitABit(2000);
			executor.executeScript("arguments[0].click();", senarioDataPage.accessDetails);
			logger.info("Clicked on Access Details tab");
			waitABit(1000);			
		}

		}		
		if(sProductType.equals("Dedicated Internet Access")||sProductType.equals("ExaSwitch")||sProductType.equals("Wavelength"))
		{
		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.cablingType);
		waitABit(2000);		
		executor.executeScript("arguments[0].click();", senarioDataPage.cablingType);
		logger.info("Clicked on Cabling Type");
		waitABit(3000);		
		executor.executeScript("arguments[0].click();", senarioDataPage.fiberMode);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys("S");
		waitABit(700);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(1200);
		logger.info("Selected Single Mode Fiber");
		executor.executeScript("arguments[0].click();", senarioDataPage.connectorType);
		waitABit(2000);	
		logger.info("Selected connector type as LC");
		if(sProductType.equals("ExaSwitch")) 
		{
			executor.executeScript("arguments[0].click();", senarioDataPage.opticType);
			waitABit(2000);	
			logger.info("Selected Optic type as LR4");
		}
		else {
//		executor.executeScript("arguments[0].click();", senarioDataPage.existingBuildExtCablingType);
//		waitABit(2000);	
//		executor.executeScript("arguments[0].click();", senarioDataPage.buildExtFiberMode);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("S");
//		waitABit(700);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(800);	
//		executor.executeScript("arguments[0].click();", senarioDataPage.buildExtConnectorType);
//		waitABit(1000);	
		
		if(myEnv.equals("TEST4") && sProductType.equals("Dedicated Internet Access") )
		{
		String networkStatus=senarioDataPage.networkStatus.getText();
		if(networkStatus.equals("Off Net"))	
		{
		senarioDataPage.accessOffnetTab.click();
		waitABit(2000);
		logger.info("Clicked on Access Offnet Tab");
		senarioDataPage.offnetMTU.sendKeys("1500");
		waitABit(2000);
		logger.info("MTU value entered ");
		
		if(scenario.equals("DIA_Offnet_Wave"))
		{
			senarioDataPage.colocationSpace.click();
			logger.info("Colocation selected to No");
			waitABit(2000);
		}
		}
		}
		}
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//executor.executeScript("document.body.style.zoom = '70%';");
        waitABit(2000);
		
		if(scenario.contains("MR"))
		{
			executor.executeScript("arguments[0].click();", senarioDataPage.managedRouterDetails);
		    waitABit(1500);
			senarioDataPage.managedRouterDetailsEdit.click();
			waitABit(3000);
			senarioDataPage.lanRoutingProtocol.sendKeys("Static");
			waitABit(1500);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			waitABit(1500);
			senarioDataPage.multipleWANSeries_No.click();
			waitABit(1500);
			senarioDataPage.multiRouterRole.sendKeys("Managed behind CPE");
			waitABit(1500);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			waitABit(1500);
			senarioDataPage.multipleWANSeries_No.click();
			senarioDataPage.multipleLANConnection_No.click();
			waitABit(1500);	
			for(int i=0;i<=15;i++)
			{
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			waitABit(800);	
			String value1=getDriver().switchTo().activeElement().getAttribute("class");
			System.out.println("classValue="+value1);
			String value=getDriver().switchTo().activeElement().getAttribute("title");
			System.out.println("titleValue="+value1);
			if(value.equals("OK") || value1.equals("saveData"))
			{
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				break;
			}
			waitABit(2000);	
			}							
		}	
		}
		executor.executeScript("arguments[0].click();", senarioDataPage.saveTDFButton);
		 //waitABit(10000); 
		senarioDataPage.waitForTextToAppear("New version of Technical Design has been saved successfully!", 90000);
	    logger.info("Technical Design has been saved successfully");
		waitABit(1000);  
        getDriver().switchTo().parentFrame();
        waitABit(3000);
        getDriver().switchTo().defaultContent();
        waitABit(1000);  
        getDriver().navigate().refresh();      
		
	    E2ESteps.printInGreenColor(" add TechnicalDesignForm information ", " Out of submitTechnicalDesignForm");
	}
	
	
	public void addRelatedNumber() {
		waitABit(4000);
		getDriver().switchTo().parentFrame();
		getDriver().switchTo().defaultContent();
		//WebElement relatedNumber = getDriver().findElement(By.xpath("//a[@title='The following Related Numbers are required in order to submit your order:  CAT Approval']"));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		senarioDataPage.waitForTextToAppear("Related Numbers", 90000);
		String smPage = getDriver().getCurrentUrl();
		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.relatedNumberLink);
		executor.executeScript("arguments[0].click();", senarioDataPage.relatedNumberLink);
		logger.info("clicked on Related number link");
		waitABit(2000);
		senarioDataPage.newButton.isCurrentlyEnabled();
		senarioDataPage.newButton.withTimeoutOf(Duration.ofSeconds(40)).waitUntilPresent().click();
		logger.info("clicked on New button");
		senarioDataPage.waitForTextToAppear("RN-ID", 20000);
		waitABit(2000);
		senarioDataPage.comments.withTimeoutOf(Duration.ofSeconds(40)).waitUntilClickable().sendKeys("Testing");
		waitABit(1000);
		logger.info("comments added successfully");
		senarioDataPage.relatedNumber.withTimeoutOf(Duration.ofSeconds(40)).waitUntilClickable().sendKeys("12345");
		
		executor.executeScript("arguments[0].scrollIntoView(true);", senarioDataPage.type);
		executor.executeScript("arguments[0].click();", senarioDataPage.type);
		logger.info("Type added successfully");
		//senarioDataPage.type.waitUntilClickable().click();
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		senarioDataPage.carApprovalStatus.withTimeoutOf(Duration.ofSeconds(40)).waitUntilClickable().sendKeys("Completed");
		waitABit(2000);
		logger.info("CAR approval status added successfully");
		senarioDataPage.save.withTimeoutOf(Duration.ofSeconds(40)).waitUntilClickable().click();
		logger.info("Related number details saved successfully");
		waitABit(5000);
		getDriver().navigate().to(smPage);
		waitABit(6000);
	}
}
