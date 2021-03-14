package getting_started;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NewTest1 {
	
  @Test
  public void firstGetRequest() {
	  given().baseUri("https://restcountries.eu/rest/v2/").when().get("all").then().statusCode(200);
	  
  }
  
  @Test
  public void firstJsonResponse() {
	  given().baseUri("https://restcountries.eu/rest/v2").
	  when().get("/alpha/USA").
	  then().statusCode(200)
	        .body(
	        		"name",equalTo("United States of America"),
	        		"alpha2Code",equalTo("US"),
	        		"altSpellings",hasItem("USA"),
	        		"currencies[0].symbol",equalTo("$")
	              );
  }
}
