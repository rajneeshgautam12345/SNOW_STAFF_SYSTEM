package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends SfaPage {
	public WebElementFacade lnk_account;
	@FindBy(xpath = "//a[contains(@data-label,'Opportunities')]")
	public WebElementFacade tab_opportunities;
	@FindBy(xpath = "//button[@name='New'][contains(.,'New')]")
	public WebElementFacade btn_new_opp;
	@FindBy(xpath = "(//span[text()='Customer Solution Quote']/../../div/span)[1]")
	public WebElementFacade recordType;
	
	@FindBy(xpath = "(//span[contains(@class,'slds-radio--faux')])[5]")
	public WebElementFacade rdo_l3quote;
	@FindBy(xpath = "//span[@dir='ltr' and text()='Next']")
	public WebElementFacade btn_opp_next;
	@FindBy(xpath = "(//input[contains(@name,'Name')][1])")
	public WebElementFacade txt_opp_name;
	@FindBy(xpath = "//label[text()='Sub-Type']/following-sibling::div//button[contains(@class,'slds-input')]") // works
																												// // in
																												// //
																												// test
																												// // 1
	public WebElementFacade dd_opp_sub_type;
	@FindBy(xpath = "//label[text()='Sub-Type']/..//button") // works in test 4
	public WebElementFacade dd_opp_sub_type1;
	@FindBy(xpath = "//label[text()='Sub-Type']/..//span[text()='New Service']") // works in test 4
	public WebElementFacade dd_opp_sub_type_new_Services;
	
	@FindBy(xpath = "(//button[contains(@aria-label, 'Sub-Type Motion')])[1]") // works in test 4
	public WebElementFacade dd_sub_type_motion;
	
	
	
	@FindBy(xpath = "//*[starts-with(@name,'CloseDate')]")
	public WebElementFacade txt_opp_date;
	@FindBy(xpath = "//label[text()='Stage']/following-sibling::div//button[contains(@class,'slds-input')]")
	public WebElementFacade dd_opp_stage;
	@FindBy(xpath = "//label[text()='Stage']/..//button")
	public WebElementFacade dd_opp_stage1;
	@FindBy(xpath = "//label[text()='Stage']/..//span[text()='Qualified']")
	public WebElementFacade dd_opp_stage_Qua;
	@FindBy(xpath = "//input[@name='Partner_Sales_Rep_ID_Text__c']")
	public WebElementFacade partnerSalesrepId;
	@FindBy(xpath = "//*[@title=\'Save\']")
	public WebElementFacade btn_save_opp;
	@FindBy(xpath = "(//span[contains(.,'Opportunities')])")
	public WebElementFacade opp_tab;
	@FindBy(xpath = "//a[@data-label='Quotes']")
	public WebElementFacade tab_quote;
	@FindBy(xpath = "//input[@value='New Scenario Manager Quote']") // New Quote starts here e2e itv1
	public WebElementFacade btn_new_quote;
	@FindBy(linkText = "Koch Entertainment")
	public WebElementFacade lnk_account_name;
	@FindBy(xpath = "//button[@aria-label='Search']")
	public WebElementFacade txt_search;
	@FindBy(name = "save") // save button
	public WebElementFacade btn_save;
	@FindBy(xpath = "(//html/body/div[4]/div[1]/section/div[1]")
	public WebElementFacade opp_tab_2;
	@FindBy(xpath = "//span[@class='slds-col scopesItem_name slds-truncate'][contains(.,'Accounts')]")
	public WebElementFacade account_tab;
	public String customer1 = "//a[@title='";
	public String customer2 = "']";
	public String customerId1 = "//span[text()='";
	public String customerId2 = "']/../../../th//a[@title='";
	public String customerId3 = "']";
	@FindBy(xpath = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[3]")
	public WebElementFacade lbl_oppty_id;
	@FindBy(xpath = "//a[@title = 'Home Tab - Selected']")
	public WebElementFacade tab_home;
	@FindBy(css = "img[title = 'All Tabs']")
	public WebElementFacade img_allTabs;
	@FindBy(css = "#Account_Tab > a") // account starts here
	public WebElementFacade lnk_Account_Tabs;
	@FindBy(css = "#phSearchInput") // account search field
	public WebElementFacade txt_phSearchInput;
	@FindBy(id = "secondSearchButton") // account search button
	public WebElementFacade btn_phSearchButton;
	@FindBy(id = "0012A00002IuKu2_RelatedOpportunityList_link") // click on oppty link
	public WebElementFacade link_newOpp;
	@FindBy(name = "newOpp") // opportunties new button
	public WebElementFacade btn_newOpp;
	@FindBy(css = "#bottomButtonRow > input:nth-child(1)") // opportunities continue button
	public WebElementFacade btn_continue;
	@FindBy(css = "#opp9") // calendar due date text
	public WebElementFacade tbx_customerWantDate;
	@FindBy(css = "#opp11") // stage selection list box
	public WebElementFacade lst_stage;
	@FindBy(name = "opp3") // text oppty name field
	public WebElementFacade txt_oppName;
	@FindBy(name = "level_3") // click scenario manager button
	public WebElementFacade btn_level_3;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lnk_account;
	}
}
