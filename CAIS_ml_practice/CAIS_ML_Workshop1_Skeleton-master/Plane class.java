/**
 * For Gate, Plane and Road Segment class to better organize x,y coordinates of location
**/
public class Location{
	private double x;
	private double y;

	public Location(double x, double y){
		this.x = x;
		this.y = y;
	}

	// check whether the locations are the same
	public boolean isSameLocation(Location location){
		return this == location;
	}
}


/** Since the types for size is limited and can only be taken one of this set, use enum class 
 *  This is a public class for both Gate class and Plane class
**/
public enum Size{
	SMALL, MEDIUM, LARGE
}

/**
 * manage the plane actions 
**/
public class Plane{

	// Since the types for status is limited and can only be taken one of this set, use enum class
	private enum Status{
		GROUND, PARKED, TAKINGOFF, LANDING
	}

	// Create a separate airline string to store airline name; 
	// necessary since some terminal is taken by a single airline
	private String airline;
	private String planeNumber;
	// keep track of plane's current location
	private Location currentLocation;
	// keep track of the segment the plane supposed to be on 
	private int currentSegmentIndex;
	
	private Gate gate;
	private Size size;
	private Status status;

	private Route currentRoute;

	


	

	// Assume the plane status update from controller is by int value 0,1,2,3
	public Plane(String planeNumber, Location currentLocation, Size size, int status, Gate gate){
		this.planeNumber = planeNumber;
		this.airline = planeNumber.substring(0,2);
		this.currentLocation = currentLocation;

		// create Route based on plane's current location
		// then get all routes generated 
		Route route = new Route(currentLocation);
		// default the current route to be the first in the route list
		// else to manually set it use chooseRoute()
		this.currentRoute = this.allRoutes.get(0);

		this.size = size;
		this.status = Status.values()[status];
		this.gate = gate;
	}

	// set the route chosen by the user as the current route
	public void chooseRoute(int index){
		this.currentRoute = allRoutes.get(index);
		return;
	}

	// If want to update or change the current assigned the route, 
	// call this function to update the current route
	// This function calls the updateRoute() in Route class which returns the new route
	public void setRoute(){
		this.route = this.route.updateRoute(this.currentLocation);
		return;
	}

	// set plane status
	public void setStatus(int status){
		this.status = Status.values()[status];
		return;
	}

	// update plane's current location
	public void setCurrentLocation(){
		
	}

	// check whether the plane is still on route. If not on route, display warning
	// assign new route based on plane current location
	// assume route updateRoute() always takes in currentLocation of the plane
	public boolean isOnRoute(){
		if(!currentLocation.isSameLocation(.....)){
			this.route.updateRoute(this.currentLocation);
		}
		return;
	}

	// check whether at the end of the route
	// make updates accordingly
	public boolean isAtDestination(){

	}



}