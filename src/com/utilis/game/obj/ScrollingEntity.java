package com.utilis.game.obj;

import java.awt.Image;
import com.utilis.game.gui.*;

public class ScrollingEntity extends Entity {
	
	protected int realX;
	protected int realY;
	
	protected ScrollingCanvas scroller;
	
	public ScrollingEntity(int w, int h) {
		super(w, h);
	}
	public ScrollingEntity(Image i) {
		super(i);
	}
	public ScrollingEntity(CollisionBox c) {
		super(c);
	}
	public ScrollingEntity(Image i, CollisionBox c) {
		super(i, c);
	}
	
	public void moveUp(int n){
		scroller.setOffsetY(scroller.getOffsetY() - n);
		super.moveUp(n);
	}
	public void moveDown(int n){
		scroller.setOffsetY(scroller.getOffsetY() + n);
		super.moveDown(n);
	}
	public void moveLeft(int n){
		scroller.setOffsetX(scroller.getOffsetX() - n);
		super.moveLeft(n);
	}
	public void moveRight(int n){
		scroller.setOffsetX(scroller.getOffsetX() + n);
		super.moveRight(n);
	}
	
	public int getRealX() {
		return realX;
	}
	public int getRealY() {
		return realY;
	}
	public ScrollingCanvas getScroller() {
		return scroller;
	}
	
	public void setRealX(int realX) {
		this.realX = realX;
	}
	public void setRealY(int realY) {
		this.realY = realY;
	}
	public void setScroller(ScrollingCanvas scroller) {
		this.scroller = scroller;
	}
	
}
