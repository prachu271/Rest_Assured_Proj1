package getting_started;

import org.testng.annotations.Test;

import io.restassured.response.Response;

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
  
  @Test
  public void validate_xml_Response() {
	  given().baseUri("https://api.openweathermap.org/data/2.5")
	  		.queryParam("q", "pune")
	  		.queryParam("appid", "87d34aefa8787e3be0321fd8efdc22ef")
	  		.queryParam("mode", "xml").
	  		
	  when().get("/weather").
	  then().statusCode(200)
	  		.body(
	  				"current.city.country",equalTo("IN"),
	  				"current.city.@name",equalTo("Pune")
	  				);
  }
  
  @Test
  public void extract_response() {
	  Response res= given().baseUri("https://restcountries.eu/rest/v2").
	  when().get("/alpha/USA").
	  then().
	  		 extract().response();
	  System.out.println(res.asString());
  }
  
  @Test
  public void extract_singleValue()
  {
	  String temp= given().baseUri("https://api.openweathermap.org/data/2.5")
		.queryParam("q", "pune")
		.queryParam("appid", "87d34aefa8787e3be0321fd8efdc22ef")
		.queryParam("mode", "xml").
		
		when().get("/weather").
		then().statusCode(200)
		.body(
				"current.city.country",equalTo("IN"),
				"current.city.@name",equalTo("Pune")
				)
		.extract().path("current.temperature.@value");
	    System.out.println(temp);
  }
  
  @Test
	public void verify_status_line() {
		given()
			.baseUri("https://api.printful.com").
		when()
			.get("/variant/1").
		then()
			.statusCode(404)
			.statusLine("HTTP/1.1 404 Not Found");
  }
}
