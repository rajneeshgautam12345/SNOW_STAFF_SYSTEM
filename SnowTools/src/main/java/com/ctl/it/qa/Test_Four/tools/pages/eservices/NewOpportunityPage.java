package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewOpportunityPage extends Page {
	@FindBy(xpath = "//input[@id='opp4']")
	public WebElementFacade ddl_account_name;
	@FindBy(xpath = "//img[contains(@alt,'Account Name Lookup (New Window)')]")
	public WebElementFacade btn_look_up;
	@FindBy(xpath = "//input[@name='go']")
	public WebElementFacade btn_go;
	@FindBy(xpath = "//input[@id='lksrch']")
	public WebElementFacade tbx_search;
	@FindBy(xpath = "//input[contains(@id,'ALL')][@name='lkenhmd']")
	public WebElementFacade rbn_all_fields;
	@FindBy(xpath = "(//a[@href='#'][contains(.,'Qwest Communications')])[1]")
	public WebElementFacade lnk_qwest;
	@FindBy(xpath = "//div[@class='pbBody']/table/tbody/tr[2]/th/a")
	public WebElementFacade lnk_first_result;
	@FindBy(xpath = "//input[contains(@id,'opp3')]")
	public WebElementFacade tbx_opportunity_name;
	@FindBy(xpath = "//input[contains(@id,'opp9')]")
	public WebElementFacade tbx_close_date;
	@FindBy(xpath = "//select[contains(@id,'opp11')]")
	public WebElementFacade ddl_stage;
	@FindBy(xpath = "//select[contains(@id,'ForecastCategoryName')]")
	public WebElementFacade ddl_forecast_category;
	@FindBy(xpath = "//option[@value='0'][contains(.,'AT&T')]")
	public WebElementFacade btn_att;
	@FindBy(xpath = "//img[contains(@id,'00N2A00000DoTDC_right_arrow')]")
	public WebElementFacade btn_right;
	@FindBy(xpath = "(//input[contains(@value,' Save ')])[1]")
	public WebElementFacade btn_save_opportunity;
	@FindBy(xpath = "(//input[contains(@value,'Level 3')])[1]")
	public WebElementFacade btn_level3;
	@FindBy(xpath = "//*[@value='New Scenario Manager Quote']")
	public WebElementFacade btn_new_scenario;
//	@FindBy(xpath = "//input[@id='ScenarioName']")
//	public WebElementFacade tbx_scenario_name;
	@FindBy(xpath = "//input[@id='mat-input-0']")
	public WebElementFacade tbx_scenario_name;
	@FindBy(xpath = "//span[contains(@class,'mat-select-placeholder ng-tns-c9-3 ng-star-inserted')]")
	public WebElementFacade tbx_scenario_currency;
	@FindBy(xpath = "//span[contains(.,'US Dollars - USD')]")
	public WebElementFacade ddl_usd;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[1]")
	public WebElementFacade ddl_scenario_currency;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'US Dollars - USD')]")
	public WebElementFacade ddl_scenario_currency_usd;
//	@FindBy(xpath = "//button[contains(@id,'SaveButton')]")
//	public WebElementFacade btn_save_scenario;
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	public WebElementFacade btn_save_scenario;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_account_name;
	}
}
