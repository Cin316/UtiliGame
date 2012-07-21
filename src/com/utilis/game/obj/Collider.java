package com.utilis.game.obj;

import java.awt.Rectangle;

/**
 * An abstract class for all classes which can be used in collision detection.
 * 
 * @author Cin316
 * @see CollisionGroup
 * @see CollisionBox
 */
public abstract class Collider {
	
	/**
	 * <code>CollisionBox</code> for this <code>Collider</code>
	 */
	protected CollisionBox collide;
	/**
	 * x position of this <code>Collider</code>, measured in pixels
	 */
	protected int x;
	/**
	 * y position of this <code>Collider</code>, measured in pixels
	 */
	protected int y;
	/**
	 * width of this <code>Collider</code>, measured in pixels
	 */
	protected int width;
	/**
	 * height of this <code>Collider</code>, measured in pixels
	 */
	protected int height;
	/**
	 * <code>Rectangle</code> representing area of this <code>Collider</code>
	 */
	protected Rectangle rect;
	
	/**
	 * exeception to be thrown if <code>ColisionBox</code> size does not match current <code>CollisionBox</code> size when setting <code>CollisonBox</code>
	 * @author Cin316
	 * @see CollisionBox
	 */
	public class CollisionBoxSizeException extends Exception{
		
		/**
		 * Class constructor to throw exception.
		 */
		public CollisionBoxSizeException(){
			super("CollisionBox sizes do not match!");
		}
	}
	
	/**
	 * method that returns the current <code>CollisionBox</code>
	 * @return current <code>CollisonBox</code>.
	 */
	public CollisionBox getCollisionBox(){
		return collide;
	}
	/**
	 * method that returns the x position of this <code>Collider</code>, measured in pixels
	 * @return x position of this <code>Collider</code>
	 */
	public int getX() {
		return x;
	}
	/**
	 * method that returns the y position of this <code>Collider</code>, measured in pixels
	 * @return y position of this <code>Collider</code>
	 */
	public int getY() {
		return y;
	}
	/**
	 * method that returns the width position of this <code>Collider</code>, measured in pixels
	 * @return width position of this <code>Collider</code>
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * method that returns the height position of this <code>Collider</code>, measured in pixels
	 * @return height position of this <code>Collider</code>
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * method that returns the <code>Rectangle</code> representing the area of this <code>Collider</code>
	 * @return <code>Rectangle</code> representing the area of this <code>Collider</code>
	 */
	public Rectangle getRectangle(){
		return rect;
	}
	
	/**
	 * sets the current <code>CollisionBox</code> to <code>cBox</code>
	 * @param cBox <code>CollisionBox</code> to set current <code>CollisionBox</code> to
	 * @throws CollisionBoxSizeException If the size of <code>cBox</code> does not match the size of the current <code>CollisionBox</code>
	 */
	public void setCollisionBox(CollisionBox cBox) throws CollisionBoxSizeException{
		if (cBox.getSizeX()!=collide.getSizeX()||cBox.getSizeY()!=collide.getSizeY()){
			throw new CollisionBoxSizeException();
		}else{
			collide = cBox;
		}
	}
	/**
	 * sets the current x position of this <code>Collider</code> to <code>x</code>
	 * @param x <code>int</code> to set current x position to
	 */
	public void setX(int x) {
		this.x = x;
		rect.setBounds(x, y, width, height);
	}
	/**
	 * sets the current y position of this <code>Collider</code> to <code>y</code>
	 * @param y <code>int</code> to set current y position to
	 */
	public void setY(int y) {
		this.y = y;
		rect.setBounds(x, y, width, height);
	}
	/**
	 * sets the current width of this <code>Collider</code> to <code>width</code>
	 * @param width <code>int</code> to set current width to
	 */
	public void setWidth(int width) {
		this.width = width;
		rect.setBounds(x, y, width, height);
	}
	/**
	 * sets the current height of this <code>Collider</code> to <code>height</code>
	 * @param height <code>int</code> to set current height to
	 */
	public void setHeight(int height) {
		this.height = height;
		rect.setBounds(x, y, width, height);
	}
	/**
	 * sets the current Rectangle of this <code>Collider</code> to <code>r</code>
	 * @param r <code>Rectangle</code> to set the current Rectangle to
	 */
	public void setRectangle(Rectangle r){
		rect = r;
	}
	
}
