package com.utilis.game.obj;

import java.awt.Rectangle;

public abstract class Collider {
	
	protected CollisionBox collide;
	protected int x, y;
	protected int width, height;
	protected Rectangle rect;
	
	public class CollisionBoxSizeException extends Exception{
		
		public CollisionBoxSizeException(){
			super("CollisionBox sizes do not match!");
		}
	}
	
	public CollisionBox getCollisionBox(){
		return collide;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Rectangle getRectangle(){
		return rect;
	}
	
	public void setCollisionBox(CollisionBox cBox) throws CollisionBoxSizeException{
		if (cBox.getSizeX()!=collide.getSizeX()||cBox.getSizeY()!=collide.getSizeY()){
			throw new CollisionBoxSizeException();
		}else{
			collide = cBox;
		}
	}
	public void setX(int x) {
		this.x = x;
		rect.setBounds(x, y, width, height);
	}
	public void setY(int y) {
		this.y = y;
		rect.setBounds(x, y, width, height);
	}
	public void setWidth(int width) {
		this.width = width;
		rect.setBounds(x, y, width, height);
	}
	public void setHeight(int height) {
		this.height = height;
		rect.setBounds(x, y, width, height);
	}
	public void setRectangle(Rectangle r){
		rect = r;
	}
	
}
