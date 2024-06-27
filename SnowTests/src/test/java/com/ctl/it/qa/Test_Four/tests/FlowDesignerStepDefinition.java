package com.ctl.it.qa.Test_Four.tests;

import com.ctl.it.qa.Test_Four.tools.steps.snow.FlowDesignerSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class FlowDesignerStepDefinition {
	@Steps
	FlowDesignerSteps flowDesignerSteps;

	@When("User navigates to the workflow window tab")
	public void user_navigates_to_the_workflow_window_tab() {
		flowDesignerSteps.user_switch_To_The_Workflow_Window();
	}

	@When("User successfully navigates to the workflow in flow designer")
	public void user_successfully_navigates_to_the_workflow_in_flow_designer() {
		flowDesignerSteps.user_switch_To_The_Workflow_Window();
	}

	@Then("User validates the order validation wait workflow status")
	public void user_validates_the_order_validation_wait_workflow_status() {
		flowDesignerSteps.user_Switch_Back_To_Flow_Engine_Context_Window();
		flowDesignerSteps.user_Validates_Order_Validation_Wait_Status();
		flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
		
	}

	@Then("User validates the workflow {string} is waiting for CCM Task")
	public void user_validates_the_workflow_is_waiting_for_CCM_Task(String string) {
		flowDesignerSteps.user_Validates_CCM_Task_Wait_Status();
		flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
	}

	@Then("User validates the workflow {string} is waiting for TDG task")
	public void user_validates_the_workflow_is_waiting_for_TDG_task(String string) {
		flowDesignerSteps.user_Validates_TDG_Task_Wait_Status();
		flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
	}

	@Then("User validates the workflow {string} is waiting for IIQ task")
	public void user_validates_the_workflow_is_waiting_for_IIQ_Task(String string) {
		flowDesignerSteps.user_Validates_IIQ_Task_Wait_Status();
		//flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
	}
	
	@Then("User validates the workflow {string} completed successfully")
	public void user_validates_the_workflow_completed_successfully(String workflowName) {
		flowDesignerSteps.refreshWorkflow();
		flowDesignerSteps.validatesWorkflowComleted(workflowName);
		flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
	}

	@Then("User validates the workflow {string} is waiting for mesh path")
	public void user_validates_the_workflow_is_waiting_for_mesh_path(String string) {
	}
	

@When("User open the flow {string} in flow designer")
public void user_open_the_in_flow_designer(String workflow) {
	flowDesignerSteps.User_Open_The_Workfow(workflow);
	
}


@Then("User validates the workflow {string} is waiting for credit check status")
public void user_validates_the_workflow_is_waiting_for_credit_check_status(String string) {
	flowDesignerSteps.user_Validates_Credit_Check_Wait_Status();
	flowDesignerSteps.user_Switch_Back_To_OrderLineWindow_Tab();
}


@Then("User validates {string} flow waiting for {string} task")
public void user_validates_flow_waiting_for_task(String string, String string2) {
	flowDesignerSteps.user_Validates_Offnet_Flow_Waiting_For_Offnet_Manual_Design_Task();
}

@Then("User successfully validates the {string} is waiting for {string}")
public void user_successfully_validates_the_is_waiting_for(String flow, String subflow) {
	int stepNo=26;
	subflow="[ACCESS PO][Wait for stage status to change Off-Net Connection and Status FOC Received OR Circuit Accepted]";
	flowDesignerSteps.user_Validates_Subflow_Waiting_Under_Flow(stepNo,flow,subflow);
	
}

@Then("User validates {string} subflow completed under {string} flow")
public void user_validates_subflow_completed_under_flow(String string, String string2) {
	flowDesignerSteps.user_Validates_Subflow_Create_Offnet_Port_Completed();
}
}