package cs314.a2;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	@Test // positive m n
	public void testWorldIntInt1() {
		World w = new World(2,3);
		assertTrue(w.m == 3);
		assertTrue(w.n == 2);
	}
	
	@Test // m n less than 1 (throws exception)
	public void testWorldIntInt2() {
		boolean thrown = false;
		try{
			World w = new World(0,0);
		}
		catch(IllegalArgumentException e){
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test // positive n
	public void testWorldInt1() {
		World w = new World(2);
		assertTrue(w.m == 2);
		assertTrue(w.n == 2);
	}
	
	@Test // n less than 1 (throws exception)
	public void testWorldInt2() {
		boolean thrown = false;
		try{
			World w = new World(0);
		}
		catch(IllegalArgumentException e){
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test // standard x y
	public void testGetIntInt1() {
		World w = new World(3,4);
		String s = "test";
		w.objects[1][0] = s;
		assertTrue(w.get(0,1).equals(s));
	}
	
	@Test // negative x y
	public void testGetIntInt2() {
		World w = new World(3,4);
		boolean thrown = false;
		try{
			w.get(-1, -1);
		}
		catch(ArrayIndexOutOfBoundsException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test // x y greater than n m
	public void testGetIntInt3() {
		World w = new World(3,4);
		boolean thrown = false;
		try{
			w.get(3, 4);
		}
		catch(ArrayIndexOutOfBoundsException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test // standard x y
	public void testPutIntIntObject1() {
		World w = new World(3,4);
		String s = "test";
		w.put(0,1,s);
		assertTrue(w.objects[1][0] == s);
	}

	@Test // negative x y
	public void testPutIntIntObject2() {
		World w = new World(3,4);
		String s = "test";
		boolean thrown = false;
		try{
			w.put(-1,-1,s);
		}
		catch(ArrayIndexOutOfBoundsException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test // x y greater than n m
	public void testPutIntIntObject3() {
		World w = new World(3,4);
		String s = "test";
		boolean thrown = false;
		try{
			w.put(3,4,s);
		}
		catch(ArrayIndexOutOfBoundsException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test // standard x y
	public void testGetCoordinate() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(1,2,w);
		String s = "test";
		w.put(1,2,s);
		assertTrue(c.get() == s);
	}

	@Test // standard x y
	public void testPutCoordinateObject() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(1,2,w);
		String s = "test";
		c.put(s);
		assertTrue(w.get(1,2) == s);
	}

	@Test // standard input
	public void testToString() {
		World w = new World(4,5);
		assertTrue(w.toString().equals("World(4,5)"));
	}

}
