package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CenturyLinkEngage extends SfaPage {
	@FindBy(id = "CurrentBandwidth") // CurrentBandwidth
	public WebElementFacade txt_currentbandwith;
	@FindBy(id = "ServiceProvider") // ServiceProvider
	public WebElementFacade ddl_serviceprovider;
	@FindBy(id = "BWUnitofMeasurement") // current bandwidth
	public WebElementFacade ddl_BWUnitofMeasurement;
	@FindBy(id = "Term") // terms
	public WebElementFacade ddl_term;
	@FindBy(xpath = "//*[@id=\"collapse0\"]/div/div/div/button[1]") // continue Button
	public WebElementFacade btn_continue;
	@FindBy(xpath = "//*[@id=\"childProduct565\"]/kendo-grid-toolbar/button") // and new package Button
	public WebElementFacade btn_new_package;
	@FindBy(id = "PackageType") // Package Type
	public WebElementFacade ddl_packagetype;
	@FindBy(id = "Quantity") // Package Quantity
	public WebElementFacade txt_quantity;
	@FindBy(xpath = "//*[@id='collapse0']/div/app-product-children-attribute-grid/app-product-children-attribute-grid-edit/kendo-dialog/div[2]/kendo-dialog-actions/div/button[2]") // and
																																													// new
																																													// package
																																													// Button
	public WebElementFacade btn_pkg_save;
	@FindBy(xpath = "//*[@id=\"collapse0\"]/div/app-product-children-attribute-grid/div[4]/div/button[2]") // and finish
																											// Button
	public WebElementFacade btn_cle_finish;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return txt_currentbandwith;
	}
}