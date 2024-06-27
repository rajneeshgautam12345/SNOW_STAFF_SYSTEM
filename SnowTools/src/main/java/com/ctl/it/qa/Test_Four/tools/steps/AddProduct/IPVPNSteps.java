package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.IPVPNPortAccess;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class IPVPNSteps extends E2ESteps {
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	IPVPNPortAccess ipvnportaccess;

///////IP VPN Port Access
	@Step
	public void user_adds_eip_vpn_port_access_product(String smyproduct, String access, String buildingExt,
			String Spec_Design) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		// Long tempNum=Math.round(Math.random()*100000);
		// String mySPCRID=String.valueOf(tempNum);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		// String myEnv=System.getProperty("staf.environment.key");
		configureIPVPNPortAndAccess();
//		this.addNewProduct(); // add the product here
//		ipvnportaccess.ddl_ddlAddress.waitUntilEnabled(); // open address
//		ipvnportaccess.ddl_ddlAddress.click(); // open address
//		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // pick the first address
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		// getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick the
		// first address
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for extended deliver");
//		}
		ipvnportaccess.ddl_transport.waitUntilEnabled().waitUntilClickable(); // open access box
		ipvnportaccess.ddl_transport.click();
		waitABit(2000);
		ipvnportaccess.waitForTextToAppear("10GIG", 2000); // Wait for Upload
		ipvnportaccess.ddl_transport.selectByVisibleText(access);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for extended deliver");
		}
		try {
			// executor.executeScript("arguments[0].click();",
			// ipvnportaccess.ddl_insidewiring); // Select Building Extension Drop down
			// ipvnportaccess.ddl_insidewiring.waitUntilClickable().click(); // Select
			// Building Extension Drop down
//			productPage.waitForTextToAppear("Extend", 2000); // Wait for Upload;
//			waitABit(2000);
//			ipvnportaccess.ddl_insidewiring.selectByVisibleText(buildingExt);
		} catch (Exception e) {
			System.out.println("building extension already set");
		}
//
		executor.executeScript("arguments[0].scrollIntoView(true);", ipvnportaccess.ddl_MultiServiceSelection);
		ipvnportaccess.ddl_MultiServiceSelection.waitUntilClickable(); // open access box
		waitABit(2000);
		executor.executeScript("arguments[0].click();", ipvnportaccess.ddl_MultiServiceSelection);
		// ipvnportaccess.ddl_MultiServiceSelection.click();
		waitABit(2000);
		ipvnportaccess.waitForTextToAppear("Aggregate", 2000); // Wait for Upload
		ipvnportaccess.ddl_MultiServiceSelection.selectByVisibleText("No");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for extended deliver");
		}
//	
//	ipvnportaccess.ddl_TotalVPNCIR.waitUntilEnabled().waitUntilClickable(); // open access box 
//	ipvnportaccess.ddl_TotalVPNCIR.click();
//	waitABit(2000);
//	ipvnportaccess.waitForTextToAppear("0 Mbps", 2000); // Wait for Upload
//	ipvnportaccess.ddl_TotalVPNCIR.selectByVisibleText("10 Mbps");
//	myflag = WaitAndSync();
//	if (myflag) {
//		 System.out.println("error in WaitAndSync for extended deliver");
//	}
//	
//	if (smyproduct.equals("IP VPN Port and Access_Internet_Agg")) {
//		this.setIPVPN_Internet();  //pick out managed router
//	}
		if (smyproduct.equals("IP VPN Port and Access_router")) {
			this.setManageRouter(); // pick out managed router
		} else if (smyproduct.equals("IP VPN Port and Access_Managed_IAD")) {
			this.setManaged_IAD(); // pick out managed router
		} else if (smyproduct.equals("IP VPN Port and Access_OSS")) {
			this.set_Onsite_Support_Services(); // pick out managed router
		} else if (smyproduct.equals("IP VPN Port and Access_Managed_TSP")) {
			this.set_Telecom_Service_Priority(); // pick out managed router
		} else if (smyproduct.equals("IP VPN Port and Access_Diversity")) {
			this.set_Diversity(); // pick out managed router
		} else {
			waitABit(4000);
			WebElement element1 = getDriver().findElement(By.id("btnAttribContinue")); // update
			JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
			jse1.executeScript("arguments[0].click()", element1);
			if (myflag) {
				System.out.println("error in WaitAndSync for Finsih button to visible");
			}
			// WebElement continue_element =
			// getDriver().findElement(By.id("btnAttribContinue"));
			// continue_element.click()
			// ipvnportaccess.btn_continue.click(); // click the continue button
//		 waitABit(4000);
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//		 waitABit(1000);
//		ipvnportaccess.txt_spcrid.type(mySPCRID); // add a number in spcrid field
//		ipvnportaccess.btn_continue.click(); // click the continue button
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		WebElement element = getDriver().findElement(By.id("btnfinish"));
		waitABit(2000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click()", element);
		// element.click();
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for access");
		}
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}

	private void configureIPVPNPortAndAccess() {
		productPage.waitForTextToAppear("Select a product", 40000);
		waitABit(5000);
		getDriver().findElement(By.xpath("(//span[text()='IP VPN Port and Access']/..)[1]")).click();
		System.out.println("IPVPN Products added");
		waitABit(10000);
		getDriver().findElement(By.xpath("//span[text()='Proceed to Configure']/..")).click();
		System.out.println("Successfully clicked on configure");
		Boolean myflag;
		productPage.waitForTextToAppear("IP VPN Port and Access"); // Wait for Upload
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
	}
}
