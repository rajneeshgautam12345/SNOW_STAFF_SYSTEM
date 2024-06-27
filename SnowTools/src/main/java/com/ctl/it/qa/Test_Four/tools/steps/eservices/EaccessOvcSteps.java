//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriLoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriProjectListPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
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
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class EaccessOvcSteps extends BaseStep {
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
//	IntDataContainer Container1 = envData.getContainer("SFDC1");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String opportunityid = null;
//	String businessorderid = null;
//	String sess = null;
//
//	@Step
//	public void i_create_a_scenario_for_the_product_EaccessOvc_for_the_A_end_location_and_Z_end_location_having_existing_ENNI(
//			String a_end_eaccess, String z_end_eaccess, String ENNI, String Building_Ex) {
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		System.out.println("Creating New Product Package");
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(a_end_eaccess);
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkgpage);
//		String first_address = getDriver().findElement(By.xpath("//a[@class='grid-link']")).getText();
//		System.out.println("First Address : " + first_address);
//		waitABit(2000);
//		productpkgpage.cbx_box.waitUntilClickable().click();
//		waitABit(2000);
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
//		waitABit(3000);
//		customClickableWait(productpkg3page.lst_product_wholesaleuni);
//		productpkg3page.lst_product_wholesaleuni.click();
//		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("1st Product Selected : " + firstproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_bandwidth);
//		productpkg3page.lst_bandwidth.click();
//		waitABit(1000);
//		productpkg3page.lst_bandwidth_1gbps.click();
//		customwaitforpageloading(productpkg3page);
//		String bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Bandwidth Entered : " + bandwidth);
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		waitABit(1000);
//		productpkg3page.ddl_uni_type_transparent.click();
////		productpkg3page.ddl_uni_type_multiplexed.click();
//		customwaitforpageloading(productpkg3page);
//		String unitype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype);
//		waitABit(1000);
//		productpkg3page.ddl_evc_type.click();
//		waitABit(1000);
//		productpkg3page.ddl_evc_type_basic.click();
//		customwaitforpageloading(productpkg3page);
//		String evcclass = getDriver().findElement(By.xpath("(//span[@class='k-input'])[9]")).getText();
//		System.out.println("EVC Class Selected : " + evcclass);
//		waitABit(2000);
//		if (Building_Ex.contains("No")) {
//			WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//			String Building_Text = Building.getText();
//			System.out.println("Building : " + Building_Text);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Extended")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Standard")) {
//				System.out.println("Building Already Updated");
//				customwaitforpageloading(productpkg3page);
//			}
//		} else {
//			WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//			String Building_Text = Building.getText();
//			System.out.println("Building : " + Building_Text);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Extended")) {
//				System.out.println("Building Already Updated");
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Standard")) {
//				System.out.println("Updating Building");
//				waitABit(1000);
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//		}
//		waitABit(2000);
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		System.out.println("Wholesale UNI Added for A end Location");
//		WaitForPageToLoad();
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		productpkgpage.tbx_address.sendKeys(z_end_eaccess);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
//		String second_address = getDriver().findElement(By.xpath("(//a[@class='grid-link'])[1]")).getText();
//		System.out.println("Second Address : " + second_address);
//		productpkgpage.cbx_box.waitUntilClickable().click();
//		customClickableWait(productpkgpage.btn_next);
//		productpkgpage.btn_next.waitUntilClickable().click();
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Z end Address Selected");
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_eaccessovc);
//		productpkg3page.lst_product_eaccessovc.click();
//		String secondproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("2nd Product Selected : " + secondproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.ddl_add_1);
//		productpkg3page.ddl_add_1.click();
//		waitABit(1000);
//		if (first_address.contains(second_address)) {
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			System.out.println("Location is Selected at Address 1");
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//			String A_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//			if (A_Loc_Value.contains("E-NNI")) {
//				System.out.println("A Location ENNI Already Selected");
//			} else {
//				System.out.println("Selecting ENNI at A Location");
//				customClickableWait(productpkg3page.ddl_a_loc);
//				productpkg3page.ddl_a_loc.click();
//				waitABit(3000);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//				waitABit(3000);
//				productpkg3page.btn_a_loc_inventory.click();
//				System.out.println("Moved to A Location Inventory");
//				waitABit(30000);
//				for (int i = 0; i < 5; i++) {
//					String inventory_message = getDriver()
//							.findElement(By.xpath("(//span[@class='k-pager-info k-label'])[2]")).getText();
//					System.out.println("Inventory = " + inventory_message);
//					if (inventory_message.contains("No items to display")) {
//						System.out.println("Retrying to get Existing ENNI package");
//						waitABit(1000);
//						productpkg3page.btn_a_loc_inventory_close.click();
//						waitABit(1000);
//						productpkg3page.lst_product_re_entry.click();
//						waitABit(1000);
//						getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP, Keys.ENTER);
//						customwaitforpageloading(productpkg3page);
//						waitABit(1000);
//						productpkg3page.lst_product_re_entry.click();
//						waitABit(1000);
//						getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//						customwaitforpageloading(productpkg3page);
//						customClickableWait(productpkg3page.ddl_add_1);
//						productpkg3page.ddl_add_1.click();
//						waitABit(1000);
//						getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//						waitABit(1000);
//						customwaitforpageloading(productpkg3page);
//						System.out.println("A end Location is Selected again at Address 1");
//						customwaitforpageloading(productpkg3page);
//						waitABit(2000);
//						customClickableWait(productpkg3page.ddl_a_loc);
//						productpkg3page.ddl_a_loc.click();
//						waitABit(2000);
//						getDriver().switchTo().defaultContent();
//						getDriver().switchTo().frame(frame2);
//						waitABit(2000);
//						productpkg3page.btn_a_loc_inventory.click();
//						System.out.println("Moved to A Location Inventory Again");
//						waitABit(30000);
//					} else {
//						System.out.println("Existing ENNI Packages Found");
//						waitABit(2000);
//						customClickableWait(productpkg3page.ENNI(ENNI));
//						productpkg3page.ENNI(ENNI).click();
//						waitABit(2000);
//						customwaitforpageloading(productpkg3page);
//						System.out.println("Required ENNI Package Selected");
//						getDriver().switchTo().defaultContent();
//						getDriver().switchTo().frame(frame2);
//						String Z_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]"))
//								.getText();
//						System.out.println("Z Loc Value : " + Z_Loc_Value);
//						if (!Z_Loc_Value.contains("UNI")) {
//							System.out.println("Selecting UNI at Z Location");
//							productpkg3page.ddl_z_loc.click();
//							waitABit(2000);
//							System.out.println("Moved to Z Location Scenario");
//							waitABit(10000);
//							customClickableWait(productpkg3page.rbn_add_2_2);
//							waitABit(1000);
//							productpkg3page.rbn_add_2_2.click();
//							customwaitforpageloading(productpkg3page);
//							getDriver().switchTo().defaultContent();
//							getDriver().switchTo().frame(frame2);
//						} else {
//							System.out.println("UNI Already Selected at Z Location");
//						}
//						break;
//					}
//				}
//			}
//		} else {
//			try {
//				List<WebElement> List = getDriver().findElements(By.xpath("//*[@id='Address1_listbox']/li"));
//				for (int i = 0; i < List.size(); i++) {
//					waitABit(2000);
//					if (List.get(i).getText().contains(second_address)) {
//						waitABit(2000);
//						List.get(i).click();
//					}
//				}
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			System.out.println("A end Location is Selected at Address 1");
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//			String A_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//			if (A_Loc_Value.contains("E-NNI")) {
//				System.out.println("A Location ENNI Already Selected");
//			} else {
//				System.out.println("Selecting ENNI at A Location");
//				customClickableWait(productpkg3page.ddl_a_loc);
//				productpkg3page.ddl_a_loc.click();
//				waitABit(3000);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//				waitABit(3000);
//				productpkg3page.btn_a_loc_inventory.click();
//				System.out.println("Moved to A Location Inventory");
//				waitABit(5000);
//				customClickableWait(productpkg3page.ENNI(ENNI));
//				productpkg3page.ENNI(ENNI).click();
//				waitABit(2000);
//				customwaitforpageloading(productpkg3page);
//				System.out.println("Required ENNI Package Selected");
//			}
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			String Z_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]")).getText();
//			System.out.println("Z Loc Value : " + Z_Loc_Value);
//			if (!Z_Loc_Value.contains("UNI")) {
//				System.out.println("Selecting UNI at Z Location");
//				productpkg3page.ddl_z_loc.click();
//				waitABit(5000);
//				System.out.println("Moved to Z Location Scenario");
//				customClickableWait(productpkg3page.rbn_add_2_2);
//				waitABit(10000);
//				productpkg3page.rbn_add_2_2.click();
//				customwaitforpageloading(productpkg3page);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//			} else {
//				System.out.println("UNI Already Selected at Z Location");
//			}
//		}
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.ddl_ovc);
//		productpkg3page.ddl_ovc.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		customwaitforpageloading(productpkg3page);
//		String ovctype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("OVC Selected : " + ovctype);
//		waitABit(2000);
//		productpkg3page.ddl_bandwidth_10.click();
//		waitABit(10000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		customwaitforpageloading(productpkg3page);
//		String ovcbandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[9]")).getText();
//		System.out.println("Bandwidth Selected : " + ovcbandwidth);
//		waitABit(2000);
//		customClickableWait(productpkg3page.ddl_ovc_class_2);
//		productpkg3page.ddl_ovc_class_2.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		String ovcclass = getDriver().findElement(By.xpath("(//span[@class='k-input'])[10]")).getText();
//		System.out.println("OVC Class Selected : " + ovcclass);
//		waitABit(1000);
//		// ((JavascriptExecutor)
//		// getDriver()).executeScript("arguments[0].scrollIntoView(true);",productpkg3page.btn_quick_save);
//		waitABit(1000);
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		customwaitforpageloading(productpkg3page);
//		System.out.println("EAccess OVC Configured between A & Z end Locations");
//	}
//
//	@Step
//	public void i_perform_the_profitability_analysis_for_eaccess() {
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
//					.findElement(By.xpath(
//							"//*[@id=\"product-tree-items\"]/table[2]/tfoot/tr/td[4]/div/div[2]/div/div[1]/div[1]"))
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
//		try {
//			for (int i = 0; i < 5; i++) {
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame("quote-iframe");
//				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
//				wait.until(ExpectedConditions.textToBePresentInElementLocated(
//						By.xpath("//*[@id=\"package-summary-grid\"]/div[2]/table/tbody/tr[1]/td[10]/span"),
//						"Profit Approval OK"));
//				String Profit = getDriver()
//						.findElement(By.xpath("//*[@id=\"package-summary-grid\"]/div[2]/table/tbody/tr[1]/td[10]/span"))
//						.getText();
//				if (Profit.contains("Profit Approval OK")) {
//					System.out.println("Profit Approval OK");
//				} else {
//					System.out.println("Profit Not Passed");
//					customClickableWait(productpage.btn_discount_profitability);
//					productpage.btn_discount_profitability.click();
//					System.out.println("Discounting Profitability Checking Again");
//					customClickableWait(productpage.btn_save);
//					productpage.btn_save.click();
//					customwaitforpageloading(productpage);
//					getDriver().switchTo().defaultContent();
//					getDriver().switchTo().frame("quote-iframe");
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_and_update_the_Clli_for_A_End(String a_end_clli_eaccess) {
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
//		waitABit(2000);
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
//		customClickableWait(swiftpage.btn_address2_edit);
//		swiftpage.btn_address2_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 1");
//		// swiftpage.lnk_ovc_end_user_CLLI1_select_LABBRMCOS00.waitUntilClickable().click();
//		swiftpage.aendcllieaccess(a_end_clli_eaccess).click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CILLI Updated for OVC");
//		customClickableWait(swiftpage.btn_second_product);
//		swiftpage.btn_second_product.click();
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_second_sub_product);
//		swiftpage.btn_second_sub_product.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_address1_edit);
//		swiftpage.btn_second_address1_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 2");
//		// swiftpage.lnk_ovc_end_user_CLLI1_select_LABBRMCOS00.waitUntilClickable().click();
//		swiftpage.aendcllieaccess(a_end_clli_eaccess).click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("End User CLLI Updated for Second Product");
//	}
//
//	@Step
//	public void i_process_the_technical_data_gathering_for_eaccess(String Building_Ex) {
//		System.out.println("******** TDG is Being Started **********");
//		String Service_Group = getDriver()
//				.findElement(By.xpath("//div[@data-uxf-point='name'][contains(.,'Service Group')]")).getText();
//		System.out.println("Service Groupp Details : " + Service_Group);
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
//		waitABit(25000);
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
//		if (Building_Ex.contains("No")) {
//			System.out.println("No Need to Provide TDG for CAT for Wholesale UNI");
//		} else {
//			asriTDGPage.lnk_Cat1.click();
//			waitABit(1000);
//			asriTDGPage.ddl_cat_interface.click();
//			asriTDGPage.ddl_cat_interface_select.click();
//			waitABit(1000);
//			asriTDGPage.btn_save.click();
//			customwaitforpageloadingasri(asriTDGPage);
//			customwaitforpageloading();
//		}
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloading();
//	}
//}
