package com.utilis.game.obj;

import java.awt.image.*;

import com.utilis.StringedObj;

/**
 * A class for storing the actual solid points that collide with another <code>Collider</code>.
 * @author Cin316
 * @see Collider
 * @see CollisionGroup
 */
public class CollisionBox implements StringedObj{
	
	/**
	 * width of the <code>CollisionBox</code>, measured in pixels
	 */
	protected int sizeX;
	/**
	 * height of the <code>CollisionBox</code>, measured in pixels
	 */
	protected int sizeY;
	/**
	 * two-dimensional array representing which pixels are solid points that collide with other points.  Its size is equivalent to <code>sizeX</code> and <code>sizeY</code>, respectively 
	 */
	protected boolean[][] collide;
	/**
	 * class constructor to create blank <code>collide<code> with specified width and height
	 * @param X width of <code>CollisionBox</code> to be created
	 * @param Y height of <code>CollisionBox</code> to be created
	 */
	public CollisionBox(int X, int Y){
		
		collide = new boolean[X][Y];
		
		sizeX = X;
		sizeY = Y;
		
		for(int x=0; x<X; x++){
			for(int y=0; y<Y; y++){
				collide[x][y] = false;
			}
		}
		
	}
	/**
	 * class constructor to create blank <code>collide<code> with specified width, height, and boolean value
	 * @param X width of <code>CollisionBox</code> to be created
	 * @param Y height of <code>CollisionBox</code> to be created
	 * @param b <code>boolean</code> value to assign to every <code>boolean</code> in <code>collide</code>
	 */
	public CollisionBox(int X, int Y, boolean b){
		
		collide = new boolean[X][Y];
		
		sizeX = X;
		sizeY = Y;
		
		for(int x=0; x<X; x++){
			for(int y=0; y<Y; y++){
				collide[x][y] = b;
			}
		}
		
	}
	/**
	 * class constructor to create <code>collide</code> from an <code>Image</code> (<code>img</code>)  White (RGB[1,1,1]) (or any other color) is considered <code>false</code>.  Black (RGB[255,255,255]) is considered <code>true</code>.  Width and height are specified by width and height of <code>img</code>.
	 * @param img <code>Image</code> to get <code>collide</code> from
	 */
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
	/**
	 * class constructor to set <code>collide</code> to provided <code>boolean[][]</code>
	 * @param bool two-dimensional array to set <code>collide</code> to
	 */
	public CollisionBox(boolean[][] bool){
		
		collide = bool;
		
	}
	
	/**
	 * gets the boolean in <code>collide</code> of provided x and y values
	 * @param x x position of provided <code>boolean</code> 
	 * @param y y position of provided <code>boolean</code>
	 * @return boolean in <code>collide</code> of provided x and y values
	 */
	public boolean getCollision(int x, int y){
		return collide [x][y];
	}
	/**
	 * gets the width of this <code>CollisionBox</code>
	 * @return the current width of this <code>CollisionBox</code>
	 */
	public int getSizeX(){
		return sizeX;
	}
	/**
	 * gets the width of this <code>CollisionBox</code>
	 * @return the current width of this <code>CollisionBox</code>
	 */
	public int getSizeY(){
		return sizeY;
	}
	
	/**
	 * sets the boolean specified with <code>x</code> and <code>y</code> to the specified value
	 * @param x x position of the boolean to be set
	 * @param y y position of the boolean to be set
	 * @param value the value to set the specified boolean to
	 */
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
	
	private String booleanToString(boolean b){
		String out = "";
		if (b==true){
			out = "1";
		}else if (b==false){
			out = "0";
		}
		return out;
	}
	private boolean stringToBoolean(String s){
		boolean out = false;
		if (s=="1"){
			out = true;
		}else if (s=="0"){
			out = false;
		}
		return out;
	}
	
	public StringedObj loadString(String string) {
		int height = 0;
		int width = 0;
		StringedObj sObj;
		
		//Gets image width and height;
		boolean widthCalcd = false;
		for(int i=0; i>string.length(); i++){
			if (string.charAt(i)==(',') && !widthCalcd){
				width++;
			}
			if (string.charAt(i)==(';')){
				height++;
				widthCalcd = true;
			} 
		}
		
		String[][] colors = new String[width][height];
		
		return sObj;
	}

	public String saveString() {
		String word = "";
		for(int y=0; y<sizeY;y++){
			for(int x=0; x<sizeX;x++){
				
				word += booleanToString(getCollision(x, y));
				word += ","; //Indicates end of boolean data.
			}
			word += ";"; //Indicates newline of data.
		}
		return word;
		
	}
	
}
