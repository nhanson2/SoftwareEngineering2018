package edu.nd.se2018.homework.chipschallenge;

import javafx.scene.image.Image;

public class Tiles {
	int scale = 20;
	Image blankTile = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/BlankTile.png",scale,scale,true,true);
	Image wall = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/Wall.png",scale,scale,true,true);
	Image blueKey = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/blueKey.png",scale,scale,true,true);
	Image blueKeyWall = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/blueKeyWall.png",scale,scale,true,true);
	Image bugUp = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/bugUp.png",scale,scale,true,true);
	Image chipDown = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipDown.png",scale,scale,true,true);
	Image chipUp = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipUp.png",scale,scale,true,true);
	Image chipLeft = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipLeft.png",scale,scale,true,true);
	Image chipRight = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipRight.png",scale,scale,true,true);
	Image chipItem = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipitem.png",scale,scale,true,true);
	Image greenKey = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/greenKey.png",scale,scale,true,true);
	Image greenKeyWall = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/greenKeyWall.png",scale,scale,true,true);
	Image portal = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/portal.png",scale,scale,true,true);
	Image redKey = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/redKey.png",scale,scale,true,true);
	Image redKeyWall = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/redKeyWall.png",scale,scale,true,true);
	Image tokenGate = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/tokenGate.png",scale,scale,true,true);
	Image water = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/water.png",scale,scale,true,true);
	Image jumpPad = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/jumpPad.png",scale,scale,true,true);
	Image chipDrown = new Image("file:///C:/Users/Nathaniel/git/SoftwareEngineering2018/src/chip/textures/chipDrown.png",scale,scale,true,true);
}
// Enumeration for level items
/* 1 = blank tile
 * 2 = chip
 * 3 = green key
 * 4 = green key wall
 * 5 = red key
 * 6 = red key wall
 * 7 = blue key
 * 8 = blue key wall
 * 9 = portal
 * 0 = jump pad
 */