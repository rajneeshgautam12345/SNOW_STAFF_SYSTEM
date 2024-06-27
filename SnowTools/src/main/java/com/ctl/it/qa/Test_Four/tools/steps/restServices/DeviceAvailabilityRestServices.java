package com.ctl.it.qa.Test_Four.tools.steps.restServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import io.restassured.response.ResponseBodyExtractionOptions;
import net.serenitybdd.annotations.Step;

@SuppressWarnings({ "serial", "unused" })
public class DeviceAvailabilityRestServices extends BaseStep {
	static int counter = 0;
	IntDataContainer Container2 = envData.getContainer("ACT");

	@Step
	public void validateAvaiabilityMeshEndPoint() {
		String baseURI = envData.getFieldValue("Mesh");
		String url = "/inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No";
		given().when().relaxedHTTPSValidation().baseUri(baseURI).get(url).then().statusCode(200).body("totalResources",
				equalTo(1));
		System.out.println("Mesh Sanity Passed");
	}

	@Step
	public void validateAvaiabilityACTEndPoint() {
		String baseURI = envData.getFieldValue("ACT");
		String url = "/ac-ip-confgen-rs/rs/Network/v1/Provisioning/actRequest/92b724d9-8410-47fa-bb77-842a7d03d3ac";
		given().auth().basic("autopilot", "TestNotProduction").when().relaxedHTTPSValidation().baseUri(baseURI).get(url)
				.then().statusCode(200);
		System.out.println("ACT Sanity Passed");
	}

	@Step
	public void i_complete_the_order_in_FD_with_required_details_and_push_the_order_for_further_AP_flows() {
	}

	@Step
	public void validateTaskStatus(int no, String ID) throws ParseException, InterruptedException {
		taskValidation(no, ID);
	}

	private void taskValidation(Integer expectedRecord, String ID) throws ParseException, InterruptedException {
		counter++;
		String wm = envData.getFieldValue("FD");
		// String order_ID = "AP-EXT-"+ID;
		System.out.println("Order ID : " + ID);
		String playLoad = "{\"searchFields\":[{\"fieldName\":\"TASK_INSTANCE_ID\",\"value\":[\"AP-EXT-" + ID
				+ "\"],\"operator\":\"starts with\",\"tableName\":\"task_instance\",\"isDateCriteria\":false}]}";
		// String playLoad =
		// "{\"searchFields\":[{\"fieldName\":\"TASK_INSTANCE_ID\",\"value\":[\"AP-552160519-10-14-157009841\"],\"operator\":\"starts
		// with\",\"tableName\":\"task_instance\",\"isDateCriteria\":false}]}";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Username", "aa88318");
		headers.put("Content-Type", "application/json");
		ResponseBodyExtractionOptions s = given().auth().basic("aa88318", "").headers(headers).when().body(playLoad)
				.post(wm).then().statusCode(200).extract().body();
		JSONParser parser = new JSONParser();
		Object tempData = parser.parse(s.asString());
		JSONObject jsonTempData = (JSONObject) tempData;
		JSONObject paginationData = (JSONObject) jsonTempData.get("pagination");
		paginationData.get("totalRecords");
		JSONArray taskArray = (JSONArray) jsonTempData.get("taskResults");
		System.out.println(taskArray.size());
		int failCount = 0;
		// @SuppressWarnings("unused")
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < taskArray.size(); i++) {
			JSONObject task = (JSONObject) taskArray.get(i);
			// System.out.println(task.toString());
			String statusMessage = (String) task.get("STATUS_MESSAGE");
			if (statusMessage.equalsIgnoreCase("Complete")) {
				System.out.println(task.get("TASK_NAME") + (" : STATUS_MESSAGE : ") + statusMessage);
			}
			if (statusMessage.equalsIgnoreCase("Cancelled")) {
				System.out.println(task.get("TASK_NAME") + (" : STATUS_MESSAGE : ") + statusMessage);
			}
			if (statusMessage.equalsIgnoreCase("Failed")) {
				System.out.println(task.get("TASK_NAME") + (" : STATUS_MESSAGE : ") + statusMessage);
				failCount = failCount + 1;
			}
			String taskName = (String) task.get("STATUS_MESSAGE");
			if (!m.containsKey(taskName)) {
				m.put(taskName, 0);
			}
			m.put(taskName, m.get(taskName) + 1);
		}
		// System.out.println("Total number of Fail Count :" + failCount);
		System.out.println(m);
		try {
			int completeStatus = m.get("Complete");
			assertThat(completeStatus, equalTo(expectedRecord));
		} catch (Exception e) {
			Thread.sleep(120000);
			if (counter == 11) {
				// assertThat("Test Case is failed", false);
				if (failCount > 0) {
					assertThat("Test Case is Failed", false);
				}
			}
			taskValidation(expectedRecord, ID);
		}
		/*
		 * try {
		 * 
		 * if (failCount>1) {
		 * 
		 * assertThat("Test Case is Failed", false);
		 * 
		 * }
		 * 
		 * } catch (Exception e) { System.out.println(e); }
		 */
	}
}
