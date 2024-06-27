//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.ElineEVCSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class ElineEVCStepDefinition {
//	@Steps
//	ElineEVCSteps elineevcsteps;
//
//	@Given("I am logged in as a user in SSO with {string} credentials in specified environment {string}")
//	public void i_am_logged_in_as_a_user_in_SSO_with_credentials_in_specified_environment(String userType, String ENV) {
//		elineevcsteps.i_am_logged_in_as_a_user_in_SSO_with_credentials_in_specified_environment(userType, ENV);
//	}
//
//	@When("I create a new Lobby opportunity with account number {string}")
//	public void i_create_a_new_Lobby_opportunity_with_account_number(String Account_Number) {
//		elineevcsteps.i_create_a_new_Lobby_opportunity_with_account_number(Account_Number);
//	}
//
//	@Then("^Opty should be created successfully with opportunityid$")
//	public void Opty_should_be_created_successfully_with_opportunityid() {
//		elineevcsteps.Opty_should_be_created_successfully_with_opportunityid();
//	}
//
//	@When("I create a scenario for the product Eline Evc for the A end location {string} and Z end location {string}")
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location(
//			String a_end_eline, String z_end_eline) {
//		elineevcsteps.i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location(
//				a_end_eline, z_end_eline);
//	}
//
//	@Then("^The scenario should be created successfully$")
//	public void the_scenario_should_be_created_successfully() {
//		elineevcsteps.the_scenario_should_be_created_successfully();
//	}
//
//	@When("^I perform the profitability analysis for eline$")
//	public void i_perform_the_profitability_analysis_for_eline() {
//		elineevcsteps.i_perform_the_profitability_analysis_for_eline();
//	}
//
//	@Then("^The added products should be under profitable status$")
//	public void the_added_products_should_be_under_profitable_status() {
//		elineevcsteps.the_added_products_should_be_under_profitable_status();
//	}
//
//	@When("^I update the order stage in the quote and prepare order$")
//	public void i_update_the_order_stage_in_the_quote_and_prepare_order() {
//		elineevcsteps.i_update_the_order_stage_in_the_quote_and_prepare_order();
//	}
//
//	@When("I add the contact details {string} {string} {string}")
//	public void i_add_the_contact_details(String CCM, String SalesEngineer, String Contact) {
//		elineevcsteps.i_add_the_contact_details(CCM, SalesEngineer, Contact);
//	}
//
//	@When("^I attach the SOF$")
//	public void i_attach_the_SOF() {
//		elineevcsteps.i_attach_the_SOF();
//	}
//
//	@When("I update the billing account {string}")
//	public void i_update_the_billing_account(String Billing_Number) {
//		elineevcsteps.i_update_the_billing_account(Billing_Number);
//	}
//
//	@When("^I submit the order$")
//	public void i_submit_the_order() {
//		elineevcsteps.i_submit_the_order();
//	}
//
//	@Then("^The order should be submitted to SwIFT successfully$")
//	public void the_order_should_be_submitted_to_SwIFT_successfully() {
//		elineevcsteps.the_order_should_be_submitted_to_SwIFT_successfully();
//	}
//
//	@Given("I am logged in as a user in Swift in specified environment {string}")
//	public void i_am_logged_in_as_a_user_in_Swift_in_specified_environment(String ENV) {
//		elineevcsteps.i_am_logged_in_as_a_user_in_Swift_in_specified_environment(ENV);
//	}
//
//	@When("^I search the Business Order ID in Swift$")
//	public void i_search_the_Business_Order_ID_in_Swift() {
//		elineevcsteps.i_search_the_Business_Order_ID_in_Swift();
//	}
//
//	@Then("Swift should be generating an Order Package ID")
//	public void swift_should_be_generating_an_Order_Package_ID() {
//		elineevcsteps.it_should_be_generating_a_Order_Package_ID();
//	}
//
//	@When("I set the NDD and CRD and update the Cllis for A End {string} and Z End {string}")
//	public void i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End(String a_end_clli, String z_end_clli) {
//		System.out.println("A End Clli : " + a_end_clli);
//		System.out.println("Z End Clli : " + z_end_clli);
//		elineevcsteps.i_set_the_NDD_and_CRD_and_update_the_cllis_for_a_end_and_z_end(a_end_clli, z_end_clli);
//	}
//
//	@When("^I impersonate the Order Package to a user$")
//	public void i_impersonate_the_Order_Package_to_a_user() {
//		elineevcsteps.i_impersonate_the_Order_Package_to_a_user();
//	}
//
//	@When("^I add an OES$")
//	public void i_add_an_OES() {
//		elineevcsteps.i_add_an_OES();
//	}
//
//	@When("^I validate, reassign and complete the first task$")
//	public void i_validate_reassign_and_complete_the_first_task() {
//		elineevcsteps.i_validate_reassign_and_complete_the_first_task();
//	}
//
//	@Then("^First task should be cmpleted and two more sub tasks gets created$")
//	public void first_task_should_be_cmpleted_and_two_more_sub_tasks_gets_created() {
//		elineevcsteps.first_task_should_be_cmpleted_and_two_more_sub_tasks_gets_created();
//	}
//
//	@When("I reassign, validate and complete the second task {string}")
//	public void i_reassign_validate_and_complete_the_second_task(String ENV) {
//		elineevcsteps.i_reassign_validate_and_complete_the_second_task(ENV);
//	}
//
//	@Then("^Second task should be completed$")
//	public void second_task_should_be_completed() {
//		elineevcsteps.second_task_should_be_completed();
//	}
//
//	@When("^I reassign, validate and complete the third task$")
//	public void i_reassign_validate_and_complete_the_third_task() {
//		elineevcsteps.i_reassign_validate_and_complete_the_third_task();
//	}
//
//	@Then("Order should move to GCA")
//	public void order_should_move_to_GCA() {
//		elineevcsteps.third_task_should_be_completed_and_order_should_move_to_GCA();
//	}
//
//	@When("I log in as a user in GCA")
//	public void i_log_in_as_a_user_in_GCA() {
//		elineevcsteps.i_am_logged_in_as_a_user_in_GCA_in_specified_environment();
//	}
//
//	@When("I search the Order in GCA")
//	public void i_search_the_Order_in_GCA() {
//		elineevcsteps.i_search_the_Order_Package_ID_in_GCA();
//	}
//
//	@Then("Submitted order from Swift should be Approved")
//	public void submitted_order_from_Swift_should_be_Approved() {
//		elineevcsteps.order_details_should_be_populated_in_GCA_with_Order_Result_as_Approved();
//	}
//
//	@Given("I am logged in as a user in ISM in specified environment {string}")
//	public void i_am_logged_in_as_a_user_in_ISM_in_specified_environment(String ENV) {
//		elineevcsteps.i_am_logged_in_as_a_user_in_ISM_in_specified_environment(ENV);
//	}
//
//	@When("^I search the Order Package ID in ISM$")
//	public void i_search_the_Order_Package_ID_in_ISM() {
//		elineevcsteps.i_search_the_Order_Package_ID_in_ISM();
//	}
//
//	@Then("^Order details should be populated in ISM, with Return Message as Sent to ODO\\.$")
//	public void order_details_should_be_populated_in_ISM_with_Return_Message_as_Sent_to_ODO() {
//		elineevcsteps.order_details_should_be_populated_in_ISM_with_Return_Message_as_Sent_to_ODO();
//	}
//
//	@When("I am logged in ASRI with {string} credentials for submitted order")
//	public void i_am_logged_in_ASRI_with_credentials_for_submitted_order(String userType2) {
//		elineevcsteps.i_am_logged_in_ASRI_with_credentials_in_specified_environment(userType2);
//	}
//
//	@When("^I search order package ID in project list page$")
//	public void i_search_order_package_ID_in_project_list_page() {
//		elineevcsteps.i_search_order_package_ID_in_project_list_page();
//	}
//
//	@When("^I process the technical data gathering for Eline$")
//	public void i_process_the_technical_data_gathering_for_eline() {
//		elineevcsteps.i_process_the_technical_data_gathering_for_eline();
//	}
//
//	@Then("The order should be staged at TDG")
//	public void the_order_should_be_staged_at_TDG() {
//		elineevcsteps.the_product_should_be_staged_at_TDG();
//	}
//
//	@Then("I complete the order and push the order to AP")
//	public void i_complete_the_order_and_push_the_order_to_AP() {
//		elineevcsteps.i_complete_the_order_and_push_the_order_to_AP();
//	}
//}