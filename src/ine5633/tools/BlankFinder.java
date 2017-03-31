package ine5633.tools;

import ine5633.Coordinate;

/**
 * Classe utilizada para descobrir a posição que está vazia, dado um tabuleiro
 * Test class: {@link BlankFinderTest}
 * @author feekosta
 */
public class BlankFinder {

	public static Coordinate find(Integer [][] state){
		for(int row = 0; row < state.length; row ++){
			for(int column = 0; column < state[row].length; column++){
				if(state[row][column] == null){
					return new Coordinate(row+1, column+1);
				}
			}
		}
		return null;
	}
	
}
