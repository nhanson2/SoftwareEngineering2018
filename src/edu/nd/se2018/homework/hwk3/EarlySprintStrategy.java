package edu.nd.se2018.homework.hwk3;

public class EarlySprintStrategy extends Strategy {
	public EarlySprintStrategy() {
		effort = 100;
	}
	@Override
	public double setEffort(double milesRun) {
		if(milesRun>2) {
			return 75;
		} else {
			return 100;
		}
	}
}