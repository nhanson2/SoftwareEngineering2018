package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Nathaniel Hanson
 * Date: 10/18/2018
 * JumpPad.java
 * Teleportation Pads in Chip's Challenge
 */
public class JumpPad{
	boolean displayed = true;
	Point coordinates;
	ImageView jumpView;
	Level myMap;
	JumpPad nextPad;
	public JumpPad(Level map,ImageView pic, Point coord) {
		myMap = map;
		jumpView = pic;
		coordinates = coord;
	}
	public Point getLoc() {
		return this.coordinates;
	}
	public void setPosition(int x, int y) {
		this.coordinates = new Point(x,y);
	};
	public void setImage(Image newImg) {
		jumpView.setImage(newImg);
	}
	public void hide() {
		Tiles myTiles = new Tiles();
		ImageView temp = new ImageView(myTiles.jumpPad);
		temp.setX(coordinates.x*20);
		temp.setY(coordinates.y*20);
		this.jumpView = temp;
		displayed = false;
	}
}
