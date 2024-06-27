//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import java.util.Map;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.SwiftStandaloneUniSteps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//import net.serenitybdd.core.Serenity;
//
//public class StandaloneUniStepDefinition {
//	@Steps
//	SwiftStandaloneUniSteps swiftstandaloneunisteps;
//
//	@Given("I am logged in as a user in Swift for account {string}")
//	public void i_am_logged_in_as_a_user_in_Swift_for_account(String Account_ID) {
//		swiftstandaloneunisteps.i_am_logged_in_as_a_user_in_Swift_for_account(Account_ID);
//	}
//
//	@When("I prepare the order package in swift with below info")
//	public void i_prepare_the_order_package_in_swift_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("a_end_clli"));
//		System.out.println(test.get("Network_1"));
//		System.out.println(test.get("BE1"));
//		swiftstandaloneunisteps.i_prepare_the_order_package_in_swift_with_below_info(table);
//	}
//
//	@When("I update the contact details for Uni with below info")
//	public void i_update_the_contact_details_for_Uni_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("Contact"));
//		swiftstandaloneunisteps.i_update_the_contact_details_for_Uni_with_below_info(table);
//	}
//
//	@When("completed technical data gathering for the submitted order with below info")
//	public void completed_technical_data_gathering_for_the_submitted_order_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("BE1"));
//		String Service_Group = swiftstandaloneunisteps
//				.i_process_the_technical_data_gathering_for_Standalone_Uni_with(table);
//		Serenity.setSessionVariable("ID").to(Service_Group);
//	}
//}
