package com.utilis.game.obj;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.utilis.StringedObj;
import com.utilis.StringedObj.InvalidStringedObjStringException;
import com.utilis.game.obj.Collider.CollisionBoxSizeException;

/**
 * A class representing an object that is locked to a grid and cannot move.
 * @author Cin316
 * @see Screen
 */
public class Tile extends Collider{
	
	/**
	 * an <code>Image</code> representing this <code>Tile</code>
	 */
	protected Image image;
	
	public String convertToString(){
		
		String output = "";
		
		output += ("x:" + x + "\n");
		output += ("y:" + y + "\n");
		output += ("width:" + width + "\n");
		output += ("height:" + height + "\n");
		output += ("collision:" + collide.convertToString() + "\n");
		
		return output;
		
	}
	/**
	 * Takes a String and uses it to create a new Collider.
	 * @param s String to create new Collider from.
	 * @return StringedObj created from the original String.  Instance of Collider.
	 */
	public StringedObj createFromString(String s) throws InvalidStringedObjStringException{
		
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		Tile output;
		ArrayList<String> lines = new ArrayList<String>(5); //5 lines are used in convertToString
		
		//Converts String into lines in an ArrayList
		String l = "";
		for(int i=0; i>s.length(); i++){
			if( s.charAt(i) == '\n' ){
				lines.add(l);
				l = "";
			}else{
				l += Character.toString( s.charAt(i) );
			}
		}
		
		//Read from lines.
		boolean[] variablePresent = new boolean[5];
		String currentLine;
		String value;
		for(int i=0; i<lines.size(); i++){
			
			currentLine = lines.get(i);
			int colonNum;
			colonNum = currentLine.indexOf(":");
			value = currentLine.substring(colonNum+1);
			
			if( currentLine.startsWith("x:") ){
				Integer val = new Integer(value);
				x = val.intValue();
				variablePresent[0] = true;
			}else if( currentLine.startsWith("y:") ){
				Integer val = new Integer(value);
				y = val.intValue();
				variablePresent[1] = true;
			}else if( currentLine.startsWith("width:") ){
				Integer val = new Integer(value);
				width = val.intValue();
				variablePresent[2] = true;
			}else if( currentLine.startsWith("height:") ){
				Integer val = new Integer(value);
				height = val.intValue();
				variablePresent[3] = true;
			}else if( currentLine.startsWith("collision:") ){
				CollisionBox cb = new CollisionBox(1, 1); //Used to run createFromString.
				CollisionBox collide = (CollisionBox) cb.createFromString(value);
				variablePresent[4] = true;
			}
			
		}
		
		//Check if something was missing.
		for(int i=0; i<variablePresent.length; i++){
			
			if(!variablePresent[i]){
				throw new InvalidStringedObjStringException();
			}
			
		}
		
		//Create Collider.
		output = new Tile(x, y, width, height);
		try {
			output.setCollisionBox(collide);
		} catch (CollisionBoxSizeException e) {
			throw new InvalidStringedObjStringException();
		}
		
		return (StringedObj) output;
	}
	
	/**
	 * class constructor to create a blank <code>Tile</code> with the specified values.
	 * @param width the <code>width</code> of the <code>Tile</code> to be created
	 * @param height the <code>height</code> of the <code>Tile</code> to be created
	 * @param x the x position of the <code>Tile</code> to be created
	 * @param y the y position of the <code>Tile</code> to be created
	 */
	public Tile(int width, int height, int x, int y){
		this.width = width;
		this.x = x;
		this.y = y;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		collide = new CollisionBox(width, height);
		image = null;
	}
	/**
	 * class constructor to create a <code>Tile</code> with the specified values.  The <code>width</code> and <code>height</code> are provided by the <code>CollisionBox</code>.
	 * @param i <code>Image</code> to be used to create the new <code>Tile</code>
	 * @param c <code>CollisionBox</code> to be used to create the new <code>Tile</code>
	 * @param x x position of the <code>Tile</code> to be created 
	 * @param y y position of the <code>Tile</code> to be created
	 */
	public Tile(Image i, CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = i;
	}
	/**
	 * class constructor to create a <code>Tile</code> with a blank <code>Image</code> and specified values.  The <code>width</code> and <code>height</code> are provided by the <code>CollisionBox</code>.
	 * @param c <code>CollisionBox</code> to be used to create the new <code>Tile</code>
	 * @param x x position of the <code>Tile</code> to be created 
	 * @param y y position of the <code>Tile</code> to be created
	 */
	public Tile(CollisionBox c, int x, int y){
		this.x = x;
		this.y = y;
		collide = c;
		width = c.getSizeX();
		height = c.getSizeY();
		rect = new Rectangle(x, y, width, height);
		image = null;
	}
	
	/**
	 * gets the <code>Image</code> of this <code>Tile</code>
	 * @return the current <code>Image</code> of this <code>Tile</code>
	 */
	public Image getImage(){
		return image;
	}
	
	/**
	 * sets the <code>Image</code> of this <code>Tile</code> to the specified <code>Image</code>
	 * @param i the <code>Image</code> to set this <code>Tile</code>'s <code>Image</code> to
	 */
	public void setImage(Image i){
		image = i;
	}
	
}
