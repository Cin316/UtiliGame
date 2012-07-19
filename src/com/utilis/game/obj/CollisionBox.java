package com.utilis.game.obj;

import java.awt.image.*;

public class CollisionBox {
	
	private int sizeX, sizeY;
	private boolean[][] collide;
	
	public CollisionBox(int X, int Y){
		
		collide = new boolean[X][Y];
		
		for(int x=0; x>=X; x++){
			for(int y=0; y>=Y; y++){
				collide[x][y] = false;
			}
		}
		
	}
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
	public CollisionBox(boolean[][] bool){
		
		collide = bool;
		
	}
	
	public boolean getCollision(int x, int y){
		return collide [x][y];
	}
	public int getSizeX(){
		return sizeX;
	}
	public int getSizeY(){
		return sizeY;
	}

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
