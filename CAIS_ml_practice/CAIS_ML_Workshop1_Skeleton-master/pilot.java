public class Pilot{

	// night vs. day mode of the display
	// use enum since these are only two modes 
	private enum Mode{
		NIGHT_MODE, DAY_MODE
	}

	// string display for warnings
	// declare as private static final to avoid changes 
	private static final String LEFT_TURN = "Turn left ahead!";
	// ...

	private int gateNumber;
	// route assigend to the pilot
	private Route route;
	// use queue FIFO property to manage incoming warnings of different times
	private Queue<String> warningList;
	private Mode mode;
	// get time of day to automate mode for display
	private int timeOfDay;

	/**
	* initialize Pilot once the destination gate is known
	* constructor will start the navigate function
	**/
	public Pilot(int gateNumber){
		this.gateNumber = gateNumber;
		// Initialize the route
		this.route = //.....
		this.warningList = new LinkedList<String>();

		// assign the display mode based on the current time
		Calendar calendar = Calendar.getInstance();
		this.timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		if(this.timeOfDay >=7 && this.timeOfDay<18){
			this.mode = DAY_MODE;
		}else{
			this.mode = NIGHT_MODE;
		}

		// main function used to navigate the assigned route
		// depends on the navigation API using 
		navigate();
	}

	
	/**
	* Things need to take care in this function:
	*  while(!alertOffRoute && !alertChangeRoute){
	*  		if close to intersection || possible new movement upcoming
	*			add new warning to warningList
	*		else if already pass the oldest warning
	*			remove the head from warningList
	*		update the map orientation, pilot/plane movement on the map
	*   }
	**/
	private void navigate(){


	}

	/**
	* Return true if off the assigned the route and release audible alert
	**/	
	private boolean alertOffRoute(){

	}


	/**
	* Return true if route changes and release audible alert
	**/	
	private boolean alertChangeRoute(){

	}
}


