package com.utilis.game.obj;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HUDElement {
	
	protected Image normalImage;
	protected boolean hasRolloverImage;
	protected Image rolloverImage;
	protected boolean hasClickImage;
	protected Image clickImage;
	protected int width, height;
	protected int x, y;
	protected Rectangle area;
	
	public static final int ROLLOVER_IMAGE = 1;
	public static final int CLICK_IMAGE = 2;
	
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
	}
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
	}
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
	}
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
	}
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
		
	}
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
		
	}
	
	public Image getNormalImage() {
		return normalImage;
	}
	public boolean hasRolloverImage() {
		return hasRolloverImage;
	}
	public Image getRolloverImage() {
		return rolloverImage;
	}
	public boolean hasClickImage() {
		return hasClickImage;
	}
	public Image getClickImage() {
		return clickImage;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle getArea() {
		return area;
	}
	
	public void setNormalImage(Image normalImage) {
		this.normalImage = normalImage;
	}
	public void setRolloverImage(Image rolloverImage) {
		this.rolloverImage = rolloverImage;
		hasRolloverImage = true;
	}
	public void setClickImage(Image clickImage) {
		this.clickImage = clickImage;
		hasClickImage = true;
	}
	public void setWidth(int width) {
		this.width = width;
		area.setSize(width, area.height);
	}
	public void setHeight(int height) {
		this.height = height;
		area.setSize(area.width, height);
	}
	public void setX(int x) {
		this.x = x;
		area.setLocation(x, area.y);
	}
	public void setY(int y) {
		this.y = y;
		area.setLocation(area.x, y);
	}
	
}
