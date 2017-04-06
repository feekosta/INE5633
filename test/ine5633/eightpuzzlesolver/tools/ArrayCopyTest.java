package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ine5633.eightpuzzlesolver.model.Node;
import ine5633.eightpuzzlesolver.tools.ArrayTools;

public class ArrayCopyTest extends AbstractInstantiationTest {

	@Override
	public Class<?> getClassToTest() {
		return ArrayTools.class;
	}

	@Test
	public void shouldDeepCopyAMultidimensionalArray(){
		Integer[][] original = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Integer[][] deepCopy = ArrayTools.deepCopy(original);
		deepCopy[0][0] = null;
		Assert.assertEquals(new Integer(1), original[0][0]);
		Assert.assertNull(deepCopy[0][0]);
	}
	
	@Test
	public void shouldPrintAMultidimensionalArrayByNode(){
		Integer[][] original = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		Node n1 = new Node.Builder(original).build();
		Node n2 = new Node.Builder(original).father(n1).build();
		Boolean print = ArrayTools.print(n2);
		Assert.assertTrue(print);
	}
	
	@Test
	public void shouldSortAMultidimensionalArrayByLevelAndScore(){
		Integer[][] original = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		List<Node> frontier = new ArrayList<>();
		Node n1 = new Node.Builder(original).level(1).score(4).build();
		frontier.add(n1);
		Node n2 = new Node.Builder(original).level(2).score(1).build();
		frontier.add(n2);
		ArrayTools.sort(frontier);
		Assert.assertEquals(n2, frontier.get(0));
	}

}
