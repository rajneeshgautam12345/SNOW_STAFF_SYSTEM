//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.EaccessOvcSteps;
//
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class EaccessOvcStepDefinition {
//	@Steps
//	EaccessOvcSteps eaccessovcsteps;
//
//	@When("I create a scenario for the product EaccessOvc for the A end location {string} and Z end location {string} having existing ENNI {string} {string}")
//	public void i_create_a_scenario_for_the_product_EaccessOvc_for_the_A_end_location_and_Z_end_location_having_existing_ENNI(
//			String a_end_eaccess, String z_end_eaccess, String ENNI, String Building_Ex) {
//		eaccessovcsteps
//				.i_create_a_scenario_for_the_product_EaccessOvc_for_the_A_end_location_and_Z_end_location_having_existing_ENNI(
//						a_end_eaccess, z_end_eaccess, ENNI, Building_Ex);
//	}
//
//	@When("^I perform the profitability analysis for eaccess$")
//	public void i_perform_the_profitability_analysis_for_eaccess() {
//		eaccessovcsteps.i_perform_the_profitability_analysis_for_eaccess();
//	}
//
//	@When("I set the NDD and CRD and update the Clli for A End {string}")
//	public void i_set_the_NDD_and_CRD_and_update_the_Clli_for_A_End(String a_end_clli_eaccess) {
//		System.out.println("A End Clli : " + a_end_clli_eaccess);
//		eaccessovcsteps.i_set_the_NDD_and_CRD_and_update_the_Clli_for_A_End(a_end_clli_eaccess);
//	}
//
//	@When("I process the technical data gathering for Eaccess {string}")
//	public void i_process_the_technical_data_gathering_for_eaccess(String Building_Ex) {
//		eaccessovcsteps.i_process_the_technical_data_gathering_for_eaccess(Building_Ex);
//	}
//}
