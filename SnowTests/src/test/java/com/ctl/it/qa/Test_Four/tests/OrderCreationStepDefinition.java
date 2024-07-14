package com.ctl.it.qa.Test_Four.tests;

import javax.mail.MessagingException;

import org.apache.http.impl.conn.tsccm.WaitingThreadAborter;

import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.DIASteps;
import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.ExaSwitchSteps;
import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.SDWanSteps;
import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.WaveLengthSteps;
import com.ctl.it.qa.Test_Four.tools.steps.Locations.CreateLocationSteps;
import com.ctl.it.qa.Test_Four.tools.steps.Oppty.CreateOppySteps;
import com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager.CreateScenarioSteps;
import com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager.SecenarioDataSteps;
import com.ctl.it.qa.Test_Four.tools.steps.user.UserSteps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class OrderCreationStepDefinition {
	@Steps
	UserSteps endUser;
	@Steps
	CreateOppySteps creaateoppysteps;
	@Steps
	CreateScenarioSteps createscenariosteps;
	@Steps
	CreateLocationSteps createLocationsteps;
	@Steps
	DIASteps diasteps;
	@Steps
	SDWanSteps sdwansteps;
	@Steps
	SecenarioDataSteps secenariodatasteps;
	@Steps
	ExaSwitchSteps exaSwitchSteps;
	@Steps
	WaveLengthSteps wavelengthSteps;

	@Given("^User is in SFA url$")
	public void User_is_in_sfa_url() {
		endUser.is_in_sfa_login_page();
	}


	@When("^User logs in as a \"([^\"]*)\" user$")
	public void User_logs_in_as_a_user(String userType) {
		endUser.logs_in_as(userType);
	}

	@Then("User should be on Login Page")
	public void User_should_be_on_login_page() {
		endUser.should_be_on_login_page();
	}

	@When("User creates an Opportunity \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_creates_an_Opportunity(String sAccount, int pdays) {
		creaateoppysteps.user_creates_an_Opportunity(sAccount, pdays);
	}

	@When("^User creates a Secenario$")
	public void user_creates_a_Secenario() {
		createscenariosteps.user_creates_a_Secenario();
	}

//	@When("^User adds three elan valid locations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_three_elan_valid_locations(String faddress, String fcity, String fstate, String fplcode,
//			String secaddress, String seccity, String secstate, String secplcode, String trdaddress, String trdcity,
//			String trdstate, String trdplcode) {
//		createLocationsteps.user_adds_three_elan_valid_locations(faddress, fcity, fstate, fplcode, secaddress, seccity,
//				secstate, secplcode, trdaddress, trdcity, trdstate, trdplcode);
//	}

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
//	@When("^User adds one valid locations using Cilli \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_locations_using_Cilli(String fcountry, String fcilli, String floor, String room) {
//		createLocationsteps.user_adds_one_valid_locations_using_Cilli(fcountry, fcilli, floor, room);
//	}

	@When("^User adds one valid locations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_one_valid_locations(String faddress, String fcity, String fstate, String fplcode) {
		createLocationsteps.user_adds_one_valid_locations(faddress, fcity, fstate, fplcode);
	}

	@When("^User adds one valid locations with floor \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_one_valid_locations_with_floor(String faddress, String floorAndRoom, String fstate,
			String fplcode) {
		createLocationsteps.user_adds_one_valid_locations_with_floor(faddress, floorAndRoom, fstate, fplcode);
		createLocationsteps.navigate_to_proceed_to_product_selection();
	}

//	@When("^User adds one valid international locations with floor \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
//	public void user_adds_one_valid_international_locations_with_floor(String faddress, String fcity, String fstate,
//			String fplcode) {
//		createLocationsteps.user_adds_one_valid_international_locations_with_floor(faddress, fcity, fstate, fplcode);
//	}

	@When("^User adds dia product \"([^\"]*)\" \"([^\"]*)\" \"([^\\\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_dia_product(String smyproduct, String bandwidth, String accessSubbandwidth,
			String billingMethod, String buildingExt) {
		diasteps.user_adds_dia_product(smyproduct, bandwidth, accessSubbandwidth, billingMethod, buildingExt);
	}

	
	
	@When("^User adds secenario data \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_secenario_data(String contact, int pdays) {
		secenariodatasteps.set_Quote_To_Argeement();
		secenariodatasteps.set_HotCut();
		System.out.println("Pdays==" + pdays);
		if (pdays == 3) {
			secenariodatasteps.addGlobalNotes();
		}
		//secenariodatasteps.add_Contacts(contact);
		secenariodatasteps.add_Attachment(pdays,"Service Order Form");
		secenariodatasteps.add_Ban();
		 
	//	secenariodatasteps.submitTechnicalDesignForm(floorAndRoom);
		// secenariodatasteps.submit_the_Order();
		
	}

@When("User adds secenario data {string} {string} {string}")
public void user_adds_secenario_data(String contact, String Pdays, String floorAndRoom) {
   
	int pdays= Integer.parseInt(Pdays);
	secenariodatasteps.set_Quote_To_Argeement();
	secenariodatasteps.set_HotCut();
	System.out.println("Pdays==" + pdays);
	if (pdays == 3) {
		secenariodatasteps.addGlobalNotes();
	}
	secenariodatasteps.add_Contacts(contact,floorAndRoom);
	secenariodatasteps.adding_Ban();
	secenariodatasteps.add_Attachment(pdays,"Service Order Form");
//	String scenarioName=System.getProperty("ScenarioName");
//	System.out.println("scenarioName==" +scenarioName);
//	if(scenarioName.equals("Wavelength_Encrypted"))
//	{
//		secenariodatasteps.waitABit(6000);
//		secenariodatasteps.add_Attachment(pdays,"Encrypted Waves Addendum");
//	}
	secenariodatasteps.add_Ban();
	// secenariodatasteps.submit_the_Order();
}


	@When("^User adds secenario data not submitting order \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_secenario_data_not_submitting_order(String contact, int pdays, String tasknum)
			throws MessagingException {
		secenariodatasteps.set_Quote_To_Argeement();
		secenariodatasteps.set_HotCut();
		//secenariodatasteps.add_Contacts(contact);
		secenariodatasteps.add_Attachment(pdays,"Service Order Form");
		secenariodatasteps.add_Ban();
		secenariodatasteps.sendMailReport_beforeSwift(tasknum);
	}

	@Then("^User can work order in provisioning$")
	public void user_can_work_order_in_provisioning() throws MessagingException {
		endUser.user_can_work_order_in_provisioning();
	}

	@When("User adds dia product {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_adds_dia_product(String smyproduct, String bandwidth, String subBandwidth, String billingMethod,
			String buildingExt, String multipleLogicals, String pdr, String cdr, String term) {
		diasteps.user_adds_dia_products(smyproduct, bandwidth, subBandwidth, billingMethod, buildingExt,
				multipleLogicals, pdr, cdr, term);
	}

	
	@When("User adds managed service component to DIA order {string} {string} {string} {string}")
	public void user_adds_managed_service_component_to_DIA_order(String managedService, String managedServiceType,
			String kitName, String cpeProvider) {
		diasteps.user_adds_managed_services(managedService, managedServiceType, kitName, cpeProvider);
	}

	@When("User submit the product configured")
	public void user_submit_the_product_configured() {
		diasteps.productConfigurationFinishButtonAndDiscountingApproval();
		
		
	}
	
	@When("User submitted the order to DOP {string}")
	public void user_submitted_the_order_to_dop(String floorAndRoom) {
//		secenariodatasteps.submitTechnicalDesignForm();
//		secenariodatasteps.submit_SingleDigitalForm(floorAndRoom);
		
		if(!floorAndRoom.equals("Floor 1 Room 9999"))
		{
		secenariodatasteps.submit_the_Order();
		}
		
	}

	@When("User submitted the order to DOP {string} {string}")
	public void user_submitted_the_order_to_dop(String floorAndRoom, String scenario) {
//		secenariodatasteps.submitTechnicalDesignForm(scenario);
//		secenariodatasteps.submit_SingleDigitalForm(floorAndRoom);
		
//		if(!floorAndRoom.equals("Floor 1 Room 9999"))
//		{
//		secenariodatasteps.submit_the_Order();
//		}
		
	}

	@When("User submitted the order to DOP")
	public void user_submitted_the_order_to_DOP() {
		
		secenariodatasteps.submit_the_Order();
	}

	@When("^User adds sdwan product \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_adds_sdwan_product(String smyproduct, String accesstype, String access1, String bandwidth,
			String bill_method, String buildingExt) {
		sdwansteps.user_adds_sdwan_product(smyproduct, accesstype, access1, bandwidth, bill_method, buildingExt);
	}
	

@When("User adds dia product {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
public void user_adds_dia_product(String smyproduct, String bandwidth, String subBandwidth, String accessSolution, String billingMethod, String buildingExt, String multipleLogicals, String pdr, String cdr, String term) {
	diasteps.user_adds_dia_products2(smyproduct, bandwidth, subBandwidth, accessSolution,billingMethod, buildingExt,
			multipleLogicals, pdr, cdr, term);
}


@When("User adds exaSwitch product {string} {string} {string} {string} {string} {string} {string}")
public void user_adds_exaSwitch_product(String smyproduct, String bandwidth, String alocationBuilExtension, String cloudServiceProvider,
		String cspLocationName, String customRoute, String term) {
	exaSwitchSteps.user_adds_exaSwitch_products(smyproduct, bandwidth, alocationBuilExtension, cloudServiceProvider, cspLocationName, customRoute, term);;
}


@When("User adds first valid locations with floor {string} {string} {string} {string}")
public void user_adds_first_valid_locations_with_floor(String faddress, String floorAndRoom, String fstate, String fplcode) {
	createLocationsteps.user_adds_one_valid_locations_with_floor(faddress, floorAndRoom, fstate, fplcode);
}

@When("User adds second valid locations with floor {string} {string} {string} {string}")
public void user_adds_second_valid_locations_with_floor(String secaddress, String floorAndRoom2, String fstate, String string4) {
   
	createLocationsteps.create_second_location(secaddress, floorAndRoom2, fstate);
	createLocationsteps.navigate_to_proceed_to_product_selection();
}

@When("User adds wavelength product {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
public void user_adds_wavelength_product(String smyproduct, String bandwidth, String buildingExt_A, String buildingExt_Z, String custom_Route, String protection, String circuit_Divesity,String latency_guarantee,String encryption,String contract_Type,String term) {
	wavelengthSteps.user_adds_wavelength_product(smyproduct, bandwidth, buildingExt_A, buildingExt_Z, custom_Route, protection, circuit_Divesity, latency_guarantee, encryption, contract_Type, term);
	
}

@When("User adds wavelength a side access details {string} {string} {string}")
public void user_adds_wavelength_a_side_access_details(String promotion, String aAccessService, String aLoc3rdPartyXconnect) {
	wavelengthSteps.a_Side_Access_Configuration(promotion, aAccessService, aLoc3rdPartyXconnect);
}

@When("User adds wavelength z side access details {string} {string}")
public void user_adds_wavelength_z_side_access_details(String zAccessService, String zLoc3rdPartyXconnect) {
	wavelengthSteps.z_Side_Access_Configuration(zAccessService, zLoc3rdPartyXconnect);
}

@When("User switch the pre-depoloy status {string}")
public void user_switch_the_pre_depoloy_status(String pre_DeployStatus) {
	
		wavelengthSteps.preDeploySwitch(pre_DeployStatus);
	}


@When("User submit the TDF and SDF form {string} {string}")
public void user_submit_the_tdf_and_sdf_form(String floorAndRoom, String scenario) {
	secenariodatasteps.submitTechnicalDesignForm(scenario);
	secenariodatasteps.submit_SingleDigitalForm(floorAndRoom,scenario);
	
	if(scenario.equals("DIA_Affiliate"))
	{
		secenariodatasteps.addRelatedNumber();
	}
	
}

}