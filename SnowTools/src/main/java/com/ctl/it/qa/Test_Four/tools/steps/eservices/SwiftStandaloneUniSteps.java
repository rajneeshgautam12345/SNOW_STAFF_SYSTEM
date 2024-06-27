//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriLoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriProjectListPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.GCAPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ISMPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.MetaStormPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.SwiftPage;
//
//import io.cucumber.datatable.DataTable;
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class SwiftStandaloneUniSteps extends BaseStep {
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
//	String sess = null;
//	String sess2 = null;
//	String orderpackageid = null;
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_Swift_for_account(String Account_ID) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		String URL = envData.getFieldValue("Swift");
//		swiftpage.openAt(URL + "Customer/" + Account_ID);
//		WaitForPageToLoad(60);
//		System.out.println("Swift Page Launched");
//		String url1 = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url1);
//		swiftpage.maximize();
//		WaitForPageToLoad(10); // wait for auto log in
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_create_new_package.waitUntilClickable();
//		swiftpage.btn_create_new_package.click();
//		// waitABit(2000);
//		System.out.println("Selecting Acount");
//		swiftpage.btn_select_account.waitUntilClickable();
//		swiftpage.btn_select_account.click();
//		// waitABit(2000);
//		swiftpage.waitForTextToAppear("Account Number", 30000);
//		swiftpage.tbx_account.sendKeys("304254");
//		// waitABit(2000);
//		System.out.println("Account Number Entered");
//		swiftpage.btn_search_account.waitUntilClickable();
//		swiftpage.btn_search_account.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.waitForTextToAppear("Note: For maximum performance", 30000);
//		System.out.println("Clicked on Search");
//		swiftpage.lnk_select_account.waitUntilClickable();
//		swiftpage.lnk_select_account.click();
//		waitABit(2000);
//		System.out.println("Account Selected");
//		waitABit(2000);
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
//		WebElement ok = wait.until(ExpectedConditions
//				.presenceOfElementLocated(By.xpath("(//button[@ng-click='AccountManagementSearchOkClick()'])[1]")));
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", ok);
//		// swiftpage.btn_ok_account.click();
//		swiftpage.waitForTextToAppear("Create New Order", 30000);
//		System.out.println("Ok Clicked");
//		swiftpage.btn_select_office.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		System.out.println("Office Selected");
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		swiftpage.btn_select_product_type.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
//				Keys.ARROW_DOWN);
//		waitABit(1000);
//		swiftpage.btn_order_package.click();
//		waitABit(1000);
//		System.out.println("Product Selected");
//		WebElement save = getDriver().findElement(By.id("SaveNewOrderPackageButton"));
//		JavascriptExecutor js0 = (JavascriptExecutor) getDriver();
//		js0.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", save);
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		/*
//		 * 
//		 * try {
//		 * 
//		 * // WebElement save =
//		 * getDriver().findElement(By.id("SaveNewOrderPackageButton")); //
//		 * JavascriptExecutor js0 = (JavascriptExecutor)getDriver();
//		 * js0.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()",
//		 * save); System.out.println("First Save Try");
//		 * waitForSwiftProgressBar(swiftpage); } catch (Exception e) {
//		 * swiftpage.btn_save_package.click(); waitABit(1000);
//		 * customwaitforpageloading(swiftpage); System.out.println("Catch Save Try");
//		 * waitForSwiftProgressBar(swiftpage); }
//		 */
//		System.out.println("New Order Package Created");
//		waitABit(5000);
//	}
//
//	@Step
//	public void i_prepare_the_order_package_in_swift_with_below_info(DataTable table) {
//		String orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
//		System.out.println("Order Package ID = " + orderpackageid);
//		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
//		sess = Serenity.sessionVariableCalled("orderpackageid");
//		waitABit(3000);
//		swiftpage.ddl_order.click();
//		waitABit(2000);
//		swiftpage.ddl_order_id.click();
//		waitABit(2000);
//		swiftpage.tbx_order_id_field.clear();
//		waitABit(1000);
//		swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
//		for (int i = 0; i < 500; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1 - 1 of 1 items")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(3000);
//				swiftpage.btn_search.click();
//				waitForSwiftProgressBar(swiftpage);
//				customwaitforpageloading(swiftpage);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		swiftpage.lnk_order_package_1st_task.click();
//		waitABit(2000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_order_type.click();
//		waitABit(2000);
//		swiftpage.ddl_order_type_selected.click();
//		waitABit(2000);
//		swiftpage.ddl_CCM_select.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(2000);
//		swiftpage.ddl_OES_select.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(2000);
//		swiftpage.btn_top_save.click();
//		waitForSwiftProgressBar(swiftpage);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(2000);
//		System.out.println("Impersonating");
//		customClickableWait(swiftpage.btn_userinfo);
//		swiftpage.btn_userinfo.click();
//		waitABit(5000);
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//				.sendKeys("Madahalli Chowdegowda, Raju");
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		swiftpage.btn_impersonate.click();
//		waitForSwiftProgressBar(swiftpage);
//		customwaitforpageloading(swiftpage);
//		System.out.println("Impersonated to a User");
//		swiftpage.btn_add_psp.click();
//		waitABit(2000);
//		Map<String, String> test = table.asMap(String.class, String.class);
//		swiftpage.tbx_clli_search.sendKeys((test.get("a_end_clli") + Keys.TAB));
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(10000);
//		waitForSwiftProgressBar(swiftpage);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys("SL0002991479" + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox = getDriver().findElement(By.id("SL0002991479"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
//		waitABit(3000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_clear.click();
//		waitABit(2000);
//		swiftpage.btn_next.click();
//		waitABit(2000);
//		swiftpage.btn_new_product_package.click();
//		waitForSwiftProgressBar(swiftpage);
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_product.click();
//		waitABit(3000);
//		swiftpage.ddl_uni_selected.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_address.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		String Network_1 = test.get("Network_1");
//		if (Network_1.contains("Onnet")) {
//			waitABit(3000);
//			// swiftpage.ddl_port_bandwidth.waitUntilEnabled();
//			swiftpage.ddl_port_bandwidth.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_bandwidth_1gbps.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_network_status.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//			// swiftpage.ddl_select_offnet.click();
//			customwaitforpageloading(swiftpage);
//			swiftpage.ddl_port_bandwidth.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//			swiftpage.ddl_bandwidth.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
//					Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			// swiftpage.ddl_select_bandwidth_10mbps.click();
//			customwaitforpageloading(swiftpage);
//			swiftpage.ddl_EVC_Class.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		}
//		swiftpage.ddl_uni_type.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		String BE1 = test.get("BE1");
//		if (BE1.contains("No")) {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_next_2.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_next.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("********** Uni Configured**********");
//	}
//
//	@Step
//	public void i_update_the_contact_details_for_Uni_with_below_info(DataTable table) {
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_contacts);
//		swiftpage.btn_contacts.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().waitUntilEnabled();
//		swiftpage.btn_contacts.click();
//		System.out.println("Updating Contacts");
//		waitABit(2000);
//		Map<String, String> test = table.asMap(String.class, String.class);
//		swiftpage.tbx_add_contact.sendKeys(test.get("Contact"));
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
//		swiftpage.tbx_contact_role.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		swiftpage.tbx_contact_section.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
//		/*
//		 * getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//		 * waitABit(2000);
//		 */
//		swiftpage.btn_contacts.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(15000);
//		try {
//			WebElement Oops = getDriver().findElement(By.xpath("//h2[@id='OopsTitle']"));
//			WebElement Overlay = getDriver().findElement(By.xpath("//div[@class='k-overlay']"));
//			for (int i = 0; i < 5; i++) {
//				if (Oops.isDisplayed() && Overlay.isDisplayed()) {
//					waitABit(2000);
//					System.out.println("Oops Displayed, Closing the Window");
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//button[contains(.,'Refresh Page')]")).click();
//				} else {
//					System.out.println("Contacts Updated Successfully");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		// a[@class='k-button k-bare k-button-icon k-window-action k-state-hover']
//	}
//
//	@Step
//	public String i_process_the_technical_data_gathering_for_Standalone_Uni_with(DataTable table) {
//		System.out.println("******** TDG is Being Started **********");
//		// String Service_Group =
//		// getDriver().findElement(By.xpath("//div[@data-uxf-point='name'][contains(.,'Service
//		// Group')]")).getText();
//		// String Service_Group =
//		// getDriver().findElement(By.xpath("(//div[@class='name'])[2]")).getText();
//		// System.out.println("Service Groupp Details : "+Service_Group);
//		String instance_id_1 = getDriver()
//				.findElement(By.xpath("//div[@data-uxf-point='name'][contains(.,'Service Group')]")).getText();
//		String Service_Group = instance_id_1.substring(24, 39);
//		System.out.println("Service Groupp Details : " + Service_Group);
//		Serenity.setSessionVariable("Order_ID").to(Service_Group);
//		sess2 = Serenity.sessionVariableCalled("Order_ID");
//		waitABit(3000);
//		try {
//			for (int i = 0; i < 100; i++) {
//				String TDG = getDriver().findElement(By.xpath("(//a[@class='activityName'])[1]")).getText();
//				System.out.println("TDG Status :" + TDG);
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
//		waitABit(5000);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		System.out.println("UNI Dropdown Clicked");
//		customClickableWait(asriTDGPage.lnk_UNI);
//		asriTDGPage.lnk_UNI.click();
//		waitABit(5000);
//		customwaitforpageloading();
//		// asriTDGPage.selectUni(0).click();
//		System.out.println("TDG for UNI is being Completed ");
//		asriTDGPage.ddl_loaRequire.click();
//		asriTDGPage.ddl_selectloaRequire.click();
//		asriTDGPage.ddl_interface.click();
//		asriTDGPage.ddl_Selectinterface.click();
//		asriTDGPage.ddl_UNI_Mode.click();
//		asriTDGPage.ddl_selectUNI_Mode.click();
//		asriTDGPage.ddl_UNI_Connector_Type.click();
//		asriTDGPage.ddl_selectUNI_Connector_Type.click();
//		asriTDGPage.ddl_Redundant_Power_Supply.click();
//		asriTDGPage.ddl_selectRedundant_Power_Supply.click();
//		asriTDGPage.ddl_Power_Type.click();
//		asriTDGPage.ddl_selectPower_Type.click();
//		asriTDGPage.ddl_Customer_CPE_Duplex.click();
//		asriTDGPage.ddl_selectCustomer_CPE_Duplex.click();
//		asriTDGPage.btn_save.click();
//		customwaitforpageloadingasri(asriTDGPage);
//		System.out.println("UNI Update Completed");
//		customwaitforpageloading();
//		String Net_Status = getDriver().findElement(By.xpath("(//span[@class='headerFont'])[3]")).getText();
//		if (Net_Status.contains("Off Net")) {
//			System.out.println("Offnet Fields are being filled");
//			asriTDGPage.ddl_Interface_Rate.click();
//			asriTDGPage.ddl_select_Interface_Rate.click();
//			waitABit(3000);
//			asriTDGPage.ddl_Colocation_CLLI.sendKeys("LABBRMCO");
//			waitABit(3000);
//			asriTDGPage.ddl_Interface_Type.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(3000);
//			System.out.println("Offnet Fields Done");
//			asriTDGPage.btn_save.click();
//			customwaitforpageloadingasri(asriTDGPage);
//			System.out.println("UNI Update Completed for Offnet as well");
//		} else {
//			System.out.println("No Offnet");
//			waitABit(3000);
//		}
//		Map<String, String> test = table.asMap(String.class, String.class);
//		String BE1 = test.get("BE1");
//		if (BE1.contains("No")) {
//			System.out.println("No Need to Provide TDG for CAT for UNI");
//		} else {
//			System.out.println("Updating TDG for CAT for UNI");
//			asriTDGPage.lnk_Cat1.click();
//			waitABit(1000);
//			asriTDGPage.ddl_cat_interface.click();
//			asriTDGPage.ddl_cat_interface_select.click();
//			waitABit(1000);
//			asriTDGPage.btn_save.click();
//			customwaitforpageloadingasri(asriTDGPage);
//			customwaitforpageloading();
//		}
//		customwaitforpageloadingasri(asriTDGPage);
//		customwaitforpageloading();
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloadingasri(asriTDGPage);
//		waitABit(5000);
//		return Service_Group;
//	}
//}
