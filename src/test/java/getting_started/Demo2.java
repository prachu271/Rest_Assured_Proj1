package getting_started;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo2 {
  @Test
  public void validatePosts() {
	  //System.out.println(Payload.createPost.post());
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	  given().log().all().contentType(ContentType.JSON)
	  		 .body(Payload.PostDetails.createpost()).	  
	  
	  when().post("/posts").
	  
	  then().log().all().statusCode(201)
	        .body("title",equalTo("foo"),
	        	  "body",equalTo("Mohit"),
	        	  "userId",equalTo(1)
	        		);
	        
  }
  
 @Test
 public void getPosts() {
	 
	 given().log().all().baseUri("https://jsonplaceholder.typicode.com")
	 .when().get("/Posts/1")
	 .then().log().all().statusCode(200).body("userId",equalTo(1));
 }
 
 @Test
 public void updatePost() {
	 
	 given().log().all().baseUri("https://jsonplaceholder.typicode.com/posts")
	 		.contentType(ContentType.JSON)
	 		.body(Payload.PostDetails.updatePost()).
	 		
	 when().put("/1").
	  then().log().all().statusCode(200).body("title",equalTo("Go")
			  );
 }
 
 @Test
 public void deletePost()
 {
	 
	 given().baseUri("https://jsonplaceholder.typicode.com");
	 when().delete("/posts/1").
	 then().statusCode(200);
 }
}
