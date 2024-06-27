package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.FlightDeckPage;
import com.ctl.it.qa.Test_Four.tools.steps.flightdeck.FlightDeckSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class FlightDeckStepDefinition {
	private final Logger logger = LoggerFactory.getLogger(FlightDeckStepDefinition.class);
	@Steps
	FlightDeckSteps flightDecksteps;
	FlightDeckPage flightDeck;

	@Given("User logs in as valid user in flight deck")
	public void user_logs_in_as_valid_user_in_flight_deck() {
		flightDecksteps.logs_in_flightDeck();
	}


	@When("User navigate to Advance Search Page")
	public void user_navigate_to_Advance_Search_Page() {
		flightDecksteps.navigate_To_AdvanceSearch();
	}

	@Then("User successfully navigated to advance search page")
	public void user_successfully_navigated_to_advance_search_page() {
		flightDecksteps.validateAdvanceSearchPage();
	}

	@When("User enters the Order Id and hit on search")
	public void user_enters_the_Order_Id_and_hit_on_search() {
		flightDecksteps.searchOrderId();
		flightDecksteps.selectPerPageTaskSize("10");
	}

	@Then("Order records successfully dispalyed")
	public void order_records_successfully_dispalyed() {
	}

	@When("User complete the CSA task")
	public void user_complete_the_CSA_task() {
		flightDecksteps.User_Search_And_Open_Task("Confirm/Schedule Activation");
		flightDecksteps.AssignWorkbookAndUserToTask("");
		flightDecksteps.completeTask();
	}

	@Then("User successfully completed the CSA task")
	public void user_successfully_completed_the_CSA_task() {
		flightDecksteps.closeAllTab();
	}

	@When("User complete the service validate field task")
	public void user_complete_the_service_validate_field_task() {
		flightDecksteps.User_Search_And_Open_Task("Service Validate Field");
		flightDecksteps.AssignWorkbookAndUserToTask("");
		flightDecksteps.completeTask();
		// flightDecksteps.UserComplete_Service_Validate_Field_Task("Service Validate
		// Field");
	}

	@Then("User successfully completed the service validate field task")
	public void user_successfully_completed_the_service_validate_field_task() {
		flightDecksteps.closeAllTab();
	}

	@When("User complete the service validate UNI tester task")
	public void user_complete_the_service_validate_UNI_tester_task() {
		flightDecksteps.User_Search_And_Open_Task("Service Validate - UNI (Tester)");
		flightDecksteps.AssignWorkbookAndUserToTask("");
		flightDecksteps.completeTask();
		// flightDecksteps.UserComplete_Service_Validate_UNI_Task("Service Validate -
		// UNI (Tester)");
	}

	@Then("User successfully completed the service validate UNI tester task")
	public void user_successfully_completed_the_service_validate_UNI_tester_task() {
		flightDecksteps.closeAllTab();
	}

	@When("User complete the send completion details task")
	public void user_complete_the_send_completion_details_task() {
		flightDecksteps.User_Search_And_Open_Task("Send Completion Details");
		flightDecksteps.AssignWorkbookAndUserToTask("");
		flightDecksteps.completeTask();
		// flightDecksteps.UserComplete_Send_Completion_Details_Task("Send Completion
		// Details");
	}
	
	
	//Snow Added
	@When("User logs in flightdeck application")
	public void user_logs_in_flightdeck_application() {
		flightDecksteps.logs_in_flightDeck();
	}
	
	@Then("User validates the {string} task kicked off for order")
	public void user_validates_the_task_kicked_off_for_order(String taskName) {
		flightDecksteps.user_Switch_To_Flight_Deck_Window();
		flightDecksteps.waitABit(60000);
		flightDecksteps.User_Search_Task(taskName);
	}
}
