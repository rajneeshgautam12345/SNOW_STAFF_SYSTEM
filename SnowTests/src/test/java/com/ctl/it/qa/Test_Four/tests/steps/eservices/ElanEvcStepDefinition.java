//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.ElanEvcSteps;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class ElanEvcStepDefinition {
//	@Steps
//	ElanEvcSteps elanevcsteps;
//
//	@When("I create a scenario for the product ElanEvc for the A end location {string} B end location {string} and C end location {string}")
//	public void i_create_a_scenario_for_the_product_ElanEvc_for_the_A_end_location_B_end_location_and_C_end_location(
//			String a_end_point, String b_end_point, String c_end_point) {
//		elanevcsteps
//				.i_create_a_scenario_for_the_product_ElanEvc_for_the_A_end_location_B_end_location_and_C_end_location(
//						a_end_point, b_end_point, c_end_point);
//	}
//
//	@When("I perform the profitability analysis for elan")
//	public void i_perform_the_profitability_analysis_for_elan() {
//		elanevcsteps.i_perform_the_profitability_analysis_for_elan();
//	}
//
//	@Then("^The order should be submitted to SwIFT successfully for elan$")
//	public void the_order_should_be_submitted_to_SwIFT_successfully_for_elan() {
//		elanevcsteps.the_order_should_be_submitted_to_SwIFT_successfully_for_elan();
//	}
//
//	@When("^I search the Business Order ID in Swift for elan$")
//	public void i_search_the_Business_Order_ID_in_Swift_for_elan() {
//		elanevcsteps.i_search_the_Business_Order_ID_in_Swift_for_elan();
//	}
//
//	@Then("^It should be generating Order Package IDs$")
//	public void it_should_be_generating_Order_Package_IDs() {
//		elanevcsteps.it_should_be_generating_Order_Package_IDs();
//	}
//
//	@When("I set the NDD and CRD for first order and update the Cllis for A End {string}")
//	public void i_set_the_NDD_and_CRD_for_first_order_and_update_the_Clli_for_A_End(String a_end_clli_elan) {
//		elanevcsteps.i_set_the_NDD_and_CRD_for_first_order_and_update_the_Clli_for_A_End(a_end_clli_elan);
//	}
//
//	@Then("^Third task should be completed$")
//	public void third_task_should_be_completed() {
//		elanevcsteps.third_task_should_be_completed();
//	}
//
//	@When("I set the NDD and CRD for second order and update the Cllis for A End {string} {string}")
//	public void i_set_the_NDD_and_CRD_for_second_order_and_update_the_Clli_for_A_End(String a_end_clli_elan,
//			String b_end_clli_elan) {
//		elanevcsteps.i_set_the_NDD_and_CRD_for_second_order_and_update_the_Clli_for_A_End(a_end_clli_elan,
//				b_end_clli_elan);
//	}
//
//	@When("I set the NDD and CRD for third order and update the Cllis for B End {string} {string}")
//	public void i_set_the_NDD_and_CRD_for_third_order_and_update_the_Clli_for_B_End(String b_end_clli_elan,
//			String a_end_clli_elan) {
//		elanevcsteps.i_set_the_NDD_and_CRD_for_third_order_and_update_the_Clli_for_B_End(b_end_clli_elan,
//				a_end_clli_elan);
//	}
//
//	@When("I set the NDD and CRD for fourth order and update the Cllis for C End {string}")
//	public void i_set_the_NDD_and_CRD_for_fourth_order_and_update_the_Clli_for_C_End(String c_end_clli_elan) {
//		elanevcsteps.i_set_the_NDD_and_CRD_for_fourth_order_and_update_the_Clli_for_C_End(c_end_clli_elan);
//	}
//
//	@When("I complete all the required tasks {string}")
//	public void i_complete_all_the_required_tasks(String c_end_clli_elan) {
//		elanevcsteps.i_complete_all_the_required_tasks(c_end_clli_elan);
//	}
//
//	@Then("Order should move to GCA for Elan")
//	public void order_should_move_to_GCA_for_Elan() {
//		elanevcsteps.order_should_move_to_GCA();
//	}
//
//	@When("^I search the Order Package ID in GCA for elan$")
//	public void i_search_the_Order_Package_ID_in_GCA_for_elan() {
//		elanevcsteps.i_search_the_Order_Package_ID_in_GCA_for_elan();
//	}
//
//	@When("^I search the Order Package ID in ISM for elan$")
//	public void i_search_the_Order_Package_ID_in_ISM_for_elan() {
//		elanevcsteps.i_search_the_Order_Package_ID_in_ISM_for_elan();
//	}
//
//	@When("^I search order package ID in project list page for elan$")
//	public void i_search_order_package_ID_in_project_list_page_for_elan() {
//		elanevcsteps.i_search_order_package_ID_in_project_list_page_for_elan();
//	}
//
//	@When("I process the technical data gathering for Elan")
//	public void i_process_the_technical_data_gathering_for_elan() {
//		elanevcsteps.i_process_the_technical_data_gathering_for_elan();
//	}
//
//	@When("I verify the design")
//	public void i_verify_the_design() {
//		elanevcsteps.i_verify_the_design();
//	}
//
//	@Then("The task should be at Activate stage")
//	public void the_task_should_be_at_activate_stage() {
//		elanevcsteps.the_task_should_be_at_activate_stage();
//	}
//}
