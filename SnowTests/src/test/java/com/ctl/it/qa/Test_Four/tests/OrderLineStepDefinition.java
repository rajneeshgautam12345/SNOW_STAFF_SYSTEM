package com.ctl.it.qa.Test_Four.tests;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.steps.snow.CustomerOrderSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.OrderLineSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.ServiceNowSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class OrderLineStepDefinition {
	@Steps
	ServiceNowSteps serviceNowSteps;
	@Steps
	OrderLineSteps orderLineSteps;
	@Steps
	CustomerOrderSteps customerOrderSteps;

	@When("User navigates to the customer order page")
	public void user_navigates_to_the_customer_order_page() {
		customerOrderSteps.user_navigates_Back_To_CustomerOrderPage_From_OrderLineItem();
	}

	@When("User navigates to the order line {string} Item")
	public void user_navigates_to_the_order_line_Item(String orderLineProdComp) {
		customerOrderSteps.user_Navigates_To_Component_Order_Line_Item(orderLineProdComp);
	}

	@Then("User successfully navigated to order line {string} Item")
	public void user_successfully_navigated_to_order_line_Item(String component) {
	}

	@Then("User validates the DIA order characteristics")
	public void user_validates_the_DIA_order_characteristics() {
		// snowSteps.user_Validates_DIA_Characteristics();
	}

	@When("User navigates to product order section of DIA")
	public void user_navigates_to_product_order_section_of_DIA() {
		orderLineSteps.user_Navigates_To_Product_Order_Section();
	}

	@When("User navigates to product order section of Internet Service")
	public void user_navigates_to_product_order_section_of_Internet_Service() {
		orderLineSteps.user_Navigates_To_Product_Order_Section();
	}

	@When("User navigates to order tasks section of {string}")
	public void user_navigates_to_order_tasks_section_of(String component) {
		orderLineSteps.user_Switch_Back_To_Order_Line_Item(component);
		orderLineSteps.user_Clicks_On_Order_Task_Tab(component);
	}

	@Then("User validates {string} task is open state")
	public void user_validates_task_is_open_state(String expTaskName) {
		orderLineSteps.user_Validates_Task_Open_Status(expTaskName);
	}

	@Then("User validates {string} task is completed state")
	public void user_validates_task_is_completed_state(String expTaskName) {
		orderLineSteps.user_Validates_Task_Complete_Status(expTaskName);
	}

	@When("User navigates to product order section of Access Service")
	public void user_navigates_to_product_order_section_of_Access_Service() {
		orderLineSteps.user_Navigates_To_Product_Order_Section();
	}

	@Then("User validates the {string} kicked off for {string} under flow context")
	public void user_validates_the_kicked_off_for_under_flow_context(String expWorkflow, String component) {
		orderLineSteps.user_Validates_Workflow_for_Component(expWorkflow, component);
	}

	@When("User clicks on the {string} and clicks on open in operation view")
	public void user_clicks_on_the_and_clicks_on_open_in_operation_view(String workflowName) {
		orderLineSteps.user_Clicks_On_The_Workflow_Link(workflowName);
		serviceNowSteps.user_Clicks_On_Operation_View_Link();
	}

	@When("User completes the {string} task")
	public void user_completes_the_task(String taskName) {
		orderLineSteps.user_Completes_The_Task(taskName);
	}

	@When("User reload the order line item")
	public void user_reload_the_order_line_item() {
		orderLineSteps.user_reload_The_Order_Line_Item_Page();
	}
	

	@When("User enters characteristic values for order line {string} Item")
	public void user_enters_characteristic_values_for_order_line_item(String crd) {
		orderLineSteps.user_entersOrderLineCharacteristicValues(crd);
		orderLineSteps.user_entersContactDetails();
	}


	@Then("User validates the {string} task kicked off time")
	public void user_validates_the_layer_task_kicked_off_time(String int1) {
		
		orderLineSteps.user_validatesLayerOMTTask_Kicked_Off(int1);
	
		
		
	}

}