package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class LevelOne extends Level{
	int limits = 25;
	int[][] levelGrid = new int[limits][limits];
	Tiles myTiles = new Tiles();
    ChipMan chip;
    HashMap<Point,ChipToken> tokens = new HashMap<Point, ChipToken>();
    Gate myGate;
    Portal myPortal;
    int chipCount = 0;
    boolean gameOver = false;
    
    @Override
    public boolean getStatus() {
    	return this.gameOver;
    }
	public void initLevel(String fileName) {
		try {
			readLevel(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	public void readLevel(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
		while(sc.hasNextLine()) {
			for (int i=0; i<limits; i++) {
				String[] line = sc.nextLine().trim().split(" ");
				for (int j=0; j<line.length; j++) {
					levelGrid[j][i] = Integer.parseInt(line[j]);
		         }
			}
		}
		sc.close();
	}
	public int updateLevel(Point coordinates,ObservableList<Node> root) {
		if(levelGrid[coordinates.x][coordinates.y]==2) {
			ChipToken temp = tokens.get(coordinates);
			root.remove(temp.tokenView);
			temp.hide();
			tokens.put(coordinates,temp);
			ImageView temp2 = new ImageView(myTiles.blankTile);
			temp2.setX(coordinates.x*20);
			temp2.setY(coordinates.y*20);
			root.add(0,temp2);
			levelGrid[coordinates.x][coordinates.y]=1;
			chipCount--;
			if(chipCount==0) {
				myGate.hide();
				levelGrid[myGate.getLoc().x][myGate.getLoc().y] = 1;
				levelGrid[myPortal.getLoc().x][myPortal.getLoc().y] = 1;
			}
		}
		if(coordinates.equals(myPortal.getLoc())) {
			return 1;
		}
		return 0;
	}
	public void drawLevel(ObservableList<Node> root) {
		for(int x = 0; x < limits; x++) {
			for(int y = 0; y< limits; y++) {
				if(levelGrid[x][y]==5) {
					ImageView wall = new ImageView(myTiles.wall);
					wall.setX(x*20);
					wall.setY(y*20);
					root.add(wall);
					levelGrid[x][y]=5;
				}
				else if(levelGrid[x][y]==1) {
					// Add the blank tile
					ImageView blank = new ImageView(myTiles.blankTile);
					blank.setX(x*20);
					blank.setY(y*20);
					root.add(blank);
				}
				else if(levelGrid[x][y]==2) {
					// Add the chips
					ImageView chipSet = new ImageView(myTiles.chipItem);
					chipSet.setX(x*20);
					chipSet.setY(y*20);
					tokens.put(new Point(x,y),new ChipToken(this,chipSet,new Point(x,y)));
					root.add(chipSet);
					chipCount++;
				}
				else if(levelGrid[x][y]==7) {
					// Add token gate
					ImageView tokenGate = new ImageView(myTiles.tokenGate);
					tokenGate.setX(x*20);
					tokenGate.setY(y*20);
					myGate = new Gate(this,tokenGate, new Point(x,y));
					root.add(tokenGate);
				}
				else if(levelGrid[x][y]==9) {
					// Add portal
					ImageView portal = new ImageView(myTiles.portal);
					portal.setX(x*20);
					portal.setY(y*20);
					myPortal = new Portal(this,portal,new Point(x,y));
					root.add(portal);
				}
			}
		}
		myGate.addObserver(myPortal);
	}
}
