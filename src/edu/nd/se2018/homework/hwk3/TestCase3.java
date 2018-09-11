package edu.nd.se2018.homework.hwk3;
import org.junit.Test;
// Test that the clear function works, and identify the fastest strategy for horses starting at the same rate
// Test the console enabling feature function correctly
// Test when horses start at the same speed, with the same strategy, then the first horse will win
public class TestCase3 {
	@Test
	public void test() {
		Race race = new Race();
		race.consoleEnabled = false;
		race.register("bob",12,12,"slow");
		race.register("bo",14,12,"early");
		race.register("bobby",15,12,"steady");
		String result = race.runRace();
		System.out.println(result);
		assert(result.equals("Winner is bob"));
		race.clear();
		race.consoleEnabled = true;
		race.register("jack",12,1,"slow");
		race.register("john",14,1,"slow");
		race.register("jo",15,1,"slow");
		result = race.runRace();
		System.out.println(result);
		assert(result.equals("Winner is jack"));
	}
}
