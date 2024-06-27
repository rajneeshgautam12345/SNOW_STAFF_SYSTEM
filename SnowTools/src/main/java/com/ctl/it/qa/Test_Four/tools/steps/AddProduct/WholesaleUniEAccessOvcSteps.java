package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class WholesaleUniEAccessOvcSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

///////wholesaleUni_e_access_ovc
	@Step
	public void user_adds_wholesaleUni_e_access_ovc(String smyproduct, String sNet, String bandwidth, String port_redun,
			String buildingExt, String evc_Type, String e_bandwidth, String e_class, String uni_type, String product_2,
			String secaddress, String secplcode) {
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
//ENNI
		// wholesale Uni
		this.addNewProduct(); // add the product here
		productPage.lst_tranport.click(); // Select access Dropdown
		productPage.waitForTextToAppear("1 Gbps", 20000); // Wait for Upload;
		if (bandwidth.equals("100 Mbps")) {
			getDriver().switchTo().activeElement().sendKeys("100 Mbps", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (uni_type.equals("Multiplexed")) {
			productPage.lst_unitypedd.click(); // Select Type Drop down
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("m", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for multiplexed");
			}
		}
		if (e_class.equals("Basic")) {
			productPage.lst_elan_bandwidth.click();
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for Basic");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (buildingExt.equals("Standard_Delivery")) {
			productPage.lst_dia_billmethod.click(); // Select Building Extension Drop down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for extended deliver");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		productPage.btn_quicksave.click(); // quick save button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for quick save");
		}
//E_Access OVC
		productPage.btn_createpackage.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		waitABit(2000);
		productPage.chk_addresses.click(); // check the first location check box
		productPage.txt_address.type(secaddress); // Wait for Address box and type
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in myflag = WaitAndSync() for next button");
		}
		getDriver().findElement(By.id(secplcode)).click();
		waitABit(1000);
		productPage.btn_prodconfirmnext.click(); // click the next button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for lst_ip_vpn_port_access");
		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		waitABit(2000);
		productPage.waitForTextToAppear("Adaptive Network Security", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("E-Access - OVC", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for E-Access - OVC");
		}
		productPage.lst_product_new_product.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		productPage.lst_addressdd.click();// Select address Drop down
		waitABit(1000);
		productPage.lst_address1value.click(); // Address 1 Select
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 1");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		productPage.lst_cloud_access_point.click(); // click on cloud access poing
		waitABit(3000);
		productPage.rdo_relCloud_Access_Point_radio.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		try {
			productPage.btn_x_close_1.click(); // close the pop up
		} catch (Exception e) {
			System.out.println(e);
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		productPage.lst_relCustomer_Access_Point.click(); // customer access point
		waitABit(3000);
		productPage.rdo_relCustomer_Access_Point_radio.click();
		try {
			productPage.btn_x_close_2.click(); // close the pop up
		} catch (Exception e) {
			System.out.println(e);
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		productPage.lst_evctypedd.click(); // OVC drop down open
		productPage.waitForTextToAppear("Access-EPL", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("Access-EVPL", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		productPage.lst_evcportbandwidth.click(); // band width drop down
		productPage.waitForTextToAppear("2 Mbps", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("60", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		productPage.ddl_pickclass.click(); // class drop down
		productPage.waitForTextToAppear("Basic", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}
}
