package com.ctl.it.qa.Test_Four.tools.steps.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.MarketplacePage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class MarketplaceSteps extends E2ESteps {
	MarketplacePage marketplace;
	private final Logger logger = LoggerFactory.getLogger(MarketplaceSteps.class);

	@Step
	public void user_is_in_marketplace_homepage() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ChromeOptions options = new ChromeOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		marketplace.openAt(envData.getFieldValue("MarketPlaceUrl"));
		getDriver().manage().window().maximize();
		waitABit(1000);
		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
		// marketplace.btn_SSO.click(); // click on the single sign in button
		logger.info("Successfully launched the MarketPlace url");
	}

	@Step
	public void enterLocationAddress(String clli) {
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		marketplace.locationAddress.sendKeys(clli);
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(marketplace.address).click().build().perform();
		waitABit(4000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", marketplace.checkAvailability);
		// marketplace.checkAvailability.click();
		for (int i = 0; i <= marketplace.locationStatusMsg.size() - 1; i++) {
			String availabilityMsg = marketplace.locationStatusMsg.get(i).getAttribute("class");
		}
		executor.executeScript("arguments[0].click();", marketplace.addressContinue);
		// marketplace.addressContinue.click();
	}

//	@Step
//	public void enterLocationAddress(String clli) {
//		marketplace.locationAddress.sendKeys(clli);
//		waitABit(2000);
//		marketplace.address.click();
//		waitABit(2000);
//		marketplace.checkAvailability.click();
//		for(int i=0;i<=marketplace.locationStatusMsg.size()-1;i++)
//		{
//		  String availabilityMsg=marketplace.locationStatusMsg.get(i).getAttribute("class");
//		}
//		
//		marketplace.addressContinue.click();
//	 }
	@Step
	public void enterProductDetails(String term, String bandwidth, String billingType, String pdr) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		getDriver().findElement(By.xpath(marketplace.ele1 + term + marketplace.ele2)).click();
		waitABit(2000);
		WebElement bandwidth_Type = getDriver().findElement(By.xpath(marketplace.ele1 + bandwidth + marketplace.ele2));
		executor.executeScript("arguments[0].scrollIntoView(true);", bandwidth_Type);
		waitABit(1000);
		executor.executeScript("arguments[0].click();", bandwidth_Type);
		waitABit(3000);
		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		System.out.println(marketplace.ele1 + billingType + marketplace.ele2);
		WebElement billing_Type = getDriver().findElement(By.xpath(marketplace.ele1 + billingType + marketplace.ele2));
		executor.executeScript("arguments[0].scrollIntoView(true);", billing_Type);
		waitABit(1000);
		executor.executeScript("arguments[0].click();", billing_Type);
		waitABit(5000);
		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		// waitABit(1000);
		executor.executeScript("arguments[0].click();",
				getDriver().findElement(By.xpath(marketplace.ele1 + pdr + marketplace.ele2)));
		waitABit(1000);
		// getDriver().findElement(By.xpath(marketplace.ele1+pdr+marketplace.ele2)).click();
		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(2000);
		executor.executeScript("arguments[0].click();", marketplace.productDetailsContinue);
		waitABit(5000);
	}

	@Step
	public void enterBuildingExtensionDetails(String buildingExtension) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (buildingExtension.equals("Yes")) {
			waitABit(2000);
			executor.executeScript("arguments[0].click();", marketplace.buildingExtensionYes);
			// marketplace.buildingExtensionYes.click();
			waitABit(1000);
		} else {
			waitABit(2000);
			executor.executeScript("arguments[0].scrollIntoView(true);", marketplace.buildingExtensionNo);
			waitABit(1000);
			executor.executeScript("arguments[0].click();", marketplace.buildingExtensionNo);
			// marketplace.buildingExtensionNo.click();
			waitABit(1000);
		}
		waitABit(1000);
		executor.executeScript("arguments[0].click();", marketplace.buildingExtensionContinue);
	}

	@Step
	public void enterManagedRouter(String managedRouter) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (managedRouter.equals("Yes")) {
			executor.executeScript("arguments[0].click();", marketplace.managedRouterYes);
			marketplace.managedRouterYes.click();
			waitABit(1000);
		} else {
			executor.executeScript("arguments[0].click();", marketplace.managedRouterNo);
			// marketplace.managedRouterNo.click();
			waitABit(1000);
		}
		waitABit(1000);
		executor.executeScript("arguments[0].click();", marketplace.managedRouterContinue);
		// marketplace.managedRouterContinue.click();
	}

	@Step
	public void entersiteAccessContact(String firstName, String lastName, String mobileNo, String phoneNo, String email,
			String contactPreference) {
		marketplace.firstName.sendKeys(firstName);
		waitABit(1000);
		marketplace.lastName.sendKeys(lastName);
		waitABit(1000);
		marketplace.mobileNo.sendKeys(mobileNo);
		waitABit(1000);
		marketplace.phoneNo.sendKeys(phoneNo);
		waitABit(1000);
		marketplace.email.sendKeys(email);
		waitABit(2000);
		for (int i = 0; i <= marketplace.contactPreference.size(); i++) {
			String contactPref = marketplace.contactPreference.get(i).getAttribute("value");
			if (contactPref.equals(contactPreference)) {
				marketplace.contactPreference.get(i).click();
			}
		}
		marketplace.saveContact.click();
		waitABit(2000);
		marketplace.contactContinue.click();
		waitABit(2000);
	}

	@Step
	public void enterServiceAddress(String floor, String room) {
		marketplace.floor.selectByVisibleText("Floor");
		waitABit(1000);
		marketplace.floorValue.clear();
		marketplace.floorValue.sendKeys("Floor 1");
		waitABit(2000);
		marketplace.room.selectByVisibleText("Room");
		waitABit(1000);
		marketplace.roomValue.clear();
		marketplace.roomValue.sendKeys("Room 1");
		waitABit(2000);
		marketplace.serviceAddressContinue.click();
		waitABit(2000);
	}

	@Step
	public void enterActivationDate() {
		waitABit(2000);
		marketplace.accept.click();
		waitABit(2000);
		marketplace.continueToCheckout.click();
		waitABit(2000);
	}
}