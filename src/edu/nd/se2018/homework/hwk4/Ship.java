package edu.nd.se2018.homework.hwk4;

import java.util.Observable;
import java.awt.Point;

/**
 * @author Nathaniel Hanson
 * Date: 9/17/2018
 * Ship.java
 * Christopher Columbus Ship, observed object
 */

public class Ship extends Observable {
	Point coordinates;
	OceanMap myMap;
	int dimensions;
	public Ship(OceanMap map) {
		coordinates = new Point(0,0);
		myMap = map;
		dimensions = myMap.limits;
	}
	public Point getLoc() {
		return this.coordinates;
	}
	public void goEast() {
		// Check Right Bounds
		if(coordinates.x <= dimensions-2 && myMap.oceanGrid[coordinates.x+1][coordinates.y]==4) {
			myMap.oceanGrid[coordinates.x][coordinates.y] = 4;
			coordinates.setLocation(coordinates.x+1, coordinates.y);
			myMap.oceanGrid[coordinates.x][coordinates.y] = 1;
			setChanged();
			notifyObservers(coordinates);
		}
	}
	public void goWest() {
		// Check Left Bounds
		if(coordinates.x >= 1 && myMap.oceanGrid[coordinates.x-1][coordinates.y]==4) {
			myMap.oceanGrid[coordinates.x][coordinates.y] = 4;
			coordinates.setLocation(coordinates.x-1, coordinates.y);
			myMap.oceanGrid[coordinates.x][coordinates.y] = 1;
			setChanged();
			notifyObservers(this.coordinates);
		}
	}
	public void goNorth() {
		// Check Top Bounds
		if(coordinates.y >= 1 && myMap.oceanGrid[coordinates.x][coordinates.y-1]==4) {
			myMap.oceanGrid[coordinates.x][coordinates.y] = 4;
			coordinates.setLocation(coordinates.x, coordinates.y-1);
			myMap.oceanGrid[coordinates.x][coordinates.y] = 1;
			setChanged();
			notifyObservers(coordinates);
		}
	}
	public void goSouth() {
		// Check Bottom Bounds
		if(this.getLoc().y <= dimensions-2 && myMap.oceanGrid[coordinates.x][coordinates.y+1]==4) {
			myMap.oceanGrid[coordinates.x][coordinates.y] = 4;
			coordinates.setLocation(coordinates.x, coordinates.y+1);
			myMap.oceanGrid[coordinates.x][coordinates.y] = 1;
			setChanged();
			notifyObservers(coordinates);
		}
	}
}
