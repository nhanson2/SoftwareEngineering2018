package edu.nd.se2018.homework.hwk4;

import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

/**
 * @author Nathaniel Hanson
 * Date: 9/17/2018
 * OceanExplorer.java
 * Framework for JavaFX Application (Ocean Explorer)
 */

// Ocean Explorer Game
public class OceanExplorer extends Application{
	boolean gameOver = false;
	final private int scale = 25;  
	Scene scene;
    Pane root;
    Point targetPoint;
    OceanMap map;
    Ship ship;
    Image shipImage;
    Image pirateImage;
    ImageView shipImageView;
    ImageView[] pirateImageView = new ImageView[2];
    PirateShip [] pirates;
    
    // Make new start method
    @Override
	public void start(Stage oceanStage) throws Exception {
    	// Initialize Game Window
		root = new AnchorPane();  
		scene = new Scene(root,scale*10,scale*10);
		oceanStage.setTitle("Ocean Explorer!");
		oceanStage.setScene(scene);
		// Initialize Map/Ship
		map = new OceanMap(this);
		ship = new Ship(map);
		map.makeIslands(ship.getLoc());
		map.makePirates(ship.getLoc());
		map.drawMap(root.getChildren(), scale, ship.getLoc());
		shipImage = new Image("file:///C:/Users/Nathaniel/Pictures/ColumbusShip.png",scale,scale,true,true);
		pirateImage = new Image("file:///C:/Users/Nathaniel/Pictures/pirateship.gif",scale,scale,true,true);
		pirates = map.myPirates;
		// Add pirate ships to map and create observer objects
		for(int i=0;i<2;i++) {
			ship.addObserver(pirates[i]);
			ImageView temp = new ImageView(pirateImage);
			temp.setX(map.pirateArr[i].getX()*scale);
			temp.setY(map.pirateArr[i].getY()*scale);
			root.getChildren().add(temp);
			pirateImageView[i] = temp;
		}
		// Add the ship to the map
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getLoc().x*scale);
		shipImageView.setY(ship.getLoc().y*scale);
		root.getChildren().add(shipImageView);
		oceanStage.show();
		// Start play
		startGame();
	}
    // Start Game Methodology
    private void startGame(){
    	// Create a keypressed handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
        @Override
    	public void handle(KeyEvent ke) {
    		if(!gameOver)
    		// Delegate movement decisions and actions to the seeker
    			switch(ke.getCode()){
    				case RIGHT:
    					ship.goEast();
    					break;
    				case LEFT:
    					ship.goWest();
    					break;
    				case DOWN:
    					ship.goSouth();
    					break;
    				case UP:
    					ship.goNorth();
    					break;
    				default:
    					break;	
    			}
    			shipImageView.setX(ship.getLoc().x*scale);
    			shipImageView.setY(ship.getLoc().y*scale);
    		}						
        });
    }
    // Update the pirate ship views
    public void updatePirates() {
    	for(int i=0;i<2;i++) {
    		pirateImageView[i].setX(pirates[i].getPirateLoc().x*scale);
    		pirateImageView[i].setY(pirates[i].getPirateLoc().y*scale);
    	}	
    }
    // Return the scene
    public Scene getScene(){
    	return scene;
    }
    // Main functionality
    public static void main(String[] args) {
     	launch(args);
    }
}