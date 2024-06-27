package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.pages.WebElementFacade;

@SuppressWarnings("serial")
public abstract class BaseStep extends Steps {
	public int count = 0;

	public void customClickableWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void customVisibleWaitism(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customVisibleWaitBAN(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customwaitforpageloading(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(800))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='k-loading-image']"));
		System.out.println("Page Loading Circle is being Displayed");
		// waitABit(5000);
	}

	public void customwaitforpageloadingbilling(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(800))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[@class='popupBackground'])[1]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingipvpn(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(300))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='lds-ellipsis']"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingism(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(250))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[contains(.,'Auto signing...')])[4]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingasri(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(250)).waitForElementsToDisappear(
				org.openqa.selenium.By.xpath("//button[@class='btn btn-primary'][contains(.,'Loading...')]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public boolean isalertpresent() {
		boolean presentFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30000));
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("Alert is Not Present");
			} else {
				Alert alert = getDriver().switchTo().alert();
				alert.accept();
				System.out.println("Alert was Present and Accepted");
				presentFlag = true;
			}
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return presentFlag;
	}

	public void customVisibilityWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customwaitforpageloading() {
		waitABit(20000);
	}

	public void customwaitforpageloading2() {
		waitABit(2000);
	}

	public void customwaitforpageloading5() {
		waitABit(5000);
	}

	public void getserviceIconEnable(boolean isIconEnable, WebElementFacade iconElement) {
		while (isIconEnable && count < 10) {
			waitABit(20000);
			iconElement.click();
			System.out.println("clicked on hierachy");
			count++;
		}
	}

	public Boolean waitForSwiftProgressBar(Page page) {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(5000);
				if (page.isElementVisible(By.xpath("//*[@id='ajax-spinner']/div/div[1]"))) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(3000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}
}