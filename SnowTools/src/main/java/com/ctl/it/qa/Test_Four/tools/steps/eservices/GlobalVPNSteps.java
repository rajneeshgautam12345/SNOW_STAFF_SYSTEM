//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Iterator;
//import java.util.List;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ExistingOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.NewOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg2Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg3Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkgPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.SwiftPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class GlobalVPNSteps extends BaseStep {
//	NewOpportunityPage newopportunitypage;
//	ProductPage productpage;
//	ProductPkgPage productpkgpage;
//	ProductPkg2Page productpkg2page;
//	ProductPkg3Page productpkg3page;
//	ExistingOpportunityPage existingopportunitypage;
//	SwiftPage swiftpage;
//	IntDataContainer Container1 = envData.getContainer("TEST2");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String orderpackageid = null;
//
//	@Step
//	public void i_create_a_scenario_for_the_product_Global_VPN_for_the_A_end_location_and_add_an_optional_product_as(
//			String a_end, String Router) {
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		System.out.println("Creating New Product Package");
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(a_end);
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(200));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkgpage);
//		String first_address = getDriver().findElement(By.xpath("//a[@class='grid-link']")).getText();
//		System.out.println("First Address : " + first_address);
//		productpkgpage.cbx_box.click();
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
//		customClickableWait(productpkg3page.lst_product_ipvpn);
//		productpkg3page.lst_product_ipvpn.click();
//		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("1st Product Selected : " + firstproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(3000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		waitABit(3000);
//		customClickableWait(productpkg3page.ddl_ipvpn_access);
//		productpkg3page.ddl_ipvpn_access.selectByVisibleText("Ethernet 100Mbps ");
//		waitABit(3000);
//		customwaitforpageloadingipvpn(productpkg3page);
//		customClickableWait(productpkg3page.ddl_ipvpn_building);
//		productpkg3page.ddl_ipvpn_building.selectByVisibleText("Standard Delivery - To the MPoE (Customer Provided) ");
//		waitABit(3000);
//		customwaitforpageloadingipvpn(productpkg3page);
//		waitABit(5000);
//		productpkg3page.ddl_ipvpn_multiservice.selectByVisibleText("Aggregate ");
//		waitABit(3000);
//		customwaitforpageloadingipvpn(productpkg3page);
//		waitABit(5000);
//		customClickableWait(productpkg3page.btn_ipvpn_continue);
//		productpkg3page.btn_ipvpn_continue.click();
//		waitABit(3000);
//		customwaitforpageloadingipvpn(productpkg3page);
//		System.out.println("Add Internet VPN");
//		waitABit(120000);
//		String name = Router;
//		if (name.contains("Yes")) {
//			System.out.println("Router Required : " + name);
//			System.out.println("Router Required");
//			waitABit(3000);
//			customClickableWait(productpkg3page.ddl_ipvpn_optional_router);
//			productpkg3page.ddl_ipvpn_optional_router.selectByVisibleText("Managed Router ");
//			waitABit(3000);
//			customwaitforpageloadingipvpn(productpkg3page);
//			waitABit(3000);
//			customClickableWait(productpkg3page.btn_ipvpn_router_add);
//			productpkg3page.btn_ipvpn_router_add.click();
//			waitABit(3000);
//			customwaitforpageloadingipvpn(productpkg3page);
//			waitABit(1000);
//			productpkg3page.ddl_ipvpn_router_manufacturer.selectByVisibleText(" Adtran ");
//			waitABit(3000);
//			customwaitforpageloadingipvpn(productpkg3page);
//			productpkg3page.ddl_ipvpn_router_chassis.selectByVisibleText(" INV4430 ");
//			waitABit(3000);
//			customwaitforpageloadingipvpn(productpkg3page);
//			productpkg3page.btn_ipvpn_router_add_save.click();
//			customwaitforpageloadingipvpn(productpkg3page);
//			waitABit(5000);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//		} else {
//			System.out.println("Router Not Required");
//		}
//		waitABit(3000);
//		customClickableWait(productpkg3page.btn_ipvpn_finish);
//		productpkg3page.btn_ipvpn_finish.click();
//		waitABit(5000);
//		customwaitforpageloadingipvpn(productpkg3page);
//		customwaitforpageloading(productpkg3page);
//	}
//
//	@Step
//	public void i_perform_the_profitability_analysis_for_globalvpn() {
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
//	public void i_add_a_new_product_to_the_product_package_as_VRF_ID(String a_end, String a_end_clli) {
//		orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
//		System.out.println("Order Package ID = " + orderpackageid);
//		System.out.println("Adding VRF ID to the Product Package");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_userinfo);
//		swiftpage.btn_userinfo.click();
//		waitABit(5000);
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//		waitABit(3000);
//		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//				.sendKeys("Madahalli Chowdegowda, Raju");
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		swiftpage.btn_impersonate.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		customClickableWait(swiftpage.btn_add_psp);
//		swiftpage.btn_add_psp.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.tbx_clli_search);
//		swiftpage.tbx_clli_search.sendKeys(a_end);
//		waitABit(5000);
//		/*
//		 * WebDriverWait wait = new WebDriverWait(getDriver(), 200);
//		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
//		 * xpath("(//span[@class='k-icon k-i-loading'])[3]")));
//		 */
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customClickableWait(swiftpage.btn_clli_search);
//		swiftpage.btn_clli_search.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//				swiftpage.cbx_clli_select);
//		waitABit(1000);
//		customClickableWait(swiftpage.cbx_clli_select);
//		swiftpage.cbx_clli_select.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_next);
//		swiftpage.btn_next.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_new_package);
//		swiftpage.btn_new_package.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.ddl_new_package);
//		swiftpage.ddl_new_package.click();
//		customClickableWait(swiftpage.lnk_VRF_ID);
//		swiftpage.lnk_VRF_ID.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.ddl_vrf_address);
//		swiftpage.ddl_vrf_address.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.tbx_network_name);
//		swiftpage.tbx_network_name.sendKeys("Test_" + orderpackageid);
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_next_second);
//		swiftpage.btn_next_second.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_next);
//		swiftpage.btn_next.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_save_vrf);
//		swiftpage.btn_save_vrf.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//		customClickableWait(swiftpage.lnk_docs);
//		swiftpage.lnk_docs.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.lnk_sof);
//		swiftpage.lnk_sof.click();
//		customClickableWait(swiftpage.btn_delete_sof);
//		swiftpage.btn_delete_sof.click();
//		waitABit(3000);
//		try {
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10000));
//			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
//				System.out.println("Alert is Not Present");
//			} else {
//				Alert alert = getDriver().switchTo().alert();
//				alert.accept();
//				System.out.println("Alert was Present and Accepted");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_attach_doc);
////	swiftpage.btn_attach_doc.click();
//		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ISE.text";
//		System.out.println(FilePath);
//		getDriver().findElement(By.id("fileUploadInput")).sendKeys(FilePath);
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_doc_type);
//		swiftpage.ddl_doc_type.click();
//		customClickableWait(swiftpage.ddl_doc_ise);
//		swiftpage.ddl_doc_ise.click();
//		waitABit(3000);
//		swiftpage.btn_save_doc.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_close_window.click();
//		getDriver().navigate().refresh();
//		WaitForPageToLoad(60);
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_product_ipvpn_logical);
//		swiftpage.btn_second_product_ipvpn_logical.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product_ipvpn_logical);
//		swiftpage.btn_second_sub_product_ipvpn_logical.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_details);
//		swiftpage.btn_details.click();
//		waitABit(2000);
//		String CBP_BAN = getDriver().findElement(By.xpath("//a[@ng-click='OpenExistingAccountPage()']")).getText();
//		System.out.println("CBP BAN :" + CBP_BAN);
//		customClickableWait(swiftpage.lnk_vrf_id_edit);
//		swiftpage.lnk_vrf_id_edit.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_auto_fill);
//		swiftpage.btn_auto_fill.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_search_vrf);
//		swiftpage.btn_search_vrf.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		WebElement VRF_NAME = getDriver()
//				.findElement(By.xpath("//td[@role='gridcell'][contains(.,'Test_" + orderpackageid + "')]"));
//		waitABit(3000);
//		VRF_NAME.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_vrf_select_save);
//		swiftpage.btn_vrf_select_save.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		getDriver().navigate().refresh();
//		WaitForPageToLoad(60);
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_first_sub_product_vrf);
//		swiftpage.btn_first_sub_product_vrf.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_details);
//		swiftpage.btn_details.click();
//		customClickableWait(swiftpage.lnk_ban_edit);
//		swiftpage.lnk_ban_edit.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.lnk_ban_new);
//		swiftpage.lnk_ban_new.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.tbx_ban_new);
//		swiftpage.tbx_ban_new.sendKeys(CBP_BAN);
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_ban_search);
//		swiftpage.btn_ban_search.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.lnk_ban_first);
//		swiftpage.lnk_ban_first.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_ban_ok);
//		swiftpage.btn_ban_ok.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_ban_save);
//		swiftpage.btn_ban_save.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_addresses);
//		swiftpage.btn_addresses.click();
//		waitABit(8000);
//		customClickableWait(swiftpage.btn_uni_address_edit);
//		swiftpage.btn_uni_address_edit.click();
//		waitABit(10000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 1");
//		swiftpage.aendclli_gvpn(a_end_clli).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 1 Updated");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_product_ipvpn_logical);
//		swiftpage.btn_second_product_ipvpn_logical.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product_ipvpn_logical);
//		swiftpage.btn_second_sub_product_ipvpn_logical.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_uni_address_edit);
//		swiftpage.btn_uni_address_edit.click();
//		waitABit(8000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 2");
//		swiftpage.aendclli_gvpn(a_end_clli).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//		swiftpage.btn_end_user_CLLI_update_save.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 2 Updated");
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_third_product);
//		swiftpage.btn_third_product.waitUntilClickable().click();
//		customClickableWait(swiftpage.btn_third_sub_product);
//		swiftpage.btn_third_sub_product.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_uni_address_edit);
//		swiftpage.btn_uni_address_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 3");
//		swiftpage.aendclli_gvpn(a_end_clli).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//		swiftpage.btn_end_user_CLLI_update_save.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 3 Updated");
//	}
//
//	@Step
//	public void i_set_the_ndd_and_crd_for_global_vpn() {
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
//	public void i_reassign_and_complete_all_the_generated_tasks_for_global_vpn() {
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_contacts);
//		swiftpage.btn_contacts.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
//		List<WebElement> Contacts = getDriver()
//				.findElements(By.xpath("//span[contains(@class,'contactName ng-binding')]"));
//		System.out.println("Number of Contacts Added = " + Contacts.size());
//		Iterator<WebElement> itr = Contacts.iterator();
//		waitABit(1000);
//		while (itr.hasNext()) {
//			waitABit(1000);
//			System.out.println(itr.next().getText());
//		}
//		/*
//		 * if (Contacts.size()>0) {
//		 * System.out.println("Contacts Already Attached to the Product Package");
//		 * waitABit(2000);
//		 * getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP); }
//		 * 
//		 * else { System.out.println("Contact Needs to be Updated"); waitABit(2000);
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
//		 * 
//		 * }
//		 */
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		swiftpage.lnk_order_package_1st_task.click();
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("1st Task Reassigned to Me");
//		waitABit(2000);
//		customClickableWait(swiftpage.lnk_order_package_1st_task);
//		waitABit(2000);
//		swiftpage.lnk_order_package_1st_task.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(2000);
//		swiftpage.btn_complete.click();
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("1st Task Completed");
//		System.out.println("Waiting for Other 4 Tasks to Generate");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 4 of 4 items"));
//			System.out.println("All the 4 Tasks Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_second);
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
//			System.out.println("User for Second Task : " + User);
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("2nd Task Already Impersonating to Raju");
//				break;
//			} else {
//				waitABit(3000);
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(5000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				waitABit(3000);
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
//		waitABit(5000);
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
//		System.out.println("4th Tasks Completed");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 4 of 4 items"));
//			System.out.println("3rd & 4th Tasks are Available");
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
//				System.out.println("3rd Task Already Impersonating to Raju");
//				break;
//			} else {
//				waitABit(3000);
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(5000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				waitABit(2000);
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
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 5 of 5 items"));
//			System.out.println("5th Task Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customClickableWait(swiftpage.lnk_order_package_fifth);
//		for (int i = 0; i < 5; i++) {
//			String FifthTask = getDriver()
//					.findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[6]/td[4]/span")).getText();
//			System.out.println("Third Task Status : " + FifthTask);
//			if (FifthTask.contains("Ready")) {
//				System.out.println("Fifth Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Fifth Task is Not Ready to be Validated");
//			}
//		}
//		swiftpage.lnk_order_package_fifth.click();
//		for (int k = 0; k < 2; k++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("4th Task Already Impersonating to Raju");
//				break;
//			} else {
//				waitABit(3000);
//				customClickableWait(swiftpage.btn_userinfo);
//				swiftpage.btn_userinfo.click();
//				waitABit(5000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
//				waitABit(2000);
//				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
//						.sendKeys("Madahalli Chowdegowda, Raju");
//				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//				waitABit(2000);
//				swiftpage.btn_impersonate.click();
//				customwaitforpageloading(swiftpage);
//				waitABit(2000);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_fifth);
//		swiftpage.lnk_order_package_fifth.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("5th Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_fifth);
//		swiftpage.lnk_order_package_fifth.click();
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("5th Task Completed");
//	}
//
//	@Step
//	public void i_process_the_technical_data_gathering_for_Global_VPN() {
//	}
//}
