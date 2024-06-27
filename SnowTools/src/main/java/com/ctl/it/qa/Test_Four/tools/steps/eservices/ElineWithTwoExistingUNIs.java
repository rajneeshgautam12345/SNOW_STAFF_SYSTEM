//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
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
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//
//@SuppressWarnings("serial")
//public class ElineWithTwoExistingUNIs extends BaseStep {
//	LoginPage loginpage;
//	OpportunityPage opportunitypage;
//	NewOpportunityPage newopportunitypage;
//	ProductPage productpage;
//	ProductPkgPage productpkgpage;
//	ProductPkg2Page productpkg2page;
//	ProductPkg3Page productpkg3page;
//	ExistingOpportunityPage existingopportunitypage;
//	SwiftPage swiftpage;
//	IntDataContainer Container1 = envData.getContainer("SFDC1");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	String opportunityid = null;
//	String businessorderid = null;
//	String sess = null;
//
//	@Step
//	public void i_prepare_the_order_package_with_required_products_for_the_Cllis_with_specified(String a_end_clli,
//			String z_end_clli, String GLMID1, String GLMID2, String existing_uni1, String existing_uni2) {
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
//		swiftpage.tbx_clli_search.sendKeys(a_end_clli + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(GLMID1 + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox3 = getDriver().findElement(By.id(GLMID1));
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
//		swiftpage.tbx_clli_search.sendKeys(z_end_clli + Keys.TAB);
//		waitABit(2000);
//		swiftpage.btn_clli_search.click();
//		waitABit(8000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(GLMID2 + Keys.ENTER);
//		waitABit(2000);
//		WebElement checkbox4 = getDriver().findElement(By.id(GLMID2));
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
//		swiftpage.tbx_search_uni_1.sendKeys(existing_uni1);
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
//					swiftpage.tbx_clli_search.sendKeys(a_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(GLMID1 + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox5 = getDriver().findElement(By.id(GLMID1));
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
//					swiftpage.tbx_clli_search.sendKeys(z_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(GLMID2 + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox6 = getDriver().findElement(By.id(GLMID2));
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
//					swiftpage.tbx_search_uni_1.sendKeys(existing_uni1);
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
////	((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",swiftpage.btn_relationship_save );	
//		waitABit(2000);
////	swiftpage.btn_relationship_save.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_pencil2.click();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.clear();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.sendKeys(existing_uni2);
//		waitABit(2000);
//		swiftpage.btn_search_uni1.click();
//		customwaitforpageloading(swiftpage);
//		try {
//			WebElement error_1 = getDriver().findElement(By.xpath("//div[@class='k-overlay']"));
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
//			wait.until(ExpectedConditions.visibilityOf(error_1));
//			for (int i = 0; i < 10; i++) {
//				if (error_1.isDisplayed()) {
//					customClickableWait(swiftpage.btn_product_packages);
//					swiftpage.btn_product_packages.click();
//					swiftpage.btn_add_psp.click();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(a_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(GLMID1 + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox5 = getDriver().findElement(By.id(GLMID1));
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
//					swiftpage.tbx_clli_search.sendKeys(z_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					swiftpage.btn_glm_dropdown.click();
//					waitABit(2000);
//					swiftpage.btn_filter.click();
//					waitABit(2000);
//					swiftpage.btn_filter_value.sendKeys(GLMID2 + Keys.ENTER);
//					waitABit(2000);
//					WebElement checkbox6 = getDriver().findElement(By.id(GLMID2));
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
//					swiftpage.tbx_search_uni_1.sendKeys(existing_uni2);
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
////	((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",swiftpage.btn_relationship_save );	
//		waitABit(2000);
////	swiftpage.btn_relationship_save.click();
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
////	getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
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
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_two_existing_UNIs(
//			String a_end_eline, String z_end_eline, String existing_uni1, String existing_uni2) {
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		System.out.println("Creating New Product Package");
//		customClickableWait(productpkgpage.tbx_address);
//		productpkgpage.tbx_address.sendKeys(a_end_eline);
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkgpage);
//		waitABit(3000);
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
//		customClickableWait(productpkg3page.lst_product_uni);
//		productpkg3page.lst_product_uni.click();
//		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("1st Product Selected : " + firstproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.lst_bandwidth);
//		productpkg3page.lst_bandwidth.click();
//		productpkg3page.lst_bandwidth_1gbps.click();
//		customwaitforpageloading(productpkg3page);
//		String bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//		System.out.println("Bandwidth Entered : " + bandwidth);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		productpkg3page.ddl_uni_type_transparent.click();
//		// productpkg3page.ddl_uni_type_multiplexed.click();
//		customwaitforpageloading(productpkg3page);
//		String unitype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype);
//		WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//		String Building_Text = Building.getText();
//		System.out.println("Building : " + Building_Text);
//		if (Building_Text.contains("- Select -")) {
//			System.out.println("Updating Building");
//			Building.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building_Text.contains("Extended")) {
//			System.out.println("Updating Building");
//			Building.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building_Text.contains("Standard")) {
//			System.out.println("Building Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		customClickableWait(productpkg3page.btn_quick_save);
//		productpkg3page.btn_quick_save.click();
//		System.out.println("********************UNI 1 Added for A end Location*******************");
//		WaitForPageToLoad();
//		shouldExist(productpage);
//		customClickableWait(productpage.btn_new_product_pkg);
//		productpage.btn_new_product_pkg.click();
//		shouldExist(productpkgpage);
//		productpkgpage.tbx_address.sendKeys(z_end_eline);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		customwaitforpageloading(productpkg3page);
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
//		productpkg3page.lst_product_evc.waitUntilClickable().click();
//		String thirdproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("2nd Product Selected : " + thirdproduct);
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
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Selecting Product at A end Location");
//		try {
//			String A_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[6]")).getText();
//			System.out.println("A Location Value : " + A_Loc_Value);
//			if (A_Loc_Value.contains("UNI")) {
//				System.out.println("A Location UNI Already Selected");
//			} else {
//				System.out.println("Selecting UNI at A Location");
//				productpkg3page.ddl_a_loc.waitUntilClickable().click();
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//				waitABit(2000);
//				WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
//				wait2.until(ExpectedConditions.textToBe(By.xpath("(//div[@data-bind='text: ScenarioMessage'])[1]"),
//						"All possible related packages have been loaded."));
//				customClickableWait(productpkg3page.rbn_add_1);
//				waitABit(2000);
//				productpkg3page.rbn_add_1.waitUntilClickable().click();
//				customwaitforpageloading(productpkg3page);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Selecting Products at Z end Location");
//		try {
//			String Z_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]")).getText();
//			System.out.println("Z Location Value : " + Z_Loc_Value);
//			if (!Z_Loc_Value.contains("UNI")) {
//				System.out.println("Selecting UNI at Z Location");
//				customwaitforpageloading(productpkg3page);
//				productpkg3page.ddl_z_loc.click();
//				waitABit(2000);
//				productpkg3page.btn_existing_uni_inventory.click();
//				waitABit(2000);
//				WebDriverWait wait3 = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
//				wait3.until(ExpectedConditions.textToBePresentInElementLocated(
//						By.xpath("(//div[@data-bind='text: InventoryMessage'])[2]"),
//						"All possible related packages have been loaded."));
//				customClickableWait(productpkg3page.UNI(existing_uni1));
//				waitABit(2000);
//				productpkg3page.UNI(existing_uni1).click();
//				customwaitforpageloading(productpkg3page);
//				getDriver().switchTo().defaultContent();
//				getDriver().switchTo().frame(frame2);
//			} else {
//				System.out.println("UNI Already Selected at Z Location");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		try {
//			String Span_Type = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//			System.out.println("Span_Type : " + Span_Type);
//			if (Span_Type.contains("Intermarket")) {
//				System.out.println("Span Type is Alredy Intermarket");
//			} else {
//				productpkg3page.ddl_span_type.click();
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customwaitforpageloading(productpkg3page);
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_evc);
//		WebElement EVC = getDriver().findElement(By.xpath("(//span[@class='k-input'])[9]"));
//		String EVC_Text = EVC.getText();
//		System.out.println("EVC Type : " + EVC_Text);
//		if (!EVC_Text.contains("EVPL")) {
//			System.out.println("Updating EVC");
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
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
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
//	public void i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_existing_UNIs(String a_end_clli,
//			String z_end_clli) {
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
//		customClickableWait(swiftpage.btn_end_user_CLLI1_transparent);
//		swiftpage.btn_end_user_CLLI1_transparent.click();
//		waitABit(2000);
//		System.out.println("Updating Clli 1");
//		// swiftpage.lnk_end_user_CLLI_ELPSTX98S6T.waitUntilClickable().click();
//		swiftpage.aendclli(a_end_clli).click();
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
//		customClickableWait(swiftpage.btn_end_user_CLLI2_transparent);
//		swiftpage.btn_end_user_CLLI2_transparent.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 2");
//		// swiftpage.lnk_end_user_CLLI_DLLFTXFQSC5.waitUntilClickable().click();
//		swiftpage.zendclli(z_end_clli).click();
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
//		// customClickableWait(swiftpage.btn_addresses);
//		// swiftpage.btn_addresses.click();
//		// waitABit(2000);
//		customClickableWait(swiftpage.btn_second_address_edit);
//		swiftpage.btn_second_address_edit.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.btn_end_user_2CLLI_transparent);
//		swiftpage.btn_end_user_2CLLI_transparent.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 3");
//		// swiftpage.lnk_end_user_CLLI_DLLFTXFQSC5.waitUntilClickable().click();
//		swiftpage.zendclli(z_end_clli).click();
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
//		customClickableWait(swiftpage.btn_end_user_eline_uni2);
//		swiftpage.btn_end_user_eline_uni2.click();
//		waitABit(3000);
//		System.out.println("Updating Clli 4");
//		// swiftpage.lnk_end_user_CLLI_ELPSTX98S6T.waitUntilClickable().click();
//		swiftpage.aendclli(a_end_clli).click();
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
//}
