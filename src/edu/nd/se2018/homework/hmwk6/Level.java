package edu.nd.se2018.homework.hmwk6;

import java.awt.Point;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
}