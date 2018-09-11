package edu.nd.se2018.homework.hwk3;
import org.junit.Test;

public class TestCase2 {
	@Test
	public void test() {
		Race race2 = new Race();
		race2.consoleEnabled = false;
		race2.register("Scooter",0,22,"early");
		race2.register("Joey",4,25,"steady");
		String result = race2.runRace();
		System.out.println(result);
		assert(result.equals("Winner is Joey"));
		race2.clear();
		race2.register("Lone Ranger",1,22,"early");
		result = race2.runRace();
		assert(result.equals("Winner is Lone Ranger"));
	}
}
