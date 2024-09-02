package Demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.path.json.JsonPath;

public class oAuthtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};

		String response = given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);
		
		JsonPath jp = new JsonPath(response);
		String accessToken = jp.getString("access_token");
		
		GetCourse gc = given().log().all()
		.queryParam("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.then().log().all().extract()
		.as(GetCourse.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getCourses().getWebAutomation().get(1).getCourseTitle());
		
		List<Api> apicourse = gc.getCourses().getApi();
		for(int i = 0; i < apicourse.size(); i++) {
			System.out.println(apicourse.get(i).getCourseTitle());
			if(apicourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apicourse.get(i).getPrice());
			}
		}
		
		ArrayList<String> a = new ArrayList<String>();
		List<WebAutomation> w = gc.getCourses().getWebAutomation();
		for(int j = 0; j < w.size(); j++) {
			a.add(w.get(j).getCourseTitle());
		}
		List<String> expectedList = Arrays.asList(courseTitles);
		
		Assert.assertEquals(expectedList, a);
		Assert.assertTrue(a.equals(expectedList));

	}

}
