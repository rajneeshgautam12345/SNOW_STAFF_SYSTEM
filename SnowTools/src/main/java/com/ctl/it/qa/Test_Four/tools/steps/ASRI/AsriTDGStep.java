//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class AsriTDGStep extends AsriStep {
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	IntDataContainer dataCon = envData.getContainer("AsriLoginPage");
//	private final Logger logger = LoggerFactory.getLogger(AsriTDGStep.class);
//
//	@Step
//	public void flowForTDG() {
//		System.out.println("******** Technical Data gathering function is Started **********");
//		customClickableWait(asriHistoryActivityPage.lnk_TDG);
//		asriHistoryActivityPage.lnk_TDG.click();
//		System.out.println("TDG is clicked");
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("assign button is clicked");
//		waitABit(20000);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		System.out.println("in the outer frame");
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		System.out.println("swicted to inner frame ");
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		System.out.println("dropdown is clicked");
//		customClickableWait(asriTDGPage.lnk_ECV);
//		asriTDGPage.lnk_ECV.click();
//		System.out.println("one value is clicked");
//		waitABit(5000);
//		asriTDGPage.ddl_Protection_Type.click();
//		asriTDGPage.ddl_selectNetwork.click();
//		System.out.println("EVS is done");
//		asriTDGPage.btn_save.click();
//		System.out.println("EVS save is clicked ");
//		customwaitforpageloading();
//		asriTDGPage.selectUni(0).click();
//		System.out.println("clicked on uni1 ");
//		asriTDGPage.ddl_loaRequire.click();
//		asriTDGPage.ddl_selectloaRequire.click();
//		asriTDGPage.ddl_interface.click();
//		asriTDGPage.ddl_Selectinterface.click();
//		asriTDGPage.ddl_UNI_Mode.click();
//		asriTDGPage.ddl_selectUNI_Mode.click();
//		asriTDGPage.ddl_UNI_Connector_Type.click();
//		asriTDGPage.ddl_selectUNI_Connector_Type.click();
//		asriTDGPage.ddl_Redundant_Power_Supply.click();
//		asriTDGPage.ddl_selectRedundant_Power_Supply.click();
//		asriTDGPage.ddl_Power_Type.click();
//		asriTDGPage.ddl_selectPower_Type.click();
//		asriTDGPage.ddl_Customer_CPE_Duplex.click();
//		asriTDGPage.ddl_selectCustomer_CPE_Duplex.click();
//		System.out.println("fill all of uni 1 is done ");
//		asriTDGPage.btn_save.click();
//		System.out.println("uni 1 save is clicked ");
//		customwaitforpageloading();
//		asriTDGPage.selectUni(1).click();
//		System.out.println("uni 2 started");
//		asriTDGPage.ddl_loaRequire.click();
//		asriTDGPage.ddl_selectloaRequire.click();
//		asriTDGPage.ddl_interface.click();
//		asriTDGPage.ddl_Selectinterface.click();
//		asriTDGPage.ddl_UNI_Mode.click();
//		asriTDGPage.ddl_selectUNI_Mode.click();
//		asriTDGPage.ddl_UNI_Connector_Type.click();
//		asriTDGPage.ddl_selectUNI_Connector_Type.click();
//		asriTDGPage.ddl_Redundant_Power_Supply.click();
//		asriTDGPage.ddl_selectRedundant_Power_Supply.click();
//		asriTDGPage.ddl_Power_Type.click();
//		asriTDGPage.ddl_selectPower_Type.click();
//		asriTDGPage.ddl_Customer_CPE_Duplex.click();
//		asriTDGPage.ddl_selectCustomer_CPE_Duplex.click();
//		asriTDGPage.btn_save.click();
//		System.out.println("uni2  save is clicked ");
//		customwaitforpageloading();
//		asriTDGPage.btn_validate.click();
//		customwaitforpageloading();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_complete.click();
//		waitABit(120000);
//		getDriver().switchTo().parentFrame();
//		System.out.println("clicked on complted");
//		System.out.println("After TDG completion inside the 2frame");
//		System.out.println("********* Technical Data gathering function is completed **********");
//	}
//
//	@Step
//	public void flowForTDGIPVPN() {
//		System.out.println("******** Technical Data gathering function is Started **********");
//		commonData.getContainer("Manage Task").getContainer("Technical Data Gathering_IPVPN");
//		waitABit(15000);
//		for (int i = 0; i <= 40; i++) {
//			List<WebElement> allTasks = getDriver()
//					.findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a"));
//			String taskName = allTasks.get(0).getText();
//			System.out.println("Task Name-" + taskName);
//			if (taskName.equals("Technical Data Gathering")) {
//				System.out.println("Technical Data Gathering task kicked off ");
//				break;
//			} else {
//				getDriver().findElement(By.xpath("//div[@data-uxf-point='projects']//div[@class='refreshButtonIcon']"))
//						.click();
//				waitABit(5000);
//				System.out.println("ASRI refresh icon clicked");
//			}
//		}
//		customClickableWait(asriHistoryActivityPage.lnk_TDG);
//		asriHistoryActivityPage.lnk_TDG.click();
//		System.out.println("TDG is clicked");
//		waitABit(5000);
//		String assignedValue = getDriver().findElement(By.xpath("//div[@data-uxf-point='usid']/div"))
//				.getAttribute("title");
//		System.out.println("Assigned Value--" + assignedValue);
//		String cuid = dataCon.getFieldValue("tbx_username");
//		if (!cuid.equals(assignedValue)) {
//			getDriver().findElement(By.xpath("//div[@class='assignToMeButton button']")).click();
//			waitABit(5000);
//		} else {
//			System.out.println("Already assigned to the current user");
//			getDriver().findElement(By.xpath("//div[@class='statusTitle']")).click();
//		}
//		String assignValueCheck = getDriver().findElement(By.xpath("//div[@data-uxf-point='assignToMeButton']"))
//				.getAttribute("class");
//		System.out.println("Assigned Value Check--" + assignValueCheck);
//		if (!assignValueCheck.equals("assignToMeButton disabled")) {
//			getDriver().findElement(By.xpath("//div[@data-uxf-point='assignToMeButton']")).click();
//		}
////		customClickableWait(asriTDGPage.btn_assign);
////		asriTDGPage.btn_assign.click();
////		System.out.println("assign button is clicked");
//		waitABit(20000);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		System.out.println("in the outer frame");
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		System.out.println("swicted to inner frame ");
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		System.out.println("dropdown is clicked");
//		customClickableWait(asriTDGPage.port);
//		asriTDGPage.port.click();
//		Select s1 = new Select(asriTDGPage.ddl_loaRequire);
//		s1.selectByValue("No");
//		waitABit(1000);
//		Select s2 = new Select(asriTDGPage.ddl_interface);
//		s2.selectByValue("Fiber");
//		waitABit(1000);
//		Select s3 = new Select(asriTDGPage.ddl_UNI_Mode);
//		s3.selectByValue("SM");
//		Select s4 = new Select(asriTDGPage.ddl_UNI_Connector_Type);
//		s4.selectByValue("SC");
//		Select s5 = new Select(asriTDGPage.ddl_Redundant_Power_Supply);
//		s5.selectByValue("No");
//		waitABit(1000);
//		Select s6 = new Select(asriTDGPage.ddl_Power_Type);
//		s6.selectByValue("AC");
//		waitABit(1000);
//		Select s7 = new Select(asriTDGPage.ddl_Customer_CPE_Duplex);
//		s7.selectByValue("Hard-coded Full");
//		waitABit(1000);
//		Select s8 = new Select(asriTDGPage.taggingType);
//		s8.selectByValue("Untagged");
//		waitABit(1000);
//		asriTDGPage.btn_save.click();
//		waitForASRIProgressBar();
//		waitABit(1000);
//		customClickableWait(asriTDGPage.ipvpn);
//		asriTDGPage.ipvpn.click();
//		waitABit(1000);
//		Select s21 = new Select(asriTDGPage.custAssignWANIPs);
//		s21.selectByValue("No");
//		waitABit(1000);
////		asriTDGPage.custAssignCTLIPs.clear();
////		asriTDGPage.custAssignCTLIPs.sendKeys("127.0.0.1");
////		waitABit(1000);
////		asriTDGPage.custAssignIPs.clear();
////		asriTDGPage.custAssignIPs.sendKeys("127.0.0.2");
////		waitABit(1000);
////		Select s22=new Select(asriTDGPage.SubnetLengthAndSubnetMask);
////		s22.selectByValue("/30@255.255.255.252");
////		waitABit(1000);
//		Select s23 = new Select(asriTDGPage.wanRoutingProtocol);
//		s23.selectByValue("BGP");
//		waitABit(1000);
//		asriTDGPage.uniqueCustASN.clear();
//		asriTDGPage.uniqueCustASN.sendKeys("65748");
////		Select s24=new Select(asriTDGPage.uniqueCustASN);
////		s24.selectByValue("65748");
//		waitABit(1000);
//		Select s25 = new Select(asriTDGPage.ipv4ConfigureFor);
//		s25.selectByValue("This and all other locations");
//		waitABit(1000);
//		Select s26 = new Select(asriTDGPage.authenticationReq);
//		s26.selectByValue("No");
//		waitABit(1000);
//		Select s27 = new Select(asriTDGPage.ipv4AssignBy);
//		s27.selectByValue("CenturyLink");
//		waitABit(1000);
//		Select s28 = new Select(asriTDGPage.ipv4BFDTimerOn);
//		s28.selectByValue("No");
//		waitABit(1000);
//		Select s29 = new Select(asriTDGPage.multicast);
//		s29.selectByValue("No");
//		waitABit(1000);
//		Select s30 = new Select(asriTDGPage.noOfLLQueues);
//		s30.selectByValue("1");
//		waitABit(1000);
//		Select s31 = new Select(asriTDGPage.mcosSchedulerPolicyTemplate);
//		s31.selectByValue("COS_L3_EH_P1_10_10_10_45_25");
//		waitABit(1000);
//		Select s32 = new Select(asriTDGPage.premiumPlusPremiumPIR);
//		s32.selectByValue("6M");
//		waitABit(1000);
//		Select s33 = new Select(asriTDGPage.premiumPlusPremiumCIR);
//		s33.selectByValue("6M");
//		waitABit(1000);
//		Select s34 = new Select(asriTDGPage.customPolicing);
//		s34.selectByValue("No");
//		waitABit(1000);
//		Select s35 = new Select(asriTDGPage.premiumPlusPremiumPolicer);
//		s35.selectByValue("Shared");
//		waitABit(1000);
//		Select s36 = new Select(asriTDGPage.classOfServiceTrustMark);
//		s36.selectByValue("Trust");
//		waitABit(1000);
//		Select s37 = new Select(asriTDGPage.cosAllocation);
//		s37.selectByValue("Multi");
//		waitABit(1000);
//		Select s38 = new Select(asriTDGPage.ottVoiceCompleteReq);
//		s38.selectByValue("No");
//		Select s39 = new Select(asriTDGPage.ottANSReq);
//		s39.selectByValue("No");
//		Select s40 = new Select(asriTDGPage.ottSDWANReq);
//		s40.selectByValue("No");
//		Select s41 = new Select(asriTDGPage.ottDynamicConnReq);
//		s41.selectByValue("No");
//		asriTDGPage.btn_save.click();
//		System.out.println("IPVPN save is clicked ");
//		waitForASRIProgressBar();
//		waitABit(1000);
//		asriTDGPage.btn_validate.click();
//		waitForASRIProgressBar();
//		waitABit(1000);
//		getDriver().findElement(By.xpath("//*[@id='validationSuccess']")).isDisplayed();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_complete.click();
//		waitABit(5000);
//		waitForASRIProgressBar();
//		waitABit(2000);
//		getDriver().switchTo().parentFrame();
//		System.out.println("clicked on complted");
//		System.out.println("After TDG completion inside the 2frame");
//		System.out.println("********* Technical Data gathering function is completed **********");
//	}
//
//	@Step
//	public void flowForTDG_REDDIA_Monarch_SAO(String workflow) {
//		logger.info("******** Technical Data gathering function is Started **********");
//		IntDataContainer dataContainer = commonData.getContainer("Manage Task")
//				.getContainer("Technical Data Gathering_REDDIA");
//		waitABit(2000);
//		System.out.println(getDriver().findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a")).size());
//		while (getDriver().findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a")).size() == 0) {
//			waitABit(2000);
//			logger.info("Waiting for tasks to populate");
//		}
//		for (int i = 0; i <= 90; i++) {
//			List<WebElement> allTasks = getDriver()
//					.findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a"));
//			String taskName = allTasks.get(0).getText();
//			if (taskName.equals("Technical Data Gathering")) {
//				logger.info("Technical Data Gathering task kicked off ");
//				break;
//			} else {
//				getDriver().findElement(By.xpath("//div[@data-uxf-point='projects']//div[@class='refreshButtonIcon']"))
//						.click();
//				waitABit(6000);
//				logger.info("ASRI refresh icon clicked");
//			}
//		}
//		customClickableWait(asriHistoryActivityPage.lnk_TDG);
//		asriHistoryActivityPage.lnk_TDG.click();
//		logger.info("TDG is clicked");
//		try {
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(8));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='statusTitle']")));
//			getDriver().findElement(By.xpath("//div[@class='statusTitle']")).click();
//		} catch (TimeoutException e) {
//			logger.info("Success");
//		}
//		customClickableWait(asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		logger.info("assign button is clicked");
//		waitABit(5000);
//		waitForASRIProgressBar();
//		waitABit(2000);
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_gtframe);
//		logger.info("in the outer frame");
//		getDriver().switchTo().frame(asriHistoryActivityPage.frame_customIframe);
//		logger.info("swicted to inner frame ");
//		customClickableWait(asriTDGPage.ddl_Eline);
//		asriTDGPage.ddl_Eline.click();
//		logger.info("dropdown is clicked");
//		customClickableWait(asriTDGPage.port);
//		asriTDGPage.port.click();
//		Select s1 = new Select(asriTDGPage.ddl_loaRequire);
//		// s1.selectByValue("No");
//		s1.selectByValue(dataContainer.getFieldValue("sel_LOARequired"));
//		waitABit(1000);
//		Select s2 = new Select(asriTDGPage.ddl_interface);
//		s2.selectByValue("Fiber");
//		waitABit(1000);
//		Select s3 = new Select(asriTDGPage.ddl_UNI_Mode);
//		s3.selectByValue("MM");
//		waitABit(1000);
//		Select s4 = new Select(asriTDGPage.ddl_UNI_Connector_Type);
//		s4.selectByValue("SC");
//		waitABit(1000);
//		Select s5 = new Select(asriTDGPage.ddl_Redundant_Power_Supply);
//		s5.selectByValue("No");
//		waitABit(1000);
//		Select s6 = new Select(asriTDGPage.ddl_Power_Type);
//		s6.selectByValue("AC");
//		waitABit(1000);
//		Select s7 = new Select(asriTDGPage.ddl_Customer_CPE_Duplex);
//		s7.selectByValue("Hard-coded Full");
//		waitABit(1000);
//		Select s8 = new Select(asriTDGPage.taggingType);
//		s8.selectByValue("Untagged");
//		waitABit(1000);
//		if (workflow.equals("SAO")) {
//			asriTDGPage.diverseForm.sendKeys("Testing123");
//			waitABit(1000);
//		}
//		asriTDGPage.btn_save.click();
//		waitForASRIProgressBar();
//		// waitABit(2000);
//		customClickableWait(asriTDGPage.internetAccess);
//		asriTDGPage.internetAccess.click();
//		Select s9 = new Select(asriTDGPage.wanIPVersion);
//		s9.selectByValue("IPv4 Public");
//		waitABit(1000);
//		Select s10 = new Select(asriTDGPage.wanIPBlockToAssign);
//		s10.selectByValue("/29@255.255.255.248");
//		waitABit(1000);
//		Select s11 = new Select(asriTDGPage.wanRoutingProtocol);
//		s11.selectByValue("Static");
//		waitABit(1000);
//		asriTDGPage.btn_save.click();
//		waitForASRIProgressBar();
//		waitABit(2000);
//		asriTDGPage.btn_validate.click();
//		waitForASRIProgressBar();
//		waitABit(2000);
//		getDriver().findElement(By.xpath("//*[@id='validationSuccess']")).isDisplayed();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_complete.click();
//		waitABit(5000);
//		waitForASRIProgressBar();
//		waitABit(5000);
//		getDriver().switchTo().parentFrame();
//		logger.info("clicked on complted");
//		logger.info("After TDG completion inside the 2frame");
//		logger.info("********* Technical Data gathering function is completed **********");
//	}
//
//	@Step
//	public void TDGValidation() {
//		waitABit(20000);
//		List<WebElement> allTasks = getDriver().findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a"));
//		String taskName = allTasks.get(0).getText();
//		logger.info("Task Name-" + taskName);
//		if (taskName.contains("Create Note – TDG Complete")) {
//			logger.info("Technical Data Gathering task Completed Successfully");
//		}
////		Assert.assertEquals(" Validate status of TDG", true,
////				asriHistoryActivityPage.lbl_TDGComplete.containsText("Complete"));
//	}
//
//	public Boolean waitForASRIProgressBar() {
//		Boolean bflag;
//		bflag = false;
//		try {
//			System.out.println("in try for  waitForASRIProgressBar");
//			int ncounter;
//			ncounter = 0;
//			do {
//				// waitABit(5000);
//				if (asriTDGPage.isElementVisible(By.xpath("//button[@class='btn btn-primary']"))) {
//					System.out.println("Loading progress bar is dispayed");
//					ncounter = ncounter + 1;
//					waitABit(2000);
//				} else {
//					System.out.println("All good");
//					bflag = true;
//				}
//			} while (bflag != true);
//			System.out.println("out of try for  waitForASRIProgressBar");
//			System.out.println("Loading progress bar  counter is " + ncounter);
//			bflag = false;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return bflag;
//	}
//
//	public Boolean waitForASRIProgressBar1() {
//		Boolean bflag;
//		bflag = false;
//		try {
//			System.out.println("in try for  waitForASRIProgressBar");
//			int ncounter;
//			ncounter = 0;
//			do {
//				// waitABit(1000);
//				try {
//					WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//					wait.until(ExpectedConditions
//							.invisibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
//					System.out.println("All good");
//					bflag = true;
//				} catch (TimeoutException e) {
//					System.out.println("Loading progress bar is dispayed");
//					ncounter = ncounter + 1;
//					waitABit(3000);
//				}
//			} while (bflag != true);
//			System.out.println("out of try for  waitForASRIProgressBar");
//			System.out.println("Loading progress bar  counter is " + ncounter);
//			bflag = false;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return bflag;
//	}
//
//	@Step
//	public void waitForPONRTask() {
//		waitABit(5000);
//		int counter = 0;
//		for (int i = 1; i <= 150; i++) {
//			List<WebElement> allTasks = getDriver()
//					.findElements(By.xpath("//div[@class='activitiesOverdue']//tr/td[1]/a"));
//			String taskName = allTasks.get(0).getText();
//			logger.info("Task Name-" + taskName);
//			if (taskName.equals("Order PONR Reached")) {
//				logger.info("Order PONR Reached task kicked Off");
//				break;
//			} else {
//				getDriver().findElement(By.xpath("//div[@data-uxf-point='projects']//div[@class='refreshButtonIcon']"))
//						.click();
//				waitABit(5000);
//				System.out.println("Counter Value-" + counter + "ASRI refresh icon clicked");
//				counter = counter + 1;
//			}
//		}
//	}
//}
