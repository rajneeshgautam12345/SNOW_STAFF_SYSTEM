package com.ctl.it.qa.Test_Four.tests;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.steps.snow.CustomerOrderSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.ServiceNowSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.UserDefinedException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ServiceNowStepDefinition {
	@Steps
	ServiceNowSteps serviceNowSteps;
	@Steps
	CustomerOrderSteps customerOrderSteps;

	@When("User logs in DOP application")
	public void user_logs_in_DOP_application() {
		serviceNowSteps.logs_in_dop_application();
	}

	@Then("User successfully logged in DOP application")
	public void user_successfully_logged_in_DOP_application() {
		serviceNowSteps.validate_dop_application();
	}

	@When("User search the quotes in DOP")
	public void user_search_the_quotes_in_DOP() {
		serviceNowSteps.searchOrderInDOP();
	}

	@Then("User successfully get the order records")
	public void user_successfully_get_the_order_records() throws UserDefinedException {
		serviceNowSteps.validateSearchedOrderRecords();
	}

	@Then("User validates the order move to swift")
	public void user_validates_the_order_move_to_swift() throws UserDefinedException {
		serviceNowSteps.validatesOrderSwitchToSwiftPath();
	}

	@When("User logs in Snow application")
	public void user_logs_in_Snow_application() {
		serviceNowSteps.logs_in_snow_application();
	}

	@Then("User successfully logged in snow application")
	public void user_successfully_logged_in_snow_application() {
		serviceNowSteps.validate_Snow_application();
	}

	@When("User navigate to customer orders submodule")
	public void user_navigate_to_customer_orders_submodule() {
		serviceNowSteps.impersonateUser("Sean Eger");
		serviceNowSteps.switchToGlobalDomain();
		serviceNowSteps.navigate_To_Customer_Orders_Submodule();
	}

	@Then("User succesfully landed to customer orders submodule")
	public void user_succesfully_landed_to_customer_orders_submodule() {
		serviceNowSteps.validate_Customer_Orders_Submodule();
		
		
	}

	@When("User search the order in customer orders submodule")
	public void user_search_the_order_in_customer_orders_submodule() {
		serviceNowSteps.impersonateUser("Sean Eger");
		serviceNowSteps.switchToGlobalDomain();
		serviceNowSteps.navigate_To_Customer_Orders_Submodule();
		serviceNowSteps.validate_Customer_Orders_Submodule();
		serviceNowSteps.search_Orders();
	}

	@Then("successfully displayed the searched order records")
	public void successfully_displayed_the_searched_order_records() {
		serviceNowSteps.validatesSearchedOrderRecords();
	}

	@When("User clicks on Customer order")
	public void user_clicks_on_Customer_order() {
		serviceNowSteps.clicks_On_Customer_Orders();
	}

	@Then("User successfully landed to order deatils")
	public void user_successfully_landed_to_order_deatils() {
		customerOrderSteps.landed_To_Orders_Details();
	}

	// New
	@When("User clicks on approve button")
	public void user_clicks_on_approve_button() {
		customerOrderSteps.clicks_On_Approve_Order();
	}

	@Then("order successfully gets approved")
	public void order_successfully_gets_approved() {
		customerOrderSteps.validatesOrderApproved();
	}

	@When("User clicks on show related items link")
	public void user_clicks_on_show_related_items_link() {
		customerOrderSteps.clicks_On_Related_Items();
	}

	@When("User clicks on related order entities")
	public void user_clicks_on_related_order_entities() {
		customerOrderSteps.clicks_On_Related_Order_Entities();
	}

	@Then("User successfully validates the SM id, Opportunity Id")
	public void user_successfully_validates_the_SM_id_Opportunity_Id() {
		customerOrderSteps.validates_Related_Order_Entities();
	}
		
	@When("User navigates to gather_order_details tab")
	public void user_navigates_to_gather_order_details_tab() {
		customerOrderSteps.clicks_On_Technical_Data_Gathering_Tab();
	}

	@When("fillup the access type and access subtype details under tdg form")
	public void fillup_the_access_type_and_access_subtype_details_under_tdg_form() {
		customerOrderSteps.enters_AccessType_and_AccessSubType_details();
	}

	@When("enters the details for IP subnets and save it")
	public void enters_the_details_for_ip_subnets_and_save_it() {
		customerOrderSteps.enters_ip_Subnet_details();
		customerOrderSteps.user_navigates_Back_To_CustomerOrderPage_From_OrderLineItem();
	}

	@When("enters the details for transport access and save it")
	public void enters_the_details_for_transport_access_and_save_it() {
		customerOrderSteps.enters_transport_access_details();
		customerOrderSteps.user_navigates_Back_To_CustomerOrderPage_From_OrderLineItem();
	}

	@When("user navigates back to customer order page")
	public void user_navigates_back_to_customer_order_page() {
		customerOrderSteps.user_navigates_Back_To_CustomerOrderPage_From_OrderLineItem();
	
	}

	@Then("User validates the Path Comp workflow kicked off")
	public void user_validates_the_path_comp_workflow_kicked_off() {
	
		String flowName="";
		customerOrderSteps.open_Path_Comp_Workflow(flowName);
		
	}

	

	@When("User navigates to the path comp mesh action")
	public void user_navigates_to_the_path_comp_mesh_action() {
		customerOrderSteps.user_navigates_to_Mesh_Path_action();
		
		
	}

	@Then("User validates the device and port details of mesh response")
	public void user_validates_the_device_and_port_details_of_mesh_response() {
		customerOrderSteps.user_validates_device_and_port_details_of_mesh_response();
		
		//span[text()='MESH Path Comp']
	}

	

	@When("User navigates to the flow designer")
	public void user_navigates_to_the_flow_designer() {
	    
	}

	@Then("User validates the Create UNI action completed successfully")
	public void user_validates_the_create_uni_action_completed_successfully() {	  	
		//span[text()='AutoPilot Create UNI']/../../../../div[3]/span[1]	
		//p[text()='Wait for Enrichment Value: u_port_service_alias arrives']/../../../div[3]/span[1]
		
	}

	@When("User navigates to the service order enrichment tab")
	public void user_navigates_to_the_service_order_enrichment_tab() {
		customerOrderSteps.clicks_On_Service_Order_Enrichment_Items();
		
	}

	@Then("User validates the port service alias updated successfully")
	public void user_validates_the_port_service_alias_updated_successfully() {
		customerOrderSteps.user_Validates_Port_Service_Alias_Value();
	}
	

@When("User approve the credit check status")
public void user_approve_the_credit_check_status() {
	customerOrderSteps.user_Approve_Credit_Check_Status();
	
}


@When("User do the following")
public void user_do_the_following() {
	serviceNowSteps.user_do_the_following();
	
}
}