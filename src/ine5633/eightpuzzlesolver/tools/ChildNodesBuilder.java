package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Coordinate;
import ine5633.eightpuzzlesolver.model.Node;

/**
 * Class used to generate child nodes
 * <br>@author feekosta
 */
public class ChildNodesBuilder {
	
	private final Integer [][] objective;
	
	public ChildNodesBuilder(Integer [][] objective) {
		this.objective = objective;
	}
	
	public List<Node> build(Node node) {
		List<Node> children = new ArrayList<>();
		for (Integer[][] state : getChildStates(node)) {
			children.add(buildNode(node, state));
		}
		return children;
	}
	
	private List<Integer[][]> getChildStates(Node node) {
		Coordinate blankCoordinate = BlankFinder.find(node.getState());
		List<Coordinate> coordinates = MotionFinder.find(blankCoordinate);
		return BorderMaker.make(node.getState(), blankCoordinate, coordinates);
	}
	
	private Node buildNode(Node node, Integer[][] state) {
		return new Node.Builder(state)
			.level(node.getLevel()+1)
			.father(node)
			//.score(HeuristicCalculator.blocksOutOfPlace(state, objective))
			//.score(HeuristicCalculator.manhattanDistance(state, objective))
			.score(HeuristicCalculator.manhattanDistance(state, objective)+HeuristicCalculator.blocksOutOfPlace(state, objective))
			.build();
	}
	
}
