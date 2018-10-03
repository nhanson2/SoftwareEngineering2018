package edu.nd.se2018.homework.hmwk6;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.homework.hwk4.OceanMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ChipMan extends Observable implements MovingObject{
	Point coordinates;
	int dimensions;
	int scale = 50;
	Level myMap;
	ImageView chipView;
	public ChipMan(Level map,int dimension, ImageView pic, int scale) {
		// Start Chip in the center of the game
		dimensions = dimension;
		coordinates = new Point(dimensions/2,dimensions/2);
		myMap = map;
		chipView = pic;
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
	}
	public void moveLeft() {
		coordinates.setLocation(coordinates.x-1, coordinates.y);
		//myMap.levelGrid[coordinates.x][coordinates.y] = 1;
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		setChanged();
		notifyObservers(coordinates);
	}
	public void moveRight() {
		coordinates.setLocation(coordinates.x+1, coordinates.y);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		//myMap.levelGrid[coordinates.x][coordinates.y] = 1;
		//setChanged();
		//notifyObservers(coordinates);
	};
	public void moveUp() {
		coordinates.setLocation(coordinates.x, coordinates.y-1);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		//myMap.levelGrid[coordinates.x][coordinates.y] = 1;
		setChanged();
		notifyObservers(coordinates);
	};
	public void moveDown() {
		coordinates.setLocation(coordinates.x, coordinates.y+1);
		chipView.setX(this.getLoc().x*scale);
		chipView.setY(this.getLoc().y*scale);
		//myMap.levelGrid[coordinates.x][coordinates.y] = 1;
		setChanged();
		notifyObservers(coordinates);
	};
	public void setPosition(int x, int y) {
		this.coordinates = new Point(x,y);
	};
	public Point getLoc() {
		return this.coordinates;
	}
	public void setImage(Image newImg) {
		chipView.setImage(newImg);
	}
}
