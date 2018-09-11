package edu.nd.se2018.homework.hwk3;

import java.util.ArrayList;
import java.text.*;
import java.math.RoundingMode;

public class Race {
	public boolean consoleEnabled = true;
	DecimalFormat df = new DecimalFormat("#.###");
	ArrayList<Horse> roster = new ArrayList<Horse>();
	public void register(String name, int number, double speed, String strat) {
		this.roster.add(new Horse(name,number,speed,strat));
		System.out.println(name + " successfully registered");
	}
	public void clear() {
		this.roster.clear();
	}
	public String runRace() {
		System.out.println("And the race is off!");
		boolean cont = true;
		while(cont) {
			for(int i=0;i<this.roster.size();i++) {
				// Update position of each horse every tenth of a second
				Horse temp = this.roster.get(i);
				temp.setDistance(0.0001);
				if(this.consoleEnabled) {
					System.out.println(temp.getName() + " ==> " + df.format(temp.getDist()));
				}
				this.roster.set(i, temp);
				if(temp.getDist() >= 10) {
					return(String.format("Winner is %s", temp.getName()));
				}
			}
			if(this.consoleEnabled) {
				System.out.println("===================");
			}
		}
		return("");
	}
}