package ine5633.eightpuzzlesolver.tools;

import ine5633.eightpuzzlesolver.model.Coordinate;

/**
 * Class used to find the position that is empty on a board
 * <br>Test class: {@link BlankFinderTest}
 * <br>@author feekosta
 */
public class BlankFinder {

	public BlankFinder() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Coordinate find(Integer [][] state){
		for(int row = 0; row < Coordinate.MAX; row ++){
			for(int column = 0; column < Coordinate.MAX; column++){
				if(state[row][column] == null){
					return new Coordinate(row+1, column+1);
				}
			}
		}
		return null;
	}
	
}
