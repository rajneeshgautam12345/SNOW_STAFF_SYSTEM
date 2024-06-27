//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Map;
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
//public class SwiftEaccessOvcSteps extends BaseStep {
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
//	String sess2 = null;
//	String orderpackageid = null;
//
//	@Step
//	public void i_prepare_the_order_package_in_swift_for_EVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		String Network_1 = test.get("Network_1");
//		String Uni_Type1 = test.get("Uni_Type1");
//		String BE1 = test.get("BE1");
//		String GLMID1 = test.get("GLMID1");
//		String GLMID2 = test.get("GLMID2");
//		String a_end_clli = test.get("a_end_clli");
//		String z_end_clli = test.get("z_end_clli");
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
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_glm_dropdown.click();
//		waitABit(2000);
//		swiftpage.btn_filter.click();
//		waitABit(2000);
//		swiftpage.btn_filter_value.sendKeys(GLMID1 + Keys.ENTER);
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
//		waitABit(2000);
//		swiftpage.ddl_wholesaleuni_selected.click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_address.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		if (Network_1.contains("Onnet")) {
//			waitABit(3000);
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
//			customwaitforpageloading(swiftpage);
//		}
//		if (Network_1.contains("Onnet")) {
//			waitABit(2000);
//			swiftpage.ddl_EVC_class1.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			waitABit(2000);
//			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//			customwaitforpageloading(swiftpage);
//		} else {
//			System.out.println("Network is offnet");
//			waitABit(2000);
//			swiftpage.ddl_EVC_class1.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			waitABit(2000);
//			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//			customwaitforpageloading(swiftpage);
//		}
//		waitABit(2000);
//		swiftpage.btn_next_2.click();
//		waitABit(5000);
//		swiftpage.btn_next.click();
//		waitABit(5000);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("**********A End Uni Configured**********");
//		String UNI_1 = getDriver()
//				.findElement(By.xpath("//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[1]/td[4]/span")).getText();
//		System.out.println("Product PAckage ID : UNI 1 : " + UNI_1);
//		System.out.println("Eaccess Ovc selection started");
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
//		swiftpage.ddl_ovc_selected.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.ddl_select_address.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.ddl_select_address2.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		swiftpage.lnk_pencil1.click();
//		waitABit(2000);
//		swiftpage.tbx_search_uni_1.sendKeys("442415147");
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
//					WebElement checkbox5 = getDriver().findElement(By.id(GLMID1));
//					JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
//					js5.executeScript("arguments[0].click();", checkbox5);
//					waitABit(2000);
//					swiftpage.tbx_clli_search.clear();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(z_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					WebElement checkbox6 = getDriver().findElement(By.id(GLMID2));
//					JavascriptExecutor js6 = ((JavascriptExecutor) getDriver());
//					js6.executeScript("arguments[0].click();", checkbox6);
//					waitABit(3000);
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
//		swiftpage.btn_expand_2.click();
//		waitABit(2000);
//		swiftpage.lnk_select_uni.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		WebElement save = getDriver().findElement(By.id("relationshipSaveBtn"));
//		JavascriptExecutor js1 = ((JavascriptExecutor) getDriver());
//		js1.executeScript("arguments[0].click();", save);
//		waitABit(2000);
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
//					swiftpage.tbx_clli_search.sendKeys(a_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					WebElement checkbox5 = getDriver().findElement(By.id(GLMID1));
//					JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
//					js5.executeScript("arguments[0].click();", checkbox5);
//					waitABit(2000);
//					swiftpage.tbx_clli_search.clear();
//					waitABit(2000);
//					swiftpage.tbx_clli_search.sendKeys(z_end_clli + Keys.TAB);
//					waitABit(2000);
//					swiftpage.btn_clli_search.click();
//					waitABit(10000);
//					customwaitforpageloading(swiftpage);
//					WebElement checkbox6 = getDriver().findElement(By.id(GLMID2));
//					JavascriptExecutor js6 = ((JavascriptExecutor) getDriver());
//					js6.executeScript("arguments[0].click();", checkbox6);
//					waitABit(3000);
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
//		swiftpage.btn_expand_2.click();
//		waitABit(2000);
//		swiftpage.lnk_select_uni.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		WebElement save2 = getDriver().findElement(By.id("relationshipSaveBtn"));
//		js1.executeScript("arguments[0].click();", save2);
//		waitABit(2000);
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
//		swiftpage.ddl_ovc.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,
//		// Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.ddl_select_ovc_bandwidth.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
//				Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		swiftpage.ddl_select_ovc_class.click();
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_next_2.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(3000);
//		swiftpage.btn_next.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(2000);
//		swiftpage.btn_save.click();
//		customwaitforpageloading(swiftpage);
//		waitABit(5000);
//	}
//
//	@Step
//	public String completed_technical_data_gathering_for_the_submitted_OVC_order_with_below_info(DataTable table) {
//		System.out.println("******** TDG is Being Started **********");
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
//		waitABit(10000);
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("Assign Button Clicked");
//		waitABit(25000);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		waitABit(10000);
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
//		asriTDGPage.tbx_EVLAN_ID.sendKeys("1");
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
//		/*
//		 * if (Building_Ex.contains("No")) {
//		 * 
//		 * System.out.println("No Need to Provide TDG for CAT for Wholesale UNI");
//		 * 
//		 * } else {
//		 * 
//		 * asriTDGPage.lnk_Cat1.click(); waitABit(1000);
//		 * asriTDGPage.ddl_cat_interface.click();
//		 * asriTDGPage.ddl_cat_interface_select.click(); waitABit(1000);
//		 * asriTDGPage.btn_save.click(); customwaitforpageloadingasri(asriTDGPage);
//		 * customwaitforpageloading();
//		 * 
//		 * }
//		 */
//		waitABit(3000);
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloading();
//		return Service_Group;
//	}
//
//	public void the_product_should_be_staged_at_TDG_for_OVC() {
//		try {
//			String Validation_Result = getDriver().findElement(By.xpath("//textarea[@readonly='true']")).getText();
//			if (Validation_Result.contains("No Validation Exception!")) {
//				System.out.println("No Validation Exception!");
//			} else {
//				System.out.println("Validation Incomplete");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		customwaitforpageloading();
//	}
//}
