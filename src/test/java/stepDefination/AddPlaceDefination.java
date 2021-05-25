package stepDefination;

import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class AddPlaceDefination extends Utils {
	
	RequestSpecification reqSpec;
	ResponseSpecification respoSpec ;
	Response resp;
	String response;
	JsonPath js;
	static String place_id;
	TestDataBuild td = new TestDataBuild();

    @Given("^Add place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws IOException {

    	reqSpec = given().spec(requestSpecifications()).body(td.testData(name, language, address));
    	
    }



	@When("^user call \"([^\"]*)\" with http \"([^\"]*)\" request$")
    public void user_call_something_with_http_request(String resourse ,String method) throws Throwable {

		 ApiResources resourceApi = ApiResources.valueOf(resourse);
		 String resource = resourceApi.addResources();
		 System.out.println(resource);
		 
	    respoSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		 
		 if(method.equalsIgnoreCase("POST")) {
			 resp = reqSpec.when().post(resource);
	         response = reqSpec.when().post(resource).asString();
	         System.out.println(response);
		 }else if(method.equalsIgnoreCase("GET")) {
			 resp = reqSpec.when().get(resource);
	         response = reqSpec.when().get(resource).asString();
	         System.out.println(response);
		 }
		 
		
    }

    @Then("^Api call is sucess with status code 200$")
    public void api_call_is_sucess_with_status_code_200() throws Throwable {
    	
    	System.out.println("rrrr "+resp.getStatusCode());
    	assertEquals(resp.getStatusCode(),200);

    }

  
	@And("^\"([^\"]*)\" in response code is \"([^\"]*)\"$")
    public void something_in_response_code_is_something(String key, String value) throws Throwable {

		assertEquals(getJsonPath(resp,key),value);
		
//		 js = new JsonPath(response);
//		assertEquals(js.get("status"),value);
		
    }
	


		@Then("Verify place_id with the {string} added {string} after hiting {string}")
		public void verify_place_id_with_the_added_after_hiting(String name, String reqType , String getplace) throws Throwable {

			
			//place_id = js.getString("place_id");
			place_id = getJsonPath(resp,"place_id");
			System.out.println(place_id);
			reqSpec = given().spec(requestSpecifications()).queryParam("place_id", place_id);

			
//			ApiResources resourceapi = ApiResources.valueOf(getplace);
//			String resources = resourceapi.addResources();
//			resp = reqSpec.when().get(resources).then().spec(respoSpec).extract().response();
//			 response = reqSpec.when().get(resources).then().spec(respoSpec).extract().response().asString();
//	         System.out.println(response);
	    	
	    	//Mark:- Alias
	         
	         user_call_something_with_http_request(getplace,reqType);
	        
	         js = new JsonPath(response);
	         String names = js.getString("name");
	         System.out.println("name is "+name);
	         System.out.println("names is "+names);
	         assertEquals(name,names);
	         
	         System.out.println("aaaaa "+place_id);
		
		}



			@Given("Delete place payload")
			public void delete_place_payload() throws IOException {

				reqSpec = given().spec(requestSpecifications()).body(td.delData(place_id));

			}








}
