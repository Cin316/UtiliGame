package com.utilis.game.obj;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class representing any kind of custom GUI element
 * @author Cin316
 * @see com.utilis.game.gui.Canvas
 */
public class HUDElement {
	
	/**
	 * an <code>Image</code> representing this GUI element when it is not pressed down or rolled over.
	 */
	protected Image normalImage;
	/**
	 * a <code>boolean</code> representing whether or not this <code>HUDElement</code> has a <code>rolloverImage</code>
	 */
	protected boolean hasRolloverImage;
	/**
	 * an <code>Image</code> representing this GUI element when it is rolled over by the mouse
	 */
	protected Image rolloverImage;
	/**
	 * a <code>boolean</code> representing whether or not this <code>HUDElement</code> has a <code>clickImage</code>
	 */
	protected boolean hasClickImage;
	/**
	 * an <code>Image</code> representing this GUI element when it is clicked on by the mouse
	 */
	protected Image clickImage;
	/**
	 * an <code>Image</code> representing the current state this <code>HUDElement</code> is in
	 */
	protected Image currentImage;
	/**
	 * the current width of this <code>HUDElement</code>, measured in pixels
	 */
	protected int width;
	/**
	 * the current height of this <code>HUDElement</code>, measured in pixels
	 */
	protected int height;
	/**
	 * the current x position of this <code>HUDElement</code>, measured in pixels
	 */
	protected int x;
	/**
	 * the current y position of this <code>HUDElement</code>, measured in pixels
	 */
	protected int y;
	/**
	 * a <code>Rectangle</code> representing the area of this <code>HUDElement</code>
	 */
	protected Rectangle area;
	
	/**
	 * an <code>int</code> representing the rollover <code>imageType</code>, used in <code>HUDElement(Image, Image, int)</code>
	 * @see #HUDElement(Image, Image, int)
	 */
	public static final int ROLLOVER_IMAGE = 1;
	/**
	 * an <code>int</code> representing the clicked <code>imageType</code>, used in <code>HUDElement(Image, Image, int)</code>
	 * @see #HUDElement(Image, Image, int)
	 */
	public static final int CLICK_IMAGE = 2;
	
	/**
	 * class constructor to create a blank <code>HUDElement</code> of specified width and height
	 * @param width the width of the <code>HUDElement</code> to be created, measured in pixels
	 * @param height the height of the <code>HUDElement</code> to be created, measured in pixels
	 */
	public HUDElement(int width, int height){
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		area = new Rectangle(x, y, width, height);
		normalImage = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		rolloverImage = null;
		clickImage = null;
		hasClickImage = false;
		hasRolloverImage = false;
		currentImage = normalImage;
	}
	/**
	 * class constructor to create a blank <code>HUDElement</code> of specified width, height, x coordinate, and y coordinate
	 * @param width the width of the <code>HUDElement</code> to be created, measured in pixels
	 * @param height the height of the <code>HUDElement</code> to be created, measured in pixels
	 */
	public HUDElement(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		area = new Rectangle(x, y, width, height);
		normalImage = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		rolloverImage = null;
		clickImage = null;
		hasClickImage = false;
		hasRolloverImage = false;
		currentImage = normalImage;
	}
	/**
	 * class constructor to create a blank <code>HUDElement</code> with values from the specified <code>Rectangle</code>
	 * @param r <code>Rectangle</code> to be used to create the <code>HUDElement</code>
	 */
	public HUDElement(Rectangle r){
		this.x = (int) r.getX();
		this.y = (int) r.getY();
		this.width = (int) r.getWidth();
		this.height = (int) r.getHeight();
		area = r;
		normalImage = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		rolloverImage = null;
		clickImage = null;
		hasClickImage = false;
		hasRolloverImage = false;
		currentImage = normalImage;
	}
	/**
	 * class constructor to create a <code>HUDElement</code> with values and <code>Image</code> from the specified <code>Image</code>
	 * @param i <code>Image</code> to be used to create the <code>HUDElement</code>
	 */
	public HUDElement(Image i){
		x = 0;
		y = 0;
		try {
			MediaTracker mTracker = new MediaTracker(null); //May throw NullPointerException.
			mTracker.addImage(i ,1);
			mTracker.waitForID(1);
			width = i.getWidth(null);
			height = i.getHeight(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		area = new Rectangle(x, y, width, height);
		normalImage = i;
		rolloverImage = null;
		clickImage = null;
		hasClickImage = false;
		hasRolloverImage = false;
		currentImage = normalImage;
	}
	/**
	 * class constructor to create a <code>HUDElement</code> with values and two <code>Images</code>  The second <code>Image</code> uses the specified <code>int</code> to decide which <code>Image</code> it is.
	 * @param i <code>Image</code> to be used for values and as the <code>normalImage</code>
	 * @param secondaryImage <code>Image</code> to be used for another <code>Image</code>
	 * @param imageType <code>int</code> to specify whether the <code>secondaryImage</code> is a <code>clickImage</code> or a <code>rolloverImage</code>
	 * @see #CLICK_IMAGE
	 * @see #ROLLOVER_IMAGE
	 */
	public HUDElement(Image i, Image secondaryImage, int imageType){
		x = 0;
		y = 0;
		try {
			MediaTracker mTracker = new MediaTracker(null); //May throw NullPointerException.
			mTracker.addImage(i ,1);
			mTracker.waitForID(1);
			width = i.getWidth(null);
			height = i.getHeight(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		area = new Rectangle(x, y, width, height);
		normalImage = i;
		if (imageType==HUDElement.ROLLOVER_IMAGE){
			rolloverImage = secondaryImage;
			hasRolloverImage = true;
			clickImage = null;
			hasClickImage = false;
		}else if(imageType==HUDElement.CLICK_IMAGE){
			clickImage = secondaryImage;
			hasClickImage = true;
			rolloverImage = null;
			hasRolloverImage = false;
		}else{
			//Throw error here.
		}
		currentImage = normalImage;
	}
	/**
	 * class constructor to create a <code>HUDElement</code> with values and all three <code>Images</code>
	 * @param i <code>Image</code> to be used for values and as the <code>normalImage</code>
	 * @param rImage <code>Image</code> to be used for the <code>rolloverImage</code>
	 * @param cImage  <code>Image</code> to be used for the <code>clickImage</code>
	 */
	public HUDElement(Image i, Image rImage, Image cImage){
		x = 0;
		y = 0;
		try {
			MediaTracker mTracker = new MediaTracker(null); //May throw NullPointerException.
			mTracker.addImage(i ,1);
			mTracker.waitForID(1);
			width = i.getWidth(null);
			height = i.getHeight(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		area = new Rectangle(x, y, width, height);
		normalImage = i;
		rolloverImage = rImage;
		clickImage = cImage;
		hasClickImage = true;
		hasRolloverImage = true;
		currentImage = normalImage;
	}
	
	/**
	 * gets the <code>currentImage</code>
	 * @return the current <code>currentImage</code>
	 */
	public Image getCurrentImage(){
		return currentImage;
	}
	/**
	 * gets the <code>normalImage</code>
	 * @return the current <code>normalImage</code>
	 */
	public Image getNormalImage() {
		return normalImage;
	}
	/**
	 * gets the value of <code>hasRolloverImage</code>
	 * @return the current <code>hasRolloverImage</code>
	 */
	public boolean hasRolloverImage() {
		return hasRolloverImage;
	}
	/**
	 * gets the <code>rolloverImage</code>
	 * @return the current <code>rolloverImage</code>
	 */
	public Image getRolloverImage() {
		return rolloverImage;
	}
	/**
	 * gets the value of <code>hasClickImage</code>
	 * @return the current <code>hasClickImage</code>
	 */
	public boolean hasClickImage() {
		return hasClickImage;
	}
	/**
	 * gets the <code>clickImage</code>
	 * @return the current <code>clickImage</code>
	 */
	public Image getClickImage() {
		return clickImage;
	}
	/**
	 * gets the <code>width</code> of this <code>HUDElement</code>
	 * @return the current <code>width</code> of this <code>HUDElement</code>
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * gets the <code>height</code> of this <code>HUDElement</code>
	 * @return the current <code>height</code> of this <code>HUDElement</code>
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * gets the x position of this <code>HUDElement</code>
	 * @return the current x position of this <code>HUDElement</code>
	 */
	public int getX() {
		return x;
	}
	/**
	 * gets the y position of this <code>HUDElement</code>
	 * @return the current y position of this <code>HUDElement</code>
	 */
	public int getY() {
		return y;
	}
	/**
	 * gets the <code>Rectangle</code> representing the area of this <code>HUDElement</code>
	 * @return the current <code>Rectangle</code> representing the area of this <code>HUDElement</code>
	 */
	public Rectangle getArea() {
		return area;
	}
	
	/**
	 * sets <code>normalImage</code> to the specified <code>Image</code>
	 * @param normalImage the <code>Image</code> to set <code>normalImage</code> to
	 */
	public void setNormalImage(Image normalImage) {
		this.normalImage = normalImage;
	}
	/**
	 * sets <code>rolloverImage</code> to the specified <code>Image</code>
	 * @param rolloverImage the <code>Image</code> to set <code>rolloverImage</code> to
	 */
	public void setRolloverImage(Image rolloverImage) {
		this.rolloverImage = rolloverImage;
		hasRolloverImage = true;
	}
	/**
	 * sets <code>clickImage</code> to the specified <code>Image</code>
	 * @param clickImage the <code>Image</code> to set <code>clickImage</code> to
	 */
	public void setClickImage(Image clickImage) {
		this.clickImage = clickImage;
		hasClickImage = true;
	}
	/**
	 * sets <code>width</code> to the specified <code>int</code>
	 * @param width the <code>int</code> to set <code>width</code> to
	 */
	public void setWidth(int width) {
		this.width = width;
		area.setSize(width, area.height);
	}
	/**
	 * sets <code>height</code> to the specified <code>int</code>
	 * @param height the <code>int</code> to set <code>height</code> to
	 */
	public void setHeight(int height) {
		this.height = height;
		area.setSize(area.width, height);
	}
	/**
	 * sets x position to the specified <code>Image</code>
	 * @param x the <code>int</code> to set x position to
	 */
	public void setX(int x) {
		this.x = x;
		area.setLocation(x, area.y);
	}
	/**
	 * sets y position to the specified <code>Image</code>
	 * @param y the <code>int</code> to set y position to
	 */
	public void setY(int y) {
		this.y = y;
		area.setLocation(area.x, y);
	}
	
	/**
	 * sets <code>normalImage</code> as the <code>currentImage</code>
	 */
	public void setCurrentImageToNormalImage(){
		currentImage = normalImage;
	}
	/**
	 * sets <code>rolloverImage</code> as the <code>currentImage</code>
	 */
	public void setCurrentImageToRolloverImage(){
		currentImage = rolloverImage;
	}
	/**
	 * sets <code>clickImage</code> as the <code>currentImage</code>
	 */
	public void setCurrentImageToClickImage(){
		currentImage = clickImage;
	}
}
