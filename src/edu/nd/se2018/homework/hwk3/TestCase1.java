package edu.nd.se2018.homework.hwk3;
import org.junit.Test;

public class TestCase1 {
	@Test
	public void test() {
		Race race = new Race();
		race.consoleEnabled = false;
		race.register("Scooter",0,22,"early");
		race.register("Molly",1,24,"slow");
		race.register("Hannah",2,25,"early");
		race.register("Nick",3,25,"steady");
		race.register("Joey",4,25,"steady");
		String result = race.runRace();
		assert(result.equals("Winner is Molly"));
	}
}
