package ine5633.eightpuzzlesolver;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.model.Node;

public class EightPuzzleSolverTest {
	
	@Test
	public void shouldReturnLeafNodeWhenBoardIsValid() throws Exception {
		Integer[][] state = new Integer[][]{{null,7,8},{5,6,3},{4,1,2}};
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node solv = new EightPuzzleSolver(objective).solv(state);
		Assert.assertNotNull(solv);
	}
	
	@Test
	public void shouldReturnsMinimumValueNodesInFrontierWhenTheEvaluatedNodeIsTheTargetNode() throws Exception {
		Integer[][] state = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		EightPuzzleSolver eightPuzzleSolver = new EightPuzzleSolver(objective);
		Node solv = eightPuzzleSolver.solv(state);
		Assert.assertNotNull(solv);
		Assert.assertEquals(new Integer(1), eightPuzzleSolver.getMaxNodeInFrontier());
	}
	
	@Test(expected=Exception.class)
	public void shouldThrowExceptionWhenWhenBoardIsInvalid() throws Exception {
		Integer[][] state = new Integer[][]{{null,8,7},{5,6,3},{4,1,2}};
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		new EightPuzzleSolver(objective).solv(state);
	}

}
