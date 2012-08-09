package com.utilis.game.gui;

import java.awt.Graphics;

import com.utilis.game.obj.*;

public class ScrollingCanvas extends Canvas {
	
	protected int offsetX;
	protected int offsetY;
	
	protected ScrollingEntity centerEntity;
	
	public ScrollingCanvas(int xTiles, int yTiles, int tWidth, int tHeight){
		super(xTiles, yTiles, tWidth, tHeight);
	}
	
	public ScrollingEntity getCenterEntity() {
		return centerEntity;
	}
	public int getOffsetX() {
		return offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	
	public void setCenterEntity(ScrollingEntity sc){
		sc.setScroller(this);
		centerEntity = sc;
	}
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	
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
		paintTiles(dbg);
		paintEntities(dbg);
		paintHUD(dbg);
		
		// draw image on the screen 
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	public void update(Graphics g){
		
		paint(g);
		
	} 
	
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
