//package com.ctl.it.qa.Test_Four.tools.asristeps;
//
//import java.time.Duration;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.ctl.it.qa.staf.Steps;
//
//import net.serenitybdd.core.pages.WebElementFacade;
//
//@SuppressWarnings("serial")
//public abstract class AsriStep extends Steps {
//	public int count = 0;
//
//	public void customClickableWait(WebElementFacade element) {
//		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(120));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
//
//	public void customVisibilityWait(WebElementFacade element) {
//		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(120));
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public void customwaitforpageloading() {
//		waitABit(20000);
//	}
//
//	public void getserviceIconEnable(boolean isIconEnable, WebElementFacade iconElement) {
//		while (isIconEnable && count < 10) {
//			waitABit(20000);
//			iconElement.click();
//			System.out.println("clicked on hierachy");
//			count++;
//		}
//	}
//}
