//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import java.time.Duration;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.Alert;
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
//public class ElineEVCSteps extends BaseStep {
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
//	IntDataContainer Container1 = envData.getContainer("TEST2");
//	IntDataContainer Container2 = commonData.getContainer("SFDC2");
//	IntDataContainer Container3 = envData.getContainer("SwIFT");
//	IntDataContainer Container4 = envData.getContainer("GCA");
//	IntDataContainer Container5 = envData.getContainer("ISM");
//	IntDataContainer Container6 = envData.getContainer("MetaStorm");
//	IntDataContainer Container7 = envData.getContainer("AsriLoginPage");
//	String SM = null;
//	String opportunityid = null;
//	String businessorderid = null;
//	String sess = null;
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_SSO_with_credentials_in_specified_environment(String userType, String ENV) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		if (ENV.contains("1")) {
//			loginpage.openAt(envData.getFieldValue("ITV1"));
//		}
//		if (ENV.contains("2")) {
//			loginpage.openAt(envData.getFieldValue("ITV2"));
//		}
//		if (ENV.contains("4")) {
//			loginpage.openAt(envData.getFieldValue("ITV4"));
//		}
//		loginpage.maximize();
//		WaitForPageToLoad(60);
//		loginpage.btn_OAM_SSO.click();
//		loginpage.tbx_email.sendKeys("abhishek.tripathi1@centurylink.com");
//		waitABit(60000);
//		/*
//		 * shouldExist(loginpage); IntDataContainer logincontainer =
//		 * envData.getContainer(loginpage.getClass().getSimpleName()).getContainer(
//		 * userType); fillFields(loginpage,
//		 * logincontainer.getMandatoryFieldsFromAllContainers());
//		 * loginpage.btn_log_in.click();
//		 */
//		WaitForPageToLoad(60);
//		String url = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url);
//		System.out.println("Login Successful");
//		waitABit(1000);
//		if (!url.contains("lightning")) {
//			System.out.println("Already A Classic Version of SFDC");
//		} else {
//			System.out.println("SFDC's Lightning Version, Switching to Classic ");
//			customClickableWait(loginpage.img_profile);
//			loginpage.img_profile.click();
//			waitABit(2000);
//			loginpage.lnk_back_to_classic.click();
//		}
//		WaitForPageToLoad(60);
//		customClickableWait(loginpage.btn_opportunities);
//		loginpage.btn_opportunities.click();
//		customClickableWait(opportunitypage.btn_new);
//		opportunitypage.btn_new.click();
//		customClickableWait(opportunitypage.btn_continue);
//		opportunitypage.btn_continue.click();
//		System.out.println("Started the Opportunity Creation");
//		WaitForPageToLoad(60);
//	}
//
//	@Step
//	public void i_create_a_new_Lobby_opportunity_with_account_number(String Account_Number) {
//		System.out.println("Selecting Account");
//		setParentHandle();
//		newopportunitypage.btn_look_up.waitUntilClickable().click();
//		waitForChildWindowToAppear();
//		switchToChildWindow();
//		getDriver().switchTo().frame(0);
//		newopportunitypage.tbx_search.sendKeys(Account_Number);
//		newopportunitypage.rbn_all_fields.waitUntilClickable().click();
//		newopportunitypage.btn_go.waitUntilClickable().click();
//		waitABit(3000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame("resultsFrame");
//		customClickableWait(newopportunitypage.lnk_first_result);
//		newopportunitypage.lnk_first_result.click();
//		switchToParentWindow();
//		WaitForPageToLoad(60);
//		System.out.println("Account Selected");
//		newopportunitypage.tbx_opportunity_name.sendKeys(Container2.getFieldValue("opportunity_name"));
//		newopportunitypage.ddl_stage.selectByVisibleText("Identified");
//		newopportunitypage.ddl_forecast_category.selectByVisibleText("Pipeline");
//		newopportunitypage.tbx_close_date.sendKeys(ElineEVCSteps.getDate());
//		newopportunitypage.btn_att.click();
//		newopportunitypage.btn_right.click();
//		newopportunitypage.btn_save_opportunity.waitUntilClickable().click();
//		WaitForPageToLoad(60);
//	}
//
//	@Step
//	public void Opty_should_be_created_successfully_with_opportunityid() {
//		opportunityid = getDriver().findElement(By.id("00NA0000005BwOL_ileinner")).getText();
//		System.out.println("Opportunity Created Successfully (Opportunity ID) = " + opportunityid);
//		customClickableWait(newopportunitypage.btn_level3);
//		newopportunitypage.btn_level3.click();
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
//		WaitForPageToLoad(100);
//		System.out.println("Level 3 Products Selected");
//		WebElement frame1 = getDriver().findElement(By.cssSelector("iframe[title='OpportunityQuotes']"));
//		// WebElement frame1 = getDriver().findElement(By.id("0662A000002Kmds"));
//		waitABit(3000);
//		getDriver().switchTo().frame(frame1);
//		waitABit(3000);
//		newopportunitypage.btn_new_scenario.click();
//		waitABit(3000);
//		System.out.println("Creating New Scenario");
//		WaitForPageToLoad(1000);
//		getDriver().switchTo().defaultContent();
//		try {
//			for (int i = 0; i < 10; i++) {
//				WebElement Clone = getDriver().findElement(By.xpath("(//input[@value=' Clone '])[1]"));
//				if (!Clone.isDisplayed()) {
//					System.out.println("Moved to Scenario Page");
//					getDriver().navigate().refresh();
//					WaitForPageToLoad(60);
//					break;
//				} else {
//					System.out.println("Failed to Click..... Trying Again");
//					waitABit(3000);
//					getDriver().switchTo().frame(frame1);
//					waitABit(3000);
//					newopportunitypage.btn_new_scenario.click();
//					System.out.println("Creating New Scenario");
//					WaitForPageToLoad(60);
//					getDriver().navigate().refresh();
//					WaitForPageToLoad(60);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		// getDriver().switchTo().defaultContent();
//		System.out.println("Refreshing the Page Again");
//		getDriver().navigate().refresh();
//		WaitForPageToLoad(60);
//		WebElement frame2 = getDriver().findElement(By.id("quote-iframe"));
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(newopportunitypage.tbx_scenario_name);
//		newopportunitypage.tbx_scenario_name.sendKeys(Container2.getFieldValue("scenario_name"));
//		waitABit(3000);
//		// customClickableWait(newopportunitypage.tbx_scenario_currency);
//		String currency = getDriver().findElement(By.xpath("//div[contains(@class,'mat-select-value')]/span/span"))
//				.getText();
//		System.out.println("Existing Currency Value : " + currency);
//		if (currency.isEmpty()) {
//			System.out.println("Updating Currency");
//			newopportunitypage.tbx_scenario_currency.click();
//			waitABit(2000);
//			newopportunitypage.ddl_usd.click();
//			waitABit(2000);
//		} else {
//			System.out.println("Currency Already Updated");
//		}
//		waitABit(20000);
//		customClickableWait(newopportunitypage.btn_save_scenario);
//		newopportunitypage.btn_save_scenario.click();
//		WaitForPageToLoad(60);
//		System.out.println("New Scenario Created");
//	}
//
//	@Step
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location(
//			String a_end_eline, String z_end_eline) {
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
//		waitABit(1000);
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
//		waitABit(1000);
//		customClickableWait(productpkg3page.ddl_uni_type);
//		productpkg3page.ddl_uni_type.waitUntilClickable().click();
//		waitABit(1000);
//		productpkg3page.ddl_uni_type_transparent.click();
//		// productpkg3page.ddl_uni_type_multiplexed.click();
//		customwaitforpageloading(productpkg3page);
//		String unitype = getDriver().findElement(By.xpath("(//span[@class='k-input'])[8]")).getText();
//		System.out.println("UNI Selected : " + unitype);
//		WebElement Building = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
//		String Building_Text = Building.getText();
//		System.out.println("Building : " + Building_Text);
//		customwaitforpageloading(productpkg3page);
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
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//			waitABit(5000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		}
//		if (Building_Text.contains("Standard")) {
//			System.out.println("Building Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		waitABit(1000);
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
//		productpkgpage.btn_next.click();
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Z end Address Selected");
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customClickableWait(productpkg3page.lst_product);
//		productpkg3page.lst_product.click();
//		waitABit(1000);
//		customClickableWait(productpkg3page.lst_product_evc);
//		productpkg3page.lst_product_evc.waitUntilClickable().click();
//		String secondproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
//		System.out.println("2nd Product Selected : " + secondproduct);
//		customClickableWait(productpkg3page.btn_new_product);
//		productpkg3page.btn_new_product.click();
//		customwaitforpageloading(productpkg3page);
//		customClickableWait(productpkg3page.ddl_add_1);
//		productpkg3page.ddl_add_1.click();
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
//			System.out.println(e);
//		} finally {
//			System.out.println("A end Location is Selected at Address 1");
//		}
//		customwaitforpageloading(productpkg3page);
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
//			waitABit(2000);
//			WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(200));
//			wait2.until(ExpectedConditions.textToBe(By.xpath("(//div[@data-bind='text: ScenarioMessage'])[1]"),
//					"All possible related packages have been loaded."));
//			customClickableWait(productpkg3page.rbn_add_1);
//			waitABit(2000);
//			productpkg3page.rbn_add_1.waitUntilClickable().click();
//			customwaitforpageloading(productpkg3page);
//		}
//		waitABit(2000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame(frame2);
//		customwaitforpageloading(productpkg3page);
//		System.out.println("Selecting Products at Z end Location");
//		String Z_Loc_Value = getDriver().findElement(By.xpath("(//span[@class='k-input'])[7]")).getText();
//		System.out.println("Z Location Value : " + Z_Loc_Value);
//		if (!Z_Loc_Value.contains("Create")) {
//			System.out.println("Selecting UNI at Z Location");
//			customwaitforpageloading(productpkg3page);
//			productpkg3page.ddl_z_loc.click();
//			waitABit(2000);
//			WebDriverWait wait3 = new WebDriverWait(getDriver(), Duration.ofSeconds(200));
//			wait3.until(ExpectedConditions.textToBePresentInElementLocated(
//					By.xpath("(//div[@data-bind='text: ScenarioMessage'])[2]"),
//					"All possible related packages have been loaded."));
//			customClickableWait(productpkg3page.rbn_add_2);
//			waitABit(2000);
//			productpkg3page.rbn_add_2.click();
//			customwaitforpageloading(productpkg3page);
//			getDriver().switchTo().defaultContent();
//			getDriver().switchTo().frame(frame2);
//		} else {
//			System.out.println("Create New Package Already Selected at Z Location");
//		}
//		customwaitforpageloading(productpkg3page);
//		waitABit(2000);
//		WebElement EVC = getDriver().findElement(By.xpath("(//span[@class='k-input'])[10]"));
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
//		WebElement Bandwidth = getDriver().findElement(By.xpath("(//span[@class='k-input'])[11]"));
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
//		WebElement Class = getDriver().findElement(By.xpath("(//span[@class='k-input'])[12]"));
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
//		WebElement Building2 = getDriver().findElement(By.xpath("(//span[@class='k-input'])[26]"));
//		String Building2_Text = Building2.getText();
//		System.out.println("Building : " + Building2_Text);
//		if (Building2_Text.contains("- Select -")) {
//			System.out.println("Updating Building");
//			Building2.click();
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(1000);
//			customwaitforpageloading(productpkg3page);
//		} else {
//			System.out.println("Building Already Updated");
//			customwaitforpageloading(productpkg3page);
//		}
//		customClickableWait(productpkg3page.btn_quick_save);
//		waitABit(1000);
//		productpkg3page.btn_quick_save.waitUntilClickable().click();
//		WaitForPageToLoad();
//		System.out.println("UNI2 Added for Z end Location");
//		System.out.println("ELine EVC Configured between A & Z end Locations");
//	}
//
//	@Step
//	public void the_scenario_should_be_created_successfully() {
//		customwaitforpageloading(productpage);
//		System.out.println("Product Configuration Done");
//	}
//
//	@Step
//	public void i_perform_the_profitability_analysis_for_eline() {
//		customwaitforpageloading(productpage);
//		getDriver().switchTo().defaultContent();
//		WebElement frame3 = getDriver().findElement(By.id("quote-iframe"));
//		getDriver().switchTo().frame(frame3);
//		customwaitforpageloading(productpage);
//		customClickableWait(productpage.btn_discount_profitability);
//		productpage.btn_discount_profitability.click();
//		;
//		System.out.println("Discounting Profitability Checking");
//		customClickableWait(productpage.btn_save);
//		for (int i = 0; i < 10; i++) {
//			String ProfitPass = getDriver()
//					.findElement(By.xpath(
//							"//*[@id=\"product-tree-items\"]/table[3]/tfoot/tr/td[4]/div/div[2]/div/div[1]/div[1]"))
//					.getText();
//			// String ProfitPass =
//			// getDriver().findElement(By.xpath("//*[@id=\"product-tree-items\"]/table[2]/tfoot/tr/td[4]/div/div[2]/div/div[1]/div[1]")).getText();
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
//	public void the_added_products_should_be_under_profitable_status() {
//		customwaitforpageloading(productpage);
//		getDriver().switchTo().defaultContent();
//		System.out.println("Discounting Profitability Checked");
//		waitABit(1000);
//		/*
//		 * String SM =
//		 * getDriver().findElement(By.xpath("//td[@class='col-data'])[7]")).getText();
//		 * System.out.println("Scenario ID : "+SM);
//		 */
//		customClickableWait(productpage.lnk_back);
//		waitABit(3000);
//		productpage.lnk_back.click();
//		WaitForPageToLoad(100);
//		try {
//			if (existingopportunitypage.btn_edit.isVisible()) {
//				System.out.println("Moved to Opportunity Page");
//			} else {
//				System.out.println("Retrying Again to Click on Back Btn");
//				customClickableWait(productpage.lnk_back);
//				waitABit(3000);
//				productpage.lnk_back.click();
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Step
//	public void i_update_the_order_stage_in_the_quote_and_prepare_order() {
//		System.out.println("Current Opportunity Found");
//		// shouldExist(existingopportunitypage);
//		customClickableWait(existingopportunitypage.btn_edit);
//		existingopportunitypage.btn_edit.click();
//		WaitForPageToLoad();
//		existingopportunitypage.ddl_stage_update.selectByVisibleText("Proposed");
//		waitABit(1000);
//		existingopportunitypage.btn_save.click();
//		WaitForPageToLoad(60);
//		try {
//			for (int i = 0; i < 5; i++) {
//				String Error = getDriver().findElement(By.xpath("//span[contains(.,'New Task')]")).getText();
//				System.out.println("Error Text " + Error);
//				if (!Error.contains("New Task")) {
//					System.out.println("REST API Error While Saving the Change of Stage, Retrying");
//					existingopportunitypage.lnk_error.click();
//					WaitForPageToLoad();
//					shouldExist(existingopportunitypage);
//					customClickableWait(existingopportunitypage.btn_edit);
//					existingopportunitypage.btn_edit.click();
//					WaitForPageToLoad();
//					existingopportunitypage.ddl_stage_update.selectByVisibleText("Proposed");
//					waitABit(1000);
//					existingopportunitypage.btn_save.click();
//					WaitForPageToLoad();
//				} else {
//					System.out.println("Opportunity Stage Changed to Proposed");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Opportunity Stage Changed to Proposed");
//		}
//		System.out.println("Clicking : Prepare Order");
//		// WebElement frame4 =
//		// getDriver().findElement(By.cssSelector("iframe[title='OpportunityQuotes']"));
//		WebElement frame4 = getDriver().findElement(By.id("0662A000002Kmds"));
//		getDriver().switchTo().frame(frame4);
//		waitABit(5000);
//		if (existingopportunitypage.btn_prepare_order.isClickable()) {
//			System.out.println("Prepare Order Clickable");
//			existingopportunitypage.btn_prepare_order.click();
//			waitABit(8000);
//			WaitForPageToLoad(60);
//			getDriver().switchTo().defaultContent();
//			try {
//				for (int i = 0; i < 10; i++) {
//					WebElement Clone = getDriver().findElement(By.xpath("(//input[@value=' Clone '])[1]"));
//					if (!Clone.isDisplayed()) {
//						System.out.println("Moved to Quote Page");
//						break;
//					} else {
//						System.out.println("Failed to Click..... Trying Again");
//						getDriver().switchTo().frame(frame4);
//						waitABit(3000);
//						existingopportunitypage.btn_prepare_order.click();
//						waitABit(10000);
//						WaitForPageToLoad(60);
//					}
//				}
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			getDriver().switchTo().defaultContent();
//		} else {
//			System.out.println("Prepare Order is Not Clickable");
//			existingopportunitypage.Scenario(SM).click();
//		}
//	}
//
//	@Step
//	public void i_add_the_contact_details(String CCM, String SalesEngineer, String Contact) {
//		WaitForPageToLoad(60);
//		WaitForFrameToLoad(60);
//		shouldExist(quotepage);
//		System.out.println("Prepare Order Clicked");
//		waitABit(5000);
//		customClickableWait(quotepage.btn_edit);
//		quotepage.btn_edit.click();
//		WaitForPageToLoad(60);
//		waitABit(2000);
//		quotepage.lst_msa_edit.selectByVisibleText("No");
//		quotepage.lst_porting_edit.selectByVisibleText("No");
//		quotepage.lst_hot_cut_edit.selectByVisibleText("No");
//		waitABit(2000);
//		System.out.println("MSA, Porting & Hot Cut Updated");
//		setParentHandle();
//		quotepage.btn_CCM_search.click();
//		waitForChildWindowToAppear();
//		switchToChildWindow();
//		getDriver().switchTo().frame("searchFrame");
//		quotepage.tbx_CCM_search.sendKeys(CCM);
//		quotepage.btn_CCM_search_go.waitUntilClickable().click();
//		waitABit(2000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame("resultsFrame");
//		quotepage.lnk_CCM_select.click();
//		waitABit(2000);
//		switchToParentWindow();
//		WaitForPageToLoad();
//		System.out.println("CCM Updated");
//		waitABit(1000);
//		quotepage.tbx_sales_engineer_edit.clear();
//		quotepage.tbx_sales_engineer_edit.sendKeys(SalesEngineer);
//		waitABit(1000);
//		System.out.println("Sales Engineer Updated");
//		quotepage.btn_save_edit.click();
//		WaitForPageToLoad();
//		try {
//			for (int i = 0; i < 5; i++) {
//				String Error = getDriver().findElement(By.xpath("//a[contains(.,'re-display the record')]")).getText();
//				System.out.println("Error Text " + Error);
//				if (Error.contains("re-display the record")) {
//					System.out.println("REST API Error While Saving the Change of Order Details, Retrying");
//					existingopportunitypage.lnk_error.click();
//					WaitForPageToLoad();
//					customClickableWait(quotepage.btn_edit);
//					quotepage.btn_edit.click();
//					WaitForPageToLoad();
//					quotepage.lst_msa_edit.selectByVisibleText("No");
//					quotepage.lst_porting_edit.selectByVisibleText("No");
//					quotepage.lst_hot_cut_edit.selectByVisibleText("No");
//					waitABit(1000);
//					System.out.println("MSA, Porting & Hot Cut Updated");
//					setParentHandle();
//					quotepage.btn_CCM_search.click();
//					waitForChildWindowToAppear();
//					switchToChildWindow();
//					getDriver().switchTo().frame("searchFrame");
//					quotepage.tbx_CCM_search.sendKeys(CCM);
//					quotepage.btn_CCM_search_go.waitUntilClickable().click();
//					waitABit(1000);
//					getDriver().switchTo().defaultContent();
//					getDriver().switchTo().frame("resultsFrame");
//					quotepage.lnk_CCM_select.click();
//					switchToParentWindow();
//					WaitForPageToLoad();
//					System.out.println("CCM Updated");
//					waitABit(1000);
//					quotepage.tbx_sales_engineer_edit.clear();
//					quotepage.tbx_sales_engineer_edit.sendKeys(SalesEngineer);
//					waitABit(1000);
//					System.out.println("CCM & Sales Engineer Updated");
//					quotepage.btn_save_edit.click();
//					WaitForPageToLoad();
//				} else {
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Order Details Updated Successfully");
//		}
//		customClickableWait(quotepage.btn_existing_contacts);
//		quotepage.btn_existing_contacts.click();
//		customClickableWait(quotepage.tbx_contact1);
//		quotepage.tbx_contact1.sendKeys(Contact);
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		quotepage.tbx_contact2.sendKeys(Contact);
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(1000);
//		quotepage.tbx_contact3.sendKeys(Contact);
//		waitABit(5000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		waitABit(2000);
//		customClickableWait(quotepage.btn_save_contacts);
//		quotepage.btn_save_contacts.click();
//		System.out.println("Contacts Updated");
//	}
//
//	private void WaitForFrameToLoad(int i) {
//		// TODO Auto-generated method stub
//	}
//
//	@Step
//	public void i_attach_the_SOF() {
//		customClickableWait(quotepage.btn_global_attachment);
//		quotepage.btn_global_attachment.click();
//		WaitForPageToLoad();
//		customClickableWait(quotepage.tbx_doc_name);
//		quotepage.tbx_doc_name.sendKeys("SOF");
//		quotepage.ddl_doc_type.selectByVisibleText("Service Order Form");
//		waitABit(2000);
//		quotepage.tbx_signed_date.sendKeys(ElineEVCSteps.getDate());
//		waitABit(8000);
//		System.out.println("SOF Attaching");
//		quotepage.btn_add_attachment.waitUntilClickable().click();
//		WaitForPageToLoad(100);
//		try {
//			for (int i = 0; i < 5; i++) {
//				String error = getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
//				if (error.contains("Signed Date is required")) {
//					System.out.println("Signed Date needs to be Updated Again");
//					waitABit(2000);
//					quotepage.tbx_signed_date.clear();
//					waitABit(2000);
//					quotepage.tbx_signed_date.sendKeys(ElineEVCSteps.getDate());
//					waitABit(8000);
//				} else {
//					System.out.println("Signed Date Updated");
//					break;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		waitABit(5000);
//		getDriver().switchTo().defaultContent();
//		getDriver().switchTo().frame("theIframe");
//		waitABit(2000);
//		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SOF.pdf";
//		System.out.println(FilePath);
//		getDriver().findElement(By.id("ucAttachment_fileAttach")).sendKeys(FilePath);
//		waitABit(8000);
//		customClickableWait(quotepage.btn_add_choosen_attachment);
//		quotepage.btn_add_choosen_attachment.click();
//		System.out.println("SOF Attached");
//		getDriver().switchTo().defaultContent();
//		waitABit(8000);
//		quotepage.lnk_back_to_record.click();
//		System.out.println("Service Order Form Updated");
//	}
//
//	@Step
//	public void i_update_the_billing_account(String Billing_Number) {
//		customClickableWait(quotepage.btn_billing_account);
//		quotepage.btn_billing_account.click();
//		System.out.println("Updating Billing Account");
//		waitABit(5000);
//		customClickableWait(quotepage.tbx_billing_account_number);
//		quotepage.tbx_billing_account_number.sendKeys(Billing_Number);
//		waitABit(2000);
//		customClickableWait(quotepage.btn_search_billing_account_number);
//		quotepage.btn_search_billing_account_number.click();
//		waitABit(15000);
//		customClickableWait(quotepage.btn_select_billing_account);
//		quotepage.btn_select_billing_account.click();
//		waitABit(3000);
//		quotepage.btn_update_all.click();
//		waitABit(2000);
//		try {
//			for (int i = 0; i < 50; i++) {
//				String BAN_ID = getDriver().findElement(By.xpath("(//td[contains(@class,'dataCell')])[12]")).getText();
//				if (BAN_ID.length() < 1) {
//					System.out.println("Length of BAN ID : " + BAN_ID.length());
//					System.out.println("Updating the BAN ID");
//					waitABit(5000);
//					quotepage.btn_update_all.waitUntilClickable().click();
//					waitABit(5000);
//					customwaitforpageloadingbilling(quotepage);
//					waitABit(5000);
//				} else {
//					System.out.println("Length of BAN ID : " + BAN_ID.length());
//					System.out.println("BAN ID Updated");
//					break;
//				}
//			}
//		} catch (Exception e) {
//		}
//		waitABit(5000);
//		customClickableWait(quotepage.btn_return_to_quote);
//		waitABit(5000);
//		quotepage.btn_return_to_quote.waitUntilClickable().click();
//		System.out.println("Billing Account Updated; Order is Ready to Submit to SwIFT");
//	}
//
//	@Step
//	public void i_submit_the_order() {
//		WaitForPageToLoad(100);
//		quotepage.btn_submit_to_swift.waitUntilClickable().click();
//		WaitForPageToLoad(100);
//		for (int i = 0; i < 25; i++) {
//			String message = getDriver().findElement(By.id("j_id0:j_id5:j_id6:j_id7:0:j_id8:j_id9:j_id11")).getText();
//			System.out.println("Order Submitted to Swift Status : " + message);
//			// Actions action = new Actions(getDriver());
//			WebElement message2 = getDriver().findElement(By.xpath("//input[@value='Ok']"));
//			message2.click();
//			// action.click(message2).build().perform();
//			if (!message.contains("Successfully Updated")) {
//				customClickableWait(quotepage.btn_billing_account);
//				quotepage.btn_billing_account.click();
//				customClickableWait(quotepage.btn_select_billing_account);
//				quotepage.btn_select_billing_account.click();
//				waitABit(3000);
//				quotepage.btn_update_all.waitUntilClickable().click();
//				waitABit(8000);
//				quotepage.btn_return_to_quote.waitUntilClickable().click();
//				WaitForPageToLoad();
//				quotepage.btn_submit_to_swift.waitUntilClickable().click();
//				WaitForPageToLoad();
//			} else {
//				break;
//			}
//		}
//	}
//
//	@Step
//	public void the_order_should_be_submitted_to_SwIFT_successfully() {
//		shouldExist(quotepage);
//		businessorderid = getDriver().findElement(By.id("00N2A00000DoTFx_ileinner")).getText();
//		System.out.println("SwIFT Business Order ID = " + businessorderid);
//		System.out.println("Order Pushed to Swift");
//		getDriver().close();
//	}
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_Swift_in_specified_environment(String ENV) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		if (ENV.contains("1")) {
//			swiftpage.openAt(Container3.getFieldValue("ITV1"));
//		}
//		if (ENV.contains("2")) {
//			swiftpage.openAt(Container3.getFieldValue("ITV2"));
//		}
//		if (ENV.contains("4")) {
//			swiftpage.openAt(Container3.getFieldValue("ITV4"));
//		}
//		WaitForPageToLoad();
//		System.out.println("Swift Page Launched");
//		swiftpage.maximize();
//		WaitForPageToLoad(5); // wait for auto log in
//		swiftpage.ddl_business_order_id_select.waitUntilClickable().click();
//		waitABit(2000);
//		swiftpage.ddl_business_order_id_selected.click();
//		System.out.println("Business Order ID Selected");
//	}
//
//	@Step
//	public void i_search_the_Business_Order_ID_in_Swift() {
//		waitABit(3000);
//		swiftpage.tbx_order_id_field.sendKeys(businessorderid);
//		swiftpage.btn_search.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//		for (int i = 0; i < 200; i++) {
//			String message = getDriver().findElement(By.xpath("//div[@class='k-link']/span[2]")).getText();
//			System.out.println("Business Order Id = " + message);
//			if (!message.contains(businessorderid)) {
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
//	public void it_should_be_generating_a_Order_Package_ID() {
//		String orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
//		System.out.println("Order Package ID = " + orderpackageid);
//		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
//		sess = Serenity.sessionVariableCalled("orderpackageid");
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
//	}
//
//	@Step
//	public void i_set_the_NDD_and_CRD_and_update_the_cllis_for_a_end_and_z_end(String a_end_clli, String z_end_clli) {
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
//		customClickableWait(swiftpage.btn_first_product);
//		swiftpage.btn_first_product.click();
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_first_sub_product);
//		swiftpage.btn_first_sub_product.click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
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
//		// swiftpage.lnk_end_user_CLLI_select_MMPHTNBGS08.waitUntilClickable().click();
//		swiftpage.zendclli2(z_end_clli).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(8000);
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
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 1 Updated");
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_second_product);
//		swiftpage.btn_second_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_sub_product);
//		swiftpage.btn_second_sub_product.click();
//		waitABit(2000);
//		customClickableWait(swiftpage.btn_second_address1_edit_eline);
//		swiftpage.btn_second_address1_edit_eline.click();
//		waitABit(8000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli 2");
//		// swiftpage.lnk_end_user_2CLLI_select_BNGHNYBCS00.waitUntilClickable().click();
//		swiftpage.aendclli1(a_end_clli).click();
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
//		customClickableWait(swiftpage.btn_second_address2_edit_eline);
//		swiftpage.btn_second_address2_edit_eline.click();
//		waitABit(5000);
//		customClickableWait(swiftpage.ddl_end_user_CLLI_update);
//		swiftpage.ddl_end_user_CLLI_update.click();
//		waitABit(5000);
//		System.out.println("Updating Clli3");
//		// swiftpage.lnk_end_user_CLLI_select_MMPHTNBGS08.waitUntilClickable().click();
//		swiftpage.zendclli2(z_end_clli).click();
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_end_user_CLLI_update);
//		swiftpage.btn_end_user_CLLI_update.click();
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		// customClickableWait(swiftpage.btn_end_user_CLLI_update_save);
//		// swiftpage.btn_end_user_CLLI_update_save.click();
//		// waitABit(5000);
//		// customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.btn_top_save);
//		swiftpage.btn_top_save.click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("CILLI 3 Updated");
//		waitABit(5000);
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
//		System.out.println("Updating Clli 4");
//		// swiftpage.lnk_end_user_2CLLI_select_BNGHNYBCS00.waitUntilClickable().click();
//		swiftpage.aendclli1(a_end_clli).click();
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
//	public void i_impersonate_the_Order_Package_to_a_user() {
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
//	}
//
//	@Step
//	public void i_add_an_OES() {
//		customClickableWait(swiftpage.btn_order_details);
//		swiftpage.btn_order_details.click();
//		waitABit(1000);
//		System.out.println("Adding OES");
//		swiftpage.ddl_OES.sendKeys("Abhay, Chitale");
//		waitABit(2000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(3000);
////		swiftpage.ddl_VSC.click();
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
////		waitABit(1000);
////		swiftpage.ddl_TDE.click();
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
////		waitABit(1000);
////		swiftpage.ddl_Director.click();
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
////		waitABit(1000);
////		swiftpage.ddl_Manager.click();
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
////		waitABit(1000);
//		swiftpage.btn_top_save.waitUntilClickable().click();
//		customwaitforpageloading(swiftpage);
//		System.out.println("OES Added");
//	}
//
//	@Step
//	public void i_validate_reassign_and_complete_the_first_task() {
//		waitABit(1000);
//		customClickableWait(swiftpage.btn_contacts);
//		swiftpage.btn_contacts.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
//		List<WebElement> Contacts = getDriver()
//				.findElements(By.xpath("//span[contains(@class,'contactName ng-binding')]"));
//		System.out.println("Number of Contacts Added = " + Contacts.size());
//		/*
//		 * Iterator<WebElement> itr = Contacts.iterator(); waitABit(1000);
//		 * while(itr.hasNext()) { waitABit(1000);
//		 * System.out.println(itr.next().getText()); }
//		 */
//		if (Contacts.size() > 0) {
//			System.out.println("Contacts Already Attached to the Product Package");
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//		} else {
//			System.out.println("Contact Needs to be Updated");
//			waitABit(2000);
//			swiftpage.tbx_add_contact.sendKeys("Chris Woelkers");
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(2000);
//			swiftpage.tbx_contact_role.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			// swiftpage.cbx_contact_role_select.click();
//			waitABit(2000);
//			swiftpage.tbx_contact_section.click();
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			waitABit(2000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			/*
//			 * swiftpage.cbx_contact_section_1.click();
//			 * swiftpage.cbx_contact_section_2.click();
//			 * swiftpage.cbx_contact_section_3.click();
//			 */
//			waitABit(2000);
//			swiftpage.btn_contacts.click();
//			customwaitforpageloading(swiftpage);
//			waitABit(5000);
//		}
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
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
//		waitABit(2000);
//		swiftpage.lnk_order_package_1st_task.click();
//		waitABit(2000);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(2000);
//		swiftpage.btn_complete.click();
//		System.out.println("test");
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//		System.out.println("1st Task Completed");
//	}
//
//	@Step
//	public void first_task_should_be_cmpleted_and_two_more_sub_tasks_gets_created() {
//		System.out.println("Waiting for 2nd and 3rd Tasks to Generate");
//		try {
//			WebElement UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"));
//			System.out.println("Update Task Status : " + UpdatedTask.getText());
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
//			wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask, "1 - 3 of 3 items"));
//			System.out.println("2nd and 3rd Task Generated");
//			customwaitforpageloading(swiftpage);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@SuppressWarnings("unlikely-arg-type")
//	@Step
//	public void i_reassign_validate_and_complete_the_second_task(String ENV) {
//		customClickableWait(swiftpage.lnk_order_package_ready1);
//		for (int i = 0; i < 5; i++) {
//			String SecondTask = getDriver()
//					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span")).getText();
//			System.out.println("Second Task Status : " + SecondTask);
//			if (SecondTask.contains("Ready")) {
//				System.out.println("Second Task is Ready to be Validated");
//				break;
//			} else {
//				System.out.println("Second Task is Not Ready to be Validated, Switching to MetaStorm");
//				getDriver().close();
//				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//				if (ENV.contains("1")) {
//					metastormpage.openAt(Container6.getFieldValue("ITV1"));
//				}
//				if (ENV.contains("2")) {
//					metastormpage.openAt(Container6.getFieldValue("ITV2"));
//				}
//				if (ENV.contains("4")) {
//					metastormpage.openAt(Container6.getFieldValue("ITV4"));
//				}
//				WaitForPageToLoad(100);
//				metastormpage.maximize();
//				waitABit(5000); // auto login wait
//				System.out.println("MetaStorm Page is Loaded");
//				System.out.println("Current URL : " + getDriver().getCurrentUrl());
//				customClickableWait(metastormpage.btn_watch_list);
//				metastormpage.btn_watch_list.click();
//				waitABit(3000);
//				System.out.println("Test 1377");
//				customClickableWait(metastormpage.ddl_process);
//				System.out.println("Test 1379");
//				metastormpage.ddl_process.click();
//				waitABit(5000);
//				System.out.println("Test 1382");
//				customClickableWait(metastormpage.ddl_process_OP_Welcome);
//				System.out.println("Test 1384");
//				metastormpage.ddl_process_OP_Welcome.click();
//				waitABit(5000);
//				customClickableWait(metastormpage.ddl_stage);
//				System.out.println("Test 1388");
//				metastormpage.ddl_stage.click();
//				waitABit(5000);
//				customClickableWait(metastormpage.ddl_stage_select);
//				System.out.println("Test 1392");
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
//				if (ENV.contains("1")) {
//					swiftpage.openAt(Container3.getFieldValue("ITV1"));
//				}
//				if (ENV.contains("2")) {
//					swiftpage.openAt(Container3.getFieldValue("ITV2"));
//				}
//				if (ENV.contains("4")) {
//					swiftpage.openAt(Container3.getFieldValue("ITV4"));
//				}
//				WaitForPageToLoad();
//				System.out.println("Swift Page Launched Again");
//				swiftpage.maximize();
//				WaitForPageToLoad(5); // wait for auto log in
//				swiftpage.ddl_business_order_id_select.waitUntilClickable().click();
//				waitABit(2000);
//				swiftpage.ddl_business_order_id_selected.click();
//				System.out.println("Business Order ID Selected");
//				waitABit(3000);
//				swiftpage.tbx_order_id_field.sendKeys(businessorderid);
//				swiftpage.btn_search.waitUntilClickable().click();
//				WaitForPageToLoad();
//				customClickableWait(swiftpage.lnk_order_package_ready1);
//			}
//		}
//		customClickableWait(swiftpage.lnk_order_package_ready1);
//		swiftpage.lnk_order_package_ready1.click();
//		waitABit(3000);
//		for (int k = 0; k < 2; k++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
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
//		customClickableWait(swiftpage.lnk_order_package_ready1);
//		swiftpage.lnk_order_package_ready1.click();
//		waitABit(3000);
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("2nd Task Reassigned to User");
//		customClickableWait(swiftpage.lnk_order_package_ready1);
//		swiftpage.lnk_order_package_ready1.click();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
//	}
//
//	@Step
//	public void second_task_should_be_completed() {
//		waitABit(3000);
//		System.out.println("2nd Task Completed");
//	}
//
//	@Step
//	public void i_reassign_validate_and_complete_the_third_task() {
//		waitABit(3000);
//		customwaitforpageloading(swiftpage);
//		customClickableWait(swiftpage.lnk_order_package_ready2);
//		waitABit(2000);
//		swiftpage.lnk_order_package_ready2.click();
//		waitABit(3000);
//		for (int i = 0; i < 2; i++) {
//			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
//			if (User.contains("Madahalli Chowdegowda, Raju")) {
//				System.out.println("3rd Task Already Impersonating to Raju");
//				break;
//			} else {
//				System.out.println("Need to Impersonate 3rd Task");
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
//		waitABit(3000);
//		swiftpage.lnk_order_package_ready2.click();
//		customClickableWait(swiftpage.btn_reassign_me);
//		swiftpage.btn_reassign_me.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
//		customwaitforpageloading(swiftpage);
//		System.out.println("3rd Task Reassigned to Me");
//		customClickableWait(swiftpage.lnk_order_package_ready2);
//		swiftpage.lnk_order_package_ready2.click();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
//		customClickableWait(swiftpage.btn_complete);
//		waitABit(3000);
//		swiftpage.btn_complete.click();
//		waitABit(10000);
//		customwaitforpageloading(swiftpage);
//	}
//
//	@Step
//	public void third_task_should_be_completed_and_order_should_move_to_GCA() {
//		System.out.println("Last Task Completed");
//		waitABit(5000);
//		customwaitforpageloading(swiftpage);
//		String order_pkg_status = getDriver()
//				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span")).getText();
//		System.out.println("Order Package Status = " + order_pkg_status);
//		waitABit(2000);
//		System.out.println("All Tasks Completed in Swift");
//		waitABit(2000);
//		System.out.println("Order Pushed to GCA");
//		waitABit(2000);
//		getDriver().close();
//	}
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_GCA_in_specified_environment() {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		gcapage.openAt(envData.getFieldValue("GCA"));
//		WaitForPageToLoad(60);
//		gcapage.maximize();
//		System.out.println("GCA Page is Loaded");
//		System.out.println("Current URL : " + getDriver().getCurrentUrl());
//	}
//
//	@Step
//	public void i_search_the_Order_Package_ID_in_GCA() {
//		waitABit(10000);
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
//	public void order_details_should_be_populated_in_GCA_with_Order_Result_as_Approved() {
//		waitABit(5000);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", gcapage.btn_details);
//		for (int i = 0; i < 1; i++) {
//			String orderresult = getDriver().findElement(By.xpath("//td[@data-name='OrderCreditResult']")).getText();
//			System.out.println("Order Status : " + orderresult);
//			if (!orderresult.contains("Approved")) {
//				customClickableWait(gcapage.btn_details);
//				gcapage.btn_details.click();
//				WaitForPageToLoad();
//				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
//				waitABit(2000);
//				gcapage.ddl_order_result.selectByVisibleText("Approved");
//				waitABit(2000);
//				gcapage.btn_save.waitUntilClickable().click();
//				WaitForPageToLoad();
//				System.out.println("Order Status Changed to Approved");
//			} else {
//				System.out.println("Order is Already Approved");
//				break;
//			}
//		}
//		System.out.println("Order Pushed to ISM");
//		waitABit(2000);
//		getDriver().close();
//	}
//
//	@Step
//	public void i_am_logged_in_as_a_user_in_ISM_in_specified_environment(String ENV) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		ismpage.openAt(envData.getFieldValue("ISM"));
//		WaitForPageToLoad(500);
//		// customVisibleWaitism(ismpage.btn_search);
//		waitABit(15000);
//		ismpage.maximize();
//		System.out.println("ISM Page is Loaded");
//		try {
//			for (int i = 0; i < 10; i++) {
//				WebElement Login = getDriver().findElement(By.xpath("//div[contains(@id,'ext-element-38')]"));
//				WebElement Close = getDriver()
//						.findElement(By.xpath("//span[@data-ref='btnInnerEl'][contains(.,'Close')]"));
//				if (Login.isDisplayed()) {
//					System.out.println("Login Required in ISM");
//					/*
//					 * shouldExist(loginpage); IntDataContainer logincontainer =
//					 * envData.getContainer(loginpage.getClass().getSimpleName()).getContainer(
//					 * userType); fillFields(loginpage,
//					 * logincontainer.getMandatoryFieldsFromAllContainers());
//					 * loginpage.btn_log_in.click();
//					 */
//					Close.click();
//				} else {
//					System.out.println("Login Not Required in ISM");
//					waitABit(5000);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Step
//	public void i_search_the_Order_Package_ID_in_ISM() {
//		waitABit(15000);
//		customClickableWait(ismpage.tbx_transaction_id);
//		ismpage.tbx_transaction_id.sendKeys(sess);
//		waitABit(30000);
//		ismpage.tbx_return_code.click();
//		waitABit(5000);
//		ismpage.tbx_return_code_all.click();
//		waitABit(5000);
//		ismpage.btn_search.waitUntilClickable().click();
//		waitABit(5000);
//		for (int i = 0; i < 200; i++) {
//			String searchresult = getDriver().findElement(By.xpath("//div[@id='tbtext-1084']")).getText();
//			if (searchresult.contains("No data to display")) {
//				System.out.println("Search Result = " + searchresult + " ; Retrying");
//				waitABit(15000);
//				ismpage.btn_search.click();
//			} else {
//				System.out.println("Search Result = " + searchresult);
//				break;
//			}
//		}
//	}
//
//	@Step
//	public void order_details_should_be_populated_in_ISM_with_Return_Message_as_Sent_to_ODO() {
//		waitABit(5000);
//		for (int j = 0; j < 25; j++) {
//			String returnmessage = getDriver().findElement(By.xpath("(//div[@class='x-grid-cell-inner '])[10]"))
//					.getText();
//			if (!returnmessage.contains("Sent to ODO")) {
//				waitABit(10000);
//				ismpage.btn_search.click();
//			} else {
//				System.out.println("Return Message = " + returnmessage);
//				break;
//			}
//		}
//		waitABit(2000);
//		System.out.println("Order Sent to ODO");
//		getDriver().quit();
//	}
//
//	@Step
//	public void i_am_logged_in_ASRI_with_credentials_in_specified_environment(String userType2) {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		asriLoginPage.openAt(envData.getFieldValue("ASRI"));
//		getDriver().manage().window().maximize();
//		shouldExist(asriLoginPage, 10);
//		/*
//		 * if(!(System.getProperty("staf.userid.key1") == null ||
//		 * (System.getProperty("staf.password.key1") == null ))) {
//		 * System.setProperty("staf.userid.key", "staf.userid.key1");
//		 * System.setProperty("staf.password.key", "staf.password.key1"); }
//		 */
//		IntDataContainer dataContainer = envData.getContainer(asriLoginPage.getClass().getSimpleName())
//				.getContainer(userType2);
//		fillFields(asriLoginPage, dataContainer.getMandatoryFieldsFromAllContainers());
//		asriLoginPage.btn_login.click();
//		System.out.println("login done");
//		System.out.println("********** Login function is completed ****************");
//	}
//
//	@Step
//	public void i_search_order_package_ID_in_project_list_page() {
//		System.out.println("On Home Page");
//		customwaitforpageloading();
//		customClickableWait(asriHomePage.lnk_project);
//		asriHomePage.lnk_project.click();
//		System.out.println("Project Icon is Clicked");
//		customwaitforpageloading();
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriProjectListPage.frame_2frame);
////		getDriver().switchTo().frame("2frame") ;
//		customClickableWait(asriProjectListPage.ddl_ExtOrderID);
//		asriProjectListPage.ddl_ExtOrderID.click();
//		System.out.println("Clicked on External ID");
//		asriProjectListPage.tbx_ExtorderID.sendKeys(sess + Keys.ENTER);
//		System.out.println("Package ID Entred");
//		try {
//			for (int i = 0; i < 200; i++) {
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
//	public void i_process_the_technical_data_gathering_for_eline() {
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
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		System.out.println("ELINE Dropdown Clicked");
//		customClickableWait(asriTDGPage.lnk_ECV);
//		asriTDGPage.lnk_ECV.click();
//		waitABit(5000);
//		asriTDGPage.ddl_Protection_Type.click();
//		asriTDGPage.ddl_selectNetwork.click();
//		waitABit(2000);
//		for (int i = 0; i < 2; i++) {
//			String CVLAN = getDriver().findElement(By.xpath("(//select[contains(@id,'Preservation')])[1]")).getText();
//			System.out.println("CVLAN Status : " + CVLAN);
//			if (CVLAN.contains("Yes")) {
//				System.out.println("CVLAN Alredy Updated");
//			} else {
//				System.out.println("Updating CVLAN");
//				asriTDGPage.ddl_CVLAN_ID.click();
//				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			}
//		}
//		waitABit(2000);
//		asriTDGPage.tbx_CVLAN_1.sendKeys("5");
//		waitABit(2000);
//		asriTDGPage.tbx_CVLAN_2.sendKeys("5");
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
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloadingasri(asriTDGPage);
//		waitABit(5000);
//	}
//
//	@Step
//	public void the_product_should_be_staged_at_TDG() {
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
////		Assert.assertEquals("Validation Status", true,
////				"textarea[@readonly='true']".contains("No Validation Exception!"));
//		waitABit(5000);
//		// getDriver().close();
//	}
//
//	@Step
//	public void i_complete_the_order_and_push_the_order_to_AP() {
//		customwaitforpageloading();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_complete.click();
//		System.out.println("clicked on Complete");
//		waitABit(120000);
//		getDriver().switchTo().parentFrame();
//		System.out.println("*** TDG Completed, Order Pushed to AP ***");
//		waitABit(1000000);
//	}
//}
