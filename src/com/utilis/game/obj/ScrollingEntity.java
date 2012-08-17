package com.utilis.game.obj;

import java.awt.Image;
import com.utilis.game.gui.*;

/**
 * A class representing an <code>Entity</code> that can control the scrolling of a <code>ScrollingCanvas</code>.
 * @author Cin316
 * @see com.utilis.game.gui.ScrollingCanvas
 * @see Entity
 */
public class ScrollingEntity extends Entity {
	
	/**
	 * the <code>int</code> representing the actual x value that is being used to display this <code>ScrollingEntity</code> on screen
	 */
	protected int realX;
	/**
	 * the <code>int</code> representing the actual y value that is being used to display this <code>ScrollingEntity</code> on screen
	 */
	protected int realY;
	
	/**
	 * the <code>ScrollingCanvas</code> that this <code>ScrollingEntity</code> is currently controlling
	 */
	protected ScrollingCanvas scroller;
	/**
	 * class constructor which makes a blank <code>ScrollingEntity</code> with the specified width and height
	 * @param w width of the <code>ScrollingEntity</code> to be created
	 * @param h height of the <code>ScrollingEntity</code> to be created
	 */
	public ScrollingEntity(int w, int h) {
		super(w, h);
		realX = 0;
		realY = 0;
		scroller = new ScrollingCanvas(1,1,1,1);
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>Image</code>, an <code>Image</code> equivalent to the specified <code>Image</code>, and a blank <code>CollisionBox</code>
	 * @param i <code>Image</code> to be used for creation of this <code>Entity</code> 
	 */
	public ScrollingEntity(Image i) {
		super(i);
		realX = 0;
		realY = 0;
		scroller = new ScrollingCanvas(1,1,1,1);
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>CollisionBox</code>, a blank <code>Image</code>, and a <code>CollsionBox</code> equivalent to the specified <code>CollisionBox</code>
	 * @param c <code>CollisionBox</code> to be used for creation of this <code>Entity</code>
	 */
	public ScrollingEntity(CollisionBox c) {
		super(c);
		realX = 0;
		realY = 0;
		scroller = new ScrollingCanvas(1,1,1,1);
	}
	/**
	 * class constructor which creates an <code>Entity</code> with the width and height of the specified <code>CollisionBox</code>, an <code>Image</code> equivalent to the specified <code>Image</code>, and a <code>CollsionBox</code> equivalent to the specified <code>CollisionBox</code>
	 * @param i <code>Image</code> to be used for creation of this <code>Entity</code>
	 * @param c <code>CollisionBox</code> to be used for creation of this <code>Entity</code>
	 */
	public ScrollingEntity(Image i, CollisionBox c) {
		super(i, c);
		realX = 0;
		realY = 0;
		scroller = new ScrollingCanvas(1,1,1,1);
	}
	
	/**
	 * decreases the <code>y</code> position of this <code>ScrollingEntity</code> the specified number of pixels and modifies the <code>scroller</code>'s <code>offsetY</code> giving the appearance that the other objects in <code>scroller</code> are moving around this <code>ScrollingEntity</code>
	 * @param n number of pixels to move up
	 */
	public void moveUp(int n){
		scroller.setOffsetY(scroller.getOffsetY() - n);
		super.moveUp(n);
	}
	/**
	 * increases the <code>y</code> position of this <code>ScrollingEntity</code> the specified number of pixels and modifies the <code>scroller</code>'s <code>offsetY</code> giving the appearance that the other objects in <code>scroller</code> are moving around this <code>ScrollingEntity</code>
	 * @param n number of pixels to move down
	 */
	public void moveDown(int n){
		scroller.setOffsetY(scroller.getOffsetY() + n);
		super.moveDown(n);
	}
	/**
	 * decreases the <code>x</code> position of this <code>ScrollingEntity</code> the specified number of pixels and modifies the <code>scroller</code>'s <code>offsetX</code> giving the appearance that the other objects in <code>scroller</code> are moving around this <code>ScrollingEntity</code>
	 * @param n number of pixels to move left
	 */
	public void moveLeft(int n){
		scroller.setOffsetX(scroller.getOffsetX() - n);
		super.moveLeft(n);
	}
	/**
	 * increases the <code>x</code> position of this <code>ScrollingEntity</code> the specified number of pixels and modifies the <code>scroller</code>'s <code>offsetX</code> giving the appearance that the other objects in <code>scroller</code> are moving around this <code>ScrollingEntity</code>
	 * @param n number of pixels to move right
	 */
	public void moveRight(int n){
		scroller.setOffsetX(scroller.getOffsetX() + n);
		super.moveRight(n);
	}
	
	/**
	 * returns the value of <code>realX</code> in this <code>ScrollingEntity</code>
	 * @return the current value of <code>realX</code>
	 */
	public int getRealX() {
		return realX;
	}
	/**
	 * returns the value of <code>realY</code> in this <code>ScrollingEntity</code>
	 * @return the current value of <code>realY</code>
	 */
	public int getRealY() {
		return realY;
	}
	/**
	 * returns the <code>ScrollingCanvas</code> that this <code>ScrollingEntity</code> is currently controlling
	 * @return the current <code>ScrollingCanvas</code> that this <code>ScrollingEntity</code> is controlling
	 */
	public ScrollingCanvas getScroller() {
		return scroller;
	}
	
	/**
	 * sets the value of <code>realX</code> to the specified value
	 * @param realX the value to set <code>realX</code> to
	 */
	public void setRealX(int realX) {
		scroller.setOffsetX(scroller.getOffsetX()-(realX - this.realX));
		this.realX = realX;
	}
	/**
	 * sets the value of <code>realY</code> to the specified value
	 * @param realY the value to set <code>realY</code> to
	 */
	public void setRealY(int realY) {
		scroller.setOffsetY(scroller.getOffsetY()-(realY - this.realY));
		this.realY = realY;
	}
	/**
	 * sets the <code>ScrollingCanvas</code> that this <code>ScrollingEntity</code> is currently controlling to the specified value
	 * @param scroller the <code>ScrollingCanvas</code> to be controlled by this <code>ScrollingEntity</code>
	 */
	public void setScroller(ScrollingCanvas scroller) {
		this.scroller = scroller;
	}
	
}
