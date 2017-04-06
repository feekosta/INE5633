package ine5633.eightpuzzlesolver;

import org.junit.Test;

import ine5633.eightpuzzlesolver.tools.AbstractInstantiationTest;

public class MainTest extends AbstractInstantiationTest {
	
	@Override
	public Class<?> getClassToTest() {
		return Main.class;
	}

	@Test
	public void shouldExecuteMain() throws Exception {
		Main.main(null);
	}

}
