package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.model.Node;

public class NodeComparatorTest extends AbstractInstantiationTest{
	
	@Test
	public void shouldReturnTrueIfNodeIsObjective(){
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node current = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).build();
		Boolean isObjective = NodeComparator.isObjective(current, objective);
		Assert.assertTrue(isObjective);
	}
	
	@Test
	public void shouldReturnFalseIfNodeIsntObjective(){
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node current = new Node.Builder(new Integer[][]{{1,2,3},{null,5,6},{7,8,5}}).build();
		Boolean isObjective = NodeComparator.isObjective(current, objective);
		Assert.assertFalse(isObjective);
	}
	
	@Test
	public void shouldReturnTrueIfNodeIsVisited(){
		Node n1 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).score(1).level(1).build();
		Node n2 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,null,8}}).score(1).level(2).build();
		List<Node> nodes = Arrays.asList(n1, n2);
		Node current = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).score(1).level(1).build();
		Boolean isObjective = NodeComparator.isVisited(current, new ArrayList<>(nodes));
		Assert.assertTrue(isObjective);
	}
	
	@Test
	public void shouldReturnTrueIfNodeIsVisitedAndUpdateVisiteds(){
		Node n1 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).score(3).level(2).build();
		Node n2 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,null,8}}).score(1).level(2).build();
		List<Node> nodes = Arrays.asList(n1, n2);
		Node current = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).score(1).level(1).build();
		Boolean isObjective = NodeComparator.isVisited(current, new ArrayList<>(nodes));
		Assert.assertTrue(isObjective);
	}
	
	@Test
	public void shouldReturnFalseIfNodeIsntVisited(){
		Node n1 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}}).build();
		Node n2 = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{7,null,8}}).build();
		List<Node> nodes = Arrays.asList(n1, n2);
		Node current = new Node.Builder(new Integer[][]{{1,2,3},{4,5,6},{null,8,9}}).build();
		Boolean isObjective = NodeComparator.isVisited(current, new ArrayList<>(nodes));
		Assert.assertFalse(isObjective);
	}

	@Override
	public Class<NodeComparator> getClassToTest() {
		return NodeComparator.class;
	}

}
