package cs314.a2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoordinateTest.class, WorldTest.class })
public class TestAll {
	public static void main(String[] args) {
	    Result result1 = JUnitCore.runClasses(WorldTest.class);
	    Result result2 = JUnitCore.runClasses(CoordinateTest.class);
	  }

}
