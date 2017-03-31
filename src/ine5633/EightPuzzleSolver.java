package ine5633;

import java.util.List;

public class EightPuzzleSolver {
	
	private Integer [][]  objective;
	private List<Node> viewed;
	private List<Node> frontier;

	public EightPuzzleSolver() {
		setObjective(new Integer[][]{{1,2,3},{4,5,6},{7,8,null}});
	}

	public Integer [][] getObjective() {
		return objective;
	}

	public void setObjective(Integer [][] objective) {
		this.objective = objective;
	}

	public List<Node> getFrontier() {
		return frontier;
	}

	public void setFrontier(List<Node> frontier) {
		this.frontier = frontier;
	}

	public List<Node> getViewed() {
		return viewed;
	}

	public void setViewed(List<Node> viewed) {
		this.viewed = viewed;
	}
	
}
