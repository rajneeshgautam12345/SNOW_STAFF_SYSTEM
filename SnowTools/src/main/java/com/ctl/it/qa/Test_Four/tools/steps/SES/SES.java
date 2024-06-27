package com.ctl.it.qa.Test_Four.tools.steps.SES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SES extends SfaPage {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	// LoginPage loginpge;
	// SES sespage;
	@FindBy(xpath = "//*[contains(@id,'tvUserApplicationn')]//img[(@alt='Expand SES')]")
	public WebElementFacade tab_SES;
	@FindBy(xpath = "//a[contains(text(),'My Services')]")
	public WebElementFacade tab_My_Services;
	@FindBy(xpath = "//select[contains(@id, 'DropDownList_SESStatus')]")
	public WebElementFacade any_status;
	@FindBy(xpath = "//select[contains(@id, 'Dropdownlist_FilterSpecialist')]")
	public WebElementFacade assigned_to;
	@FindBy(xpath = "//input[contains(@id,'Textbox_CustOrderID')]")
	public WebElementFacade ses_cust_Order_ID;
	@FindBy(xpath = "//input[contains(@id,'Button_Search')]")
	public WebElementFacade ses_search_Order_ID;
	@FindBy(xpath = "//select[contains(@id, 'DropDownList_SESStatus')]")
	public WebElementFacade Provisioning_status;
	@FindBy(xpath = "//input[contains(@id, 'Button_SendToKenan')]")
	public WebElementFacade Button_SendToKenan;

	@Step
	public void open_SES_URL() {
		openAt(envData.getFieldValue("SESurl")); // the ses url from the e2e.xml
	}

	@Step
	public void navigate_To_SES_Module() {
		waitABit(3000);
		tab_SES.click();
	}

	@Step
	public void navigate_To_My_Services_Module() {
		tab_My_Services.waitUntilEnabled();
		tab_My_Services.click();
		waitABit(3000);
	}

	@Step
	public void search_Order_ID() {
		getDriver().switchTo().frame("frmContent");
		Select ses_any_status = new Select(any_status);
		ses_any_status.selectByVisibleText("[any status]");
		waitABit(2000);
		Select ses_assigned_to = new Select(assigned_to);
		ses_assigned_to.selectByVisibleText("[any specialist]");
		String nSwiftID = System.getProperty("Swift.ID");
		ses_cust_Order_ID.sendKeys(nSwiftID);
		// ses_cust_Order_ID.sendKeys("553198977");
		ses_search_Order_ID.waitUntilEnabled();
		ses_search_Order_ID.click();
		// *[@id="DataGrid_Orders"]/tbody/tr
		waitABit(2000);
		for (int i = 2; i <= 5; i++) {
			String allRecords1 = "//*[@id='DataGrid_Orders']/tbody/tr[";
			String allRecords2 = "]/td[2]";
			WebElement allrecords = getDriver().findElement(By.xpath(allRecords1 + i + allRecords2));
			String sesOrderId = allrecords.getText();
			if (sesOrderId.equals(nSwiftID)) {
				System.out.println("Order id Matched successfully");
			}
		}
		// *[@id="DataGrid_Orders"]/tbody/tr[2]/td[2]
	}

	@Step
	public void send_to_Kenan() {
		for (int j = 2; j <= 5; j++) {
			String allRecords3 = "//*[@id='DataGrid_Orders']/tbody/tr[";
			String allRecords4 = "]/td/a";
			WebElement scid_records = getDriver().findElement(By.xpath(allRecords3 + j + allRecords4));
			scid_records.click();
			Select ses_Provisioning_status = new Select(Provisioning_status);
			ses_Provisioning_status.selectByVisibleText("Complete");
			Button_SendToKenan.click();
			waitABit(3000);
			getDriver().switchTo().defaultContent();
			tab_My_Services.click();
			waitABit(2000);
			getDriver().switchTo().frame("frmContent");
			// updated
		}
	}

	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return tab_My_Services;
	}
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Step
	public void logs_in_Ease_Application() {
		
		String userType="Valid";
		String FDUrl = envData.getFieldValue("Ease");
		String myUser =envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_uname");
		String myUserPassword = envData.getContainer("Ease").getFieldValue("tbx_password");
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().navigate().to(FDUrl);		
		System.out.println("Url is entered");
		
		
	}
	
}
