package com.utilis.game.obj;

import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionGroup {
	
	public class Collision{
		
		protected ArrayList<Collider> collided;
		protected boolean hasCollided;
		
		public Collision(ArrayList<Collider> c){
			collided = c;
			hasCollided = true;
		}
		public Collision(ArrayList<Collider> c, boolean b){
			collided = c;
			hasCollided = b;
		}

		public ArrayList<Collider> getCollided() {
			return collided;
		}
		public boolean hasCollided() {
			return hasCollided;
		}
		
		public void setCollided(ArrayList<Collider> collided) {
			this.collided = collided;
		}
		public void setHasCollided(boolean hasCollided) {
			this.hasCollided = hasCollided;
		}
		
	}
	
	protected ArrayList<Collider> colliders;
	protected boolean colliding = false;
	
	public CollisionGroup(){
		
	}
	
	public void add(Collider c){
		colliders.add(c);
	}
	
	public Collision checkCollision(){
		
		Collider collider1;
		Collider collider2;
		Rectangle intersection;
		int offset1X, offset1Y, offset2X, offset2Y;
		
		boolean collision = false;
		ArrayList<Collider> collided = new ArrayList<Collider>();
		
		// TODO Add code if there is only 1 collider to check;
		for(int c1=0; c1 <= colliders.size(); c1++){
			for(int c2=0; c2 <= colliders.size(); c2++){
				
				collider1 = colliders.get(c1);
				collider2 = colliders.get(c2);
				
				if(c1==c2){
					//Skips collision checking.
					collision = false;
				}else{
					//Checks collision.
					boolean intersects = false;
					if(collider1.getRectangle().intersects(collider2.getRectangle())){
						intersects = true;
						intersection = collider1.getRectangle().intersection(collider2.getRectangle());
						offset1X = intersection.x - collider1.getX();
						offset2X = intersection.x - collider2.getX();
						offset1Y = intersection.y - collider1.getY();
						offset2Y = intersection.y - collider2.getY();
						
						for(int x=0; x <= intersection.getWidth(); x++){
							for(int y=0; y <= intersection.getHeight(); y++){
								collision = collider1.getCollisionBox().getCollision(collider1.getX()+offset1X+x, collider1.getY()+offset1Y+y) && collider2.getCollisionBox().getCollision(collider2.getX()+offset2X+x, collider2.getY()+offset2Y+y) || collision;
								
							}
						}
					}else{
						collision = false;
					}
					if (collision){
						collided.add(collider1);
						collided.add(collider2);
					}
				}
					
			}
				
		}
		return new Collision(collided, collision);
	}
		
}
	

