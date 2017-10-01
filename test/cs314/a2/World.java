package cs314.a2;
public class World {
	
/*
 * File: World.java
 * Author: Sadie Henry
 * Date: 9/25/2015
 * Class: CS314
 * 
 * This class represents a World that is n objects wide and m objects tall. 
 * Get and Put methods are implemented in terms of both Coordinate and standard x y.	
 */
	
	// global variables
	protected int n;
	protected int m;
	protected Object[][] objects;

	// standard constructor
	public World(int n, int m){
		
		if(n < 1 || m < 1){
			throw new IllegalArgumentException("n and m must be greater than 0");
		}
		this.n = n;
		this.m = m;
		objects = new Object[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				objects[i][j] = null;
			}
		}
	}
	
	// 1-argument constructor (calls standard constructor)
	public World(int n){
		
		this(n, n);		
	}
	
	// retrieves object from Objects array, does not check bounds
	protected Object get(int x, int y){
		
		return objects[y][x];
	}
	
	// puts object in Object array, does not check bounds
	protected void put(int x, int y, Object o){
		
		objects[y][x] = o;
	}
	
	// puts object at Coordinate c, bounds handled by coordinate
	public Object get(Coordinate c){
		
		return c.get();		
	}
	
	// puts object at Coordinate c, bounds handled by coordinate
	public void put(Coordinate c, Object o){
		
		c.put(o);
	}
	
	// basic toString override method
	public String toString(){
		
		return "World(" + n + "," + m + ")";
		
	}
	
}
