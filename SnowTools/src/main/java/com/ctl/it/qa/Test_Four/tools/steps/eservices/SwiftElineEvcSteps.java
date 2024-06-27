//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
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
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import io.cucumber.datatable.DataTable;
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class SwiftElineEvcSteps extends BaseStep {
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
//	IntDataContainer Container1 = envData.getContainer("TEST2");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String sess = null;
//	String orderpackageid = null;
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_Swift_in_specified_environment_with_Account_ID(String ENV,
//			String Account_ID) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		if (ENV.contains("1")) {
//			swiftpage.openAt("http://swiftenv1/Customer/966529");
//		}
//		if (ENV.contains("2")) {
//			// swiftpage.openAt(Container3.getFieldValue("ITV2"));
//			swiftpage.openAt("http://swiftenv2/Customer/966529");
//		}
//		if (ENV.contains("4")) {
//			swiftpage.openAt("http://swiftenv4/Customer/966529");
//		}
//		WaitForPageToLoad(60);
//		System.out.println("Swift Page Launched");
//		String url = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url);
//		swiftpage.maximize();
//		WaitForPageToLoad(10); // wait for auto log in
//		/*
//		 * swiftpage.ddl_order.click(); waitABit(2000);
//		 * swiftpage.ddl_customer_id.click(); waitABit(2000);
//		 * swiftpage.tbx_order_id_field.sendKeys(Account_ID + Keys.ENTER);
//		 * customwaitforpageloading(swiftpage);
//		 * 
//		 * String parent=getDriver().getWindowHandle(); System.out.println(parent);
//		 * 
//		 * swiftpage.lnk_account.click(); WaitForPageToLoad(60);
//		 * 
//		 * swiftpage.lnk_account1.click(); WaitForPageToLoad(60);
//		 * 
//		 * java.util.Set<String> child = getDriver().getWindowHandles();
//		 * 
//		 * getDriver().switchTo().window(parent); waitABit(5000); getDriver().close();
//		 * 
//		 * System.out.println("Size of the Window : "+child.size()); //
//		 * child.remove(parent); getDriver().switchTo().window((String)
//		 * child.toArray()[1]); getDriver().manage().window().maximize();
//		 */
//		String url1 = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url1);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_create_new_package.click();
//		waitABit(2000);
//		String url2 = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url2);
//		System.out.println("Selecting Acount");
//		swiftpage.btn_select_account.click();
//		waitABit(2000);
//		swiftpage.tbx_account.sendKeys("304254");
//		waitABit(2000);
//		System.out.println("Account Number Entered");
//		swiftpage.btn_search_account.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		System.out.println("Clicked on Search");
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
//		waitABit(2000);
//		System.out.println("Ok Clicked");
//		swiftpage.btn_select_office.click();
//		waitABit(2000);
//		System.out.println("Office Selected");
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
//		swiftpage.btn_select_product_type.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
//				Keys.ARROW_DOWN);
//		waitABit(2000);
//		swiftpage.btn_order_package.click();
//		waitABit(2000);
//		System.out.println("Product Selected");
//		/*
//		 * WebElement Save =
//		 * getDriver().findElement(By.xpath("//button[@id='SaveNewOrderPackageButton']")
//		 * );
//		 * 
//		 * WebDriverWait wait1 = new WebDriverWait(getDriver(), 200);
//		 * wait1.until(ExpectedConditions.elementToBeClickable(Save));
//		 * 
//		 * Save.click();
//		 */
//		WebElement save = getDriver().findElement(By.id("SaveNewOrderPackageButton"));
//		JavascriptExecutor js0 = (JavascriptExecutor) getDriver();
//		js0.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", save);
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		String ur4 = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + ur4);
//		try {
//			for (int i = 0; i < 5; i++) {
//				if (save.isDisplayed()) {
//					System.out.println("Failed to Click on Save");
//					waitABit(2000);
//					swiftpage.btn_save_package.click();
//					waitABit(5000);
//					customwaitforpageloading(swiftpage);
//					String ur5 = getDriver().getCurrentUrl();
//					System.out.println("Current URL : " + ur5);
//				} else {
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customwaitforpageloading(swiftpage);
//		System.out.println("New Order Package Created");
//		waitABit(5000);
//		String ur6 = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + ur6);
//	}
//
//	@Step
//	public void i_prepare_the_order_package_in_swift_for_EVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
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
//		customwaitforpageloading(swiftpage);
//		System.out.println("Impersonated to a User");
//		swiftpage.btn_add_psp.click();
//		waitABit(2000);
//		swiftpage.tbx_clli_search.sendKeys(test.get("a_end_clli") + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(test.get("GLMID1") + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox = getDriver().findElement(By.id(test.get("GLMID1")));
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
//			// swiftpage.ddl_port_bandwidth.withTimeoutOf(30,
//			// TimeUnit.SECONDS).waitUntilVisible().waitUntilEnabled();
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
//		}
//		waitABit(2000);
//		String Uni_Type1 = test.get("Uni_Type1");
//		if (Uni_Type1.contains("Transparent")) {
//			swiftpage.ddl_uni_type.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_uni_transparent.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_uni_type.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			// swiftpage.ddl_select_uni_multiplexed.click();
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(2000);
//		String BE1 = test.get("BE1");
//		if (BE1.contains("No")) {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_BE_standard.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			// swiftpage.ddl_select_BE.click();
//			customwaitforpageloading(swiftpage);
//		}
//		if (Network_1.contains("Onnet")) {
//			waitABit(2000);
//		} else {
//			swiftpage.ddl_EVC_class.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(2000);
//		swiftpage.btn_next_2.click();
//		waitABit(5000);
//		swiftpage.btn_next.click();
//		waitABit(2000);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("**********A End Uni Configured**********");
//		swiftpage.btn_add_psp.click();
//		waitABit(2000);
//		swiftpage.tbx_clli_search.sendKeys(test.get("z_end_clli") + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(test.get("GLMID2") + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox2 = getDriver().findElement(By.id(test.get("GLMID2")));
//		JavascriptExecutor js2 = ((JavascriptExecutor) getDriver());
//		js2.executeScript("arguments[0].click();", checkbox2);
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
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_product.click();
//		waitABit(2000);
//		swiftpage.ddl_uni_selected2.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_address.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		String Network_2 = test.get("Network_2");
//		waitABit(3000);
//		if (Network_2.contains("Onnet")) {
//			// swiftpage.ddl_port_bandwidth.withTimeoutOf(30,
//			// TimeUnit.SECONDS).waitUntilVisible().waitUntilEnabled();
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
//		}
//		waitABit(2000);
//		String Uni_Type2 = test.get("Uni_Type2");
//		if (Uni_Type2.contains("Transparent")) {
//			swiftpage.ddl_uni_type.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_uni_transparent.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_uni_type.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(2000);
//		String BE2 = test.get("BE2");
//		if (BE2.contains("No")) {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_BE_standard.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		} else {
//			swiftpage.ddl_BE.click();
//			waitABit(2000);
//			// swiftpage.ddl_select_BE.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			customwaitforpageloading(swiftpage);
//		}
//		if (Network_2.contains("Onnet")) {
//			waitABit(2000);
//		} else {
//			swiftpage.ddl_EVC_class.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(5000);
//		swiftpage.btn_next_2.click();
//		waitABit(5000);
//		swiftpage.btn_next.click();
//		waitABit(5000);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("**********Z End Uni Configured**********");
//		String UNI_1 = getDriver()
//				.findElement(By.xpath("//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[1]/td[4]/span")).getText();
//		System.out.println("Product PAckage ID : UNI 1 : " + UNI_1);
//		String UNI_2 = getDriver()
//				.findElement(By.xpath("//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[2]/td[4]/span")).getText();
//		System.out.println("Product PAckage ID : UNI 2 : " + UNI_2);
//		swiftpage.btn_add_psp.click();
//		waitABit(2000);
//		swiftpage.tbx_clli_search.sendKeys(test.get("a_end_clli") + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(test.get("GLMID1") + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox3 = getDriver().findElement(By.id(test.get("GLMID1")));
//		JavascriptExecutor js3 = ((JavascriptExecutor) getDriver());
//		js3.executeScript("arguments[0].click();", checkbox3);
//		waitABit(3000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_clear.click();
//		waitABit(2000);
//		swiftpage.tbx_clli_search.clear();
//		waitABit(2000);
//		swiftpage.tbx_clli_search.sendKeys(test.get("z_end_clli") + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(test.get("GLMID2") + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox4 = getDriver().findElement(By.id(test.get("GLMID2")));
//		JavascriptExecutor js4 = ((JavascriptExecutor) getDriver());
//		js4.executeScript("arguments[0].click();", checkbox4);
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
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_product.click();
//		waitABit(2000);
//		swiftpage.ddl_evc_selected.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//		swiftpage.ddl_select_address.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_address2.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_pencil1.click();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.sendKeys(UNI_2);
//		waitABit(2000);
//		swiftpage.btn_search_uni1.click();
//		customwaitforpageloading(swiftpage);
//		try {
//			WebElement error_1 = getDriver().findElement(By.xpath("//div[@class='k-overlay']"));
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.visibilityOf(error_1));
//			for (int i = 0; i < 10; i++) {
//				if (error_1.isDisplayed()) {
//					customClickableWait(swiftpage.btn_product_packages);
//					swiftpage.btn_product_packages.click();
//					swiftpage.btn_add_psp.click();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(test.get("a_end_clli") + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(test.get("GLMID1") + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox5 = getDriver().findElement(By.id(test.get("GLMID1")));
//					JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
//					js5.executeScript("arguments[0].click();", checkbox5);
//					waitABit(3000);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_clear.click();
//					waitABit(2000);
//					waitABit(2000);
//					swiftpage.tbx_clli_search.clear();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(test.get("z_end_clli") + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(test.get("GLMID2") + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox6 = getDriver().findElement(By.id(test.get("GLMID2")));
//					JavascriptExecutor js6 = ((JavascriptExecutor) getDriver());
//					js6.executeScript("arguments[0].click();", checkbox6);
//					waitABit(3000);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_clear.click();
//					waitABit(2000);
//					swiftpage.btn_next.click();
//					waitABit(2000);
//					swiftpage.btn_new_product_package.click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_product.click();
//					waitABit(2000);
//					swiftpage.ddl_evc_selected.click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_address.click();
//					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_address2.click();
//					waitABit(2000);
//					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.lnk_pencil1.click();
//					waitABit(2000);
//					swiftpage.tbx_search_uni_1.sendKeys(UNI_1);
//					waitABit(2000);
//					swiftpage.btn_search_uni1.click();
//					customwaitforpageloading(swiftpage);
//				} else {
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//		swiftpage.btn_expand_1.click();
//		waitABit(2000);
//		swiftpage.lnk_select_uni.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		WebElement save = getDriver().findElement(By.id("relationshipSaveBtn"));
//		JavascriptExecutor js0 = ((JavascriptExecutor) getDriver());
//		js0.executeScript("arguments[0].click();", save);
//		// ((JavascriptExecutor)
//		// getDriver()).executeScript("arguments[0].scrollIntoView(true);",swiftpage.btn_relationship_save
//		// );
//		waitABit(2000);
//		// swiftpage.btn_relationship_save.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_pencil2.click();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.clear();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.sendKeys(UNI_1);
//		waitABit(2000);
//		swiftpage.btn_search_uni1.click();
//		customwaitforpageloading(swiftpage);
//		try {
//			WebElement error_1 = getDriver().findElement(By.xpath("//div[@class='k-overlay']"));
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.visibilityOf(error_1));
//			for (int i = 0; i < 10; i++) {
//				if (error_1.isDisplayed()) {
//					customClickableWait(swiftpage.btn_product_packages);
//					swiftpage.btn_product_packages.click();
//					swiftpage.btn_add_psp.click();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(test.get("a_end_clli") + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(test.get("GLMID1") + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox5 = getDriver().findElement(By.id(test.get("GLMID1")));
//					JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
//					js5.executeScript("arguments[0].click();", checkbox5);
//					waitABit(3000);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_clear.click();
//					waitABit(2000);
//					waitABit(2000);
//					swiftpage.tbx_clli_search.clear();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(test.get("z_end_clli") + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(test.get("GLMID2") + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox6 = getDriver().findElement(By.id(test.get("GLMID2")));
//					JavascriptExecutor js6 = ((JavascriptExecutor) getDriver());
//					js6.executeScript("arguments[0].click();", checkbox6);
//					waitABit(3000);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_clear.click();
//					waitABit(2000);
//					swiftpage.btn_next.click();
//					waitABit(2000);
//					swiftpage.btn_new_product_package.click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_product.click();
//					waitABit(2000);
//					swiftpage.ddl_evc_selected.click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_address.click();
//					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.ddl_select_address2.click();
//					waitABit(2000);
//					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//					customwaitforpageloading(swiftpage);
//					swiftpage.lnk_pencil1.click();
//					waitABit(2000);
//					swiftpage.tbx_search_uni_1.sendKeys(UNI_1);
//					waitABit(2000);
//					swiftpage.btn_search_uni1.click();
//					customwaitforpageloading(swiftpage);
//				} else {
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//		swiftpage.btn_expand_1.click();
//		waitABit(2000);
//		swiftpage.lnk_select_uni.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		WebElement save2 = getDriver().findElement(By.id("relationshipSaveBtn"));
//		JavascriptExecutor js31 = ((JavascriptExecutor) getDriver());
//		js31.executeScript("arguments[0].click();", save2);
//		// ((JavascriptExecutor)
//		// getDriver()).executeScript("arguments[0].scrollIntoView(true);",swiftpage.btn_relationship_save
//		// );
//		waitABit(2000);
//		// swiftpage.btn_relationship_save.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		String instance_id_1 = getDriver().findElement(By.xpath("(//td[@class='ng-binding ng-scope'])[1]")).getText();
//		String instance_id_2 = getDriver().findElement(By.xpath("(//td[@class='ng-binding ng-scope'])[2]")).getText();
//		System.out.println("Full ID 1 : " + instance_id_1);
//		System.out.println("Full ID 2 : " + instance_id_2);
//		String Ins_ID_1 = instance_id_1.substring(12, 21);
//		String Ins_ID_2 = instance_id_2.substring(12, 21);
//		System.out.println("Instance ID 1 : " + Ins_ID_1);
//		System.out.println("Instance ID 2 : " + Ins_ID_2);
//		swiftpage.tbx_ins_id_1.sendKeys(Ins_ID_1);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.tbx_ins_id_2.sendKeys(Ins_ID_2);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_evc.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.ddl_select_bandwidth.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
//				Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.ddl_select_class.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_next_2.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_next.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//	}
//
//	@Step
//	public void i_update_the_contact_details_for_EVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_contacts);
//		swiftpage.btn_contacts.click();
//		System.out.println("Updating Contacts");
//		waitABit(2000);
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
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
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
//	public void i_attach_the_SOF_in_swift() {
//		customClickableWait(swiftpage.lnk_docs1);
//		swiftpage.lnk_docs1.click();
//		waitABit(3000);
//		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SOF.pdf";
//		System.out.println("SOF File Path : " + FilePath);
//		getDriver().findElement(By.id("fileUploadInput")).sendKeys(FilePath);
//		waitABit(8000);
//		customClickableWait(swiftpage.ddl_doc_type);
//		swiftpage.ddl_doc_type.click();
//		customClickableWait(swiftpage.ddl_doc_sof);
//		swiftpage.ddl_doc_sof.click();
//		waitABit(3000);
//		swiftpage.btn_save_doc.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_close_window.click();
//		getDriver().navigate().refresh();
//		WaitForPageToLoad(60);
//	}
//
//	@Step
//	public void i_validate_reassign_and_complete_the_first_task_in_swift() {
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_product_packages.waitUntilClickable().click();
//		waitABit(3000);
//		WebElement checkbox5 = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
//		js5.executeScript("arguments[0].click();", checkbox5);
//		customClickableWait(swiftpage.btn_edit_dates);
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
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		swiftpage.lnk_order_package_1st_task.click();
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("1st Task Reassigned to Me");
//		waitABit(2000);
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		waitABit(3000);
//		swiftpage.lnk_order_package_1st_task.click();
//		waitABit(2000);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(2000);
//		swiftpage.btn_complete.click();
//		System.out.println("test");
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("1st Task Completed");
//	}
//
//	@Step
//	public void i_reassign_validate_and_complete_the_second_task_in_swift() {
//		System.out.println("Waiting for Next Task to Generate");
//		try {
//			for (int i = 0; i < 100; i++) {
//				waitABit(5000);
//				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//						.getText();
//				System.out.println("Update Task Status : " + UpdatedTask);
//				if (UpdatedTask.contains("1 - 2 of 2 items")) {
//					System.out.println("2nd Task Generated");
//					waitABit(2000);
//					break;
//				} else {
//					waitABit(30000);
//					getDriver().navigate().refresh();
//					WaitForPageToLoad(60);
//					System.out.println("2nd Task Not Generated, Retrying");
//				}
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_ready2);
//		String SecondTask = getDriver()
//				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
//		System.out.println("Second Task Status : " + SecondTask);
//		if (SecondTask.contains("Ready")) {
//			System.out.println("Second Task is Ready to be Validated");
//		}
//		for (int j = 0; j < 2; j++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("2nd Task Already Impersonating to Raju");
//				break;
//			} else {
//				System.out.println("Need to Impersonate 2nd Task");
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(2000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//						.sendKeys("Madahalli Chowdegowda, Raju");
//				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//				waitABit(2000);
//				swiftpage.btn_impersonate.click();
//				customwaitforpageloading(swiftpage);
//				waitABit(2000);
//			}
//		}
//		waitABit(2000);
//		customClickableWait(swiftpage.lnk_order_package_ready2);
//		swiftpage.lnk_order_package_ready2.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("2nd Task Reassigned to User");
//		waitForSwiftProgressBar(swiftpage);
//		// customClickableWait(swiftpage.lnk_order_package_ready2);
//		swiftpage.lnk_order_package_ready2.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().waitUntilEnabled();
//		swiftpage.lnk_order_package_ready2.click();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitForSwiftProgressBar(swiftpage);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		waitForSwiftProgressBar(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		waitABit(3000);
//		System.out.println("2nd Task Completed");
//		String Packg_Status = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
//		System.out.println("Package Status : " + Packg_Status);
//		try {
//			for (int i = 0; i < 100; i++) {
//				waitABit(2000);
//				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//						.getText();
//				System.out.println("Update Task Status : " + UpdatedTask);
//				/*
//				 * WebDriverWait wait = new WebDriverWait(getDriver(), 100);
//				 * wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask,
//				 * "1 - 2 of 2 items"));
//				 */
//				if (UpdatedTask.contains("1 - 4 of 4 items")) {
//					waitABit(2000);
//					break;
//				} else {
//					waitABit(30000);
//					getDriver().navigate().refresh();
//					WaitForPageToLoad(60);
//				}
//				System.out.println("3rd & 4th Task Generated");
//				waitForSwiftProgressBar(swiftpage);
//				customwaitforpageloading(swiftpage);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_ready4);
//		for (int i = 0; i < 5; i++) {
//			String FourthTask = getDriver()
//					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[4]/span")).getText();
//			System.out.println("Fourth Task Status : " + FourthTask);
//			if (FourthTask.contains("Ready")) {
//				System.out.println("Fourth Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Fourth Task is Not Ready to be Validated, Switching to MetaStorm");
//				getDriver().close();
//				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//				metastormpage.openAt(envData.getFieldValue("Metastorm"));
//				WaitForPageToLoad(100);
//				metastormpage.maximize();
//				waitABit(5000); // auto login wait
//				System.out.println("MetaStorm Page is Loaded");
//				System.out.println("Current URL : " + getDriver().getCurrentUrl());
//				customClickableWait(metastormpage.btn_watch_list);
//				metastormpage.btn_watch_list.click();
//				waitABit(3000);
//				customClickableWait(metastormpage.ddl_process);
//				metastormpage.ddl_process.click();
//				waitABit(5000);
//				customClickableWait(metastormpage.ddl_process_OP_Welcome);
//				metastormpage.ddl_process_OP_Welcome.click();
//				waitABit(5000);
//				customClickableWait(metastormpage.ddl_stage);
//				metastormpage.ddl_stage.click();
//				waitABit(5000);
//				customClickableWait(metastormpage.ddl_stage_select);
//				metastormpage.ddl_stage_select.click();
//				waitABit(5000);
//				String parent = getDriver().getWindowHandle();
//				System.out.println("Sess Value for Xpath is : " + sess);
//				metastormpage.metastorm(sess).click();
//				waitABit(10000);
//				java.util.Set<String> child = getDriver().getWindowHandles();
//				System.out.println("Size of the Window : " + child.size());
//				child.remove(parent);
//				getDriver().switchTo().window((String) child.toArray()[0]);
//				getDriver().getTitle();
//				getDriver().manage().window().maximize();
//				try {
//					List<WebElement> TaskList = getDriver()
//							.findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[9]"));
//					for (int k = 0; k < TaskList.size(); k++) {
//						waitABit(5000);
//						if (TaskList.get(k).getText().contains("ManuallyExpireWCTaskWait")) {
//							waitABit(5000);
//							System.out.println("Manually Expire WC Task Wait Button Found");
//							String parent1 = getDriver().getWindowHandle();
//							TaskList.get(k).click();
//							System.out.println("Manually Expire WC Task Wait Clicked");
//							waitABit(10000);
//							Set<String> grandchild = getDriver().getWindowHandles();
//							System.out.println("Size of the Window : " + grandchild.size());
//							Iterator<String> ite = grandchild.iterator();
//							while (ite.hasNext()) {
//								String popupHandle = ite.next();
//								if (!parent1.equals(popupHandle) && !child.equals(popupHandle)
//										&& !parent.equals(popupHandle)) {
//									getDriver().switchTo().window(popupHandle);
//									getDriver().manage().window().maximize();
//									System.out.println("Window title is : " + getDriver().getTitle());
//									waitABit(2000);
//									customClickableWait(metastormpage.btn_manual_expire_ok);
//									metastormpage.btn_manual_expire_ok.click();
//									waitABit(10000);
//								}
//							}
//							System.out.println("Metastorm Task Performed");
//							getDriver().switchTo().window(parent);
//							getDriver().close();
//						}
//					}
//				} catch (Exception e) {
//					System.out.println("Catched Exception : " + e.getMessage());
//				} finally {
//					System.out.println("Manually Expire WC Task Done");
//				}
//				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//				String URL = envData.getFieldValue("Swift");
//				swiftpage.openAt(URL);
//				WaitForPageToLoad(60);
//				System.out.println("Swift Page Launched Again");
//				swiftpage.maximize();
//				WaitForPageToLoad(5); // wait for auto log in
//				swiftpage.tbx_order_id_field.clear();
//				swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
//				WaitForPageToLoad(60);
//				customClickableWait(swiftpage.lnk_order_package_ready1);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_ready4);
//		swiftpage.lnk_order_package_ready4.click();
//		waitABit(3000);
//		for (int k = 0; k < 2; k++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("4th Task Already Impersonating to Raju");
//				break;
//			} else {
//				waitABit(3000);
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(2000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//						.sendKeys("Madahalli Chowdegowda, Raju");
//				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//				waitABit(2000);
//				swiftpage.btn_impersonate.click();
//				customwaitforpageloading(swiftpage);
//				waitForSwiftProgressBar(swiftpage);
//				waitABit(2000);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_ready4);
//		swiftpage.lnk_order_package_ready4.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		waitForSwiftProgressBar(swiftpage);
//		System.out.println("4th Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_ready4);
//		swiftpage.lnk_order_package_ready4.waitUntilPresent();
//		swiftpage.lnk_order_package_ready4.click();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitForSwiftProgressBar(swiftpage);
//		// waitABit(3000);
//		swiftpage.btn_complete.click();
//		// waitABit(10000);
//		waitForSwiftProgressBar(swiftpage);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//	}
//
//	@Step
//	public void i_reassign_validate_and_complete_the_last_task_in_swift() {
//		customClickableWait(swiftpage.lnk_order_package_ready2);
//		String LastTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span"))
//				.getText();
//		System.out.println("Second Task Status : " + LastTask);
//		if (LastTask.contains("Ready")) {
//			System.out.println("Last Task is Ready to be Validated");
//		}
//		for (int j = 0; j < 2; j++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("Last Task Already Impersonating to Raju");
//				break;
//			} else {
//				System.out.println("Need to Impersonate Last Task");
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(2000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//						.sendKeys("Madahalli Chowdegowda, Raju");
//				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//				waitABit(2000);
//				swiftpage.btn_impersonate.click();
//				customwaitforpageloading(swiftpage);
//				// waitABit(2000);
//				waitForSwiftProgressBar(swiftpage);
//			}
//		}
//		waitABit(2000);
//		customClickableWait(swiftpage.lnk_order_package_ready3);
//		swiftpage.lnk_order_package_ready3.waitUntilPresent();
//		swiftpage.lnk_order_package_ready3.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		waitForSwiftProgressBar(swiftpage);
//		System.out.println("Last Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_ready3);
//		swiftpage.lnk_order_package_ready3.waitUntilPresent();
//		swiftpage.lnk_order_package_ready3.click();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitForSwiftProgressBar(swiftpage);
//		// waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		// ((JavascriptExecutor)
//		// getDriver()).executeScript("arguments[0].scrollIntoView(true);",swiftpage.btn_collapse
//		// );
//		// waitForSwiftProgressBar(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		waitABit(3000);
//		System.out.println("Last Task Completed");
//		String Packg_Status = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
//		System.out.println("Package Status : " + Packg_Status);
//	}
//}
