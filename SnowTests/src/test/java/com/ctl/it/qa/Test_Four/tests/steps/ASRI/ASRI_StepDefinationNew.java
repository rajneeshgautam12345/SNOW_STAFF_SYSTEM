//package com.ctl.it.qa.Test_Four.tests.steps.ASRI;
//
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriLoginStep;
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriOpenBusinessIDStep;
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriTDGStep;
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriUni1FlowStep;
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriUni2FlowStep;
//import com.ctl.it.qa.Test_Four.tools.steps.ASRI.AsriVerifyDesignStep;
//import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class ASRI_StepDefinationNew {
//	@Steps
//	AsriLoginStep asriLoginStep;
//	@Steps
//	AsriOpenBusinessIDStep asriOpenBusinessIDStep;
//	@Steps
//	AsriTDGStep asriTDGStep;
//	@Steps
//	AsriUni1FlowStep asriUni1FlowStep;
//	@Steps
//	AsriUni2FlowStep asriUni2FlowStep;
//	@Steps
//	AsriVerifyDesignStep asriVerifyDesignStep;
//
//	@Given("^I am on the ASRI Home page$")
//	public void i_am_on_the_ASRI_Home_page() {
//		// System.out.println("first login page");
//		asriLoginStep.asriLogin();
//	}
//
//	@When("^I open the business order ID \"([^\"]*)\" in project list page$")
//	public void i_open_the_business_order_ID_in_project_list_page(String order_package_ID) {
//		System.out.println("business_order_ID : " + order_package_ID);
//		asriOpenBusinessIDStep.searchAndOpenserviceGp(order_package_ID);
//	}
//
//	@When("^I open the business order ID in project list page$")
//	public void i_open_the_business_order_ID_in_project_list_page() {
//		// String orderpackageid = Serenity.sessionVariableCalled("orderpackageid");
////		String orderpackageid3= SwiftSteps.myOpid;
////		System.out.println("orderpackageid is : " + orderpackageid3);
//		String orderpackageid3 = "553410997";
//		SwiftSteps.myOpid = "553410997";
//		asriOpenBusinessIDStep.searchAndOpenserviceGp(orderpackageid3);
//	}
//
//	@And("^I process the technical data gathering for the business order ID$")
//	public void i_process_the_technical_data_gathering_for_the_business_order_ID() {
//		asriTDGStep.flowForTDG();
//	}
//
//	@When("I process the technical data gathering task for RED DIA in {string} flow")
//	public void i_process_the_technical_data_gathering_task_for_RED_DIA_in_flow(String workflow) {
//		asriTDGStep.flowForTDG_REDDIA_Monarch_SAO(workflow);
//	}
//
//	@When("I process the technical data gathering task for IPVPN in {string} flow")
//	public void i_process_the_technical_data_gathering_task_for_IPVPN_in_flow(String workflow) {
//		asriTDGStep.flowForTDGIPVPN();
//	}
//
//	@Then("^The technical data gathering for the business order ID should be completed$")
//	public void the_technical_data_gathering_for_the_business_order_ID_is_completed() {
//		asriTDGStep.TDGValidation();
//		asriTDGStep.waitForPONRTask();
//	}
//
//	@When("^I process the device port selection of Uni-first for the business order ID$")
//	public void i_process_the_device_port_selection_of_Uni_first_for_the_business_order_ID() {
//		asriUni1FlowStep.uni1Flow();
//	}
//
//	@Then("^The device port selection of Uni-first for the business order ID should be completed$")
//	public void the_device_port_selection_of_Uni_first_for_the_business_order_ID_is_completed() {
//		asriUni1FlowStep.validateUni1Status();
//	}
//
//	@When("^I process the device port selection of Uni-second for the business order ID$")
//	public void i_process_the_device_port_selection_of_Uni_second_for_the_business_order_ID() {
//		asriUni2FlowStep.uni2Flow();
//	}
//
//	@Then("^The device port selection of Uni-second for the business order ID should be completed$")
//	public void the_device_port_selection_of_Uni_second_for_the_business_order_ID_is_completed() {
//		// asriUni2FlowStep.validateUni2Status();
//	}
//
//	@When("^I process the verify design for the business order ID$")
//	public void i_process_the_verify_design_for_the_business_order_ID() {
//		asriVerifyDesignStep.evcFlow();
//	}
//
//	@Then("^The verify design for the business order ID should be completed$")
//	public void the_verify_design_for_the_business_order_ID_is_completed() {
//		asriVerifyDesignStep.validateVerifyDesignStatus();
//	}
//}
