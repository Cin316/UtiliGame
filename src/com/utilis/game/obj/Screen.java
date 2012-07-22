package com.utilis.game.obj;

/**
 * A class for storing and managing a two-dimensiona array of <code>Tiles</code>
 * @author Cin316
 * @see Tile
 */
public class Screen {
	
	/**
	 * the two-dimensional array of <code>Tiles</code>
	 */
	protected Tile[][] tiles;
	/**
	 * the number of pixels wide the <code>Tiles</code> in this <code>Screen</code> are
	 */
	protected int tileWidth;
	/**
	 * the number of pixels high the <code>Tiles</code> in this <code>Screen</code> are
	 */
	protected int tileHeight;
	/**
	 * the number of <code>Tiles</code> wide this <code>Screen</code> is
	 */
	protected int numOfTilesX;
	/**
	 * the number of <code>Tiles</code> high this <code>Screen</code> is
	 */
	protected int numOfTilesY;
	
	/**
	 * class constructor to create <code>Screen</code> with specified values
	 * @param tilesX the number of <code>Tiles</code> wide the <code>Screen</code> will be
	 * @param tilesY the number of <code>Tiles</code> high the <code>Screen</code> will be
	 * @param tHeight the height of the <code>Tiles</code>, measured in pixels
	 * @param tWidth the width of the <code>Tiles</code>, measured in pixels
	 */
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
	
	/**
	 * gets the number of <code>Tiles</code> wide this <code>Screen</code> is
	 * @return the current number of <code>Tiles</code> wide this <code>Screen</code> is
	 */
	public int getNumOfTilesX(){
		return numOfTilesX;
	}
	/**
	 * gets the number of <code>Tiles</code> high this <code>Screen</code> is
	 * @return the current number of <code>Tiles</code> high this <code>Screen</code> is
	 */
	public int getNumOfTilesY(){
		return numOfTilesY;
	}
	
	/**
	 * gets the width of the <code>Tiles</code> in this <code>Screen</code>, measured in pixels
	 * @return the width of the <code>Tiles</code> in this <code>Screen</code>
	 */
	public int getTileWidth(){
		return tileWidth;
	}
	/**
	 * gets the height of the <code>Tiles</code> in this <code>Screen</code>, measured in pixels
	 * @return the height of the <code>Tiles</code> in this <code>Screen</code>
	 */
	public int getTileHeight(){
		return tileHeight;
	}
	
	/**
	 * gets the specified <code>Tile</code> in this <code>Screen</code>
	 * @param x the x coordinate of the <code>Tile</code>
	 * @param y the y coordinate of the <code>Tile</code>
	 * @return the specified <code>Tile</code>
	 */
	public Tile getTile(int x, int y){
		return tiles[x][y];
	}
	/**
	 * sets the <code>Tile</code> specified by the x and y coordinates to the specified <code>Tile</code>
	 * @param x the x coordinate of the specified <code>Tile</code>
	 * @param y the y coordinate of the specified <code>Tile</code>
	 * @param t the <code>Tile</code> to set the specified <code>Tile</code> to
	 */
	public void setTile(int x, int y, Tile t){
		tiles[x][y] = t;
	}
	
}
