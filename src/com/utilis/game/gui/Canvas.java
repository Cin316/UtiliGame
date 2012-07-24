package com.utilis.game.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;

import com.utilis.game.obj.*;

/**
 * A class for painting and managing the contents of a <code>Window</code>.  It is uses double buffering.
 * @author Cin316
 * @see Window
 * @see com.utilis.game.obj.Screen
 */
public class Canvas extends JPanel{
	
	/**
	 * the width of the <code>Tiles</code> in this <code>Canvas</code>'s <code>Screen</code>
	 */
	protected int tileWidth;
	/**
	 * the height of the <code>Tiles</code> in this <code>Canvas</code>'s <code>Screen</code>
	 */
	protected int tileHeight;
	/**
	 * the number of <code>Tiles</code> wide this <code>Canvas</code>'s <code>Screen</code> is
	 */
	protected int tilesNumX;
	/**
	 * the number of <code>Tiles</code> high this <code>Canvas</code>'s <code>Screen</code> is
	 */
	protected int tilesNumY;
	
	/**
	 * the <code>ArrayList</code> of <code>HUDElements</code> in this <code>Canvas</code>
	 */
	protected ArrayList<HUDElement> HUDElements = new ArrayList<HUDElement>();
	/**
	 * the <code>ArrayList</code> of <code>Entities</code> in this <code>Canvas</code>
	 */
	protected ArrayList<Entity> entities = new ArrayList<Entity>();
	/**
	 * a <code>Screen</code> for managing the <code>Tiles</code> in this <code>Canvas</code>
	 */
	protected Screen screen;
	
	/**
	 * An <code>Image</code> used for double buffering.
	 */
	protected Image dbImage;
	/**
	 * The instance of <code>Graphics</code> used for double buffering
	 */
	protected Graphics dbg;
	
	/**
	 * Class constructor creates <code>Screen</code> with specified values and initializes
	 * @param xTiles the number of <code>Tiles</code> wide the <code>Screen</code> to be created will be
	 * @param yTiles the number of <code>Tiles</code> high the <code>Screen</code> to be created will be
	 * @param tWidth the width of the <code>Tiles</code>
	 * @param tHeight the height of the <code>Tiles</code>
	 */
	public Canvas(int xTiles, int yTiles, int tWidth, int tHeight){
		
		tilesNumX = xTiles;
		tilesNumY = yTiles;
		tileWidth = tWidth;
		tileHeight = tHeight;
		
		screen = new Screen(tilesNumX, tilesNumY, tileWidth, tileHeight);
	}
	
	/**
	 * gets the <code>Screen</code> of this <code>Canvas</code>
	 * @return the current <code>Screen</code>
	 */
	public Screen getScreen() {
		return screen;
	}
	/**
	 * gets the width of the <code>Tiles</code> in the <code>Screen</code>
	 * @return the width of the <code>Tiles</code>, measured in pixels
	 */
	public int getTileWidth() {
		return tileWidth;
	}
	/**
	 * gets the height of the <code>Tiles</code> in the <code>Screen</code>
	 * @return the height of the <code>Tiles</code>, measured in pixels
	 */
	public int getTileHeight() {
		return tileHeight;
	}
	/**
	 * gets the number of <code>Tiles</code> wide the <code>Screen</code> is
	 * @return the current number of <code>Tiles</code> wide the <code>Screen</code> is
	 */
	public int getTilesNumX() {
		return tilesNumX;
	}
	/**
	 * gets the number of <code>Tiles</code> high the <code>Screen</code> is
	 * @return the current number of <code>Tiles</code> high the <code>Screen</code> is
	 */
	public int getTilesNumY() {
		return tilesNumY;
	}
	/**
	 * gets the <code>ArrayList</code> of <code>HUDElements</code>
	 * @return the current <code>ArrayList</code> of <code>HUDElements</code>
	 */
	public HUDElement getHUDElement(int i){
		return HUDElements.get(i);
	}
	/**
	 * gets the <code>ArrayList</code> of <code>Entities</code>
	 * @return the current <code>ArrayList</code> of <code>Entities</code>
	 */
	public Entity getEntity(int i){
		return entities.get(i);
	}
	
	/**
	 * sets the width of the <code>Tiles</code> in the <code>Screen</code> to the specified value
	 * @param tileWidth the width to set the <code>Tiles</code> in the <code>Screen</code> to
	 */
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}
	/**
	 * sets the height of the <code>Tiles</code> in the <code>Screen</code> to the specified value
	 * @param tileHeight the height to set the <code>Tiles</code> in the <code>Screen</code> to
	 */
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	/**
	 * sets the number of <code>Tiles</code> wide in the <code>Screen</code> to the specified value
	 * @param tileWidth the number of <code>Tiles</code> wide to set the <code>Screen</code> to
	 */
	public void setTilesNumX(int tilesNumX) {
		this.tilesNumX = tilesNumX;
	}
	/**
	 * sets the number of <code>Tiles</code> high in the <code>Screen</code> to the specified value
	 * @param tileWidth the number of <code>Tiles</code> high to set the <code>Screen</code> to
	 */
	public void setTilesNumY(int tilesNumY) {
		this.tilesNumY = tilesNumY;
	}
	/**
	 * sets the <code>HUDElement</code> specified by the <code>int</code> to the value specified by <code>h</code>
	 * @param i the position of the <code>HUDElement</code> to be changed
	 * @param h the <code>HUDElement</code> to set the specified <code>HUDElement</code> to
	 */
	public void setHUDElement(int i, HUDElement h){
		HUDElements.set(i, h);
	}
	/**
	 * sets the <code>Entity</code> specified by the <code>int</code> to the value specified by <code>e</code>
	 * @param i the position of the <code>Entity</code> to be changed
	 * @param e the <code>Entity</code> to set the specified <code>Entity</code> to
	 */
	public void setEntity(int i, Entity e){
		entities.set(i, e);
	}
	
	/**
	 * adds the specified <code>HUDElement</code> to the <code>ArrayList</code> of <code>HUDElements</code>
	 * @param h the <code>HUDElement</code> to be added to the <code>ArrayList</code>
	 */
	public void add(HUDElement h){
		HUDElements.add(h);
	}
	/**
	 * adds the specified <code>Entity</code> to the <code>ArrayList</code> of <code>Entities</code>
	 * @param h the <code>Entity</code> to be added to the <code>ArrayList</code>
	 */
	public void add(Entity e){
		entities.add(e);
	}
	
	protected void paintComponent(Graphics g){
		
		paintTiles(g);
		paintEntities(g);
		paintHUD(g);
		
	}
	
	/**
	 * Method to update the <code>Canvas</code>.  Uses double buffering.
	 */
	public void update(Graphics g){
		
		// initialize buffer//
		if (dbImage == null){
			dbImage = createImage (this.getSize().width, this.getSize().height); 
			dbg = dbImage.getGraphics (); 
		} 
	
		// clear screen in background 
		dbg.setColor(getBackground ()); 
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height); 
	
		// draw elements in background 
		dbg.setColor(getForeground()); 
		paintComponent(dbg); 
	
		// draw image on the screen 
		g.drawImage(dbImage, 0, 0, this); 
	} 
	
	protected void paintTiles(Graphics g){
		
		Tile tile;

		for(int x=0; x<tilesNumX; x++){
			for(int y=0; y<tilesNumY; y++){
				
				tile = screen.getTile(x, y);
				g.drawImage(tile.getImage(), tile.getX(), tile.getY(), tileWidth, tileHeight, this);
				//g.drawImage(tile.getImage(), tile.getX(), tile.getY(), this); for non resized images.
				
			}
		}
	}
	protected void paintEntities(Graphics g){
		Entity e;
		for(int i=0; i<entities.size(); i++){
			e = entities.get(i);
			g.drawImage(e.getImage(), e.getX(), e.getY(), this);
		}
	}
	protected void paintHUD(Graphics g){
		HUDElement h;
		for(int i=0; i<HUDElements.size(); i++){
			h = HUDElements.get(i);
			g.drawImage(h.getCurrentImage(), h.getX(), h.getY(), this);
		}
		
	}
	
}