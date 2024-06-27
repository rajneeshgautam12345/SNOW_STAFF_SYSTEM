package com.ctl.it.qa.Test_Four.tools.steps.Swift;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class Script_Builder_SwiftSteps extends E2ESteps {
	public static String myOpid = null;
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	public Boolean waitForSwiftProgressBar() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(5000);
				if (productPage.isElementVisible(By.xpath("//*[@id='ajax-spinner']/div/div[1]"))) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(3000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	@SuppressWarnings("deprecation")
	public void Log_in_Swift_ScriptBuilder_get_order(String nBoid) {
		// tasknum is being used to send in name of the product
		int myCounter;
		int pkgCounter;
		Boolean myflag;
		myflag = false;
		String nSwiftID = nBoid; // this is BOID
		String myProductType = "Wavelength";
		String myEnv = System.getProperty("staf.environment.key");
		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
		swiftPage.maximize();
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
		waitABit(2000);
		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
		waitABit(2000); // leave this for timing issue returning the impersonate row
		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
		swiftPage.searchBtn.click(); // click the search button
		waitABit(10000);
		String url1 = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url1);
		String sOpid = url1.toString();
		myOpid = url1.substring(30, 39);
		System.out.println("the Order package id is " + myOpid);
		waitABit(10);
//	myflag=false; 
//	myCounter=0;
//	pkgCounter=0;
//	String sholder="";
//     do{
//    	try {   		
//    		sholder = senarioDataPage.find(By.xpath("//*[@id='orderPackagesGrid']/div[2]/div[1]/div")).getTextValue(); 
//    		System.out.println("waiting 10 sec for first row showed going to check and push search again "); // write the swift first row to show 
//    		if (sholder.contains("No records available.")) {
//    			swiftPage.searchBtn.click(); // click the search button
//    			System.out.println("Swift search button pushed again"); // write the swift search button pushed 
//    			waitABit(10000);
//    			getDriver().navigate().refresh(); //refresh the page
//    			waitABit(5000);
//    			myflag=false;
//    			myCounter= myCounter + 1;
//    			System.out.println("Record counter is " + myCounter);
//    			if (myCounter==300) {
//    				System.out.println("FAILED no record showed up");
//    				 getDriver().close();
//    				 getDriver().quit();
//    				myflag=true;
//    				
//    			}
//    		}
//    		else {
//    			System.out.println("no records returned");
//
//    			myflag=true;
//    		}
//    	}
//    	catch(Exception e) {
//    		 System.out.println(e);
//   			 myflag=true;
//   		 }
//
//     }while(myflag !=true);
//     waitABit(100);
//     if(myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")||(myProductType.contains("IP VPN Port and Access"))) {
//    	 
//    	swiftPage.withTimeoutOf(600, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@id='orderPackagesGrid']/div[2]/table/tbody/tr[1]/td[1]")); // wait for first row to show 
//     }else {
//	    	
//	     swiftPage.withTimeoutOf(600, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for first row to show 
//	 }
//    
//    	System.out.println(" first row showed "); // write the swift first row to show 
//    	System.out.println("records returned");
//		System.out.println("out of senerio manager and all the timing");
//		
//		
//		if(myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")||(myProductType.contains("IP VPN Port and Access"))) {
//			swiftPage.lnk_first_order.click();  // click on the first task
//			swiftPage.waitForTextToAppear("Tasks", 30000); 
//			getDriver().navigate().refresh(); 
//			swiftPage.withTimeoutOf(600, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for first row to show
//    	for(int i=0; i<2; i++) {
//    		if(i==1) {
//				 swiftPage.lnk_second_order.click();
//				 swiftPage.waitForTextToAppear("Tasks", 30000); 
//			 }
//    		 if(myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")){
//				 if(i==2) {
//					 swiftPage.lnk_third_order.click();
//					 swiftPage.waitForTextToAppear("Tasks", 30000); 
//				 }
//				 else {
//					 break;
//				 }
//			 }
//    		swiftPage.waitForTextToAppear("Ready", 20000); // Wait for Upload;
//			 String myName =swiftPage.txt_assignee_name.getText(); //get the name to  impersonate
//			 System.out.println("myName is " + myName);
//			 swiftPage.lbl_user_info.click(); //open impersonate box
//			 waitABit(5000);
//			 swiftPage.txt_user_info.type("");
//			 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			 getDriver().switchTo().activeElement().sendKeys(myName);
//			 waitABit(2000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// 
//			 waitABit(2000);
//			 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			 waitABit(2000);
//			 try {
//				 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//				 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//				 swiftPage.btn_oes_order_pick.click(); //cause oes list to open
//				 waitABit(2000);
//				 swiftPage.lst_oes_order_pick.click(); // using click because object is described in page as list box pick 
//				 waitABit(2000);
//				 swiftPage.btn_completeTask.click(); //press the complete button.
//				 myflag = waitForSwiftProgressBar();
//				 if (myflag) {
//				 System.out.println("error in waitForSwiftProgressBar");
//				 }
//
//				 swiftPage.searchBtn.click(); // click the search button
//				
//			 }
//			 catch(Exception e) {
//			  System.out.println(e);
//			
//			 }
//		
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 
//    	}
//		}else {	
//			 String myName =swiftPage.txt_assignee_name.getText(); //get the name to  impersonate
//			 System.out.println("myName is " + myName);
//			 swiftPage.lbl_user_info.click(); //open impersonate box
//			 waitABit(5000);
//			 swiftPage.txt_user_info.type("");
//			 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			 getDriver().switchTo().activeElement().sendKeys(myName);
//			 waitABit(2000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// ded network type
//			 waitABit(2000);
//			 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 waitABit(2000);
//			 try {
//			 swiftPage.btn_oes_order_pick.click(); //cause oes list to open
//			 waitABit(2000);
//			 swiftPage.lst_oes_order_pick.click(); // using click because object is described in page as list box pick 2
//			 swiftPage.btn_completeTask.click(); //press the complete button.
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//			 }
//
//			 swiftPage.searchBtn.click(); // click the search button
//			 }
//			 catch(Exception e) {
//			  System.out.println(e);
//			
//			 }
//			
//	}	
//		
	}

// @Step
// public void user_Gathers_Order_Details(){ 
//
//	String myName;
////	String myProductType = System.getProperty("myProduct.ID");
////	String SIDID=System.getProperty("SID.ID"); 	
//	 //JavascriptExecutor executor = (JavascriptExecutor)getDriver(); 
//
//		
//	for (int i = 0; i < 100; i++) {
//		
//		waitABit(5000);
//		String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
//		System.out.println("Update Task Status : "+UpdatedTask);
//		
//		if (UpdatedTask.contains("1 - 2 of 2 items")) {
//			System.out.println("2nd Task Generated");
//			waitABit(2000);
//			break;
//			
//		} else {
//			
//			waitABit(10000);
//			getDriver().navigate().refresh();
//			WaitForPageToLoad(60);
//			System.out.println("2nd Task Not Generated, Retrying");
//		}
//	
//	}// ends for
//	String SecondTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
//	
//	System.out.println("Second Task Status : "+SecondTask);
//	
//	if (SecondTask.contains("Ready")) {
//			
//		System.out.println("Second Task is Ready to be Validated");
//	}
//	 myName = getDriver().findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]/td[5]/span")).getText();
//	 swiftPage.lbl_user_info.click(); //open impersonate box
//	 waitABit(5000);
//	 swiftPage.txt_user_info.type("");
//	 waitABit(1000);
//	 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//	 getDriver().switchTo().activeElement().sendKeys(myName);
//	 waitABit(2000);
//	 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// 
//	 waitABit(2000);
//	 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//	 
//}
// @Step
// public void add_iSE_Document(){ 
//	 swiftPage.lnk_doc.click(); // click on the doc link
//	swiftPage.lbl_ise_design.click(); // click on the ise design link 
//	swiftPage.btn_design_edit.click();
//	swiftPage.lst_doc_type.click();
//	getDriver().switchTo().activeElement().sendKeys("iSE");
//	getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);// 
//	swiftPage.btn_save_doctype.waitUntilEnabled();
//	swiftPage.btn_save_doctype.click();
//	waitABit(5000);
//	 getDriver().navigate().refresh(); //refresh the page
//	waitABit(5000);
// }
// 
	@Step
	public void press_complete_Swift_Task() {
		Boolean myflag;
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		System.out.println("This is done press_complete_Swift_Task"); // write the Swift Impersonate row is set
		System.out.println("out of swift and all the timing");
	}

// // written by eric steele
// @Step
// public void Launch_SEO() {
//	JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//	String order = "";
//	swiftPage.openAt(envData.getFieldValue("SEOurl")); 
//	swiftPage.btn_watch_list.click(); // click sort watch list
//	waitABit (2000);
//
//	String win1 = getDriver().getWindowHandle();
//	System.out.println(win1);
//
//	swiftPage.lst_sort.click();
//	waitABit (1000);
//	swiftPage.lst_sort.click();
//	waitABit (1000);
//
//	for(int i=0;i<=100;i++){
//		WebElement my_order = (WebElement) jse.executeScript("return document.querySelector(\'#ctl00_phMainContent_WatchListPart_AlertListPart_ctl00__"+i+" > td:nth-child(2)\')"); 
//		order = my_order.getText();
//   		System.out.println(order);
//   		if (order.contains("SwIFT-"+myOpid+"-OP_Credit_Check")) {
//	   		System.out.println("Found it!");
//	   		my_order.click();
//   			break;
//		} 
//	}
//	
//	
//	waitABit (10000);
//	Set<String> win2 = getDriver().getWindowHandles();
//	System.out.println(win2);
//    Iterator<String> i1=win2.iterator();
//    while(i1.hasNext())			
//    {		
//        String ChildWindow=i1.next();		
//        		
//        if(!win1.equalsIgnoreCase(ChildWindow))			
//        {    		
//                // Switching to Child windows
//        	    getDriver().switchTo().window(ChildWindow);	                                                                                                           
//        	    swiftPage.complete_credit_task.click(); //this might need case statements if we do more than one task
//        		waitABit (10000);
//        		Set<String> win3 = getDriver().getWindowHandles();
//                win3.remove(win1);
//                win3.remove(ChildWindow);
//        		System.out.println(win3);
//        		String rc =  win3.toString();  
//        		String rcc = rc.substring(1, 42);
//        		System.out.println(rcc);
//           		getDriver().switchTo().window(rcc);	                                                                                                           
//        		waitABit (5000);
//        		swiftPage.btn_close_wait.click();
//           		getDriver().switchTo().window(win1);	                                                                                                           
//           		swiftPage.openAt(envData.getFieldValue("swifturl")); // go back to swift
//        }		
//    }		
// }
// 
	WebDriver driver;

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

//@Step
//public void overide_completes_WelcomeCustomer(String sExpStatus, String sExpTask){ 
//	Boolean myflag;
////	String myName;
////	String myProductType = System.getProperty("myProduct.ID");
////	String SIDID=System.getProperty("SID.ID");
////	JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//	 
//	 swiftPage.lbl_user_info.click(); //open impersonate box
//	 waitABit(5000);
//	 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//	 myflag = waitForSwiftProgressBar();
//	 if (myflag) {
//	 System.out.println("error in waitForSwiftProgressBar");
//	 }
//	 find_status_taskName(sExpStatus,sExpTask);  // go to function to find the welcome task
//	 swiftPage.btn_completeTask.click(); //press the complete button.
//	 myflag = waitForSwiftProgressBar();
//	 if (myflag) {
//	 System.out.println("error in waitForSwiftProgressBar");
//	 }
//	
// }
//@Step
//public void completes_Order_Validation(String sExpStatus, String sExpTask){ 
//	Boolean myflag;
//	 find_status_taskName(sExpStatus,sExpTask);  // go to function to find the welcome task
//	 
//	 swiftPage.btn_TDG_form.waitUntilEnabled();
//	 swiftPage.btn_TDG_form.click();
//	 
//	 myflag = waitForSwiftProgressBar();
//	 if (myflag) {
//		 System.out.println("error in waitForSwiftProgressBar");
//	}
//	
//
//	 // It will return the parent window name as a String
//	 String parent=getDriver().getWindowHandle();
//	
//	 // This will return the number of windows opened by Webdriver and will return Set of St//rings
//	 Set<String>s1=getDriver().getWindowHandles();
//	
//	 // Now we will iterate using Iterator
//	 Iterator<String> I1= s1.iterator();
//	
//	 while(I1.hasNext()) {
//	
//	    String child_window=I1.next();
//		 if(!parent.equals(child_window))
//		 {
//		 getDriver().switchTo().window(child_window);
//		
//		 System.out.println(getDriver().switchTo().window(child_window).getTitle());
//		 swiftPage.btn_TDG_form_edit.click(); // click on edit button for TDG form
//		 myflag = waitForSwiftProgressBar();
//		 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//		}
//		 waitABit(10000);
//		 swiftPage.btn_TDG_form_save.click(); // click on edit button for TDG form
//		 myflag = waitForSwiftProgressBar();
//		 if (myflag) {
//			 System.out.println("error in waitForSwiftProgressBar");
//		}
//		 getDriver().switchTo().window(child_window).close();
//		 }
//	
//	 }
//	 // once all pop up closed now switch to parent window
//	 	 getDriver().switchTo().window(parent);
//	  
//	 swiftPage.btn_completeTask.click(); //press the complete button.
//	 myflag = waitForSwiftProgressBar();
//	 if (myflag) {
//	 System.out.println("error in waitForSwiftProgressBar");
//	 }
//	
// }
	public void find_status_taskName(String sExpStatus, String sExpTask) {
		WebElement taskRow;
		Boolean myflag;
		String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
		if (UpdatedTask.contains("1 - 4 of 4 items")) {
			waitABit(2000);
		} else {
			waitABit(30000);
			getDriver().navigate().refresh();
		}
		System.out.println("3rd & 4th Task Generated");
		// waitForSwiftProgressBar();
		System.out.println("Update Task Status : " + UpdatedTask);
		String numofTask = UpdatedTask.substring(4, 5);
		System.out.println("number of Tasks are: " + numofTask);
		int myTask = Integer.parseInt(numofTask);
		System.out.println("number of Tasks are: " + myTask);
		for (int i = 2; i <= (myTask + 1);) {
			System.out.println("the number i is: " + i);
			String myStatus = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[4]/span"))
					.getText();
			String myTaskName = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"))
					.getText();
			System.out.println("the status is : " + myStatus);
			System.out.println("the task is : " + myTaskName);
			if (sExpStatus.equalsIgnoreCase(myStatus) && sExpTask.equalsIgnoreCase(myTaskName)) {
				taskRow = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"));
				taskRow.click();
				// switch (sExpTask) {
				if (sExpTask.equals("Welcome Customer")) {
					// case "Welcome Customer":
					Actions act = new Actions(getDriver());
					act.contextClick(taskRow).perform();
					waitABit(1000);
					WebElement override;
					override = getDriver()
							.findElement(By.xpath("//*[starts-with(@ng-show,'TaskIRRules.CanOverridePending')]"));
					override.click();
					// break;
				} else {
					// default:
					System.out.println("this task does not require over ride " + sExpTask);
				}
				WebElement taskRow1 = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[5]/span"));
				String myName = taskRow1.getText(); // get the name to impersonate
				System.out.println("myName is " + myName);
				swiftPage.lbl_user_info.click(); // open impersonate box
				waitABit(5000);
				swiftPage.txt_user_info.type("");
				getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
				getDriver().switchTo().activeElement().sendKeys(myName);
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
				waitABit(2000);
				swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
			}
			i = i + 1;
			waitABit(1);
		}
	}
}
//@Step
//public void Completes_Customer_Coordination_single_Task(String sExpStatus, String sExpTask){ 
//	Boolean myflag;
//	String SIDID=System.getProperty("SID.ID");
//	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
//	 Calendar cal = Calendar.getInstance();
//	 cal.setTime(new Date());
//	 cal.add(Calendar.DATE, 3);
//	 String newDate = dateFormat.format(cal.getTime());    	
//	 JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//
//	 find_status_taskName(sExpStatus,sExpTask); 
////	 WebElement elementCustCoord = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]"));  // click  on welcome task
////	 waitABit(2000);
////	 elementCustCoord.click();
////	 waitABit(2000);
//	 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//	 swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
//	 swiftPage.btn_productPackagesTab.click(); // click on the product package tab
//	 WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
//	 JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
//	 jse1.executeScript("arguments[0].click()", element1); // check the select all check box
//	 swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
//	 swiftPage.btn_editDatesBtn.click(); //edit dates
//	 //swiftPage.txt_NewNddDatePicker.waitUntilEnabled();// set date NDD
//	// swiftPage.txt_NewNddDatePicker.type(newDate); //set dates NDD
//	 swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
//	 swiftPage.txt_CurrentCrdDatePicker.type(newDate); //set dates txt_Current Date
//	 swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
//	 swiftPage.btn_EditDateDialogOkBtn.click(); //save dates
//	 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//	 waitABit(2000);
//	 swiftPage.btn_completeTask.waitUntilEnabled(); 
//	 swiftPage.btn_completeTask.click(); //press the complete button.
//		 myflag = waitForSwiftProgressBar();
//		 if (myflag) {
//		 	System.out.println("error in waitForSwiftProgressBar");
//		 }
//	 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//	 getDriver().navigate().refresh(); //refresh the page
//	System.out.println("out of user_completes_Customer_Coordination");
//		 
//	 
//	}
//}  
// 
// ###########################################################################
// @Step
// public void Verify_Swift_order_success()  {
//	int myCounter;
//	Boolean myflag;  
//	myflag = false;	
//	 
//	 // look for the order to be completed. 
//	 try {
//		 swiftPage.tab_orderDetailsTab.waitUntilEnabled();// click on ordering tab
//		 swiftPage.tab_orderDetailsTab.click();// click on ordering tab
//		 System.out.println("had to press order Details tab to open"); // end of row 3
//    }
//	catch(Exception e) {
//		  System.out.println(e);
//	}// end of catch
//	  myflag=false; 
//	  myCounter=0;
//     do{
//            String checkOrder = swiftPage.lbl_OrderPackageStatusLbl.getTextValue();
//           if (checkOrder.equals("InProgress")) {
//                  getDriver().navigate().refresh(); 
//                  myflag=false;
//                  myCounter= myCounter + 1;
//                  if (myCounter==50) {
//	            	   System.out.println("FAILED Order ready did NOT show up");
//	            	   myflag=true;
//					
//				}
//           }
//           else {
//                  if (checkOrder.equals("Ordered") || checkOrder.equals("Approved")) {
//                         System.out.println("Order is ready");
//                         myflag=true;
//                  }
//           }
//          
//
// }while(myflag !=true);
//
// }
// 
// @Step
// public void user_adds_PSP_order(){
//	Boolean myflag;  
//	String SIDID=System.getProperty("SID.ID");
//	String endUserClli=null;
//	 JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//	 for (int i = 0; i < 2; i++) {
//		 if(i==0) {
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 swiftPage.lnk_first_order.waitUntilEnabled();
//			 swiftPage.lnk_first_order.click();
//			 swiftPage.waitForTextToAppear("Tasks", 30000); 
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);//  move down 
//			 swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
//			 swiftPage.btn_productPackagesTab.click(); // click on the product package tab
//			 swiftPage.lnk_service_address.waitUntilEnabled(); // click on service addres
//			 swiftPage.lnk_service_address.click(); // click on service address
//			 endUserClli=swiftPage.txt_enduserclli.getText(); // get end user clli
//			 System.out.println("End user Clli is:  "+endUserClli);
//			 waitABit(2000);
//			 swiftPage.btn_serviceaddressClose.waitUntilEnabled(); // close service location window
//			 swiftPage.btn_serviceaddressClose.click(); // close service location window
//			 swiftPage.btn_addPspBtn.click(); // click on the PSP Button 
//			 swiftPage.txt_searchClliCriteriaTextBox.type(endUserClli); // add the clli to text box
//			 getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//			 swiftPage.btn_location_search_button.waitUntilEnabled(); // click on search button
//			 swiftPage.btn_location_search_button.click(); // click on search button
//			 waitABit(5000);
//			 swiftPage.img_filtercheckbox.click();// check the filter drop down image
//			 swiftPage.img_filter.click();// check the filter drop down image
//			 swiftPage.txt_filterinput.type(endUserClli); // search for the cilli
//			 swiftPage.btn_filtersearch.click();  // press the search button
//			 waitABit(5000);
//	
//			 WebElement loc_element = getDriver().findElement(By.xpath("//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr/td[2]/span"));
//			 String myLocation =loc_element.getText();
//			 System.out.println("Location is : "+myLocation);
//			 WebElement cbxClli_element = getDriver().findElement(By.name(myLocation));
//		 	 //waitABit(3000);
//		 	 executor.executeScript("arguments[0].click();",cbxClli_element);  // check the clli check box
//		 	 waitABit(2000);
//			 swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
//			 swiftPage.btn_pspNext.click();// click the next button
//			 swiftPage.waitForTextToAppear("Products", 30000); 
//			 swiftPage.btn_addnewpsp.waitUntilEnabled();  //click on new product package button
//			 swiftPage.btn_addnewpsp.click();  //click on new product package button
//			 swiftPage.ddl_pspproduct.waitUntilEnabled(); // the product drop down
//			 swiftPage.ddl_pspproduct.click(); // the product drop down
//			 getDriver().switchTo().activeElement().sendKeys("VRF ID");// pick product
//			 getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			 waitABit(2000);
//			 swiftPage.ddl_pspaddress.waitUntilEnabled();// get the address loaded
//			 swiftPage.ddl_pspaddress.click();// get the address loaded
//			 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//			 waitABit(2000);
//			 swiftPage.btn_pspprproductNext.waitUntilEnabled();// click the next button
//			 swiftPage.btn_pspprproductNext.click();// click the next button
//			 
//			 JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
//	   		 jse1.executeScript("arguments[0].click()", swiftPage.btn_productPackagesTab);
//			// swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
//			 //swiftPage.btn_productPackagesTab.click(); // click on the product package tab
//			 waitABit(2000);
//			 
//			 swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
//			 swiftPage.btn_pspNext.click();// click the next button
//			 swiftPage.btn_pspprproducSave.waitUntilEnabled();// click the save button
//			 swiftPage.btn_pspprproducSave.click();// click the save button
//			 waitABit(2000);	 
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//				 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//		
//			 swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
//			 swiftPage.btn_productPackagesTab.click(); // click on the product package tab
//			 getDriver().switchTo().activeElement().sendKeys(Keys.DOWN);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 System.out.println("above the vfr task: ");
//		   	 swiftPage.arr_vrfid.waitUntilEnabled(); // open the vrf id task
//		   	 swiftPage.arr_vrfid.click(); // open the vrf id task
//		   	 System.out.println("below the vfr task: ");
//		   	 String prodPkgID = swiftPage.lbl_productpkgID.getText(); // get the product package id
//		   	 System.out.println("product package id is: " +prodPkgID);
//		   	 System.setProperty("PkgId.ID", prodPkgID ); // set the swift id in memory
//	   		 String myPkgID=System.getProperty("PkgId.ID"); // get the swift id out of memory
//	   	     System.out.println(" My product package id is: " +myPkgID);
//	   	     
//			 swiftPage.arr_vrfid_arrow.waitUntilEnabled(); // open up the vrf id dropdown
//			 swiftPage.arr_vrfid_arrow.click(); // open up the vrf id dropdown
//			 swiftPage.lbl_vrfid_secondLabel.waitUntilEnabled(); // click on vrfid label
//			 swiftPage.lbl_vrfid_secondLabel.click(); // click on vrfid label
//			 waitABit(2000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 swiftPage.lnk_details.waitUntilEnabled(); // click on the details link
//			 swiftPage.lnk_details.click(); // click on the details link
//			 waitABit(2000);
//			 swiftPage.btn_cbpban.waitUntilEnabled(); // CPB ban edit icon
//			 swiftPage.btn_cbpban.click(); // CPB ban edit icon
//			 waitABit(2000);
//			 swiftPage.btn_new_ban.waitUntilEnabled(); // add the scenario id
//			 swiftPage.btn_new_ban.click(); // add the scenario id
//			 waitABit(2000);
//			 swiftPage.btn_cbpban_search.waitUntilEnabled(); // click on the cbp ban sear
//			 swiftPage.btn_cbpban_search.click(); // click on the cbp ban search
//			 waitABit(5000);
//			 swiftPage.txt_accountname.waitUntilEnabled();
//			 swiftPage.txt_accountname.click();  // click on account name to pick one
//			 swiftPage.btn_accountsearch.waitUntilEnabled(); // click on search button
//			 swiftPage.btn_accountsearch.click(); // click on search button
//			 waitABit(2000);
//			 WebElement element = getDriver().findElement(By.xpath("(//span[contains(@class,'glyphicon glyphicon-ok')])[21]"));
//			 waitABit(2000);
//			 element.click();
//			 waitABit(2000);
//			 
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 WebElement elementsave = getDriver().findElement(By.xpath("//*[@id='saveChanges']"));  // have to go to top of page and hit save changes for this app to save any edits
//			 waitABit(2000);
//			 elementsave.click();
//			 waitABit(2000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
////		   	 swiftPage.arr_vrfid.waitUntilEnabled(); // open first logical interface
////		   	 swiftPage.arr_vrfid.click(); // open first logical interface
////		   	 waitABit(1000);
////		   	 swiftPage.lbl_ipvpnlogicalinterface_1.waitUntilEnabled(); // click on logical interface label to open it up
////		   	 swiftPage.lbl_ipvpnlogicalinterface_1.click(); // click on logical interface label to open it up
//			List<WebElement> parentProducts = getDriver().findElements(
//	    	By.cssSelector(".row.small-gutter#orderdetailssection .k-master-row.ng-scope [role=\"gridcell\"] .ng-binding[ ng-bind=\"dataItem.ProductName\"]")); // return task names 
//	          	for(WebElement ele : parentProducts) {
//	    		  if(ele.getText().contains("IP VPN Logical Interface")) {
//	    			  ele.click(); //opens first one 
//	    			   getDriver().findElement(By.cssSelector(".container-fluid .col-md-12  table[role='treegrid'] .k-selectable .k-master-row")).click(); //click on child
//	    			   break;
//	    		 }
//	          }
//		   	 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//				 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 
//		   	// swiftPage.lnk_details.waitUntilClickable().click(); // click on the details link
//		   	swiftPage.lnk_detailedit.waitUntilEnabled(); // click on the edit pencil for VRF ID
//		   	swiftPage.lnk_detailedit.click(); // click on the edit pencil for VRF ID
//		   	swiftPage.btn_autofill.waitUntilEnabled(); // click on auto fill
//		    swiftPage.btn_autofill.click(); // click on auto fill
//		    waitABit(8000);
//			 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//				 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 waitABit(3000);
//		   	 swiftPage.btn_searchvrf.waitUntilEnabled(); // click on search
//		   	 swiftPage.btn_searchvrf.click(); // click on search
//		   	 myflag = waitForSwiftProgressBar();
//			 if (myflag) {
//				 System.out.println("error in waitForSwiftProgressBar");
//			 }
//			 swiftPage.img_vfrfiltercheckbox.waitUntilEnabled();// check the filter drop down image for vfr
//		   	 swiftPage.img_vfrfiltercheckbox.click();// check the filter drop down image for vfr
//		   	 swiftPage.img_vrffilter.waitUntilEnabled();// check the filter drop down image
//		   	 swiftPage.img_vrffilter.click();// check the filter drop down imag
//		   	//  myPkgID=System.getProperty("PkgId.ID"); // get the swift id out of memory
//		   	 swiftPage.txt_filterinput.type(myPkgID); // search for the cilli
//		   	 swiftPage.btn_filter.waitUntilEnabled(); // click on filter
//		   	 swiftPage.btn_filter.click(); // click on filter
//		   	 swiftPage.lbl_vrfid.waitUntilEnabled();  // click on the link
//		   	 swiftPage.lbl_vrfid.click();  // click on the link
//
//		   	 swiftPage.btn_savevrf.waitUntilEnabled(); // click on save
//		   	 swiftPage.btn_savevrf.click(); // click on save
//		     getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 //getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 WebElement elementsave2 = getDriver().findElement(By.xpath("//*[@id='saveChanges']"));  // have to go to top of page and hit save changes for this app to save any edits
//			 waitABit(2000);
//			 elementsave2.click();
//			 waitABit(2000);
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//		 }	 
//		 if (i==1) {
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 getDriver().navigate().refresh(); //refresh the page
//			 waitABit(5000);
//			 swiftPage.searchBtn.waitUntilEnabled(); // click the search button
//			 swiftPage.searchBtn.click(); // click the search button
//			 swiftPage.lnk_second_order.waitUntilEnabled();
//			 swiftPage.lnk_second_order.click();
//			 swiftPage.waitForTextToAppear("Tasks", 30000); 
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 //getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			 swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
//			 swiftPage.btn_productPackagesTab.click(); // click on the product package tab
////		   	 swiftPage.arr_secondLogInterface.waitUntilEnabled(); // second chevron for logical interface
////		   	 swiftPage.arr_secondLogInterface.click(); // second chevron for logical interface
////		     swiftPage.lbl_ipvpnlogicalinterface_2.waitUntilEnabled(); // click on logical interface label to open it
////		     swiftPage.lbl_ipvpnlogicalinterface_2.click(); // click on logical interface label to open itup
////		   	 WaitAndSync();
//			 List<WebElement> parentProducts = getDriver().findElements(
//	    	 By.cssSelector(".row.small-gutter#orderdetailssection .k-master-row.ng-scope [role=\"gridcell\"] .ng-binding[ ng-bind=\"dataItem.ProductName\"]")); // return to quote button 
//	          	for(WebElement ele : parentProducts) {
//	    		  if(ele.getText().contains("IP VPN Logical Interface")) {
//	    			  ele.click(); //opens first one 
//	    			   getDriver().findElement(By.cssSelector(".container-fluid .col-md-12  table[role='treegrid'] .k-selectable .k-master-row")).click(); //click on child		
//	    			   break;
//	    		 }
//	          }
//		   	 swiftPage.lnk_details.waitUntilEnabled(); // click on the details link
//		   	 swiftPage.lnk_details.click(); // click on the details link
//		   	 swiftPage.lnk_detailedit.waitUntilEnabled(); // click on the edit pencil for VRF ID
//		   	 swiftPage.lnk_detailedit.click(); // click on the edit pencil for VRF ID
//		   	 swiftPage.btn_autofill.waitUntilEnabled(); // click on auto fill
//		   	 swiftPage.btn_autofill.click(); // click on auto fill
//		   	 WaitAndSync();
//		   	 waitABit(2000);
//		   	 swiftPage.btn_searchvrf.waitUntilEnabled(); // click on search
//		   	 swiftPage.btn_searchvrf.click(); // click on search
//		   	 WaitAndSync();
//		   	swiftPage.txt_accountname1.waitUntilEnabled();  // click on account name to pick one
//		   	 swiftPage.txt_accountname1.click();  // click on account name to pick one
//		   	 swiftPage.btn_savevrf.waitUntilEnabled(); // click on save
//		   	 swiftPage.btn_savevrf.click(); // click on save
//		   	 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//			 WebElement elementsave3 = getDriver().findElement(By.xpath("//*[@id='saveChanges']"));  // have to go to top of page and hit save changes for this app to save any edits
//			 waitABit(2000);
//			 elementsave3.click();
//			 waitABit(2000);
//			 System.out.println("out of PSP");
//		 	}
//		 	
//		 }
//	 
// }
//	 
//
//			
// @Step
// public void user_completes_Order_Details(){ 
//	Boolean myflag;
//	String myName;
//	int myTaskCounter =-1;
//	String myProductType = System.getProperty("myProduct.ID");
//	String SIDID=System.getProperty("SID.ID"); 	
//	 JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//	 if(myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")||(myProductType.contains("IP VPN Port and Access"))) {
//		 myTaskCounter=2;
//	 }else {
//		 myTaskCounter=1;
//    }
//	 for (int i = 0; i  < myTaskCounter; i++) {
//		
//		 if(i==0) {
//			swiftPage.lnk_first_order.waitUntilEnabled().waitUntilClickable();
//			swiftPage.lnk_first_order.click();
//			swiftPage.waitForTextToAppear("Tasks", 30000); 
//			 }
//		 if(i==1) {
//			swiftPage.lnk_second_order.waitUntilEnabled().waitUntilClickable();
//			swiftPage.lnk_second_order.click();
//			swiftPage.waitForTextToAppear("Tasks", 30000); 
//		 }
//		 try {
//					 
//				 myName =swiftPage.txt_api_swift_assignee_name.getText();
//				 swiftPage.lbl_user_info.click(); //open impersonate box
//				 waitABit(5000);
//				 swiftPage.txt_user_info.type("");
//				 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//				 getDriver().switchTo().activeElement().sendKeys(myName);
//				 waitABit(2000);
//				 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// 
//				 waitABit(2000);
//				 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//				 WebElement elementCustCoord = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]"));  // click  on complete order details task
//		   		 JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
//		   		 jse1.executeScript("arguments[0].click()", elementCustCoord);
//		   		 waitABit(4000);
//		//		 WebElement elementCustCoord = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]"));  // click  on complete order details task
//		//		 waitABit(2000);
//		//		 elementCustCoord.click();
//		//		 waitABit(2000);
//				 swiftPage.btn_completeTask.click(); //press the complete button.
//				 myflag = waitForSwiftProgressBar();
//				 if (myflag) {
//				 	System.out.println("error in waitForSwiftProgressBar");
//				 }
//				 getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//				 getDriver().navigate().refresh(); //refresh the page
//				 waitABit(5000);
//				 swiftPage.searchBtn.click(); // click the search button
//				 waitABit(2000);
//				 System.out.println("out of user_completes_Order_Detail");
//		 }catch(Exception e) {
//			 System.out.println("Last task did not show up");
//		 }
//	 }
// }	
// @Step
// public void impersonate_second_task()  {
//	 try {
//		 
//
//		Boolean myflag;
//		String myName =""; 
//		swiftPage.waitForTextToAppear("Tasks", 3000); 
//	    myName =swiftPage.txt_second_assignee_name.getText(); //get the name to  impersonate using welcome custommer as it is second task on screen.
//		 System.out.println("myName is " + myName);
//		 swiftPage.lbl_user_info.click(); //open impersonate box
//		 waitABit(5000);
//		 swiftPage.txt_user_info.type("");
//		 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		 getDriver().switchTo().activeElement().sendKeys(myName);
//		 waitABit(2000);
//		 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// ded network type
//		 waitABit(2000);
//		 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//		 myflag = waitForSwiftProgressBar();
//		 if (myflag) {
//		 System.out.println("error in waitForSwiftProgressBar");
//		 
//		 }
//	 }catch(Exception e) {
//			 System.out.println("Second task did not show up in swift ");
//		 
//		 }
//	}
// 
// @Step
// public void add_swift_doc()  {
//	Boolean myflag;
//	String myName =""; 
//    myName =swiftPage.txt_second_assignee_name.getText(); //get the name to  impersonate using welcome custommer as it is second task on screen.
//	 System.out.println("myName is " + myName);
//	 swiftPage.lbl_user_info.click(); //open impersonate box
//	 waitABit(5000);
//	 swiftPage.txt_user_info.type("");
//	 getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//	 getDriver().switchTo().activeElement().sendKeys(myName);
//	 waitABit(2000);
//	 getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);// ded network type
//	 waitABit(2000);
//	 swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
//	 myflag = waitForSwiftProgressBar();
//	 if (myflag) {
//	 System.out.println("error in waitForSwiftProgressBar");
//	}
//	 swiftPage.lnk_doc.click(); // click on the doc link
//	 swiftPage.lbl_ise_design.click(); // click on the ise design link
//	 String userDir = System.getProperty("user.dir"); 
//	 try {
//		 	swiftPage.btn_attachment_field.withTimeoutOf(30, TimeUnit.SECONDS).sendKeys(userDir + "\\src\\test\\resources\\testdata\\IPJustificationForm.xlsx");// Attachment to Add
//	 }catch(Exception e) {
//		 swiftPage.btn_attachment_field.withTimeoutOf(30, TimeUnit.SECONDS).sendKeys(userDir + "\\src\\test\\resources\\testdata\\IPJustificationForm.xlsx");// Attachment to Add
//	 }
// send in the file
//}
//	@Step
//	public void Wait_For_BPMS_Acceptance_Task(String sExpStatus, String sExpTask){
//	Boolean bflag=false;
//	int ncounter =0;
//	do { 
//		  waitABit(100);
//		  String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
//			if (UpdatedTask.contains("1 - 7 of 7 items")) {
//				
//				waitABit(2000);
//				
//			} else {
//				
//				waitABit(30000);
//				getDriver().navigate().refresh();
//				
//			}
//			System.out.println("Update Task Status : "+UpdatedTask);
//			String numofTask=UpdatedTask.substring(4,5);
//			System.out.println("number of Tasks are: " +numofTask);
//			int myTask = Integer.parseInt(numofTask);
//			System.out.println("number of Tasks are: " +myTask);
//				for(int i=2; i<=(myTask+1); i++ ) {
//					System.out.println("the number i is: " +i);
//					String myStatus= getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr["+i+"]/td[4]/span")).getText();
//					String myTaskName= getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr["+i+"]/td[7]/span")).getText();
//					System.out.println("the status is : " +myStatus);
//					System.out.println("the task is : " +myTaskName);
//				
//					System.out.println("Table status is " +myStatus + "  and my Task is " +myTaskName);
//					if (myStatus.equalsIgnoreCase("Completed") && myTaskName.equalsIgnoreCase("Waiting For BPMS Acceptance")) {
//						System.out.println("BPMS is completed");
//						bflag = true;
//			  } else {
//				System.out.println("waiting on completed");
//				ncounter=ncounter +1;
//				 waitABit(5000);
//				 if(ncounter > 100)
//				 bflag = false;
//			  }	
//			}
//	  	} while (bflag != true); 
//	}
//}
