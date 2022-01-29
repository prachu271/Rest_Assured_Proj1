package Post_Put_Delete;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import java.io.File;

public class Post_Put_Delete {
  @Test
  public void post_request() {
	  
	  File file= new File("Data/createEmployee.json");
	  
	  given()
	  		 .baseUri("http://dummy.restapiexample.com/api/v1")
	  		 .contentType(ContentType.JSON)
	  		 .body(file).
	  when()
	  		 .post("/create").
	  then()
	  		 .statusCode(200);
  }
}
