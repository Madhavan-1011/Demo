import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class sumValidation {

	@Test
	public void sumOfCourse() {
		JsonPath js = new JsonPath(payload.coursePrice());
		int noOfCourse = js.getInt("courses.size()");
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Sum of purchaseAmt : "+ purchaseAmt);
		int totalAmt = 0;
		for(int i = 0; i < noOfCourse; i++) {
			int totalPrice = js.getInt("courses["+i+"].price");
			int totalCopies = js.getInt("courses["+i+"].copies");
			int totalAmtind = totalPrice*totalCopies;
			totalAmt = totalAmt + totalAmtind;
			
		}
		System.out.println("TotalamountActual : "+totalAmt);
		Assert.assertEquals(totalAmt, purchaseAmt);
	}
	
	
}
