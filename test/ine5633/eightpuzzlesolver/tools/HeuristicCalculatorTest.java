package ine5633.eightpuzzlesolver.tools;

import org.junit.Assert;
import org.junit.Test;

public class HeuristicCalculatorTest extends AbstractInstantiationTest {

	@Override
	public Class<?> getClassToTest() {
		return HeuristicCalculator.class;
	}
	
	@Test
	public void shouldReturnAllBlocksOutOfPlace() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] current = new Integer[][]{{null,7,8},{5,6,3},{4,1,2}};
		Integer blocksOutOfPlace = HeuristicCalculator.blocksOutOfPlace(current, objective);
		Assert.assertEquals(new Integer(9), blocksOutOfPlace);
	}
	
	@Test
	public void shouldReturnAllBlocksNotNullOutOfPlace() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] current = new Integer[][]{{2,7,8},{5,6,3},{4,1,null}};
		Integer blocksOutOfPlace = HeuristicCalculator.blocksOutOfPlace(current, objective);
		Assert.assertEquals(new Integer(8), blocksOutOfPlace);
	}
	
	@Test
	public void shouldReturnNoneBlocksOutOfPlace() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] current = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer blocksOutOfPlace = HeuristicCalculator.blocksOutOfPlace(current, objective);
		Assert.assertEquals(new Integer(0), blocksOutOfPlace);
	}
	
	@Test
	public void shouldReturnAManhathanDistanceEqualsZero() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] current = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer blocksOutOfPlace = HeuristicCalculator.manhattanDistance(current, objective);
		Assert.assertEquals(new Integer(0), blocksOutOfPlace);
	}
	
	@Test
	public void shouldReturnAManhathanDistanceGreaterThanZero() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] current = new Integer[][]{{1,2,3},{4,5,6},{7,null,8}};
		Integer blocksOutOfPlace = HeuristicCalculator.manhattanDistance(current, objective);
		Assert.assertEquals(new Integer(2), blocksOutOfPlace);
	}
	
	@Test
	public void shouldReturnAManhathanDistanceGreaterThanZeroVerifyNull() {
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,null,8}};
		Integer[][] current = new Integer[][]{{1,null,3},{4,5,6},{8,2,7}};
		Integer blocksOutOfPlace = HeuristicCalculator.manhattanDistance(current, objective);
		Assert.assertEquals(new Integer(8), blocksOutOfPlace);
	}
	
	
	

}
