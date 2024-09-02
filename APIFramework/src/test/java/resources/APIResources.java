package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	getPlaceAPI("/maps/api/place/get/json");
	
	public String resource;
	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
