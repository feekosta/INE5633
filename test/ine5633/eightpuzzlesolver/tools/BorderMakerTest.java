package ine5633.eightpuzzlesolver.tools;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.Coordinate;
import ine5633.eightpuzzlesolver.Node;

public class BorderMakerTest extends AbstractInstantiationTest{
	
	
	@Test
	public void shouldMakeABorderWithTwoStates(){
		
		Node node = new Node();
		node.setState(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
		
		Coordinate blankCoordinate = BlankFinder.find(node.getState());
		List<Coordinate> coordinates = MotionFinder.find(blankCoordinate);
		
		List<Integer[][]> make = BorderMaker.make(node.getState(), blankCoordinate, coordinates);
		for (Integer[][] integers : make) {
			System.out.println(Arrays.deepToString(integers));
		}
		
		Assert.assertEquals(2, make.size());
		Assert.assertNull(make.get(0)[coordinates.get(0).getX()-1][coordinates.get(0).getY()-1]);
		Assert.assertNull(make.get(1)[coordinates.get(1).getX()-1][coordinates.get(1).getY()-1]);
	}

	@Override
	public Class<?> getClassToTest() {
		return BorderMaker.class;
	}

}
