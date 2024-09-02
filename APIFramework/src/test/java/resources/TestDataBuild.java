package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public static AddPlace addPlacePayload(String name, String address, String lang) {
		AddPlace a= new AddPlace();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		a.setAccuracy(50);
		a.setName(name);
		a.setPhone_number("\"(+91) 983 893 3937");
		a.setAddress(address);
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		a.setTypes(myList);
		a.setWebsite("http://google.com");
		a.setLanguage(lang);
		return a;
	}

}
