package ine5633.eightpuzzlesolver.tools;

import org.junit.Assert;
import org.junit.Test;

public class BoardValidatorTest extends AbstractInstantiationTest {

	@Override
	public Class<?> getClassToTest() {
		return BoardValidator.class;
	}
	
	
	@Test
	public void shouldReturnTrueIfBoardIsValid() {
		Integer[][] state = new Integer[][]{{null,7,8},{5,6,3},{4,1,2}};
		Boolean validate = BoardValidator.validate(state);
		Assert.assertTrue(validate);
	}
	
	@Test
	public void shouldReturnFalseIfBoardIsInvalid() {
		Integer[][] state = new Integer[][]{{null,8,7},{5,6,3},{4,1,2}};
		Boolean validate = BoardValidator.validate(state);
		Assert.assertFalse(validate);
	}

}
