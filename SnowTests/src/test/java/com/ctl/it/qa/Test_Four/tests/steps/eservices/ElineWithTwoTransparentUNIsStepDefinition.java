//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import java.util.Map;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.ElineWithTwoTransparentUNIs;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//import net.serenitybdd.core.Serenity;
//
//public class ElineWithTwoTransparentUNIsStepDefinition {
//	@Steps
//	ElineWithTwoTransparentUNIs elinewithtwotransparentunis;
//
//	@When("I create a scenario for the product Eline Evc for the A end location {string} and Z end location {string} having two transparent UNIs {string} {string} {string}")
//	public void i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_two_transparent_UNIs(
//			String a_end_eline, String z_end_eline, String Building_Ex_1, String Building_Ex_2, String ENV) {
//		elinewithtwotransparentunis
//				.i_create_a_scenario_for_the_product_Eline_Evc_for_the_A_end_location_and_Z_end_location_having_two_transparent_UNIs(
//						a_end_eline, z_end_eline, Building_Ex_1, Building_Ex_2, ENV);
//	}
//
//	@When("I set the NDD and CRD and update the Cllis for A End {string} and Z End {string} for transparent UNIs")
//	public void i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_transparent_UNIs(
//			String a_end_clli_transparent, String z_end_clli_transparent) {
//		elinewithtwotransparentunis.i_set_the_NDD_and_CRD_and_update_the_Cllis_for_A_End_and_Z_End_for_transparent_UNIs(
//				a_end_clli_transparent, z_end_clli_transparent);
//	}
//
//	@When("completed technical data gathering for the submitted EVC order with below info")
//	public void completed_technical_data_gathering_for_the_submitted_EVC_order_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("BE1"));
//		System.out.println(test.get("BE2"));
//		String Service_Group = elinewithtwotransparentunis
//				.completed_technical_data_gathering_for_the_submitted_EVC_order_with_below_info(table);
//		Serenity.setSessionVariable("ID").to(Service_Group);
//	}
//}
