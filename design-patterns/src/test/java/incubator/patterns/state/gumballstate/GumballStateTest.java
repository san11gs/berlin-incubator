package incubator.patterns.state.gumballstate;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing gumball machine implemented with state pattern.
 * 
 * @author m.schuetz
 */
public class GumballStateTest {

	@Test
	public void testMachine() throws Exception{
		GumballMachine gumballMachine = new GumballMachine(5);

		assertEquals(NoQuarterState.class, gumballMachine.getState().getClass());
		
		gumballMachine.insertQuarter();
		
		assertEquals(HasQuarterState.class, gumballMachine.getState().getClass());

		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		assertEquals(NoQuarterState.class, gumballMachine.getState().getClass());
		assertEquals(3, gumballMachine.getCount());
	}
	
}
