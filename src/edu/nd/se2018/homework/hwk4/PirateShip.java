package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Arrays;
import java.lang.Math;

/**
 * @author Nathaniel Hanson
 * Date: 9/17/2018
 * PirateShip.java
 * Class object for PirateShip
 * Function: Observers ship and determines appropriate location to move to
 */

public class PirateShip implements Observer{
	Point pirateCoordinates;
	Point columbusLocation;
	OceanMap myMap;
	OceanExplorer myGame;
	int dimensions;
	public PirateShip(OceanMap map, Point loc, OceanExplorer game, int limits) {
		pirateCoordinates = loc;
		myMap = map;
		myGame = game;
		dimensions = limits;
	}
	public Point getPirateLoc() {
		return pirateCoordinates;
	}
	public void setPirateLoc(Point coordinates) {
		pirateCoordinates = coordinates;
	}
	// Override the update method so the pirate ship can be aware
	// of columbus' moves
	@Override
	public void update(Observable o, Object arg) {
		//Base case
		if(o instanceof Ship) {
			// Cast arg to a point
			columbusLocation = (Point)arg;
			// Determine new coordinates and update the map
			movePirate();
			myGame.updatePirates();
		}
	}
	public void movePirate() {
		// Compare the hypotenuse from each of the directions and find the smallest distance
		// from the ship, and move in that direction
		double distEast = -100;
		double distWest = -100;
		double distNorth = -100;
		double distSouth = -100;
		double[] distances = new double[4];
		int tempX = pirateCoordinates.x;
		int tempY = pirateCoordinates.y;
		if(tempX+1 < dimensions && tempX >=0 && myMap.oceanGrid[tempX+1][tempY]==4) {
			// Check distance moving east
			distEast = Math.hypot(tempX+1-columbusLocation.x,tempY-columbusLocation.y);
			distances[0] = distEast;
		}
		if(tempX < dimensions && tempX-1 >=0 && myMap.oceanGrid[tempX-1][tempY]==4) {
			// Check distance moving west
			distWest = Math.hypot(tempX-1-columbusLocation.x,tempY-columbusLocation.y);
			distances[1] = distWest;
		}
		if(tempY+1 < dimensions && tempY >=0 && myMap.oceanGrid[tempX][tempY+1]==4) {
			// Check distance moving north
			distNorth = Math.hypot(tempX-columbusLocation.x,tempY+1-columbusLocation.y);
			distances[2] = distNorth;
		}
		if(tempY < dimensions && tempY-1 >=0 && myMap.oceanGrid[tempX][tempY-1]==4) {
			// Check distance moving south
			distSouth = Math.hypot(tempX-columbusLocation.x,tempY-1-columbusLocation.y);
			distances[3] = distSouth;
		}
		// Find the minimum value for move, stored at distances[0]
		Arrays.sort(distances);
		double minDist = 0;
		for(double temp: distances) {
			if(temp>0) {
				minDist = temp;
				break;
			}
		}
		if(minDist == distEast) {
			// Move east
			myMap.oceanGrid[tempX][tempY] = 4;
			myMap.oceanGrid[tempX+1][tempY] = 2;
			setPirateLoc(new Point(tempX+1,tempY));
		}
		else if(minDist == distWest) {
			// Move west
			myMap.oceanGrid[tempX][tempY] = 4;
			myMap.oceanGrid[tempX-1][tempY] = 2;
			setPirateLoc(new Point(tempX-1,tempY));
		}
		else if(minDist == distNorth) {
			// Move north
			myMap.oceanGrid[tempX][tempY] = 4;
			myMap.oceanGrid[tempX][tempY+1] = 2;
			setPirateLoc(new Point(tempX,tempY+1));
		}
		else if(minDist == distSouth) {
			// Move south
			myMap.oceanGrid[tempX][tempY] = 4;
			myMap.oceanGrid[tempX][tempY-1] = 2;
			setPirateLoc(new Point(tempX,tempY-1));
		}
	}
}
