package com.utilis.game.obj;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity extends Collider{
	
	protected Image image;
	
	public Entity(int w, int h){
		width = w;
		height = h;
		x = 0;
		y = 0;
		rect = new Rectangle(x, y, width, height);
		image = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		collide = new CollisionBox(width, height);
	}
	public Entity(Image i){
		
		image = i;
		x = 0;
		y = 0;
		
		try {
			MediaTracker mTracker = new MediaTracker(null); //May throw NullPointerException.
			mTracker.addImage(image,1);
			mTracker.waitForID(1);
			width = image.getWidth(null);
			height = image.getHeight(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rect = new Rectangle(x, y, width, height);
		collide = new CollisionBox(width, height);
		
	}
	public Entity(CollisionBox c){
		collide = c;
		x = 0;
		y = 0;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = (Image) new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	public Entity(Image i, CollisionBox c){
		collide = c;
		x = 0;
		y = 0;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = i;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setBounds(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void moveUp(int n){
		y -= n;
	}
	public void moveDown(int n){
		y += n;
	}
	public void moveLeft(int n){
		x -= n;
	}
	public void moveRight(int n){
		x += n;
	}
	
}
