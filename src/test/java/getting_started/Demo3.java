package getting_started;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3 {
  @Test
  public void getCountries() {
	  RestAssured.baseURI="https://restcountries.eu/rest/v2";
	  given().
	  when().get("/alpha/AF").
	  then().statusCode(200).
	  		body(
	  				"name",equalTo("Afghanistan"),
	  				"callingCodes[0]",equalTo("93"),
	  				"altSpellings",hasItem("AF"),
	  				"currencies[0].symbol",equalTo("؋")
	  				);
  }
}
