package com.utilis.game.obj;

import java.awt.Image;
import java.awt.Rectangle;

public class Tile extends Collider{
	
	protected Image image;
	
	public Tile(int width, int height, int x, int y){
		this.width = width;
		this.x = x;
		this.y = y;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		collide = new CollisionBox(width, height);
		image = null;
	}
	public Tile(Image i, CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = i;
	}
	public Tile(CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = null;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setImage(Image i){
		image = i;
	}
	
}
