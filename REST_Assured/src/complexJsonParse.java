import org.testng.Assert;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payload.coursePrice());
		int noOfCourse = js.getInt("courses.size()");
		System.out.println("Number of courses : "+ noOfCourse);
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Number of purchaseAmt : "+ purchaseAmt);
		String title = js.getString("courses[0].title");
		System.out.println("Number of title : "+ title);
		
		for(int i = 0; i < noOfCourse; i++) {
			String course = js.get("courses["+i+"].title");
			int price = js.get("courses["+i+"].price");
			System.out.println("course name "+ i +" " + course);
			System.out.println("course price "+ i +" " + price);
		}
		
		for(int i = 0; i < noOfCourse; i++) {
			//String course = js.get("courses["+i+"].title");
			if(((String) js.get("courses["+i+"].title")).equalsIgnoreCase("RPA")) {
				int noOFCopies = js.getInt("courses["+i+"].copies");
				System.out.println(noOFCopies);
				break;
			}
		}
		
		int totalAmt = 0;
		for(int i = 0; i < noOfCourse; i++) {
			int totalPrice = js.getInt("courses["+i+"].price");
			int totalCopies = js.getInt("courses["+i+"].copies");
			int totalAmtind = totalPrice*totalCopies;
			totalAmt = totalAmt + totalAmtind;
			
		}
		System.out.println(totalAmt);
		Assert.assertEquals(totalAmt, purchaseAmt);

	}
}
