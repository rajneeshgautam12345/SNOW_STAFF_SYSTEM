//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import java.util.Map;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.SwiftElineEvcSteps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class SwiftElineEvcStepDefinition {
//	@Steps
//	SwiftElineEvcSteps swiftelineevcsteps;
//
//	@Given("I am logged in as a user in Swift in specified environment {string} with Account ID {string}")
//	public void i_am_logged_in_as_a_user_in_Swift_in_specified_environment_with_Account_ID(String ENV,
//			String Account_ID) {
//		swiftelineevcsteps.i_am_logged_in_as_a_user_in_Swift_in_specified_environment_with_Account_ID(ENV, Account_ID);
//	}
//
//	@When("I prepare the order package in swift for EVC with below info")
//	public void i_prepare_the_order_package_in_swift_for_EVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("a_end_clli"));
//		System.out.println(test.get("z_end_clli"));
//		System.out.println(test.get("GLMID1"));
//		System.out.println(test.get("GLMID2"));
//		System.out.println(test.get("Network_1"));
//		System.out.println(test.get("Network_2"));
//		System.out.println(test.get("Uni_Type1"));
//		System.out.println(test.get("Uni_Type2"));
//		System.out.println(test.get("BE1"));
//		System.out.println(test.get("BE2"));
//		swiftelineevcsteps.i_prepare_the_order_package_in_swift_for_EVC_with_below_info(table);
//	}
//
//	@When("I update the contact details for EVC with below info")
//	public void i_update_the_contact_details_for_EVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("Contact"));
//		swiftelineevcsteps.i_update_the_contact_details_for_EVC_with_below_info(table);
//	}
//
//	@When("I upload the SOF in swift")
//	public void i_attach_the_SOF_in_swift() {
//		swiftelineevcsteps.i_attach_the_SOF_in_swift();
//	}
//
//	@When("I complete all the tasks for building the Order")
//	public void i_complete_all_the_tasks_for_building_the_Order_for_account() {
//		swiftelineevcsteps.i_validate_reassign_and_complete_the_first_task_in_swift();
//		swiftelineevcsteps.i_reassign_validate_and_complete_the_second_task_in_swift();
//		swiftelineevcsteps.i_reassign_validate_and_complete_the_last_task_in_swift();
//	}
//}
