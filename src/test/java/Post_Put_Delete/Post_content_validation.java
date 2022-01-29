package Post_Put_Delete;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Post_content_validation {
  @Test
  public void post_request() {
	  
	  File file= new File("Data/createEmployee.json");
	  
	  int id=given()
	  		 .baseUri("http://dummy.restapiexample.com/api/v1")
	  		 .contentType(ContentType.JSON)
	  		 .body(file).
	  when()
	  		 .post("/create").
	  then()
	         .statusCode(200)
	  		 .extract().path("data.id");
	 System.out.println(id);
  }
}
