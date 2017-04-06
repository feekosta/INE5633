package ine5633.eightpuzzlesolver.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ine5633.eightpuzzlesolver.model.Coordinate;

public class BlankFinderTest extends AbstractInstantiationTest{
	
	@Test
	public void shouldFindABlankCoordinate() {
		Coordinate find = BlankFinder.find(new Integer[][]{{1,2,null},{4,5,6},{7,8,9}});
		assertNotNull(find);
		assertEquals(new Integer(1), find.getX());
		assertEquals(new Integer(3), find.getY());
	}
	
	@Test
	public void shouldReturnNullWithABlankCoordinateNotExists() {
		Coordinate find = BlankFinder.find(new Integer[][]{{1,2,3},{4,5,6},{7,8,9}});
		assertNull(find);
	}

	@Override
	public Class<?> getClassToTest() {
		return BlankFinder.class;
	}

}
