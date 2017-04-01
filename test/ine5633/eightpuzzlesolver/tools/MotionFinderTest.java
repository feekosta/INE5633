package ine5633.eightpuzzlesolver.tools;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.Coordinate;

public class MotionFinderTest extends AbstractInstantiationTest{
	
	@Test
	public void shouldFindFourMovimentsWhenIsCenterPosition(){
		List<Coordinate> coordinates = MotionFinder.find(new Coordinate(2, 2));
		Assert.assertEquals(4, coordinates.size());
	}

	@Override
	public Class<?> getClassToTest() {
		return MotionFinder.class;
	}

}
