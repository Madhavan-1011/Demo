import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import files.reusableMethods;

public class excelDriven {
	
	@Test
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("RestAssured", "AddBookTest");
		
		HashMap<String, Object> map= new HashMap();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		
		RestAssured.baseURI="http://216.10.245.166";
		String resp = given()
				.header("Content-Type", "application/json")
				.body(map)
				.when()
				.post("/Library/Addbook.php")
				.then().assertThat().statusCode(200).log().all()
				.extract().response().asString();
		
		JsonPath js = reusableMethods.rawToJson(resp);
		String id = js.get("ID");
		System.out.println(id);

	}
}
