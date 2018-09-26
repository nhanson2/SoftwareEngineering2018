package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Random;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private double speed = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private Direction dir;
	private Random rand = new Random();
	
	public Train(int x, int y, Direction way){
		this.currentX = x;
		this.currentY = y;
		this.dir = way;
		this.speed = this.rand.nextInt(3-1)+1;
		originalX = x;
		img = new Image("images\\Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
		if(this.dir==Direction.EAST) {
			imgView.setScaleX(-1);
		}
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public Direction getDirection() {
		return dir;
	}
	public void redefineSpeed() {
		this.speed = this.rand.nextInt(3-1)+1;
	}
	
	public void move(boolean x){
		if(this.dir == Direction.WEST) {
			currentX-=this.speed;
		}
		if(this.dir == Direction.EAST) {
			currentX+=this.speed;
		}
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX < -200 || currentX > 1400)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
		redefineSpeed();
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}