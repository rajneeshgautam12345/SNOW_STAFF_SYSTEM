//package com.ctl.it.qa.Test_Four.tests;
//
//import java.util.Map;
//
//import javax.mail.MessagingException;
//
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.AdaptiveThreatIntelligenceSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.AddProductSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.BulkCrossConnectSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.CLEngageSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.ColacationSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.CrossConnectStandaloneSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.DDOSSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.DIASteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.ElanEvcEndpointsSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.ElynkInterConnectSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.ElynkSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.EnniWholesaleUniEAccessOvcSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.HSIPProductSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.HSIPWavelengthBillingServiceSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.HubFaciltySteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.IPVPNSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.InternetProductSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.PrivateDedNetworkSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.PrivateLineSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.SDWanSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.TransportEntranceFacilitySteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.WaveLengthSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.WholesaleUniEAccessOvcSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.CreditCheck.CreditCheckSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.Locations.CreateLocationSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.NetworkDesigner.NetworkDesignerSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.Oppty.CreateOppySteps;
//import com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager.CreateScenarioSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager.SecenarioDataSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.SmokeTest.SmokeTestSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.Swift.Script_Builder_SwiftSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;
//import com.ctl.it.qa.Test_Four.tools.steps.user.UserSteps;
//
//import APITests.OpptyAPI;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class UserStepDefinition {
//	@Steps
//	OpptyAPI opptyapi;
//	@Steps
//	UserSteps endUser;
//	@Steps
//	CreateOppySteps creaateoppysteps;
//	@Steps
//	CreateScenarioSteps createscenariosteps;
//	@Steps
//	CreateLocationSteps createLocationsteps;
//	@Steps
//	AddProductSteps addproductsteps;
//	@Steps
//	AdaptiveThreatIntelligenceSteps adaptivethreatintelligencesteps;
//	@Steps
//	PrivateLineSteps privatelinesteps;
//	@Steps
//	HubFaciltySteps hubfaciltysteps;
//	@Steps
//	HSIPProductSteps hsipproductsteps;
//	@Steps
//	PrivateDedNetworkSteps privatedednetworksteps;
//	@Steps
//	WaveLengthSteps wavelengthsteps;
//	@Steps
//	HSIPWavelengthBillingServiceSteps hsipwavelengthbillingservicesteps;
//	@Steps
//	ElanEvcEndpointsSteps elanevcendpointseteps;
//	@Steps
//	TransportEntranceFacilitySteps transportentrancefacilitysteps;
//	@Steps
//	InternetProductSteps internetproductsteps;
//	@Steps
//	DIASteps diasteps;
//	@Steps
//	ColacationSteps colacationsteps;
//	@Steps
//	ElynkSteps elynksteps;
//	@Steps
//	ElynkInterConnectSteps elynkinterconnectsteps;
//	@Steps
//	CrossConnectStandaloneSteps crossconnectstandalonesteps;
//	@Steps
//	BulkCrossConnectSteps bulkcrossconnectsteps;
//	@Steps
//	IPVPNSteps ipvpnsteps;
//	@Steps
//	EnniWholesaleUniEAccessOvcSteps enniwholesaleunieaccessovcsteps;
//	@Steps
//	WholesaleUniEAccessOvcSteps wholesaleunieaccessovcsteps;
//	@Steps
//	CLEngageSteps clengageSteps;
//	@Steps
//	DDOSSteps ddossteps;
//	@Steps
//	SecenarioDataSteps secenariodatasteps;
//	@Steps
//	SwiftSteps swiftsteps;
//	@Steps
//	SDWanSteps sdwansteps;
//	@Steps
//	NetworkDesignerSteps networkdesignersteps;
//	@Steps
//	CreditCheckSteps creditchecksteps;
//	@Steps
//	Script_Builder_SwiftSteps script_builder_steps;
//	@Steps
//	SmokeTestSteps smoketeststeps;
//
//	@Given("^User is in SFA url$")
//	public void User_is_in_sfa_url() {
//		endUser.is_in_sfa_login_page();
//	}
//
//	@Given("^User creates API OpptyID$")
//	public void user_creates_api_opptyid() {
//		opptyapi.create_OpptyAPI();
//	}
//
//	@When("^User logs in as a \"([^\"]*)\" user$")
//	public void User_logs_in_as_a_user(String userType) {
//		endUser.logs_in_as(userType);
//	}
//
//	@Then("User should be on Home Page")
//	public void User_should_be_on_home_page() {
//		endUser.should_be_on_home_page();
//	}
//
//	@Then("User should be on Login Page")
//	public void User_should_be_on_login_page() {
//		endUser.should_be_on_login_page();
//	}
//
//	@When("User creates an Opportunity \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_creates_an_Opportunity(String sAccount, int pdays) {
//		creaateoppysteps.user_creates_an_Opportunity(sAccount, pdays);
//	}
//
//	@When("^User creates a Secenario$")
//	public void user_creates_a_Secenario() {
//		createscenariosteps.user_creates_a_Secenario();
//	}
//
//	@When("^User adds three elan valid locations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_three_elan_valid_locations(String faddress, String fcity, String fstate, String fplcode,
//			String secaddress, String seccity, String secstate, String secplcode, String trdaddress, String trdcity,
//			String trdstate, String trdplcode) {
//		createLocationsteps.user_adds_three_elan_valid_locations(faddress, fcity, fstate, fplcode, secaddress, seccity,
//				secstate, secplcode, trdaddress, trdcity, trdstate, trdplcode);
//	}
//
//	@When("^User adds two valid locations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_two_valid_locations(String faddress, String fcity, String fstate, String fplcode,
//			String secaddress, String seccity, String secstate, String secplcode) {
//		createLocationsteps.user_adds_two_valid_locations(faddress, fcity, fstate, fplcode, secaddress, seccity,
//				secstate, secplcode);
//	}
//
//	@When("^User adds two valid locations using Cilli \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_two_valid_locations_using_Cilli(String fcilli, String fplcode, String seccilli,
//			String secplcode) {
//		createLocationsteps.user_adds_two_valid_locations_using_Cilli(fcilli, fplcode, seccilli, secplcode);
//	}
//
//	@When("^User adds two locations using Cilli with Country \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_two_locations_using_Cilli_with_Country(String fcilli, String fcountry, String seccilli,
//			String seccountry) {
//		createLocationsteps.user_adds_two_locations_using_Cilli_with_Country(fcilli, fcountry, seccilli, seccountry);
//	}
//
//	// @When("^User adds one valid locations using Cilli (.*) (.*)$")
//	@When("^User adds one valid locations using Cilli \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_locations_using_Cilli(String fcountry, String fcilli, String floor, String room) {
//		createLocationsteps.user_adds_one_valid_locations_using_Cilli(fcountry, fcilli, floor, room);
//	}
//
//	@When("^User adds one valid locations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_locations(String faddress, String fcity, String fstate, String fplcode) {
//		createLocationsteps.user_adds_one_valid_locations(faddress, fcity, fstate, fplcode);
//	}
//
//	@When("^User adds one valid locations with floor \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_locations_with_floor(String faddress, String floorAndRoom, String fstate, String fplcode) {
//		createLocationsteps.user_adds_one_valid_locations_with_floor(faddress, floorAndRoom, fstate, fplcode);
//	}
//
//	@When("^User adds product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_product(String smyproduct, String sNet, String bandwidth, String uniType, String buildingExt,
//			String evc_Type, String e_bandwidth, String e_class, String linear_diverse) {
//		addproductsteps.user_adds_product(smyproduct, sNet, bandwidth, uniType, buildingExt, evc_Type, e_bandwidth,
//				e_class, linear_diverse);
//	}
//
//	@When("^User adds one valid international locations with floor \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_international_locations_with_floor(String faddress, String fcity, String fstate,
//			String fplcode) {
//		createLocationsteps.user_adds_one_valid_international_locations_with_floor(faddress, fcity, fstate, fplcode);
//	}
//
//	@When("User adds private line product {string}  {string}")
//	public void user_adds_private_line_product(String smyproduct, String bill_type) {
//		privatelinesteps.user_adds_private_line_product(smyproduct, bill_type);
//	}
//
//	@When("^User adds hub facility product \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_hub_facility_product(String smyproduct, String bandwidth) {
//		hubfaciltysteps.user_adds_hub_facility_product(smyproduct, bandwidth);
//	}
//
//	@When("^User adds sdwan product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_sdwan_product(String smyproduct, String accesstype, String access1, String bandwidth,
//			String bill_method, String buildingExt) {
//		sdwansteps.user_adds_sdwan_product(smyproduct, accesstype, access1, bandwidth, bill_method, buildingExt);
//	}
//
//	@When("^User adds hsip product \"([^\"]*)\"$")
//	public void user_adds_hsip_product(String smyproduct) {
//		hsipproductsteps.user_adds_hsip_product(smyproduct);
//	}
//
//	@When("^User adds private dedicated network product product \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_private_dedicated_network_product(String smyproduct, String dednettype) {
//		privatedednetworksteps.user_adds_private_dedicated_network_product(smyproduct, dednettype);
//	}
//
//	@When("^User adds wavelength product")
//	public void user_adds_wavelength_product(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("Product"));
//		System.out.println(test.get("bandwidth"));
//		System.out.println(test.get("buildingExt_A"));
//		System.out.println(test.get("buildingExt_Z"));
//		System.out.println(test.get("Custom_Route"));
//		System.out.println(test.get("Protection"));
//		System.out.println(test.get("Circuit_Divesity"));
//		System.out.println(test.get("Latency_guarantee"));
//		System.out.println(test.get("Latence_value"));
//		System.out.println(test.get("Encryption"));
//		System.out.println(test.get("Contract_Type"));
//		System.out.println(test.get("Term"));
//
//		wavelengthsteps.user_adds_wavelength_product(table);
//	}
//
//	@When("^User adds hsip wavelength hsip billing hsip service product \"([^\"]*)\"  \"([^\"]*)\"$")
//	public void user_adds_hsip_wavelength_hsip_billing_hsip_service_product(String smyproduct, String bill_type) {
//		hsipwavelengthbillingservicesteps.user_adds_hsip_wavelength_hsip_billing_hsip_service_product(smyproduct,
//				bill_type);
//	}
//
//	@When("^User adds elan evc endpoints \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_elan_evc_endpoints(String smyproduct, String bandwidth, String uniType, String buildingExt,
//			String evc_Type, String e_bandwidth, String e_class, String linear_diverse) {
//		elanevcendpointseteps.user_adds_elan_evc_endpoints(smyproduct, bandwidth, uniType, buildingExt, evc_Type,
//				e_bandwidth, e_class, linear_diverse);
//	}
//
//	@When("^User adds transportEntrancefacility product \"([^\"]*)\"$")
//	public void user_adds_transportEntrancefacility_product(String smyproduct) {
//		transportentrancefacilitysteps.user_adds_transportEntrancefacility_product(smyproduct);
//	}
//
//	@When("^User adds adaptive threat intelligence product \"([^\"]*)\"$")
//	public void user_adds_adaptive_threat_intelligence_product(String smyproduct) {
//		adaptivethreatintelligencesteps.user_adds_adaptive_threat_intelligence_product(smyproduct);
//	}
//
//	@When("^User adds internet product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_internet_product(String smyproduct, String transport, String bandwidth, String buildingExt,
//			String router) {
//		internetproductsteps.user_adds_internet_product(smyproduct, transport, bandwidth, buildingExt, router);
//	}
//
//	@When("^User adds dia product \"([^\"]*)\" \"([^\"]*)\" \"([^\\\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_dia_product(String smyproduct, String bandwidth,String accessSubbandwidth, String billingMethod, String buildingExt) {
//		diasteps.user_adds_dia_product(smyproduct, bandwidth,accessSubbandwidth, billingMethod, buildingExt);
//	}
//
//	@When("^User adds colocation product \"([^\"]*)\"$")
//	public void user_adds_colacation_productt(String smyproduct) {
//		colacationsteps.user_adds_colacation_product(smyproduct);
//	}
//
//	@When("^User adds elynk product  \"([^\"]*)\"$")
//	public void user_adds_elynk_product(String smyproduct) {
//		elynksteps.user_adds_elynk_product(smyproduct);
//	}
//
//	@When("^User adds elynk interconnect product  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_elynk_interconnect_product(String smyproduct, String desTypeA, String ASideDataCenter,
//			String desTypeZ, String ZSideDataCenter, String bandwith, String classpick) {
//		elynkinterconnectsteps.user_adds_elynk_interconnect_product(smyproduct, desTypeA, ASideDataCenter, desTypeZ,
//				ZSideDataCenter, bandwith, classpick);
//	}
//
//	@When("^User adds cross connect standalone product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_cross_connect_standalone_product(String smyproduct, String bill_type, String country) {
//		crossconnectstandalonesteps.user_adds_cross_connect_standalone_product(smyproduct, bill_type, country);
//	}
//
//	@When("^User adds bulk cross connect product \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_bulk_cross_connect_product(String smyproduct, String cable_type) {
//		bulkcrossconnectsteps.user_adds_bulk_cross_connect_product(smyproduct, cable_type);
//	}
//
//	@When("^User adds ip_vpn port access product\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_eip_vpn_port_access_product(String smyproduct, String access, String buildingExt,
//			String Spec_Design) {
//		ipvpnsteps.user_adds_eip_vpn_port_access_product(smyproduct, access, buildingExt, Spec_Design);
//	}
//
//	@When("^User adds enni wholesaleUni e_access_ovc product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_enni_wholesaleUni_e_access_ovc(String smyproduct, String sNet, String bandwidth,
//			String port_redun, String buildingExt, String evc_Type, String e_bandwidth, String e_class, String uni_type,
//			String product_2) {
//		enniwholesaleunieaccessovcsteps.user_adds_enni_wholesaleUni_e_access_ovc(smyproduct, sNet, bandwidth,
//				port_redun, buildingExt, evc_Type, e_bandwidth, e_class, uni_type, product_2);
//	}
//
//	@When("^User adds wholesaleUni e_access_ovc product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_wholesaleUni_e_access_ovc(String smyproduct, String sNet, String bandwidth, String port_redun,
//			String buildingExt, String evc_Type, String e_bandwidth, String e_class, String uni_type, String product_2,
//			String secaddress, String secplcode) {
//		wholesaleunieaccessovcsteps.user_adds_wholesaleUni_e_access_ovc(smyproduct, sNet, bandwidth, port_redun,
//				buildingExt, evc_Type, e_bandwidth, e_class, uni_type, product_2, secaddress, secplcode);
//	}
//
//	@When("^User adds CLEngage product \"([^\"]*)\"$")
//	public void user_adds_CLEngage_product(String smyproduct) {
//		clengageSteps.user_adds_CLEngage_product(smyproduct);
//	}
//
//	@When("^User adds ddos product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_ddos_product(String smyproduct, String clean_bandwidth, String kit_region, String spec_design,
//			String service_type) {
//		ddossteps.user_adds_ddos_product(smyproduct, clean_bandwidth, kit_region, spec_design, service_type);
//	}
//
//	@When("^User adds secenario data \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_secenario_data(String contact, int pdays) {
//		secenariodatasteps.set_Quote_To_Argeement();
//		secenariodatasteps.set_HotCut();
//		System.out.println("Pdays=="+pdays);
//		if(pdays==3)
//		{
//		secenariodatasteps.addGlobalNotes();
//		}
//		secenariodatasteps.add_Contacts(contact);
//		secenariodatasteps.add_Attachment(pdays);
//		secenariodatasteps.add_Ban();
//		//secenariodatasteps.submit_the_Order();
//	}
//
//	@When("^User adds secenario data not submitting order \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_secenario_data_not_submitting_order(String contact, int pdays, String tasknum)
//			throws MessagingException {
//		secenariodatasteps.set_Quote_To_Argeement();
//		secenariodatasteps.set_HotCut();
//		secenariodatasteps.add_Contacts(contact);
//		secenariodatasteps.add_Attachment(pdays);
//		secenariodatasteps.add_Ban();
//		secenariodatasteps.sendMailReport_beforeSwift(tasknum);
//	}
//
//	@When("^User can submit order \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_submit_order(int futureday, String tasknum) throws MessagingException {
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.impersonate_second_task();
//		// networkdesignersteps.get_url_for_attachment_in_ISE();
//		swiftsteps.sendMailReport(tasknum);
//	}
//
//	@When("^User can submit ipvpn order \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_submit_ipvpn_order(int futureday, String tasknum) throws MessagingException {
////		swiftsteps.user_can_submit_order(futureday, tasknum);
////		swiftsteps.user_adds_PSP_order();
////		swiftsteps.user_completes_WelcomeCustomer();
////		networkdesignersteps.user_can_work_order_in_ISE();
////		swiftsteps.user_completes_Customer_Coordination();
////		swiftsteps.user_completes_Order_Details();
////		creditchecksteps.user_completes_Credit_Check();
////		swiftsteps.sendMailReport(tasknum);
//		
//		///
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.user_Gathers_Order_Details();
//		swiftsteps.add_iSE_Document();
//		swiftsteps.press_complete_Swift_Task();	
//		boolean result1 = swiftsteps.search_Target_Task("Ready", "Wait For Credit Approval", 3);
//		//boolean result1 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
//		if (result1 == true) {
//			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
//			swiftsteps.Re_Log_into_Swift();
//		}
//		else
//		{
//			System.out.println("Wait For Credit Approval task is not kicked off");
//		}
//		    swiftsteps.search_Target_Task("Ready", "Welcome Customer", 4);
//			//swiftsteps.user_CompleteWelcomeCustomerTask();
//			swiftsteps.press_complete_Swift_Task();
//			swiftsteps.user_enters_CRD_NDD();
//			swiftsteps.user_enters_vrf_details();
//			swiftsteps.search_Target_Task("Ready", "Coordinate Customer", 4);
//			//swiftsteps.user_CompleteCoordinateCustomerTask();
//			swiftsteps.press_complete_Swift_Task();
//		    swiftsteps.search_Target_Task("Ready", "Complete Order Details", 5);
//		    
//			swiftsteps.press_complete_Swift_Task();
//			//swiftsteps.completes_Complete_Order_Details_Task("Ready", "Complete Order Details");
//			boolean result2 = swiftsteps.search_Target_Task("Ready", "Wait For Credit Approval", 6);
//			//boolean result2 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
//		    if (result2 == true) {
//			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
//			swiftsteps.Re_Log_into_Swift();
//		    }	
//		    swiftsteps.sendMailReport(tasknum);
//	}
//
//	@When("^User can submit BPMS order \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_submit_BPMS_order(int futureday, String tasknum) throws MessagingException {
//		//swiftsteps.Log_in_Swift_get_order2(tasknum);
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.user_Gathers_Order_Details();
//		swiftsteps.add_iSE_Document();
//		swiftsteps.press_complete_Swift_Task();		
//		boolean result1 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
//		if (result1 == true) {
//			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
//			swiftsteps.Re_Log_into_Swift();
//		}
//		else {
//			System.out.println("Wait For Credit Approval task is not Kicked off");
//		}
//		boolean result2 = swiftsteps.checkWelcomeCustomerAndCoordinateCustomerTaskStatus();
//		if (result2 == true) {
//			swiftsteps.Launch_SEO2("OP_Welcome_Customer", "");
//			swiftsteps.Re_Log_into_Swift();
//			swiftsteps.user_CompleteWelcomeCustomerTask();
//			swiftsteps.press_complete_Swift_Task();
//			swiftsteps.user_CompleteCoordinateCustomerTask();
//			swiftsteps.press_complete_Swift_Task();
//		}		
//		boolean result3 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
//		if (result3 == true) {
//			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
//			swiftsteps.Re_Log_into_Swift();
//		}		
//		boolean result4 = swiftsteps.waitingForDownStreamSystemTaskCheck();
//		if (result4 == true) {
//			swiftsteps.Launch_SEO2("OP Install", "Waiting For Downstream System Job Completion");
//			swiftsteps.Re_Log_into_Swift();
//		}
//		
//		swiftsteps.user_enters_CRD();
//		swiftsteps.completes_Order_Validation("Ready", "Order Validation");
//		swiftsteps.Wait_For_BPMS_Acceptance_Task("Completed", "Waiting For BPMS Acceptance");
//		swiftsteps.sendMailReport(tasknum);
//	}
//
//	@When("^User can submit ELan order \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_submit_ELan_order(int futureday, String tasknum) throws MessagingException {
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.sendMailReport(tasknum);
//	}
//
//	@When("^User can submit billing order \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_submit_billing_order(int futureday, String tasknum) throws MessagingException {
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.sendMailReport(tasknum);
//	}
//
//	@When("^User Can Work Order In Swift \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_work_order_in_swift(int futureday, String tasknum) throws MessagingException {
//		swiftsteps.user_can_submit_order(futureday, tasknum);
//		swiftsteps.user_Gathers_Order_Details();
//		swiftsteps.add_iSE_Document();
//		swiftsteps.press_complete_Swift_Task();
//		swiftsteps.overide_completes_WelcomeCustomer("Pending", "Welcome Customer");
//		swiftsteps.press_complete_Swift_Task();
//		swiftsteps.Completes_Customer_Coordination_single_Task("Ready", "Customer Coordination");
//		creditchecksteps.single_location_Credit_Check("Ready", "Waiting For Credit Approval");
//		swiftsteps.Launch_SEO();
//		swiftsteps.Re_Log_into_Swift();
//		swiftsteps.completes_Order_Validation("Ready", "Order Validation");
//		swiftsteps.Wait_For_BPMS_Acceptance_Task("Completed", "Waiting For BPMS Acceptance");
//		swiftsteps.sendMailReport(tasknum);
//	}
//
//	@Then("^User can work order in provisioning$")
//	public void user_can_work_order_in_provisioning() throws MessagingException {
//		endUser.user_can_work_order_in_provisioning();
//	}
//
//	@Then("^User can smoke test order in provisioning \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_can_smoke_test_order_in_provisioning(String id, String env) throws MessagingException {
//		smoketeststeps.user_can_smoke_test_order_in_provisioning(id, env);
//	}
//
//	@Given("^User Can Work Order In Swift ScriptBuild \"([^\"]*)\"$")
//	public void user_can_work_order_in_swift_scriptbuilder(String nBoid) {
//		script_builder_steps.Log_in_Swift_ScriptBuilder_get_order(nBoid);
//		// script_builder_steps.user_Gathers_Order_Details();
//		// swiftsteps.add_iSE_Document();
//		// script_builder_steps.press_complete_Swift_Task();
//		// swiftsteps.overide_completes_WelcomeCustomer("Pending","Welcome Customer");
//		// script_builder_steps.press_complete_Swift_Task();
//		// script_builder_steps.Completes_Customer_Coordination_single_Task("Ready",
//		// "Customer Coordination");
//		// creditchecksteps.single_location_Credit_Check("Ready","Waiting For Credit
//		// Approval");
//		// script_builder_steps.Launch_SEO();
//		// script_builder_steps.completes_Order_Validation("Ready","Order Validation");
//		// script_builder_steps.Wait_For_BPMS_Acceptance_Task("Completed","Waiting For
//		// BPMS Acceptance");
//
//	}
//	
//
//@When("User adds dia product {string} {string} {string} {string} {string} {string} {string} {string} {string}")
//public void user_adds_dia_product(String smyproduct, String bandwidth,String subBandwidth, String billingMethod, String buildingExt,String multipleLogicals,String pdr, String cdr, String term) {
//	diasteps.user_adds_dia_products(smyproduct, bandwidth,subBandwidth, billingMethod, buildingExt,multipleLogicals,pdr,cdr,term);
//	
//}
//
//@When("User adds managed service component to DIA order {string} {string} {string} {string}")
//public void user_adds_managed_service_component_to_DIA_order(String managedService, String managedServiceType, String kitName, String cpeProvider) {
//	diasteps.user_adds_managed_services(managedService, managedServiceType, kitName, cpeProvider);
//	
//}
//
//@When("User submit the product configured")
//public void user_submit_the_product_configured() {
//	diasteps.productConfigurationFinishButtonAndDiscountingApproval();
//	}
//
//@When("User submitted the order to DOP")
//public void user_submitted_the_order_to_DOP() {
//	secenariodatasteps.submit_the_Order();
//}
//}