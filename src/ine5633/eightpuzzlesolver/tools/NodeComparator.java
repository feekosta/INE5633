package ine5633.eightpuzzlesolver.tools;

import java.util.Arrays;
import java.util.List;

import ine5633.eightpuzzlesolver.Node;

/**
 * Classe utilizada para comparar estados de um tabuleiro
 * Test class: {@link NodeComparatorTest}
 * @author feekosta
 */
public class NodeComparator {

	public NodeComparator() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Boolean isObjective(Node current, Integer [][] objective){
		return assertEquals(current.getState(), objective);
	}
	
	public static Boolean isVisited(Node current, List<Node> nodes){
		for (Node node : nodes) {
			if(assertEquals(current.getState(), node.getState())){
				return true;
			}
		}
		return false;
	}
	
	private static Boolean assertEquals(Integer[][] current, Integer[][] objective) {
		return Arrays.deepEquals(current, objective);
	}
	
}
