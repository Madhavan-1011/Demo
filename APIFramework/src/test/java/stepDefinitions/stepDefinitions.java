package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinitions extends Utils{
	RequestSpecification req;
	ResponseSpecification res;
	RequestSpecification reqspec;
	Response responseString;
	
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String lang) throws IOException {
		reqspec = given().spec(requestSpecification()).body(data.addPlacePayload(name, address, lang));
	}
	@When("user calls {string} with {string} Http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		APIResources resourceAPI = APIResources.valueOf(resource);

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if(httpMethod.equalsIgnoreCase("POST"))
			responseString = reqspec.when().post(resourceAPI.getResource()).then().spec(res).extract().response();
		else if(httpMethod.equalsIgnoreCase("GET"))
			responseString = reqspec.when().get(resourceAPI.getResource()).then().spec(res).extract().response();
		
	}
	@Then("the API call gopt success with status code {int}")
	public void the_api_call_gopt_success_with_status_code(Integer int1) {
	    assertEquals(responseString.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String resp = responseString.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(keyValue).toString(),expectedValue);
	}
}
