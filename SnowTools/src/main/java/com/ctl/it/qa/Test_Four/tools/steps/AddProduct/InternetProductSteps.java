package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class InternetProductSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// Internet
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_internet_product(String smyproduct, String transport, String bandwidth, String buildingExt,
			String router) {
		Boolean myflag;
		// Actions action = new Actions(getDriver());
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		if (smyproduct.equals("Internet")) {
			if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
				productPage.lst_productdd.click();// Select Product Dropdown
			} else {
				productPage.lst_productdd_e2e.click();// Select Product Dropdown
			}
			waitABit(2000);
			waitABit(1000);
			productPage.lst_internet.click();// Select Product Dropdown
			// productPage.lst_internet
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("Internet").click().perform();
			// //Select bandwidth
			// productPage.lst_internet_productvalue.selectByValue(smyproduct); // Select
			// the product out of list box using smyproject
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  select Internet");
			}
			productPage.btn_newproduct.click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product 2");
			}
		}
		if (transport.equals("DS-3")) {
			productPage.lst_tranport.click(); // Select Bandwidth Dropdown DS-3
			waitABit(3000);
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("DS").click().perform();
			// //Select bandwidth
			getDriver().switchTo().activeElement().sendKeys("Ethernet 10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
		}
		try {
			if (bandwidth.equals("20 Mbps")) {
				System.out.println(" in bandwith for  send key 20");
				waitABit(3000);
				productPage.lst_internetbandwidth.waitUntilPresent().waitUntilEnabled().waitUntilClickable()
						.withTimeoutOf(120, TimeUnit.SECONDS).click();
				// action.moveToElement(getDriver().findElement(By.xpath("//*[@id='AttributeForm']"))).sendKeys("20").click().perform();
				// //Select evc bandwidth value
				getDriver().switchTo().activeElement().sendKeys("2", Keys.ENTER);
				System.out.println("picked  in bandwith for  send key 20");
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in wait and sync send key 20");
				}
				System.out.println("out of  in bandwith for  send key 20");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (buildingExt.equals("Standard_Delivery")) {
			productPage.lst_buildingext_internet_dd.click(); // Select Building Extension Drop down
			waitABit(3000);
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("s").click().perform();
			// //standard Deliver
			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for extended deliver");
			}
		}
		try {
			if (router.equals("CISCO")) {
				System.out.println(" in ROUNTER for  send key ");
				productPage.lst_evcportbandwidth.waitUntilPresent().waitUntilEnabled().waitUntilClickable()
						.withTimeoutOf(120, TimeUnit.SECONDS).click();
				waitABit(3000);
				// action.moveToElement(getDriver().findElement(By.xpath("//*[@id='AttributeForm']"))).sendKeys(router).click().perform();
				// //Select evc bandwidth value
				getDriver().switchTo().activeElement().sendKeys("CISCO", Keys.ENTER);
				System.out.println("picked  in bandwith for  send key router");
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in wait and sync send key router");
				}
				System.out.println("router");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		singleLocationNextandDiscount(); // this function does all the next and discount buttons
	}
}
