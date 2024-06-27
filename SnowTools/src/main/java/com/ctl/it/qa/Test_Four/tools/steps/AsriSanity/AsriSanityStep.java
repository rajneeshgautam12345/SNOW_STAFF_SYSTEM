//package com.ctl.it.qa.Test_Four.tools.steps.AsriSanity;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriverService;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriLoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriProjectListPage;
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//
//@SuppressWarnings("serial")
//public class AsriSanityStep extends BaseStep {
//	AsriLoginPage asriLoginPage;
//	AsriHomePage asriHomePage;
//	AsriProjectListPage asriProjectListPage;
//	IntDataContainer Container1 = envData.getContainer("AsriLoginPage");
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_ASRI_with_credentials_in_specified_environment(String userType,
//			String ENV) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		if (ENV.contains("1")) {
//			asriLoginPage.openAt(Container1.getFieldValue("ITV1"));
//		}
//		if (ENV.contains("2")) {
//			asriLoginPage.openAt(Container1.getFieldValue("ITV2"));
//		}
//		if (ENV.contains("4")) {
//			asriLoginPage.openAt(Container1.getFieldValue("ITV4"));
//		}
//		if (ENV.contains("prod")) {
//			asriLoginPage.openAt(Container1.getFieldValue("prod"));
//		}
//		getDriver().manage().window().maximize();
//		shouldExist(asriLoginPage, 10);
//		System.out.println("Logging In");
//		/*
//		 * asriLoginPage.tbx_username.sendKeys(Container1.getFieldValue("tbx_username"))
//		 * ;
//		 * asriLoginPage.tbx_password.sendKeys(Container1.getFieldValue("tbx_password"))
//		 * ;
//		 */
//		IntDataContainer dataContainer = envData.getContainer(asriLoginPage.getClass().getSimpleName())
//				.getContainer(userType);
//		fillFields(asriLoginPage, dataContainer.getMandatoryFieldsFromAllContainers());
//		asriLoginPage.btn_login.click();
//		System.out.println("login Done");
//		System.out.println("********** Login function is completed ****************");
//	}
//
//	@Step
//	public void i_search_order_package_ID_on_project_list_page(String Order_ID) {
//		System.out.println("On Home Page");
//		customClickableWait(asriHomePage.lnk_project);
//		asriHomePage.lnk_project.click();
//		System.out.println("Project Icon is Clicked");
//		waitABit(20000);
//		getDriver().switchTo().frame(asriProjectListPage.frame_2frame);
//		customClickableWait(asriProjectListPage.ddl_ExtOrderID);
//		asriProjectListPage.ddl_ExtOrderID.click();
//		System.out.println("Clicked on External ID");
//		asriProjectListPage.tbx_ExtorderID.sendKeys(Order_ID + Keys.ENTER);
//		System.out.println("Package ID Entred");
//		waitABit(5000);
//	}
//
//	@Step
//	public void the_product_package_should_be_available() {
//		try {
//			WebElement Business_Order = getDriver()
//					.findElement(By.xpath("//div[@class='project-name' and contains(@title,'Business Order')]"));
//			if (Business_Order.isDisplayed() == true) {
//				System.out.println("Business Order Available");
//			}
//		} catch (NoSuchElementException e) {
//			System.out.println("Business Order not Available");
//		}
//		Assert.assertNotEquals(" Validate ASRI SANITY", true,
//				asriProjectListPage.lbl_project_number.containsOnlyText("0"));
//		waitABit(2000);
//		getDriver().close();
//	}
//}
