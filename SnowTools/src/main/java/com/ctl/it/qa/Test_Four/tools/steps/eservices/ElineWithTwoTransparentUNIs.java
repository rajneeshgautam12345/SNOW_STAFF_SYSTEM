//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ExistingOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.LoginPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.NewOpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.OpportunityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg2Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg3Page;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkgPage;
//import com.ctl.it.qa.Test_Four.tools.pages.eservices.SwiftPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import io.cucumber.datatable.DataTable;
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//
//@SuppressWarnings("serial")
//public class ElineWithTwoTransparentUNIs extends BaseStep {
//	LoginPage loginpage;
//	OpportunityPage opportunitypage;
//	NewOpportunityPage newopportunitypage;
//	ProductPage productpage;
//	ProductPkgPage productpkgpage;
//	ProductPkg2Page productpkg2page;
//	ProductPkg3Page productpkg3page;
//	ExistingOpportunityPage existingopportunitypage;
//	SwiftPage swiftpage;
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	IntDataContainer Container1 = envData.getContainer("SFDC1");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	String opportunityid = null;
//	String businessorderid = null;
//	String sess = null;
//	String sess2 = null;
//
//	@Step
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_two_transparent_UNIs(
//			String a_end_eline, String z_end_eline, String Building_Ex_1, String Building_Ex_2, String ENV) {
//		waitABit(5000);
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		System.out.println("Creating New Product Package");
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(a_end_eline);
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
//		waitABit(3000);
//		customClickableWait(productpkg3page.lst_product_uni);
//		productpkg3page.lst_product_uni.click();
//		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("1st Product Selected : " + firstproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_bandwidth);
//		productpkg3page.lst_bandwidth.click();
//		productpkg3page.lst_bandwidth_1gbps.click();
//		customwaitforpageloading(productpkg3page);
//		String bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Bandwidth Entered : " + bandwidth);
//		waitABit(3000);
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.ddl_uni_type);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		waitABit(3000);
//		productpkg3page.ddl_uni_type_transparent.click();
//		// productpkg3page.ddl_uni_type_multiplexed.click();
//		customwaitforpageloading(productpkg3page);
//		String unitype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype);
//		if (Building_Ex_1.contains("No")) {
//			WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//			String Building_Text = Building.getText();
//			System.out.println("Building : " + Building_Text);
//			customwaitforpageloading(productpkg3page);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Extended")) {
//				System.out.println("Updating Building");
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
//			customwaitforpageloading(productpkg3page);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
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
//		}
//		waitABit(1000);
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		System.out.println("********************UNI 1 Added for A end Location*******************");
//		WaitForPageToLoad();
//		waitABit(5000);
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		productpkgpage.tbx_address.sendKeys(z_end_eline);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
//		// productpkgpage.cbx_box_3.waitUntilClickable().click();
//		productpkgpage.cbx_box_2.waitUntilClickable().click();
//		customClickableWait(productpkgpage.btn_next);
//		productpkgpage.btn_next.waitUntilClickable().click();
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Z end Address Selected");
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(3000);
//		customClickableWait(productpkg3page.lst_product_uni);
//		productpkg3page.lst_product_uni.click();
//		String secondproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("2nd Product Selected : " + secondproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		waitABit(3000);
//		customClickableWait(productpkg3page.lst_bandwidth);
//		productpkg3page.lst_bandwidth.click();
//		productpkg3page.lst_bandwidth_1gbps.click();
//		customwaitforpageloading(productpkg3page);
//		String bandwidth2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Bandwidth Entered : " + bandwidth2);
//		waitABit(3000);
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.ddl_uni_type);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		waitABit(3000);
//		productpkg3page.ddl_uni_type_transparent.click();
//		// productpkg3page.ddl_uni_type_multiplexed.click();
//		customwaitforpageloading(productpkg3page);
//		String unitype2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype2);
//		if (Building_Ex_2.contains("No")) {
//			WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//			String Building_Text = Building.getText();
//			System.out.println("Building : " + Building_Text);
//			customwaitforpageloading(productpkg3page);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
//				Building.click();
//				waitABit(1000);
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//				waitABit(1000);
//				customwaitforpageloading(productpkg3page);
//			}
//			if (Building_Text.contains("Extended")) {
//				System.out.println("Updating Building");
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
//			customwaitforpageloading(productpkg3page);
//			waitABit(1000);
//			if (Building_Text.contains("- Select -")) {
//				System.out.println("Updating Building");
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
//		}
//		waitABit(1000);
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		System.out.println("********************UNI 2 Added for Z end Location*******************");
//		WaitForPageToLoad();
//		waitABit(5000);
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		customwaitforpageloading(productpkgpage);
//		shouldExist(productpkgpage);
//		waitABit(1000);
//		customClickableWait(productpkgpage.cbx_box);
//		productpkgpage.cbx_box.waitUntilClickable().click();
//		waitABit(3000);
//		customClickableWait(productpkgpage.btn_next);
//		productpkgpage.btn_next.waitUntilClickable().click();
//		customwaitforpageloading(productpkg3page);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_evc);
//		productpkg3page.lst_product_evc.waitUntilClickable().click();
//		String thirdproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("3rd Product Selected : " + thirdproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.ddl_add_1);
//		productpkg3page.ddl_add_1.click();
//		waitABit(2000);
//		try {
//			List<WebElement> List = getDriver().findElements(By.xpath("//*[@id='Address1_listbox']/li"));
//			for (int i = 0; i < List.size(); i++) {
//				waitABit(2000);
//				if (List.get(i).getText().contains(first_address)) {
//					waitABit(2000);
//					List.get(i).click();
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("catch");
//		} finally {
//			System.out.println("A end Location is Selected at Address 1");
//		}
//		waitABit(2000);
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		System.out.println("Selecting Product at A end Location");
//		String A_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("A Location Value : " + A_Loc_Value);
//		waitABit(2000);
//		if (A_Loc_Value.contains("UNI")) {
//			System.out.println("A Location UNI Already Selected");
//		} else {
//			System.out.println("Selecting UNI at A Location");
//			productpkg3page.ddl_a_loc.waitUntilClickable().click();
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//			waitABit(8000);
//			/*
//			 * WebDriverWait wait2 = new WebDriverWait(getDriver(), 200);
//			 * wait2.until(ExpectedConditions.textToBe(By.
//			 * xpath("(//div[@data-bind='text: ScenarioMessage'])[1]"),
//			 * "All possible related packages have been loaded."));
//			 */
//			customClickableWait(productpkg3page.rbn_add_1);
//			waitABit(5000);
//			productpkg3page.rbn_add_1.waitUntilClickable().click();
//			customwaitforpageloading(productpkg3page);
//		}
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Selecting Products at Z end Location");
//		String Z_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]")).getText();
//		System.out.println("Z Location Value : " + Z_Loc_Value);
//		if (!Z_Loc_Value.contains("UNI")) {
//			System.out.println("Selecting UNI at Z Location");
//			customwaitforpageloading(productpkg3page);
//			productpkg3page.ddl_z_loc.click();
//			waitABit(8000);
//			/*
//			 * WebDriverWait wait3 = new WebDriverWait(getDriver(), 200);
//			 * wait3.until(ExpectedConditions.textToBePresentInElementLocated(By.
//			 * xpath("(//div[@data-bind='text: ScenarioMessage'])[2]"),
//			 * "All possible related packages have been loaded."));
//			 */
//			customClickableWait(productpkg3page.rbn_add_z);
//			waitABit(5000);
//			productpkg3page.rbn_add_z.click();
//			customwaitforpageloading(productpkg3page);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//		} else {
//			System.out.println("UNI Already Selected at Z Location");
//		}
//		/*
//		 * try {
//		 * 
//		 * String Span_Type =
//		 * getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		 * 
//		 * System.out.println("Span_Type : "+Span_Type);
//		 * 
//		 * if (Span_Type.contains("Intermarket")) {
//		 * System.out.println("Span Type is Alredy Intermarket"); } else {
//		 * productpkg3page.ddl_span_type.click();
//		 * getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		 * 
//		 * } } catch (Exception e) { System.out.println(e); }
//		 */
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_evc);
//		WebElement EVC = getDriver().findElement(By.xpath("(//span[@class='k-input'])[9]"));
//		String EVC_Text = EVC.getText();
//		System.out.println("EVC Type : " + EVC_Text);
//		if (!EVC_Text.contains("EVPL")) {
//			System.out.println("Updating EVC");
//			waitABit(1000);
//			EVC.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		} else {
//			System.out.println("EVC Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		WebElement Bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[10]"));
//		String Bandwidth_Text = Bandwidth.getText();
//		System.out.println("Bandwidth : " + Bandwidth_Text);
//		if (Bandwidth_Text.contains("- Select -")) {
//			System.out.println("Updating Bandwidth");
//			Bandwidth.click();
//			waitABit(1000);
//			// productpkg3page.btn_bandwidth_1gbps.click();
//			waitABit(10000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(3000);
//			customwaitforpageloading(productpkg3page);
//		} else {
//			System.out.println("Bandwidth Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		WebElement Class = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//		String Class_Text = Class.getText();
//		System.out.println("Class : " + Class_Text);
//		if (Class_Text.contains("- Select -")) {
//			System.out.println("Updating Class");
//			waitABit(1000);
//			Class.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		} else {
//			System.out.println("Class Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		customClickableWait(productpkg3page.btn_quick_save);
//		waitABit(1000);
//		productpkg3page.btn_quick_save.waitUntilClickable().click();
//		WaitForPageToLoad();
//		System.out.println("ELine EVC Configured between A & Z end Locations having Two Transparent UNIs");
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_transparent_UNIs(
//			String a_end_clli_transparent, String z_end_clli_transparent) {
//		System.out.println("Updating NDD & CRD");
//		customClickableWait(swiftpage.btn_product_packages);
//		swiftpage.btn_product_packages.waitUntilClickable().click();
//		waitABit(3000);
//		WebElement checkbox = getDriver().findElement(By.id("cbHeader"));
//		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//		js.executeScript("arguments[0].click();", checkbox);
//		customClickableWait(swiftpage.btn_edit_dates);
//		waitABit(3000);
//		swiftpage.btn_edit_dates.waitUntilClickable().click();
//		customClickableWait(swiftpage.tbx_negotiated_date);
//		swiftpage.tbx_negotiated_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_negotiated_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(1000);
//		swiftpage.tbx_requested_date.clear();
//		waitABit(1000);
//		swiftpage.tbx_requested_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(2000);
//		swiftpage.btn_save_dates.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("NDD & CRD Updated");
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_first_sub_product);
//		swiftpage.btn_first_sub_product.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_addresses);
//		swiftpage.btn_addresses.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_first_address_edit_transparent);
//		swiftpage.btn_first_address_edit_transparent.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(2000);
//		System.out.println("Updating Clli 1");
//		swiftpage.aendcllitransparent(a_end_clli_transparent).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		swiftpage.btn_end_user_CLLI_update_save.click();
//		waitABit(3000);
//		customwaitforpageloading();
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 1 Updated");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_address2_edit);
//		swiftpage.btn_second_address2_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 2");
//		swiftpage.zendcllitransparent(z_end_clli_transparent).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 2 Updated");
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_second_product);
//		swiftpage.btn_second_product.waitUntilClickable().click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product);
//		swiftpage.btn_second_sub_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_address_edit);
//		swiftpage.btn_second_address_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 3");
//		swiftpage.zendcllitransparent(z_end_clli_transparent).click();
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
//		System.out.println("CILLI 3 Updated");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_third_product);
//		swiftpage.btn_third_product.waitUntilClickable().click();
//		customClickableWait(swiftpage.btn_third_sub_product);
//		swiftpage.btn_third_sub_product.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_third_address_edit);
//		swiftpage.btn_third_address_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 4");
//		swiftpage.aendcllitransparent(a_end_clli_transparent).click();
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
//		System.out.println("CILLI 4 Updated");
//	}
//
//	@Step
//	public String completed_technical_data_gathering_for_the_submitted_EVC_order_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println("******** TDG is Being Started **********");
//		String instance_id_1 = getDriver()
//				.findElement(By.xpath("//div[@data-uxf-point='name'][contains(.,'Service Group')]")).getText();
//		System.out.println("Service Group Details : " + instance_id_1);
//		String Service_Group = instance_id_1.substring(24, 39);
//		// Service Group Details : SERVICE GROUP-E-PRODUCT-551998790-14948
//		System.out.println("Service Group : " + Service_Group);
//		Serenity.setSessionVariable("Order_ID").to(Service_Group);
//		sess2 = Serenity.sessionVariableCalled("Order_ID");
//		waitABit(3000);
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
//		WaitForPageToLoad(60);
//		customClickableWait(asriTDGPage.btn_assign);
//		waitABit(5000);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		System.out.println("ELINE Dropdown Clicked");
//		customClickableWait(asriTDGPage.lnk_ECV);
//		asriTDGPage.lnk_ECV.click();
//		waitABit(5000);
//		asriTDGPage.ddl_Protection_Type.click();
//		asriTDGPage.ddl_selectNetwork.click();
//		waitABit(2000);
//		asriTDGPage.btn_save.click();
//		customwaitforpageloadingasri(asriTDGPage);
//		System.out.println("EVC Completed");
//		customwaitforpageloading();
//		asriTDGPage.selectUni(0).click();
//		System.out.println("TDG for UNI 1 is being Completed ");
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
//		System.out.println("First UNI Update Completed");
//		customwaitforpageloading();
//		asriTDGPage.selectUni(1).click();
//		System.out.println("TDG for UNI 2 is being Completed");
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
//		System.out.println("Second UNI Update Completed");
//		customwaitforpageloadingasri(asriTDGPage);
//		customwaitforpageloading();
//		String BE1 = test.get("BE1");
//		if (BE1.contains("No")) {
//			System.out.println("No Need to Provide TDG for CAT for First UNI");
//		} else {
//			System.out.println("Updating TDG for CAT for First UNI");
//			asriTDGPage.lnk_Cat1.click();
//			waitABit(1000);
//			asriTDGPage.ddl_cat_interface.click();
//			asriTDGPage.ddl_cat_interface_select.click();
//			waitABit(1000);
//			asriTDGPage.btn_save.click();
//			customwaitforpageloadingasri(asriTDGPage);
//			customwaitforpageloading();
//		}
//		String BE2 = test.get("BE2");
//		if (BE2.contains("No")) {
//			System.out.println("No Need to Provide TDG for CAT for Second UNI");
//		} else {
//			System.out.println("Updating TDG for CAT for Second UNI");
//			asriTDGPage.lnk_Cat2.click();
//			waitABit(1000);
//			asriTDGPage.ddl_cat_interface.click();
//			asriTDGPage.ddl_cat_interface_select.click();
//			waitABit(1000);
//			asriTDGPage.btn_save.click();
//			customwaitforpageloadingasri(asriTDGPage);
//		}
//		waitABit(5000);
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloadingasri(asriTDGPage);
//		waitABit(5000);
//		return Service_Group;
//	}
//}
