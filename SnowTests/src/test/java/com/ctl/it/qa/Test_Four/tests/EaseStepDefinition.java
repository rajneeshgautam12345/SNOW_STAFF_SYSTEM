package com.ctl.it.qa.Test_Four.tests;

import com.ctl.it.qa.Test_Four.tools.steps.ease.EaseSteps;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class EaseStepDefinition {
	
	@Steps
	EaseSteps easeSteps;
	
@When("User logs in EASE application")
public void user_logs_in_ease_application() {
	easeSteps.logs_in_ease_Application();
	
}

@When("User completes the asr tasks")
public void user_completes_the_asr_tasks() {
	easeSteps.Click_On_Search();

	
}


}