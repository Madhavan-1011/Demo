import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import Files.AddbookPayload;
import Files.DeletePayload;
import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class dynamicJson {

	ArrayList<String> newId = new ArrayList<String>();

	@Test(dataProvider = "BookProvider", priority = 1)
	public void addBooks(AddbookPayload payload) {
		RestAssured.baseURI = "http://216.10.245.166";
//		AddbookPayload adb = new AddbookPayload("Learn Appium Automation with Java", "bcd", "23444", "Guru");

		String response = given().header("Content-Type", "application/json").body(new Gson().toJson(payload))

		// .body(payload.addBook(isbn, aisle))
//		.body("{\r\n"
//				+ "\r\n"
//				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
//				+ "\"isbn\":\"bcd\",\r\n"
//				+ "\"aisle\":\"227\",\r\n"
//				+ "\"author\":\"John foe\"\r\n"
//				+ "}\r\n"
//				+ "")
				.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).and().extract().response()
				.asString();

		JsonPath js = reusableMethods.rawToJson(response);
		String id = js.get("ID");
		String Msg = js.get("Msg");
		System.out.println("Book id is :" + id);
		System.out.println("Book Msg is :" + Msg);
		newId.add(id);
	}

	@Test
	public void staticJson() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
//		String n = new String(Files.readAllBytes(Paths.get("C:\\Users\\user\\eclipse-workspace\\REST_Assured\\src\\Files\\AddBookDetail.json")));
		
		String JsonOutput = given().header("Content-Type", "application/json")
		.body(reusableMethods.GenerateStringFromResource("C:\\Users\\user\\eclipse-workspace\\REST_Assured\\src\\Files\\AddBookDetail.json"))
		.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).and().extract().response()
		.asString();
		JsonPath js = reusableMethods.rawToJson(JsonOutput);
		String id = js.get("ID");
		String Msg = js.get("Msg");
		System.out.println("Book id is from JSON :" + id);
		System.out.println("Book Msg is from JSON :" + Msg);
	}

	@Test(enabled = true, priority = 2)
	public void deleteAllBook() {
		for (String id : newId) {
			DeletePayload dp = new DeletePayload(id);
			RestAssured.baseURI = "http://216.10.245.166";
			String delResponse = given().header("Content-Type", "application/json").body(new Gson().toJson(dp)).when()
					.delete("/Library/DeleteBook.php").then().assertThat().statusCode(200).and().extract().response()
					.asString();
			JsonPath js1 = reusableMethods.rawToJson(delResponse);
			String message = js1.get("msg");
			System.out.println(message);
		}
	}

	@DataProvider(name = "booksData")
	public String[][] getData() {
		String data[][] = { { "bcd", "2271" }, { "abcd", "2271" }, { "abcdf", "2271" } };
		return data;
	}

	@DataProvider(name = "BookProvider")
	public Object[] BookProvider() {

		List<AddbookPayload> returnList = new ArrayList<AddbookPayload>();
		returnList.add(new AddbookPayload("Madhavan Mamakutty 1", "Sasi", "123", "Paul Bro"));
		returnList.add(new AddbookPayload("Madhavan Mamakutty 2", "Sasi", "456", "Paul Bro"));
		returnList.add(new AddbookPayload("Madhavan Mamakutty 3", "Sasi", "789", "Paul Bro"));
		returnList.add(new AddbookPayload("Madhavan Mamakutty 4", "Sasi", "041", "Paul Bro"));

		return returnList.toArray();
//		return returnList;
	}
}
