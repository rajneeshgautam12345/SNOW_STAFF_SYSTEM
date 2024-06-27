//package com.ctl.it.qa.Test_Four.tools.steps.AsriSanity;
//
//import org.junit.Assert;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class AsriCeSanitySteps extends BaseStep {
//	AsriHomePage asriHomePage;
//	String Circuit_Name = null;
//
//	@Step
//	public void i_clicked_on_More_option_in_ASRI_Select_the_Circuit_Editor_option() {
//		System.out.println("On Home Page");
//		String url = getDriver().getCurrentUrl();
//		System.out.println("Current URL : " + url);
//		waitABit(10000);
//		String url2 = getDriver().getCurrentUrl();
//		System.out.println("Current URL 2 : " + url2);
//		customClickableWait(asriHomePage.lnk_more);
//		asriHomePage.lnk_more.click();
//		System.out.println("More Icon is Clicked");
//		waitABit(3000);
//		customClickableWait(asriHomePage.lnk_CE);
//		asriHomePage.lnk_CE.click();
//		System.out.println("Circuit Editor Clicked");
//	}
//
//	@Step
//	public void circuit_Editor_page_should_open_successfully() {
//		waitABit(10000);
//		WebElement frame = getDriver().findElement(By.id("9frame"));
//		getDriver().switchTo().frame(frame);
//		customClickableWait(asriHomePage.tbx_circuit_name);
//		waitABit(2000);
//	}
//
//	@Step
//	public void i_entered_the_Circuit_Name_in_CircuitName_Text_box(String Circuit_Name) {
//		asriHomePage.tbx_circuit_name.sendKeys(Circuit_Name + Keys.ENTER);
//		waitABit(90000);
//		customClickableWait(asriHomePage.lst_circuit_name_result);
//		waitABit(5000);
//		String circuit_name = asriHomePage.lst_circuit_name_result.getText();
//		System.out.println("Circuit Name : " + circuit_name);
//		if (circuit_name.equals(Circuit_Name)) {
//			System.out.println("Sanity Passed");
//		} else {
//			System.out.println("Sanity Failed");
//		}
//		Assert.assertEquals(" Validate ASRI CE SANITY", true,
//				asriHomePage.lst_circuit_name_result.containsOnlyText(Circuit_Name));
//	}
//
//	@Step
//	public void circuit_Editor_page_should_load_the_circuit_details() {
//		String circuit_name = asriHomePage.lst_circuit_name_result.getText();
//		System.out.println("Circuit Name : " + circuit_name);
//		System.out.println("Sanity Job Completed");
//	}
//}
