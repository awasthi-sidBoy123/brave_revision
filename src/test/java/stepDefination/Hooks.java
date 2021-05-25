package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		
		AddPlaceDefination ad = new AddPlaceDefination();
		
		if(AddPlaceDefination.place_id == null) {
		ad.add_place_payload_with_something_something_something("add", "eng", "asia");
		ad.user_call_something_with_http_request( "AddPlaceApi" ,"POST");
		ad.verify_place_id_with_the_added_after_hiting("add", "GET", "getPlaceApi");
		
		}
	}
	

}
