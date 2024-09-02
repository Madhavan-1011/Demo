import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.payload;
import Files.reusableMethods;

public class Basics {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println("Place ID is " + placeId);
		
		//UPDATE PLACE
		String newAddress = "Central Nithy street, Kailasa";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GETPLACE		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.header("Content-Type", "application/json")
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(getPlaceResponse);

		//JsonPath js1 = new JsonPath(getPlaceResponse);
		JsonPath js1 = reusableMethods.rawToJson(getPlaceResponse);
		String actualAdress = js1.getString("address");
		System.out.println(actualAdress);
		Assert.assertEquals(newAddress, actualAdress);
		
		

	}
}
