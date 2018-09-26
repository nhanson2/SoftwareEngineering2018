package edu.nd.sarec.railwaycrossing.model.infrastructure.gate;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossing.model.vehicles.Train;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Context class for Crossing Gate
 * @author jane
 *
 */
public class CrossingGate extends Observable implements Observer{
	
	// Crossing Gate location and its trigger & exit points
	private int anchorX;
	private int anchorY;
	private int movingX;
	private int movingY;
	private int triggerPoint;
	private int triggerPointTwo;
	private int exitPoint;
	private int exitPointTwo;

	private IGateState gateClosed;
	private IGateState gateOpen;
	private IGateState gateClosing;
	private IGateState gateOpening;
	private IGateState currentGateState;
	private Line line; 
	// East-bound Train
	private boolean trainOne;
	// West-bound Train
	private boolean trainTwo;
	String gateName;
	boolean isOpen = true;
	
	public CrossingGate(){}
	
	public CrossingGate(int xPosition, int yPosition, String crossingGate){		
		anchorX = xPosition;
		anchorY = yPosition;
		movingX = anchorX;
		movingY = anchorY-60;
		triggerPoint = anchorX+250;
		triggerPointTwo = anchorX-250;
		exitPoint = anchorX-250;
		exitPointTwo = anchorX+250;
		
		// Gate elements
		line = new Line(anchorX, anchorY,movingX,movingY);
		line.setStroke(Color.RED);
	    line.setStrokeWidth(10);
		
		// Gate States
		gateClosed = new GateClosed(this);
		gateOpen = new GateOpen(this);
		gateOpening = new GateOpening(this);
		gateClosing = new GateClosing(this);
		currentGateState = gateOpen;
		gateName = crossingGate;
		// Train Detection States
		trainOne = false;
		trainTwo = false;
	}
	
	public Line getGateLine(){
		return line;
	}
	
	public void operateGate(){
		currentGateState.operate();
	}
	
	public void close(){
		if (movingY<anchorY){		
		    movingX+=1;
		    movingY+=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		} else {
			currentGateState.gateFinishedClosing();
			isOpen = false;
			setChanged();
			notifyObservers();
		}
	}
	
	public void open(){
		if (movingX>anchorX){
			movingX-=1;
			movingY-=1;		
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		}  else {
			currentGateState.gateFinishedOpening();
			isOpen = true;
			setChanged();
			notifyObservers();
		}
	}
	
	// State getters and setters
	public IGateState getGateClosedState(){
		return gateClosed;
	}
	public IGateState getGateOpenState(){
		return gateOpen;
	}
	public IGateState getGateClosingState(){
		return gateClosing;
	}
	public IGateState getGateOpeningState(){
		return gateOpening;
	}
	
	public void setGateState(IGateState newState){
		currentGateState = newState;
		setChanged();
		notifyObservers();
	}
	
	public String getTrafficCommand(){
		return currentGateState.getTrafficAction();
	}
	
	public boolean canTurn() {
		return isOpen;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Train){
			Train train = (Train)o;
			// Add conditions for multi direction travel
			// Add variables to check if trains are within range
			if(train.getDirection()==Direction.WEST) {			
				if (train.getVehicleX() < exitPoint) {
					if(!trainOne) {
						currentGateState.leaveStation();
					}
					trainTwo = false;
				}
				else if(train.getVehicleX() < triggerPoint){
					currentGateState.approachStation();
					trainTwo = true;
				}
			}
			else if(train.getDirection()==Direction.EAST) {
				if (train.getVehicleX() > exitPointTwo) {
						if(!trainTwo) {
							currentGateState.leaveStation();
						}
						trainOne = false;
				}
				else if(train.getVehicleX() > triggerPointTwo){
					currentGateState.approachStation();
					trainOne = true;
				}			
			}
		}	
	}
}