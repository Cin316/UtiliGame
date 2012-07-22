package com.utilis.game.obj;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * A class representing an object that is locked to a grid and cannot move.
 * @author Cin316
 * @see Screen
 */
public class Tile extends Collider{
	
	/**
	 * an <code>Image</code> representing this <code>Tile</code>
	 */
	protected Image image;
	
	/**
	 * class constructor to create a blank <code>Tile</code> with the specified values.
	 * @param width the <code>width</code> of the <code>Tile</code> to be created
	 * @param height the <code>height</code> of the <code>Tile</code> to be created
	 * @param x the x position of the <code>Tile</code> to be created
	 * @param y the y position of the <code>Tile</code> to be created
	 */
	public Tile(int width, int height, int x, int y){
		this.width = width;
		this.x = x;
		this.y = y;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		collide = new CollisionBox(width, height);
		image = null;
	}
	/**
	 * class constructor to create a <code>Tile</code> with the specified values.  The <code>width</code> and <code>height</code> are provided by the <code>CollisionBox</code>.
	 * @param i <code>Image</code> to be used to create the new <code>Tile</code>
	 * @param c <code>CollisionBox</code> to be used to create the new <code>Tile</code>
	 * @param x x position of the <code>Tile</code> to be created 
	 * @param y y position of the <code>Tile</code> to be created
	 */
	public Tile(Image i, CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = i;
	}
	/**
	 * class constructor to create a <code>Tile</code> with a blank <code>Image</code> and specified values.  The <code>width</code> and <code>height</code> are provided by the <code>CollisionBox</code>.
	 * @param c <code>CollisionBox</code> to be used to create the new <code>Tile</code>
	 * @param x x position of the <code>Tile</code> to be created 
	 * @param y y position of the <code>Tile</code> to be created
	 */
	public Tile(CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = null;
	}
	
	/**
	 * gets the <code>Image</code> of this <code>Tile</code>
	 * @return the current <code>Image</code> of this <code>Tile</code>
	 */
	public Image getImage(){
		return image;
	}
	
	/**
	 * sets the <code>Image</code> of this <code>Tile</code> to the specified <code>Image</code>
	 * @param i the <code>Image</code> to set this <code>Tile</code>'s <code>Image</code> to
	 */
	public void setImage(Image i){
		image = i;
	}
	
}
