package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ExistingOpportunityPage extends Page {
	@FindBy(xpath = "//div[contains(@id,'opp11_ileinner')]")
	public WebElementFacade ddl_stage;
	@FindBy(xpath = "(//input[@value=' Edit '])[1]")
	public WebElementFacade btn_edit;
	@FindBy(xpath = "//select[@id='opp11']")
	public WebElementFacade ddl_stage_update;
	@FindBy(xpath = "//a[contains(.,'re-display the record')]")
	public WebElementFacade lnk_error;
	@FindBy(xpath = "//div[@id='ForecastCategoryName_ileinner']")
	// *[@id="ForecastCategoryName_ileinner"]
	public WebElementFacade ddl_forecast;
	@FindBy(xpath = "//div[@id='opp12_ileinner']")
	public WebElementFacade tbx_probability;
	@FindBy(xpath = "(//input[@value=' Save '])[1]")
	public WebElementFacade btn_save;
	@FindBy(xpath = "//a[contains(.,'Scenario Manager')]")
	public WebElementFacade btn_scenario_manager;
	@FindBy(xpath = "//a[contains(.,'Prepare Order')]")
	public WebElementFacade btn_prepare_order;

	public WebElementFacade Scenario(String SM) {
		WebElementFacade SM_quote = findBy("//a[contains(.,'" + SM + "')]");
		return SM_quote;
	}

	public WebElementFacade metastorm(String sess) {
		System.out.println("Session Variable : " + sess);
		WebElementFacade metastormelement = findBy("(//td[@class='met-Cell'][contains(.,'" + sess + "')])[1]");
		System.out.println("Metastorm Element Xpath : " + metastormelement);
		return metastormelement;
	}

	@FindBy(xpath = "//a[@href='/aSG1g0000008QehGAE']")
	public WebElementFacade btn_quote;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_stage;
	}
}
