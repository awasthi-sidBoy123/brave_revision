package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import pojoDelete.DeleteObject;

public class TestDataBuild {
	
	public AddPlace testData(String name , String language , String address) {
		
    	AddPlace ap = new AddPlace();
    	Location loc = new Location();
    	loc.setLat(-38.383494);
    	loc.setLat(33.427362);
    	ap.setLocation(loc);
    	ap.setAddress(address);
    	ap.setLanguage(language);
    	ap.setName(name);
    	ap.setWebsite("http://google.com");
    	ap.setPhone_number("(+91) 983 893 3937");
    	List<String> myType = new ArrayList<String>();
    	myType.add("shoe park");
    	myType.add("shop");
    	return ap;
		
	}
	
	public DeleteObject setDeleteData(String place_id ) {
		DeleteObject del = new DeleteObject();
		 del.setPlace_id(place_id);
		 return del;
	}

	public String delData(String placeId) {
		
		return "{\r\n\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
	
}
