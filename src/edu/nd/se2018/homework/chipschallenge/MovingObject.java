package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

/**
 * @author Nathaniel Hanson
 * Date: 10/18/2018
 * MovingObject.java
 * Interface for moveable objects
 */
public interface MovingObject {
	public void moveLeft();
	public void moveRight();
	public void moveUp();
	public void moveDown();
	public void setPosition(int x,int y);
	public Point getLoc();
}
