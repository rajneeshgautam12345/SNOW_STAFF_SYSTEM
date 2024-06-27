package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.Test_Four.tools.pages.eservices.ExistingOpportunityPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.NewOpportunityPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.OpportunityPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg2Page;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkg3Page;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.ProductPkgPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.QuotePage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class DIASteps extends BaseStep {
	LoginPage loginpage;
	OpportunityPage opportunitypage;
	NewOpportunityPage newopportunitypage;
	ProductPage productpage;
	ProductPkgPage productpkgpage;
	ProductPkg2Page productpkg2page;
	ProductPkg3Page productpkg3page;
	ExistingOpportunityPage existingopportunitypage;
	QuotePage quotepage;
	IntDataContainer Container1 = envData.getContainer("TEST2");
	String SM = null;
	String opportunityid = null;
	String businessorderid = null;
	String sess = null;

	@Step
	public void i_create_a_scenario_for_the_product_DIA_for_the_A_end_location(String a_end) {
		shouldExist(productpage);
		customClickableWait(productpage.btn_new_product_pkg);
		productpage.btn_new_product_pkg.click();
		shouldExist(productpkgpage);
		System.out.println("Creating New Product Package");
		customClickableWait(productpkgpage.tbx_address);
		productpkgpage.tbx_address.sendKeys(a_end);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@ng-bind-html,'result.AddressLinesJoinedForDisplay')]")));
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		customwaitforpageloading(productpkgpage);
		String first_address = getDriver().findElement(By.xpath("//a[@class='grid-link']")).getText();
		System.out.println("First Address : " + first_address);
		productpkgpage.btn_edit_location.click();
		waitABit(5000);
		productpkgpage.btn_edit_location_arrow.click();
		waitABit(1000);
		productpkgpage.btn_edit_location_arrow.click();
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		customClickableWait(productpkgpage.btn_next);
		productpkgpage.btn_next.click();
		System.out.println("A end Address Selected");
		customwaitforpageloading(productpkg3page);
		getDriver().switchTo().defaultContent();
		shouldExist(productpkg3page);
		WebElement frame2 = getDriver().findElement(By.id("quote-iframe"));
		getDriver().switchTo().frame(frame2);
		customClickableWait(productpkg3page.lst_product);
		productpkg3page.lst_product.click();
		waitABit(1000);
		customClickableWait(productpkg3page.lst_product_DIA);
		productpkg3page.lst_product_DIA.click();
		String firstproduct = getDriver().findElement(By.xpath("(//span[@class='k-input'])[4]")).getText();
		System.out.println("1st Product Selected : " + firstproduct);
		customClickableWait(productpkg3page.btn_new_product);
		productpkg3page.btn_new_product.click();
		waitABit(3000);
		customwaitforpageloading(productpkg3page);
		waitABit(3000);
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(frame2);
		waitABit(3000);
		customClickableWait(productpkg3page.ddl_DIA_bandwidth);
		productpkg3page.ddl_DIA_bandwidth.selectByVisibleText("GigE ");
		waitABit(3000);
		customwaitforpageloadingipvpn(productpkg3page);
		customClickableWait(productpkg3page.ddl_DIA_sub_bandwidth);
		productpkg3page.ddl_DIA_sub_bandwidth.selectByVisibleText("100 Mbps ");
		waitABit(3000);
		customwaitforpageloadingipvpn(productpkg3page);
		customClickableWait(productpkg3page.ddl_ipvpn_building);
		productpkg3page.ddl_ipvpn_building.selectByVisibleText("Standard Delivery - To the MPoE (Customer Provided) ");
		waitABit(3000);
		customwaitforpageloadingipvpn(productpkg3page);
		waitABit(5000);
		customClickableWait(productpkg3page.ddl_DIA_billing);
		productpkg3page.ddl_DIA_billing.selectByVisibleText("Flat Rate ");
		waitABit(3000);
		customwaitforpageloadingipvpn(productpkg3page);
		waitABit(10000);
		customClickableWait(productpkg3page.btn_ipvpn_continue);
		productpkg3page.btn_ipvpn_continue.click();
		waitABit(5000);
		customClickableWait(productpkg3page.btn_ipvpn_continue);
		productpkg3page.btn_ipvpn_continue.click();
		waitABit(5000);
		customClickableWait(productpkg3page.btn_ipvpn_continue);
		productpkg3page.btn_ipvpn_continue.click();
		waitABit(5000);
		customClickableWait(productpkg3page.btn_ipvpn_continue);
		productpkg3page.btn_ipvpn_continue.click();
		waitABit(5000);
		customClickableWait(productpkg3page.btn_DIA_finish);
		productpkg3page.btn_DIA_finish.click();
		waitABit(5000);
		customwaitforpageloadingipvpn(productpkg3page);
		customwaitforpageloading(productpkg3page);
	}

	@Step
	public void i_perform_the_profitability_analysis_for_DIA() {
		customwaitforpageloading(productpage);
		getDriver().switchTo().defaultContent();
		WebElement frame3 = getDriver().findElement(By.id("quote-iframe"));
		getDriver().switchTo().frame(frame3);
		customwaitforpageloading(productpage);
		customClickableWait(productpage.btn_discount_profitability);
		productpage.btn_discount_profitability.click();
		System.out.println("Discounting Profitability Checking");
		customClickableWait(productpage.btn_save);
		for (int i = 0; i < 10; i++) {
			String ProfitPass = getDriver()
					.findElement(
							By.xpath("//*[@id=\"ProductTree\"]/div/div[3]/table/tfoot/tr/td[4]/div/div[2]/div[1]/div"))
					.getText();
			System.out.println("Profit Pass Status : " + ProfitPass);
			if (!ProfitPass.contains("Profit Pass")) {
				System.out.println("Profit Not Passed");
				productpage.btn_save.click();
				customwaitforpageloading(productpage);
				getDriver().switchTo().defaultContent();
				getDriver().switchTo().frame("quote-iframe");
				customClickableWait(productpage.btn_discount_profitability);
				productpage.btn_discount_profitability.click();
				System.out.println("Discounting Profitability Checking Again");
				customClickableWait(productpage.btn_save);
			} else {
				System.out.println("Profit Passed; Saving the Status");
				productpage.btn_save.click();
				customwaitforpageloading(productpage);
				break;
			}
		}
	}
}
