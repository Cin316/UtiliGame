package com.utilis.game.gui;

import javax.swing.*;

import com.utilis.game.obj.*;

import java.awt.*;

/**
 * A class for managing a Canvas.
 * @author Cin316
 * @see Canvas
 */
public class Window extends JFrame {
	
	/**
	 * the number of pixels wide the <code>Tiles</code> in this <code>Window</code> are
	 */
	protected int tileWidth;
	/**
	 * the number of pixels high the <code>Tiles</code> in this <code>Window</code> are
	 */
	protected int tileHeight;
	/**
	 * the number of <code>Tiles</code> wide this <code>Window</code> is
	 */
	protected int tilesNumX;
	/**
	 * the number of <code>Tiles</code> high this <code>Window</code> is
	 */
	protected int tilesNumY;
	
	/**
	 * the <code>Canvas</code> in this <code>Window</code>
	 */
	protected Canvas canvas;
	
	/**
	 * Class constructor with default <code>Canvas</code>.
	 * @param xTiles the number of <code>Tiles</code> wide this <code>Window</code> is
	 * @param yTiles the number of <code>Tiles</code> high this <code>Window</code> is
	 * @param tWidth the width of the <code>Tiles</code> in this <code>Window</code>
	 * @param tHeight the height of the <code>Tiles</code> in this <code>Window</code>
	 */
	public Window(int xTiles, int yTiles, int tWidth, int tHeight){
		
		tilesNumX = xTiles;
		tilesNumY = yTiles;
		tileWidth = tWidth;
		tileHeight = tHeight;
		
		canvas = new Canvas(xTiles, yTiles, tWidth, tHeight);
		this.setContentPane(canvas);
		
		this.setSize(tilesNumX*tileWidth, (22)+ tilesNumY*tileHeight); //22 is height offset.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * Class constructor which creates <code>Canvas</code> and values from specified <code>Canvas</code>.
	 * @param c <code>Canvas</code> to use to set values to.
	 */
	public Window(Canvas c){
		
		tilesNumX = c.getTilesNumX();
		tilesNumY = c.getTilesNumY();
		tileWidth = c.getTileWidth();
		tileHeight = c.getTileHeight();
		
		canvas = c;
		this.setContentPane(canvas);
		
		this.setSize(tilesNumX*tileWidth, (22)+ tilesNumY*tileHeight); //22 is height offset.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * gets the <code>Canvas</code> in this <code>Window</code>
	 * @return the current value of the <code>Canvas</code>
	 */
	public Canvas getCanvas(){
		return canvas;
	}
	
	/**
	 * gets the width of the <code>Tiles</code>, measured in pixels
	 * @return the current width of the <code>Tiles</code>
	 */
	public int getTileWidth() {
		return tileWidth;
	}
	/**
	 * gets the height of the <code>Tiles</code>, measured in pixels
	 * @return the current height of the <code>Tiles</code>
	 */
	public int getTileHeight() {
		return tileHeight;
	}
	/**
	 * gets the number of <code>Tiles</code> wide this <code>Window</code> is
	 * @return the current number of <code>Tiles</code> wide this <code>Window</code> is
	 */
	public int getTilesNumX() {
		return tilesNumX;
	}
	/**
	 * gets the number of <code>Tiles</code> high this <code>Window</code> is
	 * @return the current number of <code>Tiles</code> high this <code>Window</code> is
	 */
	public int getTilesNumY() {
		return tilesNumY;
	}
	
	/**
	 * sets the width of the <code>Tiles</code> to the specified value
	 * @param tileWidth the value to set the width of the <code>Tiles</code> to
	 */
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
		canvas.setTileWidth(tileWidth);//ass to other set methods.
	}
	/**
	 * sets the height of the <code>Tiles</code> to the specified value
	 * @param tileHeight the value to set the height of the <code>Tiles</code> to
	 */
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	/**
	 * sets the number of <code>Tiles</code> wide this <code>Window</code> is to the specified value
	 * @param tilesNumX the value to set the the number of <code>Tiles</code> wide this <code>Window</code> is to
	 */
	public void setTilesNumX(int tilesNumX) {
		this.tilesNumX = tilesNumX;
	}
	/**
	 * sets the number of <code>Tiles</code> high this <code>Window</code> is to the specified value
	 * @param tilesNumY the value to set the the number of <code>Tiles</code> high this <code>Window</code> is to
	 */
	public void setTilesNumY(int tilesNumY) {
		this.tilesNumY = tilesNumY;
	}
	
}
