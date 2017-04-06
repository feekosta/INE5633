package ine5633.eightpuzzlesolver.model;

/**
 * This class stores the X and Y positions that will be used to pick up the position on a board
 * <br>@author feekosta
 */
public class Coordinate {

	public static final Integer MAX = 3;
	public static final Integer MIN = 1;
	
	private Integer x;
	private Integer y;
	
	public Coordinate(Integer x, Integer y) {
		this.setX(x);
		this.setY(y);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	/**
	 * This method checks whether this instance respects the minimum and maximum limits of the position
	 * @return True if valid and False if invalid
	 */

	public Boolean isValid() {
		if(getX() > MAX || getX() < MIN){
			return false;
		}
		if(getY() > MAX || getY() < MIN){
			return false;
		}
		return true;
	}

	/**
	 * This method concatenates the X position with the Y position. Example X = 2 and Y = 3, Output 23
	 * @return XY concatenates
	 */
	public Integer getXYConcat(){
		String xy = String.valueOf(getX()).concat(String.valueOf(getY()));
		return Integer.valueOf(xy);
	}
	
}
