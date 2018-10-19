package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * @author Nathaniel Hanson
 * Date: 10/2/2018
 * Level.java
 * Provides implementation for initializing level in ChipChallenge
 */

public abstract class Level {
	// Enumeration for level items
	/* 1 = blank tile
	 * 2 = chip
	 * 3 = key
	 * 4 = chip item
	 * 5 = key wall
	 * 6 = portal
	 */
	int[][] levelGrid;
	// Add map to the stage
	public void drawLevel(ObservableList<Node> root) {}
	public boolean getStatus() {return false;}
	public int updateLevel(Point coordinates, ObservableList<Node> observableList) { return 0;}
}