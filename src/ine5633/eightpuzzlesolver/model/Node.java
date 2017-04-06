package ine5633.eightpuzzlesolver.model;

import ine5633.eightpuzzlesolver.tools.ArrayTools;

/**
 * This class represents a node in a graph
 * <br>stores the : 
 * <br>- state of the board, 
 * <br>- the level in the graph, 
 * <br>- the cost of this node, 
 * <br>- the reference to the parent node
 * <br>@author feekosta
 */
public class Node {

	private Integer [][] state;
	private Integer level;
	private Node father;
	private Integer score;

	public Node(Builder builder) {
		setState(builder.state);
		setLevel(builder.level);
		setFather(builder.father);
		setScore(builder.score);
	}

	public Integer [][] getState() {
		return state;
	}

	public void setState(Integer [][] state) {
		this.state = state;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	/**
	 * This method returns the total cost of this node
	 * @return total cost of this node
	 */
	public Integer getScoreWithLevel(){
		return getScore()+getLevel();
	}

	/**
	 * This method returns a string containing the path that was used in the graph to arrive at this node
	 * @return path
	 */
	public String printState() {
		return ArrayTools.print(getState(), "|");
	}
	
	/**
	 * Class used to instantiate an object of type node
	 * @author feekosta
	 */
	public static final class Builder {
		
		private final Integer [][] state;
		private Integer level;
		private Node father;
		private Integer score;
		
		public Builder(Integer [][] state) {
			this.state = state;
			this.level = 0;
			this.score = 0;
		}
		
		public Builder level(Integer level){
			this.level = level;
			return this;
		}
		
		public Builder father(Node father){
			this.father = father;
			return this;
		}

		public Builder score(Integer score){
			this.score = score;
			return this;
		}
		
		public Node build(){
			return new Node(this);
		}
		
	}

}
