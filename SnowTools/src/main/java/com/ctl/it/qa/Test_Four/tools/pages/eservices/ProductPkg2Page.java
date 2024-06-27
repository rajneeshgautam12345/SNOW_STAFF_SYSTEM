package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPkg2Page extends Page {
	@FindBy(xpath = "//a[contains(@title,'Home Tab')]")
	public WebElementFacade btn_home;
	@FindBy(xpath = "//button[contains(.,'New Product')]")
	public WebElementFacade btn_new_product;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_home;
	}
}
