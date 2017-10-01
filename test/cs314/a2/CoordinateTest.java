package cs314.a2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	@Test // standard x y
	public void testHashCode1() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(0,1,w);
		int expected = 0 + 1 +  w.hashCode();
		int result = c.hashCode();	
		assertTrue(expected == result);
	}

	@Test // x y greater than n m
	public void testHashCode2() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(4,5,w);
		int expected = 1 + 1 +  w.hashCode();
		int result = c.hashCode();	
		assertTrue(expected == result);
	}

	@Test // x y negative
	public void testHashCode3() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(-4,-7,w);
		int expected = 2 + 1 +  w.hashCode();
		int result = c.hashCode();	
		assertTrue(expected == result);
	}
	
	@Test // x y standard
	public void testCoordinate1() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(0,1,w);
		assertTrue(c.x == 0 && c.y == 1 && c.w == w);
	}
	
	@Test // x y greater than n m
	public void testCoordinate2() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(4,5,w);
		assertTrue(c.x == 1 && c.y == 1 && c.w == w);
	}
	
	@Test // x y negative
	public void testCoordinate3() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(-4,-7,w);
		assertTrue(c.x == 2 && c.y == 1 && c.w == w);
	}
	
	@Test // x y standard
	public void testGet1() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(1,2,w);
		String s = "test";
		w.put(1,2,s);
		assertTrue(c.get() == s);		
	}
	
	@Test // x y greater than n m
	public void testGet2() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(4,6,w);
		String s = "test";
		w.put(1,2,s);
		assertTrue(c.get() == s);		
	}
	
	@Test // x y negative
	public void testGet3() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(-5,-2,w);
		String s = "test";
		w.put(1,2,s);
		assertTrue(c.get() == s);		
	}

	@Test // x y standard
	public void testPut1() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(1,2,w);
		String s = "test";
		c.put(s);
		assertTrue(w.get(1, 2) == s);
	}

	@Test // x y greater than n m
	public void testPut2() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(4,6,w);
		String s = "test";
		c.put(s);
		assertTrue(w.get(1, 2) == s);
	}

	@Test // x y negative
	public void testPut3() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(-5,-2,w);
		String s = "test";
		c.put(s);
		assertTrue(w.get(1, 2) == s);
	}
	
	@Test // coordinates have same x, y, and world
	public void testEqualsObject1() {
		World w = new World(3,4);
		Coordinate c1 = new Coordinate(1,2,w);
		Coordinate c2 = new Coordinate(1,2,w);
		assertTrue(c1.equals(c2));
	}
	
	@Test // coordinates have same x and world, different y
	public void testEqualsObject2() {
		World w = new World(3,4);
		Coordinate c1 = new Coordinate(1,2,w);
		Coordinate c2 = new Coordinate(1,1,w);
		assertFalse(c1.equals(c2));
	}
	
	@Test // coordinates have same y and world, different x
	public void testEqualsObject3() {
		World w = new World(3,4);
		Coordinate c1 = new Coordinate(1,2,w);
		Coordinate c2 = new Coordinate(2,2,w);
		assertFalse(c1.equals(c2));
	}
	
	@Test // coordinates have same x and y, different world
	public void testEqualsObject4() {
		World w1 = new World(3,4);
		World w2 = new World(3,4);
		Coordinate c1 = new Coordinate(1,2,w1);
		Coordinate c2 = new Coordinate(1,2,w2);
		assertFalse(c1.equals(c2));
	}
	
	@Test // coordinates have same x, y, and world (wrapping)
	public void testEqualsObject5() {
		World w = new World(3,4);
		Coordinate c1 = new Coordinate(1,2,w);
		Coordinate c2 = new Coordinate(-2,6,w);
		assertTrue(c1.equals(c2));
	}
	
	@Test // starting in the middle of world
	public void testNorth1() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,1,w);
		Coordinate c2 = new Coordinate(1,0,w);
		assertTrue(c1.north().equals(c2));
	}
	
	@Test // starting at north edge of world
	public void testNorth2() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,0,w);
		Coordinate c2 = new Coordinate(1,2,w);
		assertTrue(c1.north().equals(c2));
	}
	
	@Test // starting below south edge of world
	public void testNorth3() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,3,w);
		Coordinate c2 = new Coordinate(1,2,w);
		assertTrue(c1.north().equals(c2));
	}

	@Test // starting in the middle of world
	public void testEast1() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,1,w);
		Coordinate c2 = new Coordinate(2,1,w);
		assertTrue(c1.east().equals(c2));
	}
	
	@Test // starting at east edge of world
	public void testEast2() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(2,1,w);
		Coordinate c2 = new Coordinate(0,1,w);
		assertTrue(c1.east().equals(c2));
	}
	
	@Test // starting to the left of west edge of world
	public void testEast3() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(-1,1,w);
		Coordinate c2 = new Coordinate(0,1,w);
		assertTrue(c1.east().equals(c2));
	}

	@Test // starting in the middle of world
	public void testSouth1() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,1,w);
		Coordinate c2 = new Coordinate(1,2,w);
		assertTrue(c1.south().equals(c2));
	}
	
	@Test // starting at south edge of world
	public void testSouth2() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,2,w);
		Coordinate c2 = new Coordinate(1,0,w);
		assertTrue(c1.south().equals(c2));
	}
	
	@Test // starting above north edge of world
	public void testSouth3() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,-1,w);
		Coordinate c2 = new Coordinate(1,0,w);
		assertTrue(c1.south().equals(c2));
	}

	@Test // starting at the middle of world
	public void testWest1() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(1,1,w);
		Coordinate c2 = new Coordinate(0,1,w);
		assertTrue(c1.west().equals(c2));
	}
	
	@Test // starting at west edge of world
	public void testWest2() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(0,1,w);
		Coordinate c2 = new Coordinate(2,1,w);
		assertTrue(c1.west().equals(c2));
	}
	
	@Test // starting to the right of east edge of world
	public void testWest3() {
		World w = new World(3,3);
		Coordinate c1 = new Coordinate(3,1,w);
		Coordinate c2 = new Coordinate(2,1,w);
		assertTrue(c1.west().equals(c2));
	}

	@Test
	public void testToString() {
		World w = new World(3,4);
		Coordinate c = new Coordinate(1,2,w);
		String s = c.toString();
		assertTrue(s.equals("Coordinate (1,2) in World(3,4)"));
	}

}
