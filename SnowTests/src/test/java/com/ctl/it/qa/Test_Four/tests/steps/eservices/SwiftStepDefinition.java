package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;
import com.ctl.it.qa.Test_Four.tools.steps.user.UserSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SwiftStepDefinition {
	private final Logger logger = LoggerFactory.getLogger(SwiftStepDefinition.class);
	@Steps
	SwiftSteps swiftsteps;
	@Steps
	UserSteps endUser;

	@Given("User login to swift application")
	public void user_login_to_swift_application() {
		swiftsteps.loginToSwift();
	}

	@Then("User successfully logged in swift application")
	public void user_successfully_logged_in_swift_application() {
		swiftsteps.getDriver().getTitle();
		System.out.println(swiftsteps.getDriver().getTitle());
	}

	@When("User click on Create New Package")
	public void user_click_on_Create_New_Package() {
		swiftsteps.ClickOnCreateNewPackage();
	}

	@Then("Create new package section should display")
	public void create_new_package_section_should_display() {
		swiftsteps.validateCreateNewPackageSection();
	}

	@When("User enters the {string} {string} {string} {string}")
	public void user_enters_the(String accName, String salesOffice, String ProdType, String globalRegion) {
		swiftsteps.entersCreateNewPackageDetails(accName, salesOffice, ProdType, globalRegion);
	}

	@When("Clicks on Save New Order Package")
	public void clicks_on_Save_New_Order_Package() {
		swiftsteps.clicksOnSaveNewOrderPackage();
	}

	@Then("Successfully new order number generated {string}")
	public void successfully_new_order_number_generated(String smyproduct) {
		swiftsteps.userSuccessfullyValidatedNewOrderNumberGenerated(smyproduct);
	}

	@When("User navigate to Product Package section")
	public void user_navigate_to_Product_Pacgake_section() {
		swiftsteps.navigateToProductPackageSection();
	}

	@Then("User successfully landed to Product Package section")
	public void user_successfully_landed_to_Product_Package_section() {
	}

	@When("User click on Add PSP")
	public void user_click_on_Add_PSP() {
		swiftsteps.clicksOnAddPSP();
	}

	@Then("User landed to PSP page")
	public void user_landed_to_PSP_page() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@When("User enter the {string} and click on search")
	public void user_enter_the_and_click_on_search(String cLLI) {
		swiftsteps.entersCLLIAndClickOnSeach(cLLI);
	}

	@Then("Location details should display")
	public void location_details_should_display() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@When("User select the location {string} and click on next")
	public void user_select_the_location_and_click_on_next(String eEndCLLI) {
		swiftsteps.selectLocationAndClickOnSave(eEndCLLI);
	}

	@When("User click on add new product")
	public void user_click_on_add_new_product() {
		swiftsteps.userClicksOnAddNewProduct();
	}

	@Then("User landed to product page")
	public void user_landed_to_product_page() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@When("User selects the Product{string} {string} {string}")
	public void user_selects_the_Product(String string, String string2, String string3) {
		swiftsteps.userAddProduct_ProductAddressAndCurrency();
	}

	@Then("product configuration page should display")
	public void product_configuration_page_should_display() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@When("User configure the product details {string} {string} {string} {string}")
	public void user_configure_the_product_details(String string, String string2, String string3, String string4) {
		swiftsteps.userEntersTheProductConfigurationDetails();
	}

	@When("clicks on next button and save button")
	public void clicks_on_next_button_and_save_button() {
		swiftsteps.userSaveProductDetails();
	}

	@Then("User successfully added the product")
	public void user_successfully_added_the_product() {
		swiftsteps.userSuccessfullyValidatedTheAddedProductInProductPackageSection();
	}

	@When("User add the {string} {string} {string} {string} in order details section")
	public void user_add_the_in_order_details_section(String orderType, String ccm, String oes, String nae) {
		swiftsteps.userEntersOrderDeatailsValue();
		swiftsteps.userEntersContactDetails();
		swiftsteps.userClicksOnSaveChanges();
	}

	@Then("User successfully added the order details")
	public void user_successfully_added_the_order_details() {
		logger.info("User successfully added the order details");
	}

	@When("User complete the Analyze\\/Adjust PSP task")
	public void user_complete_the_Analyze_Adjust_PSP_task() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@Then("User successfully completed the Analyze\\/Adjust PSP task")
	public void user_successfully_completed_the_Analyze_Adjust_PSP_task() {
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}

	@When("User complete the tasks in swift and submit the order to BPMS {int} {string}")
	public void user_complete_the_tasks_in_swift_and_submit_the_order_to_BPMS(int futureday, String tasknum) {
		try {
			swiftsteps.user_can_submit_order(futureday, tasknum);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		swiftsteps.user_Gathers_Order_Details();
		swiftsteps.press_complete_Swift_Task();
		boolean result1 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
		if (result1 == true) {
			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
			swiftsteps.Re_Log_into_Swift();
		}
		boolean result = swiftsteps.checkWelcomeCustomerAndCoordinateCustomerTaskStatus();
		if (result == true) {
			swiftsteps.Launch_SEO2("OP_Welcome_Customer", "");
			swiftsteps.Re_Log_into_Swift();
			swiftsteps.user_CompleteWelcomeCustomerTask();
			swiftsteps.press_complete_Swift_Task();
			swiftsteps.user_CompleteCoordinateCustomerTask();
			swiftsteps.press_complete_Swift_Task();
		}
		boolean result3 = swiftsteps.checkWaitForCreditApprovalTaskStatus();
		if (result3 == true) {
			swiftsteps.Launch_SEO2("OP Credit Check", "Wait For Credit Approval");
			swiftsteps.Re_Log_into_Swift();
		}
		boolean result2 = swiftsteps.waitingForDownStreamSystemTaskCheck();
		if (result2 == true) {
			swiftsteps.Launch_SEO2("OP Install", "Waiting For Downstream System Job Completion");
			swiftsteps.Re_Log_into_Swift();
		}
		swiftsteps.enterCustomerRequestDate();
		swiftsteps.completes_Order_Validation("Ready", "Order Validation");
		// swiftsteps.Wait_For_BPMS_Acceptance_Task("Completed", "Waiting For BPMS
		// Acceptance");
	}

	@Then("User successfully submitted the order to BPMS")
	public void user_successfully_submitted_the_order_to_BPMS() {
		swiftsteps.Wait_For_BPMS_Acceptance_Task("Completed", "Waiting For BPMS Acceptance");
		// Write code here that turns the phrase above into concrete actions
		// throw new cucumber.api.PendingException();
	}
}
