package edu.nd.se2018.homework.hmwk6;

	import java.awt.Point;

import edu.nd.se2018.homework.hwk4.OceanExplorer;
import edu.nd.se2018.homework.hwk4.OceanMap;
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
public class ChipsChallenge extends Application{
		boolean gameOver = false;
		final private int scale = 50;  
		Scene scene;
	    Pane root;
	    LevelOne map;
	    Stage myStage;
	    Tiles myTiles = new Tiles();
	    ChipMan chip;
	    ImageView chipImageView;
	    // Make new start method
	    @Override
		public void start(Stage stage) throws Exception {
	    	// Initialize Game Window
			root = new AnchorPane();  
			scene = new Scene(root,500,500);
			myStage = stage;
			myStage.setScene(scene);
			myStage.setTitle("Chip's Challenge!");
			map = new LevelOne();
			map.initLevel();
			map.drawLevel(root.getChildren());
			// Create a moveable chip and add him to the game
			chipImageView = new ImageView(myTiles.chipDown);
			chip = new ChipMan(map,10,chipImageView,scale);
			root.getChildren().add(chip.chipView);
			// Start play
			myStage.show();
			startGame();
		}
	    // Start Game Methodology
	    private void startGame(){
	    	// Create a keypressed handler
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	        @Override
	    	public void handle(KeyEvent ke) {
	    		if(!gameOver) {
	    		// Delegate movement decisions and actions to the seeker
	    			switch(ke.getCode()){
	    				case RIGHT:
	    					System.out.println("RIGHT");
	    					chip.setImage(myTiles.chipRight);
	    					chip.moveRight();
	    					break;
	    				case LEFT:
	    					System.out.println("LEFT");
	    					chip.setImage(myTiles.chipLeft);
	    					chip.moveLeft();
	    					break;
	    				case DOWN:
	    					System.out.println("DOWN");
	    					chip.setImage(myTiles.chipDown);
	    					chip.moveDown();
	    					break;
	    				case UP:
	    					System.out.println("UP");
	    					chip.setImage(myTiles.chipUp);
	    					chip.moveUp();
	    					break;
	    				case ESCAPE:
	    					System.out.println("Exiting");
	    					myStage.close();
	    				default:
	    					break;	
	    				}
	    			}
    			//chipImageView.setX(chip.getLoc().x*scale);
    			//chipImageView.setY(chip.getLoc().y*scale);
	        	}
	        });
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
