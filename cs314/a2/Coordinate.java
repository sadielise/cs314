package cs314.a2;

/*
 * File: Coordinate.java
 * Author: Sadie Henry
 * Date: 9/25/2015
 * Class: CS314
 * 
 * This class represents a Coordinate at position x,y in World w. 
 * x and y are always valid coordinates and are handled by wrapping (modulo math).
 */

public class Coordinate {
	
	// global variables
	protected World w;
	protected int x;
	protected int y;
	
	// constructor (handles wrapping)
	public Coordinate(int x, int y, World w){
		
		if(x < 0){
			while(x < 0){
				x += w.n;
			}
		}		
		this.x = x % w.n;
		
		if(y < 0){
			while(y < 0){
				y += w.m;
			}
		}
		this.y = y % w.m;
		
		this.w = w;
	}
	
	// returns coordinate's object, returns null if no object
	public Object get(){
		
		return w.get(this.x, this.y);
	}
	
	// puts an object in world at coordinate
	public void put(Object o){
		
		w.put(this.x, this.y, o);
	}
	
	// equals override method
	public boolean equals(Object other){
		
		if(other == null)
			return false;
		
		if(this.getClass() != other.getClass())
			return false;
		
		if(this.w != ((Coordinate)other).w)
			return false;
		
		if((this.x == ((Coordinate)other).x) && (this.y == ((Coordinate)other).y))
			return true;
			
		return false;
	}
	
	// returns x + y + hashCode of world
	public int hashCode(){
		
		return (this.x + this.y + this.w.hashCode());
	}
	
	// returns coordinate directly to the north
	public Coordinate north(){
		
		Coordinate c = new Coordinate(this.x, this.y-1, this.w);
		return c;		
	}
	
	// returns coordinate directly to the east
	public Coordinate east(){
		
		Coordinate c = new Coordinate(this.x+1, this.y, this.w);
		return c;
	}
	
	
	// returns coordinate directly to the south
	public Coordinate south(){
		
		Coordinate c = new Coordinate(this.x, this.y+1, this.w);
		return c;
	}
	
	// returns coordinate directly to the west
	public Coordinate west(){
		
		Coordinate c = new Coordinate(this.x-1, this.y, this.w);
		return c;
	}
	
	// toString override method
	public String toString(){
		
		return "Coordinate (" + this.x + "," + this.y + ") in World(" + this.w.n + "," + this.w.m + ")";
	}

}
