package com.ctl.it.qa.Test_Four.tests;

import com.ctl.it.qa.Test_Four.tools.steps.SES.SES;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SES_StepDefination {
	@Steps
	SES ses;

	
	@When("User should be in SES Application     DIA Order is in Closed status")
	public void user_should_be_in_SES_Application_DIA_Order_is_in_Closed_status() {
		ses.open_SES_URL();
	}

	@When("User click on SES Module")
	public void user_click_on_SES_Module() {
		ses.navigate_To_SES_Module();
	}

	@Then("USer succesfully landed on SES page")
	public void user_succesfully_landed_on_SES_page() {
		System.out.println("Sucessfully landed on SES Page");
	}

	@When("User click on My Services link")
	public void user_click_on_My_Services_link() {
		ses.navigate_To_My_Services_Module();
	}

	@Then("USer succesfully landed on My Service  page")
	public void user_succesfully_landed_on_My_Service_page() {
		System.out.println("Sucessfully landed on My Service Page");
	}

	@When("User search Order Id")
	public void user_search_Order_Id() {
		ses.search_Order_ID();
	}

	@Then("User successfully validated Order id in SES")
	public void user_successfully_validated_Order_id_in_SES() {
		ses.send_to_Kenan();
	}
	
	//flightdeck
	



@When("User enters the mandatory field and completes the task")
public void user_enters_the_mandatory_field_and_completes_the_task() {

	
}





}
