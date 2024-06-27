//package com.ctl.it.qa.Test_Four.tests.steps.eservices;
//
//import java.util.Map;
//
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.SwiftEaccessOvcSteps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.annotations.Steps;
//import net.serenitybdd.core.Serenity;
//
//public class SwiftEaccessOvcStepDefinition {
//	@Steps
//	SwiftEaccessOvcSteps swifteaccessovcsteps;
//
//	@When("I prepare the order package in swift for OVC with below info")
//	public void i_prepare_the_order_package_in_swift_for_OVC_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("a_end_clli"));
//		System.out.println(test.get("z_end_clli"));
//		System.out.println(test.get("GLMID1"));
//		System.out.println(test.get("GLMID2"));
//		System.out.println(test.get("Network_1"));
//		System.out.println(test.get("Uni_Type1"));
//		System.out.println(test.get("BE1"));
//		swifteaccessovcsteps.i_prepare_the_order_package_in_swift_for_EVC_with_below_info(table);
//	}
//
//	@When("completed technical data gathering for the submitted OVC order with below info")
//	public void completed_technical_data_gathering_for_the_submitted_OVC_order_with_below_info(DataTable table) {
//		Map<String, String> test = table.asMap(String.class, String.class);
//		System.out.println(test.get("BE1"));
//		String Service_Group = swifteaccessovcsteps
//				.completed_technical_data_gathering_for_the_submitted_OVC_order_with_below_info(table);
//		Serenity.setSessionVariable("ID").to(Service_Group);
//	}
//
//	@Then("The product should be staged at TDG for OVC")
//	public void the_product_should_be_staged_at_TDG_for_OVC() {
//		swifteaccessovcsteps.the_product_should_be_staged_at_TDG_for_OVC();
//	}
//}
