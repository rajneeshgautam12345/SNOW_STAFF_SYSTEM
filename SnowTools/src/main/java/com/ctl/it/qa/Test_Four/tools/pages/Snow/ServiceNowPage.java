package com.ctl.it.qa.Test_Four.tools.pages.Snow;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ServiceNowPage extends SfaPage {
	@FindBy(id = "quoteNumber") // quoteNumber
	public WebElementFacade quoteSearchBox;
	@FindBy(id = "submitbutton") // submitButton
	public WebElementFacade submitButton;
	@FindBy(xpath = "//tr[@class='odd']") // orderRecordRow
	public WebElementFacade orderRecordRow;
	@FindBy(xpath = "(//tr[@class='odd'])/td[1]") // boid
	public WebElementFacade boid;
	@FindBy(xpath = "(//tr[@class='odd'])/td[5]") // processStatus
	public WebElementFacade processStatus;
	@FindBy(xpath = "(//tr[@class='odd'])/td[6]") // processStatus
	public WebElementFacade orderSystem;
	@FindBy(xpath = "(//tr[@class='odd'])/td[7]") // errorMsgDetails
	public WebElementFacade errorMsgDetails;
	@FindBy(xpath = "//tr[@class='odd']/td[4]") // orderId
	public WebElementFacade orderId;
	@FindBy(id = "username") // _username
	public WebElementFacade username;
	@FindBy(name = "login") // submit
	public WebElementFacade submit;
	@FindBy(name = "loginfmt")
	public WebElementFacade tbx_username;
	@FindBy(id = "idSIButton9")
	public WebElementFacade btn_next_submit;
	@FindBy(name = "passwd")
	public WebElementFacade tbx_password;
	@FindBy(id = "idBtn_Back")
	public WebElementFacade btn_NO;
	@FindBy(xpath = "//*[@placeholder='Filter navigator']") // navigatorSearchBox
	public WebElementFacade navigatorSearchBox;
	@FindBy(xpath = "//div[text()='Customer Orders']")
	public WebElementFacade customerOrders;
	@FindBy(xpath = "//select[@aria-label='Search a specific field of the Customer Orders list']") // select order
	// search Filter	
	public WebElementFacade searchFilterName;
	@FindBy(xpath = "(//select[@name='domain_picker_select'])[1]")
	public WebElementFacade domainDropdown;
	@FindBy(xpath = "//div[@aria-label='Customer Orders, filtering toolbar']//input[@placeholder='Search']") // navigatorSearchBox
	public WebElementFacade customerOrderSearch;
	@FindBy(xpath = "//select[@aria-label='Search a specific field of the Customer Orders list']") // searchOrderText
	public WebElementFacade orderSearchFilter;
	@FindBy(xpath = "//tbody[@class='list2_body']/tr[1]") // orderRecords
	public WebElementFacade orderRecords;
	public String validateSearchedOrder1 = "//tr[@record_class='sn_ind_tmt_orm_order']/td/a[@aria-label='Open record: ";
	public String validateSearchedOrder2 = "']";
	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]")
	public WebElementFacade userName;
	@FindBy(xpath = "//*[@role='menu']/li[2]")
	public WebElementFacade impersonate;
	@FindBy(xpath = "//div[@id='s2id_autogen1']") // user
	public WebElementFacade searchUser;
	@FindBy(xpath = "//a[@data-now-ux-metrics-link-name='Open in Operations View']")
	public WebElementFacade operationView;
	@FindBy(xpath = "//button[@aria-label='Refresh Flow Data']")
	public List<WebElement> serviceOrderRecords;
	@FindBy(xpath = "//*[@record_class='sn_ind_tmt_orm_service_order']//a[contains(@aria-label,'Open record: LMN')]")
	public List<WebElement> serviceOrderWorkflows;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return username;
	}
}
