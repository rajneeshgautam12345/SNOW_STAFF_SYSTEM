//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import com.ctl.it.qa.Test_Four.tools.steps.AsriSanity.AsriSanityStep;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class AsriSanityStepDefinition {
//	@Steps
//	AsriSanityStep asrisanitystep;
//
//	@Given("I am logged in as a user in ASRI with {string} credentials in specified environment {string}")
//	public void i_am_logged_in_as_a_user_in_ASRI_with_credentials_in_specified_environment(String userType,
//			String ENV) {
//		asrisanitystep.i_am_logged_in_as_a_user_in_ASRI_with_credentials_in_specified_environment(userType, ENV);
//	}
//
//	@When("I search order package ID on project list page {string}")
//	public void i_search_order_package_ID_on_project_list_page(String Order_ID) {
//		asrisanitystep.i_search_order_package_ID_on_project_list_page(Order_ID);
//	}
//
//	@Then("^The product package should be available$")
//	public void the_product_package_should_be_available() {
//		asrisanitystep.the_product_package_should_be_available();
//	}
//}
