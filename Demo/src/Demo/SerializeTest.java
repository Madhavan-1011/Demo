package Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class SerializeTest {

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
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response=given().log().all()
		.queryParam("key", "qaclick123").body(a)
		.when()
		.post("/maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200).extract().response();
		
		String responseString = response.asString();
		System.out.println(responseString);

	}

}
