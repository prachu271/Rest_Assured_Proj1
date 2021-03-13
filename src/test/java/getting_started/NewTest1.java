package getting_started;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class NewTest1 {
	
  @Test
  public void firstGetRequest() {
	  given().baseUri("https://restcountries.eu/rest/v2/").when().get("all").then().statusCode(200);
	  
  }
}
