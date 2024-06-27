package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class QuotePage extends Page {
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElementFacade btn_share;
	@FindBy(xpath = "(//input[contains(@value,'Add Global Attachment')])[1]")
	public WebElementFacade btn_global_attachment;
	@FindBy(xpath = "(//input[@value=' Edit '])[1]")
	// @FindBy(xpath = "(//div[@class='bodyDiv brdPalette
	// brandPrimaryBrd']/table/tbody/tr/td[2]/div[4]/div/table/tbody/tr/td[2]/input[3])[1]")
	public WebElementFacade btn_edit;
	@FindBy(xpath = "//select[@id='00N2A00000DoTFD']")
	public WebElementFacade lst_msa_edit;
	@FindBy(xpath = "//select[@id='00N2A00000DoTFZ']")
	public WebElementFacade lst_porting_edit;
	@FindBy(xpath = "//select[@id='00N2A00000DoTF9']")
	public WebElementFacade lst_hot_cut_edit;
	@FindBy(xpath = "//input[@id='CF00N2A00000DoTF3']")
	public WebElementFacade tbx_CCM_edit;
	@FindBy(xpath = "//img[@alt='CCM Lookup (New Window)']")
	public WebElementFacade btn_CCM_search;
	@FindBy(xpath = "//input[contains(@id,'lksrch')]")
	public WebElementFacade tbx_CCM_search;
	@FindBy(xpath = "//input[@value=' Go! ']")
	public WebElementFacade btn_CCM_search_go;
	// @FindBy(xpath = "(//a[@href='#'][contains(.,'Anistasia Bills')])[1]")
	// @FindBy(xpath = "//a[@href='#']")
	@FindBy(xpath = "(//a[@href='#'])[1]")
	public WebElementFacade lnk_CCM_select;
	@FindBy(xpath = "//input[@id='CF00N2A00000DoTFs']")
	public WebElementFacade tbx_sales_engineer_edit;
	@FindBy(xpath = "(//input[@value=' Save '])[1]")
	public WebElementFacade btn_save_edit;
	// @FindBy(xpath = "(//div[contains(@id,'ileinner')])[2]") // use for env 1
	@FindBy(xpath = "//div[@id='00N2A00000DoTFD_ileinner']")
	public WebElementFacade ddl_msa;
	// @FindBy(xpath = "(//div[contains(@id,'ileinner')])[5]") // use for env 1
	@FindBy(xpath = "//div[@id='00N2A00000DoTFZ_ileinner']")
	public WebElementFacade ddl_porting;
	@FindBy(xpath = "//div[@id='00N2A00000DoTF9_ileinner']")
	public WebElementFacade ddl_hot_cut;
	@FindBy(xpath = "//div[@id='CF00N2A00000DoTF3_ileinner']")
	public WebElementFacade tbx_CCM;
	@FindBy(xpath = "//div[@id='CF00N2A00000DoTFs_ileinner']")
	public WebElementFacade tbx_sales_engineer;
	@FindBy(xpath = "(//input[@value=' Save '])[1]")
	public WebElementFacade btn_save;
	@FindBy(xpath = "//input[contains(@name,'add_existing_contacts')]")
	public WebElementFacade btn_existing_contacts;
	// @FindBy(xpath = "(//input[@type='text'])[2]") use for env 1
	@FindBy(xpath = "//input[@id='j_id0:myForm:contactRoles:pgBlockTable:0:contact']")
	public WebElementFacade tbx_contact1;
	// @FindBy(xpath = "(//input[@type='text'])[4]")
	@FindBy(xpath = "//input[@id='j_id0:myForm:contactRoles:pgBlockTable:1:contact']")
	public WebElementFacade tbx_contact2;
	// @FindBy(xpath = "(//input[@type='text'])[6]")
	@FindBy(xpath = "//input[@id='j_id0:myForm:contactRoles:pgBlockTable:2:contact']")
	public WebElementFacade tbx_contact3;
	// @FindBy(xpath = "(//input[@type='submit'])[2]")
	@FindBy(xpath = "//input[contains(@value,'Save')]")
	public WebElementFacade btn_save_contacts;
	@FindBy(xpath = "//input[@id='j_id0:gaForm:Information:documentInformation:docName']")
	public WebElementFacade tbx_doc_name;
	@FindBy(xpath = "//select[@id='j_id0:gaForm:Information:documentContent:documentType']")
	public WebElementFacade ddl_doc_type;
	@FindBy(xpath = "//input[@id='j_id0:gaForm:Information:documentContent:j_id36:signedDate']")
	public WebElementFacade tbx_signed_date;
	@FindBy(xpath = "//input[contains(@name,'j_id0:gaForm:Information:pageBlock:j_id30')]")
	public WebElementFacade btn_add_attachment;
	@FindBy(xpath = "//input[@id='ucAttachment_fileAttach']")
	public WebElementFacade btn_choose_file;
	@FindBy(xpath = "//input[@id='ucAttachment_btnAdd']")
	public WebElementFacade btn_add_choosen_attachment;
	@FindBy(xpath = "//a[@id='j_id0:j_id1:optNew']")
	public WebElementFacade lnk_back_to_record;
	@FindBy(xpath = "(//input[@title='Select Billing Account'])[1]")
	public WebElementFacade btn_billing_account;
//	@FindBy(xpath = "//input[contains(@id,'j_id0:accountSearchFields:j_id121:BANSearchResults:banTable:0:j_id132')]")
//	@FindBy(xpath = "(//input[@value='Select'])[1]")
	@FindBy(xpath = "(//input[contains(@value,'Select')])[2]")
	public WebElementFacade btn_select_billing_account;
	@FindBy(xpath = "//span[contains(@id,'id380')]")
	public WebElementFacade lnk_billing_BAN_id;
//	@FindBy(xpath = "//input[@id='j_id0:accountSearchFields:j_id67:j_id68:j_id69']")
	@FindBy(xpath = "//input[contains(@value,'Update All')]")
	public WebElementFacade btn_update_all;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElementFacade tbx_billing_account_number;
	@FindBy(xpath = "(//input[@value='Search'])[2]")
	public WebElementFacade btn_search_billing_account_number;
	@FindBy(xpath = "//input[@value='Return to Quote']")
	public WebElementFacade btn_return_to_quote;
	@FindBy(xpath = "(//input[@value='Submit to SwIFT'])[1]")
	public WebElementFacade btn_submit_to_swift;
	@FindBy(xpath = "//td[@class='labelCol'][contains(.,'SwIFT Business Order ID')]")
	public WebElementFacade tbx_swift_id;
	@FindBy(xpath = "//div[contains(@id,'00N2A00000DoTFx_ileinner')]")
	public WebElementFacade tbx_business_order_id;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_share;
	}
}
