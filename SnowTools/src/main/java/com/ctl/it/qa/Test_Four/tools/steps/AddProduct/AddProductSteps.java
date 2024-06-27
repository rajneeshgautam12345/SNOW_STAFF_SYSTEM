package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class AddProductSteps extends E2ESteps {
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;

	@Step
	public void user_adds_product(String smyproduct, String sNet, String bandwidth, String uniType, String buildingExt,
			String evc_Type, String e_bandwidth, String e_class, String linear_diverse) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		System.setProperty("myNet.ID", sNet); // set the net status into memory
		String sNetType = System.getProperty("myNet.ID"); // get the net status from memory
		System.out.println("the net status  is  " + sNetType); // print out net status type
		System.setProperty("myEVC.ID", evc_Type); // set the net status into memory
		String sEVCType = System.getProperty("myEVC.ID"); // get the net status from memory
		System.out.println("the s EVC Type  is  " + sEVCType); // print out net status type
		String myEnv = System.getProperty("staf.environment.key");
//UNIs
		this.addNewProduct(); // add the product here
		// executor.executeScript("arguments[0].click();", productPage.lst_addressdd);
		// // Select Product Dropdown
		productPage.ddl_wavelenth_A_address.click();// Select Product Dropdown
		waitABit(1000);
		// executor.executeScript("arguments[0].click();",
		// productPage.lst_address1value); // Address 1 Select
		// productPage.lst_address1value.waitUntilPresent().click(); // Address 1 Select
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(100);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 1");
		}
		if (sNet.equals("Off Net")) {
			System.out.println("sNet is:" + sNet);
			String myTemp = productPage.ddl_network_status.getText();
			System.out.println("the value in box is: " + myTemp);
			if (myTemp.equals("On Net")) {
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				executor.executeScript("arguments[0].click();", productPage.ddl_network_status); // select off next
				// productPage.ddl_network_status.click(); // select off next
				waitABit(1000);
				executor.executeScript("arguments[0].click();", productPage.lst_off_net);
				// productPage.lst_off_net.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for off net");
				}
			}
			executor.executeScript("arguments[0].click();", productPage.lst_uniportbandwidth); // Select UNI Bandwidth
																								// Dropdown
			productPage.lst_uniportbandwidth.click(); // Select UNI Bandwidth Dropdown
			waitABit(1000);
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("10").click().perform();;
			// //Select EVP
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for lst_uniportbandwidth");
			}
			executor.executeScript("arguments[0].click();", productPage.lst_classdd); // Bandwidth
			// productPage.lst_classdd.click(); //Bandwidth
			waitABit(1000);
			// productPage.lst_bandwidth_off_net.click();
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("10").click().perform();
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for lst_uniportbandwidth");
			}
			if (uniType.equals("Multiplexed")) {
				// executor.executeScript("arguments[0].click();", productPage.lst_unitypedd);
				// // Select Type Drop down
				productPage.lst_insideWiring.click(); // Select Type Drop down
				waitABit(1000);
				// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("m").click().perform();
				// //Select Multiplexed
				getDriver().switchTo().activeElement().sendKeys("m", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for multiplexed");
				}
			}
			if (e_class.equals("Basic")) {
				executor.executeScript("arguments[0].click();", productPage.lst_elan_bandwidth);
				// productPage.lst_elan_bandwidth.click();
				waitABit(1000);
				// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("B").click().perform();
				// //Select EVC class
				getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Basic");
				}
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			if (buildingExt.equals("Standard_Delivery")) {
				executor.executeScript("arguments[0].click();", productPage.ddl_evetype); // Select Building Extension
																							// Drop down
				// productPage.ddl_evetype.click(); // Select Building Extension Drop down
				// ction.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("s").click().perform();
				// //standard Deliver
				getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for standard deliver");
				}
			}
			if (buildingExt.equals("Extend_Delivery")) {
				executor.executeScript("arguments[0].click();", productPage.ddl_evetype); // Select Building Extension
																							// Drop down
				// productPage.ddl_evetype.click(); // Select Building Extension Drop down
				getDriver().switchTo().activeElement().sendKeys("E", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for standard deliver");
				}
			}
		} // end of off net
		else {
			// executor.executeScript("arguments[0].click();",
			// productPage.lst_uniportbandwidth); // Select UNI Bandwidth Dropdown
			productPage.lst_uniportbandwidth.click(); // Select UNI Bandwidth Dropdown
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for lst_uniportbandwidth");
			}
//			if (uniType.equals("Multiplexed")) {
//				//executor.executeScript("arguments[0].click();", productPage.lst_unitypedd); // Select Type Drop down
//				productPage.lst_unitypedd.click(); // Select Type Drop down
//				productPage.WaitForPageToLoad(30);
//				getDriver().switchTo().activeElement().sendKeys("m", Keys.ENTER); 
//				myflag = WaitAndSync();
//				if (myflag) {
//					System.out.println("error in WaitAndSync for multiplexed");
//				}
//			}
			productPage.lst_unitypedd.click(); // Select Type Drop down
			getDriver().switchTo().activeElement().sendKeys(uniType, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for multiplexed");
			}
			if (buildingExt.equals("Standard_Delivery")) {
				// executor.executeScript("arguments[0].click();",
				// productPage.lst_dia_billmethod); // Select Building Extension Drop down
				productPage.lst_insideWiring.click(); // Select Building Extension Drop down
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Standard_Delivery");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			}
			if (buildingExt.equals("Extend_Delivery")) {
				executor.executeScript("arguments[0].click();", productPage.lst_dia_billmethod); // Select Building
																									// Extension Drop
																									// down
				// productPage.lst_dia_billmethod.click(); // Select Building Extension Drop
				// down
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("E", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Extend_Delivery");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			}
		} // end else
//UNI Next Buttons	
		executor.executeScript("arguments[0].click();", productPage.btn_prodconfignext); // Product Configuration Next
																							// Button
		// productPage.btn_prodconfignext.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
		// // Product Configuration Next Button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for product config next button ");
		}
		executor.executeScript("arguments[0].click();", productPage.btn_prodconfirmnext); // Child Products Next Button
		// productPage.btn_prodconfirmnext.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
		// // Child Products Next Button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for child product next button");
		}
		executor.executeScript("arguments[0].click();", productPage.btn_prodsave); // Save Product Button
		// productPage.btn_prodsave.waitUntilClickable().click(); // Save Product Button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for save product button");
		}
		if (evc_Type.equals("EVPL") || evc_Type.equals("eLync_EVC")) {
			// ELINE - EVC and eLynk_EVC
			executor.executeScript("arguments[0].click();", productPage.btn_newproduct2); // New Product
			// productPage.btn_newproduct2.click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product");
			}
			productPage.cbox_selectAllCheckBox.click();// select all check box
			// executor.executeScript("arguments[0].click();", productPage.chk_addresses);
			// // Select Addresses
			// productPage.chk_addresses.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
			// // Select Addresses
			// productPage.chk_addresses.click(); // Select Addresses
			// waitABit(3000);
			// productPage.moveTo("#countrySelect");
			productPage.WaitForPageToLoad(30);
			executor.executeScript("arguments[0].click();", productPage.btn_next); // Next Button
			// productPage.btn_next.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
			// // Next Button
			// productPage.btn_next.click(); // Next Button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for next button");
			}
			if (smyproduct.equals("UNI")) {
				if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
					executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product
																								// Dropdown
					// productPage.lst_productdd.click();// Select Product Dropdown
				} else {
					executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product
																									// Dropdown
					// productPage.lst_productdd_e2e.click();// Select Product Dropdown
				}
				waitABit(2000);
			}
			if (evc_Type.equalsIgnoreCase("EVPL")) {
				executor.executeScript("arguments[0].click();", productPage.lst_productvalue2); // Select Eline
				// productPage.lst_productvalue2.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
				// // Select Eline
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for select Eline");
				}
			}
			if (evc_Type.equalsIgnoreCase("eLync_EVC")) {
				executor.executeScript("arguments[0].click();", productPage.lst_eLynk); // Select eLync
				// productPage.lst_eLynk.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
				// // Select Eline
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for select eLync_EVC");
				}
			}
			executor.executeScript("arguments[0].click();", productPage.btn_newproduct); // New Product
			// productPage.btn_newproduct.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
			// // New Product
			// productPage.btn_newproduct.waitUntilClickable().click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for New Product");
			}
			executor.executeScript("arguments[0].click();", productPage.lst_addressdd); // Select Address Drop down
			// productPage.lst_addressdd.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();//
			// Select Address Drop down
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for select address Drop down");
			}
			executor.executeScript("arguments[0].click();", productPage.lst_address1value); // Address 1 Select
			// productPage.lst_address1value.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
			// // Address 1 Select
			waitABit(2000);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 1");
			}
			waitABit(1000);
			if (evc_Type.equals("EVPL")) {
				try {
					executor.executeScript("arguments[0].click();", productPage.lst_relatedProductSearch_relALoc_UNI); // open
																														// A
																														// Loc
					// productPage.lst_relatedProductSearch_relALoc_UNI.click(); // open A Loc
					waitABit(1000);
					executor.executeScript("arguments[0].click();", productPage.rdo_relALoc_UNI_radio);
					// productPage.rdo_relALoc_UNI_radio.click(); // click the radio button
					getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key");
					}
					try {
						executor.executeScript("arguments[0].click();", productPage.btn_x_close_1);
						// productPage.btn_x_close_1.click(); // close the pop up
					} catch (Exception e) {
						System.out.println(e);
					}
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key");
					}
					executor.executeScript("arguments[0].click();", productPage.lst_relatedProductSearch_relZLoc_UNI);
					// productPage.lst_relatedProductSearch_relZLoc_UNI.click(); // open z loc
					waitABit(2000);
					executor.executeScript("arguments[0].click();", productPage.relZLoc_UNI_radio);
					// productPage.relZLoc_UNI_radio.click(); // click the radio button
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key");
					}
					try {
						executor.executeScript("arguments[0].click();", productPage.btn_x_close_2);
						// productPage.btn_x_close_2.click(); // close the pop up
					} catch (Exception e) {
						System.out.println(e);
					}
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				try {
					executor.executeScript("arguments[0].click();", productPage.lst_evcclass);
					// productPage.lst_evcclass.withTimeoutOf(20,
					// TimeUnit.SECONDS).waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
					// productPage.waitForTextToAppear("EPL", 20000); // Wait for Upload;
					waitABit(3000);
					getDriver().switchTo().activeElement().sendKeys("EV", Keys.ENTER);
					myflag = WaitAndSync();
					System.out.println(" out of WaitAndSync for  send key Ev");
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key Ev");
						waitABit(5000);// don not change timing issue
					}
				} catch (Exception e) {
					System.out.println("NOTICE EVPL already picked");
				}
				try {
					if (e_bandwidth.equals("20 Mbps")) {
						System.out.println(" in bandwith for  send key 20");
						executor.executeScript("arguments[0].click();", productPage.lst_evcportbandwidth);
						// productPage.lst_evcportbandwidth.waitUntilPresent().waitUntilEnabled().waitUntilClickable().withTimeoutOf(120,
						// TimeUnit.SECONDS).click();
						productPage.waitForTextToAppear("2 Mbps", 20000); // Wait for Upload;
						getDriver().switchTo().activeElement().sendKeys("20", Keys.ENTER);
						System.out.println("picked  in bandwith for  send key 20");
						myflag = WaitAndSync();
						if (myflag) {
							System.out.println("error in WaitAndSync for  send key 20");
						}
						System.out.println("out of  in bandwith for  send key 20");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				try {
					if (e_class.equals("Basic")) {
						System.out.println(" in e_class for  send key b");
						executor.executeScript("arguments[0].click();", productPage.ddl_pickclass);
						// productPage.ddl_pickclass.waitUntilPresent().waitUntilEnabled().waitUntilClickable().withTimeoutOf(120,
						// TimeUnit.SECONDS).click();
						productPage.waitForTextToAppear("Basic", 20000); // Wait for Upload;
						getDriver().switchTo().activeElement().sendKeys("Basic", Keys.ENTER);
						System.out.println("picked  in bandwith for  send key e_class");
						myflag = WaitAndSync();
						if (myflag) {
							System.out.println("error in WaitAndSync for  send key e_class");
						}
						System.out.println("out of  in bandwith for  send keye_class");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("waiting 3 ");
//	   if (linear_diverse.equals("No")) {
//		   productPage.lst_linear_diverse.waitUntilPresent().waitUntilEnabled().waitUntilClickable().withTimeoutOf(120, TimeUnit.SECONDS).click();
//		   waitABit(3000);
//		   getDriver().switchTo().activeElement().sendKeys("n", Keys.ENTER); 
//	   	   waitABit(1000);
//	   	System.out.println("AT no");
//	   	myflag = WaitAndSync();
//		if (myflag) {
//			 System.out.println("error in WaitAndSync for  send key n");
//		}
//		 waitABit(5000);// don not change timing issue 
//		 
//		 
//		 
//	   }
			} // end of eline evc
			if (evc_Type.equals("eLync_EVC")) {
				try {
					executor.executeScript("arguments[0].click();", productPage.lst_relatedProductSearch_relUNI); // click
																													// on
																													// UNI
																													// drop
																													// down
					// productPage.lst_relatedProductSearch_relUNI.click(); // click on UNI drop
					// down
					waitABit(2000);
					productPage.rdo_elan_uni.click(); // click on radio button
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for  send key lst_relatedProductSearch_relUNI");
					}
				} catch (Exception e) {
					productPage.btn_x_close.click();// press the x close in pop up
					System.out.println(e);
				}
				executor.executeScript("arguments[0].click();", productPage.lst__encryption_wl); // open the destination
																									// type list box
																									// using encryption
																									// list box code
				// productPage.lst__encryption_wl.click(); // open the destination type list box
				// using encryption list box code
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("Private", Keys.ENTER);// pick private
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for  send key private");
				}
				executor.executeScript("arguments[0].click();", productPage.lst_billing_type_dd); // open the
																									// destination list
																									// box using this
																									// existing list box
																									// code
				// productPage.lst_billing_type_dd.click(); // open the destination list box
				// using this existing list box code
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("Center", Keys.ENTER);// pick Center for Shared Services
																						// - Ashburn
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for  send key center");
				}
				executor.executeScript("arguments[0].click();", productPage.lst_elan_bandwidth); // open the bandwidth
																									// list box using
																									// this existing
																									// list box code
				// productPage.lst_elan_bandwidth.click(); // open the bandwidth list box using
				// this existing list box code
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("20", Keys.ENTER);// pick Center for Shared Services -
																					// Ashburn
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for  send key bandwidth");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.TAB);// pick Center for Shared Services - Ashburn
				executor.executeScript("arguments[0].click();", productPage.lst_evcclass); // open the class list box
																							// using this existing list
																							// box code
				// productPage.lst_evcclass.click(); // open the class list box using this
				// existing list box code
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);// pick Center for Shared Services -
																					// Ashburn
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for  send key class");
				}
			}
		}
		singleLocationNextandDiscount(); // Next Buttons
	}
}
