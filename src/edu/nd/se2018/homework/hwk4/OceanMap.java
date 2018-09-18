package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Nathaniel Hanson
 * Date: 9/17/2018
 * OceanMap.java
 * Provides implementation for initializing map
 */

public class OceanMap {
	final int dimensions = 25;
	final int limits = 10;
	final int islandCount = 10;
	OceanExplorer myGame;
	int[][] oceanGrid = new int[limits][limits];
	/* 1 = our ship
	 * 2 = pirate ship
	 * 3 = island
	 * 4 = open water
	 */
	HashSet<Point> islands;
	HashSet<Point> pirates;
	Point pirateArr[] = new Point[2];
	PirateShip myPirates[] = new PirateShip[2];
	OceanMap(OceanExplorer game) {
		myGame = game;
	}
	// Make islands at random locations
	public void makeIslands(Point myShip) {
		islands = new HashSet<Point>();
		pirates = new HashSet<Point>();
		// Generate 10 islands
		int icount = 0;
		while(icount < 10) {
			int randX = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			int randY = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			Point temp = new Point(randX,randY);
			if(!islands.contains(temp) && !temp.equals(myShip)) {
				islands.add(temp);
				icount++;
			}
		}
	}
	// Create pirate ships at random location
	public void makePirates(Point myShip) {
		pirates = new HashSet<Point>();
		// Generate 2 Islands
		int pcount = 0;
		while(pcount < 2) {
			int randX = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			int randY = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			Point temp = new Point(randX,randY);
			if(!islands.contains(temp) && !temp.equals(myShip) && !pirates.contains(temp)) {
				pirates.add(temp);
				pirateArr[pcount] = temp;
				myPirates[pcount] = new PirateShip(this,temp,myGame,limits);
				pcount++;
			}
		}
	}
	// Add map to the stage
	public void drawMap(ObservableList<Node> root, int scale, Point myShip) {
		for(int x = 0; x < limits; x++) {
			for(int y = 0; y< limits; y++) {
				// Make an initial rect to add to the map
				// Case 1: We're at the our boat
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				Point temp = new Point(x,y);
				if(myShip.equals(temp)) {
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
					oceanGrid[x][y] = 1;
				}
				// Case 2: We're at an island
				else if(islands.contains(temp)) {
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.GREEN);
					root.add(rect);
					oceanGrid[x][y] = 3;
				}
				// Case 3: We're at a pirate ship
				else if(pirates.contains(temp)) {
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
					oceanGrid[x][y] = 2;
				}
				// Case 4: Open Water
				else {
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
					oceanGrid[x][y] = 4;
				}
			}
		}
	}
}