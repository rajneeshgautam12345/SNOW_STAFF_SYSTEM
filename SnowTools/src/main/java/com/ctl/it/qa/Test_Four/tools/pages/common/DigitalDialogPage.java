package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DigitalDialogPage extends SfaPage {
	@FindBy(id = "username") // user txt
	public WebElementFacade txt_username;
	@FindBy(id = "password") // password txt
	public WebElementFacade txt_password;
	@FindBy(id = "login") // log in button
	public WebElementFacade btnlogin;
	@FindBy(linkText = "Manage Services") // continue Button
	public WebElementFacade btn_manage_services;
	@FindBy(xpath = "//*[@id=\"childProduct565\"]/kendo-grid-toolbar/button") // and new package Button
	public WebElementFacade btn_new_package;
	@FindBy(id = "PackageType") // Package Type
	public WebElementFacade ddl_packagetype;
	@FindBy(id = "Quantity") // Package Quantity
	public WebElementFacade txt_quantity;
	@FindBy(xpath = "//*[@id=\"collapse0\"]/div/app-product-children-attribute-grid/app-product-children-attribute-grid-edit/kendo-dialog/div[2]/kendo-dialog-actions/div/button[2]") // and
																																														// new
																																														// package
																																														// Button
	public WebElementFacade btn_pkg_save;
	@FindBy(xpath = "//*[@id=\"collapse0\"]/div/app-product-children-attribute-grid/div[4]/div/button[2]") // and finish
																											// Button
	public WebElementFacade btn_cle_finish;
	@FindBy(id = "service-search") // Package Quantity
	public WebElementFacade txt_search;
	// @FindBy(jquery = "document.querySelector(\"body > ui-app >
	// qt-application\").shadowRoot.querySelector(\"stencil-router >
	// stencil-route:nth-child(4) >
	// qt-services\").shadowRoot.querySelector(\"#service-search\").shadowRoot.querySelector(\"ui-layout
	// > ui-layout:nth-child(2) >
	// ui-input-search\").shadowRoot.querySelector(\"input[type=text]\")")
	@FindBy(jquery = "document.querySelector(\"body > ui-app > qt-application\").shadowRoot.querySelector(\"stencil-router > stencil-route:nth-child(4) > qt-services\").shadowRoot.querySelector(\"#service-search\").shadowRoot.querySelector(\"ui-layout > ui-layout:nth-child(2) > ui-input-search\").shadowRoot.querySelector(\"input[$0]\")")
	// @FindBy(xpath = "//*[@id=\"service-search\"]//ui-layout/ui-layout[2]//slot")
	public WebElementFacade txt_box_search;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return txt_username;
	}
}