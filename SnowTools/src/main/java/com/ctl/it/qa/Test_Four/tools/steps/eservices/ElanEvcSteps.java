//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriLoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriProjectListPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriVerifyDesignPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ExistingOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.GCAPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ISMPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.LoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.MetaStormPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.NewOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.OpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg2Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg3Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkgPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.QuotePage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.SwiftPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class ElanEvcSteps extends BaseStep {
//	LoginPage loginpage;
//	OpportunityPage opportunitypage;
//	NewOpportunityPage newopportunitypage;
//	ProductPage productpage;
//	ProductPkgPage productpkgpage;
//	ProductPkg2Page productpkg2page;
//	ProductPkg3Page productpkg3page;
//	ExistingOpportunityPage existingopportunitypage;
//	QuotePage quotepage;
//	SwiftPage swiftpage;
//	MetaStormPage metastormpage;
//	GCAPage gcapage;
//	ISMPage ismpage;
//	AsriLoginPage asriLoginPage;
//	AsriHomePage asriHomePage;
//	AsriProjectListPage asriProjectListPage;
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	AsriVerifyDesignPage asriVerifyDesignPage;
//	IntDataContainer Container1 = envData.getContainer("TEST2");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String opportunityid = null;
//	String businessorderid = null;
//	String Address_1 = null;
//	String message = null;
//	String sess = null;
//
//	@Step
//	public void i_create_a_scenario_for_the_product_ElanEvc_for_the_A_end_location_B_end_location_and_C_end_location(
//			String a_end_point, String b_end_point, String c_end_point) {
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		System.out.println("Creating New Product Package");
//		waitABit(1000);
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(a_end_point);
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkgpage);
//		String first_address = getDriver().findElement(By.xpath("//a[@class='grid-link']")).getText();
//		System.out.println("First Address : " + first_address);
//		productpkgpage.cbx_box.waitUntilClickable().click();
//		waitABit(1000);
//		customClickableWait(productpkgpage.btn_next);
//		productpkgpage.btn_next.click();
//		System.out.println("A end Address Selected");
//		customwaitforpageloading(productpkg3page);
//		getDriver().switchTo().defaultContent();
//		shouldExist(productpkg3page);
//		WebElement frame2 = getDriver().findElement(By.id("quote-iframe"));
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_ElanEvc);
//		productpkg3page.lst_product_ElanEvc.click();
//		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("1st Product Selected : " + firstproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(3000);
//		customClickableWait(productpkg3page.ddl_evc_type);
//		productpkg3page.ddl_evc_type.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
//		String evctype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("EVC Type Selected : " + evctype);
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		productpkg3page.ddl_EVC_Class.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
//		String evcclass = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]")).getText();
//		System.out.println("EVC Class Selected : " + evcclass);
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
//		String unitype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype);
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		WaitForPageToLoad();
//		shouldExist(productpage);
//		System.out.println("******************** Elan EVC Added for A end Location********************");
//		waitABit(10000);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		customwaitforpageloading(productpkg3page);
//		productpkgpage.cbx_box.waitUntilClickable().click();
//		customClickableWait(productpkgpage.btn_next);
//		productpkgpage.btn_next.waitUntilClickable().click();
//		customwaitforpageloading(productpkg3page);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_Elan_Evc_Endpoint);
//		productpkg3page.lst_product_Elan_Evc_Endpoint.click();
//		String secondproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("2nd Product Selected : " + secondproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		waitABit(10000);
//		customwaitforpageloading(productpkg3page);
//		waitABit(5000);
//		String A_Loc_Value = getDriver().findElement(By.xpath("(//span[contains(.,'- Select -')])[3]")).getText();
//		System.out.println("A_Loc_Value : " + A_Loc_Value);
//		if (A_Loc_Value.contains("E-LAN")) {
//			System.out.println("A Location ELAN Already Selected");
//		} else {
//			System.out.println("Selecting ELAN at A Location");
//			customClickableWait(productpkg3page.ddl_a_loc_ELAN);
//			productpkg3page.ddl_a_loc_ELAN.click();
//			waitABit(3000);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			waitABit(3000);
//			/*
//			 * WebDriverWait wait2 = new WebDriverWait(getDriver(), 200);
//			 * wait2.until(ExpectedConditions.textToBe(By.
//			 * xpath("(//div[contains(@data-bind,'text: ScenarioMessage')])[1]"),
//			 * "All possible related packages have been loaded.")); WebElement ELAN_EVC =
//			 * getDriver().findElement(By.xpath("(//input[@name='relELAN_EVC_radio'])[1]"));
//			 * wait2.until(ExpectedConditions.elementToBeClickable(ELAN_EVC));
//			 */
//			customClickableWait(productpkg3page.rbn_elan);
//			productpkg3page.rbn_elan.click();
//			waitABit(2000);
//			customwaitforpageloading(productpkg3page);
//			System.out.println("Required ELAN Package Selected");
//		}
//		waitABit(2000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		String Second_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Second Loc Value : " + Second_Loc_Value);
//		if (!Second_Loc_Value.contains("Create")) {
//			System.out.println("Selecting UNI at Second Location");
//			productpkg3page.ddl_z_loc_elan.click();
//			waitABit(2000);
//			System.out.println("Moved to Second Location Scenario");
//			/*
//			 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//			 * wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.
//			 * xpath("(//div[@data-bind='text: ScenarioMessage'])[2]"),
//			 * "All possible related packages have been loaded."));
//			 */
//			customClickableWait(productpkg3page.rbn_elan_uni);
//			waitABit(2000);
//			productpkg3page.rbn_elan_uni.click();
//			customwaitforpageloading(productpkg3page);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//		} else {
//			System.out.println("UNI Already Selected at Second Location");
//		}
//		customwaitforpageloading(productpkg3page);
//		waitABit(20000);
//		productpkg3page.ddl_bandwidth_10.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		customwaitforpageloading(productpkg3page);
//		String bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("Bandwidth Selected : " + bandwidth);
//		waitABit(2000);
//		WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[16]"));
//		String Building_Text = Building.getText();
//		System.out.println("Building : " + Building_Text);
//		waitABit(1000);
//		if (Building_Text.contains("- Select -")) {
//			System.out.println("Updating Building");
//			waitABit(1000);
//			Building.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building_Text.contains("Extended")) {
//			System.out.println("Updating Building");
//			waitABit(1000);
//			Building.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building_Text.contains("Standard")) {
//			System.out.println("Building Already Updated");
//		}
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		customwaitforpageloading(productpkg3page);
//		System.out
//				.println("******************** First Elan EVC End Point Added for A end Location********************");
//		waitABit(20000);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(b_end_point);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkgpage);
//		waitABit(5000);
//		productpkgpage.cbx_box_3.waitUntilClickable().click();
//		customClickableWait(productpkgpage.btn_next);
//		waitABit(2000);
//		productpkgpage.btn_next.waitUntilClickable().click();
//		customwaitforpageloading(productpkg3page);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		waitABit(5000);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_Elan_Evc_Endpoint);
//		productpkg3page.lst_product_Elan_Evc_Endpoint.click();
//		String thirdproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("3rd Product Selected : " + thirdproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		waitABit(5000);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(5000);
//		/*
//		 * getDriver().switchTo().defaultContent();
//		 * getDriver().switchTo().frame(frame2);
//		 * 
//		 * waitABit(5000);
//		 */
//		// String A_Loc_Value_2 =
//		// getDriver().findElement(By.xpath("(//span[@class='k-input'])[5]")).getText();
//		String A_Loc_Value_2 = getDriver().findElement(By.xpath("(//span[contains(.,'- Select -')])[3]")).getText();
//		if (A_Loc_Value_2.contains("E-LAN")) {
//			System.out.println("A Location ELAN Already Selected");
//		} else {
//			System.out.println("Selecting ELAN at A Location");
//			customClickableWait(productpkg3page.ddl_a_loc_ELAN);
//			productpkg3page.ddl_a_loc_ELAN.click();
//			waitABit(3000);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			waitABit(3000);
//			/*
//			 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//			 * wait3.until(ExpectedConditions.textToBe(By.
//			 * xpath("(//div[contains(@data-bind,'text: ScenarioMessage')])[1]"),
//			 * "All possible related packages have been loaded."));
//			 */
//			customClickableWait(productpkg3page.rbn_elan);
//			productpkg3page.rbn_elan.click();
//			waitABit(2000);
//			customwaitforpageloading(productpkg3page);
//			System.out.println("Required ELAN Package Selected");
//		}
//		waitABit(2000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		String Second_Loc_Value_2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Second Loc Value : " + Second_Loc_Value_2);
//		if (!Second_Loc_Value.contains("Create")) {
//			System.out.println("Selecting UNI at Second Location");
//			productpkg3page.ddl_z_loc_elan.click();
//			waitABit(2000);
//			System.out.println("Moved to Second Location Scenario");
//			/*
//			 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//			 * wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.
//			 * xpath("(//div[@data-bind='text: ScenarioMessage'])[2]"),
//			 * "All possible related packages have been loaded."));
//			 */
//			customClickableWait(productpkg3page.rbn_elan_uni);
//			waitABit(2000);
//			productpkg3page.rbn_elan_uni.click();
//			customwaitforpageloading(productpkg3page);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//		} else {
//			System.out.println("UNI Already Selected at Second Location");
//		}
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		productpkg3page.ddl_bandwidth_10.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		customwaitforpageloading(productpkg3page);
//		String bandwidth2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("Bandwidth Selected : " + bandwidth2);
//		waitABit(2000);
//		WebElement Building2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[16]"));
//		String Building2_Text = Building2.getText();
//		System.out.println("Building : " + Building2_Text);
//		waitABit(1000);
//		if (Building2_Text.contains("- Select -")) {
//			System.out.println("Updating Building");
//			waitABit(2000);
//			Building2.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building2_Text.contains("Extended")) {
//			System.out.println("Updating Building");
//			waitABit(1000);
//			Building2.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building2_Text.contains("Standard")) {
//			System.out.println("Building Already Updated");
//		}
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		customwaitforpageloading(productpkg3page);
//		System.out
//				.println("******************** Second Elan EVC End Point Added for B end Location********************");
//		String name = c_end_point;
//		int length = name.length();
//		System.out.println("C_End_Point Length : " + length);
//		if (length > 0) {
//			waitABit(2000);
//			customClickableWait(productpage.btn_new_product_pkg);
//			productpage.btn_new_product_pkg.click();
//			shouldExist(productpkgpage);
//			customClickableWait(productpkgpage.tbx_address);
//			productpkgpage.tbx_address.sendKeys(a_end_point);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(productpkgpage);
//			productpkgpage.cbx_box_3.waitUntilClickable().click();
//			customClickableWait(productpkgpage.btn_next);
//			productpkgpage.btn_next.waitUntilClickable().click();
//			customwaitforpageloading(productpkg3page);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			customClickableWait(productpkg3page.lst_product);
//			productpkg3page.lst_product.click();
//			waitABit(1000);
//			customClickableWait(productpkg3page.lst_product_Elan_Evc_Endpoint);
//			productpkg3page.lst_product_Elan_Evc_Endpoint.click();
//			String fourthproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//			System.out.println("3rd Product Selected : " + fourthproduct);
//			customClickableWait(productpkg3page.btn_new_product);
//			productpkg3page.btn_new_product.click();
//			customwaitforpageloading(productpkg3page);
//			String A_Loc_Value_3 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[5]")).getText();
//			if (A_Loc_Value_3.contains("E-LAN")) {
//				System.out.println("A Location ELAN Already Selected");
//			} else {
//				System.out.println("Selecting ELAN at A Location");
//				customClickableWait(productpkg3page.ddl_a_loc_ELAN);
//				productpkg3page.ddl_a_loc_ELAN.click();
//				waitABit(3000);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//				waitABit(3000);
//				/*
//				 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//				 * wait3.until(ExpectedConditions.textToBe(By.
//				 * xpath("(//div[contains(@data-bind,'text: ScenarioMessage')])[1]"),
//				 * "All possible related packages have been loaded."));
//				 */
//				customClickableWait(productpkg3page.rbn_elan);
//				productpkg3page.rbn_elan.click();
//				waitABit(2000);
//				customwaitforpageloading(productpkg3page);
//				System.out.println("Required ELAN Package Selected");
//			}
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			String Second_Loc_Value_3 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//			System.out.println("Second Loc Value : " + Second_Loc_Value_3);
//			if (!Second_Loc_Value_3.contains("Create")) {
//				System.out.println("Selecting UNI at Second Location");
//				productpkg3page.ddl_z_loc_elan.click();
//				waitABit(2000);
//				System.out.println("Moved to Second Location Scenario");
//				/*
//				 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//				 * wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.
//				 * xpath("(//div[@data-bind='text: ScenarioMessage'])[2]"),
//				 * "All possible related packages have been loaded."));
//				 */
//				customClickableWait(productpkg3page.rbn_elan_uni);
//				waitABit(2000);
//				productpkg3page.rbn_elan_uni.click();
//				customwaitforpageloading(productpkg3page);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//			} else {
//				System.out.println("UNI Already Selected at Second Location");
//			}
//			customwaitforpageloading(productpkg3page);
//			waitABit(1000);
//			productpkg3page.ddl_bandwidth_10.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//			String bandwidth3 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//			System.out.println("Bandwidth Selected : " + bandwidth3);
//			waitABit(2000);
//			WebElement Building3 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[16]"));
//			String Building3_Text = Building3.getText();
//			System.out.println("Building : " + Building3_Text);
//			waitABit(1000);
//			if (Building3_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building3_Text.contains("Extended")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building3_Text.contains("Standard")) {
//				System.out.println("Building Already Updated");
//			}
//			customClickableWait(productpkg3page.btn_quick_save);
//			productpkg3page.btn_quick_save.click();
//			customwaitforpageloading(productpkg3page);
//			System.out.println(
//					"******************** Another Elan EVC End Point Added for C end Location********************");
//		} else {
//			System.out.println("No Further End Points to Add");
//		}
//	}
//
//	@Step
//	public void i_perform_the_profitability_analysis_for_elan() {
//		customwaitforpageloading(productpage);
//		getDriver().switchTo().defaultContent();
//		WebElement frame3 = getDriver().findElement(By.id("quote-iframe"));
//		getDriver().switchTo().frame(frame3);
//		customwaitforpageloading(productpage);
//		customClickableWait(productpage.btn_discount_profitability);
//		productpage.btn_discount_profitability.click();
//		System.out.println("Discounting Profitability Checking");
//		customClickableWait(productpage.btn_save);
//		for (int i = 0; i < 10; i++) {
//			String ProfitPass = getDriver()
//					.findElement(
//							By.xpath("//*[@id=\"ProductTree\"]/div/div[3]/table/tfoot/tr/td[4]/div/div[2]/div[1]/div"))
//					.getText();
//			System.out.println("Profit Pass Status : " + ProfitPass);
//			if (!ProfitPass.contains("Profit Pass")) {
//				System.out.println("Profit Not Passed");
//				productpage.btn_save.click();
//				customwaitforpageloading(productpage);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame("quote-iframe");
//				customClickableWait(productpage.btn_discount_profitability);
//				productpage.btn_discount_profitability.click();
//				System.out.println("Discounting Profitability Checking Again");
//				customClickableWait(productpage.btn_save);
//			} else {
//				System.out.println("Profit Passed; Saving the Status");
//				productpage.btn_save.click();
//				customwaitforpageloading(productpage);
//				break;
//			}
//		}
//	}
//
//	@Step
//	public void the_order_should_be_submitted_to_SwIFT_successfully_for_elan() {
//		shouldExist(quotepage);
//		businessorderid = getDriver().findElement(By.id("00N2A00000DoTFx_ileinner")).getText();
//		System.out.println("SwIFT Business Order ID = " + businessorderid);
//		System.out.println("Order Pushed to Swift");
//		getDriver().close();
//	}
//
//	@Step
//	public void i_search_the_Business_Order_ID_in_Swift_for_elan() {
//		waitABit(3000);
//		swiftpage.tbx_order_id_field.clear();
//		swiftpage.tbx_order_id_field.sendKeys(businessorderid + Keys.ENTER);
//		// swiftpage.tbx_order_id_field.sendKeys("1881929"+Keys.ENTER);
//		// swiftpage.btn_search.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//		try {
//			for (int i = 0; i < 300; i++) {
//				String message = getDriver().findElement(By.xpath("//span[@class='k-pager-info k-label']")).getText();
//				System.out.println("Swift Search Result = " + message);
//				if (!message.contains("3")) {
//					System.out.println("No Records Found, Retrying");
//					waitABit(5000);
//					swiftpage.btn_search.click();
//					customwaitforpageloading(swiftpage);
//				} else {
//					System.out.println("Order Package Available");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Step
//	public void it_should_be_generating_Order_Package_IDs() {
//		for (int i = 0; i < 300; i++) {
//			WebElement OPI1 = getDriver()
//					.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a"));
//			String OPI1_Text = OPI1.getText();
//			WebElement OPI2 = getDriver()
//					.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[2]/td[1]/a"));
//			String OPI2_Text = OPI2.getText();
//			WebElement OPI3 = getDriver()
//					.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[3]/td[1]/a"));
//			String OPI3_Text = OPI3.getText();
//			/*
//			 * if (message.contains("4")) {
//			 * 
//			 * System.out.println("4th Order Package Available"); WebElement OPI4 =
//			 * getDriver().findElement(By.xpath(
//			 * "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[4]/td[1]/a")); String
//			 * OPI4_Text = OPI4.getText();
//			 * 
//			 * @SuppressWarnings("unused") int OPI4_Length = OPI4_Text.length();
//			 * 
//			 * } else { System.out.println("4th Order Package Not Available"); }
//			 */
//			Serenity.setSessionVariable("orderpackageid").to(OPI1_Text);
//			sess = Serenity.sessionVariableCalled("orderpackageid");
//			System.out.println("Order Package Ids = " + OPI1_Text + " , " + OPI2_Text + " , " + OPI3_Text);
//			int OPI1_Length = OPI1_Text.length();
//			int OPI2_Length = OPI2_Text.length();
//			int OPI3_Length = OPI3_Text.length();
//			if (!(OPI1_Length > 0) && !(OPI2_Length > 0) && !(OPI3_Length > 0)) {
//				System.out.println("No Records Found, Retrying");
//				waitABit(5000);
//				swiftpage.btn_search.click();
//				customwaitforpageloading(swiftpage);
//			} else {
//				System.out.println("Order Package IDs Found");
//				break;
//			}
//			waitABit(1000);
//		}
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_for_first_order_and_update_the_Clli_for_A_End(String a_end_clli_elan) {
//		WebElement OPI1 = getDriver()
//				.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a"));
//		String OPI1_text = OPI1.getText();
//		OPI1.click();
//		System.out.println("Order Package ID Selected : " + OPI1_text);
//		WaitForPageToLoad();
//		for (int i = 0; i < 25; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1 - 1 of 1 items")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(3000);
//				getDriver().navigate().refresh();
//				WaitForPageToLoad();
//				customwaitforpageloading(swiftpage);
//			}
//		}
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
//		customClickableWait(swiftpage.btn_edit_dates);
//		waitABit(3000);
//		swiftpage.btn_edit_dates.click();
//		customClickableWait(swiftpage.tbx_negotiated_date);
//		swiftpage.tbx_negotiated_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_negotiated_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(1000);
//		swiftpage.tbx_requested_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_requested_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(2000);
//		swiftpage.btn_save_dates.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("NDD & CRD Updated");
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		customClickableWait(swiftpage.btn_first_sub_product);
//		waitABit(1000);
//		swiftpage.btn_first_sub_product.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_addresses);
//		swiftpage.btn_addresses.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_address_edit_elan_evc);
//		swiftpage.btn_address_edit_elan_evc.click();
//		waitABit(5000);
//		Address_1 = getDriver().findElement(By.xpath("//label[contains(@id,'currentServiceAddressDisplayAddress')]"))
//				.getText();
//		System.out.println("Address 1 : " + Address_1);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 1");
//		swiftpage.aendcllielan(a_end_clli_elan).click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for ELAN EVC");
//	}
//
//	@Step
//	public void third_task_should_be_completed() {
//		System.out.println("3rd Task Completed");
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		String order_pkg_status = getDriver()
//				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
//		System.out.println("Order Package Status = " + order_pkg_status);
//		waitABit(2000);
//		System.out.println("All Tasks Completed in Swift");
//		waitABit(2000);
//		System.out.println("Order Pushed to GCA");
//		waitABit(2000);
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_for_second_order_and_update_the_Clli_for_A_End(String a_end_clli_elan,
//			String b_end_clli_elan) {
//		waitABit(2000);
//		WebElement OPI2 = getDriver()
//				.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[2]/td[1]/a"));
//		String OPI2_text = OPI2.getText();
//		OPI2.click();
//		System.out.println("Order Package ID Selected : " + OPI2_text);
//		WaitForPageToLoad();
//		for (int i = 0; i < 25; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1 - 1 of 1 items")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(3000);
//				getDriver().navigate().refresh();
//				WaitForPageToLoad();
//				customwaitforpageloading(swiftpage);
//			}
//		}
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
//		customClickableWait(swiftpage.btn_edit_dates);
//		waitABit(3000);
//		swiftpage.btn_edit_dates.click();
//		customClickableWait(swiftpage.tbx_negotiated_date);
//		swiftpage.tbx_negotiated_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_negotiated_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(1000);
//		swiftpage.tbx_requested_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_requested_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(2000);
//		swiftpage.btn_save_dates.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("NDD & CRD Updated");
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		customClickableWait(swiftpage.btn_first_sub_product);
//		waitABit(1000);
//		swiftpage.btn_first_sub_product.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_addresses);
//		swiftpage.btn_addresses.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_address_edit_elan_evc);
//		swiftpage.btn_address_edit_elan_evc.click();
//		waitABit(5000);
//		String Address_2 = getDriver()
//				.findElement(By.xpath("//label[contains(@id,'currentServiceAddressDisplayAddress')]")).getText();
//		System.out.println("Address 2 : " + Address_2);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 1");
//		if (Address_2.contains(Address_1)) {
//			swiftpage.aendcllielan(a_end_clli_elan).click();
//		} else {
//			swiftpage.bendcllielan(b_end_clli_elan).click();
//		}
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		customwaitforpageloading(swiftpage);
//		try {
//			if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//				System.out.println("Secondary Save Btn is Available");
//				customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//				swiftpage.btn_end_user_CLLI_update_save.click();
//				waitABit(3000);
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for ELAN EVC UNI1");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_product);
//		swiftpage.btn_second_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product);
//		swiftpage.btn_second_sub_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_address_edit_elan_evc);
//		swiftpage.btn_address_edit_elan_evc.click();
//		waitABit(8000);
//		String Address_3 = getDriver()
//				.findElement(By.xpath("//label[contains(@id,'currentServiceAddressDisplayAddress')]")).getText();
//		System.out.println("Address 3 : " + Address_3);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 2");
//		if (Address_3.contains(Address_1)) {
//			swiftpage.aendcllielan(a_end_clli_elan).click();
//		} else {
//			swiftpage.bendcllielan(b_end_clli_elan).click();
//		}
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		try {
//			if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//				System.out.println("Secondary Save Btn is Available");
//				customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//				swiftpage.btn_end_user_CLLI_update_save.click();
//				waitABit(3000);
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		waitABit(2000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for ELAN EVC UNI1 End Point");
//		waitABit(2000);
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_for_third_order_and_update_the_Clli_for_B_End(String b_end_clli_elan,
//			String a_end_clli_elan) {
//		waitABit(2000);
//		WebElement OPI3 = getDriver()
//				.findElement(By.xpath("//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[3]/td[1]/a"));
//		String OPI3_text = OPI3.getText();
//		OPI3.click();
//		System.out.println("Order Package ID Selected : " + OPI3_text);
//		WaitForPageToLoad();
//		for (int i = 0; i < 25; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1 - 1 of 1 items")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(3000);
//				getDriver().navigate().refresh();
//				WaitForPageToLoad();
//				customwaitforpageloading(swiftpage);
//			}
//		}
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
//		customClickableWait(swiftpage.btn_edit_dates);
//		waitABit(3000);
//		swiftpage.btn_edit_dates.click();
//		customClickableWait(swiftpage.tbx_negotiated_date);
//		swiftpage.tbx_negotiated_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_negotiated_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(1000);
//		swiftpage.tbx_requested_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_requested_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(2000);
//		swiftpage.btn_save_dates.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("NDD & CRD Updated");
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		customClickableWait(swiftpage.btn_first_sub_product);
//		waitABit(1000);
//		swiftpage.btn_first_sub_product.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_addresses);
//		swiftpage.btn_addresses.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_address_edit_elan_evc);
//		swiftpage.btn_address_edit_elan_evc.click();
//		waitABit(5000);
//		String Address_4 = getDriver()
//				.findElement(By.xpath("//label[contains(@id,'currentServiceAddressDisplayAddress')]")).getText();
//		System.out.println("Address 4 : " + Address_4);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli ");
//		if (Address_4.contains(Address_1)) {
//			swiftpage.aendcllielan(a_end_clli_elan).click();
//		} else {
//			swiftpage.bendcllielan(b_end_clli_elan).click();
//		}
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		customwaitforpageloading(swiftpage);
//		try {
//			if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//				System.out.println("Secondary Save Btn is Available");
//				customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//				swiftpage.btn_end_user_CLLI_update_save.click();
//				waitABit(3000);
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for ELAN EVC UNI2");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_product);
//		swiftpage.btn_second_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product);
//		swiftpage.btn_second_sub_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_address_edit_elan_evc);
//		swiftpage.btn_address_edit_elan_evc.click();
//		waitABit(8000);
//		String Address_5 = getDriver()
//				.findElement(By.xpath("//label[contains(@id,'currentServiceAddressDisplayAddress')]")).getText();
//		System.out.println("Address 5 : " + Address_5);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli");
//		if (Address_5.contains(Address_1)) {
//			swiftpage.aendcllielan(a_end_clli_elan).click();
//		} else {
//			swiftpage.bendcllielan(b_end_clli_elan).click();
//		}
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		try {
//			if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//				System.out.println("Secondary Save Btn is Available");
//				customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//				swiftpage.btn_end_user_CLLI_update_save.click();
//				waitABit(3000);
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		waitABit(2000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for ELAN EVC UNI2 End Point");
//		waitABit(2000);
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_for_fourth_order_and_update_the_Clli_for_C_End(String c_end_clli_elan) {
//		String name = c_end_clli_elan;
//		int length = name.length();
//		System.out.println("C_End_Point Length : " + length);
//		if (length > 0) {
//			waitABit(2000);
//			// OPI4.click();
//			WaitForPageToLoad();
//			for (int i = 0; i < 25; i++) {
//				String ispackageavailable = getDriver()
//						.findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
//				if (ispackageavailable.contains("1 - 1 of 1 items")) {
//					System.out.println("Order Package Available");
//					break;
//				} else {
//					System.out.println("Order Package not Available, Retrying");
//					waitABit(3000);
//					getDriver().navigate().refresh();
//					WaitForPageToLoad();
//					customwaitforpageloading(swiftpage);
//				}
//			}
//			System.out.println("Updating NDD & CRD");
//			customClickableWait(swiftpage.btn_product_packages);
//			swiftpage.btn_product_packages.click();
//			waitABit(3000);
//			WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//			JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//			js.executeScript("arguments[0].click();", checkbox);
//			customClickableWait(swiftpage.btn_edit_dates);
//			waitABit(3000);
//			swiftpage.btn_edit_dates.click();
//			customClickableWait(swiftpage.tbx_negotiated_date);
//			swiftpage.tbx_negotiated_date.clear();
//			waitABit(1000);
//			swiftpage.tbx_negotiated_date.sendKeys(ElineEVCSteps.getDate());
//			waitABit(1000);
//			swiftpage.tbx_requested_date.clear();
//			waitABit(1000);
//			swiftpage.tbx_requested_date.sendKeys(ElineEVCSteps.getDate());
//			waitABit(2000);
//			swiftpage.btn_save_dates.click();
//			customwaitforpageloading(swiftpage);
//			System.out.println("NDD & CRD Updated");
//			customClickableWait(swiftpage.btn_first_product);
//			swiftpage.btn_first_product.click();
//			customClickableWait(swiftpage.btn_first_sub_product);
//			waitABit(1000);
//			swiftpage.btn_first_sub_product.click();
//			waitABit(3000);
//			customClickableWait(swiftpage.btn_addresses);
//			swiftpage.btn_addresses.click();
//			waitABit(3000);
//			customClickableWait(swiftpage.btn_address_edit_elan_evc);
//			swiftpage.btn_address_edit_elan_evc.click();
//			waitABit(5000);
//			customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//			swiftpage.ddl_end_user_CLLI_update.click();
//			waitABit(5000);
//			System.out.println("Updating Clli ");
//			swiftpage.cendcllielan(c_end_clli_elan).click();
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_end_user_CLLI_update);
//			swiftpage.btn_end_user_CLLI_update.click();
//			customwaitforpageloading(swiftpage);
//			try {
//				if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//					System.out.println("Secondary Save Btn is Available");
//					customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//					swiftpage.btn_end_user_CLLI_update_save.click();
//					waitABit(3000);
//					customwaitforpageloading(swiftpage);
//				}
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			System.out.println("End User CILLI Updated for ELAN EVC UNI2");
//			waitABit(3000);
//			customClickableWait(swiftpage.btn_second_product);
//			swiftpage.btn_second_product.click();
//			waitABit(2000);
//			customClickableWait(swiftpage.btn_second_sub_product);
//			swiftpage.btn_second_sub_product.click();
//			waitABit(2000);
//			customClickableWait(swiftpage.btn_address_edit_elan_evc);
//			swiftpage.btn_address_edit_elan_evc.click();
//			waitABit(8000);
//			customClickableWait(swiftpage.btn_end_user_CLLI_elan_evc_endpoint);
//			swiftpage.btn_end_user_CLLI_elan_evc_endpoint.click();
//			waitABit(5000);
//			System.out.println("Updating Clli");
//			swiftpage.cendcllielan(c_end_clli_elan).click();
//			waitABit(3000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_end_user_CLLI_update);
//			swiftpage.btn_end_user_CLLI_update.click();
//			waitABit(5000);
//			customwaitforpageloading(swiftpage);
//			try {
//				if (swiftpage.btn_end_user_CLLI_update_save.isCurrentlyVisible()) {
//					System.out.println("Secondary Save Btn is Available");
//					customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//					swiftpage.btn_end_user_CLLI_update_save.click();
//					waitABit(3000);
//					customwaitforpageloading(swiftpage);
//				}
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			waitABit(2000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			System.out.println("End User CILLI Updated for ELAN EVC UNI3 End Point");
//			waitABit(2000);
//		} else {
//			System.out.println("No Further End Points to Update in Swift");
//		}
//	}
//
//	@Step
//	public void i_complete_all_the_required_tasks(String c_end_clli_elan) {
//		String name = c_end_clli_elan;
//		int length = name.length();
//		System.out.println("C_End_Point Length : " + length);
//		if (length > 0) {
//			waitABit(2000);
//			System.out.println("Impersonating");
//			customClickableWait(swiftpage.btn_userinfo);
//			swiftpage.btn_userinfo.click();
//			waitABit(2000);
//			getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//			getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//					.sendKeys("Madahalli Chowdegowda, Raju");
//			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			waitABit(2000);
//			swiftpage.btn_impersonate.click();
//			customwaitforpageloading(swiftpage);
//			System.out.println("Impersonated to a User");
//			customClickableWait(swiftpage.btn_order_details);
//			swiftpage.btn_order_details.click();
//			waitABit(1000);
//			System.out.println("Adding OES");
//			swiftpage.ddl_OES.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			swiftpage.ddl_VSC.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			swiftpage.ddl_TDE.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			swiftpage.ddl_Director.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			swiftpage.ddl_Manager.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			swiftpage.btn_top_save.waitUntilClickable().click();
//			customwaitforpageloading(swiftpage);
//			System.out.println("OES Added");
//			swiftpage.btn_contacts.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
//			List<WebElement> Contacts = getDriver()
//					.findElements(By.xpath("//span[contains(@class,'contactName ng-binding')]"));
//			System.out.println("Number of Contacts Added = " + Contacts.size());
//			Iterator<WebElement> itr = Contacts.iterator();
//			while (itr.hasNext()) {
//				System.out.println(itr.next().getText());
//			}
//			if (Contacts.size() > 2) {
//				System.out.println("Contacts Already Attached to the Product Package");
//				waitABit(2000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			} else {
//				System.out.println("Contact Needs to be Updated");
//				waitABit(2000);
//				swiftpage.tbx_add_contact.sendKeys("Abhishek Tripathi");
//				waitABit(2000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(2000);
//				swiftpage.tbx_contact_role.click();
//				swiftpage.cbx_contact_role_select.click();
//				waitABit(2000);
//				swiftpage.tbx_contact_section.click();
//				waitABit(2000);
//				swiftpage.cbx_contact_section_1.click();
//				swiftpage.cbx_contact_section_2.click();
//				swiftpage.cbx_contact_section_3.click();
//				waitABit(2000);
//				swiftpage.btn_contacts.click();
//				customwaitforpageloading(swiftpage);
//				waitABit(5000);
//			}
//			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//					swiftpage.btn_collapse);
//			customClickableWait(swiftpage.lnk_order_package_1st_task);
//			swiftpage.lnk_order_package_1st_task.click();
//			customClickableWait(swiftpage.btn_reassign_me);
//			swiftpage.btn_reassign_me.click();
//			waitABit(3000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//			System.out.println("1st Task Reassigned to Me");
//			customClickableWait(swiftpage.lnk_order_package_1st_task);
//			swiftpage.lnk_order_package_1st_task.click();
//			customClickableWait(swiftpage.btn_complete);
//			waitABit(3000);
//			swiftpage.btn_complete.click();
//			customwaitforpageloading(swiftpage);
//			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//					swiftpage.btn_collapse);
//			System.out.println("1st Task Completed");
//			System.out.println("Waiting for 2nd and 3rd Tasks to Generate");
//			try {
//				WebElement UpdatedTask = getDriver()
//						.findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//				System.out.println("Update Task Status : " + UpdatedTask.getText());
//				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//				wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 3 of 3 items"));
//				System.out.println("2nd and 3rd Task Generated");
//				customwaitforpageloading(swiftpage);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			customClickableWait(swiftpage.lnk_order_package_ready1);
//			for (int i = 0; i < 5; i++) {
//				String SecondTask = getDriver()
//						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span")).getText();
//				System.out.println("Second Task Status : " + SecondTask);
//				if (SecondTask.contains("Ready")) {
//					System.out.println("Second Task is Ready to be Validated");
//					break;
//				} else {
//					System.out.println("Second Task is Not Ready to be Validated, Switching to MetaStorm");
//					getDriver().close();
//					System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//					metastormpage.openAt(Container6.getFieldValue("ITV4"));
//					WaitForPageToLoad();
//					metastormpage.maximize();
//					waitABit(5000); // auto login wait
//					System.out.println("MetaStorm Page is Loaded");
//					customClickableWait(metastormpage.btn_watch_list);
//					metastormpage.btn_watch_list.click();
//					waitABit(3000);
//					customClickableWait(metastormpage.ddl_process);
//					metastormpage.ddl_process.click();
//					waitABit(1000);
//					metastormpage.ddl_process_OP_Welcome.click();
//					waitABit(3000);
//					metastormpage.ddl_stage.click();
//					waitABit(1000);
//					metastormpage.ddl_stage_select.click();
//					waitABit(5000);
//					String parent = getDriver().getWindowHandle();
//					System.out.println("Sess Value for Xpath is : " + sess);
//					metastormpage.metastorm(sess).click();
//					waitABit(10000);
//					java.util.Set<String> child = getDriver().getWindowHandles();
//					System.out.println("Size of the Window : " + child.size());
//					child.remove(parent);
//					getDriver().switchTo().window((String) child.toArray()[0]);
//					getDriver().getTitle();
//					getDriver().manage().window().maximize();
//					try {
//						List<WebElement> TaskList = getDriver()
//								.findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[9]"));
//						for (int k = 0; k < TaskList.size(); k++) {
//							waitABit(5000);
//							if (TaskList.get(k).getText().contains("ManuallyExpireWCTaskWait")) {
//								waitABit(5000);
//								System.out.println("Manually Expire WC Task Wait Button Found");
//								String parent1 = getDriver().getWindowHandle();
//								TaskList.get(k).click();
//								System.out.println("Manually Expire WC Task Wait Clicked");
//								waitABit(10000);
//								Set<String> grandchild = getDriver().getWindowHandles();
//								System.out.println("Size of the Window : " + grandchild.size());
//								Iterator<String> ite = grandchild.iterator();
//								while (ite.hasNext()) {
//									String popupHandle = ite.next();
//									if (!parent1.equals(popupHandle) && !child.equals(popupHandle)
//											&& !parent.equals(popupHandle)) {
//										getDriver().switchTo().window(popupHandle);
//										getDriver().manage().window().maximize();
//										System.out.println("Window title is : " + getDriver().getTitle());
//										waitABit(2000);
//										customClickableWait(metastormpage.btn_manual_expire_ok);
//										metastormpage.btn_manual_expire_ok.click();
//										waitABit(10000);
//									}
//								}
//								System.out.println("Metastorm Task Performed");
//								getDriver().switchTo().window(parent);
//								getDriver().close();
//							}
//						}
//					} catch (Exception e) {
//						System.out.println("Catched Exception : " + e.getMessage());
//					} finally {
//						System.out.println("Manually Expire WC Task Done");
//					}
//					System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//					swiftpage.openAt(Container3.getFieldValue("ITV2"));
//					WaitForPageToLoad();
//					System.out.println("Swift Page Launched Again");
//					swiftpage.maximize();
//					WaitForPageToLoad(5); // wait for auto log in
//					swiftpage.ddl_business_order_id_select.waitUntilClickable().click();
//					waitABit(2000);
//					swiftpage.ddl_business_order_id_selected.click();
//					System.out.println("Business Order ID Selected");
//					waitABit(3000);
//					swiftpage.tbx_order_id_field.sendKeys(businessorderid);
//					swiftpage.btn_search.waitUntilClickable().click();
//					WaitForPageToLoad();
//					customClickableWait(swiftpage.lnk_order_package_ready1);
//				}
//			}
//			customClickableWait(swiftpage.lnk_order_package_ready1);
//			swiftpage.lnk_order_package_ready1.click();
//			waitABit(3000);
//			for (int k = 0; k < 2; k++) {
//				String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//				if (User.contains("Madahalli Chowdegowda, Raju")) {
//					System.out.println("2nd Task Already Impersonating to Raju");
//					break;
//				} else {
//					waitABit(3000);
//					customClickableWait(swiftpage.btn_userinfo);
//					swiftpage.btn_userinfo.click();
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//					getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//							.sendKeys("Madahalli Chowdegowda, Raju");
//					getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//					waitABit(2000);
//					swiftpage.btn_impersonate.click();
//					customwaitforpageloading(swiftpage);
//					waitABit(2000);
//				}
//			}
//			customClickableWait(swiftpage.lnk_order_package_ready1);
//			swiftpage.lnk_order_package_ready1.click();
//			waitABit(3000);
//			customClickableWait(swiftpage.btn_reassign_me);
//			swiftpage.btn_reassign_me.click();
//			waitABit(3000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//			System.out.println("2nd Task Reassigned to User");
//			customClickableWait(swiftpage.lnk_order_package_ready1);
//			swiftpage.lnk_order_package_ready1.click();
//			customClickableWait(swiftpage.btn_complete);
//			waitABit(3000);
//			swiftpage.btn_complete.click();
//			waitABit(10000);
//			customwaitforpageloading(swiftpage);
//			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//					swiftpage.btn_collapse);
//			waitABit(3000);
//			System.out.println("2nd Task Completed");
//			waitABit(3000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.lnk_order_package_ready2);
//			swiftpage.lnk_order_package_ready2.click();
//			waitABit(3000);
//			for (int i = 0; i < 2; i++) {
//				String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//				if (User.contains("Madahalli Chowdegowda, Raju")) {
//					System.out.println("3rd Task Already Impersonating to Raju");
//					break;
//				} else {
//					System.out.println("Need to Impersonate 3rd Task");
//					customClickableWait(swiftpage.btn_userinfo);
//					swiftpage.btn_userinfo.click();
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//					getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//							.sendKeys("Madahalli Chowdegowda, Raju");
//					getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//					waitABit(2000);
//					swiftpage.btn_impersonate.click();
//					customwaitforpageloading(swiftpage);
//					waitABit(2000);
//				}
//			}
//			waitABit(3000);
//			swiftpage.lnk_order_package_ready2.click();
//			customClickableWait(swiftpage.btn_reassign_me);
//			swiftpage.btn_reassign_me.click();
//			waitABit(3000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//			System.out.println("3rd Task Reassigned to Me");
//			customClickableWait(swiftpage.lnk_order_package_ready2);
//			swiftpage.lnk_order_package_ready2.click();
//			customClickableWait(swiftpage.btn_complete);
//			waitABit(3000);
//			swiftpage.btn_complete.click();
//			waitABit(10000);
//			customwaitforpageloading(swiftpage);
//		} else {
//			System.out.println("No Further End Points to Update in Swift");
//		}
//	}
//
//	@Step
//	public void order_should_move_to_GCA() {
//		waitABit(5000);
//		System.out.println("All Tasks Completed in Swift");
//		System.out.println("Order Pushed to GCA");
//		getDriver().close();
//	}
//
//	@Step
//	public void i_search_the_Order_Package_ID_in_GCA_for_elan() {
//		customClickableWait(gcapage.tbx_request_id);
//		System.out.println("Called Session Variable : " + sess);
//		gcapage.tbx_request_id.sendKeys(sess);
//		waitABit(5000);
//		gcapage.btn_submit.waitUntilClickable().click();
//		waitABit(5000);
//		for (int i = 0; i < 100; i++) {
//			String noresult = getDriver()
//					.findElement(By.xpath("//div[contains(@class,'col-sm-6 l3-standard-text-fg text-right')]"))
//					.getText();
//			if (noresult.contains("(0) order(s) showing.")) {
//				waitABit(5000);
//				gcapage.btn_submit.click();
//				System.out.println("Search Result = " + noresult + " ; Retrying");
//				waitABit(5000);
//			} else {
//				System.out.println("Order Details Found");
//				break;
//			}
//		}
//	}
//
//	@Step
//	public void i_search_the_Order_Package_ID_in_ISM_for_elan() {
//		waitABit(5000);
//		customClickableWait(ismpage.tbx_transaction_id);
//		ismpage.tbx_transaction_id.sendKeys(sess);
//		waitABit(2000);
//		ismpage.tbx_return_code.click();
//		waitABit(2000);
//		ismpage.tbx_return_code_all.click();
//		waitABit(5000);
//		ismpage.btn_search.waitUntilClickable().click();
//		waitABit(5000);
//		for (int i = 0; i < 100; i++) {
//			String searchresult = getDriver().findElement(By.xpath("//div[@id='tbtext-1084']")).getText();
//			if (searchresult.contains("No data to display")) {
//				System.out.println("Search Result = " + searchresult + " ; Retrying");
//				waitABit(5000);
//				ismpage.btn_search.click();
//			} else {
//				System.out.println("Search Result = " + searchresult);
//				break;
//			}
//		}
//	}
//
//	@Step
//	public void i_search_order_package_ID_in_project_list_page_for_elan() {
//		System.out.println("On Home Page");
//		customClickableWait(asriHomePage.lnk_project);
//		asriHomePage.lnk_project.click();
//		System.out.println("Project Icon is Clicked");
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriProjectListPage.frame_2frame);
//		customClickableWait(asriProjectListPage.ddl_ExtOrderID);
//		asriProjectListPage.ddl_ExtOrderID.click();
//		System.out.println("Clicked on External ID");
//		asriProjectListPage.tbx_ExtorderID.sendKeys(sess + Keys.ENTER);
//		System.out.println("Package ID Entred");
//		try {
//			for (int i = 0; i < 100; i++) {
//				String Displayed_Projects = getDriver().findElement(By.xpath("//span[@class='displayed-projects']"))
//						.getText();
//				System.out.println("Number of Projects Displayed : " + Displayed_Projects);
//				if (!(Displayed_Projects.contains("3"))) {
//					waitABit(2000);
//					asriProjectListPage.lnk_refresh.click();
//					waitABit(2000);
//				} else {
//					System.out.println("Required Service Group Available");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(asriProjectListPage.lnk_serviceGp);
//		asriProjectListPage.lnk_serviceGp.click();
//		System.out.println("Service Group Clicked");
//		customwaitforpageloading();
//	}
//
//	@Step
//	public void i_process_the_technical_data_gathering_for_elan() {
//		System.out.println("******** TDG is Being Started **********");
//		try {
//			for (int i = 0; i < 100; i++) {
//				String TDG = getDriver().findElement(By.xpath("(//a[@class='activityName'])[1]")).getText();
//				if (!TDG.contains("Technical Data Gathering")) {
//					asriHistoryActivityPage.lnk_TDG_refresh.click();
//					waitABit(5000);
//				} else {
//					System.out.println("TDG Task Available");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(asriHistoryActivityPage.lnk_TDG);
//		asriHistoryActivityPage.lnk_TDG.click();
//		System.out.println("TDG Clicked");
//		WaitForPageToLoad();
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_2frame);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		// getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		waitABit(5000);
//		asriTDGPage.ddl_Protection_Type_ELAN.click();
//		WebElement Protection = getDriver()
//				.findElement(By.xpath("//div[@id=\"row8c_MP_EVC_Service_1_Select_Tablejqxgrid\"]/div[2]/div"));
//		Actions action = new Actions(getDriver());
//		action.doubleClick(Protection).perform();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(5000);
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_save_elan.click();
//		waitABit(10000);
//		asriTDGPage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloadingasri(asriTDGPage);
//		getDriver().switchTo().parentFrame();
//		waitABit(5000);
//	}
//
//	@Step
//	public void i_verify_the_design() {
//		customClickableWait(asriHistoryActivityPage.lnk_hierarchy);
//		asriHistoryActivityPage.lnk_hierarchy.click();
//		waitABit(3000);
//		customClickableWait(asriHistoryActivityPage.lnk_MP_EVC_Service_Order);
//		asriHistoryActivityPage.lnk_MP_EVC_Service_Order.click();
//		waitABit(3000);
//		try {
//			for (int i = 0; i < 100; i++) {
//				String Verify_Design = getDriver().findElement(By.xpath("(//a[@class='activityName'])[1]")).getText();
//				if (!Verify_Design.contains("Verify Design")) {
//					asriHistoryActivityPage.lnk_TDG_refresh.click();
//					waitABit(5000);
//				} else {
//					System.out.println("Verify Design Task Available");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		asriHistoryActivityPage.lnk_VerifyDesignlink.click();
//		WaitForPageToLoad();
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		getDriver().switchTo().frame(asriVerifyDesignPage.frame_gtframe);
//		asriHistoryActivityPage.lnk_update_service_information.click();
//		waitABit(15000);
//		asriHistoryActivityPage.lnk_complete_verify_design.click();
//		waitABit(15000);
//	}
//
//	@Step
//	public void the_task_should_be_at_activate_stage() {
//		try {
//			for (int i = 0; i < 100; i++) {
//				String Verify_Design = getDriver().findElement(By.xpath("(//a[@class='activityName'])[1]")).getText();
//				if (!Verify_Design.contains("Activate")) {
//					asriHistoryActivityPage.lnk_TDG_refresh.click();
//					waitABit(5000);
//				} else {
//					System.out.println("Verify Design Task Completed");
//					System.out.println("Verify Design Task is at Activate Stage");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		getDriver().close();
//	}
//}
