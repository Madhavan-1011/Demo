package Demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Pojo.LoginRequest;
import Pojo.LoginResponse;
import Pojo.OrderDetails;
import Pojo.Orders;

public class ECommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.setContentType(ContentType.JSON).build();
		
		LoginRequest loginReq = new LoginRequest();
		loginReq.setUserEmail("maddy123@gmail.com");
		loginReq.setUserPassword("Maddy#123");
		
		RequestSpecification reqLogin = given().spec(req).body(loginReq);
		LoginResponse response = reqLogin.when().post("api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		
		System.out.println("Message : "+response.getMessage());
		System.out.println("Token : "+response.getToken());
		String token = response.getToken();
		System.out.println("UserId : "+response.getUserId());
		String userId = response.getUserId();
		
		//AddProduct
		
		RequestSpecification reqAddProductBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("Authorization", token).build();
		
		RequestSpecification reqAddProduct = given().spec(reqAddProductBase)
				.param("productName", "Kathi").param("productAddedBy", userId)
				.param("productCategory", "Yuir").param("productSubCategory", "Soul").param("productPrice", "101")
				.param("productDescription", "Kathija").param("productFor", "onlyME")
				.multiPart("productImage", new File("C:\\Users\\user\\Desktop\\Dood\\Kathi.jpeg"));
		
		String resAddProduct = reqAddProduct.when().post("api/ecom/product/add-product").then().log().all().extract().response().asString();
		System.out.println(resAddProduct);
		JsonPath js = new JsonPath(resAddProduct);
		System.out.println("ProductId : "+js.getString("productId"));
		String resproductId = js.getString("productId");

		//CreateOrder
		
		RequestSpecification reqCreateOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCountry("India");
		orderDetails.setProductOrderedId(resproductId);
		List<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
		orderDetailList.add(orderDetails);
		
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);
		
		RequestSpecification createOrder = given().spec(reqCreateOrder).body(orders);
		
		String resOrder = createOrder.when().post("api/ecom/order/create-order").then().extract().response().asString();
		System.out.println(resOrder);
		
		//DeleteOrder
		
		RequestSpecification deleteBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		
		RequestSpecification reqDelProduct = given().spec(deleteBase).pathParam("productId", resproductId);
		
		String resDelProduct = reqDelProduct.when().delete("api/ecom/product/delete-product/{productId}").then().extract().response().asString();
		System.out.println(resDelProduct);
		
		JsonPath js1 = new JsonPath(resDelProduct);
		String delMessage = js1.get("message");
		System.out.println(delMessage);

	}

}
