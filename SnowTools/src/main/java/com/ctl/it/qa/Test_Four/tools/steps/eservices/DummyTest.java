//package com.ctl.it.qa.Test_Four.tools.steps.eservices;
//
//import org.junit.Assert;
//
//import com.ctl.it.qa.staf.Steps;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.Serenity;
//
//public class DummyTest extends Steps {
//	String a = null;
//
//	@Step
//	public void test1() {
//		String FilePath = System.getProperty("user.dir" + "\\src\\test\\resources\\SOF.pdf");
//		System.out.println(FilePath);
//		System.out.println("testing session variable");
//		String orderpackageid = "xyz123";
//		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
//		Assert.assertEquals("hello", "abcd", "abcd");
//	}
//
//	@Step
//	public void test2() {
//		System.out.println("testing session called variable");
//		a = Serenity.sessionVariableCalled("orderpackageid");
//		System.out.println("called value is = " + a);
//		Assert.assertEquals("hello2", "abcd", "abc");
//	}
//
//	@Step
//	public void test3() {
//		System.out.println("testing session called variable in test 3");
//		System.out.println("called value is = " + a);
//	}
//}
