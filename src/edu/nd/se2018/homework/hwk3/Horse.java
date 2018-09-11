package edu.nd.se2018.homework.hwk3;

public class Horse {
	// Attributes of horse class
	private String horseName;
	@SuppressWarnings("unused")
	private int horseNumber;
	private double currSpeed;
	private Strategy myStrategy; 
	private double maxSpeed;
	private double distRun = 0;
	// Constructor
	public Horse(String name, int number, double speed, String strat) {
		horseName = name;
		horseNumber = number;
		currSpeed = speed;
		// Switch case to initialize the three strategy types
		switch(strat) {
			case "early":
				this.myStrategy = new EarlySprintStrategy();
				break;
			case "steady":
				this.myStrategy = new SteadyRunStrategy();
				break;
			case "slow":
				this.myStrategy = new SlowStartStrategy();
				break;
		}
		// Set the maximum allowed speed from the initialized speed
		this.maxSpeed = (100.0/this.myStrategy.effort) * this.currSpeed;
	}
	// Getter/Setter Methods
	public String getName() {	return this.horseName; }
	public double getDist() {	return this.distRun; }
	// Set the current speed as a product of effort and maximum speed
	public void setSpeed() {
		this.currSpeed = this.maxSpeed * this.myStrategy.setEffort(this.distRun);
	}
	// Update the distance traveled as a factor of speed and a time interval
	public void setDistance(double interval) {
		this.setSpeed();
		//System.out.println("distance: " + this.distRun + " speed: " + this.currSpeed + " interval: "+ interval);
		this.distRun += this.currSpeed * interval;
	}
	//Update strategy
	public void updateStat(String strat) {
		switch(strat) {
		case "early":
			this.myStrategy = new EarlySprintStrategy();
			break;
		case "steady":
			this.myStrategy = new SteadyRunStrategy();
			break;
		case "slow":
			this.myStrategy = new SlowStartStrategy();
			break;
		}
	}
}