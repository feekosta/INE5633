package ine5633.eightpuzzlesolver;

import java.util.ArrayList;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Node;
import ine5633.eightpuzzlesolver.tools.ArrayTools;
import ine5633.eightpuzzlesolver.tools.BoardValidator;
import ine5633.eightpuzzlesolver.tools.ChildNodesBuilder;
import ine5633.eightpuzzlesolver.tools.NodeComparator;

/**
 * Main game class, responsible for controlling all interaction 
 * to reach the smallest resolution path of the 8 puzzle.
 * <br>Stores :
 * <br>- a list of visited nodes,
 * <br>- the frontier,
 * <br>- the target state, 
 * <br>- the maximum number of nodes that were at the frontier.
 * <br>Test class: {@link EightPuzzleSolverTest}
 * <br>@author feekosta
 */
public class EightPuzzleSolver {
	
	private final ArrayList<Node> viewed;
	private final ArrayList<Node> frontier;
	private final Integer [][]  objective;
	private final ChildNodesBuilder childNodesBuilder;
	
	private Integer maxNodeInFrontier;
	private Integer evaluatedNodes;
	private Node solutionNode;

	public EightPuzzleSolver(Integer [][] objective) throws Exception {
		validate(objective);
		this.objective = objective;
		childNodesBuilder = new ChildNodesBuilder(objective);
		viewed = new ArrayList<>();
		frontier = new ArrayList<>();
		setMaxNodeInFrontier(0);
		setEvaluatedNodes(0);
	}
	
	public Integer getMaxNodeInFrontier() {
		return maxNodeInFrontier;
	}

	public void setMaxNodeInFrontier(Integer maxNodeInFrontier) {
		this.maxNodeInFrontier = maxNodeInFrontier;
	}
	
	public Integer getEvaluatedNodes() {
		return evaluatedNodes;
	}

	public void setEvaluatedNodes(Integer evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}

	public Node solv(Integer[][] state) throws Exception{
		validate(state);
		frontier.add(new Node.Builder(state).build());
		setMaxNodeInFrontier(1);
		work(); 
		return solutionNode;
	}

	private void validate(Integer[][] state) throws Exception {
		Boolean validate = BoardValidator.validate(state);
		if(!validate){
			throw new Exception("Board is invalid");
		}
	}

	private void work() {
		do {
			setEvaluatedNodes(getEvaluatedNodes() + 1);

			System.out.print("\n\ni "+getEvaluatedNodes()+" ---> ");
			
			Node node = frontier.iterator().next();
			System.out.print(node.printState()+"\n");
			
			if(frontier.size() > getMaxNodeInFrontier()){
				setMaxNodeInFrontier(frontier.size());
			}
			
			if(NodeComparator.isObjective(node, objective)){
				solutionNode = node;
				break;
			}
			
			frontier.remove(node);
			viewed.add(node);
			
			addInFrontier(childNodesBuilder.build(node));
			
			ArrayTools.sort(frontier);
			
		} while (frontier.iterator().hasNext());
		
	}

	private void addInFrontier(List<Node> children) {
		System.out.print("childs --> ");
		for (Node child : children) {
			System.out.print(child.printState()+"    ");
			if(!NodeComparator.isVisited(child, viewed)){
				frontier.add(child);
			}
		}
	}
	
}
