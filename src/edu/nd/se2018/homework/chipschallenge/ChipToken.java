package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Nathaniel Hanson
 * Date: 10/18/2018
 * LevelOne.java
 * Chips object for chip challenge game
 */
public class ChipToken {
	boolean displayed = true;
	Point coordinates;
	ImageView tokenView;
	Level myMap;
	public ChipToken(Level map,ImageView pic, Point coord) {
		myMap = map;
		tokenView = pic;
		coordinates = coord;
	}
	public Point getLoc() {
		return this.coordinates;
	}
	public void setPosition(int x, int y) {
		this.coordinates = new Point(x,y);
	};
	public void setImage(Image newImg) {
		tokenView.setImage(newImg);
	}
	public void hide() {
		Tiles myTiles = new Tiles();
		ImageView temp = new ImageView(myTiles.blankTile);
		temp.setX(coordinates.x*20);
		temp.setY(coordinates.y*20);
		this.tokenView = temp;
		displayed = false;
	}
}
