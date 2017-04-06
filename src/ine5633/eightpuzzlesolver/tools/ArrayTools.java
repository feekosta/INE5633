package ine5633.eightpuzzlesolver.tools;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Coordinate;
import ine5633.eightpuzzlesolver.model.Node;

/**
 * Class has methods useful for two-dimensional arrays
 * <br>Test class: {@link ArrayCopyTest}
 * <br>@author feekosta
 */
public class ArrayTools {
	
	public ArrayTools() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Integer[][] deepCopy(Integer[][] original) {
	    final Integer[][] result = new Integer[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}
	
	public static Boolean print(Node node){
		if(node.getFather() != null){
			print(node.getFather());
		}
		System.out.println("\n"+print(node.getState(), "\n|"));
		return true;
	}

	public static String print(Integer[][] state, String delimiter) {
		String response = "";
		for(int row = 0; row < Coordinate.MAX; row++){
			response = response.concat(delimiter);
			for(int column = 0; column < Coordinate.MAX; column++){
				Integer value = state[row][column];
				response = response.concat(value != null ? String.valueOf(value) : " ").concat("|");
			}
			
		}
		return response;
	}
	
	public static void sort(List<Node> frontier){
		frontier.sort(Comparator.comparing(Node::getScoreWithLevel));
	}

}
