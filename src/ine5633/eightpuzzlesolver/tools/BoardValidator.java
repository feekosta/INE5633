package ine5633.eightpuzzlesolver.tools;

import ine5633.eightpuzzlesolver.model.Coordinate;

/**
 * Class used to validate whether a tray is soluble or not
 * <br>Test class: {@link BoardValidatorTest}
 * <br>@author feekosta
 */
public class BoardValidator {

	public BoardValidator() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Boolean validate(Integer [][] tiles){
		Integer totalInversions = 0;
		for(int row = 0; row < Coordinate.MAX; row++){
			for(int column = 0; column < Coordinate.MAX; column++){
				Integer currentValue = tiles[row][column];
				if(currentValue != null){
					totalInversions += calculeInversions(currentValue, new Coordinate(row, column), tiles);
				}
			}
		}
		if(Math.floorMod(totalInversions, 2) != 0){
			return false;
		}
		return true;
	}

	/**
	 * Sum of successor values that are less than the reported value, 
	 * If odd, then the board has no resolution, if even, it is a tray that has solution 
	 * @param currentValue
	 * @param coordinate
	 * @param tiles
	 * @return
	 */
	private static Integer calculeInversions(Integer currentValue, Coordinate coordinate, Integer[][] tiles) {
		Integer inversions = 0;
		for(int x = 0; x < Coordinate.MAX; x++){
			for(int y = 0; y < Coordinate.MAX; y++){
				if(new Coordinate(x, y).getXYConcat().compareTo(coordinate.getXYConcat()) < 0){
					continue;
				}
				Integer value = tiles[x][y];
				if(value != null && currentValue > value){
					inversions++;
				}
			}
		}
		return inversions;
	}
}
