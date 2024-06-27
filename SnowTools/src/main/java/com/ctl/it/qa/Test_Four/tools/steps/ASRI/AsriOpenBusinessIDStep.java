//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import java.util.List;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHomePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriProjectListPage;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class AsriOpenBusinessIDStep extends AsriStep {
//	AsriHomePage asriHomePage;
//	AsriProjectListPage asriProjectListPage;
//	private final Logger logger = LoggerFactory.getLogger(AsriOpenBusinessIDStep.class);
//
//	@Step
//	public void searchAndOpenserviceGp(String business_order_ID) {
//		logger.info("************** searchAndOpenserviceGp function is started *************");
//		logger.info("on home page");
//		customClickableWait(asriHomePage.lnk_project);
//		asriHomePage.lnk_project.click();
//		logger.info("project icon is clicked");
//		waitABit(35000);
//		getDriver().switchTo().frame(asriProjectListPage.frame_2frame);
//		logger.info("swiched to 2frame");
//		customClickableWait(asriProjectListPage.ddl_ExtOrderID);
//		asriProjectListPage.ddl_ExtOrderID.click();
//		logger.info("clicked on external id");
//		asriProjectListPage.tbx_ExtorderID.sendKeys(business_order_ID + Keys.ENTER);
//		logger.info("oder id is entred");
//		waitABit(5000);
//		for (int i = 0; i <= 100; i++) {
//			List<WebElement> allRows = getDriver().findElements(By.xpath("//*[@class='project-name']"));
//			logger.info("Row Size" + allRows.size());
//			if (allRows.size() == 3) {
//				logger.info("All rows present");
//				break;
//			} else {
//				WebElement refresh = getDriver().findElement(By.xpath("//*[@title='Refresh page']"));
//				JavascriptExecutor js = (JavascriptExecutor) getDriver();
//				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
//						refresh);
//				refresh.click();
//				// WebElement refresh=getDriver().findElement(By.xpath("//*[@title='Refresh
//				// page']")).click();
//				waitABit(5000);
//				logger.info("Counter Value--" + i);
//			}
//		}
//		asriProjectListPage.lnk_serviceGp.click();
//		logger.info("service gp is clicked");
//		logger.info("*********** searchAndOpenserviceGp function is completed **********");
//		waitABit(20000);
//	}
//}