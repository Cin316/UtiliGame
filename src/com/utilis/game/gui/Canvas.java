package com.utilis.game.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.utilis.game.obj.Screen;
import com.utilis.game.obj.Tile;


public class Canvas extends JPanel{
		
	protected int tileWidth, tileHeight;
	protected int tilesNumX, tilesNumY;
	
	protected Screen screen;
	
	protected Image dbImage;
	protected Graphics dbg;
	
	public Canvas(int xTiles, int yTiles, int tWidth, int tHeight){
		
		tilesNumX = xTiles;
		tilesNumY = yTiles;
		tileWidth = tWidth;
		tileHeight = tHeight;
		
		screen = new Screen(tilesNumX, tilesNumY, tileWidth, tileHeight);
	}
	
	
	public Screen getScreen() {
		return screen;
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	public int getTileHeight() {
		return tileHeight;
	}
	public int getTilesNumX() {
		return tilesNumX;
	}
	public int getTilesNumY() {
		return tilesNumY;
	}
	
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	public void setTilesNumX(int tilesNumX) {
		this.tilesNumX = tilesNumX;
	}
	public void setTilesNumY(int tilesNumY) {
		this.tilesNumY = tilesNumY;
	}

	public void paintComponent(Graphics g){
		
		paintTiles(g);
		paintEntities(g);
		paintHUD(g);
		
	}

	public void update (Graphics g){
	// initialize buffer
	// TODO Re-export and clean up this code and other code.
	if (dbImage == null){
	dbImage = createImage (this.getSize().width, this.getSize().height); 
	dbg = dbImage.getGraphics (); 
	} 

	// clear screen in background 
	dbg.setColor (getBackground ()); 
	dbg.fillRect (0, 0, this.getSize().width, this.getSize().height); 

	// draw elements in background 
	dbg.setColor (getForeground()); 
	paint (dbg); 

	// draw image on the screen 
	g.drawImage (dbImage, 0, 0, this); 
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
		
	}
	protected void paintHUD(Graphics g){
	
	}
	
}