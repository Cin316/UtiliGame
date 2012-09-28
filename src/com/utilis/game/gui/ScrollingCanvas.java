package com.utilis.game.gui;

import java.awt.Graphics;

import com.utilis.game.obj.*;

/**
 * A class representing a type of <code>Canvas</code> that the elements in it can scroll based on the movements of the <code>centerEntity</code>.
 * @author Cin316
 * @see com.utilis.game.obj.ScrollingEntity
 * @see Canvas
 */
public class ScrollingCanvas extends Canvas {
	
	/**
	 * <code>int</code> representing the current x offset of the visuals displayed on screen to the actual x coordinates
	 */
	protected int offsetX;
	/**
	 * <code>int</code> representing the current y offset of the visuals displayed on screen to the actual y coordinates
	 */
	protected int offsetY;
	
	/**
	 * the <code>ScrollingEntity</code> that is currently controlling the scrolling of this <code>ScrollingCanvas</code>
	 */
	protected ScrollingEntity centerEntity;
	
	/**
	 * class constructor that uses the specified values
	 * @param xTiles the number of <code>Tiles</code> wide this <code>ScrollingCanvas</code> is
	 * @param yTiles the number of <code>Tiles</code> high this <code>ScrollingCanvas</code> is
	 * @param tWidth the height of the <code>Tiles</code> in this <code>ScrollingCanvas</code>
	 * @param tHeight the width of the <code>Tiles</code> in this <code>ScrollingCanvas</code>
	 */
	public ScrollingCanvas(int xTiles, int yTiles, int tWidth, int tHeight){
		super(xTiles, yTiles, tWidth, tHeight);
	}
	/**
	 * Class constructor creates <code>Screen</code> with specified values and initializes
	 * @param s <code>Screen</code> to set the Screen to.
	 */
	public ScrollingCanvas(Screen s){
		super(s);
	}
	
	/**
	 * returns the current <code>ScrollingEntity</code> that is controlling this <code>ScrollingCanvas</code>
	 * @return the current <code>ScrollingEntity</code> that is controlling this <code>ScrollingCanvas</code>
	 */
	public ScrollingEntity getCenterEntity() {
		return centerEntity;
	}
	/**
	 * returns the value of <code>offsetX</code>
	 * @return the current value of <code>offsetX</code>
	 */
	public int getOffsetX() {
		return offsetX;
	}
	/**
	 * returns the value of <code>offsetY</code>
	 * @return the current value of <code>offsetY</code>
	 */
	public int getOffsetY() {
		return offsetY;
	}
	
	/**
	 * sets the specified <code>ScrollingEntity</code> as the <code>centerEntity</code>
	 * @param sc the <code>ScrollingEntity</code> to set as the <code>centerEntity</code>
	 */
	public void setCenterEntity(ScrollingEntity sc){
		sc.setScroller(this);
		centerEntity = sc;
	}
	/**
	 * sets <code>offsetX</code> to the specified value
	 * @param offsetX the value to set <code>offsetX</code> to
	 */
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	/**
	 * sets <code>offsetY</code> to the specified value
	 * @param offsetY the value to set <code>offsetY</code> to
	 */
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	
	/**
	 * Paints the elements on the <code>ScrollingCanvas</code>. Uses double buffering.
	 * @param g Graphics to paint on.
	 */
	protected void paintComponent(Graphics g){
		
		// initialize buffer//
		if (dbImage == null){
			dbImage = createImage(this.getSize().width, this.getSize().height); 
			dbg = dbImage.getGraphics(); 
		} 
		
		// clear screen in background 
		dbg.setColor(getBackground()); 
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height); 
		
		// draw elements in background 
		dbg.setColor(getForeground());
		
		//Paint things off screen.
		draw(dbg);
		
		// draw image on the screen 
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	/**
	 * method to update painting of the <code>ScrollingCanvas</code>
	 * @param g Graphics to paint on.
	 */
	public void update(Graphics g){
		
		paint(g);
		
	} 
	
	/**
	 * Method to paint this <code>Canvas</code> on screen.  Override this to use double buffering of with custom code.
	 * @param g Graphics to paint on.
	 */
	public void draw(Graphics g){
		
		paintTiles(g);
		paintEntities(g);
		paintHUD(g);
		
	}
	
	/**
	 * paints the <code>Tiles</code> onto the <code>ScrollingCanvas</code>
	 * @param g Graphics to paint on.
	 */
	protected void paintTiles(Graphics g){
		
		Tile tile;

		for(int x=0; x<tilesNumX; x++){
			for(int y=0; y<tilesNumY; y++){
				
				tile = screen.getTile(x, y);
				g.drawImage(tile.getImage(), tile.getX()-offsetX, tile.getY()-offsetY, tileWidth, tileHeight, this);
				//g.drawImage(tile.getImage(), tile.getX()-offsetX, tile.getY()-offsetY, this); for non resized images.
				
			}
		}
	}
	/**
	 * paints the <code>Entities</code> onto the <code>ScrollingCanvas</code>
	 * @param g Graphics to paint on.
	 */
	protected void paintEntities(Graphics g){
		Entity e;
		for(int i=0; i<entities.size(); i++){
			e = entities.get(i);
			if (e == centerEntity){
				g.drawImage(e.getImage(), ((ScrollingEntity)e).getRealX(), ((ScrollingEntity)e).getRealY(), this);
			}else{
				g.drawImage(e.getImage(), e.getX()-offsetX, e.getY()-offsetY, this);
			}
		}
	}
	
}
