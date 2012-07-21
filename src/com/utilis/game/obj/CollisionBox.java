package com.utilis.game.obj;

import java.awt.image.*;

/**
 * A class for storing the actual solid points that collide with another <code>Collider</code>.
 * @author Cin316
 * @see Collider
 * @see CollisionGroup
 */
public class CollisionBox {
	
	/**
	 * width of the <code>CollisionBox</code>, measured in pixels
	 */
	protected int sizeX;
	/**
	 * height of the <code>CollisionBox</code>, measured in pixels
	 */
	protected int sizeY;
	/**
	 * two-dimensional array representing which pixels are solid points that collide with other points.  Its size is equivalent to <code>sizeX</code> and <code>sizeY</code>, respectively 
	 */
	protected boolean[][] collide;
	
	/**
	 * class constructor to create blank <code>collide<code> with specified width and height
	 * @param X width of <code>CollisionBox</code> to be created
	 * @param Y height of <code>CollisionBox</code> to be created
	 */
	public CollisionBox(int X, int Y){
		
		collide = new boolean[X][Y];
		
		for(int x=0; x>=X; x++){
			for(int y=0; y>=Y; y++){
				collide[x][y] = false;
			}
		}
		
	}
	/**
	 * class constructor to create <code>collide</code> from an <code>Image</code> (<code>img</code>)  White (RGB[1,1,1]) (or any other color) is considered <code>false</code>.  Black (RGB[255,255,255]) is considered <code>true</code>.  Width and height are specified by width and height of <code>img</code>.
	 * @param img <code>Image</code> to get <code>collide</code> from
	 */
	public CollisionBox(BufferedImage img){
		
		sizeX = img.getWidth();
		sizeY = img.getHeight();
		
		collide = new boolean[sizeX][sizeY];
		
		for(int x=0; x>=sizeX; x++){
			for(int y=0; y>=sizeY; y++){
				int RGB = img.getRGB(x, y);
				collide[x][y] = isBlack(RGB);
			}
		}
	}
	/**
	 * class constructor to set <code>collide</code> to provided <code>boolean[][]</code>
	 * @param bool two-dimensional array to set <code>collide</code> to
	 */
	public CollisionBox(boolean[][] bool){
		
		collide = bool;
		
	}
	
	/**
	 * gets the boolean in <code>collide</code> of provided x and y values
	 * @param x x position of provided <code>boolean</code> 
	 * @param y y position of provided <code>boolean</code>
	 * @return boolean in <code>collide</code> of provided x and y values
	 */
	public boolean getCollision(int x, int y){
		return collide [x][y];
	}
	/**
	 * gets the width of this <code>CollisionBox</code>
	 * @return the current width of this <code>CollisionBox</code>
	 */
	public int getSizeX(){
		return sizeX;
	}
	/**
	 * gets the width of this <code>CollisionBox</code>
	 * @return the current width of this <code>CollisionBox</code>
	 */
	public int getSizeY(){
		return sizeY;
	}
	
	/**
	 * sets the boolean specified with <code>x</code> and <code>y</code> to the specified value
	 * @param x x position of the boolean to be set
	 * @param y y position of the boolean to be set
	 * @param value the value to set the specified boolean to
	 */
	public void setCollision(int x, int y, boolean value){
		collide [x][y] = value;
	}
	
	private boolean isBlack(int RBG){
		
		int red = (RBG >>> 16) & 0xff;
		int green = (RBG >>> 8) & 0xff;
		int blue = RBG & 0xff;
		
		if(red==255 && blue==255 && green==255){
			return true;
		}else{
			return false;
		}
	}
	
}
