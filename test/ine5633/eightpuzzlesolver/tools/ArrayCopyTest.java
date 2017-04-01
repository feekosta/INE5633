package ine5633.eightpuzzlesolver.tools;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.tools.ArrayCopy;

public class ArrayCopyTest extends AbstractInstantiationTest {

	@Override
	public Class<?> getClassToTest() {
		return ArrayCopy.class;
	}
	
	@Test
	public void shouldDeepCopyAMultidimensionalArray(){
		Integer[][] original = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] deepCopy = ArrayCopy.deepCopy(original);
		
		deepCopy[0][0] = null;
		
		Assert.assertEquals(new Integer(1), original[0][0]);
		Assert.assertNull(deepCopy[0][0]);
	}

}
