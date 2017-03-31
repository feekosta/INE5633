package ine5633.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ine5633.Coordinate;

public class BlankFinderTest {
	
	@Test
	public void shouldFindABlankCoordinate() {
		Coordinate find = BlankFinder.find(new Integer[][]{{1,2,null},{4,5,6},{7,8,9}});
		assertNotNull(find);
		assertEquals(new Integer(1), find.getX());
		assertEquals(new Integer(3), find.getY());
	}

}
