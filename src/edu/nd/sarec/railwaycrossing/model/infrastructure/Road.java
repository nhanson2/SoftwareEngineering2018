package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import edu.nd.sarec.railwaycrossing.model.vehicles.CarFactory;

/**
 * Represents a single road
 * @author jane
 * Nathaniel Hanson
 *
 */
public class Road extends Observable implements Observer{
	private int startX;
	private int endX;
	private int startY;
	private int endY;
	private CarFactory carFactory;
	//Added variable to keep track of cars currently on road
	private ArrayList<Car> cars = new ArrayList<Car>();
	Direction direction;
	Collection<CrossingGate> gates;
	boolean clearEnds = false;
	boolean turnAllowed = true;
	int roadSize;
	
	public Road(){}
	
	public Road(Point start, Point end, Direction direction, boolean buildCarFactory, boolean clearEnds){
		startX = start.x;
		startY = start.y;
		endX = end.x;
		endY = end.y;
		roadSize = 18;
		
		this.direction = direction;
		gates = new Vector<CrossingGate>();
		this.clearEnds = clearEnds;
		
	}
	
	// Adds a gate to a road
	// In case a new gate is added after the factory is assigned, we reassign factory
	// The factory needs to know all gates on the road in order to register each car as an observer.
	public void assignGate(CrossingGate gate){
		gates.add(gate);
		if (carFactory != null)
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates);  // allows additional gates.  Needs fixing
	}
	
	public void addCarFactory(){
		if (carFactory == null) // We only allow one
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates);
	}
	
	public CarFactory getCarFactory(){
		return carFactory;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getEndX(){
		return endX;
	}
	
	public int getStartY(){
		return startY;
	}
	
	public int getEndY(){
		return endY;
	} 
	
	public Direction getDirection(){
		return direction;
	}
	
	public boolean getClearEnds(){
		return clearEnds;
	}
	
	public int getRoadWidth(){
		return roadSize;
	}
	public void addCar(Car temp) {
		cars.add(temp);
	}
	@Override
	public void update(Observable o, Object arg1) {
		// This crossing gate has been opened or closed so we must update the car factory
		if (o instanceof CrossingGate){
			if(!((CrossingGate)o).canTurn()) {
				carFactory.setTurn(true);
			}
			else {
				carFactory.setTurn(false);
			}
			
		}	
	}
}