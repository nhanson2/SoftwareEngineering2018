 package edu.nd.se2018.homework.chipschallenge;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

	/**
	 * @author Nathaniel Hanson
	 * Date: 10/18/2018
	 * ChipsChallenge.java
	 * Framework for JavaFX Application (ChipsChallenge)
	 */

// Ocean Explorer Game
public class ChipsChallenge extends Application{
		boolean gameOver = false;
		final private int scale = 20;  
		Scene scene;
	    Pane root;
	    LevelOne map;
	    LevelTwo mapTwo;
	    Level currMap;
	    Stage myStage;
	    Tiles myTiles = new Tiles();
	    ChipMan chip;
	    ImageView chipImageView;
	    int currLevel = 1;
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
			map.initLevel("C:\\Users\\Nathaniel\\git\\SoftwareEngineering2018\\src\\edu\\nd\\se2018\\homework\\chipschallenge\\level_one");
			map.drawLevel(root.getChildren());
			// Create a moveable chip and add him to the game
			chipImageView = new ImageView(myTiles.chipDown);
			chip = new ChipMan(map,25,chipImageView,scale);
			root.getChildren().add(chip.chipView);
			// Start play
			myStage.show();
			// Set Level One to current Map
			startGame();
		}
	    public void nextLevel() {
	    	root.getChildren().clear();
	    	mapTwo = new LevelTwo();
	    	mapTwo.initLevel("C:\\Users\\Nathaniel\\git\\SoftwareEngineering2018\\src\\edu\\nd\\se2018\\chipschallenge\\hmwk6\\level_two");
	    	mapTwo.drawLevel(root.getChildren());
	    	chip.setMap(mapTwo);
	    	mapTwo.addChip(chip);
	    	root.getChildren().add(chip.chipView);
	    	currMap = mapTwo;
	    	startLevelTwo();
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
	    					chip.setImage(myTiles.chipRight);
	    					if(map.levelGrid[chip.coordinates.x+1][chip.coordinates.y]<5)
	    						chip.moveRight();
	    					break;
	    				case LEFT:
	    					chip.setImage(myTiles.chipLeft);
	    					if(map.levelGrid[chip.coordinates.x-1][chip.coordinates.y]<5)
	    						chip.moveLeft();
	    					break;
	    				case DOWN:
	    					chip.setImage(myTiles.chipDown);
	    					if(map.levelGrid[chip.coordinates.x][chip.coordinates.y+1]<5)
	    						chip.moveDown();
	    					break;
	    				case UP:
	    					chip.setImage(myTiles.chipUp);
	    					if(map.levelGrid[chip.coordinates.x][chip.coordinates.y-1]<5)
	    						chip.moveUp();
	    					break;
	    				case ESCAPE:
	    					myStage.close();
	    				default:
	    					break;	
	    				}
	    			if(map.updateLevel(chip.coordinates, root.getChildren())==1) {
	    				// Start Level 2 Here
	    				nextLevel();
	    			}
	    			}
	        	}
	        });
	    }
	    private void startLevelTwo(){
	    	// Create a keypressed handler
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	        @Override
	    	public void handle(KeyEvent ke) {
	    		// Delegate movement decisions and actions to the seeker
	    		switch(ke.getCode()){
	    			case RIGHT:
	    				chip.setImage(myTiles.chipRight);
	    				if(mapTwo.levelGrid[chip.coordinates.x+1][chip.coordinates.y]<5 && !gameOver)
	    					chip.moveRight();
	    				break;
	    			case LEFT:
	    				chip.setImage(myTiles.chipLeft);
	    				if(mapTwo.levelGrid[chip.coordinates.x-1][chip.coordinates.y]<5 && !gameOver)
	    					chip.moveLeft();
	   					break;
	   				case DOWN:
	   					chip.setImage(myTiles.chipDown);
	   					if(mapTwo.levelGrid[chip.coordinates.x][chip.coordinates.y+1]<5 && !gameOver)
    						chip.moveDown();
	   					break;
	    			case UP:
	    				chip.setImage(myTiles.chipUp);
	    				if(mapTwo.levelGrid[chip.coordinates.x][chip.coordinates.y-1]<5 && !gameOver)
	    					chip.moveUp();
	   					break;
	   				case ESCAPE:
	   					myStage.close();
	    			default:
	    				break;	
	    				}
	    			if(mapTwo.updateLevel(chip.coordinates, root.getChildren())==1) {
	    				gameOverScreen(true);
	    			}
	    			else if(mapTwo.updateLevel(chip.coordinates, root.getChildren())==3){
	    				chip.setImage(myTiles.chipDrown);
	    				gameOverScreen(false);
	    			}
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
	    public void gameOverScreen(boolean good) {
	    	gameOver = true;
	    	Text t = new Text();
	    	if(!good) {
	    		t.setText("GAME OVER!");
	    		t.setFill(Color.RED);
		    	t.setX(150);
		    	t.setY(150);
	    	}
	    	else {
	    		t.setText("\tYOU WON\nThanks for playing!");
	    		t.setFill(Color.BLUE);
		    	t.setX(100);
		    	t.setY(150);
	    	}
	    	t.setFont(Font.font(null, FontWeight.BOLD, 36));
	    	root.getChildren().add(t);
	    }
}
