package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Coordinate;

/**
 * Class used to generate the new states for the border
 * <br>Test class {@link BorderMakerTest}
 * <br>@author feekosta
 */
public class BorderMaker {
	
	public BorderMaker() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static List<Integer[][]> make(Integer[][] currentState, Coordinate blankCoordinate, List<Coordinate> coordinates){
		List<Integer [][]> border = new ArrayList<>(); 
		for (Coordinate coordinate : coordinates) {
			border.add(make(currentState, blankCoordinate, coordinate));
		}
		return border;
	}

	private static Integer[][] make(Integer[][] currentState, Coordinate blankCoordinate, Coordinate coordinate) {
		Integer[][] state = ArrayTools.deepCopy(currentState);
		Integer blankValue = state[blankCoordinate.getX()-1][blankCoordinate.getY()-1];
		Integer value = state[coordinate.getX()-1][coordinate.getY()-1];
		state[coordinate.getX()-1][coordinate.getY()-1] = blankValue;	 
		state[blankCoordinate.getX()-1][blankCoordinate.getY()-1] = value;
		return state;
	}

}
