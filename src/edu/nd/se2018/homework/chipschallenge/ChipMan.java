package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ChipMan extends Observable implements MovingObject{
	Point coordinates;
	int dimensions;
	int scale = 20;
	Level myMap;
	ImageView chipView;
	private static ChipMan chipInstance = null;
	ChipMan(Level map,int dimension, ImageView pic, int scale) {
		// Start Chip in the center of the game
		dimensions = dimension;
		coordinates = new Point(dimensions/2,dimensions/2);
		myMap = map;
		chipView = pic;
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
	}
	public static ChipMan ChipMan(Level map,int dimension, ImageView pic, int scale) {
		if(chipInstance == null) {
			chipInstance = new ChipMan(map, dimension, pic, scale);
		}
		return chipInstance;
	}
	public void moveLeft() {
		coordinates.setLocation(coordinates.x-1, coordinates.y);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	}
	public void moveRight() {
		coordinates.setLocation(coordinates.x+1, coordinates.y);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	};
	public void moveUp() {
		coordinates.setLocation(coordinates.x, coordinates.y-1);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	};
	public void moveDown() {
		coordinates.setLocation(coordinates.x, coordinates.y+1);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	};
	public void setPosition(int x, int y) {
		this.coordinates = new Point(x,y);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	};
	public Point getLoc() {
		return this.coordinates;
	}
	public void setCoord(Point x) {
		coordinates = x;
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	}
	public void setImage(Image newImg) {
		chipView.setImage(newImg);
	}
	public void setMap(Level map) {
		myMap = map;
	}
}
