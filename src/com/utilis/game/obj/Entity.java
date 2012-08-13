package com.utilis.game.obj;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * Class representing an object that is not locked to a grid and can collide with other <code>Colliders</code>
 * @author Cin316
 * @see Collider
 * @see com.utilis.game.gui.Canvas
 */
public class Entity extends Collider{
	
	/**
	 * the current <code>Image</code> to be displayed
	 */
	protected Image image;
	
	/**
	 * class constructor which creates an <code>Entity</code> with the specified width and height, a blank <code>Image</code>, and a blank <code>CollisionBox</code> 
 	 * @param w width of the <code>Entity</code> to be created
	 * @param h height of the <code>Entity</code> to be created
	 */
	public Entity(int w, int h){
		width = w;
		height = h;
		x = 0;
		y = 0;
		rect = new Rectangle(x, y, width, height);
		image = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		collide = new CollisionBox(width, height);
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>Image</code>, an <code>Image</code> equivalent to the specified <code>Image</code>, and a blank <code>CollisionBox</code>
	 * @param i <code>Image</code> to be used for creation of this <code>Entity</code> 
	 */
	public Entity(Image i){
		
		image = i;
		x = 0;
		y = 0;
		
		ImageIcon iicon = new ImageIcon(image);
		width = iicon.getIconWidth();
		height = iicon.getIconHeight();
		
		rect = new Rectangle(x, y, width, height);
		collide = new CollisionBox(width, height);
		
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>CollisionBox</code>, a blank <code>Image</code>, and a <code>CollsionBox</code> equivalent to the specified <code>CollisionBox</code>
	 * @param c <code>CollisionBox</code> to be used for creation of this <code>Entity</code>
	 */
	public Entity(CollisionBox c){
		collide = c;
		x = 0;
		y = 0;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>CollisionBox</code>, an <code>Image</code> equivalent to the specified <code>Image</code>, and a <code>CollsionBox</code> equivalent to the specified <code>CollisionBox</code>
	 * @param i <code>Image</code> to be used for creation of this <code>Entity</code>
	 * @param c <code>CollisionBox</code> to be used for creation of this <code>Entity</code>
	 */
	public Entity(Image i, CollisionBox c){
		collide = c;
		x = 0;
		y = 0;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = i;
	}
	
	/**
	 * gets the current <code>Image</code>
	 * @return the current <code>Image</code> of this <code>Entity</code>
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * sets the current <code>Image</code> to the specified <code>Image</code>
	 * @param image the <code>Image</code> to set the current <code>Image</code> to
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * sets the position of the <code>Entity</code> to the specified coordinates
	 * @param x the x coordinate to set the <code>Entity</code> to, measured in pixels
	 * @param y the y coordinate to set the <code>Entity</code> to, measured in pixels
	 */
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
		rect.setLocation(x, y);
	}
	/**
	 * sets the position of the <code>Entity</code> to the specified coordinates, and sets the <code>width</code> and <code>height</code> to the specified values
	 * @param x the x coordinate to set the <code>Entity</code> to, measured in pixels
	 * @param y the y coordinate to set the <code>Entity</code> to, measured in pixels
	 * @param width the width to set the <code>Entity</code> to, measured in pixels
	 * @param height the height to set the <code>Entity</code> to, measured in pixels
	 */
	public void setBounds(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect.setBounds(x, y, width, height);
	}
	
	/**
	 * decreases the <code>y</code> position of this <code>Entity</code> the specified number of pixels
	 * @param n number of pixels to move up
	 */
	public void moveUp(int n){
		y -= n;
		rect.setLocation(x, y);
	}
	/**
	 * increases the <code>y</code> position of this <code>Entity</code> the specified number of pixels
	 * @param n number of pixels to move down
	 */
	public void moveDown(int n){
		y += n;
		rect.setLocation(x, y);
	}
	/**
	 * decreases the <code>x</code> position of this <code>Entity</code> the specified number of pixels
	 * @param n number of pixels to move left
	 */
	public void moveLeft(int n){
		x -= n;
		rect.setLocation(x, y);
	}
	/**
	 * increases the <code>x</code> position of this <code>Entity</code> the specified number of pixels
	 * @param n number of pixels to move right
	 */
	public void moveRight(int n){
		x += n;
		rect.setLocation(x, y);
	}
	
}
