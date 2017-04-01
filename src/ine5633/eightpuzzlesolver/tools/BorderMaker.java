package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.List;

import ine5633.eightpuzzlesolver.Coordinate;

/**
 * Classe utilizada para gerar os novos estados para a fronteira (nodos filhos)
 * Test class {@link BorderMakerTest}
 * @author feekosta
 */
public class BorderMaker {
	
	public BorderMaker() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static List<Integer[][]> make(Integer[][] currentState, Coordinate blankCoordinate, List<Coordinate> coordinates){
		
		List<Integer [][]> border = new ArrayList<>(); 
		
		for (Coordinate coordinate : coordinates) {
			border.add(makeState(currentState, blankCoordinate, coordinate));
		}
		
		return border;
	}

	private static Integer[][] makeState(Integer[][] currentState, Coordinate blankCoordinate, Coordinate coordinate) {
		Integer[][] state = ArrayCopy.deepCopy(currentState);

		Integer blankValue = state[blankCoordinate.getX()-1][blankCoordinate.getY()-1];
		Integer value = state[coordinate.getX()-1][coordinate.getY()-1];
		
		state[coordinate.getX()-1][coordinate.getY()-1] = blankValue;	 
		state[blankCoordinate.getX()-1][blankCoordinate.getY()-1] = value;

		return state;
	}

}
