package getting_started;

import org.testng.annotations.Test;

//import io.restassured.RestAssured;

//import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import java.util.List;


public class Demo1 {
	//gyan by mohit
  static String URL = "http://dummy.restapiexample.com/api/v1";
  static String URL1= "https://jsonplaceholder.typicode.com";
  @Test
  public void getResValidation() {
	//get all employees  
//	  RestAssured.baseURI = URL;
//	  given().
//	  when().get("/employees").
//	  then().log().all().statusCode(200).body("data[0].employee_name",equalTo("Tiger Nixon"));
	  
	  //Get count of objects having userid as 1
	  String res= given().log().all().baseUri(URL1).
	  when().get("/posts").
	  then().statusCode(200).extract().response().asString();
	  
	  //System.out.println(res);
	  int count = 0;
	  JsonPath js= new JsonPath(res);
//	  String userid= js.getString("userId");
	  List<Integer> jsonResponse = js.getList("userId");
	  for(int i = 0;i< jsonResponse.size();i++) {
		  if(jsonResponse.get(i) == 2454) {
			  count+=1;
		  }
	  }
	  System.out.println(count);
	  
	  
  } 
  
}
