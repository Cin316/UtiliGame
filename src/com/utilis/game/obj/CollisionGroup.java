package com.utilis.game.obj;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * A class which stores <code>Colliders</code> and does the actual collision detection
 * @author Cin316
 * @see Collider
 * @see CollisionBox
 * @see Collision
 */
public class CollisionGroup {
	
	/**
	 * A class which stores the values of a collision - the <code>Colliders</code> which collided, and whether or not a collision actually occurred.
	 * @author Cin316
	 * @see CollisionGroup
	 */
	public class Collision{
		
		/**
		 * the list of <code>Colliders</code> which collided
		 */
		protected ArrayList<Collider> collided;
		/**
		 * whether or not a collision occurred
		 */
		protected boolean hasCollided;
		
		/**
		 * Class constructor which sets <code>collided</code> to the specified <code>ArrayList</code> and sets <code>hasCollided</code> to <code>true</code>
		 * @param c the <code>ArrayList</code> to set <code>collided</code> to
		 */
		public Collision(ArrayList<Collider> c){
			collided = c;
			hasCollided = true;
		}
		/**
		 * Class constructor which sets <code>collided</code> to the specified <code>ArrayList</code> and sets <code>hasCollided</code> to the specified <code>boolean</code>
		 * @param c the <code>ArrayList</code> to set <code>collided</code> to
		 * @param b the boolean to set <code>hasCollided</code> to
		 */
		public Collision(ArrayList<Collider> c, boolean b){
			collided = c;
			hasCollided = b;
		}
		
		/**
		 * gets the current value of <code>collided</code>
		 * @return the current <code>ArrayList</code> of <code>Colliders</code>
		 */
		public ArrayList<Collider> getCollided() {
			return collided;
		}
		/**
		 * gets the current value of <code>hasCollided</code>
		 * @return the value of <code>hasCollided</code>
		 */
		public boolean hasCollided() {
			return hasCollided;
		}
		
		/**
		 * sets <code>collided</code> to the specified <code>ArrayList</code>
		 * @param collided <code>ArrayList</code> to set <code>collided</code> to
		 */
		public void setCollided(ArrayList<Collider> collided) {
			this.collided = collided;
		}
		/**
		 * sets <code>hasCollided</code> to the specified <code>boolean</code>
		 * @param hasCollided <code>boolean</code> to set <code>hasCollided</code> to
		 */
		public void setHasCollided(boolean hasCollided) {
			this.hasCollided = hasCollided;
		}
		
	}
	
	/**
	 * list of <code>Colliders</code> that collide with each other in this <code>CollisionGroup</code>
	 */
	protected ArrayList<Collider> colliders;
	/**
	 * whether or not any <code>Collision</code> is occurring right now
	 */
	protected boolean colliding = false;
	
	/**
	 * Class constructor
	 */
	public CollisionGroup(){
		colliders = new ArrayList<Collider>();
	}
	
	/**
	 * Adds the specified <code>Collider</code> to <code>colliders</code>
	 * @param c <code>Collider</code> to be added to <code>colliders</code>
	 */
	public void add(Collider c){
		colliders.add(c);
	}
	
	/**
	 * checks if any of the <code>Colliders</code> in this <code>CollisionGroup</code> are colliding, and returns an instance of <code>Collision</code>
	 * @return instance of <code>Collision</code> with information about the current Collision
	 */
	public Collision checkCollision(){
		
		Collider collider1;
		Collider collider2;
		Rectangle intersection;
		int offset1X, offset1Y, offset2X, offset2Y;
		
		boolean collision = false;
		ArrayList<Collider> collided = new ArrayList<Collider>();
		
		if( !(collided.size() == 1 || collided.size() == 0) ){
			for(int c1=0; c1 <= colliders.size(); c1++){
				for(int c2=0; c2 <= colliders.size(); c2++){
					
					collider1 = colliders.get(c1);
					collider2 = colliders.get(c2);
					
					if(c1==c2 || ((collider1 instanceof Tile)&&(collider2 instanceof Tile)) ){
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
		}
		return new Collision(collided, collision);
	}
		
}
	

