package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class IPVPNPortAccess extends SfaPage {
	@FindBy(id = "Transport") // Access type
	public WebElementFacade ddl_transport;
	@FindBy(id = "ddlAddress") // address
	public WebElementFacade ddl_ddlAddress;
	@FindBy(id = "MultiServiceSelection") // MultiServiceSelection
	public WebElementFacade ddl_MultiServiceSelection;
	@FindBy(id = "TotalVPNCIR") // TotalVPNCIR
	public WebElementFacade ddl_TotalVPNCIR;
	@FindBy(css = "#InsideWiring") // building ext
	public WebElementFacade ddl_insidewiring;
	@FindBy(css = "#btncancel") // building ext
	public WebElementFacade btn_cancel;
	@FindBy(id = "btnAttribContinue") // continue button
	public WebElementFacade btn_continue;
	@FindBy(id = "btnGridEdit") // edit button
	public WebElementFacade btn_edit;
	@FindBy(id = "btnAttribFinish") // finish button
	public WebElementFacade btn_finish;
	@FindBy(id = "VPNCIR") // cir rate
	public WebElementFacade ddl_cirrate;
	@FindBy(id = "btnDialogSave") // save button
	public WebElementFacade btn_save;
	@FindBy(id = "nonPrimaryChildProds") // add another product
	public WebElementFacade ddl_addotherproducts;
	@FindBy(id = "MultiServiceSelection") // MultiService Selection
	public WebElementFacade ddl_multiserviceselection;
	@FindBy(id = "btnGridAddNew") // changeLabel-InternetServices
	public WebElementFacade btn_btnGridAddNew;
	@FindBy(id = "changeLabel-InternetServices") // changeLabel-InternetServices
	public WebElementFacade btn_InternetServices;
	@FindBy(id = "btnGridAddNew") // add new button
	public WebElementFacade btn_add;
	@FindBy(id = "Manufacturer") // Manufacturer
	public WebElementFacade ddl_manufacturer;
	@FindBy(id = "Chassis") // Chassis
	public WebElementFacade ddl_chassis;
	@FindBy(id = "btnDialogSave") // Dialo gSave
	public WebElementFacade btn_dialogsave;
	@FindBy(id = "changeLabel-SDRDiversity") // SDRDiversity
	public WebElementFacade lnk_sdrdiversity;
	@FindBy(id = "SPCRID") //
	public WebElementFacade txt_spcrid; // SPCRID
	@FindBy(id = "CustomKitName") //
	public WebElementFacade txt_customkitname; // SPCRID

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_transport;
	}
}