package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MetaStormPage extends Page {
	@FindBy(xpath = "//span[@class='rtbText'][contains(.,'Watch List')]")
	public WebElementFacade btn_watch_list;
	@FindBy(xpath = "(//input[contains(@name,'ProcessList')])[1]")
	public WebElementFacade ddl_process;
	@FindBy(xpath = "//li[contains(.,'OP_Welcome_Customer')]")
	public WebElementFacade ddl_process_OP_Welcome;
	@FindBy(xpath = "(//input[contains(@name,'StageList')])[1]")
	public WebElementFacade ddl_stage;
	@FindBy(xpath = "//li[contains(.,'WaitForAutoComplete')]")
	public WebElementFacade ddl_stage_select;
	@FindBy(xpath = "//a[@title='Click here to sort'][contains(.,'Folder')]")
	public WebElementFacade btn_folder;

	public WebElementFacade metastorm(String sess) {
		System.out.println("Session Variable : " + sess);
		WebElementFacade metastormelement = findBy("(//td[@class='met-Cell'][contains(.,'" + sess + "')])[1]");
		System.out.println("Metastorm Element Xpath : " + metastormelement);
		return metastormelement;
	}

	@FindBy(xpath = "(//td[@class='met-Cell'])[1]")
	public WebElementFacade btn_first_order;
	@FindBy(xpath = "//div[@class = 'actionFolderWrapper']/div[3]/div/div/ul/li[9]/a/span")
	public WebElementFacade btn_manual_expire;
	@FindBy(xpath = "//input[contains(@id,'btnConfirm')]")
	public WebElementFacade btn_manual_expire_ok;

	// div[@id = 'eSeparator']/span[3] alternate for OK
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_watch_list;
	}
}
