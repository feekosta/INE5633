package ine5633.tools;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.Coordinate;

public class MotionFinderTest {
	
	@Test
	public void shouldFindFourMovimentsWhenIsCenterPosition(){
		List<Coordinate> coordinates = MotionFinder.find(new Coordinate(2, 2));
		Assert.assertEquals(4, coordinates.size());
	}

}
