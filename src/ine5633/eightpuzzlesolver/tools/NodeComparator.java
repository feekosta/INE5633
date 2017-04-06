package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Node;

/**
 * Class used to compare states of a board
 * <br>Test class: {@link NodeComparatorTest}
 * <br>@author feekosta
 */
public class NodeComparator {

	public NodeComparator() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Boolean isObjective(Node current, Integer [][] objective){
		return assertEquals(current.getState(), objective);
	}
	
	public static Boolean isVisited(Node current, ArrayList<Node> nodes){
		for (Node node : nodes) {
			if(assertEquals(current.getState(), node.getState())){
				return updateVisited(current, nodes, node);
			}
		}
		return false;
	}

	private static Boolean assertEquals(Integer[][] current, Integer[][] objective) {
		return Arrays.deepEquals(current, objective);
	}

	private static Boolean updateVisited(Node current, List<Node> nodes, Node node) {
		if(current.getScoreWithLevel().compareTo(node.getScoreWithLevel()) >= 0){
			return true;
		} else {
			nodes.remove(node);
			return nodes.add(current);
		}
	}
	
}
