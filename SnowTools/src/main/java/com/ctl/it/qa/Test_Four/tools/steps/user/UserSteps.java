package com.ctl.it.qa.Test_Four.tools.steps.user;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ctl.it.qa.Test_Four.tools.pages.common.CenturyLinkEngage;
import com.ctl.it.qa.Test_Four.tools.pages.common.DigitalDialogPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.InvokeMail;
import com.ctl.it.qa.Test_Four.tools.steps.SendMail;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class UserSteps extends E2ESteps {
	// private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	CenturyLinkEngage centurylinkengage;
	DigitalDialogPage digitaldialogpage;
	InvokeMail invokeMail;
	SendMail sendMail;
	private final Logger logger = LoggerFactory.getLogger(UserSteps.class);

	@SuppressWarnings("deprecation")
	@Step
	public void logs_in_as(String userType) {
		System.setProperty("Type.ID", userType);
		String mytypeID = System.getProperty("Type.ID");
		logger.info("userType is  " + mytypeID); // end of getting user type id
		// loginPage.enterCredentials(userType);
		//String myUser = "rajneesh.k.gautam@lumen.com";
		String myUser =envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_username");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		waitABit(5000);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));	
		loginPage.tbx_username.sendKeys(myUser);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		waitABit(2000);
		
		loginPage.tbx_password.sendKeys(myUserPassword);
		// enterEncryptedPassword(loginPage.tbx_password, myUser);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		//waitABit(2000);
		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 120000);
		
		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
		loginPage.btn_NO.click(); // click the no button
		logger.info("Successfully logged in SFA");
	}

	public void is_in_sfa_login_page() {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		ChromeOptions options = new ChromeOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		loginPage.openAt(envData.getFieldValue("url"));
		getDriver().manage().window().maximize();
		waitABit(1000);
		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
		loginPage.btn_SSO.click(); // click on the single sign in button
		logger.info("Successfully launched the SFA url");
//		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//		jse.executeScript("window.open('about:blank','_blank');"); 
		
		
	}

	@Step
	public void should_be_on_home_page() {
		homePage.shouldExist(homePage);
	}

	@Step
	public void should_be_on_login_page() {
		loginPage.shouldExist(loginPage);
	}

	@Step
	public void user_can_work_order_in_provisioning() throws MessagingException {
		System.out.println("user_can_work_order_in_provisioning");
		String currentURL = getDriver().getCurrentUrl(); // get the current url of
		System.out.println("currentURL is " + currentURL); // // get the current url
		String myEnv = System.getProperty("staf.environment.key");
		logger.info("the Env is : " + myEnv);
//		waitABit(10000);		
//		String to[] = { "Rajneesh.k.gautam@lumen.com", "ericw.steele@centurylink.com", "swarna.mishra@level3.com" };
//		 SendMail.send("staf.sanity@centurylink.com", to, "Digital Dialog - " +
//				 " - "+ currentURL +" - "+" - "+ myEnv, "");
		// tasknum + nSwiftID +" - "+ currentURL +" - "+" - "+ myEnv, "");
	}
}
