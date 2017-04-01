package ine5633.eightpuzzlesolver.tools;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.Node;

public class NodeComparatorTest extends AbstractInstantiationTest{
	
	@Test
	public void shouldReturnTrueIfNodeIsObjective(){
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node current = new Node();
		current.setState(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
		Boolean isObjective = NodeComparator.isObjective(current, objective);
		Assert.assertTrue(isObjective);
	}
	
	@Test
	public void shouldReturnFalseIfNodeIsntObjective(){
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node current = new Node();
		current.setState(new Integer[][]{{1,2,3},{null,5,6},{7,8,5}});
		Boolean isObjective = NodeComparator.isObjective(current, objective);
		Assert.assertFalse(isObjective);
	}
	
	@Test
	public void shouldReturnTrueIfNodeIsVisited(){
		
		Node n1 = new Node();
		n1.setState(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
		
		Node n2 = new Node();
		n2.setState(new Integer[][]{{1,2,3},{4,5,6},{7,null,8}});
		
		List<Node> nodes = Arrays.asList(n1, n2);
		
		Node current = new Node();
		current.setState(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
		Boolean isObjective = NodeComparator.isVisited(current, nodes);
		Assert.assertTrue(isObjective);
	}
	
	@Test
	public void shouldReturnFalseIfNodeIsntVisited(){
		Node n1 = new Node();
		n1.setState(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
		
		Node n2 = new Node();
		n2.setState(new Integer[][]{{1,2,3},{4,5,6},{7,null,8}});
		
		List<Node> nodes = Arrays.asList(n1, n2);
		
		Node current = new Node();
		current.setState(new Integer[][]{{1,2,3},{4,5,6},{null,7,8}});
		Boolean isObjective = NodeComparator.isVisited(current, nodes);
		Assert.assertFalse(isObjective);
	}

	@Override
	public Class<NodeComparator> getClassToTest() {
		return NodeComparator.class;
	}

}
