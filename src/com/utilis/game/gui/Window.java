package com.utilis.game.gui;


import javax.swing.*;

import com.utilis.game.obj.*;

import java.awt.*;

public class Window extends JFrame {
	
	
	protected int tileWidth, tileHeight;
	protected int tilesNumX, tilesNumY;
	
	protected Canvas canvas;
	
	public Window(int xTiles, int yTiles, int tWidth, int tHeight){
		
		tilesNumX = xTiles;
		tilesNumY = yTiles;
		tileWidth = tWidth;
		tileHeight = tHeight;
		
		canvas = new Canvas(xTiles, yTiles, tWidth, tHeight);
		this.add(canvas);
		
		this.setSize(tilesNumX*tileWidth, (22)+ tilesNumY*tileHeight); //22 is height offset.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}

	public int getTileWidth() {
		return tileWidth;
	}
	public int getTileHeight() {
		return tileHeight;
	}
	public int getTilesNumX() {
		return tilesNumX;
	}
	public int getTilesNumY() {
		return tilesNumY;
	}
	
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	public void setTilesNumX(int tilesNumX) {
		this.tilesNumX = tilesNumX;
	}
	public void setTilesNumY(int tilesNumY) {
		this.tilesNumY = tilesNumY;
	}
	
}
