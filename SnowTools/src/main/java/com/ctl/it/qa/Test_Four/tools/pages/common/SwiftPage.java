package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SwiftPage extends SfaPage {
	@FindBy(id = "searchId") // _searchId
	public WebElementFacade txt_searchId;
	@FindBy(xpath = "//*[@id='searchWrapper']/span[3]") // _searchId
	public WebElementFacade lst_business_order_listbox;
	@FindBy(xpath = "//*[@id='searchType_listbox']/li[contains(., 'Business Order Id')]") // _searchId
	public WebElementFacade lst_business_order_pick;
	@FindBy(xpath = "//*[@id='searchType_listbox']/li[contains(., 'Order Package Id')]") // _searchId
	public WebElementFacade lst_order_pkg_pick;
	@FindBy(id = "searchBtn") // _search button
	public WebElementFacade searchBtn;
	@FindBy(css = "#assignRoleInfo > table > tbody > tr:nth-child(4) > td:nth-child(2) > span > span > span.k-select") // check
																														// button
																														// for
																														// oes
																														// section
	public WebElementFacade btn_oes_order_pick;
	@FindBy(xpath = "//*[@id='OESDropdown_listbox']/li[2]") // pick the second name in the list
	public WebElementFacade lst_oes_order_pick;
	@FindBy(id = "completeTask") // _search
	public WebElementFacade btn_completeTask;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm'][contains(.,'Open TDG Form')]")
	public WebElementFacade btn_TDG_form;
	@FindBy(xpath = "//a[@class='btn btn-success'][contains(.,'Edit')]")
	public WebElementFacade btn_TDG_form_edit;
	@FindBy(xpath = "//a[@class='btn btn-success'][contains(.,'Save')]")
	public WebElementFacade btn_TDG_form_save;
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[4]/span") // pick the second name in the list
	public WebElementFacade lbl_order_pkg_row1;
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span") // pick the second name in the list
	public WebElementFacade lbl_order_pkg_row2;
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span") // pick the second name in the list
	public WebElementFacade lbl_order_pkg_row3;
	@FindBy(id = "contactsTab") // _search
	public WebElementFacade tab_contactsTab;
	@FindBy(id = "orderDetailsTab") // _search
	public WebElementFacade tab_orderDetailsTab;
	@FindBy(id = "productPackagesTab") // product package tab
	public WebElementFacade tab_productPackagesTab;
	@FindBy(id = "editDatesBtn") // _edit date button for
	public WebElementFacade btn_editDatesBtn;
	@FindBy(id = "NewNddDatePicker") // set first date
	public WebElementFacade txt_NewNddDatePicker;
	@FindBy(id = "CurrentCrdDatePicker") // set CurrentCrdDatePicker
	public WebElementFacade txt_CurrentCrdDatePicker;
	@FindBy(id = "EditDateDialogOkBtn") // _EditDateDialogOkBtn - saves dates
	public WebElementFacade btn_EditDateDialogOkBtn;
	@FindBy(id = "OrderPackageStatusLbl") // _OrderPackageStatusLbl
	public WebElementFacade lbl_OrderPackageStatusLbl;
	@FindBy(id = "createOrder")
	public WebElementFacade btn_createorder;// _Create order button
	@FindBy(id = "createCPOOrder")
	public WebElementFacade btn_createcpeorder;// _Create cpe order button
	@FindBy(xpath = "//*[@id='createOrderConfirmDialog']//*[@id='createCPOOrder'] ")
	public WebElementFacade btn_create_cpo_order;// _Create cpe order button
	@FindBy(xpath = "//*[@id='validateTask'] ")
	public WebElementFacade btn_validateTask;// _Create validateTask button
	@FindBy(xpath = "//*[@id='orderPackageValidationErrors']/tbody/tr/td[2]/span")
	public WebElementFacade lnk_validateErrors;// _Create validateTask errors link
	@FindBy(xpath = "//*[@id='documentsGrid']/div[3]/table/tbody/tr[1]/td[1]/div/button[2" + "" + "]")
	public WebElementFacade btn_editworkbookbutton;
	@FindBy(xpath = "//*[@id='documentsGrid']/div[3]/table/tbody/tr[1]/td[3]/div/div")
	public WebElementFacade lst_serviceorderform;// lst_service order form
	@FindBy(xpath = "//*[@id='documentsGrid']/div[3]/table/tbody/tr[1]/td[3]/div") // work book list box
	public WebElementFacade lbl_work_book_listbox;
	@FindBy(xpath = "//*[@id='businessPurposeTypeDrop1711687_listbox']/li[1]") // work book list box open
	public WebElementFacade lbl_work_book_listbox_open;
	@FindBy(id = "taskWrapper")
	public WebElementFacade frm_taskWrapper;// _Create cpe order button
	@FindBy(xpath = "//*[@id='openTask']") // btn_open_tdg_form
	public WebElementFacade btn_open_tdg_form;
	@FindBy(xpath = "//html/body/div/div[7]/div[2]/div/table/tbody/tr/td[4]/a") // btn_oedit_tdg_form
	public WebElementFacade btn_open_tdg_form_edit;
	@FindBy(xpath = "//html/body/div/div[11]/div/a[1]") // btn_save /html/body/div/div[11]/div/a[1]_tdg_form
	public WebElementFacade btn_open_tdg_form_save;
	@FindBy(id = ("OrderPackage")) // order pkg check box
	public WebElementFacade cbx_orderpackage;
	@FindBy(id = ("SL0000092774")) // first location check box
	public WebElementFacade cbx_1st_location;
	@FindBy(id = ("SL0000097959")) // first location check box
	public WebElementFacade cbx_2nd_location;
	@FindBy(id = ("SL0002163199")) // first location check box
	public WebElementFacade cbx_1st_location_pl;
	@FindBy(id = ("SL0001959005")) // first location check box
	public WebElementFacade cbx_2nd_location_pl;
	@FindBy(id = ("SL0000074997")) // first location check box
	public WebElementFacade cbx_elan_1st_location;
	@FindBy(id = ("SL0000100743")) // first location check box
	public WebElementFacade cbx_elan_2nd_location;
	@FindBy(id = ("SL0000025278")) // first location check box
	public WebElementFacade cbx_elan_3rd_location;
	@FindBy(id = ("SL0002058646")) // first location check box
	public WebElementFacade cbx_offnet_first_location;
	@FindBy(id = ("SL0002107206")) // first location check box
	public WebElementFacade cbx_offnet_second_location;
	@FindBy(xpath = ("//*[@id='550808345__INT_AH']")) // after hours
	public WebElementFacade cbx_after_hours;
	@FindBy(id = ("550808345__INT_BAC")) // back up
	public WebElementFacade cbx_int_backup;
	@FindBy(id = ("550808345__INT_PRI")) // Internet Primary
	public WebElementFacade cbx_int_primary;
	@FindBy(id = ("550808345__INT_SEC")) // Security
	public WebElementFacade cbx_int_security;
	@FindBy(id = ("550808345__ORDER_CON")) // Security
	public WebElementFacade cbx_order_contact;
	@FindBy(xpath = ("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[2]/td[5]/span")) // user name
	public WebElementFacade txt_assignee_name;
	@FindBy(xpath = ("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[5]/td[5]/span")) // user name
	public WebElementFacade txt_welcomeCustomer_assignee_name;
	@FindBy(xpath = ("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[4]/td[5]/span")) // user name
	public WebElementFacade txt_cust_coordiation_assignee_name;
	@FindBy(xpath = ("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[6]/td[5]/span")) // user name
	public WebElementFacade txt_api_swift_assignee_name;
	@FindBy(xpath = ("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]/td[5]/span")) // user name
	public WebElementFacade txt_second_assignee_name;
	// div[@class='leftNavSectionItem'][contains(.,'Docs (0)')]
	@FindBy(xpath = "//span[@ng-show='DocumentCount != 0'][contains(.,'(1)')]") // open doc attachment window swift
	public WebElementFacade lnk_doc_tryagain;
	@FindBy(xpath = "//*[@id=\"requiredDocumentsGrid\"]/div[2]/table/tbody/tr/td[2]/span") // open doc attachment window
																							// swift
	public WebElementFacade txt_doc_text;
	@FindBy(xpath = "//*[@id=\"requiredDocumentsGrid\"]/div[2]/div[1]/div") // open doc attachment window swift
	public WebElementFacade txt_NO_doc_text;
	@FindBy(xpath = "//*[@id=\"requiredDocumentsGrid\"]/div[2]/table/tbody/tr/td[1]/img") // green check box
	public WebElementFacade cx_green_box;
	@FindBy(xpath = "//div[@ng-click='OpenDocumentsWindow() ']")
	public WebElementFacade lnk_doc;
	@FindBy(xpath = "//*[@id=\"documentToolbar\"]/tbody/tr/td[4]/div/div/strong/text()") // add the document
	public WebElementFacade btn_attachment_field;
	@FindBy(xpath = "//td[@role='gridcell'][contains(.,'iSE Design')]")
	public WebElementFacade lbl_ise_design;
	@FindBy(xpath = "//*[@id=\"documentsGrid\"]/div[3]/table/tbody/tr/td[1]/div/button[1]")
	public WebElementFacade btn_design_edit;
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	public WebElementFacade lst_doc_type;
	@FindBy(xpath = "//button[contains(@ng-click,'UpdateDocument(this)')]")
	public WebElementFacade btn_save_doctype;
	@FindBy(xpath = "//span[@class='rtbText'][contains(.,'Watch List')]")
	public WebElementFacade btn_watch_list;
	@FindBy(xpath = "//span[contains(.,'ManuallyExpireWCTaskWait')]")
	public WebElementFacade complete_welcome_task;
	@FindBy(xpath = "//span[@class='rmText'][contains(.,'CreditCheckDone')]")
	public WebElementFacade complete_creditCheckDone;
	@FindBy(xpath = "//span[contains(.,'CreditCheckDone')]")
	public WebElementFacade complete_credit_task;
	@FindBy(xpath = "//a[contains(.,'Folder')]")
	public WebElementFacade lst_sort;
	@FindBy(id = "ctl00_phMainContent_WatchListPart_ProcessList_Input")
	public WebElementFacade lst_process_pick;
	@FindBy(id = ("headerUserInfo")) // user_info
	public WebElementFacade lbl_user_info;
	@FindBy(xpath = ("//*[@id=\"UserInfo\"]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/span/span/input")) // user info
	public WebElementFacade txt_user_info;
	@FindBy(id = ("impersonateUserBtn")) // impersonateUserBtn
	public WebElementFacade btn_impersonateUserBtn;
	@FindBy(xpath = ("//*[@id='orderPackagesGrid']/div[2]/table/tbody/tr[2]/td[1]")) // user info
	public WebElementFacade lbl_product_to_click_on;
	@FindBy(xpath = "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade lnk_first_order;
	@FindBy(xpath = "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[2]/td[1]/a")
	public WebElementFacade lnk_second_order;
	@FindBy(id = "cbHeader")
	public WebElementFacade cbx_vfrids; // vfr select all check box
	@FindBy(xpath = "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[3]/td[1]/a")
	public WebElementFacade lnk_third_order;
	// finishing swift for ipvpn
	@FindBy(id = ("productPackagesTab")) // productPackagesTab
	public WebElementFacade btn_productPackagesTab;
	@FindBy(xpath = "//*[@id=\"NavOnThisOrder\"]/div[2]/div[3]")
	public WebElementFacade lnk_service_address;
	@FindBy(xpath = "//*[@id=\"serviceAddressesGrid\"]/div[2]/table/tbody/tr/td[7]/span")
	public WebElementFacade txt_enduserclli;
	@FindBy(xpath = "//html/body/div[14]/div[1]/div/a[3]")
	public WebElementFacade btn_serviceaddressClose;
	@FindBy(id = "addPspBtn")
	public WebElementFacade btn_addPspBtn;
	@FindBy(id = "searchClliCriteriaTextBox")
	public WebElementFacade txt_searchClliCriteriaTextBox;
	@FindBy(id = "location-search-button")
	public WebElementFacade btn_location_search_button;
	@FindBy(xpath = "//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr/td[2]/label")
	public WebElementFacade cbx_cllicheckbox;
	@FindBy(xpath = "//*[@id=\"wizContainer\"]/div/div[2]/div[5]/div[3]/button")
	public WebElementFacade btn_pspNext;
	@FindBy(xpath = "//*[@id=\"wizContainer\"]/div/div[2]/div[4]/div[2]/button")
	public WebElementFacade btn_pspprproductNext;
	@FindBy(xpath = "//*[@id=\"wizContainer\"]/div/div[2]/div[5]/div[4]/button")
	public WebElementFacade btn_pspprproducSave;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-more-vertical')])[108]")
	public WebElementFacade img_vfrfiltercheckbox;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-more-vertical')])[88]")
	public WebElementFacade img_filtercheckbox;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-filter')])[3]")
	public WebElementFacade img_filter;
	@FindBy(xpath = "//span[contains(.,'Filter')]")
	public WebElementFacade img_vrffilter;
	@FindBy(xpath = "//input[contains(@title,'Value')]")
	public WebElementFacade txt_filterinput;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Filter')]")
	public WebElementFacade btn_filtersearch;
	@FindBy(xpath = "(//label[@class='k-checkbox-label'])[19]")
	public WebElementFacade cbx_clliLocation;
	@FindBy(xpath = "//div[@id='locationSearchGrid']/div[1]//thead/tr/th")
	public WebElementFacade ele_resize;
	@FindBy(xpath = "//div[@id='locationSearchGrid']//table[1]//th[2]")
	public WebElementFacade ele_resize1;
	@FindBy(xpath = "//div[@id='locationSearchGrid']//div[@class='k-resize-handle']")
	public WebElementFacade ele_resize2;
	@FindBy(xpath = "//*[@id=\"package-configuration\"]/div[2]/div[1]/button")
	public WebElementFacade btn_addnewpsp;
	@FindBy(xpath = "//*[@id=\"productEditor\"]/div[2]/div[2]/table[1]/thead/tr[1]/td[2]/div/span/span/span[1]")
	public WebElementFacade ddl_pspproduct;
	@FindBy(xpath = "//*[@id=\"address1\"]/td[2]/div/span/span/span[1]")
	public WebElementFacade ddl_pspaddress;
	@FindBy(xpath = "(//a[contains(@class,'k-icon k-i-expand')])[1]")
	public WebElementFacade arr_vrfid;
	@FindBy(xpath = "(//td[contains(@role,'gridcell')])[100]")
	public WebElementFacade lbl_productpkgID;
	@FindBy(xpath = "(//td[@role='gridcell'][contains(.,'IP VPN Logical Interface')])[2]")
	public WebElementFacade lbl_ipvpnlogicalinterface_1;
	@FindBy(xpath = ".//tr[@class='k-detail-row ng-scope']//td[contains(.,'IP VPN Logical Interface') and @role='gridcell']")
	public WebElementFacade lbl_ipvpnlogicalinterface_2;
	@FindBy(xpath = "//a[@href='javascript:void(0);'][contains(.,'Details')]")
	public WebElementFacade lnk_details;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-pencil')])[2]")
	public WebElementFacade lnk_detailedit;
	@FindBy(xpath = "//button[@class='btn'][contains(.,'Auto-fill')]")
	public WebElementFacade btn_autofill;
	@FindBy(xpath = "//button[contains(@ng-click,'SearchVrf()')]")
	public WebElementFacade btn_searchvrf;
	@FindBy(xpath = "//button[contains(@ng-click,'CommitVrf()')]")
	public WebElementFacade btn_savevrf;
	@FindBy(xpath = "//*[@id=\"vrfResultGrid\"]/div[2]/table/tbody/tr/td[2]")
	public WebElementFacade lbl_vrfid;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Filter')]")
	public WebElementFacade btn_filter;
	@FindBy(id = "(saveChanges")
	public WebElementFacade btn_saveChanges;
	@FindBy(xpath = "//*[@id=\"productSummaryGrid\"]/div[3]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade arr_secondLogInterface;
	@FindBy(xpath = "(//a[contains(@class,'k-icon k-i-expand')])[1]")
	public WebElementFacade arr_vrfid_arrow;
	@FindBy(xpath = "(//td[contains(.,'VRF ID')])[3]")
	public WebElementFacade lbl_vrfid_secondLabel;
	@FindBy(xpath = "//button[contains(@ng-click,'OpenAccountDialog()')]")
	public WebElementFacade btn_cbpban;
	@FindBy(xpath = "(//button[@id='AccountManagementSearchBtn'])[1]")
	public WebElementFacade btn_new_ban;
	@FindBy(xpath = "(//button[contains(@ng-click,'SearchAccounts()')])[1]")
	public WebElementFacade btn_cbpban_search;
	@FindBy(xpath = "(//span[contains(@ng-bind,'dataItem.AccountName')])[1]")
	public WebElementFacade txt_accountname;
	@FindBy(xpath = "//*[@id=\"vrfResultGrid\"]/div[2]/table/tbody/tr")
	public WebElementFacade txt_accountname1;
	@FindBy(xpath = "(//button[@ng-click='AccountManagementSearchOkClick()'])[1]")
	public WebElementFacade btn_accountsearch;
	@FindBy(id = "acctOkButton") // might not be used
	public WebElementFacade btn_accountok;
	@FindBy(xpath = "(//span[contains(@class,'k-widget k-dropdown k-header')])[1]")
	public WebElementFacade ddl_business_order_id_select;
	@FindBy(xpath = "(//input[contains(@id,'AccountNumberSearchEntry')])[1]")
	public WebElementFacade tbx_account;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Business Order Id')]")
	public WebElementFacade ddl_business_order_id_selected;
	@FindBy(xpath = "//input[contains(@id,'searchId')]")
	public WebElementFacade tbx_order_id_field;
	@FindBy(xpath = "(//span[contains(@class,'k-input ng-scope')])[1]")
	public WebElementFacade tbx_order_id;
	@FindBy(xpath = "//a[contains(@id,'searchBtn')]")
	public WebElementFacade btn_search;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Wholesale UNI')]")
	public WebElementFacade ddl_wholesaleuni_selected;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[35]")
	public WebElementFacade ddl_EVC_class1;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-Access - OVC')]")
	public WebElementFacade ddl_ovc_selected;
	@FindBy(xpath = "(//a[@class='k-icon k-i-expand'])[3]")
	public WebElementFacade btn_expand_2;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[31]")
	public WebElementFacade ddl_ovc;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[32]")
	public WebElementFacade ddl_select_ovc_bandwidth;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[33]")
	public WebElementFacade ddl_select_ovc_class;
	@FindBy(xpath = "(//button[@id='AccountManagementSearchBtn'])[1]")
	public WebElementFacade btn_select_account;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade ddl_select_order_type;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Modify/Add')]")
	public WebElementFacade ddl_order_type_selected;
	@FindBy(xpath = "//input[@aria-owns='CoordinatorDropdown_listbox']")
	public WebElementFacade ddl_CCM_select;
	@FindBy(xpath = "(//span[contains(@unselectable,'on')])[3]")
	public WebElementFacade ddl_order;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Customer Id')]")
	public WebElementFacade ddl_customer_id;
	@FindBy(xpath = "//input[@aria-owns='OESDropdown_listbox']")
	public WebElementFacade ddl_OES_select;
	@FindBy(xpath = "(//button[contains(.,'Search')])[1]")
	public WebElementFacade btn_search_account;
//        	@FindBy(xpath = "//span[contains(.,'LEVEL 3 DEMO AND TESTING')]")
	@FindBy(xpath = "//*[@id=\"AccountManagementSearchGrid\"]/div[2]/table/tbody/tr")
	public WebElementFacade lnk_select_account;
	@FindBy(xpath = "(//button[contains(.,'OK')])[1]")
	public WebElementFacade btn_ok_account;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade btn_select_office;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[3]")
	public WebElementFacade btn_select_product_type;
	@FindBy(css = "div[class='col-xs-12'] span")
	// @FindBy(xpath = "//button[contains(@ng-click,'Create()')]")
	public WebElementFacade btn_save_package;
	@FindBy(xpath = "//a[@href='#customerTabContentOrderPackages']")
	public WebElementFacade btn_order_package;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[43]")
	public WebElementFacade ddl_EVC_class;
	@FindBy(xpath = "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade lnk_account;
	@FindBy(xpath = "//a[@id='headerLinkAnchor']")
	public WebElementFacade lnk_account1;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Order Package Id')]")
	public WebElementFacade ddl_order_id;
	@FindBy(xpath = "//button[@id='ShowCreateOrderPackageFormBtn']")
	public WebElementFacade btn_create_new_package;
	@FindBy(xpath = "//a[contains(@id,'productPackagesTab')]")
	public WebElementFacade btn_product_packages;
	@FindBy(xpath = "//button[@id='addPspBtn']")
	public WebElementFacade btn_add_psp;
	@FindBy(xpath = "//input[@id='searchClliCriteriaTextBox']")
	public WebElementFacade tbx_clli_search;
	@FindBy(xpath = "//button[@id='location-search-button']")
	public WebElementFacade btn_clli_search;
//        	@FindBy(xpath = "(//label[@class='k-checkbox-label'])[20]")
//        	@FindBy(xpath = "(//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr[6]/td[1]")
	@FindBy(xpath = "//label[@for='SL0002991479']")
	public WebElementFacade cbx_clli_select;
	@FindBy(xpath = "//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr[14]/td[1]")
	public WebElementFacade cbx_clli_select_1;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[31]")
	public WebElementFacade ddl_network_status;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Off Net')])[7]")
	public WebElementFacade ddl_select_offnet;
	@FindBy(xpath = "(//label[contains(.,'Bandwidth:')]/following::td//span[@class='k-widget k-dropdown k-header field-width-large'])[1]")
	public WebElementFacade ddl_port_bandwidth;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[33]")
	public WebElementFacade ddl_bandwidth;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'10 Mbps')])[3]")
	public WebElementFacade ddl_select_bandwidth_10mbps;
	@FindBy(xpath = "(//label[contains(.,'Bandwidth:')]/following::td//span[@class='k-widget k-dropdown k-header field-width-large'])[1]/select[@id='paList3']/option[3]")
	public WebElementFacade ddl_select_bandwidth_1gbps;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[34]")
	public WebElementFacade ddl_uni_type;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Transparent')])[22]")
	public WebElementFacade ddl_select_uni_transparent;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Multiplexed')])[18]")
	public WebElementFacade ddl_select_uni_multiplexed;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[37]")
	public WebElementFacade ddl_BE;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Standard Delivery - To the MPoE (Customer Provided)')])[23]")
	public WebElementFacade ddl_select_BE_standard;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[43]")
	public WebElementFacade ddl_EVC_Class;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'<default> Extended Delivery - To the Customer Suite (Lumen Provided)')])[19]")
	public WebElementFacade ddl_select_BE;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[1]")
	public WebElementFacade btn_next_2;
	@FindBy(xpath = "(//button[@ng-disabled='!CanDoNext'])[1]")
	public WebElementFacade btn_next;
	@FindBy(xpath = "//button[contains(.,'New Product Package')]")
	public WebElementFacade btn_new_product_package;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_select_product;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-Line - EVC')]")
	public WebElementFacade ddl_evc_selected;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[4]")
	public WebElementFacade ddl_select_address;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[5]")
	public WebElementFacade ddl_select_address2;
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[3]")
	public WebElementFacade lnk_pencil1;
	@FindBy(xpath = "//input[@id='ambiguousSearchableInput']")
	public WebElementFacade tbx_search_uni_1;
	@FindBy(xpath = "//button[@id='relationshipSearchSearchButton']")
	public WebElementFacade btn_search_uni1;
	@FindBy(xpath = "//*[@id=\"relationshipResultGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade btn_expand_1;
	@FindBy(xpath = "//td[@role='gridcell'][contains(.,'Yes')]")
	public WebElementFacade lnk_select_uni;
	@FindBy(xpath = "//button[@id='relationshipSaveBtn']")
	public WebElementFacade btn_relationship_save;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-pencil')])[4]")
	public WebElementFacade lnk_pencil2;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'UNI')])[1]")
	public WebElementFacade ddl_uni_selected;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'UNI')])[2]")
	public WebElementFacade ddl_uni_selected2;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[3]")
	public WebElementFacade btn_next_second;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Save')])[1]")
	public WebElementFacade btn_save;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Save')])[1]")
	public WebElementFacade btn_save_vrf;
	@FindBy(xpath = "//span[@ng-show='DocumentCount != 0']")
	public WebElementFacade lnk_docs;
	@FindBy(xpath = "//div[@class='leftNavSectionItem'][contains(.,'Docs (0)')]")
	public WebElementFacade lnk_docs1;
	@FindBy(xpath = "//td[contains(.,'SOF.pdf')]")
	public WebElementFacade lnk_sof;
	@FindBy(xpath = "//button[@id='deleteDocBtn']")
	public WebElementFacade btn_delete_sof;
	@FindBy(xpath = "//input[@id='fileUploadInput']")
	public WebElementFacade btn_attach_doc;
	@FindBy(xpath = "(//div[contains(@deselectable,'on')])[6]")
	public WebElementFacade ddl_doc_type;
	@FindBy(xpath = "//button[@ng-click='UpdateDocument(this)']")
	public WebElementFacade btn_save_doc;
	@FindBy(xpath = "(//a[@aria-label='Close'])[4]")
	public WebElementFacade lnk_close_window;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'iSE Design')]")
	public WebElementFacade ddl_doc_ise;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Service Order Form')])[2]")
	public WebElementFacade ddl_doc_sof;
	@FindBy(xpath = "//button[contains(.,'New Product Package')]")
	public WebElementFacade btn_new_package;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_new_package;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'VRF ID')]")
	public WebElementFacade lnk_VRF_ID;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[4]")
	public WebElementFacade ddl_vrf_address;
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[1]")
	public WebElementFacade tbx_network_name;
	@FindBy(xpath = "//button[@id='editDatesBtn']")
	public WebElementFacade btn_edit_dates;
	@FindBy(xpath = "//input[@id='NewNddDatePicker']")
	public WebElementFacade tbx_negotiated_date;
	@FindBy(xpath = "//input[@id='CurrentCrdDatePicker']")
	public WebElementFacade tbx_requested_date;
	@FindBy(xpath = "//button[@id='EditDateDialogOkBtn']")
	public WebElementFacade btn_save_dates;
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[1]/td[4]")
	public WebElementFacade btn_first_product;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[2]//div[2]//tr[1])[2]")
	public WebElementFacade btn_first_sub_product_vrf;
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[1]")
	public WebElementFacade btn_first_sub_product;
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Addresses')]")
	public WebElementFacade btn_addresses;
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Products : E-Access - OVC')]")
	public WebElementFacade btn_product_ovc;
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Products : Wholesale UNI')]")
	public WebElementFacade btn_product_uni;
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[1]")
	public WebElementFacade btn_first_address_edit_transparent;
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_second_address2_edit;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[136]")
	public WebElementFacade btn_end_user_CLLI1_transparent;

	public WebElementFacade aendcllitransparent(String a_end_clli_transparent) {
		WebElementFacade aendcllitransparent = findBy(
				"//li[@tabindex='-1'][contains(.,'" + a_end_clli_transparent + "')]");
		return aendcllitransparent;
	}

	public WebElementFacade zendcllitransparent(String z_end_clli_transparent) {
		WebElementFacade zendcllitransparent = findBy(
				"//li[@tabindex='-1'][contains(.,'" + z_end_clli_transparent + "')]");
		return zendcllitransparent;
	}

	public WebElementFacade aendclli(String a_end_clli) {
		WebElementFacade aendclli = findBy("//li[@tabindex='-1'][contains(.,'" + a_end_clli + "')]");
		return aendclli;
	}

	public WebElementFacade zendclli(String z_end_clli) {
		WebElementFacade zendclli = findBy("//li[@tabindex='-1'][contains(.,'" + z_end_clli + "')]");
		return zendclli;
	}

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_uni_address_edit;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[112]")
	public WebElementFacade btn_end_user_CLLI;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[114]")
	public WebElementFacade btn_end_user_CLLI_eline_uni1;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[110]")
	public WebElementFacade btn_end_user_CLLI_uni2;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'MMPHTNBGS08')]")
	public WebElementFacade lnk_end_user_CLLI_select_MMPHTNBGS08;
	@FindBy(xpath = "(//li[contains(@data-offset-index,'38')])[322]")
	public WebElementFacade btn_end_user_CLLI_DNVTCO56S00;
	@FindBy(xpath = "(//li[@data-offset-index='4'])[27]")
	public WebElementFacade btn_end_user_CLLI_CLEYOHIGS00;
	@FindBy(xpath = "//button[contains(.,'Update Service Address')]")
	public WebElementFacade btn_end_user_CLLI_update;
	@FindBy(xpath = "//button[@ng-click='PullRelatedPsps()'][contains(.,'Save')]")
	public WebElementFacade btn_end_user_CLLI_update_save;
	@FindBy(xpath = "//button[contains(@ng-click,'SaveOrderPackageClick()')]")
	public WebElementFacade btn_top_save;
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[3]")
	public WebElementFacade btn_second_product;
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[2]")
	public WebElementFacade btn_second_product_ipvpn_logical;
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[2]")
	public WebElementFacade btn_second_sub_product;
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[1]")
	public WebElementFacade btn_second_sub_product_ipvpn_logical;
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_second_address1_edit;
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_address_edit_elan_evc;
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Details')]")
	public WebElementFacade btn_details;
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[2]")
	public WebElementFacade lnk_vrf_id_edit;
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[1]")
	public WebElementFacade lnk_ban_edit;
	@FindBy(xpath = "(//button[@id='AccountManagementSearchBtn'])[1]")
	public WebElementFacade lnk_ban_new;
	@FindBy(xpath = "(//input[@id='AccountNumberSearchEntry'])[1]")
	public WebElementFacade tbx_ban_new;
	@FindBy(xpath = "(//button[contains(.,'Search')])[3]")
	public WebElementFacade btn_ban_search;
	@FindBy(xpath = "//span[@ng-bind='dataItem.AccountName']")
	public WebElementFacade lnk_ban_first;
	@FindBy(xpath = "(//button[@ng-click='AccountManagementSearchOkClick()'])[1]")
	public WebElementFacade btn_ban_ok;
	@FindBy(xpath = "//button[@ng-click='CommitAccountNumber()']")
	public WebElementFacade btn_ban_save;
	@FindBy(xpath = "//button[@id='vrfAutoFillCustomerNumber']")
	public WebElementFacade btn_auto_fill;
	@FindBy(xpath = "//button[@id='vrfSearchSearchButton']")
	public WebElementFacade btn_search_vrf;
	@FindBy(xpath = "//button[@ng-click='CommitVrf()']")
	public WebElementFacade btn_vrf_select_save;
	@FindBy(xpath = "//button[@id='editServiceAddressCancelButton']")
	public WebElementFacade btn_cancel;
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[1]")
	public WebElementFacade btn_second_address1_edit_eline;
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_second_address2_edit_eline;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[132]")
	public WebElementFacade btn_end_user_CLLI2_transparent;
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_address2_edit;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[106]")
	public WebElementFacade btn_end_user_2CLLI_transparent;
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_second_address_edit;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[142]")
	public WebElementFacade btn_end_user_2CLLI;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[134]")
	public WebElementFacade btn_end_user_CLLI_eline;

	public WebElementFacade aendclli1(String a_end_clli) {
		WebElementFacade aendclli1 = findBy("//li[@tabindex='-1'][contains(.,'" + a_end_clli + "')]");
		return aendclli1;
	}

	public WebElementFacade zendclli2(String z_end_clli) {
		WebElementFacade zendclli2 = findBy("//li[@tabindex='-1'][contains(.,'" + z_end_clli + "')]");
		return zendclli2;
	}

	public WebElementFacade aendclli_gvpn(String a_end_clli) {
		WebElementFacade aendclli_gvpn = findBy("//li[@tabindex='-1'][contains(.,'" + a_end_clli + "')]");
		return aendclli_gvpn;
	}

	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'BNGHNYBCS00')]")
	public WebElementFacade lnk_end_user_2CLLI_select_BNGHNYBCS00;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[142]")
	public WebElementFacade btn_end_user_2CLLI2;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[106]")
	public WebElementFacade btn_ovc_end_user_CLLI2_eaccess;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[124]")
	public WebElementFacade btn_ovc_end_user_CLLI1;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[95]")
	public WebElementFacade btn_end_user_CLLI_elan_evc;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[96]")
	public WebElementFacade btn_end_user_CLLI_elan_evc_endpoint;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[112]")
	public WebElementFacade btn_end_user_CLLI_elan_evc_UNI;
	@FindBy(xpath = "//span[@aria-owns='endUserClliDropDown_listbox']/span/span[1]")
	public WebElementFacade ddl_end_user_CLLI_update;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'LABBRMCOS00')]")
	public WebElementFacade lnk_ovc_end_user_CLLI1_select_LABBRMCOS00;
	@FindBy(xpath = "//a[contains(.,'GLMID')]//parent::th/a/span")
	public WebElementFacade btn_glm_dropdown;
	@FindBy(xpath = "//input[@title='Value']")
	public WebElementFacade btn_filter_value;
	@FindBy(xpath = "//button[@type='reset'][contains(.,'Clear')]")
	public WebElementFacade btn_filter_clear;

	public WebElementFacade aendcllieaccess(String a_end_clli_eaccess) {
		WebElementFacade aendcllieaccess = findBy("//li[@tabindex='-1'][contains(.,'" + a_end_clli_eaccess + "')]");
		return aendcllieaccess;
	}

	public WebElementFacade aendcllielan(String a_end_clli_elan) {
		WebElementFacade aendcllielan = findBy("//li[@tabindex='-1'][contains(.,'" + a_end_clli_elan + "')]");
		return aendcllielan;
	}

	public WebElementFacade bendcllielan(String b_end_clli_elan) {
		WebElementFacade bendcllielan = findBy("//li[@tabindex='-1'][contains(.,'" + b_end_clli_elan + "')]");
		return bendcllielan;
	}

	public WebElementFacade cendcllielan(String c_end_clli_elan) {
		WebElementFacade cendcllielan = findBy("//li[@tabindex='-1'][contains(.,'" + c_end_clli_elan + "')]");
		return cendcllielan;
	}

	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'CLEYOHIGS00')]")
	public WebElementFacade lnk_ovc_end_user_CLLI1_select_cleyohig;
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[4]")
	public WebElementFacade btn_third_product;
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[2]")
	public WebElementFacade btn_third_sub_product;
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_third_address_edit;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[110]")
	public WebElementFacade btn_end_user_eline_uni2;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[2])[1]")
	public WebElementFacade btn_order_package_first;
	@FindBy(xpath = "//a[contains(@id,'orderDetailsTab')]")
	public WebElementFacade btn_order_details;
	@FindBy(xpath = "//input[@aria-owns='OESDropdown_listbox']")
	public WebElementFacade ddl_OES;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[9]")
	public WebElementFacade ddl_VSC;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[12]")
	public WebElementFacade ddl_TDE;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[14]")
	public WebElementFacade ddl_Director;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[15]")
	public WebElementFacade ddl_Manager;
	@FindBy(xpath = "//button[contains(@ng-click,'ValidateTaskClick()')]")
	public WebElementFacade btn_validate;
	@FindBy(xpath = "//button[@id='completeTask']")
	public WebElementFacade btn_complete;
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[2]")
	public WebElementFacade lnk_order_package_1st_task;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[4])[1]")
	public WebElementFacade lnk_order_package_ready1;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[6])[1]")
	public WebElementFacade lnk_OES_ready1;
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]")
	public WebElementFacade lnk_order_package_second;
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[5]")
	public WebElementFacade lnk_order_package_fourth;
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[4]")
	public WebElementFacade lnk_order_package_third;
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[6]")
	public WebElementFacade lnk_order_package_fifth;
	@FindBy(xpath = "//button[@id='reassignTaskToMe']")
	public WebElementFacade btn_reassign_me;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[3])[1]")
	public WebElementFacade lnk_order_package_ready2;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[5])[1]")
	public WebElementFacade lnk_order_package_ready4;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[4])[1]")
	public WebElementFacade lnk_order_package_ready3;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[7])[1]")
	public WebElementFacade lnk_order_package_ready5;
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable'])[1]/table/tbody/tr[2]/td[5]")
	public WebElementFacade btn_order_package_space;
	@FindBy(xpath = "//span[@id='headerUserInfo']")
	public WebElementFacade btn_userinfo;
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[1]")
	public WebElementFacade tbx_ins_id_1;
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[2]")
	public WebElementFacade tbx_ins_id_2;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[32]")
	public WebElementFacade ddl_evc;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[33]")
	public WebElementFacade ddl_select_bandwidth;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[34]")
	public WebElementFacade ddl_select_class;
	@FindBy(xpath = "//input[@aria-owns='impersonateUserId_listbox']")
	public WebElementFacade tbx_impersonate_to_user;
	@FindBy(xpath = "//button[@id='impersonateUserBtn']")
	public WebElementFacade btn_impersonate;
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[1]/td/p/a")
	public WebElementFacade btn_collapse;
	@FindBy(xpath = "//a[@href='#contacts']")
	public WebElementFacade btn_contacts;
	@FindBy(xpath = "//input[@class='contact-form-elements contact-name-text-box k-input']")
	public WebElementFacade tbx_add_contact;
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	public WebElementFacade tbx_contact_role;
	@FindBy(xpath = "(//input[@type='checkbox'][contains(@id,'CON')])[1]")
	public WebElementFacade cbx_contact_role_select;
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	public WebElementFacade tbx_contact_section;
	@FindBy(xpath = "//input[@id='OrderPackage']")
	public WebElementFacade cbx_contact_section_1;
	@FindBy(xpath = "(//input[@type='checkbox'])[50]")
	public WebElementFacade cbx_contact_section_2;
	@FindBy(xpath = "(//input[@type='checkbox'])[51]")
	public WebElementFacade cbx_contact_section_3;
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[4]/span")
	public WebElementFacade lbl_ready;
	@FindBy(xpath = "//button[@id='GetPspsButton']")
	public WebElementFacade btn_getpsp;
	@FindBy(xpath = "//input[@id='pspIdInventorySearchTxt']")
	public WebElementFacade tbx_psp_id;
	@FindBy(xpath = "//span[@ng-bind='dataItem.ProductPackageId']")
	public WebElementFacade btn_psp_id_row;
	@FindBy(xpath = "//button[@id='modifyBtn']")
	public WebElementFacade btn_modify;
	@FindBy(xpath = "//button[@id='modifyDisconnectOkBtn']")
	public WebElementFacade btn_modify_ok;
	@FindBy(xpath = "(//button[@ng-click='OkBtnClicked()'])[3]")
	public WebElementFacade btn_modify_ok_ok;
	@FindBy(xpath = "//label[@for='existingOPRadio']")
	public WebElementFacade rbn_modify_existing_package;
	@FindBy(xpath = "//span[contains(.,'551531805')]")
	public WebElementFacade lnk_modify_order_package_select;
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade ddl_order_type;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Modify/Add')]")
	public WebElementFacade ddl_order_type_select;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[6]")
	public WebElementFacade ddl_CCM;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_attributes_edit;
	@FindBy(xpath = "//span[@class='k-input ng-scope' and contains(text(),'bps')]")
	public WebElementFacade ddl_bandwidth_edit;
	@FindBy(xpath = "(//span[@class='k-input ng-scope' and contains(text(),'bps')])[2]")
	public WebElementFacade ddl_bandwidth_edit_ovc;
	@FindBy(xpath = "//td[contains(.,'IP Logical - Service')]")
	public WebElementFacade ipLogicalServiceRow;
	@FindBy(xpath = "//td[contains(.,'Lumen to Assign WAN IPs?')]/..//select")
	public WebElementFacade lumenToAssignWanIP;
	@FindBy(xpath = "//td[contains(.,'WAN IPv4 Block Size')]/..//select")
	public WebElementFacade waniPv4BlockSize;
	// SEO Webelemnt(Metastorm)
	@FindBy(xpath = "(//ul[@class='rcbList'])[1]/li")
	public List<WebElementFacade> processDropDown_Options;
	@FindBy(xpath = "//input[@name='ctl00$phMainContent$WatchListPart$StageList']")
	public WebElementFacade stageDropdown;
	@FindBy(xpath = "(//ul[@class='rcbList'])[2]/li")
	public List<WebElementFacade> stageDropdownOptions;
	@FindBy(xpath = "//td[@class='gridData']//tbody/tr")
	public List<WebElementFacade> allrecords;
	@FindBy(xpath = "//td[@class='gridData']//tbody/tr/td[1]")
	public List<WebElementFacade> allOrders;
	@FindBy(xpath = "//td[@class='gridData']//tbody/tr/td[2]")
	public List<WebElementFacade> allSubjects;
	@FindBy(xpath = "//span[text()='ManuallyExpireWCTaskWait']")
	public WebElementFacade manuallyExpireWCTaskWait;
	@FindBy(xpath = "//span[text()='ActivateOVTask']")
	public WebElementFacade activateOVTask;
	@FindBy(xpath = "//span[text()='CreditCheckDone']")
	public WebElementFacade creditCheckDone;
	@FindBy(xpath = "//input[@name='btnConfirm']")
	public WebElementFacade btnConfirmForManuallyExpiredWCTask;
	@FindBy(xpath = "//input[@id='btnConfirm' and @value='Yes']")
	public WebElementFacade btnConfirm;
	@FindBy(xpath = "(//*[text()='Circuit Type:']/../..//span)[1]") //
	public WebElementFacade circuitType;
	@FindBy(xpath = "(//*[text()='Port Type:']/../..//span)[1]") //
	public WebElementFacade portType;
	// Added by raj
	@FindBy(xpath = "(//*[text()='Access Type:']/../..//span)[1]") //
	public WebElementFacade accessType;
	@FindBy(xpath = "(//*[text()='Access Sub Bandwidth:']/../..//span)[1]") //
	public WebElementFacade accessSubbandwidth;
	@FindBy(xpath = "(//*[text()='Inside Wiring:']/../..//span)[1]") //
	public WebElementFacade insideType;
	@FindBy(xpath = "//span[@aria-owns='OrderTypeDropdown_listbox']/span/span/span") //
	public WebElementFacade orderType;
	@FindBy(xpath = "//*[text()='Coordinator / CCM:']/../..//span/input") //
	public WebElementFacade ccm;
	// vrf
	@FindBy(xpath = "//*[@id='productSummaryGrid']//span[text()='IP VPN Logical Interface']/../../td/a")
	public WebElementFacade ipvpn_logical_expand;
	@FindBy(xpath = "//*[@id='productSummaryGrid']//td[text()='IP VPN Logical Interface']")
	public WebElementFacade ipcpn_logical_clk;
	@FindBy(xpath = "//a[text()='Details']")
	public WebElementFacade details_clk;
	@FindBy(xpath = "//label[text()='VRF ID:']/../../div/button/i")
	public WebElementFacade select_icon;
	@FindBy(xpath = "//*[@id='vrfAutoFillCustomerNumber']")
	public WebElementFacade auto_fill_clk;
	@FindBy(xpath = "//button[@id=\"vrfSearchSearchButton\"]")
	public WebElementFacade vrf_searchbutton;
	@FindBy(xpath = "//div[@id=\"vrfResultGrid\"]//table/tbody/tr[1]")
	public WebElementFacade vrf_first_row;
	@FindBy(xpath = "//button[@ng-click=\"CommitVrf()\"]")
	public WebElementFacade vrf_save;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_search;
		// return txt_searchId;
	}
}
