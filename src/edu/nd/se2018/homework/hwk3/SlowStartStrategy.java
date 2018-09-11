package edu.nd.se2018.homework.hwk3;

public class SlowStartStrategy extends Strategy{
	public SlowStartStrategy() {
		effort = 75;
	}
	@Override
	public double setEffort(double milesRun) {
		if(milesRun >= 10) {
			return 100;
		}
		else if(milesRun >= 6) {
			return 90;
		} else {
			return 75;
		}
	}
}