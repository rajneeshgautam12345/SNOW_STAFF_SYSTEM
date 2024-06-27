//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
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
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.SwiftPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class EaccessModifySteps extends BaseStep {
//	SwiftPage swiftpage;
//	GCAPage gcapage;
//	ISMPage ismpage;
//	AsriLoginPage asriLoginPage;
//	AsriHomePage asriHomePage;
//	AsriProjectListPage asriProjectListPage;
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String Order_pckg_ID = null;
//	String orderpckgid1 = null;
//	String orderpckgid2 = null;
//	String new_package_number = null;
//	String final_package_number = null;
//	String sess = null;
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_Swift_for_modify_scenario() {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		swiftpage.openAt(Container3.getFieldValue("ITV4"));
//		WaitForPageToLoad();
//		System.out.println("Swift Page Launched");
//		swiftpage.maximize();
//		WaitForPageToLoad(5); // wait for auto log in
//		System.out.println("Order Package ID Selected");
//	}
//
//	@Step
//	public void i_search_the_Order_package_ID_in_Swift(String Order_pckg_ID) {
//		waitABit(1000);
//		swiftpage.tbx_order_id_field.sendKeys(Order_pckg_ID);
//		swiftpage.btn_search.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//		for (int i = 0; i < 200; i++) {
//			String message = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
//			System.out.println("Order Id = " + message);
//			if (!message.contains(Order_pckg_ID)) {
//				System.out.println("No Records Found, Retrying");
//				waitABit(10000);
//				swiftpage.btn_search.click();
//				customwaitforpageloading(swiftpage);
//			} else {
//				System.out.println("Order Package Found");
//				break;
//			}
//		}
//		waitABit(1000);
//	}
//
//	@Step
//	public void it_should_be_generating_order_package_details() {
//		for (int i = 0; i < 25; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(3000);
//				swiftpage.btn_search.click();
//				customwaitforpageloading(swiftpage);
//			}
//		}
//	}
//
//	@Step
//	public void i_shall_capture_the_Product_package_IDs() {
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		orderpckgid1 = getDriver()
//				.findElement(By.xpath("//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[1]/td[4]/span")).getText();
//		System.out.println("Product Package ID 1 : " + orderpckgid1);
//		orderpckgid2 = getDriver()
//				.findElement(By.xpath("//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[2]/td[4]/span")).getText();
//		System.out.println("Product Package ID 2 : " + orderpckgid2);
//	}
//
//	@Step
//	public void i_click_on_account_name() {
//		waitABit(5000);
//		WebElement account_name = getDriver().findElement(By.xpath("//a[@id='headerLinkAnchor']"));
//		System.out.println("Account Name : " + account_name.getText());
//		account_name.click();
//		System.out.println("Account Name Clicked");
//		waitABit(3000);
//		ArrayList<String> tab2 = new ArrayList<String>(getDriver().getWindowHandles());
//		getDriver().switchTo().window(tab2.get(0));
//		getDriver().close();
//		getDriver().switchTo().window(tab2.get(1));
//		WaitForPageToLoad(60);
//	}
//
//	@Step
//	public void account_detail_should_be_available_in_another_tab() {
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		Boolean Getpsp = getDriver().findElement(By.xpath("//button[@id='GetPspsButton']")).isDisplayed();
//		System.out.println("Get PSP buttion is available :" + Getpsp);
//	}
//
//	@Step
//	public void i_start_Modifying_the_OVC_package_by_creating_a_new_modified_order_package() {
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_userinfo);
//		swiftpage.btn_userinfo.click();
//		waitABit(15000);
//		/*
//		 * WebDriverWait wait = new WebDriverWait(getDriver(), 200);
//		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
//		 * xpath("//span[@class='k-icon k-i-arrow-60-down k-i-loading']")));
//		 */
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//				.sendKeys("Madahalli Chowdegowda, Raju");
//		waitABit(10000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		swiftpage.btn_impersonate.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		swiftpage.tbx_psp_id.sendKeys(orderpckgid1);
//		waitABit(3000);
//		swiftpage.btn_getpsp.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_psp_id_row);
//		swiftpage.btn_psp_id_row.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_modify);
//		swiftpage.btn_modify.click();
//		waitABit(5000);
//		swiftpage.btn_modify_ok.click();
//		waitABit(5000);
//		swiftpage.btn_modify_ok_ok.click();
//		waitABit(2000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		String new_package = getDriver().findElement(By.xpath("//*[@id=\"inventoryPspEditor\"]//li[2]//span"))
//				.getText();
//		System.out.println("New Package : " + new_package);
//		String str = new_package;
//		Pattern p = Pattern.compile("(\\d+)");
//		Matcher m = p.matcher(str);
//		while (m.find()) {
//			new_package_number = m.group(1);
//			System.out.println("New_Package_Number : " + new_package_number);
//		}
//		Serenity.setSessionVariable("orderpackageid").to(new_package_number);
//		sess = Serenity.sessionVariableCalled("orderpackageid");
//	}
//
//	@Step
//	public void i_modify_the_UNI_package_and_attach_it_to_the_existing_modified_order_package() {
//		swiftpage.tbx_psp_id.clear();
//		swiftpage.tbx_psp_id.sendKeys(orderpckgid2);
//		waitABit(3000);
//		swiftpage.btn_getpsp.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_psp_id_row);
//		swiftpage.btn_psp_id_row.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_modify);
//		swiftpage.btn_modify.click();
//		waitABit(5000);
//		swiftpage.rbn_modify_existing_package.click();
//		waitABit(2000);
//		WebElement pckg_select = getDriver().findElement(By.xpath("//span[contains(.,'" + new_package_number + "')]"));
//		pckg_select.click();
//		waitABit(2000);
//		swiftpage.btn_modify_ok.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//	}
//
//	@Step
//	public void i_search_the_modified_order_package_ID_in_Swift() {
//		swiftpage.tbx_order_id_field.clear();
//		waitABit(2000);
//		swiftpage.tbx_order_id_field.sendKeys(new_package_number + Keys.ENTER);
//		waitABit(5000);
//	}
//
//	@Step
//	public void it_should_be_generating_modified_order_package_details() {
//		for (int i = 0; i < 25; i++) {
//			String ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
//					.getText();
//			if (ispackageavailable.contains("1 - 1 of 1 items")) {
//				System.out.println("Order Package Available");
//				break;
//			} else {
//				System.out.println("Order Package not Available, Retrying");
//				waitABit(5000);
//				swiftpage.btn_search.click();
//				customwaitforpageloading(swiftpage);
//			}
//		}
//	}
//
//	@Step
//	public void i_impersonate_the_Order_Package_to_a_user_for_modifiy_scenario() {
//		for (int k = 0; k < 2; k++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			System.out.println("User : " + User);
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("Task Already Impersonating to Raju");
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
//				waitABit(2000);
//			}
//		}
//	}
//
//	@Step
//	public void i_update_order_type_add_an_OES_CCM() {
//		customClickableWait(swiftpage.btn_order_details);
//		swiftpage.btn_order_details.click();
//		waitABit(1000);
//		swiftpage.ddl_order_type.click();
//		waitABit(2000);
//		swiftpage.ddl_order_type_select.click();
//		waitABit(3000);
//		System.out.println("Adding CCM");
//		swiftpage.ddl_CCM.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		System.out.println("Adding OES");
//		swiftpage.ddl_OES.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		swiftpage.btn_top_save.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_for_modified_scenario() {
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.waitUntilClickable().click();
//		waitABit(3000);
//		WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
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
//	}
//
//	@Step
//	public void i_reassign_and_complete_all_the_generated_tasks() {
//		String Product = getDriver().findElement(By.xpath(
//				"//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[1]/td[5]/span"))
//				.getText();
//		System.out.println("Product Available at First Line : " + Product);
//		if (Product.contains("Wholesale UNI")) {
//			customClickableWait(swiftpage.btn_first_product);
//			swiftpage.btn_first_product.click();
//			waitABit(1000);
//			customClickableWait(swiftpage.btn_first_sub_product);
//			swiftpage.btn_first_sub_product.click();
//			waitABit(3000);
//			customwaitforpageloading(swiftpage);
//			swiftpage.btn_product_uni.click();
//			waitABit(2000);
//			swiftpage.btn_attributes_edit.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(5000);
//			swiftpage.ddl_bandwidth_edit.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(5000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//			swiftpage.btn_end_user_CLLI_update_save.click();
//			waitABit(2000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(1000);
//			customClickableWait(swiftpage.btn_second_product);
//			swiftpage.btn_second_product.click();
//			waitABit(2000);
//			customClickableWait(swiftpage.btn_second_sub_product);
//			swiftpage.btn_second_sub_product.click();
//			waitABit(2000);
//			customwaitforpageloading(swiftpage);
//			swiftpage.btn_product_ovc.click();
//			waitABit(5000);
//			swiftpage.btn_attributes_edit.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(3000);
//			swiftpage.ddl_bandwidth_edit_ovc.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(5000);
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(1000);
//		} else {
//			customClickableWait(swiftpage.btn_first_product);
//			swiftpage.btn_first_product.click();
//			waitABit(1000);
//			customClickableWait(swiftpage.btn_first_sub_product);
//			swiftpage.btn_first_sub_product.click();
//			waitABit(3000);
//			customwaitforpageloading(swiftpage);
//			swiftpage.btn_product_ovc.click();
//			waitABit(2000);
//			swiftpage.btn_attributes_edit.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(5000);
//			swiftpage.ddl_bandwidth_edit.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(5000);
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(1000);
//			customClickableWait(swiftpage.btn_second_product);
//			swiftpage.btn_second_product.click();
//			waitABit(2000);
//			customClickableWait(swiftpage.btn_second_sub_product);
//			swiftpage.btn_second_sub_product.click();
//			waitABit(2000);
//			customwaitforpageloading(swiftpage);
//			swiftpage.btn_product_uni.click();
//			waitABit(1000);
//			swiftpage.btn_attributes_edit.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(3000);
//			swiftpage.ddl_bandwidth_edit.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(5000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//			swiftpage.btn_end_user_CLLI_update_save.click();
//			waitABit(2000);
//			customwaitforpageloading(swiftpage);
//			customClickableWait(swiftpage.btn_top_save);
//			swiftpage.btn_top_save.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(1000);
//		}
//		/*
//		 * waitABit(1000); swiftpage.btn_contacts.click();
//		 * swiftpage.tbx_add_contact.sendKeys("Abhishek Tripathi"); waitABit(2000);
//		 * getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//		 * waitABit(2000); swiftpage.tbx_contact_role.click();
//		 * swiftpage.cbx_contact_role_select.click(); waitABit(2000);
//		 * swiftpage.tbx_contact_section.click(); waitABit(2000);
//		 * swiftpage.cbx_contact_section_1.click();
//		 * swiftpage.cbx_contact_section_2.click();
//		 * swiftpage.cbx_contact_section_3.click(); waitABit(2000);
//		 * swiftpage.btn_contacts.click(); customwaitforpageloading(swiftpage);
//		 * waitABit(5000);
//		 */
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		swiftpage.lnk_order_package_1st_task.click();
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("1st Task Reassigned to Me");
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		swiftpage.lnk_order_package_1st_task.click();
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("1st Task Completed");
//		System.out.println("Waiting for 2nd Task to Generate");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 2 of 2 items"));
//			System.out.println("2nd Task Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_second);
//		for (int i = 0; i < 5; i++) {
//			String SecondTask = getDriver()
//					.findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
//			System.out.println("Second Task Status : " + SecondTask);
//			if (SecondTask.contains("Ready")) {
//				System.out.println("Second Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Second Task is Not Ready to be Validated");
//			}
//		}
//		swiftpage.lnk_order_package_second.click();
//		for (int k = 0; k < 2; k++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			System.out.println("User for Second Task : " + User);
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("2nd Task Already Impersonating to Raju");
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
//				waitABit(2000);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_second);
//		swiftpage.lnk_order_package_second.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("2nd Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_second);
//		swiftpage.lnk_order_package_second.click();
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("Waiting for 3rd & 4th Task to Generate");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 4 of 4 items"));
//			System.out.println("3rd & 4th Task Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_fourth);
//		for (int i = 0; i < 5; i++) {
//			String FourthTask = getDriver()
//					.findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[5]/td[4]/span")).getText();
//			System.out.println("Fourth Task Status : " + FourthTask);
//			if (FourthTask.contains("Ready")) {
//				System.out.println("Fourth Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Fourth Task is Not Ready to be Validated");
//			}
//		}
//		swiftpage.lnk_order_package_fourth.click();
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
//				waitABit(2000);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_fourth);
//		swiftpage.lnk_order_package_fourth.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("4th Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_fourth);
//		swiftpage.lnk_order_package_fourth.click();
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("4th Task Completed");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 4 of 4 items"));
//			System.out.println("3rd & 4th Task Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_third);
//		for (int i = 0; i < 5; i++) {
//			String ThirdTask = getDriver()
//					.findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[4]/td[4]/span")).getText();
//			System.out.println("Third Task Status : " + ThirdTask);
//			if (ThirdTask.contains("Ready")) {
//				System.out.println("Third Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Third Task is Not Ready to be Validated");
//			}
//		}
//		swiftpage.lnk_order_package_third.click();
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
//				waitABit(2000);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_third);
//		swiftpage.lnk_order_package_third.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("3rd Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_third);
//		swiftpage.lnk_order_package_third.click();
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("3rd Task Completed");
//	}
//
//	@Step
//	public void all_tasks_should_be_completed_and_order_should_move_to_GCA() {
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 5 of 5 items"));
//			System.out.println("Credit Check");
//			System.out.println("Order Pushed to GCA");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		getDriver().close();
//	}
//
//	@Step
//	public void i_search_the_Order_Package_ID_in_GCA_for_modified() {
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
//	public void i_search_the_Order_Package_ID_in_ISM_for_modified() {
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
//	public void i_search_order_package_ID_in_project_list_page_for_modified() {
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
//	public void i_process_the_technical_data_gathering_for_modified_Eaccess() {
//		System.out.println("******** TDG is Being Started **********");
//		String Service_Group = getDriver()
//				.findElement(By.xpath("//div[@data-uxf-point='name'][contains(.,'Service Group')]")).getText();
//		System.out.println("Service Groupp Details : " + Service_Group);
//		for (int i = 0; i < 100; i++) {
//			String TDG = getDriver().findElement(By.xpath("(//a[@class='activityName'])[1]")).getText();
//			System.out.println("TDG Status :" + TDG);
//			if (!TDG.contains("Technical Data Gathering")) {
//				asriHistoryActivityPage.lnk_TDG_refresh.click();
//				waitABit(5000);
//			} else {
//				System.out.println("TDG Task Available");
//				break;
//			}
//		}
//		customClickableWait(asriHistoryActivityPage.lnk_TDG);
//		asriHistoryActivityPage.lnk_TDG.click();
//		System.out.println("TDG Clicked");
//		WaitForPageToLoad();
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		customClickableWait(asriTDGPage.ddl_EAccess);
//		asriTDGPage.ddl_EAccess.click();
//		customClickableWait(asriTDGPage.lnk_OVC);
//		asriTDGPage.lnk_OVC.click();
//		waitABit(5000);
//		asriTDGPage.ddl_Protection_Type_OVC.click();
//		asriTDGPage.ddl_selectNetwork.click();
//		waitABit(2000);
//		asriTDGPage.ddl_VLAN_COS.click();
//		asriTDGPage.ddl_VLAN_COS_yes.click();
//		waitABit(2000);
//		asriTDGPage.ddl_VLAN_ID.click();
//		asriTDGPage.ddl_VLAN_ID_yes.click();
//		waitABit(2000);
//		asriTDGPage.ddl_S_VLAN.click();
//		asriTDGPage.ddl_S_VLAN_yes.click();
//		waitABit(2000);
//		asriTDGPage.btn_save.click();
//		System.out.println("OVC Save is Clicked ");
//		customwaitforpageloading();
//		asriTDGPage.lnk_UNI.click();
//		System.out.println("clicked on UNI");
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
//		System.out.println("UNI Save is Clicked ");
//		customwaitforpageloading();
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloading();
//		waitABit(5000);
//	}
//
//	@Step
//	public void the_product_should_be_staged_at_TDG_for_modified() {
//		try {
//			String Validation_Result = getDriver().findElement(By.xpath("//textarea[@readonly='true']")).getText();
//			if (Validation_Result.contains("No Validation Exception!")) {
//				System.out.println("No Validation Exception!");
//				getDriver().switchTo().parentFrame();
//				asriTDGPage.btn_complete.click();
//				waitABit(10000);
//				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(200));
//				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='gtSavePopup']")));
//				waitABit(5000);
//				getDriver().switchTo().parentFrame();
//				System.out.println("clicked on complted");
//				System.out.println("********* Technical Data gathering function is completed **********");
//			} else {
//				System.out.println("Validation Incomplete");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}
