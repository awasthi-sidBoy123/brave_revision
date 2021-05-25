package resources;

public enum ApiResources {

	AddPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");

	String resources ;
	
	ApiResources(String resources) {
		this.resources = resources;
	}
	
	public String addResources() {
		return resources;
	}
}
