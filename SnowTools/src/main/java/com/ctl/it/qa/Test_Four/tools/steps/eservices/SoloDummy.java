package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import net.serenitybdd.core.pages.WebElementFacade;

public class SoloDummy {
	public static void main(String[] args) {
		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SOF.pdf";
		System.out.println(FilePath);
		String orderpackageid = "12345";
		metastorm(orderpackageid);
	}

	public static WebElementFacade metastorm(String orderpackageid) {
		String xpath = "//td[@class='met-Cell'][contains(.,'" + orderpackageid + "')][1]";
		System.out.println("Xpath is : " + xpath);
		return null;
	}
}
