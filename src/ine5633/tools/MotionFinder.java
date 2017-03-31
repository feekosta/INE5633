package ine5633.tools;

import java.util.ArrayList;
import java.util.List;

import ine5633.Coordinate;

/**
 * Classe usada para descobrir os movimentos possiveis no tabuleiro
 * @author feekosta
 */
public class MotionFinder {

	public static List<Coordinate> find(Coordinate coordinate){
		List<Coordinate> coordinates = build(coordinate);
		return filter(coordinates);
	}

	private static List<Coordinate> build(Coordinate coordinate) {
		List<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(new Coordinate(coordinate.getX()-1, coordinate.getY()));
		coordinates.add(new Coordinate(coordinate.getX(), coordinate.getY()-1));
		coordinates.add(new Coordinate(coordinate.getX()+1, coordinate.getY()));
		coordinates.add(new Coordinate(coordinate.getX(), coordinate.getY()+1));
		return coordinates;
	}
	
	private static List<Coordinate> filter(List<Coordinate> coordinatesToFilter) {
		List<Coordinate> coordinates = new ArrayList<>();
		for (Coordinate coordinate : coordinatesToFilter) {
			if(coordinate.isValid()){
				coordinates.add(coordinate);
			}
		}
		return coordinates;
	}
	
	public static void main(String[] args) {
		
		new MotionFinder();
		List<Coordinate> find = MotionFinder.find(new Coordinate(2, 2));
		System.out.println(find.toString());
	}
	
}
