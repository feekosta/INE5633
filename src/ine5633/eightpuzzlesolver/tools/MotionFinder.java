package ine5633.eightpuzzlesolver.tools;

import java.util.ArrayList;
import java.util.List;

import ine5633.eightpuzzlesolver.model.Coordinate;

/**
 * Class used to discover possible moves on the board
 * <br>Test class: {@link MotionFinderTest}
 * <br>@author feekosta
 */
public class MotionFinder {

	public MotionFinder() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static List<Coordinate> find(Coordinate coordinate){
		return filter(build(coordinate));
	}

	/**
	 * Produces all possible coordinates for an empty position
	 * @param coordinate
	 * @return
	 */
	private static List<Coordinate> build(Coordinate coordinate) {
		List<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(new Coordinate(coordinate.getX()-1, coordinate.getY()));
		coordinates.add(new Coordinate(coordinate.getX(), coordinate.getY()-1));
		coordinates.add(new Coordinate(coordinate.getX()+1, coordinate.getY()));
		coordinates.add(new Coordinate(coordinate.getX(), coordinate.getY()+1));
		return coordinates;
	}
	
	/**
	 * Return valid coordinates
	 * @param coordinatesToFilter
	 * @return
	 */
	private static List<Coordinate> filter(List<Coordinate> coordinatesToFilter) {
		List<Coordinate> coordinates = new ArrayList<>();
		for (Coordinate coordinate : coordinatesToFilter) {
			if(coordinate.isValid()){
				coordinates.add(coordinate);
			}
		}
		return coordinates;
	}
	
}
