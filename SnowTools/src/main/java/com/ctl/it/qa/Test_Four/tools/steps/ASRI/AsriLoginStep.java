//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriLoginPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//
//@SuppressWarnings("serial")
//public class AsriLoginStep extends AsriStep {
//	AsriLoginPage asriLoginPage;
//	String url = envData.getContainer("AsriLoginPage").getFieldValue("url");
//	IntDataContainer dataCon = envData.getContainer("AsriLoginPage");
//	private final Logger logger = LoggerFactory.getLogger(AsriLoginStep.class);
//
//	@Step
//	public void asriLogin() {
//		logger.info("******** Login function is Started ****************");
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		getDriver().get("chrome://settings/clearBrowserData");
//		asriLoginPage.openAt(url);
//		getDriver().get("chrome://settings/clearBrowserData");
//		getDriver().manage().deleteAllCookies();
//		asriLoginPage.openAt(url);
//		logger.info("Url is entered");
//		getDriver().manage().window().maximize();
//		logger.info("window is maximized");
//		shouldExist(asriLoginPage, 90);
//		logger.info("asriLoginPage is exists");
//		asriLoginPage.tbx_username.sendKeys(dataCon.getFieldValue("tbx_username"));
//		System.out.println("User name is entered");
//		asriLoginPage.tbx_password.sendKeys(dataCon.getFieldValue("tbx_password"));
//		System.out.println("password is entered");
//		asriLoginPage.btn_login.click();
//		logger.info("clicked on login button");
//		logger.info("login done");
//		logger.info("********** Login function is completed ****************");
//	}
//}