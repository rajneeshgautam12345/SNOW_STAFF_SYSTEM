package com.ctl.it.qa.Test_Four.tests.steps.marketplace;

import com.ctl.it.qa.Test_Four.tools.steps.marketplace.MarketplaceSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class MarketplaceStepDefinition {
	@Steps
	MarketplaceSteps marketplaceSteps;

	@Given("User is in marketplace url")
	public void user_is_in_marketplace_url() {
		marketplaceSteps.user_is_in_marketplace_homepage();
	}

	@When("User select the address {string}")
	public void user_select_the_address(String clli) {
		marketplaceSteps.enterLocationAddress(clli);
	}

	@Then("User successfully added the location address")
	public void user_successfully_added_the_location_address() {
	}

	@When("User select the product details {string} {string} {string} {string}")
	public void user_select_the_product_details(String term, String bandwidth, String billingType, String pdr) {
		marketplaceSteps.enterProductDetails(term, bandwidth, billingType, pdr);
	}

	@Then("User successfully added the product details")
	public void user_successfully_added_the_product_details() {
	}

	@When("User choose the building extension details {string}")
	public void user_choose_the_building_extension_details(String buildingExtension) {
		marketplaceSteps.enterBuildingExtensionDetails(buildingExtension);
	}

	@Then("User successfuly chooses the building extension option")
	public void user_successfuly_chooses_the_building_extension_option() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("User selects the managed Router options {string}")
	public void user_selects_the_managed_Router_options(String managedRouter) {
		marketplaceSteps.enterManagedRouter(managedRouter);
	}

	@Then("User successfuly chooses the managed router option")
	public void user_successfuly_chooses_the_managed_router_option() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("User enters the site access and technical contact details {string} {string} {string} {string} {string} {string}")
	public void user_enters_the_site_access_and_technical_contact_details(String firstName, String lastName,
			String mobileNo, String phoneNo, String email, String contactPreference) {
		marketplaceSteps.entersiteAccessContact(firstName, lastName, mobileNo, phoneNo, email, contactPreference);
	}

	@Then("User successfully added the contact details")
	public void user_successfully_added_the_contact_details() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("User enters the service address and equipment location")
	public void user_enters_the_service_address_and_equipment_location() {
		String floor = "Floor 1";
		String room = "Room 1";
		marketplaceSteps.enterServiceAddress(floor, room);
	}

	@Then("User successfully added the service address and equipment location")
	public void user_successfully_added_the_service_address_and_equipment_location() {
	}

	@When("User added the activation & site preparation dates")
	public void user_added_the_activation_site_preparation_dates() {
		marketplaceSteps.enterActivationDate();
	}

	@Then("User successfully added the activation & site preparation dates")
	public void user_successfully_added_the_activation_site_preparation_dates() {
	}
}
