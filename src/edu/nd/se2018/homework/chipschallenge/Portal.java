package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Nathaniel Hanson
 * Date: 10/18/2018
 * Portal.java
 * End of game portals in game
 */
public class Portal implements Observer{
	boolean displayed = true;
	boolean walkable = false;
	Point coordinates;
	ImageView gateView;
	Level myMap;
	public Portal(Level map,ImageView pic, Point coord) {
		myMap = map;
		gateView = pic;
		coordinates = coord;
	}
	public Point getLoc() {
		return this.coordinates;
	}
	public void setPosition(int x, int y) {
		this.coordinates = new Point(x,y);
	};
	public void setImage(Image newImg) {
		gateView.setImage(newImg);
	}
	public void hide() {
		Tiles myTiles = new Tiles();
		ImageView temp = new ImageView(myTiles.tokenGate);
		temp.setX(coordinates.x*20);
		temp.setY(coordinates.y*20);
		this.gateView = temp;
		displayed = false;
	}
	@Override
	public void update(Observable o, Object arg1) {
		if(o instanceof Gate) {
			walkable = !(boolean)arg1;
		}	
	}

}
