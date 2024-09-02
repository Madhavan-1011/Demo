package Demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace a= new AddPlace();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		a.setAccuracy(50);
		a.setName("Frontline house");
		a.setPhone_number("\"(+91) 983 893 3937");
		a.setAddress("29, side layout, cohen 09");
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		a.setTypes(myList);
		a.setWebsite("http://google.com");
		a.setLanguage("French-IN");
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		Response responseString = given().spec(req).body(a).when().post("/maps/api/place/add/json").then().spec(res).extract().response();
		System.out.println(responseString.asString());

	}

}
