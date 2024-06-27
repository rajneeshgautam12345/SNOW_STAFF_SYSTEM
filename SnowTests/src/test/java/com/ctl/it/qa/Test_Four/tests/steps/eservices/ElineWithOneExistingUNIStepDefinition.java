//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.ElineWithOneExistingUNI;
//
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//
//public class ElineWithOneExistingUNIStepDefinition {
//	@Steps
//	ElineWithOneExistingUNI elinewithoneexistinguni;
//
//	@When("I create a scenario for the product Eline Evc for the A end location {string} and Z end location {string} having one existing UNI {string}")
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_one_existing_UNI(
//			String a_end_eline, String z_end_eline, String existing_uni) {
//		elinewithoneexistinguni
//				.i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_one_existing_UNI(
//						a_end_eline, z_end_eline, existing_uni);
//	}
//
//	@When("I set the NDD and CRD and update the Cllis for A End {string} and Z End {string} for existing UNI")
//	public void i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_existing_UNI(String a_end_clli,
//			String z_end_clli) {
//		elinewithoneexistinguni.i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_existing_UNI(
//				a_end_clli, z_end_clli);
//	}
//}
