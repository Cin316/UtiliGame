package com.utilis.game.obj;

public class Screen {
	
	protected Tile[][] tiles;
	protected int tileWidth, tileHeight;
	protected int numOfTilesX, numOfTilesY;
	
	public Screen(int tilesX, int tilesY, int tHeight, int tWidth){
		numOfTilesX = tilesX;
		numOfTilesY = tilesY;
		tileHeight = tHeight;
		tileWidth = tWidth;
		tiles = new Tile[tilesX][tilesY];
		
		for(int x=0; x<tilesX; x++){
			for(int y=0; y<tilesY; y++){
				tiles[x][y] = new Tile(tileWidth, tileHeight, x*tileWidth, y*tileHeight);
			}
		}
	}
	
	public int getNumOfTilesX(){
		return numOfTilesX;
	}
	public int getNumOfTilesY(){
		return numOfTilesY;
	}
	
	public int getTileWidth(){
		return tileWidth;
	}
	public int getTileHeight(){
		return tileHeight;
	}
	
	public Tile getTile(int x, int y){
		return tiles[x][y];
	}
	public void setTile(int x, int y, Tile t){
		tiles[x][y] = t;
	}
	
}
