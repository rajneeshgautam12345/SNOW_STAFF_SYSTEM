package com.ctl.it.qa.Test_Four.tools.steps.ease;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.Test_Four.tools.pages.common.EasePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.FlightDeckPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.ServiceNowSteps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class EaseSteps extends E2ESteps {
	EasePage easePage;

	@Step
	public void logs_in_ease_Application() {

		String userType="Valid";
		String easeUrl = envData.getFieldValue("Ease");
		String myUser =envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_uname");
		String myUserPassword = envData.getContainer("Ease").getFieldValue("tbx_password");
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().navigate().to(easeUrl);		
		System.out.println("Url is entered");
		easePage.goToLoginPage.click();
		easePage.module.selectByVisibleText("Access");
		easePage.username.waitUntilClickable().withTimeoutOf(90, TimeUnit.SECONDS);
		easePage.username.sendKeys(myUser);
		waitABit(1000);
		easePage.password.sendKeys(myUserPassword);
		waitABit(1000);
		easePage.loginButton.click();
		
	}

	@Step
	public void Click_On_Search() {
		Actions a1=new Actions(getDriver());
		a1.moveToElement(easePage.orderTab).build().perform();
		a1.moveToElement(easePage.search).click().build().perform();
		
	}

	
}
	


