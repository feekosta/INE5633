package ine5633.eightpuzzlesolver.tools;

import ine5633.eightpuzzlesolver.model.Coordinate;

/**
 * Class used to calculate heuristics
 * <br>Test class: {@link HeuristicCalculatorTest}
 * <br>@author feekosta
 */
public class HeuristicCalculator {

	public HeuristicCalculator() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	/**
	 * Method sums up the total of parts out of place
	 * @param current
	 * @param objective
	 * @return
	 */
	public static Integer blocksOutOfPlace(Integer[][] current, Integer[][] objective){
		Integer outOfPlace = 0;
		for(int row = 0; row < Coordinate.MAX; row++){
			for(int column = 0; column < Coordinate.MAX; column++){
				Integer currentValue = current[row][column];
				Integer objectiveValue = objective[row][column];
				if(currentValue != null){
					if(!currentValue.equals(objectiveValue)){
						outOfPlace++;
					}
				} else {
					if(objectiveValue != null){
						outOfPlace++;
					}
				}
			}
		}
		return outOfPlace;
		
	}
	
	/**
	 * Method sums the distance from a point X to the position of a point Y, for all points
	 * @param current
	 * @param objective
	 * @return
	 */
	public static Integer manhattanDistance(Integer[][] current, Integer[][] objective){
		Integer manhattanDistance = 0;
		for(int row = 0; row < Coordinate.MAX; row++){
			for(int column = 0; column < Coordinate.MAX; column++){
				Integer currentValue = current[row][column];
				Coordinate coordinate = getCoordinateByValue(objective, currentValue);
				manhattanDistance += manhattanDistance(new Coordinate(row+1, column+1), coordinate);
			}
		}
		return manhattanDistance;
		
	}
	
	/**
	 * Returns the coordinate of a value on the board
	 * @param current
	 * @param value
	 * @return
	 */
	private static Coordinate getCoordinateByValue(Integer[][] current, Integer value) {
		Coordinate response = null;
		for(int row = 0; row < Coordinate.MAX; row++){
			for(int column = 0; column < Coordinate.MAX; column++){
				Integer currentValue = current[row][column];
				if(currentValue != null){
					if(currentValue.equals(value)){
						response = new Coordinate(row+1, column+1);
						break;
					}
				} else {
					if(value == null){
						response = new Coordinate(row+1, column+1);
						break;
					}
				}
			}
		}
		return response;
	}

	/**
	 * returns the distance from a point X to the position of a point Y
	 * @param current
	 * @param objective
	 * @return
	 */
	public static Integer manhattanDistance(Coordinate current, Coordinate objective){
	    Integer x = Math.abs(current.getX()-objective.getX());
	    Integer y = Math.abs(current.getY()-objective.getY());
	    return x+y;
	}
	
}
