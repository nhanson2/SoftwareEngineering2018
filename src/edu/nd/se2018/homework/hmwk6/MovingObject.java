package edu.nd.se2018.homework.hmwk6;

import java.awt.Point;

public interface MovingObject {
	public void moveLeft();
	public void moveRight();
	public void moveUp();
	public void moveDown();
	public void setPosition(int x,int y);
	public Point getLoc();
}
