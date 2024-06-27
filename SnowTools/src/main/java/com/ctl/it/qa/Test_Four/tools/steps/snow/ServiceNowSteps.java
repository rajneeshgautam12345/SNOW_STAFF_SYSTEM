package com.ctl.it.qa.Test_Four.tools.steps.snow;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.Snow.ServiceNowPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.AddProduct.DIASteps;
import com.ctl.it.qa.Test_Four.tools.steps.Locations.CreateLocationSteps;
import com.ctl.it.qa.Test_Four.tools.steps.ScenarioManager.SecenarioDataSteps;

import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class ServiceNowSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(ServiceNowSteps.class);
	public static String myOpid = null;
	public static String snowOrderId = null;
	ServiceNowPage serviceNowPage;
	SecenarioDataSteps scenariodatasteps;
	ScenarioDataPage senarioDataPage;
	DIASteps diaSteps;
	E2ESteps e2e;
	
	public void logs_in_dop_application() {
		String dopUrl = envData.getFieldValue("dopurl");
		serviceNowPage.openAt(dopUrl); // the snow url from the e2e.xml
		
		// serviceNowPage.waitForTextToAppear("Get the Order Details",60000);
		// E2ESteps.softAssertError("In Swift", true, "the BOID ",
		// String.valueOf(nSwiftID));
	}

	public void validate_dop_application() {
		serviceNowPage.waitForTextToAppear("Get the Order Details", 60000);
		logger.info("Successfully launched the DOP application");
	}

	public void searchOrderInDOP() {
		waitABit(25000);
		// String smId = "SM10414236";
		//String boid = System.getProperty("Swift.ID");
		String smId = System.getProperty("SID.ID");
		System.out.println(smId);
		// String quoteNo="";
		serviceNowPage.quoteSearchBox.sendKeys(smId);
		logger.info("Successfully searched the SM Id in DOP");
		//serviceNowPage.quoteSearchBox.sendKeys(boid);
		serviceNowPage.submitButton.click();
		logger.info("Successfully clicked on submit button");
		try {
		serviceNowPage.waitForTextToAppear("DOP : Order Details", 90000);
	     }
	     catch(TimeoutException e)
	    {
		 waitABit(15000);
		 serviceNowPage.submitButton.click();
	    }
}

	public void validateSearchedOrderRecords() throws UserDefinedException {
		serviceNowPage.waitForTextToAppear("DOP : Order Details", 90000);
		logger.info("Order records searched in DOP application");
		serviceNowPage.orderRecordRow.isDisplayed();
		String stausOfOrder = serviceNowPage.processStatus.getText();
		String orderSystem = serviceNowPage.orderSystem.getText();
		logger.info("Status of service now order" + stausOfOrder);
		if (stausOfOrder.equals("FAILED") || !orderSystem.equals("SNOW")) {
			System.out.println(serviceNowPage.errorMsgDetails.getText());
			throw new UserDefinedException("Failed to retrieve service now order");
		} else {
			snowOrderId = serviceNowPage.orderId.getText();
			logger.info("Service now order id-" + snowOrderId);
		}
	}

	public void logs_in_snow_application() {
		//String snowUrl = envData.getContainer("Snow").getFieldValue("url");
		String userType="Valid";
		String snowUrl = envData.getFieldValue("ServiceNow");		
		String username = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_uname");
		String myUser =envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_username");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		
//		String username = envData.getContainer("Snow").getFieldValue("tbx_username");
//		String myUser = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_username");
//		String myUserPassword = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_password");
//		String password=envData.getContainer("Snow").getFieldValue("tbx_password");
		serviceNowPage.openAt(snowUrl); // the snow url from the e2e.xml
		serviceNowPage.username.sendKeys(username);
		waitABit(3000);
		serviceNowPage.submit.click();
		waitABit(2000);
		serviceNowPage.tbx_username.sendKeys(myUser);
		waitABit(1000);
		serviceNowPage.btn_next_submit.click();
		waitABit(3000);
		serviceNowPage.tbx_password.sendKeys(myUserPassword);
		waitABit(1000);
		serviceNowPage.btn_next_submit.click();
		waitABit(2000);
		serviceNowPage.btn_NO.click();
	}

	public void validate_Snow_application() {
		String serviceNowHomePagetitle = serviceNowPage.getDriver().getTitle();
		if (serviceNowHomePagetitle.equals("Dashboards Overview | ServiceNow")) {
			System.out.println("Successfully logged in snow");
		}
	}

	public void navigate_To_Customer_Orders_Submodule() {
		serviceNowPage.navigatorSearchBox.sendKeys("Customer Orders");
		waitABit(5000);
		serviceNowPage.customerOrders.click();
	}

	public void validate_Customer_Orders_Submodule() {
		String customerOrdersPage = serviceNowPage.getDriver().getTitle();
		if (customerOrdersPage.equals("Customer Orders | ServiceNow")) {
			logger.info("Successfully navigated to Customer Orders Page");
		}
	}

	public void search_Orders() {
		// String orderId="";
		// serviceNowPage.customerOrderSearch.sendKeys(snowOrderId);
		getDriver().switchTo().frame("gsft_main");
		serviceNowPage.waitForTextToAppear("Search", 90000);
		waitABit(1000);
		serviceNowPage.searchFilterName.selectByVisibleText("Customer Order");
		waitABit(1000);
		snowOrderId = "880013362";
		serviceNowPage.customerOrderSearch.sendKeys(snowOrderId);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("Serached Customer Order id in snow");
	}

	public void validatesSearchedOrderRecords() {
		serviceNowPage.orderRecords.isDisplayed();
		serviceNowPage.getDriver()
				.findElement(By.xpath(
						serviceNowPage.validateSearchedOrder1 + snowOrderId + serviceNowPage.validateSearchedOrder2))
				.isDisplayed();
		logger.info("Successfully displayed searched order record");
	}

	public void clicks_On_Customer_Orders() {
		waitABit(2000);
		waitABit(2000);
		String orderIdLink1 = "//a[text()='";
		String orderIdLink2 = "']";
		getDriver().findElement(By.xpath(orderIdLink1 + snowOrderId + orderIdLink2)).isDisplayed();
		getDriver().findElement(By.xpath(orderIdLink1 + snowOrderId + orderIdLink2)).click();
		logger.info("Navigated to Customer Order details page");
		// 880007387
	}

	public void validatesOrderSwitchToSwiftPath() throws UserDefinedException {
		serviceNowPage.waitForTextToAppear("DOP : Order Details", 90000);
		logger.info("Order records searched in DOP application");
		serviceNowPage.orderRecordRow.isDisplayed();
		String stausOfOrder = serviceNowPage.processStatus.getText();
		String orderSystem = serviceNowPage.orderSystem.getText();
		String msgDetails = serviceNowPage.errorMsgDetails.getText();
		logger.info("Status of service now order" + stausOfOrder);
		logger.info("Message details of order" + msgDetails);
		if (stausOfOrder.equals("DONE") || orderSystem.equals("SwIFT")) {
			String swiftBusinessOrderId = serviceNowPage.boid.getText();
			logger.info("Swift BOID" + swiftBusinessOrderId);
			logger.info("Successfully order reached to swift");
		} else {
			throw new UserDefinedException("Failed to retrieve service now order");
		}
	}

	public void impersonateUser(String user) {
		serviceNowPage.userName.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		// serviceNowPage.impersonate.click();
		waitABit(2000);
		serviceNowPage.searchUser.click();
		getDriver().switchTo().activeElement().sendKeys(user);
		waitABit(5000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(10000);		
	}

	public void user_Clicks_On_Operation_View_Link() {
		serviceNowPage.operationView.click();
		logger.info("Successfully clicked on operation view link");
	}
//		
//public void user_Validates__Workflow_Status(String Workflow_Name) {
//		
//		List<WebElement> allWorkflowStatus=serviceNowPage.workflowStatus;
//		List<WebElement> allWorkflowName=serviceNowPage.workflow_Name;
//		List<WebElement> allWorkflowCommentName=serviceNowPage.workflowCommentName;
//		
//		for(int i=0;i<=allWorkflowStatus.size()-1;i++)
//		{
//			String statusOfWorkflow=allWorkflowStatus.get(i).getText();
//			String workflowName=allWorkflowName.get(i).getText();
//			String workflowCommentName=allWorkflowCommentName.get(i).getText();
//			
//			logger.info(workflowName+"-"+statusOfWorkflow);
//			
//			if(i<=19)
//			{
//				
//			}
//			
//			
//			
//			
//			
//			if(statusOfWorkflow.equals("Waiting") && workflowCommentName.equals("[SOX COMPLIANCE]: Wait for task closure / resolution"))
//			{		
//			  logger.info("Waiting for Order validation task to be completed in Snow");
//			}
//			}
//		
//		//String parentWindow=getDriver]().getWindowHandle();
//		Set<String> allWindows=getDriver().getWindowHandles();
//		
//		for (String window : allWindows) 
//		{
//		  String title=getDriver().switchTo().window(window).getTitle();
//		  if(!title.equals("Flow Designer - Operations View : LMN-ORCH-DIA-Order Validation Execution"))
//		  {
//			  getDriver().switchTo().window(window);
//		  }
//		}
//		}
//	

	public void switchToGlobalDomain() {
		
		Select s1= new Select(serviceNowPage.domainDropdown);
		s1.selectByVisibleText("global");
		waitABit(4000);
	}

	
	public void user_do_the_following() {
	
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		//String url="https://lumn--e2e.sandbox.lightning.force.com/lightning/r/Opportunity_Quote__c/aSGVG0000002MHN4A2/view";
		String url="https://lumn--e2e.sandbox.lightning.force.com/one/one.app#eyJjb21wb25lbnREZWYiOiJvbmU6YWxvaGFQYWdlIiwiYXR0cmlidXRlcyI6eyJhZGRyZXNzIjoiaHR0cHM6Ly9sdW1uLS1lMmUuc2FuZGJveC5saWdodG5pbmcuZm9yY2UuY29tL2FwZXgvTmV3T3Bwb3J0dW5pdHlRdW90ZT9PcHBvcnR1bml0eV9RdW90ZV9fYz1TTTEwNjIyOTI0Jk9wcG9ydHVuaXR5X19jPTAwNlZHMDAwMDA1SXpJSCZPcHBvcnR1bml0eU51bWJlcj0xNTk0NjU0MTgmb3A9RWRpdCZvYmplY3Q9T3Bwb3J0dW5pdHlRdW90ZSZyZXRVUkw9MDA2VkcwMDAwMDVJeklIIn0sInN0YXRlIjp7fX0%3D";
		getDriver().navigate().to(url);
		
		waitABit(8000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		
		e2e.singleLocationNextandDiscount();
		
		//diaSteps.user_adds_dia_products(smyproduct, bandwidth, accessubBandwidth, billingMethod, buildingExt, multipleLogicals, pdr, cdr, term);
//		senarioDataPage.waitForTextToAppear("Additional Fields", 10000);
//		String currentUrl= getDriver().getCurrentUrl();		
//	
//		getDriver().findElement(By.xpath("//span[text()='Show more actions']/..")).click();
//		waitABit(2000);
//		List<WebElement> allOptions = getDriver()
//				.findElements(By.xpath("//div[@role='menu']/slot/runtime_platform_actions-action-renderer"));
//		int allSizeOptions = allOptions.size();
//		logger.info("Sizeee--" + allSizeOptions);	
//		//String text=allOptions.get(i).getAttribute("title");
//		if (allSizeOptions>2)
//		{
//			getDriver().findElement(By.xpath("//*[@title='Submit to Order']")).click();
//		} 	    
//		else {
//		getDriver().findElement(By.xpath("//button[text()='Submit to Order']")).click();
//		}
		
		
//		getDriver().findElement(By.xpath("//span[text()='Show more actions']/..")).click();
//		waitABit(2000);
//		List<WebElement> allOptions = getDriver()
//				.findElements(By.xpath("//div[@role='menu']/slot/runtime_platform_actions-action-renderer"));
//		int allSizeOptions = allOptions.size();
//		logger.info("Sizeee--" + allSizeOptions);
//		for(int i=0;i<=allOptions.size()-1;i++)
//		 {
//			String title=allOptions.get(i).getAttribute("title");
//			if(title.equals("Technical Design Form"))
//			{
//				allOptions.get(i).click();	
//			}
//		} 
//		
//	
		
//		waitABit(13000);
//		Boolean myflag;
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for bandwidth");
//		}
//		
//		waitABit(2000);
//		
//		
//		
//		
//		WebElement iframe_quote  = getDriver().findElement(By.xpath("//iframe[@title='accessibility title']"));
//		getDriver().switchTo().frame(iframe_quote);
//		
//		WebElement iframe_manage_scenario = getDriver().findElement(By.xpath("//iframe[@id='quote-iframe'][@name='theIframe']"));
//		getDriver().switchTo().frame(iframe_manage_scenario);
//		
//		senarioDataPage.waitForTextToAppear("DQPK", 80000);
//		System.out.println("found the record");
		
//		WebElement OptionIcon=getDriver().findElement(By.xpath("//td[@data-col-key-value='8-action-8']//span//button"));
//		Actions a1=new Actions(getDriver());
//		a1.moveToElement(OptionIcon).click().build().perform();
//		waitABit(1000);
//		getDriver().findElement(By.xpath("//div[@role='menu']//a/span[text()='Edit']")).click();
//		waitABit(12000);
//		
//		WebElement ele1=getDriver().findElement(By.xpath("//label[@for='pmoNo-1']"));
//		
//		if(myEnv.equals("TEST4"))
//		{
//			WebElement ipTechDetails=getDriver().findElement(By.xpath("//a[@data-label='IP Technical Details']"));
//			executor.executeScript("arguments[0].click();", ipTechDetails);
//			waitABit(3000);
//			
//		}
//		
//		WebElement ipModeBridged=getDriver().findElement(By.xpath("//label[@for='ipModeBridged-1']"));
//		executor.executeScript("arguments[0].scrollIntoView(true);", ipModeBridged);
//		waitABit(2000);
//		executor.executeScript("arguments[0].click();", ipModeBridged);
//		
//		
//		
//		WebElement ipVersion=getDriver().findElement(By.xpath("//button[@name='LAN_IP_Version__c']"));
//		
//		WebElement wanIPBlock=getDriver().findElement(By.xpath("//button[@name='IPv4_Public_WAN_Prefix_Length__c']"));
//		
//		WebElement ele5=getDriver().findElement(By.xpath("//label[@for='LANIPsNo-1']"));
//		WebElement ele6=getDriver().findElement(By.xpath("//button[@name='Routing_Protocol__c']"));
//
//		if(myEnv.equals("TEST4"))
//		{
//			waitABit(2000);
//			WebElement accessDetails=getDriver().findElement(By.xpath("//a[@data-label='Access Details']"));
//			executor.executeScript("arguments[0].click();", accessDetails);
//			waitABit(3000);			
//		}
//		
//		WebElement cablingType=getDriver().findElement(By.xpath("//label[@for='cablingFiber-1']"));
//		WebElement ele11=getDriver().findElement(By.xpath("//label[@for='redundantPowerNo-1']"));
//		WebElement ele12=getDriver().findElement(By.xpath("//label[@for='powerTypeAC-1']"));
//		WebElement ele13=getDriver().findElement(By.xpath("//label[@for='cpeDuplexHardcoded-1']"));
//
//
//		WebElement saveButton=getDriver().findElement(By.xpath("//button[@title='Save Version']"));
//		
//		WebElement publishButton=getDriver().findElement(By.xpath("//button[@title='Publish']"));
//	
//		executor.executeScript("arguments[0].scrollIntoView(true);", cablingType);
//		waitABit(2000);
//		
//		executor.executeScript("arguments[0].click();", cablingType);
//		waitABit(4000);
//		
//		WebElement fiberMode=getDriver().findElement(By.xpath("//button[@name='Customer_Fiber_Mode__c']"));
//
//		
//		executor.executeScript("arguments[0].click();", fiberMode);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("S");
//		waitABit(700);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(1000);
//		
//		
//		waitABit(1000);
//		WebElement connectorType=getDriver().findElement(By.xpath("//label[@for='connectorLC-1']"));
//		executor.executeScript("arguments[0].click();", connectorType);
//		waitABit(2000);
//		
//		WebElement existingBuildExtCablingType=getDriver().findElement(By.xpath("//label[@for='beCablingFiber-1']"));
//		
//
//		executor.executeScript("arguments[0].click();", existingBuildExtCablingType);
//		waitABit(2000);
//		
//		WebElement buildExtFiberMode=getDriver().findElement(By.xpath("//button[@name='BE_Fiber_Mode__c']"));
//		executor.executeScript("arguments[0].click();", buildExtFiberMode);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("S");
//		waitABit(700);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(1000);
//		
//		WebElement buildExtConnectorType=getDriver().findElement(By.xpath("//label[@for='beConnectorLC-1']"));
//		
//		executor.executeScript("arguments[0].click();", buildExtConnectorType);
//		waitABit(1000);
//		
//		if(!myEnv.equals("TEST4"))
//		{
//		if(CreateLocationSteps.network_Status.contains("OFF-NET"))
//		{
//		getDriver().findElement(By.xpath("//a[@id='Access Offnet__item']")).click();
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//input[@name='Offnet_UNI_MTU__c']")).sendKeys("1500");;
//		waitABit(2000);
//		}
//		}
//		executor.executeScript("arguments[0].click();", saveButton);
//        waitABit(10000);
//        
        String parent=getDriver().getWindowHandle();
//        
//        getDriver().switchTo().parentFrame();
//        waitABit(2000);
//        getDriver().switchTo().defaultContent();
//        waitABit(2000);
        
        String sdfUrl1= envData.getFieldValue("sdfurl");
        //String sdfUrl1="https://ctl-enterprise--test2.sandbox.my.site.com/ltngOut/SingleDigitalForm?scenarioId=";
        String sdfUrl2="#";
        
//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//		jse.executeScript("window.open('https://www.google.com/','_blank');"); 
//        
//        for (String windowHandle : getDriver().getWindowHandles()) {
//    	    if(!parent.equals(windowHandle)) {
//    	       	getDriver().switchTo().window(windowHandle);
//    	        break;
//    	    }
//    	}
//        
//        getDriver().navigate().to(sdfUrl1+"SM10622495"+sdfUrl2);
//        waitABit(25000);
//        senarioDataPage.waitForTextToAppear("Dedicated Internet Access",95000);
//        WebElement packageId=getDriver().findElement(By.xpath("//th[@data-label='Package ID']//a"));
//        executor.executeScript("arguments[0].click();", packageId);
//		waitABit(4000);
//		WebElement earlyAcceptance=getDriver().findElement(By.xpath("(//input[@name='Early_Acceptance__c']/..//label)[1]"));
//		WebElement expedite=getDriver().findElement(By.xpath("//button[@name='ExpediteType__c']"));
//		executor.executeScript("arguments[0].click();", expedite);
//		waitABit(2000);
//		executor.executeScript("arguments[0].click();", earlyAcceptance);
//		
//		waitABit(2000);
//		WebElement floorAndRoom=getDriver().findElement(By.xpath("//button[@title='Click to select Floor Room Suite']"));
//		executor.executeScript("arguments[0].scrollIntoView(true);", floorAndRoom);
//		waitABit(1000);
//		floorAndRoom.click();
//
//		waitABit(5000);
//		WebElement floorAndRoomText=getDriver().findElement(By.xpath("//input[@name='designators']"));
//		
//		
//		floorAndRoomText.sendKeys("Floor 1 Room TELC");
//		//floorAndRoomText.sendKeys("Floor 5 Room WLAB");
//		waitABit(2000);
//		if(myEnv.equals("TEST4"))
//		{
//		WebElement loa_cfa=getDriver().findElement(By.xpath("//button[@name='LOA_CFA__c']"));
//		//executor.executeScript("arguments[0].scrollIntoView(true);", loa_cfa);
//		waitABit(2000);
//		loa_cfa.click();
//		//executor.executeScript("arguments[0].click();", loa_cfa);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("N");
//		//waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		}
//		
//		WebElement addLocalContact=getDriver().findElement(By.xpath("//span[text()='Add /Edit Location Contact']"));
//		
//		executor.executeScript("arguments[0].scrollIntoView(true);", addLocalContact);
//		waitABit(4000);
//		
//		addLocalContact.click();
//		
//		WebElement addLocalContactButton=getDriver().findElement(By.xpath("//button[@title='Add Contact']"));
//		
//		waitABit(2000);
//		addLocalContactButton.click();
//		
//		WebElement fistName=getDriver().findElement(By.xpath("//input[@name='First_Name__c']"));
//		WebElement lastName=getDriver().findElement(By.xpath("//input[@name='Last_Name__c']"));
//		WebElement email=getDriver().findElement(By.xpath("//input[@name='Email__c']"));
//		WebElement phoneNo=getDriver().findElement(By.xpath("//input[@name='PhoneNumber__c']"));
//		WebElement mobNO=getDriver().findElement(By.xpath("//input[@name='MobilePhoneNumber__c']"));
//		WebElement role=getDriver().findElement(By.xpath("//button[@name='Role__c']"));
//		
//		fistName.sendKeys("Raj114");
//		lastName.sendKeys("Gautam161");
//		email.sendKeys("rajneesh777@gmail.com");
//		phoneNo.sendKeys("2063964608");
//		mobNO.sendKeys("2063964608");
//		role.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		
//		waitABit(1000);
//        getDriver().findElement(By.xpath("//button[@aria-label='Country Code (Phone)']")).click();
//		
//        waitABit(2000);
//		for(int i=1;i<=6;i++)
//		{		
//			getDriver().switchTo().activeElement().sendKeys("U");
//			waitABit(3000);
//			//System.out.println(getDriver().switchTo().activeElement().getText());	  
//		}
//			
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		
//	    getDriver().findElement(By.xpath("//button[@aria-label='Country Code']")).click();
//		
//	    waitABit(2000);
//		for(int i=1;i<=6;i++)
//		{		
//	    	getDriver().switchTo().activeElement().sendKeys("U");
//			waitABit(3000);
//			//System.out.println(getDriver().switchTo().activeElement().getText());	  
//		}
//				
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		
//		WebElement save=getDriver().findElement(By.xpath("//button[@type='submit']"));
//		save.click();
//		waitABit(6000);
//		
//		CreateLocationSteps.network_Status="OFF-NET";
//		if(CreateLocationSteps.network_Status.contains("OFF-NET"))
//		{
//		WebElement addLocalContactButton1=getDriver().findElement(By.xpath("//button[@title='Add Contact']"));
//		addLocalContactButton1.click();
//		waitABit(4000);
//		WebElement fistName1=getDriver().findElement(By.xpath("//input[@name='First_Name__c']"));
//		WebElement lastName1=getDriver().findElement(By.xpath("//input[@name='Last_Name__c']"));
//		WebElement email1=getDriver().findElement(By.xpath("//input[@name='Email__c']"));
//		WebElement phoneNo1=getDriver().findElement(By.xpath("//input[@name='PhoneNumber__c']"));
//		WebElement mobNO1=getDriver().findElement(By.xpath("//input[@name='MobilePhoneNumber__c']"));
//		WebElement role1=getDriver().findElement(By.xpath("//button[@name='Role__c']"));
//		waitABit(2000);
//		
//		fistName1.sendKeys("Raj2");
//		lastName1.sendKeys("Gautam2");
//		email1.sendKeys("rajneesh2@gmail.com");
//		phoneNo1.sendKeys("2063964609");
//		mobNO1.sendKeys("2063964609");
//		role1.click();
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(1000);
		
//		getDriver().findElement(By.xpath("//button[@aria-label='Country Code (Phone)']")).click();
//		
//		for(int i=0;i<=20;i++)
//		{
//			String countrycode= getDriver().switchTo().activeElement().getText();
//			System.out.println("Country code-"+countrycode);
//			
//			if(countrycode.equals("United States +1"))
//			{
//			  System.out.println("found element");
//			  waitABit(700);
//			  getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			  break;
//			  
//			}
//			
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//			waitABit(1000);
//		}
//		
//		waitABit(1000);
//		
//	    getDriver().findElement(By.xpath("//button[@aria-label='Country Code']")).click();
//		
//		for(int i=0;i<=20;i++)
//		{
//			String countrycode= getDriver().switchTo().activeElement().getText();
//			System.out.println("Country code-"+countrycode);
//			
//			if(countrycode.equals("United States +1"))
//			{
//			  System.out.println("found element");
//			  waitABit(700);
//			  getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			  break;	  
//			}
//			
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//			waitABit(1000);
//		}
		
//		WebElement save1=getDriver().findElement(By.xpath("//button[@type='submit']"));
//		save1.click();
//		waitABit(5000);
//		}
//		
//		WebElement closeLocalContactWindow=getDriver().findElement(By.xpath("//button[@title='Close']"));
//		closeLocalContactWindow.click();
//		
//		WebElement save_ValidateButton=getDriver().findElement(By.xpath("//button[@title='Save Validate']"));
//		executor.executeScript("arguments[0].scrollIntoView(true);", save_ValidateButton);
//		waitABit(4000);
//		
//		save_ValidateButton.click();
		
//		waitABit(7000);	  
//		
//		//senarioDataPage.waitForTextToAppear("Details are saved successfully!", 90000);
//		getDriver().switchTo().window(parent);
//		getDriver().navigate().refresh();
//		waitABit(15000);	 
//			
//		WebElement iframe_quote1  = getDriver().findElement(By.xpath("//iframe[@title='accessibility title']"));
//		getDriver().switchTo().frame(iframe_quote1);
//		
//		WebElement iframe_manage_scenario1 = getDriver().findElement(By.xpath("//iframe[@id='quote-iframe'][@name='theIframe']"));
//		getDriver().switchTo().frame(iframe_manage_scenario1);
//		
//		WebElement OptionIcon2=getDriver().findElement(By.xpath("//td[@data-col-key-value='8-action-8']//span//button"));
//		Actions a2=new Actions(getDriver());
//		a2.moveToElement(OptionIcon2).click().build().perform();
//		waitABit(1000);
//		getDriver().findElement(By.xpath("//div[@role='menu']//a/span[text()='Edit']")).click();
//		waitABit(10000);
//		WebElement publishButton2=getDriver().findElement(By.xpath("//button[@title='Publish']"));
//
//		executor.executeScript("arguments[0].scrollIntoView(true);", publishButton2);
//		executor.executeScript("arguments[0].click();", publishButton2);
//		waitABit(10000);
		
	//	getDriver().navigate().to(currentUrl);
		
//		getDriver().findElement(By.xpath("//a[text()='<< Back']")).click();
//		waitABit(10000);
		
		
	}
	}


