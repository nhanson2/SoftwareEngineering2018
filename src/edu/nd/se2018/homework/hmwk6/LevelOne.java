package edu.nd.se2018.homework.hmwk6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class LevelOne extends Level{
	int limits = 10;
	int[][] levelGrid = new int[limits][limits];
	Tiles myTiles = new Tiles();
	
	public void initLevel() {
		for(int x = 0; x < limits; x++) {
			for(int y = 0; y< limits; y++) {
				levelGrid[x][y] = 1;
			}
		}
		this.levelGrid[2][2] = 2;
		this.levelGrid[8][4] = 2;
		this.levelGrid[6][8] = 3;
	}
	
	// Enumeration for level items
	/* 1 = blank tile
	 * 2 = chip
	 * 3 = key
	 * 4 = chip item
	 * 5 = key wall
	 * 6 = portal
	 */
	public void drawLevel(ObservableList<Node> root) {
		for(int x = 0; x < limits; x++) {
			for(int y = 0; y< limits; y++) {
				if(x == 0 || y==0 || y==(limits-1) || x==(limits-1)) {
					ImageView wall = new ImageView(myTiles.wall);
					wall.setX(x*50);
					wall.setY(y*50);
					root.add(wall);
				}
				else if(levelGrid[x][y]==1) {
					// Add the blank tile
					ImageView blank = new ImageView(myTiles.blankTile);
					blank.setX(x*50);
					blank.setY(y*50);
					root.add(blank);
				}
				else if(levelGrid[x][y]==2) {
					// Add the chips
					ImageView chipSet = new ImageView(myTiles.chipItem);
					chipSet.setX(x*50);
					chipSet.setY(y*50);
					root.add(chipSet);
				}
				else if(levelGrid[x][y]==3) {
					ImageView key = new ImageView(myTiles.greenKey);
					key.setX(x*50);
					key.setY(y*50);
					root.add(key);
				}
			}
		}
	}
}
